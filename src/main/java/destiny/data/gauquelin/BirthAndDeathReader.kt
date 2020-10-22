/**
 * Created by smallufo on 2018-04-06.
 */
package destiny.data.gauquelin

import destiny.core.calendar.Location
import java.io.InputStream
import java.time.Duration
import java.time.LocalDateTime

/**
 * "9280" (i.e. 9272) Birth and Death Data (mostly infants) in Paris (unpublished)
 *
 * 9272 Birth and Death Data (mostly infants) in Paris. "Series F, volume 1".
 * 讀取的是 http://cura.free.fr/gauq/902gdF1.html
 * 此為 2009 改版的格式 , 用 TAB 區隔欄位
 * 沒有性別！
 * 有四筆資料 Death 「早於」 Birth , txt 檔案已經 mark 起來
 * */

class BirthAndDeathReader {

  fun read() {
    val iStream: InputStream = javaClass.getResourceAsStream("BirthAndDeath.txt")
    iStream.bufferedReader(Charsets.UTF_8).useLines { sequence ->
      sequence
        .filterNot { it.startsWith("#") }
        .filterNot { it.length == 0 }
        .chunked(2).forEach { lines ->
          val birth = parseLine(lines[0])
          val death = parseLine(lines[1])
          require(death.lmt.isAfter(birth.lmt))
          println("[${birth.number}] 存活 ${Duration.between(birth.lmt , death.lmt).toDays()} 日")

        }
    }
  }

  fun parseLine(line : String) : GPerson2 {
    val tokens = line.split("\t").toList()
    val num = tokens[0].toInt()
    val day = tokens[2].toInt()
    val month = tokens[3].toInt()
    val year = tokens[4].toInt()
    val hour = tokens[5].toInt()
    val min = tokens[6].toInt()
    val sec = tokens[7].toInt()
    val ciCode = tokens[8]

    val (tzid , minuteOffset) = ParseTools.getTzidAndMinuteOffset(tokens[9].toInt())
    val lat = ParseTools.parseLat(tokens[10])
    val lng = ParseTools.parseLng(tokens[11])

    val lmt = LocalDateTime.of(year , month , day , hour , min , sec)
    val loc = Location(lat, lng, tzid, minuteOffset)

    return GPerson2(null , num , null , null , lmt , loc , null , line)
  }

}
