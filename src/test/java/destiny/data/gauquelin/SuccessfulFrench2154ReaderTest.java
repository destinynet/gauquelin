/**
 * Created by smallufo at 2009/3/17 下午 10:41:31
 */
package destiny.data.gauquelin;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import destiny.data.GeolocationFinder;
import destiny.data.GeolocationFinderYahooImpl;
import destiny.utils.location.TimeZoneGisgraphyImpl;
import destiny.utils.location.TimeZoneIF;
import destiny.utils.location.TimeZoneService;
import destiny.web.yahoo.AppData;

public class SuccessfulFrench2154ReaderTest extends TestCase
{
  protected GeolocationFinder geolocationFinder;

  protected void _setUp() throws Exception
  {
    AppData yahooAppData = new AppData("nK_pLKTIkYXVXPGU4I26K_SDQ1PRSP2q" , "614990115076948b0825ec2dbb9a4530");
    TimeZoneGisgraphyImpl timeZoneGisgraphyImpl = new TimeZoneGisgraphyImpl("http://db.xfiles.to:9090/geoloc/findnearbylocation");
    List<TimeZoneIF> timeZoneImpls = new ArrayList<TimeZoneIF>();
    timeZoneImpls.add(timeZoneGisgraphyImpl);
    TimeZoneService timeZoneService = new TimeZoneService(timeZoneImpls);

    geolocationFinder = new GeolocationFinderYahooImpl(yahooAppData, timeZoneService);
  }

  
  public void _testSuccessfulFrench2154Reader()
  {
    TextDataReader reader = new SuccessfulFrench2154Reader(geolocationFinder);
    reader.getPersons();
  }

  
}
