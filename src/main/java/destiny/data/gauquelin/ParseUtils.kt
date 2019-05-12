/**
 * @author smallufo
 * Created on 2009/3/7 at 下午 8:32:01
 */
package destiny.data.gauquelin

import destiny.core.Gender
import destiny.core.calendar.EastWest
import destiny.core.calendar.Location
import destiny.core.calendar.LocationTools
import destiny.core.calendar.NorthSouth
import destiny.tools.location.TimeZoneUtils
import mu.KotlinLogging
import java.io.Serializable
import java.sql.Timestamp
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

class ParseUtils : Serializable {
  companion object {

    private fun parseLat(lat:String) : Triple<NorthSouth , Int , Int> {
      val (latDeg, latMin) = lat.splitToSequence('N', 'S').map { it.trim { it <= ' ' } }.map { it.toInt() }.toList().let { list ->
        list[0] to list[1]
      }
      val ns = lat[if (latDeg < 10) 1 else 2]
      val northSouth = if (ns == 'N') NorthSouth.NORTH else NorthSouth.SOUTH
      return Triple(northSouth, latDeg, latMin)
    }

    private fun parseLng(lng:String) : Triple<EastWest , Int , Int> {
      val (lngDeg, lngMin) = lng.splitToSequence('E', 'W').map { it.trim { it <= ' ' } }.map { it.toInt() }.toList().let { list ->
        list[0] to list[1]
      }
      val ew = lng[if (lngDeg < 10) 1 else 2]
      val eastWest = if (ew == 'E') EastWest.EAST else EastWest.WEST
      return Triple(eastWest, lngDeg, lngMin)
    }

    /**
     * 以 Number 排序
     * Sport 運動冠軍 , Scientist 科學家(及醫師) , Military 軍人 , Painter 畫家 , Musician 音樂家 , Actor 演員 , Politician 政治人物
     * PRO    NUM COU DAY MON YEA H   MN  SEC TZ  LAT LON COD CITY
     */
    fun parseByNumber(line: String): GPerson2? {
      try {

        val st = StringTokenizer(line, "\t")
        val PRO = st.nextToken()


        //某些 NUM 會以驚嘆號結尾，原因不詳
        val number = st.nextToken().substringBeforeLast('!').toInt()

        val COU = st.nextToken()

        val day = st.nextToken().toInt()
        val month = st.nextToken().toInt()
        val year = st.nextToken().toInt()

        val hour = st.nextToken().toInt()
        val minute = st.nextToken().toInt()
        val second = st.nextToken().toInt()

        // -1 的話，代表「東一區」
        val tz: Int = st.nextToken().toInt().let { 0 - it }
        TimeZoneUtils.getTimeZone(tz * 60).id // 資料已經都是 GMT 了 , 所以此 tz int 其實沒有實際作用


        val (northSouth, latDeg, latMin) = parseLat(st.nextToken())
        val (eastWest, lngDeg, lngMin) = parseLng(st.nextToken())
        // 都是 GMT 時間

        val time = LocalDateTime.of(year, month, day, hour, minute, second)
        val ts = Timestamp.valueOf(time)



        val location = Location(
          eastWest, lngDeg, lngMin, 0.0,
          northSouth, latDeg, latMin, 0.0, "GMT", null, 0.0)


        val COD = st.nextToken()
        val city = try {
          st.nextToken()
        } catch (ignored: NoSuchElementException) {
          null
        }

        return GPerson2(null, number, null, null, time, location, city, line)
      } catch (e: Exception) {
        logger.warn("{} : exception : {}", line, e.message)
        return null
      }
    }

    /**
     * parse name
     * 範例：
     * # YEA	MON	DAY	NAME
     * 1800	9	27	Baret Rouvray Charles
     */
    fun parseName(line: String): Pair<LocalDate, String> {
      return line.splitToSequence('\t').toList().let { list ->
        val year = list[0].trim().toInt()
        val month = list[1].trim().toInt()
        val day = list[2].trim().toInt()
        val name = list[3].trim()
        LocalDate.of(year , month , day) to name
      }
    }


    /** 專門處理 Sport 450  */
    fun parseType3(line: String): GPerson {
      val st = StringTokenizer(line, "\t")
      val number = Integer.parseInt(st.nextToken())
      val day = Integer.parseInt(st.nextToken())
      val month = Integer.parseInt(st.nextToken())
      val year = Integer.parseInt(st.nextToken())
      val hour = Integer.parseInt(st.nextToken())
      val minute = Integer.parseInt(st.nextToken())
      val second = Integer.parseInt(st.nextToken())

      val LAT = st.nextToken()
      val st2 = StringTokenizer(LAT, "NS")
      val latDeg = Integer.parseInt(st2.nextToken().trim { it <= ' ' })
      val latMin = Integer.parseInt(st2.nextToken().trim { it <= ' ' })
      val NS = LAT[if (latDeg < 10) 1 else 2]

      val LON = st.nextToken()
      val st3 = StringTokenizer(LON, "EW")
      val longDeg = Integer.parseInt(st3.nextToken().trim { it <= ' ' })
      val longMin = Integer.parseInt(st3.nextToken().trim { it <= ' ' })
      val EW = LON[if (longDeg < 10) 1 else 2]

      val name = st.nextToken()

      // 時間都是 GMT , 因為沒有時區這欄，所以推測都是 GMT
      val time = LocalDateTime.of(year, month, day, hour, minute, second)
      val ts = Timestamp.valueOf(time)
      val location = Location(
        if (EW == 'E') EastWest.EAST else EastWest.WEST, longDeg, longMin, 0.0,
        if (NS == 'N') NorthSouth.NORTH else NorthSouth.SOUTH, latDeg, latMin, 0.0, "GMT", null, 0.0)

      val person = GPerson()
      person.number = number
      person.gender = -1
      person.gmtTimestamp = ts
      person.location = LocationTools.encode(location)
      person.name = name
      person.raw = line

      return person
    }

    /**
     * http://cura.free.fr/gauq/902gdD9b.html
     * 以下五種 :
     * ACD : "ACUTE DELUSIONS"
     * HALP : "HALLUCINATING PSYCHOSIS"
     * MD : "MENTALLY DERANGED"
     * MDP : MANIC-DEPRESSIVE PSYCHOSIS
     * SCH : SCHIZOPHRENICS
     */
    fun parseMental(line: String): GPerson2? {
      val st = StringTokenizer(line, "\t")
      val acd = st.nextToken()
      val rest = line.substring(line.indexOf(st.nextToken()))
      val person = parseMurderAlcoholic(rest)?.apply {
        raw = line
      }

      return person
    }

    /**
     * 殺人犯 , 酗酒者
     * NUM    SEX     DAY MON YEA H   MN  SEC TZ      LAT LON     COD
     */
    fun parseMurderAlcoholic(line: String): GPerson2? {
      try {
        val st = StringTokenizer(line, "\t")
        val number = Integer.parseInt(st.nextToken())

        val gender = st.nextToken().let {
          when (it) {
            "M" -> Gender.男
            "F" -> Gender.女
            else -> throw Exception("Unknown Gender : $it , line = $line")
          }
        }

        val day = st.nextToken().toInt()
        val month = st.nextToken().toInt()
        val year = st.nextToken().toInt()

        val hour = st.nextToken().toInt()
        val minute = st.nextToken().toInt()
        val second = st.nextToken().toInt()

        val tz = Integer.parseInt(st.nextToken()) // -1 的話，代表「東一區」

        val (northSouth, latDeg, latMin) = parseLat(st.nextToken())
        val (eastWest, lngDeg, lngMin) = parseLng(st.nextToken())

        // 都是 GMT 時間
        val time = LocalDateTime.of(year, month, day, hour, minute, second)
        val ts = Timestamp.valueOf(time)
        val location = Location(eastWest, lngDeg, lngMin, 0.0, northSouth, latDeg, latMin, 0.0, "GMT", null, 0.0)

        val COD = st.nextToken()

        return GPerson2(null , number , null , gender , time , location , null , line)
      } catch (e:Exception) {
        logger.warn("{} : exception : {}", line, e.message)
        return null
      }
    }


    val logger = KotlinLogging.logger { }
  }
}
