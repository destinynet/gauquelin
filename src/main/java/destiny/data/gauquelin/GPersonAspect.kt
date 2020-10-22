/**
 * Created by smallufo at 2009/3/13 下午 6:07:29
 */
package destiny.data.gauquelin

import destiny.astrology.AspectData
import destiny.astrology.Planet
import destiny.astrology.toString
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "aspect")
@Cacheable
/** 一個命盤的任兩顆星呈現什麼交角  */
class GPersonAspect : Serializable {
  @Id
  @Column(name = "personId")
  var personId: Long = 0

  @OneToOne
  @PrimaryKeyJoinColumn
  var gperson: GPerson? = null

  var sunMoon: String? = null
  var sunMercury: String? = null
  var sunVenus: String? = null
  var sunMars: String? = null
  var sunJupiter: String? = null
  var sunSaturn: String? = null
  var sunUranus: String? = null
  var sunNeptune: String? = null
  var sunPluto: String? = null
  var moonMercury: String? = null
  var moonVenus: String? = null
  var moonMars: String? = null
  var moonJupiter: String? = null
  var moonSaturn: String? = null
  var moonUranus: String? = null
  var moonNeptune: String? = null
  var moonPluto: String? = null
  var mercuryVenus: String? = null
  var mercuryMars: String? = null
  var mercuryJupiter: String? = null
  var mercurySaturn: String? = null
  var mercuryUranus: String? = null
  var mercuryNeptune: String? = null
  var mercuryPluto: String? = null
  var venusMars: String? = null
  var venusJupiter: String? = null
  var venusSaturn: String? = null
  var venusUranus: String? = null
  var venusNeptune: String? = null
  var venusPluto: String? = null
  var marsJupiter: String? = null
  var marsSaturn: String? = null
  var marsUranus: String? = null
  var marsNeptune: String? = null
  var marsPluto: String? = null
  var jupiterSaturn: String? = null
  var jupiterUranus: String? = null
  var jupiterNeptune: String? = null
  var jupiterPluto: String? = null
  var saturnUranus: String? = null
  var saturnNeptune: String? = null
  var saturnPluto: String? = null
  var uranusNeptune: String? = null
  var uranusPluto: String? = null
  var neptunePluto: String? = null

