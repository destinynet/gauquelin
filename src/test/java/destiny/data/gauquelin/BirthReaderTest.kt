/**
 * Created by smallufo on 2018-04-06.
 */
package destiny.data.gauquelin

import kotlin.test.Test


class BirthReaderTest {

  @Test
  fun read() {

    val reader = BirthReader()
    reader.read("Birth_A.txt" , BirthReader.Hospital.SaintAntoine)

  }
}