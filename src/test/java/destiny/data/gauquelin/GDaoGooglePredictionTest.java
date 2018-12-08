/**
 * @author smallufo
 * Created on 2011/5/1 at 上午9:29:53
 */
package destiny.data.gauquelin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/** 將資料庫中的 GPerson , 輸出成 Google Prediction API 所需的 CSV 格式檔 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:gauquelin.xml"})
@Transactional(transactionManager="transactionManagerGauquelin")
public class GDaoGooglePredictionTest
{
  @Inject
  private GDao dao;

  @Test
  @javax.transaction.Transactional
  public void testPredict() {
    GPerson p = dao.get(3L);
    System.out.println(p.getCSV());
  }
  
  /** 2011/5/4 ，輸出「工作」，每類工作上限 500人 , 全部 5000 人*/
  @Test
  @javax.transaction.Transactional
  public void testExportJobEach5500() throws IOException
  {
    long t = System.currentTimeMillis();
    FileOutputStream fos = new FileOutputStream(new File("jobs5500.csv") );
    PrintStream ps = new PrintStream(fos);
    int max=550;
    
    this.processJob(fos, ps, "actor" , max , false);
    this.processJob(fos, ps, "executive" , max, false);
    this.processJob(fos, ps, "journalist" , max, false);
    this.processJob(fos, ps, "military" , max, false);
    this.processJob(fos, ps, "musician" , max, false);
    this.processJob(fos, ps, "painter" , max, false);
    this.processJob(fos, ps, "politician" , max, false);
    this.processJob(fos, ps, "scientist" , max, false);
    this.processJob(fos, ps, "sport" , max, false);
    this.processJob(fos, ps, "writer" , max, false);
    
    ps.close();
    fos.close();
    System.out.println("全部費時 " + (System.currentTimeMillis() - t)/1000L + " 秒");
  }
  
  
  /** 2011/5/1 只輸出「工作」「奇數」的資料  。作為初步的成品。跑起來全部費時 2.6 小時 
   * 一半的資料就有 9271 rows */
  @Test
  @javax.transaction.Transactional
  public void testExportJobCsvOdd() throws IOException
  {
    long t = System.currentTimeMillis();
    FileOutputStream fos = new FileOutputStream(new File("gauquelinJobOdd.csv") );
    PrintStream ps = new PrintStream(fos);
    this.processJob(fos, ps, "actor" , Integer.MAX_VALUE , true);
    this.processJob(fos, ps, "executive", Integer.MAX_VALUE, true);
    this.processJob(fos, ps, "journalist", Integer.MAX_VALUE, true);
    this.processJob(fos, ps, "military", Integer.MAX_VALUE, true);
    this.processJob(fos, ps, "musician", Integer.MAX_VALUE, true);
    this.processJob(fos, ps, "painter", Integer.MAX_VALUE, true);
    this.processJob(fos, ps, "politician", Integer.MAX_VALUE, true);
    this.processJob(fos, ps, "scientist", Integer.MAX_VALUE, true);
    this.processJob(fos, ps, "sport", Integer.MAX_VALUE, true);
    this.processJob(fos, ps, "writer", Integer.MAX_VALUE, true);
    
    ps.close();
    fos.close();
    System.out.println("全部費時 " + (System.currentTimeMillis() - t)/1000L + " 秒");
  }
  
  private void processJob(FileOutputStream fos , PrintStream ps , String job , int max , boolean half) throws IOException
  {
    long total = dao.getCount(job);
    if (total > max)
      total = max;
    int size = 10;
    long pages = total / size +1;
    if (total % size == 0)
      pages--;
    
    System.out.println("job = " + job + " , total = " + total + " , pages = " + pages);
    long t = System.currentTimeMillis();
    
    for(int page = 0 ; page < pages ; page++)
    {
      for(GPerson p : dao.findAllByCategory(job, page*size , size))
      {
        if (half)
        {
          if (p.getId() % 2 == 1)
            ps.println(p.getCSV());
        }
        else
          ps.println(p.getCSV());
      }
      fos.flush();
    }
    System.out.println("處理 job " + job + " , 費時 " + (System.currentTimeMillis() -t)/1000L + " 秒");
  }
  
  /** (useless) 輸出所有 25478 筆資料，成 csv 格式。 跑起來很慢，花費  4.84 小時 */ 
  @Test
  @javax.transaction.Transactional
  public void testExportCSV() throws IOException
  {
    FileOutputStream fos = new FileOutputStream(new File("gauquelinAll.csv"));
    long total = dao.count();
    int size = 10;
    long pages = total / size ;
    System.out.println("total = " + total + " , pages = " + pages);
    long t = System.currentTimeMillis();
    
    PrintStream ps = new PrintStream(fos); 
    for(int page = 0 ; page <= pages ; page++)
    {
      Pageable pAble = PageRequest.of(page*size , size);
      for(GPerson p : dao.findAll(pAble))
      {
        //System.out.println(" id = " + p.getId() + " , cat = " + p.getCategory() + " , raw = " + p.getRaw());
        ps.println(p.getCSV());
        //System.out.println(p.getCSV());
      }
      fos.flush();
    }
    ps.close();
    fos.close();
    
    System.out.println("費時 " + (System.currentTimeMillis() - t)/1000L + " 秒");
  }
  
  /** (useless) 輸出「奇數」的資料，成 CSV 格式 。就算只輸出一半，也花費 4.98 小時 */
  @Test
  @javax.transaction.Transactional
  public void testExportCsvOdd() throws IOException
  {
    FileOutputStream fos = new FileOutputStream(new File("gauquelinOdd.csv"));
    long total = dao.count();
    int size = 10;
    long pages = total / size ;
    System.out.println("total = " + total + " , pages = " + pages);
    long t = System.currentTimeMillis();
    
    PrintStream ps = new PrintStream(fos); 
    for(int page = 0 ; page <= pages ; page++)
    {
      Pageable pAble = PageRequest.of(page*size, size);
      for(GPerson p : dao.findAll(pAble))
      {
        if (p.getId() % 2 == 1)
          ps.println(p.getCSV());
      }
      fos.flush();
    }
    ps.close();
    fos.close();
    
    System.out.println("費時 " + (System.currentTimeMillis() - t)/1000L + " 秒");
  }
  
}
