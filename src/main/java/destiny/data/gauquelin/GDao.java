/**
 * @author smallufo 
 * Created on 2009/3/5 at 下午 9:53:25
 */ 
package destiny.data.gauquelin;

import java.util.List;

import destiny.utils.AbstractDao;

public interface GDao extends AbstractDao<GPerson>
{
  public void delete(GPersonHouse h);
  
  public long getCount(String category);
  public List<GPerson> findAllByCategory(String category);
  public List<GPerson> findAllByCategory(String category , int start , int count);
}
