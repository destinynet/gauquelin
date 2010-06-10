/**
 * @author smallufo
 * Created on 2010/3/19 at 下午9:59:16
 */
package destiny.data.gauquelin;

import javax.persistence.EntityManagerFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:gauquelin.xml"})
public class GDaoImplSpringTest 
{
  @Autowired
  private EntityManagerFactory gauquelinEntityManagerFactory;
  
  @Autowired
  private GDao gDao;
  
  @Test
  public void testEmf()
  {
    System.out.println("emf = " + gauquelinEntityManagerFactory);
  }
  
  @Test
  public void testGetById()
  {
    System.out.println("gDao = " + gDao);
    //GDaoImpl2 gdao = new GDaoImpl2();
    //GPerson gperson = gdao.getById(1L);
    //System.out.println(gperson);
  }

}
