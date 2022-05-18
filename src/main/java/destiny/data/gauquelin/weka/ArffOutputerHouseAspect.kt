/**
 * Created by smallufo at 2009/3/16 下午 8:47:54
 */
package destiny.data.gauquelin.weka

import destiny.data.gauquelin.GPerson
import mu.KotlinLogging
import java.io.BufferedWriter
import java.io.FileWriter
import java.io.Serializable

/**
 * 星體所在宮位 + 星體之間的交角
 */
class ArffOutputerHouseAspect(private val gpersons: List<GPerson>, private val outputFile: String) : Serializable {
  private fun process() {
    var bWriter: BufferedWriter?
    try {
      val fstream = FileWriter(outputFile)
      bWriter = BufferedWriter(fstream)
      val headerBuffer = StringBuffer()
      headerBuffer.append("@RELATION gauquelin\r\n\r\n")
      headerBuffer.append("@ATTRIBUTE sun {1,2,3,4,5,6,7,8,9,10,11,12}\r\n")
      headerBuffer.append("@ATTRIBUTE moon {1,2,3,4,5,6,7,8,9,10,11,12}\r\n")
      headerBuffer.append("@ATTRIBUTE mercury {1,2,3,4,5,6,7,8,9,10,11,12}\r\n")
      headerBuffer.append("@ATTRIBUTE venus {1,2,3,4,5,6,7,8,9,10,11,12}\r\n")
      headerBuffer.append("@ATTRIBUTE mars {1,2,3,4,5,6,7,8,9,10,11,12}\r\n")
      headerBuffer.append("@ATTRIBUTE jupiter {1,2,3,4,5,6,7,8,9,10,11,12}\r\n")
      headerBuffer.append("@ATTRIBUTE saturn {1,2,3,4,5,6,7,8,9,10,11,12}\r\n")
      headerBuffer.append("@ATTRIBUTE uranus {1,2,3,4,5,6,7,8,9,10,11,12}\r\n")
      headerBuffer.append("@ATTRIBUTE neptune {1,2,3,4,5,6,7,8,9,10,11,12}\r\n")
      headerBuffer.append("@ATTRIBUTE pluto {1,2,3,4,5,6,7,8,9,10,11,12}\r\n")
      headerBuffer.append("@ATTRIBUTE sunMoon       {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE sunMercury    {Conjunction} \r\n")
      headerBuffer.append("@ATTRIBUTE sunVenus      {Conjunction} \r\n")
      headerBuffer.append("@ATTRIBUTE sunMars        {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE sunJupiter    {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE sunSaturn     {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE sunUranus     {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE sunNeptune    {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE sunPluto      {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE moonMercury   {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE moonVenus      {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE moonMars      {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE moonJupiter   {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE moonSaturn    {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE moonUranus    {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE moonNeptune   {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE moonPluto      {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE mercuryVenus  {Conjunction,SextileTrine} \r\n")
      headerBuffer.append("@ATTRIBUTE mercuryMars   {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE mercuryJupiter{Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE mercurySaturn {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE mercuryUranus {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE mercuryNeptune{Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE mercuryPluto  {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE venusMars      {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE venusJupiter  {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE venusSaturn   {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE venusUranus   {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE venusNeptune  {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE venusPluto    {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE marsJupiter   {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE marsSaturn    {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE marsUranus    {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE marsNeptune   {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE marsPluto      {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE jupiterSaturn {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE jupiterUranus {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE jupiterNeptune{Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE jupiterPluto  {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE saturnUranus  {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE saturnNeptune {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE saturnPluto    {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE uranusNeptune {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE uranusPluto    {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE neptunrPluto  {Conjunction,SextileTrine,SquareOpposition} \r\n")
      //headerBuffer.append("@ATTRIBUTE category {sport,scientist,military,painter,musician,actor,politician,writerJournalist,executive,murderer,alcoholic,mental} \r\n");
//headerBuffer.append("@ATTRIBUTE category {sport,scientist,military,painterMusicianActor ,politician,writerJournalist,executive} \r\n");
      headerBuffer.append("@ATTRIBUTE category {sport,scientist,military,painterMusicianActor ,politician,writerJournalist} \r\n")
      bWriter.append(headerBuffer.toString())
      bWriter.append("\r\n")
      bWriter.append("@DATA\r\n")
      bWriter.flush()
      for (person in gpersons) {
        val sb = StringBuffer()
        val house = person.houseMap["placidus"]
        sb.append(house!!.sun.toString() + " , ")
        sb.append(house.moon.toString() + " , ")
        sb.append(house.mercury.toString() + " , ")
        sb.append(house.venus.toString() + " , ")
        sb.append(house.mars.toString() + " , ")
        sb.append(house.jupiter.toString() + " , ")
        sb.append(house.saturn.toString() + " , ")
        sb.append(house.uranus.toString() + " , ")
        sb.append(house.neptune.toString() + " , ")
        sb.append(house.pluto.toString() + " , ")
        val aspect = person.aspect
        sb.append(processAspect(aspect!!.sunMoon) + " , ")
        sb.append(processAspect(aspect.sunMercury) + " , ")
        sb.append(processAspect(aspect.sunVenus) + " , ")
        sb.append(processAspect(aspect.sunMars) + " , ")
        sb.append(processAspect(aspect.sunJupiter) + " , ")
        sb.append(processAspect(aspect.sunSaturn) + " , ")
        sb.append(processAspect(aspect.sunUranus) + " , ")
        sb.append(processAspect(aspect.sunNeptune) + " , ")
        sb.append(processAspect(aspect.sunPluto) + " , ")
        sb.append(processAspect(aspect.moonMercury) + " , ")
        sb.append(processAspect(aspect.moonVenus) + " , ")
        sb.append(processAspect(aspect.moonMars) + " , ")
        sb.append(processAspect(aspect.moonJupiter) + " , ")
        sb.append(processAspect(aspect.moonSaturn) + " , ")
        sb.append(processAspect(aspect.moonUranus) + " , ")
        sb.append(processAspect(aspect.moonNeptune) + " , ")
        sb.append(processAspect(aspect.moonPluto) + " , ")
        sb.append(processAspect(aspect.mercuryVenus) + " , ")
        sb.append(processAspect(aspect.mercuryMars) + " , ")
        sb.append(processAspect(aspect.mercuryJupiter) + " , ")
        sb.append(processAspect(aspect.mercurySaturn) + " , ")
        sb.append(processAspect(aspect.mercuryUranus) + " , ")
        sb.append(processAspect(aspect.mercuryNeptune) + " , ")
        sb.append(processAspect(aspect.mercuryPluto) + " , ")
        sb.append(processAspect(aspect.venusMars) + " , ")
        sb.append(processAspect(aspect.venusJupiter) + " , ")
        sb.append(processAspect(aspect.venusSaturn) + " , ")
        sb.append(processAspect(aspect.venusUranus) + " , ")
        sb.append(processAspect(aspect.venusNeptune) + " , ")
        sb.append(processAspect(aspect.venusPluto) + " , ")
        sb.append(processAspect(aspect.marsJupiter) + " , ")
        sb.append(processAspect(aspect.marsSaturn) + " , ")
        sb.append(processAspect(aspect.marsUranus) + " , ")
        sb.append(processAspect(aspect.marsNeptune) + " , ")
        sb.append(processAspect(aspect.marsPluto) + " , ")
        sb.append(processAspect(aspect.jupiterSaturn) + " , ")
        sb.append(processAspect(aspect.jupiterUranus) + " , ")
        sb.append(processAspect(aspect.jupiterNeptune) + " , ")
        sb.append(processAspect(aspect.jupiterPluto) + " , ")
        sb.append(processAspect(aspect.saturnUranus) + " , ")
        sb.append(processAspect(aspect.saturnNeptune) + " , ")
        sb.append(processAspect(aspect.saturnPluto) + " , ")
        sb.append(processAspect(aspect.uranusNeptune) + " , ")
        sb.append(processAspect(aspect.uranusPluto) + " , ")
        sb.append(processAspect(aspect.neptunePluto) + " , ")
        //sb.append(person.getCategory() + "\r\n");
        var cat: String?
        cat = if (person.category.equals("writer", ignoreCase = true) || person.category.equals("journalist", ignoreCase = true)) "writerJournalist" else if (person.category!!.contains("mental")) "mental" else if (person.category.equals("painter", ignoreCase = true) || person.category.equals("musician", ignoreCase = true) || person.category.equals("actor", ignoreCase = true)) "painterMusicianActor" else person.category
        sb.append(cat + "\r\n")
        bWriter.append(sb)
        bWriter.flush()
      }
    } catch (e: Exception) {
      logger.warn { "error : $e" }
    }
  }

  /** 整合 aspects  */
  private fun processAspect(orig: String?): String {
    if (orig == null) return "?"
    if (orig.equals("Sextile", ignoreCase = true) || orig.equals("Trine", ignoreCase = true)) return "SextileTrine" else if (orig.equals("Square", ignoreCase = true) || orig.equals("Opposition", ignoreCase = true)) return "SquareOpposition"
    return orig
  }

  init {
    process()
  }

  companion object {
    private val logger = KotlinLogging.logger { }
  }
}
