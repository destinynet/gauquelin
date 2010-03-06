/**
 * @author smallufo 
 * Created on 2009/3/7 at 下午 10:07:11
 */ 
package destiny.data.gauquelin;

/** Journalist 記者 , 674位 */
public class JournalistReader extends AbstractReader
{
  public JournalistReader()
  {
    /**
     * TODO : http://cura.free.fr/gauq/902gdA6y.html 沒有 journalist 的姓名資料
     */
    super("journalist.txt" , null , "journalist");
  }
  
  public static void main(String[] args)
  {
    TextDataReader r = new JournalistReader();
    for(GPerson person : r.getPersons())
    {
      System.out.println(person);
    }
  }
}
