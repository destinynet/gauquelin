/**
 * @author smallufo 
 * Created on 2009/3/5 at 下午 9:53:25
 */ 
package destiny.data.gauquelin;

import java.io.Serializable;
import java.util.List;

public interface GDao
{
  public Serializable create(GPerson p);
  
  public GPerson getById(Serializable key);
  
  public void update(GPerson p);
  
  public void delete(GPerson p);
  public void delete(GPersonHouse h);
  
  
  public long getCount();
  public List<GPerson> findAll();
  public List<GPerson> findAll(int start , int count);
  
  public long getCount(String category);
  public List<GPerson> findAllByCategory(String category);
  public List<GPerson> findAllByCategory(String category , int start , int count);
}
