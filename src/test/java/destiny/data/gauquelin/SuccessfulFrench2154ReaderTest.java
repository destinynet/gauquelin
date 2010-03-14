/**
 * Created by smallufo at 2009/3/17 下午 10:41:31
 */
package destiny.data.gauquelin;

import destiny.data.GeolocationFinder;
import destiny.utils.AbstractSpringTest;

public class SuccessfulFrench2154ReaderTest extends AbstractSpringTest
{
  protected GeolocationFinder geolocationFinder;

  public void testSuccessfulFrench2154Reader()
  {
    TextDataReader reader = new SuccessfulFrench2154Reader(geolocationFinder);
    reader.getPersons();
  }

}
