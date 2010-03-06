/**
 * Created by smallufo at 2009/3/17 下午 9:45:42
 */
package destiny.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionParams;

import destiny.core.calendar.Location;
import destiny.utils.location.TimeZoneService;
import destiny.web.yahoo.AppData;

public class GeolocationFinderYahooImpl implements GeolocationFinder
{
  private String appid;
  private TimeZoneService timeZoneService;
  private final static String APIURL = "http://local.yahooapis.com/MapsService/V1/geocode";
  
  public GeolocationFinderYahooImpl(AppData yahooAppData , TimeZoneService timeZoneService)
  {
    this.appid = yahooAppData.getAppid();
    this.timeZoneService = timeZoneService;
  }

  @Override
  public Location getLocation(String place, Locale locale)
  {
    HttpConnectionManager connManager = new MultiThreadedHttpConnectionManager();
    HttpConnectionParams params = connManager.getParams();
    params.setConnectionTimeout(3000); //內定 Connection Timeout 為 3秒！
    params.setSoTimeout(5000); //內定 Timeout 為 5秒！
    HttpClient httpClient = new HttpClient(connManager);
    
    GetMethod getMethod = new GetMethod(APIURL);
    
    NameValuePair[] data =
    {
      new NameValuePair("appid", appid),
      new NameValuePair("city", place),
      new NameValuePair("state", locale == null ? Locale.getDefault().getCountry() : locale.getCountry()),
    };
    getMethod.setQueryString(data);

    try
    {
      int httpCode = httpClient.executeMethod(getMethod);
      //System.out.println("http returns " + httpCode);
      
      
      InputStream is = getMethod.getResponseBodyAsStream();
      BufferedReader br = new BufferedReader(new InputStreamReader(is , "UTF8"));
      String tempbf;
      StringBuffer sb = new StringBuffer(100);
      while ((tempbf = br.readLine()) != null)
        sb.append(tempbf);
      String rawXml = new String(sb.toString());
      
      if (httpCode != 200)
      {
        System.err.println("Error ! http returns " + httpCode);
        System.err.println(rawXml);
        return null;
      }
      
      if (rawXml.contains("<Error>") && rawXml.contains("</Error>"))
        return null;
      
      int latStart = rawXml.indexOf("<Latitude>")+10;
      int latEnd = rawXml.indexOf("</Latitude>");
      double latitude = Double.parseDouble(rawXml.substring(latStart, latEnd));
      
      int lonStart = rawXml.indexOf("<Longitude>")+11;
      int lonEnd = rawXml.indexOf("</Longitude>");
      double longitude = Double.parseDouble(rawXml.substring(lonStart, lonEnd));
      
      //Timezone
      TimeZone tz = timeZoneService.getTimeZone(longitude, latitude);
      Location loc = new Location(longitude , latitude , tz);
      return loc;
    }
    catch (HttpException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

    
    return null;
  }

}
