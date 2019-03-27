/**
 * Created by smallufo on 2018-04-06.
 */
package destiny.data.gauquelin

import destiny.core.Gender
import destiny.core.calendar.Location
import java.time.LocalDateTime


data class Family(
  val father: GPerson2?,
  val mother: GPerson2?,
  val children: List<GPerson2>)

class BirthReader(val filename: String, val hospital: Hospital?, val city: City) {

  enum class City {
    Paris,
    /** 里爾 */
    Lille,
    /** 布爾日 */
    Bourges,
    Seine
  }

  private val cityMap = mapOf(
    City.Paris to Pair(48.50, 2.3333),
    City.Lille to Pair(50.62925, 3.057256),
    City.Bourges to Pair(47.082508, 2.399341))

  enum class Hospital {
    /** 聖安東尼奧醫院 */
    SaintAntoine,
    /** 硝石庫慈善醫院 */
    Pitie,
    /** 皇家港婦產醫院 */
    PortRoyal,
    /** 巴迪洛克醫院 , 經緯度不詳，設定為巴黎 */
    Baudelocque,
  }

  /** 先緯度、再精度 */
  private val hospitalMap = mapOf(
    Hospital.SaintAntoine to Pair(48.849062, 2.382695),
    Hospital.Pitie to Pair(48.837283, 2.365342),
    Hospital.PortRoyal to Pair(48.838743, 2.337471),
    Hospital.Baudelocque to Pair(48.50, 2.3333)
                                 )

  fun read(): Sequence<Family> {

    return javaClass.getResourceAsStream(filename).use { iStream ->
      iStream.bufferedReader(Charsets.UTF_8)
        .lineSequence()
        .filterNot { it.startsWith("#") }
        .filterNot { it.isEmpty() }
        .let { seq -> chunkByFamily(seq) }
        .filter { family ->

          return@filter family.children.all { child ->
            val childAfterFather: Boolean = family.father?.lmt?.let { child.lmt.isAfter(it) } ?: true
            val childAfterMother: Boolean = family.mother?.lmt?.let { child.lmt.isAfter(it) } ?: true
            return@all if (childAfterFather && childAfterMother) {
              true
            } else {
              println("warning : age check error : $family")
              false
            }
          }
        }
    }

  } // read


  private fun chunkByFamily(lines: Sequence<String>): Sequence<Family> = sequence {
    var father: GPerson2? = null
    var mother: GPerson2? = null
    val children = mutableListOf<GPerson2>()

    for (line in lines) {
      val token1 = line.split("\t")[1]
      if ((token1 == "F" || token1 == "M") && (children.size > 0 || (father != null && mother != null))) {
        val cloned = children.toList()
        children.clear()
        yield(Family(father, mother, cloned))
        father = null
        mother = null
      }

      when (token1) {
        "F" -> father = parseLine(line)
        "M" -> mother = parseLine(line)
        "S", "D" -> children.add(parseLine(line))
      }
    }

    yield(Family(father, mother, children))
  }


  enum class BirthPlace {
    HOS, // 醫院
    MAT, // private Maternity , 私人婦產科
    H    // 家裡
  }

  private fun parseLine(line: String): GPerson2 {
    //println(line)
    val tokens = line.split("\t").toList()
    return when (tokens.size) {
      14 -> parseLineWithPL(line, tokens)
      13 -> parseLineWithoutPL(line, tokens)
      else -> throw RuntimeException("tokens size = ${tokens.size}")
    }
  }

  private fun parseLineWithPL(line: String, tokens: List<String>): GPerson2 {
    val num = tokens[0].toInt()
    val gender = parseGender(tokens[1])
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

    val cod = tokens[13]

    val lmt = LocalDateTime.of(year, month, day, hour, min, sec)
    val loc = Location(lng, lat, tzid, minuteOffset)

    return GPerson2(null, num, null, gender, lmt, loc, null, line)
  }

  private fun parseLineWithoutPL(line: String, tokens: List<String>): GPerson2 {
    val num = tokens[0].toInt()
    val gender = parseGender(tokens[1])
    val day = tokens[2].toInt()
    val month = tokens[3].toInt()
    val year = tokens[4].toInt()
    val hour = tokens[5].toInt()
    val min = tokens[6].toInt()
    val sec = tokens[7].toInt()
    val ciCode = tokens[8]
    val (tzid, minuteOffset) = ParseTools.getTzidAndMinuteOffset(tokens[9].toInt())

    val (lat, lng) =
      if ((tokens[1] == "S" || tokens[1] == "D") && hospital != null) hospitalMap[hospital]!!
      else ParseTools.parseLat(tokens[10]) to ParseTools.parseLng(tokens[11])

    val cod = tokens[12]

    val lmt = LocalDateTime.of(year, month, day, hour, min, sec)
    val loc = Location(lng, lat, tzid, minuteOffset)

    return GPerson2(null, num, null, gender, lmt, loc, null, line)
  }

  private fun parseGender(token: String): Gender = when (token) {
    "F", "S" -> Gender.男
    "M", "D" -> Gender.女
    else -> throw RuntimeException("unknown gender $token")
  }
}