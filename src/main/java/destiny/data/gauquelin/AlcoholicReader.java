/**
 * @author smallufo 
 * Created on 2009/3/8 at 上午 1:09:39
 */ 
package destiny.data.gauquelin;


public class AlcoholicReader extends AbstractMurderAlcoholicReader
{
  public AlcoholicReader()
  {
    super("alcoholic.txt" , "alcoholic");
  }
  
  public static void main(String[] args)
  {
    TextDataReader r = new AlcoholicReader();
    for(GPerson person : r.getPersons())
    {
      System.out.println(person);
    }
  }
}
