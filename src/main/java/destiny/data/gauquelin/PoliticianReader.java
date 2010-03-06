/**
 * @author smallufo 
 * Created on 2009/3/7 at 下午 10:12:32
 */ 
package destiny.data.gauquelin;

/** Politician 政治家 , 1002 位 */
public class PoliticianReader extends AbstractReader
{
  public PoliticianReader()
  {
    super("politician.txt" , "politician_name.txt" , "politician");
  }

  public static void main(String[] args)
  {
    TextDataReader r = new PoliticianReader();
    for(GPerson person : r.getPersons())
    {
      System.out.println(person);
    }
  }
}
