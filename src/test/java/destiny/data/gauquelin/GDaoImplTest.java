/**
 * @author smallufo
 * Created on 2010/3/19 at 下午9:59:16
 */
package destiny.data.gauquelin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:gauquelin.xml"})
@TransactionConfiguration(transactionManager="transactionManagerGauquelin")
public class GDaoImplTest
{
  @Inject
  private EntityManagerFactory gauquelinEntityManagerFactory;
  
  @Inject
  private GDao gDao;
  
  @Test
  public void testEmf()
  {
    assertNotNull(gauquelinEntityManagerFactory);
  }
  
  @Transactional()
  @Test
  public void testGetHouseMap()
  {
    GPerson gperson = gDao.get(1L);
    assertEquals(7,gperson.getHouseMap().size());
  }
  
  @Transactional()
  @Test
  public void testFindAll()
  {
    List<GPerson> persons = gDao.findAll(0, 10);
    for(GPerson gp : persons)
    {
      System.out.println(gp);
      System.out.println("\t houseMapSize = " + gp.getHouseMap().size());
    }
  }

  @Test
  public void testGetById()
  {
    assertNotNull(gDao);
    GPerson gperson = gDao.get(1L);
    assertSame(1 , gperson.getNumber());
    assertEquals("Alard Pierre",gperson.getName());
    assertSame(-1 , gperson.getGender());
    assertEquals("BORDEAUX" , gperson.getPlace());
  }
  
  @Test
  public void testGetCount()
  {
    assertEquals(25478 , gDao.getCount());
  }
  
}
