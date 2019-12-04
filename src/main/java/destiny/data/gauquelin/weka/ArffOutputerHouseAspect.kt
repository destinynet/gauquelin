/**
 * Created by smallufo at 2009/3/16 下午 8:47:54
 */
package destiny.data.gauquelin.weka;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.List;

import destiny.data.gauquelin.GPerson;
import destiny.data.gauquelin.GPersonAspect;
import destiny.data.gauquelin.GPersonHouse;

/**
 * 星體所在宮位 + 星體之間的交角
 */
public class ArffOutputerHouseAspect implements Serializable
{
  private List<GPerson> gpersons;
  private String        outputFile;

  public ArffOutputerHouseAspect(List<GPerson> gpersons, String outputFile)
  {
    this.gpersons = gpersons;
    this.outputFile = outputFile;
    process();
  }

  private void process()
  {
    BufferedWriter bWriter = null;

    try
    {
      FileWriter fstream = new FileWriter(outputFile);
      bWriter = new BufferedWriter(fstream);

      StringBuffer headerBuffer = new StringBuffer();

      headerBuffer.append("@RELATION gauquelin\r\n\r\n");

      headerBuffer.append("@ATTRIBUTE sun {1,2,3,4,5,6,7,8,9,10,11,12}\r\n");
      headerBuffer.append("@ATTRIBUTE moon {1,2,3,4,5,6,7,8,9,10,11,12}\r\n");
      headerBuffer.append("@ATTRIBUTE mercury {1,2,3,4,5,6,7,8,9,10,11,12}\r\n");
      headerBuffer.append("@ATTRIBUTE venus {1,2,3,4,5,6,7,8,9,10,11,12}\r\n");
      headerBuffer.append("@ATTRIBUTE mars {1,2,3,4,5,6,7,8,9,10,11,12}\r\n");
      headerBuffer.append("@ATTRIBUTE jupiter {1,2,3,4,5,6,7,8,9,10,11,12}\r\n");
      headerBuffer.append("@ATTRIBUTE saturn {1,2,3,4,5,6,7,8,9,10,11,12}\r\n");
      headerBuffer.append("@ATTRIBUTE uranus {1,2,3,4,5,6,7,8,9,10,11,12}\r\n");
      headerBuffer.append("@ATTRIBUTE neptune {1,2,3,4,5,6,7,8,9,10,11,12}\r\n");
      headerBuffer.append("@ATTRIBUTE pluto {1,2,3,4,5,6,7,8,9,10,11,12}\r\n");

      
      headerBuffer.append("@ATTRIBUTE sunMoon       {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE sunMercury    {Conjunction} \r\n");
      headerBuffer.append("@ATTRIBUTE sunVenus      {Conjunction} \r\n");
      headerBuffer.append("@ATTRIBUTE sunMars        {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE sunJupiter    {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE sunSaturn     {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE sunUranus     {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE sunNeptune    {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE sunPluto      {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE moonMercury   {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE moonVenus      {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE moonMars      {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE moonJupiter   {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE moonSaturn    {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE moonUranus    {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE moonNeptune   {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE moonPluto      {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE mercuryVenus  {Conjunction,SextileTrine} \r\n");
      headerBuffer.append("@ATTRIBUTE mercuryMars   {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE mercuryJupiter{Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE mercurySaturn {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE mercuryUranus {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE mercuryNeptune{Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE mercuryPluto  {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE venusMars      {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE venusJupiter  {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE venusSaturn   {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE venusUranus   {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE venusNeptune  {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE venusPluto    {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE marsJupiter   {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE marsSaturn    {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE marsUranus    {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE marsNeptune   {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE marsPluto      {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE jupiterSaturn {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE jupiterUranus {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE jupiterNeptune{Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE jupiterPluto  {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE saturnUranus  {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE saturnNeptune {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE saturnPluto    {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE uranusNeptune {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE uranusPluto    {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE neptunrPluto  {Conjunction,SextileTrine,SquareOpposition} \r\n");

      
      //headerBuffer.append("@ATTRIBUTE category {sport,scientist,military,painter,musician,actor,politician,writerJournalist,executive,murderer,alcoholic,mental} \r\n");
      //headerBuffer.append("@ATTRIBUTE category {sport,scientist,military,painterMusicianActor ,politician,writerJournalist,executive} \r\n");
      headerBuffer.append("@ATTRIBUTE category {sport,scientist,military,painterMusicianActor ,politician,writerJournalist} \r\n");

      bWriter.append(headerBuffer.toString());
      bWriter.append("\r\n");
      bWriter.append("@DATA\r\n");
      bWriter.flush();

      for (GPerson person : gpersons)
      {
        StringBuffer sb = new StringBuffer();
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
        
        GPersonAspect aspect = person.getAspect();
        sb.append(processAspect(aspect.getSunMoon()) + " , ");
        sb.append(processAspect(aspect.getSunMercury()) + " , ");
        sb.append(processAspect(aspect.getSunVenus()) + " , ");
        sb.append(processAspect(aspect.getSunMars()) + " , ");
        sb.append(processAspect(aspect.getSunJupiter()) + " , ");
        sb.append(processAspect(aspect.getSunSaturn()) + " , ");
        sb.append(processAspect(aspect.getSunUranus()) + " , ");
        sb.append(processAspect(aspect.getSunNeptune()) + " , ");
        sb.append(processAspect(aspect.getSunPluto()) + " , ");
        sb.append(processAspect(aspect.getMoonMercury()) + " , ");
        sb.append(processAspect(aspect.getMoonVenus()) + " , ");
        sb.append(processAspect(aspect.getMoonMars()) + " , ");
        sb.append(processAspect(aspect.getMoonJupiter()) + " , ");
        sb.append(processAspect(aspect.getMoonSaturn()) + " , ");
        sb.append(processAspect(aspect.getMoonUranus()) + " , ");
        sb.append(processAspect(aspect.getMoonNeptune()) + " , ");
        sb.append(processAspect(aspect.getMoonPluto()) + " , ");
        sb.append(processAspect(aspect.getMercuryVenus()) + " , ");
        sb.append(processAspect(aspect.getMercuryMars()) + " , ");
        sb.append(processAspect(aspect.getMercuryJupiter()) + " , ");
        sb.append(processAspect(aspect.getMercurySaturn()) + " , ");
        sb.append(processAspect(aspect.getMercuryUranus()) + " , ");
        sb.append(processAspect(aspect.getMercuryNeptune()) + " , ");
        sb.append(processAspect(aspect.getMercuryPluto()) + " , ");
        sb.append(processAspect(aspect.getVenusMars()) + " , ");
        sb.append(processAspect(aspect.getVenusJupiter()) + " , ");
        sb.append(processAspect(aspect.getVenusSaturn()) + " , ");
        sb.append(processAspect(aspect.getVenusUranus()) + " , ");
        sb.append(processAspect(aspect.getVenusNeptune()) + " , ");
        sb.append(processAspect(aspect.getVenusPluto()) + " , ");
        sb.append(processAspect(aspect.getMarsJupiter()) + " , ");
        sb.append(processAspect(aspect.getMarsSaturn()) + " , ");
        sb.append(processAspect(aspect.getMarsUranus()) + " , ");
        sb.append(processAspect(aspect.getMarsNeptune()) + " , ");
        sb.append(processAspect(aspect.getMarsPluto()) + " , ");
        sb.append(processAspect(aspect.getJupiterSaturn()) + " , ");
        sb.append(processAspect(aspect.getJupiterUranus()) + " , ");
        sb.append(processAspect(aspect.getJupiterNeptune()) + " , ");
        sb.append(processAspect(aspect.getJupiterPluto()) + " , ");
        sb.append(processAspect(aspect.getSaturnUranus()) + " , ");
        sb.append(processAspect(aspect.getSaturnNeptune()) + " , ");
        sb.append(processAspect(aspect.getSaturnPluto()) + " , ");
        sb.append(processAspect(aspect.getUranusNeptune()) + " , ");
        sb.append(processAspect(aspect.getUranusPluto()) + " , ");
        sb.append(processAspect(aspect.getNeptunePluto()) + " , ");
        
        //sb.append(person.getCategory() + "\r\n");
        String cat;
        if (person.getCategory().equalsIgnoreCase("writer") || person.getCategory().equalsIgnoreCase("journalist"))
          cat = "writerJournalist";
        else if (person.getCategory().contains("mental"))
          cat = "mental";
        else if (person.getCategory().equalsIgnoreCase("painter") || person.getCategory().equalsIgnoreCase("musician") || person.getCategory().equalsIgnoreCase("actor"))
          cat = "painterMusicianActor";
        else
          cat = person.getCategory();
        sb.append(cat+"\r\n");

        bWriter.append(sb);
        bWriter.flush();
      }

    }
    catch (Exception e)
    {
    }

  }
  
  /** 整合 aspects */
  private String processAspect(String orig)
  {
    if (orig == null)
      return "?";
    
    if (orig.equalsIgnoreCase("Sextile") || orig.equalsIgnoreCase("Trine"))
      return "SextileTrine";
    else if (orig.equalsIgnoreCase("Square") || orig.equalsIgnoreCase("Opposition"))
      return "SquareOpposition";
    return orig;
  }
}
