/**
 * @author smallufo 
 * Created on 2009/3/7 at 下午 7:35:42
 */
package destiny.data.gauquelin;

/** 軍人 3046 位 (編號到 3047 , 但缺 312) */
public class MilitaryReader extends AbstractReader
{
  public MilitaryReader()
  {
    super("military.txt" , "military_name.txt" , "military" , 1);
  }

  public static void main(String[] args)
  {
    TextDataReader r = new MilitaryReader();
    int i=0;
    for(GPerson person : r.getPersons())
    {
      i++;
      System.out.println("["+i+"] : " + person);
    }
  }

}
