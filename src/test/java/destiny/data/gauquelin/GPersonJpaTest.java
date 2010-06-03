/**
 * @author smallufo
 * Created on 2010/3/19 at 上午11:14:15
 */
package destiny.data.gauquelin;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bm.datagen.Generator;
import com.bm.datagen.annotations.GeneratorType;
import com.bm.datagen.relation.BeanCollectionGenerator;
import com.bm.datagen.relation.SingleBeanGenerator;
import com.bm.testsuite.BaseEntityFixture;

public class GPersonJpaTest extends BaseEntityFixture<GPerson>
{
  private static final Generator[] SPECIAL_GENERATORS = {new GPersonHouseCreator() , new GPersonAspectGenerator() , new GPersonAnglePowerGenerator()};
  
  public GPersonJpaTest()
  {
    super(GPerson.class , SPECIAL_GENERATORS);
  }
  
  
  public void _testRun()
  {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("gauquelin");
    EntityManager em = emf.createEntityManager();
    
    GPerson gp = em.find(GPerson.class, 1L);
    assertNotNull(gp);
    
    //System.out.println(gp);
    
    gp = em.find(GPerson.class, 1L);
    Map<String, GPersonHouse>  map = gp.getHouseMap();
    for(String houseType : map.keySet())
    {
      assertNotNull(map.get(houseType));
      //System.out.println(houseType +" : " + map.get(houseType) );
    }
  }
  
  @GeneratorType(className = Map.Entry.class, field = "houseMap")
  public static final class GPersonHouseCreator extends BeanCollectionGenerator<Map.Entry>
  {
    public GPersonHouseCreator()
    {
      super( Map.Entry.class , 10);
    }
  }
  
  @GeneratorType(className = GPersonAspect.class, field = "aspect")
  public static final class GPersonAspectGenerator extends SingleBeanGenerator<GPersonAspect>
  {
    public GPersonAspectGenerator()
    {
      super(GPersonAspect.class);
    }
  }
  
  @GeneratorType(className = GPersonAnglePower.class, field = "anglePower")
  public static final class GPersonAnglePowerGenerator extends SingleBeanGenerator<GPersonAnglePower>
  {
    public GPersonAnglePowerGenerator()
    {
      super(GPersonAnglePower.class);
    }
  }

}
