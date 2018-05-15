/**
 * Created by smallufo at 2009/3/19 下午 9:35:58
 */
package destiny.data.gauquelin.weka.house_aspect;

import destiny.astrology.*;
import destiny.astrology.swissephImpl.AzimuthImpl;
import destiny.astrology.swissephImpl.HouseCuspImpl;
import destiny.astrology.swissephImpl.StarPositionWithAzimuthImpl;
import destiny.core.calendar.Location;
import org.junit.Test;
import weka.classifiers.Classifier;
import weka.core.Instance;

import java.time.LocalDateTime;
import java.util.Locale;

public class TimeLocation_House_Aspect_InstanceTest {

  private IHoroscopeContext horoscopeContext;

  @Test
  public void testGetInstance() throws Exception {

    IStarPositionWithAzimuth starPositionWithAzimuthImpl = new StarPositionWithAzimuthImpl(new AzimuthImpl());
    IHouseCusp houseCuspImpl = new HouseCuspImpl();

    horoscopeContext = new HoroscopeContext(IHoroscopeContext.Companion.getDefaultPoints(), HouseSystem.PLACIDUS, Coordinate.ECLIPTIC, Centric.GEO, starPositionWithAzimuthImpl, houseCuspImpl);

    for (int i = 1; i <= 1; i++) {
      TimeLocation_House_Aspect_Instance tli = new TimeLocation_House_Aspect_Instance(horoscopeContext, LocalDateTime.of(2000, 9, i, 0, 0, 0), Location.Companion.of(Locale.TAIWAN));
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
