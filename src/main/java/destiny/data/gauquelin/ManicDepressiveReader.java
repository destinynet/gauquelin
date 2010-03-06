/**
 * @author smallufo 
 * Created on 2009/3/8 at 上午 1:48:10
 */ 
package destiny.data.gauquelin;

/**
 * MDP : Manic Depressive 躁鬱症 , 913筆
 */
public class ManicDepressiveReader extends AbstractMentalReader
{
  public ManicDepressiveReader()
  {
    super("manicDepressive.txt" , "mental_manic_depressive");
  }
  
  public static void main(String[] args)
  {
    TextDataReader r = new ManicDepressiveReader();
    for(GPerson person : r.getPersons())
    {
      System.out.println(person);
    }
  }
}
