/**
 * Created by smallufo on 2019-05-11.
 */
package destiny.data.gauquelin

import destiny.core.DestinyCoreContext
import destiny.core.astrology.*
import destiny.core.astrology.AspectsCalculatorImplBuilder.Companion.aspectsCalculatorImpl
import destiny.core.astrology.HoroscopeConfigBuilder.Companion.horoscope
import destiny.core.calendar.TimeTools
import destiny.data.gauquelin.AbsMentalReader.Companion.halp
import destiny.data.gauquelin.AbsMentalReader.Companion.md
import destiny.data.gauquelin.AbsMentalReader.Companion.mdp
import destiny.data.gauquelin.AbsMentalReader.Companion.sch
import destiny.data.gauquelin.AbsProfReader.Companion.military
import destiny.data.gauquelin.AbsProfReader.Companion.musicians
import destiny.data.gauquelin.AbsProfReader.Companion.painters
import destiny.data.gauquelin.AbsProfReader.Companion.politicians
import destiny.data.gauquelin.AbsProfReader.Companion.scientists
import destiny.data.gauquelin.AbsProfReader.Companion.sports
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*
import kotlin.test.Test

@ExtendWith(SpringExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ContextConfiguration(locations = ["classpath:core.xml"])
class Analyze : DestinyCoreContext() {

  private val allMental = AbsMentalReader.acd.plus(halp).plus(md).plus(mdp).plus(sch)
  private val allProfs = AbsProfReader.journalists.asSequence().plus(military).plus(musicians).plus(painters).plus(politicians).plus(scientists).plus(sports).toList()

  private val pointsToShow = setOf(*Planet.values, *Axis.array)

  private val aspectsCalculator = aspectsCalculatorImpl { modern {} }

  //private val horoAspectsCalculator = HoroscopeAspectsCalculator(aspectsCalculator)


  @Test
  fun runMental() {
    allMental.also { list ->
      getRate(list).also { (total, matched) ->
        logger.info("mental : {} / {} = {}", matched, total, matched / total.toDouble())
      }
    }
  }

  @Test
  fun runAll() {

//    getRate(AbsProfReader.journalists).also { (total, matched) ->
//      logger.info("journalists : {} / {} = {}", matched, total, matched / total.toDouble())
//    }
//    getRate(AbsProfReader.military).also { (total, matched) ->
//      logger.info("military : {} / {} = {}", matched, total, matched / total.toDouble())
//    }
//    getRate(AbsProfReader.musicians).also { (total, matched) ->
//      logger.info("musicians : {} / {} = {}", matched, total, matched / total.toDouble())
//    }
//    getRate(AbsProfReader.painters).also { (total, matched) ->
//      logger.info("painters : {} / {} = {}", matched, total, matched / total.toDouble())
//    }
//    getRate(AbsProfReader.politicians).also { (total, matched) ->
//      logger.info("politicians : {} / {} = {}", matched, total, matched / total.toDouble())
//    }
//    getRate(AbsProfReader.scientists).also { (total, matched) ->
//      logger.info("scientists : {} / {} = {}", matched, total, matched / total.toDouble())
//    }
//    getRate(AbsProfReader.sports).also { (total, matched) ->
//      logger.info("sports : {} / {} = {}", matched, total, matched / total.toDouble())
//    }
    getRate(AbsProfReader.writers).also { (total, matched) ->
      logger.info("writers : {} / {} = {}", matched, total, matched / total.toDouble())
    }
  }

  private fun getRate(persons: List<GPerson2>): Pair<Int, Int> {
    var total = 0
    var matched = 0

    val patternContext = PatternContext(AspectEffectiveModern(), aspectsCalculator)

    persons.map { p ->
      val gmtJulDay = TimeTools.getGmtJulDay(p.lmt, p.loc)
      val horoModel: IHoroscopeModel = horoscopeFeature.getModel(gmtJulDay, p.loc, horoscope { points = pointsToShow})
      val starPosMap: Map<AstroPoint, IPos> = horoModel.positionMap
      val cuspDegreeMap: Map<Int, ZodiacDegree> = horoModel.cuspDegreeMap

      total++

      logger.trace("raw = {}" , p.raw)
      p to patternContext.tSquared.getPatterns(starPosMap , cuspDegreeMap)
    }.filter {
      it.second.isNotEmpty()
    }.forEachIndexed { index, pair ->
      val (p, patterns) = pair
      logger.info("[{} {}] \t {}", index, p.name, p.raw)
      logger.trace("lmt = {} , loc = {} ", p.lmt, p.loc)
      patterns.forEach { pattern ->
        logger.info("\t{} , 分數 : {}", pattern.getNotes(Locale.TAIWAN), pattern.score)
      }
      matched++
    }

    return total to matched
  }




  /**
   * 計算心智問題 vs 頂尖職業
   */
  @Test
  fun testComparison() {
    calculateList(allMental)
    calculateList(scientists)
  }



  private fun calculateList(persons : List<GPerson2>) {
    var total = 0
    var matched = 0

    val patternContext = PatternContext(AspectEffectiveModern(), aspectsCalculator)

    val effectiveMap = persons.map { p ->
      val gmtJulDay = TimeTools.getGmtJulDay(p.lmt, p.loc)

      val horoModel: IHoroscopeModel = horoscopeFeature.getModel(gmtJulDay, p.loc, horoscope { points = pointsToShow})
      val starPosMap: Map<AstroPoint, IPos> = horoModel.positionMap
      val cuspDegreeMap: Map<Int, ZodiacDegree> = horoModel.cuspDegreeMap

      total++

      logger.trace("raw = {}" , p.raw)
      aspectsCalculator.getPointAspectAndScore(Axis.RISING , starPosMap  ,
        points = setOf(Planet.JUPITER),
//        points = setOf(*Axis.array , *Planet.array),
        aspects = setOf(Aspect.TRINE , Aspect.SEXTILE))
        .filter { (_ , _ , score) -> score > 0.8 }
    }.filter { it.isNotEmpty() }

    logger.info("total = {} , effective = {} , ratio = {}" , total , effectiveMap.size , (effectiveMap.size / total.toDouble()) )

  }
}
