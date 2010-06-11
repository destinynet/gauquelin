/**
 * @author smallufo
 * Created on 2010/6/10 at 上午10:37:59
 */
package destiny.data.gauquelin;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import destiny.utils.AbstractDaoJpaSpringImpl;

//@Repository("gDao")
public class GDaoSpringImpl extends AbstractDaoJpaSpringImpl<GPerson> implements GDao
{
  @Inject
  private EntityManagerFactory gauquelinEntityManagerFactory;
  
  @PersistenceContext(unitName="gauquelin")
  private EntityManager entityManager;

  @PostConstruct
  public void init()
  {
    System.err.println("setEntityManagerFactory to " + gauquelinEntityManagerFactory) ;
    System.err.println("entityManager : " + entityManager);
    super.setEntityManagerFactory(gauquelinEntityManagerFactory);
  }

  @Override
  public void delete(GPersonHouse h)
  {
    getJpaTemplate().remove(h);    
  }

  /*
  @Override
  public List<GPerson> findAll(int start, int count)
  {
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<GPerson> criteria = builder.createQuery(GPerson.class);
    Root<GPerson> personRoot = criteria.from(GPerson.class);
    criteria.select(personRoot);
    return entityManager.createQuery(criteria).setFirstResult(start).setMaxResults(count).getResultList();
  }
  */

  @Override
  public List<GPerson> findAllByCategory(String category)
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<GPerson> findAllByCategory(String category, int start, int count)
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public long getCount(String category)
  {
    // TODO Auto-generated method stub
    return 0;
  }

}
