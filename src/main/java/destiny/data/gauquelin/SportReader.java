/**
 * @author smallufo 
 * Created on 2009/3/7 at 下午 7:11:33
 */ 
package destiny.data.gauquelin;

/** 運動員 2087 */
public class SportReader extends AbstractReader
{
  public SportReader()
  {
    super("sport.txt" , "sport_name.txt" , "sport");
  }

  public static void main(String[] args)
  {
    TextDataReader r = new SportReader();
    
    for(GPerson person : r.getPersons())
    {
      System.out.println(person);
    }
  }
}
