/**
 * @author smallufo
 * Created on 2010/3/19 at 下午10:11:57
 */
package destiny.data.gauquelin;

import org.springframework.test.jpa.AbstractJpaTests;

public abstract class AbstractGauquelinSpringJpaTest extends AbstractJpaTests
{
  public AbstractGauquelinSpringJpaTest()
  {
    setDependencyCheck(false);
    setAutowireMode(AUTOWIRE_BY_NAME); 
    
    setPopulateProtectedVariables(true);
    setDefaultRollback(false);
  }
  
  @Override
  protected final String[] getConfigLocations()
  {
    return new String[] {"gauquelin.xml"};
  }

}
