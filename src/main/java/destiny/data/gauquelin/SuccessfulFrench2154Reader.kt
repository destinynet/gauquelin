/**
 * Created by smallufo at 2009/3/17 下午 7:25:40
 */
package destiny.data.gauquelin

import destiny.core.calendar.Location
import destiny.core.calendar.LocationTools.encode
import destiny.tools.location.IGeocoding
import destiny.tools.location.TimeZoneService
import java.io.*
import java.net.URISyntaxException
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.*

/**
 * <pre>
 * 2154 French Physicians, Military Men and Executives. Serie E, volume 1 : from 1901 to 1963
 * 2154 位成功的 物理學家 , 軍人 , 以及執行長
 * 實際跑出來會有 2161 位，因為有 7 位身兼兩個專長
</pre> *
 */
class SuccessfulFrench2154Reader(private val geocodingImpl: IGeocoding, private val timeZoneService: TimeZoneService) : TextDataReader {
  private val persons = Collections.synchronizedList(ArrayList<GPerson>())
  private fun process() {
    val url = javaClass.getResource("successfulFrench2154.txt")
    val file: File
    var bReader: BufferedReader? = null
    val city = CityLocation()
    try {
      file = File(url.toURI())
      val fReader = FileReader(file)
      bReader = BufferedReader(fReader)
      var line: String? = null
      while (bReader.readLine().also { line = it } != null) {
        if (line != "" && line!![0] != '#') {
          val professions = line!!.substring(8, 13).trim { it <= ' ' }
          //某些人有多個職業
          val profSt = StringTokenizer(professions, ",")
          while (profSt.hasMoreTokens()) {
            val person = GPerson()
            val number = line!!.substring(0, 4).toInt()
            person.number = number
            val pro = profSt.nextToken()
            if (pro.equals("PH", ignoreCase = true)) person.category = "scientist" //物理學家，視為科學家
            else if (pro.equals("EX", ignoreCase = true)) person.category = "executive" //執行長
            else if (pro.equals("MI", ignoreCase = true)) {
              person.category = "military" //軍人
              person.gender = 1 //軍人都是男生
            }
            val name = line!!.substring(17, 49).trim { it <= ' ' }
            person.name = name
            val day = line!!.substring(49, 51).toInt()
            val month = line!!.substring(55, 57).toInt()
            val year = line!!.substring(61, 65).toInt()
            val hour = line!!.substring(69, 71).toInt()
            val min = line!!.substring(72, 74).toInt()
            //System.out.println(year + " / " + month + " / " + day + " " + hour+":"+min);
// 都是 GMT 時間
            val time = LocalDateTime.of(year, month, day, hour, min, 0)
            val ts = Timestamp.valueOf(time)
            person.gmtTimestamp = ts
            val place = line!!.substring(78, 104).trim { it <= ' ' }
            //System.out.println(place);
// 經緯度
            val loc = city.getLocation(place)
            if (loc != null) { //person.setLocation(loc.getDebugString());
              person.location = encode(loc)
              println("Found location (from properties file) for city : $place")
            } else { //利用 yahoo api 尋找
              val location = geocodingImpl.getLocation(place, timeZoneService)
              if (location != null) {
                if (location.finalMinuteOffset < 0 || location.finalMinuteOffset > 60 || location.lngDeg > 10) System.err.println("city = $place ,  location = $location") //地點警告
                else println("city = $place ,  location = $location")
                //當時資料應該都是 GMT0
                val newLoc = Location(location.lat, location.lng, "GMT", location.finalMinuteOffset, location.altitudeMeter)
                //person.setLocation(newLoc.getDebugString());
                person.location = encode(newLoc)
              } else {
                System.err.println("Cannot find location for city : $place")
                //person.setLocation(city.getLocation("Paris").getDebugString());
                person.location = encode(city.getLocation("Paris")!!)
              }
            }
            person.raw = line
            persons.add(person)
          } // each profession
        } // each valid data
      } //each line
    } catch (e: URISyntaxException) {
      e.printStackTrace()
    } catch (e: FileNotFoundException) {
      e.printStackTrace()
    } catch (e: IOException) {
      e.printStackTrace()
    }
  }

  override fun getPersons(): List<GPerson> {
    if (persons.size == 0) process()
    return persons
  }

}