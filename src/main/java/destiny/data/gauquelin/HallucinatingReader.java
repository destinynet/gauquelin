/**
 * @author smallufo 
 * Created on 2009/3/8 at 上午 1:39:51
 */ 
package destiny.data.gauquelin;

/**
 * HALP : HALLUCINATING PSYCHOSIS , 
 * Hallucination 幻覺 , 1137筆
 */
public class HallucinatingReader extends AbstractMentalReader
{
  public HallucinatingReader()
  {
    super("hallucinating.txt" , "mental_hallucinating");
  }
  
  public static void main(String[] args)
  {
    TextDataReader r = new HallucinatingReader();
    for(GPerson person : r.getPersons())
    {
      System.out.println(person);
    }
  }
}