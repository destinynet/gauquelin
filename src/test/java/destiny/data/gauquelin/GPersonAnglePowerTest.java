/**
 * @author smallufo 
 * Created on 2009/3/21 at 上午 1:04:35
 */ 
package destiny.data.gauquelin;

import junit.framework.TestCase;
import destiny.astrology.Planet;

public class GPersonAnglePowerTest extends TestCase
{

  public void testSetValue()
  {
    GPersonAnglePower g = new GPersonAnglePower();
    System.out.println(g.getSun() + " : " + g.getSunPower());
    g.setValue(Planet.SUN , "north", 0.99);
    System.out.println(g.getSun() + " : " + g.getSunPower());
  }
}
