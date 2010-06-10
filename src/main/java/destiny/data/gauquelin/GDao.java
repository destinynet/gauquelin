/**
 * @author smallufo 
 * Created on 2009/3/5 at 下午 9:53:25
 */ 
package destiny.data.gauquelin;

import java.util.List;

import javax.ejb.Remote;

import destiny.utils.AbstractDao;

@Remote
public interface GDao extends AbstractDao<GPerson>
{
  //public Serializable create(GPerson p);
  
  //public GPerson getById(Serializable key);
  
  public void delete(GPersonHouse h);
  
  
  public long getCount();
  public List<GPerson> findAll();
  public List<GPerson> findAll(int start , int count);
  
  public long getCount(String category);
  public List<GPerson> findAllByCategory(String category);
  public List<GPerson> findAllByCategory(String category , int start , int count);
}
