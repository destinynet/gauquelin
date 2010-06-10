/**
 * @author smallufo
 * Created on 2010/6/10 at 上午1:19:23
 */
package destiny.data.gauquelin;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class GDaoImpl2JpaTest
{
  @Test
  public void testGetById()
  {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("gauquelin");
    System.out.println("emf = " + emf);
    
    EntityManager em = emf.createEntityManager();
    System.out.println("em = " + em);
  }
}
