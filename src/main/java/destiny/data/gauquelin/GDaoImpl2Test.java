/**
 * @author smallufo
 * Created on 2010/3/19 at 下午9:59:16
 */
package destiny.data.gauquelin;

import junit.framework.TestCase;

public class GDaoImpl2Test extends TestCase
{

  public void testGetById()
  {
    GDaoImpl2 gdao = new GDaoImpl2();
    GPerson gperson = gdao.getById(1L);
    System.out.println(gperson);
  }

}
