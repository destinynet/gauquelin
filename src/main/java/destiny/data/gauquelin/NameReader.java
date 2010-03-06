/**
 * @author smallufo 
 * Created on 2009/3/7 at 下午 10:49:46
 */ 
package destiny.data.gauquelin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class NameReader implements Serializable
{
  private Set<NameData> nameDataSet = Collections.synchronizedSet(new LinkedHashSet<NameData>());
  
  public NameReader(String filename)
  {
    URL url = getClass().getResource(filename);
    
    File file;
    BufferedReader bReader = null;
    
    try
    {
      file = new File(url.toURI());
      FileReader fReader = new FileReader(file);
      bReader = new BufferedReader(fReader);

      String line = null;
      while ((line = bReader.readLine()) != null)
      {
        if (!line.equals("") && line.charAt(0) != '#')
        {
          StringTokenizer st = new StringTokenizer(line, "\t");
          int year = Integer.parseInt(st.nextToken().trim());
          int month = Integer.parseInt(st.nextToken().trim());
          int day = Integer.parseInt(st.nextToken().trim());
          String name = st.nextToken();
          
          nameDataSet.add(new NameData(year , month , day , name));
        }
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
        bReader.close();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
  }

  public Set<NameData> getNameDataSet()
  {
    System.out.println("Totally " + nameDataSet.size() + " name data.");
    return nameDataSet;
  }
}
