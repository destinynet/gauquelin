/**
 * @author smallufo 
 * Created on 2008/11/15 at 上午 12:41:38
 */ 
package destiny.data.causer;

import destiny.astrology.StarPositionIF;
import destiny.astrology.StarTransitIF;
import destiny.astrology.swissephImpl.RiseTransImpl;
import destiny.core.Gender;
import destiny.core.calendar.Location;
import destiny.core.calendar.SolarTermsIF;
import destiny.core.calendar.chinese.ChineseDateIF;
import destiny.core.calendar.eightwords.*;
import destiny.core.calendar.eightwords.personal.FortuneDirectionIF;
import destiny.core.calendar.eightwords.personal.PersonContext;
import destiny.core.chinese.FortuneOutput;
import destiny.core.chinese.StemBranch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.io.*;
import java.time.LocalDateTime;
import java.util.StringTokenizer;

/**
 * 車禍肇事者
 * 1,1,1949,6,26,2007,10,10,1
 * 編號1 , 男性 ,1949/6/26 出生。肇事日期 2007/10/1 清晨1點
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:core.xml"})
public class CauserReader {

//  @Inject
//  private EightWordsContext eightWordsContext;

  @Inject
  private StarPositionIF starPositionImpl;

  @Inject
  private StarTransitIF starTransitImpl;

  @Inject
  private SolarTermsIF solarTermsBean;

  @Inject @Qualifier("houseCuspImpl")
  protected RisingSignIF risingSignImpl;

  @Inject
  private ChineseDateIF chineseDateImpl;

  private YearMonthIF yearMonthImpl = new YearMonthSolarTermsStarPositionImpl(315 , starPositionImpl , starTransitImpl);

  private DayIF dayImpl = new DayImpl();
  private HourIF hourImpl = new HourSolarTransImpl(new RiseTransImpl());
  private MidnightIF midnightImpl = new MidnightSolarTransImpl(new RiseTransImpl());
  
  /** 大運順逆演算法，內定採用「陽男陰女順排；陰男陽女逆排」的演算法 */
  @Inject
  private FortuneDirectionIF fortuneDirectionImpl;

  @Inject
  private EightWordsIF eightWordsImpl;

  private Location location;
  private LocalDateTime lmt;
  
  @Test
  public void testCauserReader()
  {
    location = new Location(Location.EastWest.EAST , 120 , 0 , 0 , Location.NorthSouth.NORTH , 25, 03 , 0 , 0 , "Asia/Taipei" );
    
    File file;
    BufferedReader bReader = null;
    BufferedWriter bWriter = null;
    try
    {
      FileWriter fstream = new FileWriter("www/WEB-INF/out.txt");
      bWriter = new BufferedWriter(fstream);

      file = new File("www/WEB-INF/97010.sort");
      FileReader fReader = new FileReader(file);
      bReader = new BufferedReader(fReader);

      String line = null;
      PersonContext context;
      StemBranch eventStemBranch;
      while ((line = bReader.readLine()) != null)
      {
        StringTokenizer st = new StringTokenizer(line , ", \n");
        
        long l1 = System.currentTimeMillis();
        int index = Integer.valueOf(st.nextToken());
        String man = st.nextToken();
        Gender gender = man.equals("1")? Gender.男 : Gender.女;
        int year = Integer.valueOf(st.nextToken());
        int month = Integer.valueOf(st.nextToken());
        int day = Integer.valueOf(st.nextToken());
        int hour = 12;
        lmt = LocalDateTime.of(year , month , day , hour , 0);
        context = new PersonContext(eightWordsImpl , chineseDateImpl, yearMonthImpl , dayImpl , hourImpl, midnightImpl , true , solarTermsBean, starTransitImpl ,
          lmt , location , null, gender , 120.0 , fortuneDirectionImpl, risingSignImpl, starPositionImpl, FortuneOutput.西元);
        
        StringBuffer sb = new StringBuffer();
        sb.append(index+",");
        sb.append( (gender==Gender.男? "1" : "0") + ",");
        sb.append(year+",");
        sb.append(month+",");
        sb.append(day+",");
        EightWords ew = context.getEightWords();
        sb.append(ew.getYearStem() + ",");
        sb.append(ew.getYearBranch() + ",");
        sb.append(ew.getMonthStem() + ",");
        sb.append(ew.getMonthBranch() + ",");
        sb.append(ew.getDayStem() + ",");
        sb.append(ew.getDayBranch() + ",");
        sb.append(ew.getHourStem() + ",");
        sb.append(ew.getHourBranch() + ",");
        
        
        int eventYear = Integer.valueOf(st.nextToken());
        int eventMonth = Integer.valueOf(st.nextToken());
        int eventDay = Integer.valueOf(st.nextToken());
        int eventHour = Integer.valueOf(st.nextToken());
        int eventMinute = 0;
        int eventSecond = 0;
        //出事日期及時間
        sb.append(eventYear + ",");
        sb.append(eventMonth + ",");
        sb.append(eventDay + ",");
        sb.append(eventHour + ",");
        
        LocalDateTime targetGmt = LocalDateTime.of(eventYear , eventMonth , eventDay , eventHour , eventMinute , eventSecond).minusHours(8);
        eventStemBranch = context.getStemBranchOfFortuneMonth(targetGmt);
        
        //出事大運的干支
        sb.append(eventStemBranch.getStem()+",");
        sb.append(eventStemBranch.getBranch()+",");

        LocalDateTime time = LocalDateTime.of(eventYear , eventMonth , eventDay , eventHour , eventMinute , eventSecond);
        EightWords ew2 = eightWordsImpl.getEightWords(time , location);
        long l2 = System.currentTimeMillis();
        
        //出事時辰的八字
        sb.append(ew2.getYearStem() + ",");
        sb.append(ew2.getYearBranch() + ",");
        sb.append(ew2.getMonthStem() + ",");
        sb.append(ew2.getMonthBranch() + ",");
        sb.append(ew2.getDayStem() + ",");
        sb.append(ew2.getDayBranch() + ",");
        sb.append(ew2.getHourStem() + ",");
        sb.append(ew2.getHourBranch());
        
        System.out.println(sb.toString()+"\n費時 " + (l2-l1)/1000 + " 秒");
        bWriter.append(sb+"\n");
        bWriter.flush();
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        bWriter.close();
        bReader.close();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
  }
}
