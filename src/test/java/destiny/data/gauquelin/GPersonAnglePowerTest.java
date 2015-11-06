/**
 * @author smallufo 
 * Created on 2009/3/21 at 上午 1:04:35
 */ 
package destiny.data.gauquelin;

import destiny.astrology.Planet;
import org.junit.Test;

public class GPersonAnglePowerTest
{

  @Test
  public void testSetValue()
  {
    GPersonAnglePower g = new GPersonAnglePower();
    System.out.println(g.getSun() + " : " + g.getSunPower());
    g.setValue(Planet.SUN , "north", 0.99);
    System.out.println(g.getSun() + " : " + g.getSunPower());
  }
}
