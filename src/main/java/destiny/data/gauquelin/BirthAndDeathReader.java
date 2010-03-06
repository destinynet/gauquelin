/**
 * @author smallufo 
 * Created on 2008/3/10 at 下午 4:35:39
 */ 
package destiny.data.gauquelin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;

import destiny.core.calendar.Location;
import destiny.core.calendar.Time;
import destiny.core.calendar.Location.EastWest;
import destiny.core.calendar.Location.NorthSouth;
import destiny.core.calendar.eightwords.EightWords;
import destiny.core.calendar.eightwords.EightWordsContextBean;
import destiny.utils.location.TimeZoneUtils;

public class BirthAndDeathReader
{
  public BirthAndDeathReader()
  {
    EightWordsContextBean bean;
    
    URL url = getClass().getResource("BirthAndDeath.txt");
    File file;
    BufferedReader bReader = null;
    
    try
    {
      file = new File(url.toURI());
      FileReader fReader = new FileReader(file);
      bReader = new BufferedReader(fReader);
      String line = null;
      Time birthTime = null;
      Time deathTime = null;
      
      int i=0;
      while ((line = bReader.readLine()) != null)
      {
        if (!line.equals("") && line.charAt(0) != '#')
        {
          char birthOrDeath = line.charAt(5);
          int day = Integer.valueOf(line.substring(11, 13).trim());
          int month = Integer.valueOf(line.substring(13, 15).trim());
          int year = Integer.valueOf(line.substring(15, 19).trim());
          int hour = Integer.valueOf(line.substring(19, 21).trim());
          int minute = Integer.valueOf(line.substring(21, 23).trim());
          int second = Integer.valueOf(line.substring(23, 25).trim());
          int tz = Integer.valueOf(line.substring(25, 27).trim());
          
          int latDeg = Integer.valueOf(line.substring(27, 29).trim());
          char NS = line.charAt(29);
          int latMin = Integer.valueOf(line.substring(30, 32).trim());
          
          int longDeg = Integer.valueOf(line.substring(32, 34).trim());
          char EW = line.charAt(34);
          int longMin = Integer.valueOf(line.substring(35, 37).trim());
          
          
          Time time = new Time(year , month , day , hour , minute , second);
          Location location = new Location( (EW == 'E' ? EastWest.EAST : EastWest.WEST) , longDeg , longMin , 0 , (NS == 'N' ? NorthSouth.NORTH : NorthSouth.SOUTH) , latDeg , latMin , 0 , 0 , TimeZoneUtils.getTimeZone(tz*60) );
          
          if (birthOrDeath == 'B')
            birthTime = time;
          else
          {
            deathTime = time;
            //計算存活多久
            if (deathTime.diffSeconds(birthTime) < 60*60*24*365)
            {
              i++;
              bean = new EightWordsContextBean();
              EightWords ew1 = bean.getEightWords(birthTime , location);
              System.out.println("======"+i+"=====");
              System.out.print("出生於 : " + ew1);

              bean = new EightWordsContextBean();
              EightWords ew2 = bean.getEightWords(deathTime , location);
              System.out.println("\n卒於 : " + ew2);
            }
          }
        }
      }//while
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  public static void main(String[] args)
  {
    new BirthAndDeathReader();
  }
}
