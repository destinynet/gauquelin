/**
 * @author smallufo 
 * Created on 2009/3/8 at 上午 1:29:20
 */ 
package destiny.data.gauquelin;

/** ACD : Acute Delusion 嚴重幻想 , 333筆 */
public class AcuteDelusionReader extends AbstractMentalReader
{

  public AcuteDelusionReader()
  {
    super("acuteDelusion.txt" , "mental_acute_delusion");
  }
  
  public static void main(String[] args)
  {
    TextDataReader r = new AcuteDelusionReader();
    for(GPerson person : r.getPersons())
    {
      System.out.println(person);
    }
  }

}
