/**
 * @author smallufo
 * Created on 2009/3/25 at 上午 2:14:01
 */
package destiny.data.gauquelin

import destiny.astrology.Horoscope
import destiny.astrology.Planet
import destiny.astrology.Utils
import java.io.Serializable

class UtilHoroscopeAnglePower(h: Horoscope) : Serializable {
  val anglePower: GPersonAnglePower

  init {
    anglePower = GPersonAnglePower()

    val degEast = h.getCuspDegree(1)
    val degTop = h.getCuspDegree(10)
    val degWest = h.getCuspDegree(7)
    val degBottom = h.getCuspDegree(4)
    for (planet in Planet.values) {
      //與四個頂點，哪個點最近
      var nearestAngle: String? = null
      var tempError = 360.0

      val positionWithAzimuth = h.getPosition(planet)!!

      val planetDeg = positionWithAzimuth.lng
      // ========================= 方向 ===========================
      if (Horoscope.getAngle(planetDeg, degEast) < tempError) {
        tempError = Horoscope.getAngle(planetDeg, degEast)
        nearestAngle = "east"
      }
      if (Horoscope.getAngle(planetDeg, degTop) < tempError) {
        tempError = Horoscope.getAngle(planetDeg, degTop)
        nearestAngle = "top"
      }

      if (Horoscope.getAngle(planetDeg, degWest) < tempError) {
        tempError = Horoscope.getAngle(planetDeg, degWest)
        nearestAngle = "west"
      }
      if (Horoscope.getAngle(planetDeg, degBottom) < tempError) {
        tempError = Horoscope.getAngle(planetDeg, degBottom)
        nearestAngle = "bottom"
      }

      // =================== 力量 ======================
      var smaller = 0.0
      var larger = 0.0
      var orientalCusp = 0.0
      var occidentalCusp = 0.0
      var cuspDeg = 0.0
      var power = 0.0
      assert(nearestAngle != null)
      if (nearestAngle == "east") {
        larger = Utils.getNormalizeDegree(degEast + 10)
        smaller = Utils.getNormalizeDegree(degEast - 20)
        cuspDeg = degEast
        orientalCusp = degTop
        occidentalCusp = degBottom
      } else if (nearestAngle == "top") {
        larger = Utils.getNormalizeDegree(degTop + 10)
        smaller = Utils.getNormalizeDegree(degTop - 20)
        cuspDeg = degTop
        orientalCusp = degWest
        occidentalCusp = degEast
      } else if (nearestAngle == "west") {
        larger = Utils.getNormalizeDegree(degWest)
        smaller = Utils.getNormalizeDegree(degWest - 20)
        cuspDeg = degWest
        orientalCusp = degBottom
        occidentalCusp = degTop
      } else if (nearestAngle == "bottom") {
        larger = Utils.getNormalizeDegree(degBottom)
        smaller = Utils.getNormalizeDegree(degBottom - 20)
        cuspDeg = degBottom
        orientalCusp = degEast
        occidentalCusp = degWest
      }
      power = getPower(orientalCusp, smaller, cuspDeg, larger, occidentalCusp, planetDeg)

      anglePower.setValue(planet, nearestAngle, power)
    }
  }

  private fun getPower(orientalCusp: Double, smaller: Double, cuspDeg: Double, larger: Double, occidentalCusp: Double, degree: Double): Double {
    // 先求出中心度數（最強點)
    val center = Utils.getNormalizeDegree(Horoscope.getAngle(smaller, larger) / 2 + smaller)
    // 離中心點幾度
    val distance = Horoscope.getAngle(center, degree)
    // 再算影響範圍的半徑 ( smaller 到 larger 除以 2)
    val radius = Horoscope.getAngle(smaller, larger) / 2

    if (Horoscope.isOccidental(degree, larger)) {
      //比「大」更大
      val half = Horoscope.getAngle(occidentalCusp, cuspDeg)
      return -(distance - radius) / (half - radius)
    } else if (Horoscope.isOriental(degree, smaller)) {
      //比「小」更小
      val half = Horoscope.getAngle(orientalCusp, cuspDeg) / 2
      return -(distance - radius) / (half - radius)
    } else {
      // 在範圍內
      return 1 - distance / radius
    }
  }


}
