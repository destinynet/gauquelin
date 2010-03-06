/**
 * @author smallufo 
 * Created on 2009/3/7 at 下午 7:35:42
 */
package destiny.data.gauquelin;

/** 軍人 3046 位 */
public class MilitaryReader extends AbstractReader
{
  public MilitaryReader()
  {
    super("military.txt" , "military_name.txt" , "military" , 1);
  }

  public static void main(String[] args)
  {
    TextDataReader r = new MilitaryReader();
    for(GPerson person : r.getPersons())
    {
      System.out.println(person);
    }
  }

}
