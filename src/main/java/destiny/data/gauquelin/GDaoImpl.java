/**
 * @author smallufo
 * Created on 2010/3/19 at 下午9:21:27
 */
package destiny.data.gauquelin;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import destiny.utils.AbstractDaoJpaImpl;

@Repository(value="gDao")
public class GDaoImpl extends AbstractDaoJpaImpl<GPerson> implements GDao , Serializable
{
  @PersistenceContext(unitName = "gauquelin")
  @Override
  public void setEntityManager(EntityManager em)
  {
    //System.err.println("setEntityManager , em = " + em);
    this.em = em;
  }
  
  @Override
  public void delete(GPersonHouse h)
  {
    // TODO Auto-generated method stub

  }

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
