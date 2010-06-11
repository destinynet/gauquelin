/**
 * @author smallufo
 * Created on 2010/3/18 at 下午10:21:49
 */
package destiny.data.gauquelin;

import org.springframework.test.jpa.AbstractJpaTests;

@Deprecated
public class AbstractGauquelinTest extends AbstractJpaTests
{
  public AbstractGauquelinTest()
  {
    setDependencyCheck(false);
    setAutowireMode(AUTOWIRE_BY_NAME); 
    
    setPopulateProtectedVariables(true);
    setDefaultRollback(false);
  }

  @Override
  protected String[] getConfigLocations()
  {
    return new String[] {"gauquelin.xml"};
  }
}
