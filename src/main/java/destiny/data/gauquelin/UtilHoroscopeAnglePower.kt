/**
 * @author smallufo
 * Created on 2009/3/25 at 上午 2:14:01
 */
package destiny.data.gauquelin

import destiny.core.astrology.IHoroscopeModel
import destiny.core.astrology.Planet
import destiny.core.astrology.ZodiacDegree
import destiny.core.astrology.ZodiacDegree.Companion.toZodiacDegree
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

      val planetDeg = positionWithAzimuth.lngDeg
      // ========================= 方向 ===========================
      if (planetDeg.getAngle(degEast) < tempError) {
        tempError = planetDeg.getAngle(degEast)
        nearestAngle = "east"
      }
      if (planetDeg.getAngle(degTop) < tempError) {
        tempError = planetDeg.getAngle(degTop)
        nearestAngle = "top"
      }

      if (planetDeg.getAngle(degWest) < tempError) {
        tempError = planetDeg.getAngle(degWest)
        nearestAngle = "west"
      }
      if (planetDeg.getAngle(degBottom) < tempError) {
        tempError = planetDeg.getAngle(degBottom)
        nearestAngle = "bottom"
      }

      // =================== 力量 ======================
      var smaller = 0.0.toZodiacDegree()
      var larger = 0.0.toZodiacDegree()
      var orientalCusp = 0.0.toZodiacDegree()
      var occidentalCusp = 0.0.toZodiacDegree()
      var cuspDeg = 0.0.toZodiacDegree()
      var power: Double
      assert(nearestAngle != null)
      when (nearestAngle) {
        "east" -> {
          larger = degEast + 10
          smaller = degEast - 20
          cuspDeg = degEast
          orientalCusp = degTop
          occidentalCusp = degBottom
        }
        "top" -> {
          larger = degTop + 10
          smaller = degTop - 20
          cuspDeg = degTop
          orientalCusp = degWest
          occidentalCusp = degEast
        }
        "west" -> {
          larger = degWest
          smaller = degWest - 20
          cuspDeg = degWest
          orientalCusp = degBottom
          occidentalCusp = degTop
        }
        "bottom" -> {
          larger = degBottom
          smaller = degBottom - 20
          cuspDeg = degBottom
          orientalCusp = degEast
          occidentalCusp = degWest
        }
      }
      power = getPower(
        orientalCusp,
        smaller,
        cuspDeg,
        larger,
        occidentalCusp,
        planetDeg
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
    val center = (smaller.getAngle(larger) / 2 + smaller.value).toZodiacDegree()
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
