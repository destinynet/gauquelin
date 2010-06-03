/**
 * @author smallufo
 * Created on 2010/3/19 at 下午9:21:27
 */
package destiny.data.gauquelin;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Stateless(name="GDao")
public class GDaoImpl2 implements GDao , Serializable
{
  @PersistenceContext(unitName = "gauquelin", type = PersistenceContextType.EXTENDED)
  protected EntityManager em;
  
  @Override
  public GPerson getById(Serializable key)
  {
    return em.find(GPerson.class , key);
  }
  
  @Override
  public Serializable create(GPerson p)
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void delete(GPerson p)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(GPersonHouse h)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public List<GPerson> findAll()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<GPerson> findAll(int start, int count)
  {
    // TODO Auto-generated method stub
    return null;
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
  public long getCount()
  {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public long getCount(String category)
  {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void update(GPerson p)
  {
    // TODO Auto-generated method stub

  }

}
