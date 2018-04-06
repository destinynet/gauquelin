/**
 * Created by smallufo on 2018-04-06.
 */
package destiny.data.gauquelin

import kotlin.test.Test


class BirthReaderTest {

  @Test
  fun read() {

//    val readerA = BirthReader(BirthReader.Hospital.SaintAntoine)
//    readerA.read("Birth_A.txt")
//
//    val readerB = BirthReader(BirthReader.Hospital.Pitie)
//    readerB.read("Birth_B.txt")
//
//    val readerC = BirthReader(BirthReader.Hospital.PortRoyal)
//    readerC.read("Birth_C.txt")

    val readerD = BirthReader(BirthReader.Hospital.Baudelocque)
    readerD.read("Birth_D.txt")
  }
}