/**
 * @author smallufo 
 * Created on 2009/3/7 at 下午 8:53:05
 */ 
package destiny.data.gauquelin;

/**
 * 科學家 , 醫生 3643 位
 */
public class ScientistReader extends AbstractReader
{
  public ScientistReader()
  {
    super("scientist.txt" , "scientist_name.txt" , "scientist");
  }

  public static void main(String[] args)
  {
    TextDataReader r = new ScientistReader();
    for(GPerson person : r.getPersons())
    {
      System.out.println(person);
    }
  }
  
}
