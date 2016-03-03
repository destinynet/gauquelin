/**
 * @author smallufo
 * Created on 2010/3/19 at 下午9:21:27
 */
package destiny.data.gauquelin;

import destiny.tools.AbstractDaoJpaImpl;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Repository(value="gDao")
public class GDaoImpl extends AbstractDaoJpaImpl<GPerson> implements GDao , Serializable
{
  @PersistenceContext(unitName = "gauquelin")
  @Override
  public void setEntityManager(EntityManager em)
  {
    this.em = em;
  }
  
  @Override
  public void delete(GPersonHouse h)
  {
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<GPerson> findAllByCategory(String category)
  {
    return em.createQuery("from GPerson gp where gp.category = :category").setParameter("category", category).getResultList();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<GPerson> findAllByCategory(String category, int start, int count)
  {
    return em.createQuery("from GPerson gp where gp.category = :category").setParameter("category", category).setFirstResult(start).setMaxResults(count).getResultList();
  }

  @Override
  public long getCount(String category)
  {
    Number n = (Number) em.createQuery("select count(*) from GPerson gp where gp.category = :category").setParameter("category", category).getSingleResult();
    return n.longValue();
  }
}
