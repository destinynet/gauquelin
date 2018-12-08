/**
 * Created by smallufo at 2009/3/16 下午 9:01:41
 */
package destiny.data.gauquelin.weka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import destiny.data.gauquelin.GDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import destiny.data.gauquelin.GPerson;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:mining.xml"})
@Transactional(transactionManager="transactionManagerGauquelin")
public class ArffOutputerHouseAspectTest
{
  @Inject
  protected GDao gDao;
  
  /** 從資料庫 讀入所有 data , 輸出成 arff , 慢！別跑 */
  @Test
  public void testArffOutputer()
  {
    List<GPerson> persons = Collections.synchronizedList(new ArrayList<GPerson>());
    persons.addAll(gDao.findAllByCategory("sport"));
    persons.addAll(gDao.findAllByCategory("scientist"));
    persons.addAll(gDao.findAllByCategory("military"));
    persons.addAll(gDao.findAllByCategory("painter"));
    persons.addAll(gDao.findAllByCategory("musician"));
    persons.addAll(gDao.findAllByCategory("actor"));
    persons.addAll(gDao.findAllByCategory("politician"));
    persons.addAll(gDao.findAllByCategory("writer"));
    persons.addAll(gDao.findAllByCategory("journalist"));
    //persons.addAll(gDao.findAllByCategory("executive"));
    new ArffOutputerHouseAspect(persons , "persons-house-aspect.arff");
  }
}
