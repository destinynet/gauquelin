/**
 * @author smallufo
 * Created on 2010/3/19 at 下午9:59:16
 */
package destiny.data.gauquelin

import destiny.tools.spring.get
import org.springframework.data.domain.PageRequest
import org.springframework.transaction.annotation.Transactional
import javax.inject.Inject
import javax.persistence.EntityManagerFactory
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertSame

class GDaoImplTest : AbstractGauquelinTest() {

  @Inject
  private lateinit var emfGauquelin: EntityManagerFactory

  @Test
  fun testEmf() {
    assertNotNull(emfGauquelin)
    logger.info("emf = {}" , emfGauquelin)
  }

  /** 若不加上 @Transactional() , 則無法抓到 collections  */
  @Transactional
  @Test
  fun testGetHouseMap() {
    val gPerson = gDao.get(1L)!!
    assertEquals(7, gPerson.houseMap.size.toLong())
  }

  /** 若不加上 @Transactional() , 則無法抓到 collections  */
  @Transactional
  @Test
  fun testFindAll() {
    val persons = gDao.findAll(PageRequest.of(0 , 10))
    //val persons = gDao.findAll(0, 10)
    for (gp in persons) {
      println(gp)
      println("\t houseMapSize = " + gp.houseMap.size)
    }
  }

  @Test
  fun testGetById() {
    assertNotNull(gDao)
    val gPerson = gDao.get(1L)!!
    assertSame(1, gPerson.number)
    assertEquals("Alard Pierre", gPerson.name)
    assertSame(-1, gPerson.gender)
    assertEquals("BORDEAUX", gPerson.place)
  }

  @Test
  fun testGetCount() {
    assertEquals(25478, gDao.count())
  }

}
