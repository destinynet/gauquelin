/**
 * @author smallufo
 * Created on 2009/3/25 at 上午 2:14:01
 */
package destiny.data.gauquelin

import destiny.astrology.IHoro
import destiny.astrology.Planets
import destiny.astrology.Utils
import java.io.Serializable

class UtilHoroscopeAnglePower(h: IHoro) : Serializable {
  val anglePower: GPersonAnglePower

  init {
    anglePower = GPersonAnglePower()

    val degEast = h.getCuspDegree(1)
    val degTop = h.getCuspDegree(10)
    val degWest = h.getCuspDegree(7)
    val degBottom = h.getCuspDegree(4)
    for (planet in Planets.array) {
      //與四個頂點，哪個點最近
      var nearestAngle: String? = null
      var tempError = 360.0

      val positionWithAzimuth = h.getPosition(planet)!!

      val planetDeg = positionWithAzimuth.lng
      // ========================= 方向 ===========================
      if (IHoro.getAngle(planetDeg, degEast) < tempError) {
        tempError = IHoro.getAngle(planetDeg, degEast)
        nearestAngle = "east"
      }
      if (IHoro.getAngle(planetDeg, degTop) < tempError) {
        tempError = IHoro.getAngle(planetDeg, degTop)
        nearestAngle = "top"
      }

      if (IHoro.getAngle(planetDeg, degWest) < tempError) {
        tempError = IHoro.getAngle(planetDeg, degWest)
        nearestAngle = "west"
      }
      if (IHoro.getAngle(planetDeg, degBottom) < tempError) {
        tempError = IHoro.getAngle(planetDeg, degBottom)
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
    val center = Utils.getNormalizeDegree(IHoro.getAngle(smaller, larger) / 2 + smaller)
    // 離中心點幾度
    val distance = IHoro.getAngle(center, degree)
    // 再算影響範圍的半徑 ( smaller 到 larger 除以 2)
    val radius = IHoro.getAngle(smaller, larger) / 2

    return when {
      IHoro.isOccidental(degree, larger) -> {
        //比「大」更大
        val half = IHoro.getAngle(occidentalCusp, cuspDeg)
        -(distance - radius) / (half - radius)
      }
      IHoro.isOriental(degree, smaller) -> {
        //比「小」更小
        val half = IHoro.getAngle(orientalCusp, cuspDeg) / 2
        -(distance - radius) / (half - radius)
      }
      else -> // 在範圍內
        1 - distance / radius
    }
  }


}
