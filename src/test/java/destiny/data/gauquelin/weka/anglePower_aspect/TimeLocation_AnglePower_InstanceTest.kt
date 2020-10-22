/**
 * @author smallufo
 * Created on 2009/3/25 at 上午 2:39:47
 */
package destiny.data.gauquelin.weka.anglePower_aspect

import destiny.astrology.AspectsCalculatorImplBuilder.Companion.aspectsCalculatorImpl
import destiny.astrology.horoContext
import destiny.core.calendar.locationOf
import destiny.data.gauquelin.AbstractGauquelinTest
import java.time.LocalDateTime
import java.util.*
import kotlin.test.Test

class TimeLocation_AnglePower_InstanceTest : AbstractGauquelinTest() {

  @Test
  fun testGetInstance() {
    val horoContext = horoContext { }
    for (i in 1..30) {
      try {
        val tli = TimeLocation_AnglePower_Instance(horoContext,
          LocalDateTime.of(1900, 7, i, i, 0, 0),
          locationOf(Locale.TAIWAN) ,
          aspectsCalculatorImpl { modern {} })
        val instance = tli.instance
        //System.out.println(instance);

        val c = WekaWrapper()
        val fDistribution = c.distributionForInstance(instance)
        for (d in fDistribution)
          print("d = $d \t")
        println()
      } catch (ignored : Exception) {
        logger.warn("{}" , ignored)
      }

    }
  }
}
