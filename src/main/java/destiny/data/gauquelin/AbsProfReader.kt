/**
 * Created by smallufo on 2019-04-16.
 */
package destiny.data.gauquelin

import destiny.core.Gender
import java.time.LocalDate

/**
 * 職業 reader
 *
 */
class AbsProfReader(private val dataFile: String,
                    private val nameFile: String? = null,
                    private val preDefGender: Gender? = null) {

  val list: List<GPerson2> by lazy {
    javaClass.getResourceAsStream(dataFile).bufferedReader(Charsets.UTF_8).useLines { lines ->
      lines
        .filterNot { it.startsWith("#") }
        .filterNot { it.length == 0 }
        .map { line -> ParseUtils.parseByNumber(line) }
        .filterNotNull()
        .map { it.apply { gender = preDefGender } }
        .toList()
    }
  }

  /**
   * 日期為 key , 相同生日的人串在後面
   */
  private val dataMapByDate: Map<LocalDate, List<GPerson2>> = list.groupBy { p -> p.lmt.toLocalDate() }

  /**
   * 日期為 key , 確保該日出生者只有一人
   * */
  private val uniqDataMap: Map<LocalDate, GPerson2> = dataMapByDate.filter { entry -> entry.value.size == 1 }
    .map { entry -> entry.key to entry.value[0] }.toMap()

  /**
   * 日期(可能重複) -> 人名 列表
   **/
  val names: List<Pair<LocalDate, String>> by lazy {
    nameFile?.let { fileName ->
      javaClass.getResourceAsStream(fileName).bufferedReader(Charsets.UTF_8).useLines { lines ->
        lines
          .filterNot { it.startsWith("#") }
          .filterNot { it.length == 0 }
          .map { line -> ParseUtils.parseName(line) }
          .toList()
      }
    } ?: emptyList()

  }

  /**
   * 日期為 key , 後方串接名字
   */
  private val nameMapByDate: Map<LocalDate, List<String>> = names.asSequence().groupBy({ pair -> pair.first }, { pair -> pair.second })

  /**
   * 日期為 key , 確保當日只有此名字
   * */
  private val uniqNameMap: Map<LocalDate, String> = nameMapByDate.filter { entry -> entry.value.size == 1 }
    .map { entry -> entry.key to entry.value[0] }.toMap()

  /**
   * 最終資料 , 可能有名字 , 也可能沒名字
   */
  val listWithOptionalName: List<GPerson2> = list.map { person ->
    val date = person.lmt.toLocalDate()
    uniqDataMap[date]?.let { pWithUniqDate ->
      pWithUniqDate.name = uniqNameMap[date]
      pWithUniqDate
    } ?: person
  }

  companion object {
    val actors = AbsProfReader("actor.txt", "actor_name.txt").listWithOptionalName
    val journalists = AbsProfReader("journalist.txt").list
    val military = AbsProfReader("military.txt", "military_name.txt", Gender.男).listWithOptionalName
    val musicians = AbsProfReader("musician.txt", "musician_name.txt").listWithOptionalName
    val painters = AbsProfReader("painter.txt", "painter_name.txt").listWithOptionalName
    val politicians = AbsProfReader("politician.txt", "politician_name.txt").listWithOptionalName
    val scientists = AbsProfReader("scientist.txt", "scientist_name.txt").listWithOptionalName
    val sports = AbsProfReader("sport.txt", "sport_name.txt").listWithOptionalName
    val writers = AbsProfReader("writer.txt", "writer_name.txt").listWithOptionalName

  }

}
