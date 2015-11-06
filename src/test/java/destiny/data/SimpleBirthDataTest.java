/**
 * @author smallufo 
 * Created on 2008/7/26 at 上午 4:03:55
 */ 
package destiny.data;

import destiny.core.Gender;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleBirthDataTest
{
  @Test
  public void testSimpleBirthData2()
  {
    SimpleBirthData data1 = new SimpleBirthData(Gender.男 , 2008 , 7 , 26);
    assertEquals("男/2008-07-26" , data1.toString());
  }
}
