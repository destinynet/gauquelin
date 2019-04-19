/**
 * Created by smallufo on 2018-04-05.
 */
package destiny.data.gauquelin

import java.io.InputStream
import java.time.LocalDateTime

/**
 *
 * wget --mirror --wait 1 --page-requisites --cut-dirs=1 --relative --no-parent -A '902gd*.html' --no-host-directories http://cura.free.fr/gauq/17archg.html
 *
 * */
class CsvReaderActor(val dataFile: String, val nameFile: String) {

  fun read() {
    val iStream: InputStream = javaClass.getResourceAsStream("actor.txt")

    iStream.bufferedReader(Charsets.UTF_8).readLines()
      .filterNot { it.startsWith("#") }
      .filterNot { it.isEmpty() }
      .forEach { line ->
        val tokens = line.split("\t").toList()
        //println(tokens.joinToString(","))
        val pro = tokens[0]
        val num = tokens[1]
        val country = tokens[2]
        val day = tokens[3].toInt()
        val month = tokens[4].toInt()
        val year = tokens[5].toInt()
        val hour = tokens[6].toInt()
        val min = tokens[7].toInt()
        val sec = tokens[8].toInt()
        val tz = tokens[9].toInt()

        val lat = ParseTools.parseLat(tokens[10])

        val lng = ParseTools.parseLng(tokens[11])

        val localDateTime = LocalDateTime.of(year,month,day, hour,min,sec)


        println("[$num] : $country , tz = $tz , ldt = $localDateTime , lat,lng = $lat,$lng")
      }
  }
}