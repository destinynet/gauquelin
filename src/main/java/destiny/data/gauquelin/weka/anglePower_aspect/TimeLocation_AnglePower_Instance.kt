/**
 * @author smallufo
 * Created on 2009/3/25 at 上午 2:37:15
 */
package destiny.data.gauquelin.weka.anglePower_aspect

import destiny.astrology.*
import destiny.core.calendar.ILocation
import destiny.data.gauquelin.RefUtil
import destiny.data.gauquelin.UtilHoroscopeAnglePower
import destiny.data.gauquelin.weka.InstanceIF
import weka.core.Instance
import weka.core.Instances
import java.io.InputStreamReader
import java.time.chrono.ChronoLocalDateTime
import java.util.*

class TimeLocation_AnglePower_Instance(
  val horoscopeContext: IHoroscopeContext,

  private val time: ChronoLocalDateTime<*>,
  private val location: ILocation) : InstanceIF  {




  val pointSet = setOf<Point>(*Planet.array,*Asteroid.array,*Hamburger.array,*FixedStar.array,*LunarNode.meanArray)


  val instances: Instances by lazy {
    //javaClass.getResourceAsStream("anglePower_aspect.arff")
    javaClass.getResourceAsStream("/destiny/data/gauquelin/weka/house_aspect/anglePower_aspect.arff").use { iStream ->
      val reader = InputStreamReader(iStream)
      println("parsing anglePower_aspect.arff ...")

      Instances(reader)
    }
  }

  init {
    instances.setClassIndex(instances.numAttributes() - 1)
  }

//  init {
//    if (instances == null)
//      parseInstances()
//  }

//  private fun parseInstances() {
//    val iStream = javaClass.getResourceAsStream("anglePower_aspect.arff")
//    val reader = InputStreamReader(iStream)
//
//    try {
//      instances = Instances(reader)
//      instances!!.setClassIndex(instances!!.numAttributes() - 1)
//
//      /*
//      Enumeration<Attribute> e = instances.enumerateAttributes();
//      while(e.hasMoreElements())
//      {
//        System.out.println(e.nextElement());
//      }
//      */
//    } catch (e: Exception) {
//      println("Exception : $e")
//    }
//
//  }

  /**
   * 這是 anglePower + Aspect 的 instance
   */
  override fun getInstance(): Instance {
    val instance = Instance(instances.numAttributes())
    instance.setDataset(instances)

//    val context = horoContext {
//      points(pointSet)
//    }
    //val context = HoroscopeContext(pointSet, HouseSystem.PLACIDUS, Coordinate.ECLIPTIC, Centric.GEO, starPositionWithAzimuthImpl, houseCuspImpl)
    val horoscope = horoscopeContext.getHoroscope(time , location)

    // ================ AnglePower =================
    //horoscopeContext.setHouseSystem(HouseSystem.PLACIDUS);
    val util = UtilHoroscopeAnglePower(horoscope)
    val anglePower = util.anglePower
    val refUtil = RefUtil(anglePower)
    for (p in Planet.array) {
      val planetDirStr = p.toString(Locale.ENGLISH).toLowerCase() + "Dir"
      val planetDir = instances.attribute(planetDirStr)
      instance.setValue(planetDir, refUtil.getValue(p.toString(Locale.ENGLISH)) as String)

      val planetPowerStr = p.toString(Locale.ENGLISH).toLowerCase() + "Power"
      val planetPower = instances.attribute(planetPowerStr)
      instance.setValue(planetPower, refUtil.getValue(p.toString(Locale.ENGLISH).toLowerCase() + "Power") as Double)
    }

    // ============ Aspect ============
    val aspectCalculator = HoroscopeAspectsCalculatorModern()

    for (data in aspectCalculator.getAspectDataSet(horoscope.positionMap, Planet.list)) {
      var aspectString = data.aspect.toString(Locale.ENGLISH)
      val twoPoints = TreeSet(data.points)
      val it = twoPoints.iterator()
      val p1 = it.next()
      val p2 = it.next()
      val propName = p1.toString(Locale.ENGLISH).toLowerCase() + p2.toString(Locale.ENGLISH)

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
