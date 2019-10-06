/**
 * Created by smallufo at 2009/3/17 下午 8:49:32
 */
package destiny.data.gauquelin

import destiny.core.calendar.Location
import java.io.File
import java.io.FileReader
import java.io.Serializable
import java.util.*

class CityLocation : Serializable {
  private var prop: Properties? = null

  init {
    val url = javaClass.getResource("cityLocation.properties")
    val file: File
    try {
      file = File(url.toURI())
      val fReader = FileReader(file)

      prop = Properties()
      prop!!.load(fReader)
    } catch (e: Exception) {
      e.printStackTrace()
    }

  }

  fun getLocation(cityName: String): Location? {
    val locString = prop!!.getProperty(cityName) ?: return null

    val st = StringTokenizer(locString, ",")
    val lat = java.lang.Double.parseDouble(st.nextToken())
    val lon = java.lang.Double.parseDouble(st.nextToken())

    //TODO : 目前資料都是 gmt，時差為 0
    return Location(lat, lon, "GMT")
  }

  companion object {

    @JvmStatic
    fun main(args: Array<String>) {
      val cityLocation = CityLocation()
      println(cityLocation.getLocation("Bordeaux"))
    }
  }

}
