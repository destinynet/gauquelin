/**
 * Created by smallufo at 2009/3/16 下午 9:01:41
 */
package destiny.data.gauquelin.weka

import destiny.data.gauquelin.GDao
import destiny.data.gauquelin.GPerson
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.transaction.annotation.Transactional
import java.util.*
import javax.inject.Inject
import kotlin.test.Test

@ExtendWith(SpringExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ContextConfiguration(locations = ["classpath:mining.xml"])
@Transactional(transactionManager = "transactionManagerGauquelin")
class ArffOutputerHouseAspectTest {
  @Inject
  protected var gDao: GDao? = null

  /** 從資料庫 讀入所有 data , 輸出成 arff , 慢！別跑  */
  @Test
  fun testArffOutputer() {
    val persons = Collections.synchronizedList(ArrayList<GPerson>())
    persons.addAll(gDao!!.findAllByCategory("sport"))
    persons.addAll(gDao!!.findAllByCategory("scientist"))
    persons.addAll(gDao!!.findAllByCategory("military"))
    persons.addAll(gDao!!.findAllByCategory("painter"))
    persons.addAll(gDao!!.findAllByCategory("musician"))
    persons.addAll(gDao!!.findAllByCategory("actor"))
    persons.addAll(gDao!!.findAllByCategory("politician"))
    persons.addAll(gDao!!.findAllByCategory("writer"))
    persons.addAll(gDao!!.findAllByCategory("journalist"))
    //persons.addAll(gDao.findAllByCategory("executive"));
    ArffOutputerHouseAspect(persons, "persons-house-aspect.arff")
  }
}
