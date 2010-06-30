/** 2009/12/26 下午9:18:42 by smallufo */
package destiny.data.mining;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import destiny.core.calendar.Location;
import destiny.core.calendar.Time;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:mining.xml"})
@TransactionConfiguration(transactionManager="transactionManagerMining" , defaultRollback=false)
public class MiningPersonDaoTest
{
  @Inject
  private MiningPersonDao miningPersonDao;
  
  //若不加 @Transactional , 就不會被 commit
  @Transactional
  @Test
  public void testUpdate()
  {
    MiningPerson p = miningPersonDao.get(42L);
    p.setLocationName("愛的小窩");
    miningPersonDao.update(p);
    System.out.println(miningPersonDao.get(42L));
  }
  
  @Test
  public void testGet()
  {
    MiningPerson p = miningPersonDao.get(1L);
    assertNotNull(p);
  }
  
  //如果不加 @Transactional , 就不會刪除
  @Transactional
  @Test
  public void testDelete()
  {
    MiningPerson p = miningPersonDao.get(7L);
    miningPersonDao.delete(p);
    
    MiningPerson p2 = miningPersonDao.get(7L);
    assertNull(p2);
  }
  
  /** 測試儲存使用者，撈出來檢查，再刪除 */
  @Transactional
  @Test
  public void testSaveAndDelete()
  {
    MiningPerson p = new MiningPerson();
    p.setEmail(null);
    p.setGender(true);
    p.setName("Audi TT");
    Time lmt = new Time();
    p.setLmt(lmt.getTimestamp());
    p.setLocation(new Location().getDebugString());
    p.setLocationName("台北市");
    
    p = miningPersonDao.save(p);
    long id = p.getId(); 
    assert(id> 0);
    
    miningPersonDao.delete(p);
    MiningPerson p2 = miningPersonDao.get(id);
    assertNull(p2);
  }
}

