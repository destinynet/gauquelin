/**
 * Created by smallufo at 2009/3/11 下午 5:51:27
 */
package destiny.data.gauquelin

import java.io.BufferedWriter
import java.io.FileWriter
import java.io.IOException

/** 餵入資料，吐出姓名在尾端  */
class TextDataFormatter(reader: TextDataReader, outfile: String?) {
  init {
    var bWriter: BufferedWriter? = null
    try {
      val fstream = FileWriter(outfile)
      bWriter = BufferedWriter(fstream)
      for (person in reader.persons) {
        val sb = StringBuffer(person.raw)
        sb.append("\t")
        if (person.name != null) sb.append(person.name)
        bWriter.append(sb.toString() + "\r\n")
      }
      bWriter.flush()
    } catch (e: IOException) {
      e.printStackTrace()
    } finally {
      try {
        bWriter!!.close()
      } catch (e: IOException) {
        e.printStackTrace()
      }
    }
  }
}
