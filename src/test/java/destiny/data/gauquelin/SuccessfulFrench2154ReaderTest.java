/**
 * Created by smallufo at 2009/3/17 下午 10:41:31
 */
package destiny.data.gauquelin;

import destiny.tools.location.GeocodingIF;
import destiny.tools.location.TimeZoneService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:core.xml"})
public class SuccessfulFrench2154ReaderTest {

  @Inject
  private GeocodingIF geocodingGoogleImpl;

  @Inject
  private TimeZoneService timeZoneService;


  @Test
  public void testSuccessfulFrench2154Reader() {
    TextDataReader reader = new SuccessfulFrench2154Reader(geocodingGoogleImpl, timeZoneService);
    reader.getPersons();
  }
}
