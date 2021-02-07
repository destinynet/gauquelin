/**
 * @author smallufo
 * Created on 2009/3/12 at 上午 1:10:23
 */
package destiny.data.gauquelin

import java.io.*

abstract class AbstractMurderAlcoholicReader(private val datafile: String, private val category: String) :
  TextDataReader, Serializable {

  override val persons: List<GPerson>
    get() {
      val ps = mutableListOf<GPerson>()
      val url = javaClass.getResource(datafile)
      val file: File
      var bReader: BufferedReader? = null
      try {
        file = File(url.toURI())
        val fReader = FileReader(file)
        bReader = BufferedReader(fReader)
        var line: String? = null
        while (bReader.readLine().also { line = it } != null) {
          if (line != "" && line!![0] != '#') {
//            val gp: GPerson2? = ParseUtils.parseMurderAlcoholic(line!!)
//            gp.setCategory(category)
//            ps.add(gp)
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


}
