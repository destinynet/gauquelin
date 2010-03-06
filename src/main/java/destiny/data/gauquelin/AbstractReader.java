/**
 * @author smallufo 
 * Created on 2009/3/7 at 下午 9:45:14
 */ 
package destiny.data.gauquelin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public abstract class AbstractReader implements TextDataReader , Serializable
{
  private String datafile;
  private String namefile;
  private String category;
  private int gender = -1;
  
  protected List<GPerson> persons = Collections.synchronizedList(new ArrayList<GPerson>());
  
  public AbstractReader(String datafile , String namefile , String category)
  {
    this.datafile = datafile;
    this.namefile = namefile;
    this.category = category;
  } //AbstractReader()
  
  public AbstractReader(String datafile , String namefile , String category , int gender)
  {
    this.datafile = datafile;
    this.namefile = namefile;
    this.category = category;
    this.gender = gender;
  } //AbstractReader()
  
  private void process(String datafile , String namefile)
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
          GPerson gp = ParseUtils.parseByNumber(line);
          gp.setCategory(category);
          gp.setGender(gender);
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
    
    System.out.println("Totally " + persons.size() + " birth data.");

    if (namefile != null)
    {
      NameReader nameReader = new NameReader(namefile);
      for(NameData nameData : nameReader.getNameDataSet())
      {
        int matchCount=0;
        GPerson assignedPerson = null;
        for(GPerson person : persons)
        {
          Timestamp gmtTs = person.getGmtTimestamp();
          Calendar cal = Calendar.getInstance();
          cal.setTime(gmtTs);
          int year = cal.get(Calendar.YEAR);
          int month = cal.get(Calendar.MONTH)+1;
          int day = cal.get(Calendar.DAY_OF_MONTH);
          //System.out.println("year = " + year + " , month = " + month + " , day = " + day);
          
          if (nameData.getYear() == year && nameData.getMonth() == month && nameData.getDay() == day)
          {
            matchCount++;
            if (person.getName() == null && assignedPerson == null)
            {
              person.setName(nameData.getName());
              assignedPerson = person;
            }
          }
        } // for each birth
        if (assignedPerson == null)
          System.err.println("* Cannot find matching date : " + nameData);
        else if (matchCount > 1)
        {
          assignedPerson.setName(null);
          System.err.println("Found " + matchCount + " birth data for : " + nameData + " , skip name assignment.");
          //System.err.println("Found " + matchCount + " birth data for : " + nameData + " , assign name to [No."+assignedPerson.getNumber()+"] \t" + assignedPerson.getRaw());
          
        }
      } // for each name
    }
  } //process
  
  @Override
  public List<GPerson> getPersons()
  {
    if (persons.size() == 0)
      process(datafile , namefile);
    return persons;
  }

}
