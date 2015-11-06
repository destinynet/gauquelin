/**
 * Created by smallufo at 2009/3/17 下午 10:41:31
 */
package destiny.data.gauquelin;

import javax.inject.Inject;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import destiny.tools.location.GeolocationFinder;
import destiny.data.GeolocationFinderYahooImpl;
import destiny.tools.location.TimeZoneService;
import destiny.web.yahoo.AppData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:core.xml"})
public class SuccessfulFrench2154ReaderTest 
{
  protected GeolocationFinder geolocationFinder;

  @Inject
  private TimeZoneService timeZoneService;
  
  protected void _setUp() throws Exception
  {
    AppData yahooAppData = new AppData("nK_pLKTIkYXVXPGU4I26K_SDQ1PRSP2q" , "614990115076948b0825ec2dbb9a4530");
    geolocationFinder = new GeolocationFinderYahooImpl(yahooAppData, timeZoneService);
  }

  
  public void _testSuccessfulFrench2154Reader()
  {
    TextDataReader reader = new SuccessfulFrench2154Reader(geolocationFinder);
    reader.getPersons();
  }

  
}