  fun setAspect(data: AspectData) {
    val twoPoints = data.points
    val localeString = data.aspect.toString(Locale.ENGLISH)

    if (twoPoints.contains(Planet.SUN) && twoPoints.contains(Planet.MOON))
      sunMoon = localeString
    else if (twoPoints.contains(Planet.SUN) && twoPoints.contains(Planet.MERCURY))
      sunMercury = localeString
    else if (twoPoints.contains(Planet.SUN) && twoPoints.contains(Planet.VENUS))
      sunVenus = localeString
    else if (twoPoints.contains(Planet.SUN) && twoPoints.contains(Planet.MARS))
      sunMars = localeString
    else if (twoPoints.contains(Planet.SUN) && twoPoints.contains(Planet.JUPITER))
      sunJupiter = localeString
    else if (twoPoints.contains(Planet.SUN) && twoPoints.contains(Planet.SATURN))
      sunSaturn = localeString
    else if (twoPoints.contains(Planet.SUN) && twoPoints.contains(Planet.URANUS))
      sunUranus = localeString
    else if (twoPoints.contains(Planet.SUN) && twoPoints.contains(Planet.NEPTUNE))
      sunNeptune = localeString
    else if (twoPoints.contains(Planet.SUN) && twoPoints.contains(Planet.PLUTO))
      sunPluto = localeString
    else if (twoPoints.contains(Planet.MOON) && twoPoints.contains(Planet.MERCURY))
      moonMercury = localeString
    else if (twoPoints.contains(Planet.MOON) && twoPoints.contains(Planet.VENUS))
      moonVenus = localeString
    else if (twoPoints.contains(Planet.MOON) && twoPoints.contains(Planet.MARS))
      moonMars = localeString
    else if (twoPoints.contains(Planet.MOON) && twoPoints.contains(Planet.JUPITER))
      moonJupiter = localeString
    else if (twoPoints.contains(Planet.MOON) && twoPoints.contains(Planet.SATURN))
      moonSaturn = localeString
    else if (twoPoints.contains(Planet.MOON) && twoPoints.contains(Planet.URANUS))
      moonUranus = localeString
    else if (twoPoints.contains(Planet.MOON) && twoPoints.contains(Planet.NEPTUNE))
      moonNeptune = localeString
    else if (twoPoints.contains(Planet.MOON) && twoPoints.contains(Planet.PLUTO))
      moonPluto = localeString
    else if (twoPoints.contains(Planet.MERCURY) && twoPoints.contains(Planet.VENUS))
      mercuryVenus = localeString
    else if (twoPoints.contains(Planet.MERCURY) && twoPoints.contains(Planet.MARS))
      mercuryMars = localeString
    else if (twoPoints.contains(Planet.MERCURY) && twoPoints.contains(Planet.JUPITER))
      mercuryJupiter = localeString
    else if (twoPoints.contains(Planet.MERCURY) && twoPoints.contains(Planet.SATURN))
      mercurySaturn = localeString
    else if (twoPoints.contains(Planet.MERCURY) && twoPoints.contains(Planet.URANUS))
      mercuryUranus = localeString
    else if (twoPoints.contains(Planet.MERCURY) && twoPoints.contains(Planet.NEPTUNE))
      mercuryNeptune = localeString
    else if (twoPoints.contains(Planet.MERCURY) && twoPoints.contains(Planet.PLUTO))
      mercuryPluto = localeString
    else if (twoPoints.contains(Planet.VENUS) && twoPoints.contains(Planet.MARS))
      venusMars = localeString
    else if (twoPoints.contains(Planet.VENUS) && twoPoints.contains(Planet.JUPITER))
      venusJupiter = localeString
    else if (twoPoints.contains(Planet.VENUS) && twoPoints.contains(Planet.SATURN))
      venusSaturn = localeString
    else if (twoPoints.contains(Planet.VENUS) && twoPoints.contains(Planet.URANUS))
      venusUranus = localeString
    else if (twoPoints.contains(Planet.VENUS) && twoPoints.contains(Planet.NEPTUNE))
      venusNeptune = localeString
    else if (twoPoints.contains(Planet.VENUS) && twoPoints.contains(Planet.PLUTO))
      venusPluto = localeString
    else if (twoPoints.contains(Planet.MARS) && twoPoints.contains(Planet.JUPITER))
      marsJupiter = localeString
    else if (twoPoints.contains(Planet.MARS) && twoPoints.contains(Planet.SATURN))
      marsSaturn = localeString
    else if (twoPoints.contains(Planet.MARS) && twoPoints.contains(Planet.URANUS))
      marsUranus = localeString
    else if (twoPoints.contains(Planet.MARS) && twoPoints.contains(Planet.NEPTUNE))
      marsNeptune = localeString
    else if (twoPoints.contains(Planet.MARS) && twoPoints.contains(Planet.PLUTO))
      marsPluto = localeString
    else if (twoPoints.contains(Planet.JUPITER) && twoPoints.contains(Planet.SATURN))
      jupiterSaturn = localeString
    else if (twoPoints.contains(Planet.JUPITER) && twoPoints.contains(Planet.URANUS))
      jupiterUranus = localeString
    else if (twoPoints.contains(Planet.JUPITER) && twoPoints.contains(Planet.NEPTUNE))
      jupiterNeptune = localeString
    else if (twoPoints.contains(Planet.JUPITER) && twoPoints.contains(Planet.PLUTO))
      jupiterPluto = localeString
    else if (twoPoints.contains(Planet.SATURN) && twoPoints.contains(Planet.URANUS))
      saturnUranus = localeString
    else if (twoPoints.contains(Planet.SATURN) && twoPoints.contains(Planet.NEPTUNE))
      saturnNeptune = localeString
    else if (twoPoints.contains(Planet.SATURN) && twoPoints.contains(Planet.PLUTO))
      saturnPluto = localeString
    else if (twoPoints.contains(Planet.URANUS) && twoPoints.contains(Planet.NEPTUNE))
      uranusNeptune = localeString
    else if (twoPoints.contains(Planet.URANUS) && twoPoints.contains(Planet.PLUTO))
      uranusPluto = localeString
    else if (twoPoints.contains(Planet.NEPTUNE) && twoPoints.contains(Planet.PLUTO))
      neptunePluto = localeString


  }

