/**
 * @author smallufo
 * Created on 2009/3/5 at 下午 9:20:23
 */
package destiny.data.gauquelin

import destiny.core.calendar.LocationTools.decode
import org.hibernate.annotations.BatchSize
import java.io.Serializable
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

/**
 * 高格林的一筆資料
 */
@Entity
@Table(name = "person")
@Cacheable
@BatchSize(size = 10)
class GPerson : Serializable {
  /** 資料庫的 id  */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  var id: Long = 0
  var category: String? = null
  /** 原始的 number ，每種職業會有獨一的 number . 不同職業的 number 會重複，不可拿來做 index  */
  var number = 0
  var name: String? = null
  /** 男生 = 1 , 女生 = 0 , 未定義則為 -1  */
  var gender = -1
  /** 「未調整過時區」的原始出生時間  */
  var gmtTimestamp: Timestamp? = null
  var location: String? = null
  /** 地點  */
  var place: String? = null
  /** 原始資料  */
  var raw: String? = null
  /** 星體位於什麼宮  */
  @BatchSize(size = 100)
  @OneToMany(mappedBy = "gperson", cascade = [CascadeType.ALL], fetch = FetchType.EAGER, orphanRemoval = true)
  @MapKey(name = "house")
  var houseMap = Collections.synchronizedMap(HashMap<String, GPersonHouse>())
  /** 星體交角資料  */
  @BatchSize(size = 100)
  @OneToOne(mappedBy = "gperson")
  @JoinColumn(name = "personId")
  var aspect: GPersonAspect? = null
  /** 交角強度  */
  @BatchSize(size = 100)
  @OneToOne(mappedBy = "gperson")
  @JoinColumn(name = "personId")
  var anglePower: GPersonAnglePower? = null
  //何星體位於哪一宮
  //任兩顆星是否呈現交角，或哪種交角
  //交角強度

  /** 輸出成 CSV 格式  */
  val csv: String
    get() {
      val sb = StringBuffer()
      //sb.append(getId() + " : ");
      sb.append("\"")
      sb.append(category)
      sb.append("\",")
      //何星體位於哪一宮
      val house = houseMap["placidus"]
      sb.append(house!!.sun.toString() + ",")
      sb.append(house.moon.toString() + ",")
      sb.append(house.mercury.toString() + ",")
      sb.append(house.venus.toString() + ",")
      sb.append(house.mars.toString() + ",")
      sb.append(house.jupiter.toString() + ",")
      sb.append(house.saturn.toString() + ",")
      sb.append(house.uranus.toString() + ",")
      sb.append(house.neptune.toString() + ",")
      sb.append(house.neptune.toString() + ",")
      //任兩顆星是否呈現交角，或哪種交角
      sb.append("\"" + getShrinkAspect(aspect!!.sunMoon) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.sunMercury) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.sunVenus) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.sunMars) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.sunJupiter) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.sunSaturn) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.sunUranus) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.sunNeptune) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.sunPluto) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.moonMercury) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.moonVenus) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.moonMars) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.moonJupiter) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.moonSaturn) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.moonUranus) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.moonNeptune) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.moonPluto) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.mercuryVenus) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.mercuryMars) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.mercuryJupiter) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.mercurySaturn) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.mercuryUranus) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.mercuryNeptune) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.mercuryPluto) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.venusMars) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.venusJupiter) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.venusSaturn) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.venusUranus) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.venusNeptune) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.venusPluto) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.marsJupiter) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.marsSaturn) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.marsUranus) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.marsNeptune) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.marsPluto) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.jupiterSaturn) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.jupiterUranus) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.jupiterNeptune) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.jupiterPluto) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.saturnUranus) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.saturnNeptune) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.saturnPluto) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.uranusNeptune) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.uranusPluto) + "\",")
      sb.append("\"" + getShrinkAspect(aspect!!.neptunePluto) + "\",")
      //交角強度
      sb.append("\"" + anglePower!!.sun + "\",")
      sb.append(anglePower!!.sunPower.toString().substring(0, 5) + ",")
      sb.append("\"" + anglePower!!.moon + "\",")
      sb.append(anglePower!!.moonPower.toString().substring(0, 5) + ",")
      sb.append("\"" + anglePower!!.mars + "\",")
      sb.append(anglePower!!.marsPower.toString().substring(0, 5) + ",")
      sb.append("\"" + anglePower!!.jupiter + "\",")
      sb.append(anglePower!!.jupiterPower.toString().substring(0, 5) + ",")
      sb.append("\"" + anglePower!!.saturn + "\",")
      sb.append(anglePower!!.saturnPower.toString().substring(0, 5) + ",")
      sb.append("\"" + anglePower!!.uranus + "\",")
      sb.append(anglePower!!.uranusPower.toString().substring(0, 5) + ",")
      sb.append("\"" + anglePower!!.neptune + "\",")
      sb.append(anglePower!!.neptunePower.toString().substring(0, 5) + ",")
      sb.append("\"" + anglePower!!.pluto + "\",")
      sb.append(anglePower!!.plutoPower.toString(), 0, 5)
      return sb.toString()
    }

  /** 為了節省空間 , 將 Opposition , Trine ... 等 Aspect , 只取前面兩個字元 , 而 null 則傳回 "n"  */
  private fun getShrinkAspect(s: String?): String {
    return s?.substring(0, 2) ?: "n"
  }

  /** 資料都是 gmt 的  */
  val gmtTime: LocalDateTime
    get() = gmtTimestamp!!.toLocalDateTime()

  override fun toString(): String {
    val sb = StringBuffer()
    sb.append("[$id] ")
    sb.append(" $category")
    sb.append("\t")
    sb.append(number)
    sb.append("\t" + name)
    sb.append(" ")
    if (gender == 1) sb.append("M") else if (gender == 0) sb.append("F") else sb.append("?")
    sb.append(" ")
    sb.append("gmt = $gmtTimestamp")
    sb.append(" ")
    val loc = decode(location!!)
    sb.append("loc = $loc")
    sb.append(" ")
    sb.append(place)
    /*
    for(String house : houseMap.keySet())
      sb.append("\n分宮法：\t"+house);
    if (aspect != null)
      sb.append("\n日月交 : " + aspect.getSunMoon());
    */return sb.toString()
  }

  override fun hashCode(): Int {
    val prime = 31
    var result = 1
    result = prime * result + gender
    result = prime * result + if (location == null) 0 else location.hashCode()
    result = prime * result + if (gmtTimestamp == null) 0 else gmtTimestamp.hashCode()
    return result
  }

  override fun equals(obj: Any?): Boolean {
    if (this === obj) return true
    if (obj == null) return false
    if (javaClass != obj.javaClass) return false
    val other = obj as GPerson
    if (gender != other.gender) return false
    if (location == null) {
      if (other.location != null) return false
    } else if (location != other.location) return false
    return if (gmtTimestamp == null) {
      other.gmtTimestamp == null
    } else gmtTimestamp!!.equals(other.gmtTimestamp)
  }

}
