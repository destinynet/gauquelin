/**
 * @author smallufo
 * Created on 2009/3/25 at 上午 2:39:47
 */
package destiny.data.gauquelin.weka.anglePower_aspect

import destiny.astrology.IStarPositionWithAzimuth
import destiny.astrology.swissephImpl.AzimuthImpl
import destiny.astrology.swissephImpl.HouseCuspImpl
import destiny.astrology.swissephImpl.StarPositionWithAzimuthImpl
import destiny.core.calendar.Location
import org.junit.Before
import java.time.LocalDateTime
import java.util.*
import kotlin.test.Test

class TimeLocation_AnglePower_InstanceTest {

  private val azimuthImpl = AzimuthImpl()

  private val houseCuspImpl = HouseCuspImpl()

  private var starPositionWithAzimuthImpl: IStarPositionWithAzimuth? = null

  @Before
  fun init() {
    starPositionWithAzimuthImpl = StarPositionWithAzimuthImpl(azimuthImpl)
  }


  @Test
  fun testGetInstance() {
    for (i in 1..30) {
      val tli = TimeLocation_AnglePower_Instance(
        LocalDateTime.of(1900, 7, i, i, 0, 0),
        Location.of(Locale.TAIWAN), starPositionWithAzimuthImpl!!, houseCuspImpl)
      val instance = tli.instance
      //System.out.println(instance);

      val c = WekaWrapper()
      val fDistribution = c.distributionForInstance(instance)
      for (d in fDistribution)
        print("d = $d \t")
      println()
    }
  }
}
