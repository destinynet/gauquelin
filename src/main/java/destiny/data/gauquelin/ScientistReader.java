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
    int i=0;
    for(GPerson person : r.getPersons())
    {
      i++;
      System.out.println("["+i+"] " + person);
    }
  }
  
}
