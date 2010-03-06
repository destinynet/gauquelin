/**
 * @author smallufo 
 * Created on 2009/3/8 at 上午 1:52:22
 */ 
package destiny.data.gauquelin;

/**
 * SCH : Schizophrenics 精神分裂症 , 1266筆
 */
public class SchizophrenicsReader extends AbstractMentalReader
{
  public SchizophrenicsReader()
  {
    super("schizophrenics.txt" , "mental_schizophrenics");  
  }
  
  public static void main(String[] args)
  {
    TextDataReader r = new SchizophrenicsReader();
    for(GPerson person : r.getPersons())
    {
      System.out.println(person);
    }
  }
  
}
