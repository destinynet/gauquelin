/**
 * Created by smallufo on 2019-05-11.
 */
package destiny.data.gauquelin

import destiny.DestinyCoreContext
import destiny.astrology.*
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import javax.inject.Inject
import kotlin.test.BeforeTest
import kotlin.test.Test

@RunWith(SpringRunner::class)
@ContextConfiguration(locations = ["classpath:core.xml"])
class Analyze : DestinyCoreContext() {

  private val classicalList = Planet.classicalList

  lateinit var horoCtx: IHoroscopeContext

  @BeforeTest
  fun init() {
    horoCtx = horoContext()
  }

  @Test
  fun runAll() {

    getRate(AbsProfReader.journalists).also { (total , matched) ->
      logger.info("journalists : {} / {} = {}" , matched , total , matched/total.toDouble())
    }
    getRate(AbsProfReader.military).also { (total , matched) ->
      logger.info("military : {} / {} = {}" , matched , total , matched/total.toDouble())
    }
    getRate(AbsProfReader.musicians).also { (total , matched) ->
      logger.info("musicians : {} / {} = {}" , matched , total , matched/total.toDouble())
    }
    getRate(AbsProfReader.painters).also { (total , matched) ->
      logger.info("painters : {} / {} = {}" , matched , total , matched/total.toDouble())
    }
    getRate(AbsProfReader.politicians).also { (total , matched) ->
      logger.info("politicians : {} / {} = {}" , matched , total , matched/total.toDouble())
    }
    getRate(AbsProfReader.scientists).also { (total , matched) ->
      logger.info("scientists : {} / {} = {}" , matched , total , matched/total.toDouble())
    }
    getRate(AbsProfReader.sports).also { (total , matched) ->
      logger.info("sports : {} / {} = {}" , matched , total , matched/total.toDouble())
    }
    getRate(AbsProfReader.writers).also { (total , matched) ->
      logger.info("writers : {} / {} = {}" , matched , total , matched/total.toDouble())
    }

  }

  private fun getRate(persons : List<GPerson2>): Pair<Int, Int> {
    var total = 0
    var matched = 0
    persons.map {p ->

      val horoModel: IHoroscopeModel = horoCtx.getHoroscope(p.lmt, p.loc, p.place, classicalList)
      val starPosMap: Map<Point, IPos> = horoModel.positionMap

      total++
      p to AstroPatterns.TSquared.getPattern(starPosMap)
      //p to AstroPatterns.TSquareWithHelp.getPattern(starPosMap)
    }.filter {
      it.second.isNotEmpty()
    }.forEachIndexed { index, pair  ->
      val (p , patterns) = pair
      logger.trace("[{} {}] \t {}", index , p.name , p.raw)
      logger.trace("lmt = {} , loc = {} ", p.lmt, p.loc)
      patterns.forEach { pattern ->
        logger.trace("\t{}" , pattern)
      }
      matched++
    }

    return total to matched
  }


}