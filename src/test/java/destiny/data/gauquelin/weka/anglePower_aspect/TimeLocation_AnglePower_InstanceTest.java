/**
 * @author smallufo 
 * Created on 2009/3/25 at 上午 2:39:47
 */
package destiny.data.gauquelin.weka.anglePower_aspect;

import destiny.core.calendar.Location;
import org.junit.Test;
import weka.classifiers.Classifier;
import weka.core.Instance;

import java.time.LocalDateTime;

public class TimeLocation_AnglePower_InstanceTest
{
  @Test
  public void testGetInstance() throws Exception
  {
    for (int i=0 ; i<=100 ; i++) {
      TimeLocation_AnglePower_Instance tli = new TimeLocation_AnglePower_Instance(horoscopeImpl, LocalDateTime.of(1900, 7, i, i, 0, 0), new Location());
      Instance instance = tli.getInstance();
      //System.out.println(instance);

      Classifier c = new WekaWrapper();
      double[] fDistribution = c.distributionForInstance(instance);
      for (double d : fDistribution)
        System.out.print("d = " + d + " \t");
      System.out.println();  
    }
  }
}
