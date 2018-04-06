/**
 * Created by smallufo on 2018-04-06.
 */
package destiny.data.gauquelin

object ParseTools {

  private val nsRegex = "[NS ]".toRegex()
  private val ewRegex = "[EW ]".toRegex()

  fun getTzidAndMinuteOffset(hour : Int) : Pair<String , Int> {
    return when(hour) {
      0 -> "GMT" to 0
      -1 -> "CET" to 480
      else -> throw RuntimeException("Error hour : $hour")
    }
  }

  fun parseLat(token: String): Double {
    return token.split(nsRegex).filterNot { it.isEmpty() }.let {
      val deg = it[0].toInt()
      val min = it[1].toInt()
      return@let (deg + min.toDouble() / 60.0).let { if (token.contains("S")) 0.0 - it else it }
    }
  }

  fun parseLng(token: String): Double {
    return token.split(ewRegex).filterNot { it.isEmpty() }.let {
      val deg = it[0].toInt()
      val min = it[1].toInt()
      return@let (deg + min.toDouble() / 60.0).let { if (token.contains("W")) 0.0 - it else it }
    }
  }
}