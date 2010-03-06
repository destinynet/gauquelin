/**
 * Created by smallufo at 2009/3/16 下午 9:01:41
 */
package destiny.data.gauquelin.weka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import destiny.data.gauquelin.GDao;
import destiny.data.gauquelin.GPerson;
import destiny.utils.AbstractSpringTest;

public class ArffOutputerHouseAspectTest extends AbstractSpringTest
{
  protected GDao gDao;
  
  public void testArffOutputer()
  {
    List<GPerson> persons = Collections.synchronizedList(new ArrayList<GPerson>());
    persons.addAll(gDao.findAllByCategory("sport"));
    persons.addAll(gDao.findAllByCategory("scientist"));
    persons.addAll(gDao.findAllByCategory("military"));
    persons.addAll(gDao.findAllByCategory("painter"));
    persons.addAll(gDao.findAllByCategory("musician"));
    persons.addAll(gDao.findAllByCategory("actor"));
    persons.addAll(gDao.findAllByCategory("politician"));
    persons.addAll(gDao.findAllByCategory("writer"));
    persons.addAll(gDao.findAllByCategory("journalist"));
    //persons.addAll(gDao.findAllByCategory("executive"));
    new ArffOutputerHouseAspect(persons , "persons-house-aspect.arff");
  }
}
