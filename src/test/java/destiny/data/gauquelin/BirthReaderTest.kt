/**
 * Created by smallufo on 2018-04-06.
 */
package destiny.data.gauquelin

import kotlin.test.Test


class BirthReaderTest {

  @Test
  fun read() {

//    val readerA = BirthReader(BirthReader.Hospital.SaintAntoine, BirthReader.City.Paris)
//    readerA.read("Birth_A.txt")
//
//    val readerB = BirthReader(BirthReader.Hospital.Pitie, BirthReader.City.Paris)
//    readerB.read("Birth_B.txt")
//
//    val readerC = BirthReader(BirthReader.Hospital.PortRoyal , BirthReader.City.Paris)
//    readerC.read("Birth_C.txt")
//
//    val readerD = BirthReader(BirthReader.Hospital.Baudelocque, BirthReader.City.Paris)
//    readerD.read("Birth_D.txt")
//
//    val readerE = BirthReader(null , BirthReader.City.Paris)
//    readerE.read("Birth_E.txt")

//    val readerF = BirthReader(null , BirthReader.City.Lille)
//    readerF.read("Birth_F.txt")

    val readerG = BirthReader(null , BirthReader.City.Bourges)
    readerG.read("Birth_G.txt")
  }
}