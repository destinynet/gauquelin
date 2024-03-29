/**
 * Created by smallufo at 2009/3/19 下午 9:16:36
 */
package destiny.data.gauquelin.weka.house_aspect

import destiny.core.astrology.HoroscopeConfig
import destiny.core.astrology.IAspectsCalculator
import destiny.core.astrology.IHoroscopeModel
import destiny.core.astrology.Planet
import destiny.core.calendar.Location
import destiny.core.toString
import destiny.data.gauquelin.weka.InstanceIF
import destiny.tools.Feature
import destiny.tools.getTitle
import weka.core.Instance
import weka.core.Instances
import java.io.File
import java.io.FileReader
import java.time.LocalDateTime
import java.util.*

/** 從 time , location 取得 instance  */
class TimeLocation_House_Aspect_Instance(
  horoscopeFeature: Feature<HoroscopeConfig, IHoroscopeModel>,
  time: LocalDateTime, location: Location,
  private val aspectsCalculator : IAspectsCalculator) : InstanceIF {
  private val horoscope: IHoroscopeModel = horoscopeFeature.getModel(time, location)


  private fun getInstancesFromFile() : Instances {

    val url = TimeLocation_House_Aspect_Instance::class.java.getResource("anglePower_aspect.arff")
    val file = File(url.toURI())
    val fReader = FileReader(file)
    val instances = Instances(fReader)
    instances.setClassIndex(instances.numAttributes() - 1)

    val e = instances.enumerateAttributes()
    while (e.hasMoreElements()) {
      println(e.nextElement())
    }
    return instances
  }


  /**
   * 這是 House + Aspect 的 instance
   */
  override fun getInstance(): Instance {

    val instances = getInstancesFromFile()
    val instance = Instance(instances.numAttributes())

    instance.setDataset(instances)


    // ============ House =============
    //horoscopeContext.setHouseSystem(HouseSystem.PLACIDUS);
    for (p in Planet.values) {
      val attrString = p.toString(Locale.ENGLISH).lowercase(Locale.getDefault())
      val attr = instances.attribute(attrString)
      val house = horoscope.getHouse(p)
      if (house != null) {
        instance.setValue(attr, house.toString())
      }
    }

    // ============ Aspect ============
    //val aspectCalculator = HoroscopeAspectsCalculatorModern()

    for (data in aspectsCalculator.getAspectDataSet(horoscope.positionMap, Planet.list)) {
      var aspectString = data.aspect.getTitle(Locale.ENGLISH)
      val twoPoints = TreeSet(data.points)
      val it = twoPoints.iterator()
      val p1 = it.next()
      val p2 = it.next()
      val propName = p1.toString(Locale.ENGLISH).lowercase(Locale.getDefault()) + p2.toString(Locale.ENGLISH)

      //看看是否有此 Attribute
      val attr = instances.attribute(propName)
      if (attr != null) {
        if (aspectString.equals("Square", ignoreCase = true) || aspectString.equals("Opposition", ignoreCase = true))
          aspectString = "SquareOpposition"
        else if (aspectString.equals("Sextile", ignoreCase = true) || aspectString.equals("Trine", ignoreCase = true))
          aspectString = "SextileTrine"

        instance.setValue(attr, aspectString)
      }
    } // each aspect data


    return instance
  }

  companion object {

    //private var instances: Instances? = null
  }

}
