/**
 * @author smallufo
 * Created on 2009/3/25 at 上午 2:14:01
 */
package destiny.data.gauquelin

import destiny.core.astrology.IHoroscopeModel
import destiny.core.astrology.Planet
import destiny.core.astrology.ZodiacDegree
import destiny.tools.CircleTools
import destiny.tools.CircleTools.normalize
import java.io.Serializable

class UtilHoroscopeAnglePower(h: IHoroscopeModel) : Serializable {
  val anglePower: GPersonAnglePower

  init {
    anglePower = GPersonAnglePower()

    val degEast = h.getCuspDegree(1)
    val degTop = h.getCuspDegree(10)
    val degWest = h.getCuspDegree(7)
    val degBottom = h.getCuspDegree(4)
    for (planet in Planet.array) {
      //與四個頂點，哪個點最近
      var nearestAngle: String? = null
      var tempError = 360.0

      val positionWithAzimuth = h.getPosition(planet)!!

      val planetDeg = positionWithAzimuth.lng
      // ========================= 方向 ===========================
      if (IHoroscopeModel.getAngle(planetDeg, degEast) < tempError) {
        tempError = IHoroscopeModel.getAngle(planetDeg, degEast)
        nearestAngle = "east"
      }
      if (IHoroscopeModel.getAngle(planetDeg, degTop) < tempError) {
        tempError = IHoroscopeModel.getAngle(planetDeg, degTop)
        nearestAngle = "top"
      }

      if (IHoroscopeModel.getAngle(planetDeg, degWest) < tempError) {
        tempError = IHoroscopeModel.getAngle(planetDeg, degWest)
        nearestAngle = "west"
      }
      if (IHoroscopeModel.getAngle(planetDeg, degBottom) < tempError) {
        tempError = IHoroscopeModel.getAngle(planetDeg, degBottom)
        nearestAngle = "bottom"
      }

      // =================== 力量 ======================
      var smaller = 0.0
      var larger = 0.0
      var orientalCusp = 0.0
      var occidentalCusp = 0.0
      var cuspDeg = 0.0
      var power: Double
      assert(nearestAngle != null)
      when (nearestAngle) {
        "east" -> {
          larger = CircleTools.getNormalizeDegree(degEast + 10)
          smaller = CircleTools.getNormalizeDegree(degEast - 20)
          cuspDeg = degEast
          orientalCusp = degTop
          occidentalCusp = degBottom
        }
        "top" -> {
          larger = CircleTools.getNormalizeDegree(degTop + 10)
          smaller = CircleTools.getNormalizeDegree(degTop - 20)
          cuspDeg = degTop
          orientalCusp = degWest
          occidentalCusp = degEast
        }
        "west" -> {
          larger = CircleTools.getNormalizeDegree(degWest)
          smaller = CircleTools.getNormalizeDegree(degWest - 20)
          cuspDeg = degWest
          orientalCusp = degBottom
          occidentalCusp = degTop
        }
        "bottom" -> {
          larger = CircleTools.getNormalizeDegree(degBottom)
          smaller = CircleTools.getNormalizeDegree(degBottom - 20)
          cuspDeg = degBottom
          orientalCusp = degEast
          occidentalCusp = degWest
        }
      }
      power = getPower(
        ZodiacDegree(orientalCusp),
        ZodiacDegree(smaller),
        ZodiacDegree(cuspDeg),
        ZodiacDegree(larger),
        ZodiacDegree(occidentalCusp),
        ZodiacDegree(planetDeg)
      )

      anglePower.setValue(planet, nearestAngle, power)
    }
  }

  private fun getPower(
    orientalCusp: ZodiacDegree,
    smaller: ZodiacDegree,
    cuspDeg: ZodiacDegree,
    larger: ZodiacDegree,
    occidentalCusp: ZodiacDegree,
    degree: ZodiacDegree
  ): Double {
    // 先求出中心度數（最強點)
    val center = ZodiacDegree((smaller.getAngle(larger) / 2 + smaller.value).normalize())
    // 離中心點幾度
    val distance = center.getAngle(degree)
    //val distance = IHoroscopeModel.getAngle(center, degree)
    // 再算影響範圍的半徑 ( smaller 到 larger 除以 2)
    val radius = smaller.getAngle(larger) / 2

    return when {
      degree.isOccidental(larger) -> {
        //比「大」更大
        val half = occidentalCusp.getAngle(cuspDeg)
        -(distance - radius) / (half - radius)
      }
      degree.isOriental(smaller)  -> {
        //比「小」更小
        val half = orientalCusp.getAngle(cuspDeg) / 2
        -(distance - radius) / (half - radius)
      }
      else                        -> // 在範圍內
        1 - distance / radius
    }
  }


}
