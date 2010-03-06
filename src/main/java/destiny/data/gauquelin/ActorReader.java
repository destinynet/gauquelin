/**
 * @author smallufo 
 * Created on 2008/3/9 at 下午 12:28:12
 */
package destiny.data.gauquelin;


/** Actor 演員 , 1408位 */
public class ActorReader extends AbstractReader
{
  public ActorReader()
  {
    super("actor.txt" , "actor_name.txt" , "actor");
  }

  public static void main(String[] args)
  {
    TextDataReader r = new ActorReader();
    for(GPerson person : r.getPersons())
    {
      System.out.println(person);
    }
  }
}
