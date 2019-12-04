/**
 * Created by smallufo at 2009/3/17 下午 7:25:40
 */
package destiny.data.gauquelin;

import destiny.core.calendar.Location;
import destiny.core.calendar.LocationTools;
import destiny.tools.location.IGeocoding;
import destiny.tools.location.TimeZoneService;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

/**
 * <pre>
 * 2154 French Physicians, Military Men and Executives. Serie E, volume 1 : from 1901 to 1963
 * 2154 位成功的 物理學家 , 軍人 , 以及執行長
 * 實際跑出來會有 2161 位，因為有 7 位身兼兩個專長
 * </pre>
 */
public class SuccessfulFrench2154Reader implements TextDataReader {

  private List<GPerson> persons = Collections.synchronizedList(new ArrayList<GPerson>());

  private final IGeocoding geocodingImpl;

  private final TimeZoneService timeZoneService;

  public SuccessfulFrench2154Reader(IGeocoding geocodingImpl, TimeZoneService timeZoneService) {
    this.geocodingImpl = geocodingImpl;
    this.timeZoneService = timeZoneService;
  }

  private void process() {
    URL url = getClass().getResource("successfulFrench2154.txt");
    File file;
    BufferedReader bReader = null;

    CityLocation city = new CityLocation();
    try {
      file = new File(url.toURI());
      FileReader fReader = new FileReader(file);
      bReader = new BufferedReader(fReader);

      String line = null;
      while ((line = bReader.readLine()) != null) {
        if (!line.equals("") && line.charAt(0) != '#') {
          String professions = line.substring(8, 13).trim();
          //某些人有多個職業
          StringTokenizer profSt = new StringTokenizer(professions, ",");
          while (profSt.hasMoreTokens()) {
            GPerson person = new GPerson();
            int number = Integer.parseInt(line.substring(0, 4));
            person.setNumber(number);

            String pro = profSt.nextToken();
            if (pro.equalsIgnoreCase("PH"))
              person.setCategory("scientist"); //物理學家，視為科學家
            else if (pro.equalsIgnoreCase("EX"))
              person.setCategory("executive"); //執行長
            else if (pro.equalsIgnoreCase("MI")) {
              person.setCategory("military"); //軍人
              person.setGender(1); //軍人都是男生
            }
            String name = line.substring(17, 49).trim();
            person.setName(name);

            int day = Integer.parseInt(line.substring(49, 51));
            int month = Integer.parseInt(line.substring(55, 57));
            int year = Integer.parseInt(line.substring(61, 65));

            int hour = Integer.parseInt(line.substring(69, 71));
            int min = Integer.parseInt(line.substring(72, 74));
            //System.out.println(year + " / " + month + " / " + day + " " + hour+":"+min);

            // 都是 GMT 時間
            LocalDateTime time = LocalDateTime.of(year, month, day, hour, min, 0);
            Timestamp ts =  Timestamp.valueOf(time);
            person.setGmtTimestamp(ts);


            String place = line.substring(78, 104).trim();
            //System.out.println(place);

            // 經緯度
            Location loc = city.getLocation(place);
            if (loc != null) {
              //person.setLocation(loc.getDebugString());
              person.setLocation(LocationTools.INSTANCE.encode(loc));
              System.out.println("Found location (from properties file) for city : " + place);
            }
            else {
              //利用 yahoo api 尋找
              Location location = geocodingImpl.getLocation(place, timeZoneService);
              if (location != null) {
                if (location.getFinalMinuteOffset() < 0 || location.getFinalMinuteOffset() > 60 || location.getLngDeg() > 10)
                  System.err.println("city = " + place + " ,  location = " + location); //地點警告
                else
                  System.out.println("city = " + place + " ,  location = " + location);
                //當時資料應該都是 GMT0

                Location newLoc = new Location(location.getLat(), location.getLng() , "GMT" , location.getFinalMinuteOffset() , location.getAltitudeMeter());
                //person.setLocation(newLoc.getDebugString());
                person.setLocation(LocationTools.INSTANCE.encode(newLoc));
              }
              else {
                System.err.println("Cannot find location for city : " + place);
                //person.setLocation(city.getLocation("Paris").getDebugString());
                person.setLocation( LocationTools.INSTANCE.encode(city.getLocation("Paris")));
              }
            }

            person.setRaw(line);
            persons.add(person);
          } // each profession
        } // each valid data
      } //each line
    } catch (URISyntaxException | FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<GPerson> getPersons() {
    if (persons.size() == 0)
      process();
    return persons;
  }
}
