/**
 * Created by smallufo on 2018-04-05.
 */
package destiny.data.gauquelin

import kotlin.test.Test

class CsvReaderActorTest {

  @Test
  fun read() {
    val reader = CsvReaderActor("actor.txt" , "test")
    reader.read()
  }
}