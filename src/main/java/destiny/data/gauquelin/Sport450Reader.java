/**
 * @author smallufo 
 * Created on 2009/3/8 at 上午 12:45:32
 */ 
package destiny.data.gauquelin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sport450Reader implements TextDataReader , Serializable
{
  protected List<GPerson> persons = Collections.synchronizedList(new ArrayList<GPerson>());
  
  public Sport450Reader()
  {
    URL url = getClass().getResource("sport450.txt");
    
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
          GPerson gp = ParseUtils.parseType3(line);
          gp.setCategory("sport");
          this.persons.add(gp);
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
  
  @Override
  public List<GPerson> getPersons()
  {
    return persons;
  }
  
  public static void main(String[] args)
  {
    TextDataReader r = new Sport450Reader();
    int i=0;
    for(GPerson person : r.getPersons())
    {
      i++;
      System.out.println("["+i+"] : " +person);
    }
  }
}
