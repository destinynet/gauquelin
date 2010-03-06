/**
 * Created by smallufo at 2009/3/17 下午 9:55:31
 */
package destiny.data;

import java.util.Locale;

import destiny.utils.AbstractSpringTest;

public class GeolocationFinderYahooImplTest extends AbstractSpringTest
{
  protected GeolocationFinder geolocationFinder;
  
  public void testGetLocation()
  {
    //System.out.println(geolocationFinder.getLocation("Taipei", Locale.TAIWAN));
    //System.out.println(geolocationFinder.getLocation("Tainan City", Locale.TAIWAN));
    assertNotNull(geolocationFinder.getLocation("Taipei", Locale.TAIWAN));
    assertNotNull(geolocationFinder.getLocation("Tainan City", Locale.TAIWAN));
  }

}
