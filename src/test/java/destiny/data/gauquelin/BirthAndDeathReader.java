/**
 * @author smallufo
 * Created on 2012/2/27 at 下午3:18:03
 */
package destiny.data.gauquelin;

import destiny.core.calendar.Location;
import destiny.core.calendar.EastWest;
import destiny.core.calendar.NorthSouth;
import destiny.core.calendar.eightwords.EightWordsContext;
import destiny.tools.location.TimeZoneUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.StringTokenizer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:core.xml"})
/** 讀取的是 http://cura.free.fr/gauq/902gdF1.html 
 * 此為 2009 改版的格式 , 用 TAB 區隔欄位
 * */
public class BirthAndDeathReader
{
  @Inject
  EightWordsContext eightWordsContext;
  
  @Test
  public void testRead() throws Exception
  {
    URL url = getClass().getResource("BirthAndDeath.txt");
    File file;
    BufferedReader bReader = null;
    
    file = new File(url.toURI());
    FileReader fReader = new FileReader(file);
    bReader = new BufferedReader(fReader);
    String line = null;
    LocalDateTime birthTime = null;
    LocalDateTime deathTime = null;
    
    int i=0;
    while ((line = bReader.readLine()) != null)
    {
      if (!line.equals("") && line.charAt(0) != '#')
      {
        StringTokenizer st = new StringTokenizer(line , "\t");
        long num = Long.valueOf(st.nextToken()).longValue();
        char birthOrDeath = st.nextToken().charAt(0);
        int day = Integer.valueOf(st.nextToken().trim());
        int month = Integer.valueOf(st.nextToken().trim());
        int year = Integer.valueOf(st.nextToken().trim());
        int hour = Integer.valueOf(st.nextToken().trim());
        int minute = Integer.valueOf(st.nextToken().trim());
        int second = Integer.valueOf(st.nextToken().trim());
        if (st.countTokens() == 4)
          st.nextToken(); // 跳過 Ci
        int tz = Integer.valueOf(st.nextToken().trim());
        tz = 0-tz; // CET 時間其實是 GMT+1 , 但是這兒傳回的都是 -1
        
        //應該都是 48N50
        String lat = st.nextToken().trim();
        StringTokenizer stNS = new StringTokenizer(lat,"NS");
        int latDeg = Integer.valueOf(stNS.nextToken().trim());
        char NS = lat.charAt(2);
        int latMin = Integer.valueOf(stNS.nextToken().trim());
        
        //應該都是 2E20
        String lon = st.nextToken();
        StringTokenizer stEW = new StringTokenizer(lon,"EW");
        int longDeg = Integer.valueOf(stEW.nextToken().trim());
        char EW = lon.charAt(1);
        int longMin = Integer.valueOf(stEW.nextToken().trim());


        LocalDateTime time = LocalDateTime.of(year , month , day , hour , minute , second);
        Location location = new Location( (EW == 'E' ? EastWest.EAST : EastWest.WEST) , longDeg , longMin , 0.0
          , (NS == 'N' ? NorthSouth.NORTH : NorthSouth.SOUTH) , latDeg , latMin , 0.0 , TimeZoneUtils.Companion.getTimeZone(tz*60).getID() , null , 0.0);
        
        if (birthOrDeath == 'B')
          birthTime = time;
        else
        {
          deathTime = time;
          //計算存活多久
          if (deathTime.isAfter(birthTime))
          {
            i++;
            System.out.println("======"+i+" ("+num+")===== : " + location );
          }
          
//          if (deathTime.diffSeconds(birthTime) < 60*60*24*365)
//          {
//            //列出小於一歲的
//            i++;
//            EightWords ew1 = eightWordsContext.getEightWords(birthTime , location);
//            System.out.println("======"+i+" ("+num+")=====");
//            System.out.print("出生於 : " + ew1);
//
//            EightWords ew2 = eightWordsContext.getEightWords(deathTime , location);
//            System.out.println("\n卒於 : " + ew2);
//          }
        }
      }
    }//while
  } // test()
}
