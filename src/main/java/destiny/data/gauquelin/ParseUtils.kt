/**
 * @author smallufo
 * Created on 2009/3/7 at 下午 8:32:01
 */
package destiny.data.gauquelin

import destiny.core.calendar.EastWest
import destiny.core.calendar.Location
import destiny.core.calendar.LocationTools
import destiny.core.calendar.NorthSouth
import destiny.tools.location.TimeZoneUtils
import mu.KotlinLogging
import java.io.Serializable
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.*

class ParseUtils : Serializable {
  companion object {
    /**
     * 以 Number 排序
     * Sport 運動冠軍 , Scientist 科學家(及醫師) , Military 軍人 , Painter 畫家 , Musician 音樂家 , Actor 演員 , Politician 政治人物
     * PRO    NUM COU DAY MON YEA H   MN  SEC TZ  LAT LON COD CITY
     */
    fun parseByNumber2(line: String): GPerson2? {
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


        val (northSouth, latDeg, latMin) = st.nextToken().let { lat ->
          val (latDeg, latMin) = lat.splitToSequence('N', 'S').map { it.trim { it <= ' ' } }.map { it.toInt() }.toList().let { list ->
            list[0] to list[1]
          }
          val ns = lat[if (latDeg < 10) 1 else 2]
          val northSouth = if (ns == 'N') NorthSouth.NORTH else NorthSouth.SOUTH
          Triple(northSouth, latDeg, latMin)
        }

        val (eastWest, lngDeg, lngMin) = st.nextToken().let { lng ->
          val (lngDeg, lngMin) = lng.splitToSequence('E', 'W').map { it.trim { it <= ' ' } }.map { it.toInt() }.toList().let { list ->
            list[0] to list[1]
          }
          val ew = lng[if (lngDeg < 10) 1 else 2]
          val eastWest = if (ew == 'E') EastWest.EAST else EastWest.WEST
          Triple(eastWest, lngDeg, lngMin)
        }

        // 都是 GMT 時間

        val time = LocalDateTime.of(year, month, day, hour, minute, second)
        val ts = Timestamp.valueOf(time)
        val location = Location(
          eastWest, lngDeg, lngMin, 0.0,
          northSouth, latDeg, latMin, 0.0, TimeZoneUtils.getTimeZone(tz * 60).id, null, 0.0)


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

    fun parseByNumber(line: String): GPerson {
      val st = StringTokenizer(line, "\t")
      val PRO = st.nextToken()

      //某些 NUM 會以驚嘆號結尾，原因不詳
      var NUM = st.nextToken()
      if (NUM.lastIndexOf('!') != -1)
        NUM = NUM.substring(0, NUM.length - 1)
      val number = Integer.parseInt(NUM)
      val COU = st.nextToken()

      val day = Integer.parseInt(st.nextToken())
      val month = Integer.parseInt(st.nextToken())
      val year = Integer.parseInt(st.nextToken())

      val hour = Integer.parseInt(st.nextToken())
      val minute = Integer.parseInt(st.nextToken())
      val second = Integer.parseInt(st.nextToken())
      var tz = Integer.parseInt(st.nextToken()) // -1 的話，代表「東一區」
      tz = 0 - tz

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
      //System.out.println("LON = " + LON + " , EW = " + EW);


      // 都是 GMT 時間
      val time = LocalDateTime.of(year, month, day, hour, minute, second)
      val ts = Timestamp.valueOf(time)
      val location = Location(
        if (EW == 'E') EastWest.EAST else EastWest.WEST, longDeg, longMin, 0.0,
        if (NS == 'N') NorthSouth.NORTH else NorthSouth.SOUTH, latDeg, latMin, 0.0, TimeZoneUtils.getTimeZone(tz * 60).id, null, 0.0)


      val person = GPerson()
      person.number = number
      person.gender = -1
      person.gmtTimestamp = ts
      person.location = LocationTools.encode(location)

      val COD = st.nextToken()
      var CITY = ""
      try {
        CITY = st.nextToken()
      } catch (ignored: NoSuchElementException) {
      }

      person.place = CITY
      //原始資料
      person.raw = line
      return person
    }

    /**
     * 以日期排序
     * YEA  MON DAY PRO NUM COU H   MN  SEC TZ  LAT LON COD CITY
     */
    @Deprecated("")
    fun parseByDate(line: String): GPerson {
      val st = StringTokenizer(line, "\t")

      val year = Integer.valueOf(st.nextToken()).toInt()
      val month = Integer.valueOf(st.nextToken()).toInt()
      val day = Integer.valueOf(st.nextToken()).toInt()

      val PRO = st.nextToken()
      val number = Integer.parseInt(st.nextToken())

      val COU = st.nextToken()

      val hour = Integer.parseInt(st.nextToken())
      val minute = Integer.parseInt(st.nextToken())
      val second = Integer.parseInt(st.nextToken())

      val tz = Integer.valueOf(st.nextToken()).toInt() // -1 的話，代表「東一區」

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

      // 都是 GMT 時間
      val time = LocalDateTime.of(year, month, day, hour, minute, second)
      //Calendar cal = new GregorianCalendar(time.getYear() , time.getMonth()-1 , time.getDay() , time.getHour() , time.getMinute() , (int)time.getSecond());
      val ts = Timestamp.valueOf(time)
      val location = Location(if (EW == 'E') EastWest.EAST else EastWest.WEST, longDeg, longMin, 0.0,
        if (NS == 'N') NorthSouth.NORTH else NorthSouth.SOUTH, latDeg, latMin, 0.0, "GMT", null,
        0.0)

      val person = GPerson()
      person.number = number
      person.gender = -1
      person.gmtTimestamp = ts
      person.location = LocationTools.encode(location)

      val COD = st.nextToken()
      val CITY = st.nextToken()

      person.place = CITY
      //原始資料
      person.raw = line

      return person
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
    fun parseMental(line: String): GPerson {
      val st = StringTokenizer(line, "\t")
      val acd = st.nextToken()
      val rest = line.substring(line.indexOf(st.nextToken()))
      val person = parseMurderAlcoholic(rest)
      person.raw = line

      return person
    }

    /**
     * 殺人犯 , 酗酒者
     * NUM    SEX     DAY MON YEA H   MN  SEC TZ      LAT LON     COD
     */
    fun parseMurderAlcoholic(line: String): GPerson {
      val st = StringTokenizer(line, "\t")
      val number = Integer.parseInt(st.nextToken())

      var gender = -1
      val SEX = st.nextToken()
      if (SEX == "M")
        gender = 1
      else if (SEX == "F")
        gender = 0

      val day = Integer.parseInt(st.nextToken())
      val month = Integer.parseInt(st.nextToken())
      val year = Integer.parseInt(st.nextToken())
      val hour = Integer.parseInt(st.nextToken())
      val minute = Integer.parseInt(st.nextToken())
      val second = Integer.parseInt(st.nextToken())

      val tz = Integer.parseInt(st.nextToken()) // -1 的話，代表「東一區」

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

      // 都是 GMT 時間
      val time = LocalDateTime.of(year, month, day, hour, minute, second)
      val ts = Timestamp.valueOf(time)
      val location = Location(if (EW == 'E') EastWest.EAST else EastWest.WEST, longDeg, longMin, 0.0,
        if (NS == 'N') NorthSouth.NORTH else NorthSouth.SOUTH, latDeg, latMin, 0.0, "GMT", null,
        0.0)

      val COD = st.nextToken()

      val person = GPerson()
      person.number = number
      person.gender = gender
      person.gmtTimestamp = ts
      person.location = LocationTools.encode(location)
      person.raw = line

      return person
    }

    val logger = KotlinLogging.logger { }
  }
}
