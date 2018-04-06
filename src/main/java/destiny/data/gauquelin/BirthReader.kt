/**
 * Created by smallufo on 2018-04-06.
 */
package destiny.data.gauquelin

import destiny.core.Gender
import destiny.core.calendar.Location
import java.io.InputStream
import java.time.LocalDateTime
import kotlin.coroutines.experimental.buildSequence


class BirthReader {

  enum class Hospital {
    /** 聖安東尼奧醫院 */
    SaintAntoine,
    /** 硝石庫慈善醫院 */
    Pitie,
  }

  /** 先緯度、再精度 */
  private val hospitalMap = mapOf(
    Hospital.SaintAntoine to Pair(48.849062, 2.382695),
    Hospital.Pitie to Pair(48.837283, 2.365342)
                                 )

  fun read(filename: String, hospital: Hospital) {
    val iStream: InputStream = javaClass.getResourceAsStream(filename)

    iStream.bufferedReader(Charsets.UTF_8)
      .useLines { sequence ->
        val seq2 = sequence
          .filterNot { it.startsWith("#") }
          .filterNot { it.isEmpty() }

        chunkByFamily(seq2, hospital).forEach { f ->
          println("父 : ${f.father?.raw}")
          println("母 : ${f.mother?.raw}")
          f.children.forEach { c ->
            c.gender?.also {
              when (it) {
                Gender.男 -> println("\t子 : $c")
                Gender.女 -> println("\t女 : $c")
              }
            }
          }
        }
      }
  }

  data class Family(
    val father: GPerson2?,
    val mother: GPerson2?,
    val children: List<GPerson2>)

  private fun chunkByFamily(lines: Sequence<String>, hospital: Hospital): Sequence<Family> = buildSequence {
    var father: GPerson2? = null
    var mother: GPerson2? = null
    val children = mutableListOf<GPerson2>()

    for (line in lines) {
      val token1 = line.split("\t")[1]
      if ((token1 == "F" || token1 == "M") && children.size > 0) {
        val cloned = children.toList()
        children.clear()
        yield(Family(father, mother, cloned))
        father = null
        mother = null
      }

      when (token1) {
        "F" -> father = parseLine(line, hospital)
        "M" -> mother = parseLine(line, hospital)
        "S", "D" -> children.add(parseLine(line, hospital))
      }
    }

    yield(Family(father, mother, children))
  }


  enum class BirthPlace {
    HOS, // 醫院
    MAT, // private Maternity , 私人婦產科
    H     // 家裡
  }

  fun parseLine(line: String, hospital: Hospital): GPerson2 {
    //println("$line")
    val tokens = line.split("\t").toList()
    val num = tokens[0].toInt()
    val gender = tokens[1].let {
      return@let when (it) {
        "F", "S" -> Gender.男
        "M", "D" -> Gender.女
        else -> throw RuntimeException("unknown gender $it")
      }
    }
    val pl: Pair<BirthPlace, Pair<Double, Double>?>? = tokens[2].let {
      when (it) {
        "HOS" -> BirthPlace.HOS to hospitalMap[hospital]!!
        "MAT" -> BirthPlace.MAT to null
        "H" -> BirthPlace.H to null
        else -> null
      }
    }
    val day = tokens[3].toInt()
    val month = tokens[4].toInt()
    val year = tokens[5].toInt()
    val hour = tokens[6].toInt()
    val min = tokens[7].toInt()
    val sec = tokens[8].toInt()
    val ciCode = tokens[9]
    val (tzid, minuteOffset) = ParseTools.getTzidAndMinuteOffset(tokens[10].toInt())

    val (lat, lng) = pl?.second?.let {
      it.first to it.second
    } ?: (ParseTools.parseLat(tokens[11]) to ParseTools.parseLng(tokens[12]))

    //    val lat = ParseTools.parseLat(tokens[11])
    //    val lng = ParseTools.parseLng(tokens[12])
    val cod = tokens[13]

    val lmt = LocalDateTime.of(year, month, day, hour, min, sec)
    val loc = Location(lng, lat, tzid, minuteOffset)

    return GPerson2(null, num, null, gender, lmt, loc, null, line)
  }
}