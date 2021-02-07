/**
 * @author smallufo
 * Created on 2009/3/8 at 上午 12:45:32
 */
package destiny.data.gauquelin

import destiny.data.gauquelin.ParseUtils.Companion.parseType3
import java.io.*

class Sport450Reader : TextDataReader, Serializable {


  override val persons: List<GPerson>
    get() {
      val ps = mutableListOf<GPerson>()
      val url = javaClass.getResource("sport450.txt")
      val file: File
      var bReader: BufferedReader? = null
      try {
        file = File(url.toURI())
        val fReader = FileReader(file)
        bReader = BufferedReader(fReader)
        var line: String?
        while (bReader.readLine().also { line = it } != null) {
          if (line != "" && line!![0] != '#') {
            val gp = parseType3(line!!)
            gp.category = "sport"
            ps.add(gp)
          }
        }
      } catch (e: Exception) {
        e.printStackTrace()
      } finally {
        try {
          bReader!!.close()
        } catch (e: IOException) {
          e.printStackTrace()
        }
      }
      return ps.toList()
    }

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val r = Sport450Reader()
      var i = 0
      for (person in r.persons) {
        i++
        println("[$i] : $person")
      }
    }
  }


}
