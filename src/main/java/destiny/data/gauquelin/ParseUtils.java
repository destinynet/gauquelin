/**
 * @author smallufo 
 * Created on 2009/3/7 at 下午 8:32:01
 */ 
package destiny.data.gauquelin;

import destiny.core.calendar.Location;
import destiny.core.calendar.EastWest;
import destiny.core.calendar.NorthSouth;
import destiny.tools.location.TimeZoneUtils;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.TimeZone;

@SuppressWarnings("unused")
public class ParseUtils implements Serializable
{
  /**
   * 以 Number 排序 
   * Sport 運動冠軍 , Scientist 科學家(及醫師) , Military 軍人 , Painter 畫家 , Musician 音樂家 , Actor 演員 , Politician 政治人物  
   * PRO    NUM COU DAY MON YEA H   MN  SEC TZ  LAT LON COD CITY
   * */
  public static GPerson parseByNumber(String line)
  {
    StringTokenizer st = new StringTokenizer(line , "\t");
    String PRO = st.nextToken();

    //某些 NUM 會以驚嘆號結尾，原因不詳
    String NUM = st.nextToken();
    if (NUM.lastIndexOf('!') != -1)
      NUM = NUM.substring(0 , NUM.length()-1);
    int number = Integer.parseInt(NUM);
    String COU = st.nextToken();
    
    int day = Integer.parseInt(st.nextToken());
    int month = Integer.parseInt(st.nextToken());
    int year = Integer.parseInt(st.nextToken());
    
    int hour = Integer.parseInt(st.nextToken());
    int minute = Integer.parseInt(st.nextToken());
    int second = Integer.parseInt(st.nextToken());
    int tz = Integer.parseInt(st.nextToken()); // -1 的話，代表「東一區」
    tz = 0-tz;
    
    String LAT = st.nextToken();
    StringTokenizer st2 = new StringTokenizer(LAT , "NS");
    int latDeg = Integer.parseInt(st2.nextToken().trim());
    int latMin = Integer.parseInt(st2.nextToken().trim());
    char NS = LAT.charAt(latDeg < 10 ? 1 : 2);
    
    String LON = st.nextToken();
    StringTokenizer st3 = new StringTokenizer(LON , "EW");
    int longDeg = Integer.parseInt(st3.nextToken().trim());
    int longMin = Integer.parseInt(st3.nextToken().trim());
    char EW = LON.charAt(longDeg < 10 ? 1 : 2);
    //System.out.println("LON = " + LON + " , EW = " + EW);
    
    
    // 都是 GMT 時間
    LocalDateTime time = LocalDateTime.of(year , month , day , hour , minute , second);
    Timestamp ts = Timestamp.valueOf(time);
    Location location = new Location(
        (EW == 'E' ? EastWest.EAST : EastWest.WEST) , longDeg , longMin , 0 , 
        (NS == 'N' ? NorthSouth.NORTH : NorthSouth.SOUTH) , latDeg , latMin , 0 , 0 , 
        TimeZoneUtils.Companion.getTimeZone(tz*60));
    
    
    GPerson person = new GPerson();
    person.setNumber(number);
    person.setGender(-1);
    person.setGmtTimestamp(ts);
    person.setLocation(location.getDebugString());
    
    String COD = st.nextToken();
    String CITY ="";
    try
    {
      CITY = st.nextToken();  
    }
    catch(NoSuchElementException ignored)
    {
    }
    
    person.setPlace(CITY);
    //原始資料
    person.setRaw(line);
    return person;
  }
  
  /**
   * 以日期排序 
   * YEA  MON DAY PRO NUM COU H   MN  SEC TZ  LAT LON COD CITY
   * */
  @Deprecated
  public static GPerson parseByDate(String line)
  {
    StringTokenizer st = new StringTokenizer(line , "\t");
    
    int year = Integer.valueOf(st.nextToken()).intValue();
    int month = Integer.valueOf(st.nextToken()).intValue();
    int day = Integer.valueOf(st.nextToken()).intValue();
    
    String PRO = st.nextToken();
    int number = Integer.parseInt(st.nextToken());
    
    String COU = st.nextToken();
    
    int hour = Integer.parseInt(st.nextToken());
    int minute = Integer.parseInt(st.nextToken());
    int second = Integer.parseInt(st.nextToken());
    
    int tz = Integer.valueOf(st.nextToken()).intValue(); // -1 的話，代表「東一區」
    
    String LAT = st.nextToken();
    StringTokenizer st2 = new StringTokenizer(LAT , "NS");
    int latDeg = Integer.parseInt(st2.nextToken().trim());
    int latMin = Integer.parseInt(st2.nextToken().trim());
    char NS = LAT.charAt(latDeg < 10 ? 1 : 2);
    
    String LON = st.nextToken();
    StringTokenizer st3 = new StringTokenizer(LON , "EW");
    int longDeg = Integer.parseInt(st3.nextToken().trim());
    int longMin = Integer.parseInt(st3.nextToken().trim());
    char EW = LON.charAt(longDeg < 10 ? 1 : 2);
    
    // 都是 GMT 時間
    LocalDateTime  time = LocalDateTime.of(year , month , day , hour , minute , second);
    //Calendar cal = new GregorianCalendar(time.getYear() , time.getMonth()-1 , time.getDay() , time.getHour() , time.getMinute() , (int)time.getSecond());
    Timestamp ts = Timestamp.valueOf(time);
    Location location = new Location( (EW == 'E' ? EastWest.EAST : EastWest.WEST) , longDeg , longMin , 0 , (NS == 'N' ? NorthSouth.NORTH : NorthSouth.SOUTH) , latDeg , latMin , 0 , 0 , TimeZone.getTimeZone("GMT") );
    
    GPerson person = new GPerson();
    person.setNumber(number);
    person.setGender(-1);
    person.setGmtTimestamp(ts);
    person.setLocation(location.getDebugString());
    
    String COD = st.nextToken();
    String CITY = st.nextToken();
    
    person.setPlace(CITY);
    //原始資料
    person.setRaw(line);
    
    return person;
  }
  
