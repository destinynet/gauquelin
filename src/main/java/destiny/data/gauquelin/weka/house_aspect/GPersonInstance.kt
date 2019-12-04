/**
 * Created by smallufo at 2009/3/19 下午 7:46:29
 */
package destiny.data.gauquelin.weka.house_aspect

import destiny.data.gauquelin.GPerson
import destiny.data.gauquelin.GPersonAspect
import destiny.data.gauquelin.GPersonHouse
import destiny.data.gauquelin.RefUtil
import destiny.data.gauquelin.weka.InstanceIF
import weka.core.Instance
import weka.core.Instances
import java.io.File
import java.io.FileReader

class GPersonInstance(private val gperson: GPerson) : InstanceIF {
  private var instances: Instances? = null
  private fun parseInstances() {
    val url = javaClass.getResource("header.arff")
    val file: File
    try {
      file = File(url.toURI())
      val fReader = FileReader(file)
      instances = Instances(fReader)
      instances!!.setClassIndex(instances!!.numAttributes() - 1)
    } catch (e: Exception) {
      e.printStackTrace()
    }
  }

  override fun getInstance(): Instance {
    System.err.println("instances = $instances")
    val instance = Instance(instances!!.numAttributes())
    instance.setDataset(instances)
    //====================== House ==========================
    val house = gperson.houseMap["placidus"]
    for (prop in RefUtil.getProperties(GPersonHouse::class.java)) {
      val attr = instances!!.attribute(prop)
      if (attr != null) { //System.out.println(prop + " : " + getValue(house, prop));
        val r = RefUtil(house)
        instance.setValue(attr, r.getValue(prop).toString())
      }
    }
    //====================== Aspect ==========================
    for (prop in RefUtil.getProperties(GPersonAspect::class.java)) {
      val attr = instances!!.attribute(prop)
      if (attr != null) {
        val r = RefUtil(gperson.aspect)
        val value = r.getValue(prop)
        if (value != null) {
          var aspectString = value.toString()
          if (aspectString.equals("Square", ignoreCase = true) || aspectString.equals("Opposition", ignoreCase = true)) aspectString = "SquareOpposition" else if (aspectString.equals("Sextile", ignoreCase = true) || aspectString.equals("Trine", ignoreCase = true)) aspectString = "SextileTrine"
          instance.setValue(attr, aspectString)
        }
      }
    }
    return instance
  }

  init {
    if (instances == null) parseInstances()
  }
}
