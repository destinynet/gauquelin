/**
 * Created by smallufo at 2009/3/11 下午 6:00:57
 */
package destiny.data.gauquelin;

import junit.framework.TestCase;

public class TextDataFormatterTest extends TestCase
{

  public void testTextDataFormatter()
  {
    new TextDataFormatter(new SportReader() , "sport_new.txt");
    new TextDataFormatter(new ScientistReader() , "scientist_new.txt");
    new TextDataFormatter(new MilitaryReader() , "military_new.txt");
    new TextDataFormatter(new PainterReader() , "painter_new.txt");
    new TextDataFormatter(new MusicianReader() , "musician_new.txt");
    new TextDataFormatter(new ActorReader() , "actor_new.txt");
    new TextDataFormatter(new PoliticianReader() , "politician_new.txt");
    new TextDataFormatter(new WriterReader() , "writer_new.txt");
  }

}
