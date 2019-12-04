/**
 * @author smallufo
 * Created on 2009/3/20 at 上午 4:47:05
 */
package destiny.data.gauquelin

import destiny.astrology.Planet
import destiny.astrology.toString
import java.io.Serializable
import java.util.*
import javax.persistence.*

/** 計算星體在四個角點的力量  */
@Entity
@Table(name = "anglePower")
@Cacheable
class GPersonAnglePower : Serializable {
  @Id
  @Column(name = "personId")
  var personId: Long = 0
  @OneToOne
  @PrimaryKeyJoinColumn
  var gperson: GPerson? = null
  var sun: String? = null
  var sunPower = 0.0
  var moon: String? = null
  var moonPower = 0.0
  var mercury: String? = null
  var mercuryPower = 0.0
  var venus: String? = null
  var venusPower = 0.0
  var mars: String? = null
  var marsPower = 0.0
  var jupiter: String? = null
  var jupiterPower = 0.0
  var saturn: String? = null
  var saturnPower = 0.0
  var uranus: String? = null
  var uranusPower = 0.0
  var neptune: String? = null
  var neptunePower = 0.0
  var pluto: String? = null
  var plutoPower = 0.0
  fun setValue(planet: Planet, direction: String?, power: Double) {
    val r = RefUtil(this)
    r.setValue(planet.toString(Locale.ENGLISH), direction)
    r.setValue(planet.toString(Locale.ENGLISH) + "Power", power)
  }

  override fun toString(): String {
    val sb = StringBuffer()
    val r = RefUtil(this)
    for (prop in RefUtil.getProperties(javaClass)) {
      sb.append(prop)
      sb.append(":")
      sb.append(r.getValue(prop))
      sb.append("\n ")
    }
    return sb.toString()
  }

}
