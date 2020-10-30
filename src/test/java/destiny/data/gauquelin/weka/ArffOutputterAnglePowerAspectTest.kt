/**
 * @author smallufo
 * Created on 2009/3/21 at 下午 3:12:57
 */
package destiny.data.gauquelin.weka

import destiny.data.gauquelin.GDao
import destiny.data.gauquelin.GPerson
import java.util.*

//TODO : JUnit4
class ArffOutputterAnglePowerAspectTest {
  protected lateinit var gDao: GDao
  fun testOutputter() {
    val persons = Collections.synchronizedList(ArrayList<GPerson>())
    persons.addAll(gDao.findAllByCategory("sport"))
    persons.addAll(gDao.findAllByCategory("scientist"))
    persons.addAll(gDao.findAllByCategory("military"))
    persons.addAll(gDao.findAllByCategory("painter"))
    persons.addAll(gDao.findAllByCategory("musician"))
    persons.addAll(gDao.findAllByCategory("actor"))
    //persons.addAll(gDao.findAllByCategory("politician"));
    persons.addAll(gDao.findAllByCategory("writer"))
    persons.addAll(gDao.findAllByCategory("journalist"))
    //persons.addAll(gDao.findAllByCategory("executive"));
    ArffOutputterAnglePowerAspect(persons, "persons-anglePower-aspect.arff")
  }
}
