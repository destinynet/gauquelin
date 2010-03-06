/**
 * Created by smallufo at 2009/3/17 下午 8:49:32
 */
package destiny.data.gauquelin;

import java.io.File;
import java.io.FileReader;
import java.io.Serializable;
import java.net.URL;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.TimeZone;

import destiny.core.calendar.Location;

public class CityLocation implements Serializable
{
  private Properties prop;
  public CityLocation()
  {
    URL url = getClass().getResource("cityLocation.properties");
    File file;
    try
    {
      file = new File(url.toURI());
      FileReader fReader = new FileReader(file);
      
      prop = new Properties();
      prop.load(fReader);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  public Location getLocation(String cityName)
  {
    String locString = prop.getProperty(cityName);
    if (locString == null)
      return null;
    
    StringTokenizer st = new StringTokenizer(locString , ",");
    double lat = Double.parseDouble(st.nextToken());
    double lon = Double.parseDouble(st.nextToken());

    //TODO : 目前資料都是 gmt，時差為 0 
    Location loc = new Location(lon , lat , TimeZone.getTimeZone("GMT"));
    return loc;
  }

  public static void main(String[] args)
  {
    new CityLocation();
  }

}