  /** 專門處理 Sport 450 */
  public static GPerson parseType3(String line)
  {
    StringTokenizer st = new StringTokenizer(line , "\t");
    int number = Integer.parseInt(st.nextToken());
    int day = Integer.parseInt(st.nextToken());
    int month = Integer.parseInt(st.nextToken());
    int year = Integer.parseInt(st.nextToken());
    int hour = Integer.parseInt(st.nextToken());
    int minute = Integer.parseInt(st.nextToken());
    int second = Integer.parseInt(st.nextToken());
    
    String LAT = st.nextToken();
    StringTokenizer st2 = new StringTokenizer(LAT , "NS");
    int latDeg = Integer.parseInt(st2.nextToken().trim());
    int latMin = Integer.parseInt(st2.nextToken().trim());
    char NS = LAT.charAt(latDeg < 10 ? 1 : 2);
    
    String LON = st.nextToken();
    StringTokenizer st3 = new StringTokenizer(LON , "EW");
    int longDeg = Integer.parseInt(st3.nextToken().trim());
    int longMin = Integer.parseInt(st3.nextToken().trim());
    char EW = LON.charAt(longDeg < 10 ? 1 : 2);
    
    String name = st.nextToken();
    
    // 時間都是 GMT , 因為沒有時區這欄，所以推測都是 GMT 
    LocalDateTime time = LocalDateTime.of(year , month , day , hour , minute , second);
    Timestamp ts = Timestamp.valueOf(time);
    Location location = new Location( 
        (EW == 'E' ? EastWest.EAST : EastWest.WEST) , longDeg , longMin , 0 , 
        (NS == 'N' ? NorthSouth.NORTH : NorthSouth.SOUTH) , latDeg , latMin , 0 , 0 , 
        TimeZone.getTimeZone("GMT") );
    
    GPerson person = new GPerson();
    person.setNumber(number);
    person.setGender(-1);
    person.setGmtTimestamp(ts);
    person.setLocation(location.getDebugString());
    person.setName(name);
    person.setRaw(line);
    
    return person;
  }
  
  /** 
   * http://cura.free.fr/gauq/902gdD9b.html
   * 以下五種 :
   * ACD : "ACUTE DELUSIONS"
   * HALP : "HALLUCINATING PSYCHOSIS" 
   * MD : "MENTALLY DERANGED"   
   * MDP : MANIC-DEPRESSIVE PSYCHOSIS
   * SCH : SCHIZOPHRENICS
   * */
  public static GPerson parseMental(String line)
  {
    StringTokenizer st = new StringTokenizer(line , "\t");
    String acd = st.nextToken();
    String rest = line.substring(line.indexOf(st.nextToken()));
    GPerson person = parseMurderAlcoholic(rest);
    person.setRaw(line);
    
    return person;
  }
  
  /**
   * 殺人犯 , 酗酒者
   * NUM    SEX     DAY MON YEA H   MN  SEC TZ      LAT LON     COD
   */
  public static GPerson parseMurderAlcoholic(String line)
  {
    StringTokenizer st = new StringTokenizer(line , "\t");
    int number = Integer.parseInt(st.nextToken());
    
    int gender = -1;
    String SEX = st.nextToken();
    if (SEX.equals("M"))
      gender=1;
    else if (SEX.equals("F"))
      gender=0;
    
    int day = Integer.parseInt(st.nextToken());
    int month = Integer.parseInt(st.nextToken());
    int year = Integer.parseInt(st.nextToken());
    int hour = Integer.parseInt(st.nextToken());
    int minute = Integer.parseInt(st.nextToken());
    int second = Integer.parseInt(st.nextToken());
    
    int tz = Integer.parseInt(st.nextToken()); // -1 的話，代表「東一區」
    
    String LAT = st.nextToken();
    StringTokenizer st2 = new StringTokenizer(LAT , "NS");
    int latDeg = Integer.parseInt(st2.nextToken().trim());
    int latMin = Integer.parseInt(st2.nextToken().trim());
    char NS = LAT.charAt(latDeg < 10 ? 1 : 2);
    
    String LON = st.nextToken();
    StringTokenizer st3 = new StringTokenizer(LON , "EW");
    int longDeg = Integer.parseInt(st3.nextToken().trim());
    int longMin = Integer.parseInt(st3.nextToken().trim());
    char EW = LON.charAt(longDeg < 10 ? 1 : 2);

    // 都是 GMT 時間
    LocalDateTime time = LocalDateTime.of(year , month , day , hour , minute , second);
    Timestamp ts = Timestamp.valueOf(time);
    Location location = new Location( (EW == 'E' ? EastWest.EAST : EastWest.WEST) , longDeg , longMin , 0 , (NS == 'N' ? NorthSouth.NORTH : NorthSouth.SOUTH) , latDeg , latMin , 0 , 0 , TimeZone.getTimeZone("GMT") );
    
    String COD = st.nextToken();
    
    GPerson person = new GPerson();
    person.setNumber(number);
    person.setGender(gender);
    person.setGmtTimestamp(ts);
    person.setLocation(location.getDebugString());
    person.setRaw(line);
    
    return person;
  }
}