  override fun hashCode(): Int {
    val prime = 31
    var result = 1
    result = prime * result + if (gperson == null) 0 else gperson!!.hashCode()
    result = prime * result + if (jupiterNeptune == null) 0 else jupiterNeptune!!.hashCode()
    result = prime * result + if (jupiterPluto == null) 0 else jupiterPluto!!.hashCode()
    result = prime * result + if (jupiterSaturn == null) 0 else jupiterSaturn!!.hashCode()
    result = prime * result + if (jupiterUranus == null) 0 else jupiterUranus!!.hashCode()
    result = prime * result + if (marsJupiter == null) 0 else marsJupiter!!.hashCode()
    result = prime * result + if (marsNeptune == null) 0 else marsNeptune!!.hashCode()
    result = prime * result + if (marsPluto == null) 0 else marsPluto!!.hashCode()
    result = prime * result + if (marsSaturn == null) 0 else marsSaturn!!.hashCode()
    result = prime * result + if (marsUranus == null) 0 else marsUranus!!.hashCode()
    result = prime * result + if (mercuryJupiter == null) 0 else mercuryJupiter!!.hashCode()
    result = prime * result + if (mercuryMars == null) 0 else mercuryMars!!.hashCode()
    result = prime * result + if (mercuryNeptune == null) 0 else mercuryNeptune!!.hashCode()
    result = prime * result + if (mercuryPluto == null) 0 else mercuryPluto!!.hashCode()
    result = prime * result + if (mercurySaturn == null) 0 else mercurySaturn!!.hashCode()
    result = prime * result + if (mercuryUranus == null) 0 else mercuryUranus!!.hashCode()
    result = prime * result + if (mercuryVenus == null) 0 else mercuryVenus!!.hashCode()
    result = prime * result + if (moonJupiter == null) 0 else moonJupiter!!.hashCode()
    result = prime * result + if (moonMars == null) 0 else moonMars!!.hashCode()
    result = prime * result + if (moonMercury == null) 0 else moonMercury!!.hashCode()
    result = prime * result + if (moonNeptune == null) 0 else moonNeptune!!.hashCode()
    result = prime * result + if (moonPluto == null) 0 else moonPluto!!.hashCode()
    result = prime * result + if (moonSaturn == null) 0 else moonSaturn!!.hashCode()
    result = prime * result + if (moonUranus == null) 0 else moonUranus!!.hashCode()
    result = prime * result + if (moonVenus == null) 0 else moonVenus!!.hashCode()
    result = prime * result + if (neptunePluto == null) 0 else neptunePluto!!.hashCode()
    result = prime * result + if (saturnNeptune == null) 0 else saturnNeptune!!.hashCode()
    result = prime * result + if (saturnPluto == null) 0 else saturnPluto!!.hashCode()
    result = prime * result + if (saturnUranus == null) 0 else saturnUranus!!.hashCode()
    result = prime * result + if (sunJupiter == null) 0 else sunJupiter!!.hashCode()
    result = prime * result + if (sunMars == null) 0 else sunMars!!.hashCode()
    result = prime * result + if (sunMoon == null) 0 else sunMoon!!.hashCode()
    result = prime * result + if (sunNeptune == null) 0 else sunNeptune!!.hashCode()
    result = prime * result + if (sunPluto == null) 0 else sunPluto!!.hashCode()
    result = prime * result + if (sunSaturn == null) 0 else sunSaturn!!.hashCode()
    result = prime * result + if (sunUranus == null) 0 else sunUranus!!.hashCode()
    result = prime * result + if (sunVenus == null) 0 else sunVenus!!.hashCode()
    result = prime * result + if (uranusNeptune == null) 0 else uranusNeptune!!.hashCode()
    result = prime * result + if (uranusPluto == null) 0 else uranusPluto!!.hashCode()
    result = prime * result + if (venusJupiter == null) 0 else venusJupiter!!.hashCode()
    result = prime * result + if (venusMars == null) 0 else venusMars!!.hashCode()
    result = prime * result + if (venusNeptune == null) 0 else venusNeptune!!.hashCode()
    result = prime * result + if (venusPluto == null) 0 else venusPluto!!.hashCode()
    result = prime * result + if (venusSaturn == null) 0 else venusSaturn!!.hashCode()
    result = prime * result + if (venusUranus == null) 0 else venusUranus!!.hashCode()
    return result
  }

