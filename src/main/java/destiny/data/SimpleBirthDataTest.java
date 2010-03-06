/**
 * @author smallufo 
 * Created on 2008/7/26 at 上午 4:03:55
 */ 
package destiny.data;

import junit.framework.TestCase;
import destiny.core.Gender;

public class SimpleBirthDataTest extends TestCase
{
  public void testSimpleBirthData2()
  {
    SimpleBirthData data1 = new SimpleBirthData(Gender.男 , 2008 , 7 , 26);
    assertEquals("男/2008/7/26" , data1.toString());
  }
}
