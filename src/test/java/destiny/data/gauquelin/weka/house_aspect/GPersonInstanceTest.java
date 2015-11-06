/**
 * Created by smallufo at 2009/3/19 下午 7:50:54
 */
package destiny.data.gauquelin.weka.house_aspect;

import weka.classifiers.Classifier;
import weka.core.Instance;
import destiny.data.gauquelin.GDao;
import destiny.data.gauquelin.GPerson;

//TODO : JUnit4
public class GPersonInstanceTest
{
  protected GDao gDao;

  public void testGetInstance() throws Exception
  {
    GPerson gperson = gDao.get(8943L).get();
    System.out.println("gperson = " + gperson);
    GPersonInstance inst = new GPersonInstance(gperson);
    Instance instance = inst.getInstance();
    System.out.println(instance);
    
    Classifier c = new WekaWrapper();
    double[] fDistribution = c.distributionForInstance(instance);
    for (double d : fDistribution)
      System.out.println("d = " + d);
  }

}
