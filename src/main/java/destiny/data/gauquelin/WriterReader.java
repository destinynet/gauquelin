/**
 * @author smallufo 
 * Created on 2009/3/7 at 下午 10:01:42
 */ 
package destiny.data.gauquelin;

/** Writer 作家 , 1352位 */
public class WriterReader extends AbstractReader
{
  public WriterReader()
  {
    super("writer.txt" , "writer_name.txt" , "writer");
  }
  
  public static void main(String[] args)
  {
    TextDataReader r = new WriterReader();
    for(GPerson person : r.getPersons())
    {
      System.out.println(person);
    }
  }
}
