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
import java.util.Locale;

public class TimeLocation_AnglePower_InstanceTest
{
  private IHoroscope horoscopeImpl;

  private IAzimuth azimuthImpl = new AzimuthImpl();

  private IStarPositionWithAzimuth starPositionImpl = new StarPositionWithAzimuthImpl(azimuthImpl);

  private IHouseCusp houseCuspImpl = new HouseCuspImpl();

  @Before
  public void init() {

    horoscopeImpl = new HoroscopeImpl(starPositionImpl , houseCuspImpl);
  }

  @Test
  public void testGetInstance() throws Exception
  {
    for (int i=1 ; i<=30 ; i++) {
      TimeLocation_AnglePower_Instance tli = new TimeLocation_AnglePower_Instance(horoscopeImpl, LocalDateTime.of(1900, 7, i, i, 0, 0), Location.Companion.of(Locale.TAIWAN));
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
