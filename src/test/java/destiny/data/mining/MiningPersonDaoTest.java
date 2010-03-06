/** 2009/12/26 下午9:18:42 by smallufo */
package destiny.data.mining;

import destiny.core.calendar.Location;
import destiny.core.calendar.Time;
import destiny.utils.AbstractSpringTest;

public class MiningPersonDaoTest extends AbstractSpringTest
{
  protected MiningPersonDao miningPersonDao;
  
  /*
  protected void setTransactionManagerMining(TransactionManager tm)
  {
    System.err.println("setTransactionManagerMining to " + tm);
    this.transactionManager = (PlatformTransactionManager) tm;
  }
  */
  
  public void _testUpdate()
  {
    MiningPerson p = miningPersonDao.get(17L);
    p.setLocationName("總統府啦");
    miningPersonDao.update(p);
    System.out.println(p);
  }
  
  public void _testGetPerson()
  {
    MiningPerson p = miningPersonDao.get(28L);
    System.out.println(p);
  }
  
  public void _testDelete()
  {
    MiningPerson p = miningPersonDao.get(11L);
    miningPersonDao.delete(p);
  }
  
  public void testSavePerson()
  {
    MiningPerson p = new MiningPerson();
    p.setEmail(null);
    p.setGender(true);
    p.setName("ooxx123456789");
    Time lmt = new Time();
    p.setLmt(lmt.getTimestamp());
    p.setLocation(new Location().getDebugString());
    p.setLocationName("台北市");
    
    p = miningPersonDao.save(p);
    System.out.println("person = " + p);
  }
}

