/**
 * @author smallufo
 * Created on 2009/3/21 at 下午 3:01:34
 */
package destiny.data.gauquelin.weka

import destiny.astrology.Planets
import destiny.data.gauquelin.GPerson
import destiny.data.gauquelin.RefUtil
import java.io.BufferedWriter
import java.io.FileWriter
import java.util.*

/**
 * 星體在尖角的強度 + 星體之間的交角
 */
class ArffOutputterAnglePowerAspect(private val gpersons: List<GPerson>, private val outputFile: String) {


  init {
    process()
  }

  private fun process() {
    var bWriter: BufferedWriter? = null

    try {
      val fstream = FileWriter(outputFile)
      bWriter = BufferedWriter(fstream)

      val headerBuffer = StringBuffer()

      headerBuffer.append("@RELATION gauquelin\r\n\r\n")

      headerBuffer.append("@ATTRIBUTE sunDir       {east , top , west , bottom} \r\n")
      headerBuffer.append("@ATTRIBUTE sunPower     NUMERIC \r\n")
      headerBuffer.append("@ATTRIBUTE moonDir      {east , top , west , bottom} \r\n")
      headerBuffer.append("@ATTRIBUTE moonPower    NUMERIC \r\n")
      headerBuffer.append("@ATTRIBUTE mercuryDir   {east , top , west , bottom} \r\n")
      headerBuffer.append("@ATTRIBUTE mercuryPower NUMERIC \r\n")
      headerBuffer.append("@ATTRIBUTE venusDir     {east , top , west , bottom} \r\n")
      headerBuffer.append("@ATTRIBUTE venusPower   NUMERIC \r\n")
      headerBuffer.append("@ATTRIBUTE marsDir      {east , top , west , bottom} \r\n")
      headerBuffer.append("@ATTRIBUTE marsPower    NUMERIC \r\n")
      headerBuffer.append("@ATTRIBUTE jupiterDir   {east , top , west , bottom} \r\n")
      headerBuffer.append("@ATTRIBUTE jupiterPower NUMERIC \r\n")
      headerBuffer.append("@ATTRIBUTE saturnDir    {east , top , west , bottom} \r\n")
      headerBuffer.append("@ATTRIBUTE saturnPower  NUMERIC \r\n")
      headerBuffer.append("@ATTRIBUTE uranusDir    {east , top , west , bottom} \r\n")
      headerBuffer.append("@ATTRIBUTE uranusPower  NUMERIC \r\n")
      headerBuffer.append("@ATTRIBUTE neptuneDir   {east , top , west , bottom} \r\n")
      headerBuffer.append("@ATTRIBUTE neptunePower NUMERIC \r\n")
      headerBuffer.append("@ATTRIBUTE plutoDir     {east , top , west , bottom} \r\n")
      headerBuffer.append("@ATTRIBUTE plutoPower   NUMERIC \r\n")


      headerBuffer.append("@ATTRIBUTE sunMoon       {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE sunMercury    {Conjunction} \r\n")
      headerBuffer.append("@ATTRIBUTE sunVenus      {Conjunction} \r\n")
      headerBuffer.append("@ATTRIBUTE sunMars       {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE sunJupiter    {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE sunSaturn     {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE sunUranus     {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE sunNeptune    {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE sunPluto      {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE moonMercury   {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE moonVenus     {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE moonMars      {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE moonJupiter   {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE moonSaturn    {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE moonUranus    {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE moonNeptune   {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE moonPluto     {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE mercuryVenus  {Conjunction,SextileTrine} \r\n")
      headerBuffer.append("@ATTRIBUTE mercuryMars   {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE mercuryJupiter{Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE mercurySaturn {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE mercuryUranus {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE mercuryNeptune{Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE mercuryPluto  {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE venusMars     {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE venusJupiter  {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE venusSaturn   {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE venusUranus   {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE venusNeptune  {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE venusPluto    {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE marsJupiter   {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE marsSaturn    {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE marsUranus    {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE marsNeptune   {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE marsPluto     {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE jupiterSaturn {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE jupiterUranus {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE jupiterNeptune{Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE jupiterPluto  {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE saturnUranus  {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE saturnNeptune {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE saturnPluto   {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE uranusNeptune {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE uranusPluto   {Conjunction,SextileTrine,SquareOpposition} \r\n")
      headerBuffer.append("@ATTRIBUTE neptunrPluto  {Conjunction,SextileTrine,SquareOpposition} \r\n")


      //headerBuffer.append("@ATTRIBUTE category {sport,scientist,military,painter,musician,actor,politician,writerJournalist,executive,murderer,alcoholic,mental} \r\n");
      headerBuffer.append("@ATTRIBUTE category {sport,scientist,military,painterMusicianActor , writerJournalist} \r\n")
      //headerBuffer.append("@ATTRIBUTE category {sport,scientist,military,painter, musician , actor ,politician,writer , journalist} \r\n");

      bWriter.append(headerBuffer.toString())
      bWriter.append("\r\n")
      bWriter.append("@DATA\r\n")
      bWriter.flush()

      var refUtil: RefUtil
      for (person in gpersons) {
        val sb = StringBuffer()
        val anglePower = person.anglePower

        refUtil = RefUtil(anglePower)
        for (planet in Planets.values) {
          val dir = refUtil.getValue(planet.toString(Locale.ENGLISH).toLowerCase()) as String
          sb.append(dir)
          sb.append(",")
          val d = refUtil.getValue(planet.toString(Locale.ENGLISH).toLowerCase() + "Power") as Double
          sb.append(d)
          sb.append(", ")
        }

        /*
               GPersonHouse house = person.getHouseMap().get("placidus");
               sb.append(house.getSun() + " , ");
               sb.append(house.getMoon() + " , ");
               sb.append(house.getMercury() + " , ");
               sb.append(house.getVenus() + " , ");
               sb.append(house.getMars() + " , ");
               sb.append(house.getJupiter() + " , ");
               sb.append(house.getSaturn() + " , ");
               sb.append(house.getUranus() + " , ");
               sb.append(house.getNeptune() + " , ");
               sb.append(house.getPluto() + " , ");
               */

        val aspect = person.aspect
        sb.append(processAspect(aspect.sunMoon) + " , ")
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
        sb.append(processAspect(aspect.neptunrPluto) + " , ")

        var cat = person.category
        if (person.category.equals("writer", ignoreCase = true) || person.category.equals("journalist", ignoreCase = true))
          cat = "writerJournalist"
        else if (person.category.contains("mental"))
          cat = "mental"
        else if (person.category.equals("painter", ignoreCase = true) || person.category.equals("musician", ignoreCase = true) || person.category.equals("actor", ignoreCase = true))
          cat = "painterMusicianActor"

        sb.append(cat)
        sb.append("\r\n")

        bWriter.append(sb)
        bWriter.flush()
      }

    } catch (e: Exception) {
    }

  } // process()


  /** 整合 aspects  */
  private fun processAspect(orig: String?): String {
    if (orig == null)
      return "?"

    if (orig.equals("Sextile", ignoreCase = true) || orig.equals("Trine", ignoreCase = true))
      return "SextileTrine"
    else if (orig.equals("Square", ignoreCase = true) || orig.equals("Opposition", ignoreCase = true))
      return "SquareOpposition"
    return orig
  }

}
