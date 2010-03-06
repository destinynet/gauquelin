/**
 * @author smallufo 
 * Created on 2009/3/7 at 下午 9:04:03
 */ 
package destiny.data.gauquelin;

/** 畫家 1472 */
public class PainterReader extends AbstractReader
{
  public PainterReader()
  {
    super("painter.txt" , "painter_name.txt" , "painter");
  }

  public static void main(String[] args)
  {
    TextDataReader r = new PainterReader();
    for(GPerson person : r.getPersons())
    {
      System.out.println(person);
    }
  }

}
