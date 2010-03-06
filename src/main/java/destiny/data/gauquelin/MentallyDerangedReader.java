/**
 * @author smallufo 
 * Created on 2009/3/8 at 上午 1:45:49
 */ 
package destiny.data.gauquelin;

/**
 * MD : Mentally Deranged 心智瘋狂 , 877筆
 */
public class MentallyDerangedReader extends AbstractMentalReader
{
  public MentallyDerangedReader()
  {
    super("mentallyDeranged.txt", "mental_mentally_deranged");
  }
  
  public static void main(String[] args)
  {
    TextDataReader r = new MentallyDerangedReader();
    for(GPerson person : r.getPersons())
    {
      System.out.println(person);
    }
  }
}
