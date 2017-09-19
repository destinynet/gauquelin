/**
 * @author smallufo 
 * Created on 2009/3/25 at 上午 2:39:47
 */
package destiny.data.gauquelin.weka.anglePower_aspect;

import destiny.astrology.*;
import destiny.astrology.swissephImpl.AzimuthImpl;
import destiny.astrology.swissephImpl.HouseCuspImpl;
import destiny.astrology.swissephImpl.StarPositionWithAzimuthImpl;
import destiny.core.calendar.Location;
import org.junit.Before;
import org.junit.Test;
import weka.classifiers.Classifier;
import weka.core.Instance;

import java.time.LocalDateTime;

public class TimeLocation_AnglePower_InstanceTest
{
  private IHoroscope horoscopeImpl;

  private AzimuthIF azimuthImpl = new AzimuthImpl();

  private StarPositionWithAzimuthIF starPositionImpl = new StarPositionWithAzimuthImpl(azimuthImpl);

  private HouseCuspIF houseCuspImpl = new HouseCuspImpl();

  @Before
  public void init() {

    horoscopeImpl = new HoroscopeImpl(starPositionImpl , houseCuspImpl);
  }

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
