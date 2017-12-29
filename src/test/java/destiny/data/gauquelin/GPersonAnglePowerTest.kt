/**
 * @author smallufo
 * Created on 2009/3/21 at 上午 1:04:35
 */
package destiny.data.gauquelin

import destiny.astrology.Planet
import org.junit.Test

class GPersonAnglePowerTest {

  @Test
  fun testSetValue() {
    val g = GPersonAnglePower()
    println(g.sun + " : " + g.sunPower)
    g.setValue(Planet.SUN, "north", 0.99)
    println(g.sun + " : " + g.sunPower)
  }
}
