/**
 * @author smallufo 
 * Created on 2008/11/15 at 上午 12:41:38
 */ 
package destiny.data.causer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TimeZone;

import javax.inject.Inject;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import destiny.astrology.StarPositionIF;
import destiny.astrology.StarTransitIF;
import destiny.astrology.swissephImpl.RiseTransImpl;
import destiny.astrology.swissephImpl.StarPositionImpl;
import destiny.astrology.swissephImpl.StarTransitImpl;
import destiny.core.Gender;
import destiny.core.calendar.Location;
import destiny.core.calendar.SolarTermsBean;
import destiny.core.calendar.SolarTermsIF;
import destiny.core.calendar.Time;
import destiny.core.calendar.eightwords.DayIF;
import destiny.core.calendar.eightwords.DayImpl;
import destiny.core.calendar.eightwords.EightWords;
import destiny.core.calendar.eightwords.EightWordsContext;
import destiny.core.calendar.eightwords.HourIF;
import destiny.core.calendar.eightwords.HourSolarTransImpl;
import destiny.core.calendar.eightwords.MidnightIF;
import destiny.core.calendar.eightwords.MidnightSolarTransImpl;
import destiny.core.calendar.eightwords.YearMonthIF;
import destiny.core.calendar.eightwords.YearMonthSolarTermsStarPositionImpl;
import destiny.core.calendar.eightwords.personal.EightWordsPersonContext;
import destiny.core.calendar.eightwords.personal.FortuneDirectionDefaultImpl;
import destiny.core.calendar.eightwords.personal.FortuneDirectionIF;
import destiny.core.chinese.StemBranch;

/**
 * 車禍肇事者
 * 1,1,1949,6,26,2007,10,10,1
 * 編號1 , 男性 ,1949/6/26 出生。肇事日期 2007/10/1 清晨1點
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:core.xml"})
public class CauserReader extends TestCase
{
  @Inject
  EightWordsContext eightWordsContext;
  
  private StarPositionIF starPositionImpl = new StarPositionImpl();
  private StarTransitIF starTransitImpl = new StarTransitImpl();
  private SolarTermsIF solarTermsImpl = new SolarTermsBean(starTransitImpl , starPositionImpl);
  private YearMonthIF yearMonthImpl = new YearMonthSolarTermsStarPositionImpl(315 , starPositionImpl , starTransitImpl);
  private DayIF dayImpl = new DayImpl();
  private HourIF hourImpl = new HourSolarTransImpl(new RiseTransImpl());
  private MidnightIF midnightImpl = new MidnightSolarTransImpl(new RiseTransImpl());
  
  /** 大運順逆演算法，內定採用「陽男陰女順排；陰男陽女逆排」的演算法 */
  private FortuneDirectionIF fortuneDirectionImpl = new FortuneDirectionDefaultImpl();

  private Location location;
  private Time lmt;
  
  @Test
  public void testCauserReader()
  {
    location = new Location(Location.EastWest.EAST , 120 , 0 , 0 , Location.NorthSouth.NORTH , 25, 03 , 0 , 0 , TimeZone.getTimeZone("Asia/Taipei") );
    
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
      EightWordsPersonContext context;
      StemBranch eventStemBranch;
      while ((line = bReader.readLine()) != null)
      {
        StringTokenizer st = new StringTokenizer(line , ", \n");
        
        long l1 = System.currentTimeMillis();
        int index = Integer.valueOf(st.nextToken());
        String man = st.nextToken();
        Gender gender = man.equals("1")? Gender.男 : Gender.女;
        int year = Integer.valueOf(st.nextToken()).intValue();
        int month = Integer.valueOf(st.nextToken()).intValue();
        int day = Integer.valueOf(st.nextToken()).intValue();
        int hour = 12;
        lmt = new Time(year , month , day , hour);
        context = new EightWordsPersonContext(yearMonthImpl , dayImpl , hourImpl, midnightImpl , true ,solarTermsImpl , starTransitImpl , lmt , location , gender , 120.0 , fortuneDirectionImpl);
        
        StringBuffer sb = new StringBuffer();
        sb.append(index+",");
        sb.append( (gender==Gender.男? "1" : "0") + ",");
        sb.append(year+",");
        sb.append(month+",");
        sb.append(day+",");
        EightWords ew = context.getEightWords(lmt , location);
        sb.append(ew.getYearStem() + ",");
        sb.append(ew.getYearBranch() + ",");
        sb.append(ew.getMonthStem() + ",");
        sb.append(ew.getMonthBranch() + ",");
        sb.append(ew.getDayStem() + ",");
        sb.append(ew.getDayBranch() + ",");
        sb.append(ew.getHourStem() + ",");
        sb.append(ew.getHourBranch() + ",");
        
        
        int eventYear = Integer.valueOf(st.nextToken()).intValue();
        int eventMonth = Integer.valueOf(st.nextToken()).intValue();
        int eventDay = Integer.valueOf(st.nextToken()).intValue();
        int eventHour = Integer.valueOf(st.nextToken()).intValue();
        int eventMinute = 0;
        int eventSecond = 0;
        //出事日期及時間
        sb.append(eventYear + ",");
        sb.append(eventMonth + ",");
        sb.append(eventDay + ",");
        sb.append(eventHour + ",");
        
        Time targetGmt;
        targetGmt = new Time(eventYear,eventMonth,eventDay , eventHour-8 , eventMinute , eventSecond);
        eventStemBranch = context.getStemBranchOfFortunrMonth(targetGmt);
        
        //出事大運的干支
        sb.append(eventStemBranch.getStem()+",");
        sb.append(eventStemBranch.getBranch()+",");
        
        EightWords ew2 = eightWordsContext.getEightWords(new Time(eventYear , eventMonth , eventDay , eventHour , eventMinute , eventSecond) , location);
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
