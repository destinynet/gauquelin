/**
 * @author smallufo
 * Created on 2009/3/25 at 上午 2:37:15
 */
package destiny.data.gauquelin.weka.anglePower_aspect

import destiny.astrology.*
import destiny.astrology.Aspect.Importance
import destiny.core.calendar.ILocation
import destiny.data.gauquelin.RefUtil
import destiny.data.gauquelin.UtilHoroscopeAnglePower
import destiny.data.gauquelin.weka.InstanceIF
import weka.core.Instance
import weka.core.Instances
import java.io.InputStreamReader
import java.time.chrono.ChronoLocalDateTime
import java.util.*

class TimeLocation_AnglePower_Instance(horoscopeImpl: IHoroscope, time: ChronoLocalDateTime<*>, location: ILocation) : InstanceIF {
  private val horoscope: Horoscope

  init {
    if (instances == null)
      parseInstances()

    //    HoroscopeContextBean bean = new HoroscopeContextBean();
    //    this.horoscopeContext = bean.getHoroscopeContextPlacidus(time , location);

    val pointSet = setOf<Point>(*Planets.array,*Asteroids.array,*Hamburgers.array,*FixedStars.array,*LunarNodes.meanArray)

    this.horoscope = horoscopeImpl.getHoroscope(time, location, pointSet as Collection<Point> , HouseSystem.PLACIDUS, Centric.GEO, Coordinate.ECLIPTIC, 0.0, 1013.25)
  }

  private fun parseInstances() {
    val `is` = javaClass.getResourceAsStream("anglePower_aspect.arff")
    val reader = InputStreamReader(`is`)

    try {
      instances = Instances(reader)
      instances!!.setClassIndex(instances!!.numAttributes() - 1)

      /*
      Enumeration<Attribute> e = instances.enumerateAttributes();
      while(e.hasMoreElements())
      {
        System.out.println(e.nextElement());
      }
      */
    } catch (e: Exception) {
      println("Exception : " + e)
    }

  }

  /**
   * 這是 anglePower + Aspect 的 instance
   */
  override fun getInstance(): Instance {
    val instance = Instance(instances!!.numAttributes())
    instance.setDataset(instances)

    // ================ AnglePower =================
    //horoscopeContext.setHouseSystem(HouseSystem.PLACIDUS);
    val util = UtilHoroscopeAnglePower(horoscope)
    val anglePower = util.anglePower
    val refUtil = RefUtil(anglePower)
    for (p in Planets.array) {
      val planetDirStr = p.toString(Locale.ENGLISH).toLowerCase() + "Dir"
      val planetDir = instances!!.attribute(planetDirStr)
      instance.setValue(planetDir, refUtil.getValue(p.toString(Locale.ENGLISH)) as String)

      val planetPowerStr = p.toString(Locale.ENGLISH).toLowerCase() + "Power"
      val planetPower = instances!!.attribute(planetPowerStr)
      instance.setValue(planetPower, refUtil.getValue(p.toString(Locale.ENGLISH).toLowerCase() + "Power") as Double)
    }

    // ============ Aspect ============
    val aspectCalculator = HoroscopeAspectsCalculator(horoscope, HoroscopeAspectsCalculatorModern())

    for (data in aspectCalculator.getAspectDataSet(Arrays.asList(*Planets.array), Aspect.getAngles(Importance.HIGH))) {
      var aspectString = data.aspect!!.toString(Locale.ENGLISH)
      val twoPoints = TreeSet(data.twoPoints)
      val it = twoPoints.iterator()
      val p1 = it.next()
      val p2 = it.next()
      val propName = p1.toString(Locale.ENGLISH).toLowerCase() + p2.toString(Locale.ENGLISH)

      //看看是否有此 Attribute
      val attr = instances!!.attribute(propName)
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
    private var instances: Instances? = null
  }


}
