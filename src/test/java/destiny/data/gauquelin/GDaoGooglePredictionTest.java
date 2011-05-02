/**
 * @author smallufo
 * Created on 2011/5/1 at 上午9:29:53
 */
package destiny.data.gauquelin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/** 將資料庫中的 GPerson , 輸出成 Google Prediction API 所需的 CSV 格式檔 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:gauquelin.xml"})
@TransactionConfiguration(transactionManager="transactionManagerGauquelin" , defaultRollback=false)
public class GDaoGooglePredictionTest
{
  @Inject
  private GDao dao;

  @Test
  @Transactional(readOnly=true)
  public void testPredict() throws IOException
  {
    GPerson p = dao.get(13916L);
    System.out.println(p.getCSV());
  }
  
  /** 2011/5/1 只輸出「工作」「奇數」的資料  。作為初步的成品。跑起來全部費時 2.6 小時 
   * 一半的資料就有 9271 rows */
  @Test
  @Transactional(readOnly=true)
  public void testExportJobCsvOdd() throws IOException
  {
    long t = System.currentTimeMillis();
    FileOutputStream fos = new FileOutputStream(new File("gauquelinJobOdd.csv") );
    PrintStream ps = new PrintStream(fos);
    this.processJob(fos, ps, "actor");
    this.processJob(fos, ps, "executive");
    this.processJob(fos, ps, "journalist");
    this.processJob(fos, ps, "military");
    this.processJob(fos, ps, "musician");
    this.processJob(fos, ps, "painter");
    this.processJob(fos, ps, "politician");
    this.processJob(fos, ps, "scientist");
    this.processJob(fos, ps, "sport");
    this.processJob(fos, ps, "writer");
    
    ps.close();
    fos.close();
    System.out.println("全部費時 " + (System.currentTimeMillis() - t)/1000L + " 秒");
  }
  
  private void processJob(FileOutputStream fos , PrintStream ps , String job) throws IOException
  {
    long total = dao.getCount(job);
    int size = 10;
    long pages = total / size +1;
    System.out.println("job = " + job + " , total = " + total + " , pages = " + pages);
    long t = System.currentTimeMillis();
    
    for(int page = 0 ; page <= pages ; page++)
    {
      for(GPerson p : dao.findAllByCategory(job, page*size , size))
      {
        if (p.getId() % 2 == 1)
        {
          ps.println(p.getCSV());
          //System.out.println(p.getCSV());          
        }
      }
      fos.flush();
    }
    System.out.println("處理 job " + job + " , 費時 " + (System.currentTimeMillis() -t)/1000L + " 秒");
  }
  
  /** (useless) 輸出所有 25478 筆資料，成 csv 格式。 跑起來很慢，花費  4.84 小時 */ 
  @Test
  @Transactional(readOnly=true)
  public void testExportCSV() throws IOException
  {
    FileOutputStream fos = new FileOutputStream(new File("gauquelinAll.csv"));
    long total = dao.getCount();
    int size = 10;
    long pages = total / size ;
    System.out.println("total = " + total + " , pages = " + pages);
    long t = System.currentTimeMillis();
    
    PrintStream ps = new PrintStream(fos); 
    for(int page = 0 ; page <= pages ; page++)
    {
      for(GPerson p : dao.findAll(page*size, size))
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
  @Transactional(readOnly=true)
  public void testExportCsvOdd() throws IOException
  {
    FileOutputStream fos = new FileOutputStream(new File("gauquelinOdd.csv"));
    long total = dao.getCount();
    int size = 10;
    long pages = total / size ;
    System.out.println("total = " + total + " , pages = " + pages);
    long t = System.currentTimeMillis();
    
    PrintStream ps = new PrintStream(fos); 
    for(int page = 0 ; page <= pages ; page++)
    {
      for(GPerson p : dao.findAll(page*size, size))
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