  override fun equals(other: Any?): Boolean {
    if (this === other)
      return true
    if (other == null)
      return false
    if (javaClass != other.javaClass)
      return false
    val other = other as GPersonAspect?
    if (gperson == null) {
      if (other!!.gperson != null)
        return false
    } else if (gperson != other!!.gperson)
      return false
    if (jupiterNeptune == null) {
      if (other.jupiterNeptune != null)
        return false
    } else if (jupiterNeptune != other.jupiterNeptune)
      return false
    if (jupiterPluto == null) {
      if (other.jupiterPluto != null)
        return false
    } else if (jupiterPluto != other.jupiterPluto)
      return false
    if (jupiterSaturn == null) {
      if (other.jupiterSaturn != null)
        return false
    } else if (jupiterSaturn != other.jupiterSaturn)
      return false
    if (jupiterUranus == null) {
      if (other.jupiterUranus != null)
        return false
    } else if (jupiterUranus != other.jupiterUranus)
      return false
    if (marsJupiter == null) {
      if (other.marsJupiter != null)
        return false
    } else if (marsJupiter != other.marsJupiter)
      return false
    if (marsNeptune == null) {
      if (other.marsNeptune != null)
        return false
    } else if (marsNeptune != other.marsNeptune)
      return false
    if (marsPluto == null) {
      if (other.marsPluto != null)
        return false
    } else if (marsPluto != other.marsPluto)
      return false
    if (marsSaturn == null) {
      if (other.marsSaturn != null)
        return false
    } else if (marsSaturn != other.marsSaturn)
      return false
    if (marsUranus == null) {
      if (other.marsUranus != null)
        return false
    } else if (marsUranus != other.marsUranus)
      return false
    if (mercuryJupiter == null) {
      if (other.mercuryJupiter != null)
        return false
    } else if (mercuryJupiter != other.mercuryJupiter)
      return false
    if (mercuryMars == null) {
      if (other.mercuryMars != null)
        return false
    } else if (mercuryMars != other.mercuryMars)
      return false
    if (mercuryNeptune == null) {
      if (other.mercuryNeptune != null)
        return false
    } else if (mercuryNeptune != other.mercuryNeptune)
      return false
    if (mercuryPluto == null) {
      if (other.mercuryPluto != null)
        return false
    } else if (mercuryPluto != other.mercuryPluto)
      return false
    if (mercurySaturn == null) {
      if (other.mercurySaturn != null)
        return false
    } else if (mercurySaturn != other.mercurySaturn)
      return false
    if (mercuryUranus == null) {
      if (other.mercuryUranus != null)
        return false
    } else if (mercuryUranus != other.mercuryUranus)
      return false
    if (mercuryVenus == null) {
      if (other.mercuryVenus != null)
        return false
    } else if (mercuryVenus != other.mercuryVenus)
      return false
    if (moonJupiter == null) {
      if (other.moonJupiter != null)
        return false
    } else if (moonJupiter != other.moonJupiter)
      return false
    if (moonMars == null) {
      if (other.moonMars != null)
        return false
    } else if (moonMars != other.moonMars)
      return false
    if (moonMercury == null) {
      if (other.moonMercury != null)
        return false
    } else if (moonMercury != other.moonMercury)
      return false
    if (moonNeptune == null) {
      if (other.moonNeptune != null)
        return false
    } else if (moonNeptune != other.moonNeptune)
      return false
    if (moonPluto == null) {
      if (other.moonPluto != null)
        return false
    } else if (moonPluto != other.moonPluto)
      return false
    if (moonSaturn == null) {
      if (other.moonSaturn != null)
        return false
    } else if (moonSaturn != other.moonSaturn)
      return false
    if (moonUranus == null) {
      if (other.moonUranus != null)
        return false
    } else if (moonUranus != other.moonUranus)
      return false
    if (moonVenus == null) {
      if (other.moonVenus != null)
        return false
    } else if (moonVenus != other.moonVenus)
      return false
    if (neptunePluto == null) {
      if (other.neptunePluto != null)
        return false
    } else if (neptunePluto != other.neptunePluto)
      return false
    if (saturnNeptune == null) {
      if (other.saturnNeptune != null)
        return false
    } else if (saturnNeptune != other.saturnNeptune)
      return false
    if (saturnPluto == null) {
      if (other.saturnPluto != null)
        return false
    } else if (saturnPluto != other.saturnPluto)
      return false
    if (saturnUranus == null) {
      if (other.saturnUranus != null)
        return false
    } else if (saturnUranus != other.saturnUranus)
      return false
    if (sunJupiter == null) {
      if (other.sunJupiter != null)
        return false
    } else if (sunJupiter != other.sunJupiter)
      return false
    if (sunMars == null) {
      if (other.sunMars != null)
        return false
    } else if (sunMars != other.sunMars)
      return false
    if (sunMoon == null) {
      if (other.sunMoon != null)
        return false
    } else if (sunMoon != other.sunMoon)
      return false
    if (sunNeptune == null) {
      if (other.sunNeptune != null)
        return false
    } else if (sunNeptune != other.sunNeptune)
      return false
    if (sunPluto == null) {
      if (other.sunPluto != null)
        return false
    } else if (sunPluto != other.sunPluto)
      return false
    if (sunSaturn == null) {
      if (other.sunSaturn != null)
        return false
    } else if (sunSaturn != other.sunSaturn)
      return false
    if (sunUranus == null) {
      if (other.sunUranus != null)
        return false
    } else if (sunUranus != other.sunUranus)
      return false
    if (sunVenus == null) {
      if (other.sunVenus != null)
        return false
    } else if (sunVenus != other.sunVenus)
      return false
    if (uranusNeptune == null) {
      if (other.uranusNeptune != null)
        return false
    } else if (uranusNeptune != other.uranusNeptune)
      return false
    if (uranusPluto == null) {
      if (other.uranusPluto != null)
        return false
    } else if (uranusPluto != other.uranusPluto)
      return false
    if (venusJupiter == null) {
      if (other.venusJupiter != null)
        return false
    } else if (venusJupiter != other.venusJupiter)
      return false
    if (venusMars == null) {
      if (other.venusMars != null)
        return false
    } else if (venusMars != other.venusMars)
      return false
    if (venusNeptune == null) {
      if (other.venusNeptune != null)
        return false
    } else if (venusNeptune != other.venusNeptune)
      return false
    if (venusPluto == null) {
      if (other.venusPluto != null)
        return false
    } else if (venusPluto != other.venusPluto)
      return false
    if (venusSaturn == null) {
      if (other.venusSaturn != null)
        return false
    } else if (venusSaturn != other.venusSaturn)
      return false
    if (venusUranus == null) {
      if (other.venusUranus != null)
        return false
    } else if (venusUranus != other.venusUranus)
      return false
    return true
  }
}
