/**
 * Created by smallufo at 2009/3/19 下午 7:50:54
 */
package destiny.data.gauquelin.weka.house_aspect

import destiny.data.gauquelin.GDao
import destiny.data.gauquelin.GPerson
import destiny.tools.spring.get
import weka.classifiers.Classifier

//TODO : JUnit4
class GPersonInstanceTest {

  protected lateinit var gDao: GDao

  @Throws(Exception::class)
  fun testGetInstance() {
    val gperson: GPerson = gDao.get(8943L)!!
    println("gPerson = $gperson")
    val inst = GPersonInstance(gperson)
    val instance = inst.instance
    println(instance)
    val c: Classifier = WekaWrapper()
    val fDistribution = c.distributionForInstance(instance)
    for (d in fDistribution) println("d = $d")
  }
}
