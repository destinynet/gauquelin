/**
 * @author smallufo 
 * Created on 2009/3/8 at 上午 1:19:47
 */
package destiny.data.gauquelin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 * http://cura.free.fr/gauq/902gdD9b.html 
 * 五種心智問題 ... 格式都一樣
 *  
 * ACD : "ACUTE DELUSIONS"
 * HALP : "HALLUCINATING PSYCHOSIS" 
 * MD : "MENTALLY DERANGED"   
 * MDP : MANIC-DEPRESSIVE PSYCHOSIS
 * SCH : SCHIZOPHRENICS
 * </pre> 
 * */
public abstract class AbstractMentalReader implements TextDataReader
{
  protected List<GPerson> persons = Collections.synchronizedList(new ArrayList<GPerson>());

  public AbstractMentalReader(String datafile , String category)
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
          GPerson gp = ParseUtils.parseMental(line);
          gp.setCategory(category);
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

}
