/**
 * @author smallufo 
 * Created on 2009/3/7 at 下午 9:37:02
 */ 
package destiny.data.gauquelin;

/** Musician 音樂家 , 1248位 */
public class MusicianReader extends AbstractReader
{
  public MusicianReader()
  {
    super("musician.txt" , "musician_name.txt" , "musician");
  }



  public static void main(String[] args)
  {
    TextDataReader r = new MusicianReader();
    for(GPerson person : r.getPersons())
    {
      System.out.println(person);
    }
  }
}
