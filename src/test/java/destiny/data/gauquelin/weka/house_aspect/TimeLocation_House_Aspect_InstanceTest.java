/**
 * Created by smallufo at 2009/3/19 下午 9:35:58
 */
package destiny.data.gauquelin.weka.house_aspect;

import destiny.core.calendar.Location;
import destiny.core.calendar.Time;
import org.junit.Test;
import weka.classifiers.Classifier;
import weka.core.Instance;

public class TimeLocation_House_Aspect_InstanceTest
{
  @Test
  public void testGetInstance() throws Exception
  {
    for (int i = 1 ; i <=1 ; i++)
    {
      TimeLocation_House_Aspect_Instance tli = new TimeLocation_House_Aspect_Instance(new Time(2000,9,i,0,0,0) , new Location());
      Instance instance = tli.getInstance();
      System.out.println(instance);
      
      Classifier c = new WekaWrapper();
      double[] fDistribution = c.distributionForInstance(instance);
      for (double d : fDistribution)
        System.out.print("d = " + d + " \t");
      System.out.println();
  
    }
  }

}
