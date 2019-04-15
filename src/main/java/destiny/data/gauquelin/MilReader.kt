/**
 * Created by smallufo on 2019-04-16.
 */
package destiny.data.gauquelin

class MilReader {

  val list: List<GPerson2> by lazy {
    javaClass.getResourceAsStream("military.txt").bufferedReader(Charsets.UTF_8).useLines { lines ->
      lines
        .filterNot { it.startsWith("#") }
        .filterNot { it.isEmpty() }
        .map { line -> ParseUtils.parseByNumber2(line) }
        .filterNotNull()
        .toList()
    }
  }
}

fun main() {
  val reader = MilReader()
  reader.list.forEach { p ->
    println(p)
  }
}