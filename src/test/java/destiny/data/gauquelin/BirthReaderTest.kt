/**
 * Created by smallufo on 2018-04-06.
 */
package destiny.data.gauquelin

import kotlin.test.Test


class BirthReaderTest {

  private val readerA = BirthReader("Birth_A.txt", BirthReader.Hospital.SaintAntoine, BirthReader.City.Paris)
  private val readerB = BirthReader("Birth_B.txt", BirthReader.Hospital.Pitie, BirthReader.City.Paris)
  private val readerC = BirthReader("Birth_C.txt", BirthReader.Hospital.PortRoyal, BirthReader.City.Paris)
  private val readerD = BirthReader("Birth_D.txt", BirthReader.Hospital.Baudelocque, BirthReader.City.Paris)
  private val readerE = BirthReader("Birth_E.txt", null, BirthReader.City.Paris)
  private val readerF = BirthReader("Birth_F.txt", null, BirthReader.City.Lille)
  private val readerG = BirthReader("Birth_G.txt", null, BirthReader.City.Bourges)
  private val readerB1 = BirthReader("BirthB1.txt", null, BirthReader.City.Paris)
  private val readerB2 = BirthReader("BirthB2.txt", null, BirthReader.City.Paris)
  private val readerB3 = BirthReader("BirthB3.txt", null, BirthReader.City.Seine)
  private val readerB4 = BirthReader("BirthB4.txt", null, BirthReader.City.Seine)
  private val readerB5 = BirthReader("BirthB5.txt", null, BirthReader.City.Seine)
  private val readerB6 = BirthReader("BirthB6.txt", null, BirthReader.City.Seine)

  private val allFamilies = readerA.read()
    .plus(readerB.read())
    .plus(readerC.read())
    .plus(readerD.read())
    .plus(readerE.read())
    .plus(readerF.read())
    .plus(readerG.read())
    .plus(readerB1.read())
    .plus(readerB2.read())
    .plus(readerB3.read())
    .plus(readerB4.read())
    .plus(readerB5.read())
    .plus(readerB6.read())

  @Test
  fun read() {

    //    val readerTest = BirthReader("BirthTest.txt", null, BirthReader.City.Paris)
    //    readerTest.read().also { printFamilies(it) }
  }


  @Test
  fun readA() {
    readerA.read().also { printFamilies(it) }
  }

  @Test
  fun readB() {
    readerB.read().also { printFamilies(it) }
  }

  @Test
  fun readC() {
    readerC.read().also { printFamilies(it) }
  }

  @Test
  fun readD() {
    readerD.read().also { printFamilies(it) }
  }

  @Test
  fun readE() {
    readerE.read().also { printFamilies(it) }
  }

  @Test
  fun readF() {
    readerF.read().also { printFamilies(it) }
  }

  @Test
  fun readG() {
    readerG.read().also { printFamilies(it) }
  }

  @Test
  fun readB1() {
    readerB1.read().also { printFamilies(it) }
  }

  @Test
  fun readB2() {
    readerB2.read().also { printFamilies(it) }
  }

  @Test
  fun readB3() {
    readerB3.read().also { printFamilies(it) }
  }

  @Test
  fun readB4() {
    readerB4.read().also { printFamilies(it) }
  }

  @Test
  fun readB5() {
    readerB5.read().also { printFamilies(it) }
  }

  @Test
  fun readB6() {
    readerB6.read().also { printFamilies(it) }
  }

  private fun printFamilies(families: Sequence<Family>) {
    families.forEach { family ->
      println("family OK , father = ${family.father?.number}")
    }
  }

  @Test
  fun chainAllFamilies() {
    // total 13 groups

    println("count = ${allFamilies.count()}") // 39572
  }

  @Test
  fun findEmptyChildren() {
    allFamilies.filter { family ->
      family.father != null && family.mother != null && family.children.isEmpty()
    }.forEach { family ->
      println(family)
    }
  }

  @Test
  fun findFamiliesWithFatherAndMother() {
    val count = allFamilies.filter { family ->
      family.father != null && family.mother != null
    }.count()

    println("count = $count") // 20902
  }

  @Test
  fun countAll() {
    var count = 0
    allFamilies.forEach { family ->
      family.father?.also { count++ }
      family.mother?.also { count++ }
      count+=family.children.size
    }
    println("total $count persons") // 106251
  }
}