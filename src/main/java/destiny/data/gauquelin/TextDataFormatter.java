/**
 * Created by smallufo at 2009/3/11 下午 5:51:27
 */
package destiny.data.gauquelin;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


/** 餵入資料，吐出姓名在尾端 */
public class TextDataFormatter
{
  public TextDataFormatter(TextDataReader reader , String outfile)
  {
    BufferedWriter bWriter = null;
    try
    {
      FileWriter fstream = new FileWriter(outfile);
      bWriter = new BufferedWriter(fstream);
      
      for(GPerson person : reader.getPersons())
      {
        StringBuffer sb = new StringBuffer(person.getRaw());
        sb.append("\t");
        if (person.getName() != null)
          sb.append(person.getName());
        bWriter.append(sb+"\r\n");
      }
      bWriter.flush();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        bWriter.close();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }

    
  }
  
  
  
}
