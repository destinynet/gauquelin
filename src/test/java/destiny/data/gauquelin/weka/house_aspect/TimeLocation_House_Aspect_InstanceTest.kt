/**
 * Created by smallufo at 2009/3/19 下午 9:35:58
 */
package destiny.data.gauquelin.weka.house_aspect

import destiny.core.calendar.Location
import destiny.data.gauquelin.AbstractGauquelinTest
import java.time.LocalDateTime
import java.util.*
import kotlin.test.Test

class TimeLocation_House_Aspect_InstanceTest : AbstractGauquelinTest() {


  @Test
  fun testGetInstance() {

    val horoContext = horoContext {  }

    for (i in 1..1) {
      val tli = TimeLocation_House_Aspect_Instance(horoContext, LocalDateTime.of(2000, 9, i, 0, 0, 0),
                                                   Location.of(Locale.TAIWAN))
      val instance = tli.instance
      println(instance)

      val c = WekaWrapper()
      val fDistribution = c.distributionForInstance(instance)
      for (d in fDistribution)
        print("d = $d \t")
      println()

    }
  }

}
