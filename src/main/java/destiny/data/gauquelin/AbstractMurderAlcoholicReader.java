/**
 * @author smallufo 
 * Created on 2009/3/12 at 上午 1:10:23
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

public abstract class AbstractMurderAlcoholicReader implements TextDataReader , Serializable
{
  private String datafile;
  private String category;
  
  protected List<GPerson> persons = Collections.synchronizedList(new ArrayList<GPerson>());
  
  public AbstractMurderAlcoholicReader(String datafile , String category)
  {
    this.datafile = datafile;
    this.category = category;
  }
  
  private void process()
  {
    URL url = getClass().getResource(datafile);
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
          GPerson gp = ParseUtils.parseMurderAlcoholic(line);
          gp.setCategory(category);
          persons.add(gp);
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
    if (persons.size() == 0)
      process();
    return persons;
  }
}
