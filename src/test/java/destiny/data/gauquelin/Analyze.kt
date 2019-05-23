/**
 * Created by smallufo on 2019-05-11.
 */
package destiny.data.gauquelin

import destiny.DestinyCoreContext
import destiny.astrology.*
import destiny.data.gauquelin.AbsMentalReader.Companion.halp
import destiny.data.gauquelin.AbsMentalReader.Companion.md
import destiny.data.gauquelin.AbsMentalReader.Companion.mdp
import destiny.data.gauquelin.AbsMentalReader.Companion.sch
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import kotlin.test.BeforeTest
import kotlin.test.Test

@RunWith(SpringRunner::class)
@ContextConfiguration(locations = ["classpath:core.xml"])
class Analyze : DestinyCoreContext() {


  lateinit var horoCtx: IHoroscopeContext

  private val points = setOf(*Planet.array , *Rsmi.array)

  @BeforeTest
  fun init() {
    horoCtx = horoContext {
      //points(points)
    }
  }

  @Test
  fun runMental() {
    AbsMentalReader.acd.plus(halp).plus(md).plus(mdp).plus(sch).also { list ->
      getRate(list).also { (total, matched) ->
        logger.info("mental : {} / {} = {}", matched, total, matched / total.toDouble())
      }
    }
  }

  @Test
  fun runAll() {

    getRate(AbsProfReader.journalists).also { (total, matched) ->
      logger.info("journalists : {} / {} = {}", matched, total, matched / total.toDouble())
    }
    getRate(AbsProfReader.military).also { (total, matched) ->
      logger.info("military : {} / {} = {}", matched, total, matched / total.toDouble())
    }
    getRate(AbsProfReader.musicians).also { (total, matched) ->
      logger.info("musicians : {} / {} = {}", matched, total, matched / total.toDouble())
    }
    getRate(AbsProfReader.painters).also { (total, matched) ->
      logger.info("painters : {} / {} = {}", matched, total, matched / total.toDouble())
    }
    getRate(AbsProfReader.politicians).also { (total, matched) ->
      logger.info("politicians : {} / {} = {}", matched, total, matched / total.toDouble())
    }
    getRate(AbsProfReader.scientists).also { (total, matched) ->
      logger.info("scientists : {} / {} = {}", matched, total, matched / total.toDouble())
    }
    getRate(AbsProfReader.sports).also { (total, matched) ->
      logger.info("sports : {} / {} = {}", matched, total, matched / total.toDouble())
    }
    getRate(AbsProfReader.writers).also { (total, matched) ->
      logger.info("writers : {} / {} = {}", matched, total, matched / total.toDouble())
    }


  }

  private fun getRate(persons: List<GPerson2>): Pair<Int, Int> {
    var total = 0
    var matched = 0

    val patternContext = PatternContext(AspectEffectiveModern(), HoroscopeAspectsCalculatorModern())

    persons.map { p ->

      val horoModel: IHoroscopeModel = horoCtx.getHoroscope(p.lmt, p.loc, p.place , points)
      val starPosMap: Map<Point, IPos> = horoModel.positionMap
      val cuspDegreeMap: Map<Int, Double> = horoModel.cuspDegreeMap

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
        logger.info("\t{} , 分數 : {}", pattern.notes , pattern.score)
      }
      matched++
    }

    return total to matched
  }


}