/**
 * @author smallufo 
 * Created on 2009/3/21 at 下午 3:01:34
 */ 
package destiny.data.gauquelin.weka;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.Locale;

import destiny.astrology.Planet;
import destiny.data.gauquelin.GPerson;
import destiny.data.gauquelin.GPersonAnglePower;
import destiny.data.gauquelin.GPersonAspect;
import destiny.data.gauquelin.RefUtil;

/**
 * 星體在尖角的強度 + 星體之間的交角
 */
public class ArffOutputterAnglePowerAspect
{
  private List<GPerson> gpersons;
  private String        outputFile;
  
  
  public ArffOutputterAnglePowerAspect(List<GPerson> gpersons, String outputFile)
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

      headerBuffer.append("@ATTRIBUTE sunDir       {east , top , west , bottom} \r\n");
      headerBuffer.append("@ATTRIBUTE sunPower     NUMERIC \r\n");
      headerBuffer.append("@ATTRIBUTE moonDir      {east , top , west , bottom} \r\n");
      headerBuffer.append("@ATTRIBUTE moonPower    NUMERIC \r\n");
      headerBuffer.append("@ATTRIBUTE mercuryDir   {east , top , west , bottom} \r\n");
      headerBuffer.append("@ATTRIBUTE mercuryPower NUMERIC \r\n");
      headerBuffer.append("@ATTRIBUTE venusDir     {east , top , west , bottom} \r\n");
      headerBuffer.append("@ATTRIBUTE venusPower   NUMERIC \r\n");
      headerBuffer.append("@ATTRIBUTE marsDir      {east , top , west , bottom} \r\n");
      headerBuffer.append("@ATTRIBUTE marsPower    NUMERIC \r\n");
      headerBuffer.append("@ATTRIBUTE jupiterDir   {east , top , west , bottom} \r\n");
      headerBuffer.append("@ATTRIBUTE jupiterPower NUMERIC \r\n");
      headerBuffer.append("@ATTRIBUTE saturnDir    {east , top , west , bottom} \r\n");
      headerBuffer.append("@ATTRIBUTE saturnPower  NUMERIC \r\n");
      headerBuffer.append("@ATTRIBUTE uranusDir    {east , top , west , bottom} \r\n");
      headerBuffer.append("@ATTRIBUTE uranusPower  NUMERIC \r\n");
      headerBuffer.append("@ATTRIBUTE neptuneDir   {east , top , west , bottom} \r\n");
      headerBuffer.append("@ATTRIBUTE neptunePower NUMERIC \r\n");
      headerBuffer.append("@ATTRIBUTE plutoDir     {east , top , west , bottom} \r\n");
      headerBuffer.append("@ATTRIBUTE plutoPower   NUMERIC \r\n");

      
      headerBuffer.append("@ATTRIBUTE sunMoon       {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE sunMercury    {Conjunction} \r\n");
      headerBuffer.append("@ATTRIBUTE sunVenus      {Conjunction} \r\n");
      headerBuffer.append("@ATTRIBUTE sunMars       {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE sunJupiter    {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE sunSaturn     {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE sunUranus     {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE sunNeptune    {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE sunPluto      {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE moonMercury   {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE moonVenus     {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE moonMars      {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE moonJupiter   {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE moonSaturn    {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE moonUranus    {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE moonNeptune   {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE moonPluto     {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE mercuryVenus  {Conjunction,SextileTrine} \r\n");
      headerBuffer.append("@ATTRIBUTE mercuryMars   {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE mercuryJupiter{Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE mercurySaturn {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE mercuryUranus {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE mercuryNeptune{Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE mercuryPluto  {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE venusMars     {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE venusJupiter  {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE venusSaturn   {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE venusUranus   {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE venusNeptune  {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE venusPluto    {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE marsJupiter   {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE marsSaturn    {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE marsUranus    {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE marsNeptune   {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE marsPluto     {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE jupiterSaturn {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE jupiterUranus {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE jupiterNeptune{Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE jupiterPluto  {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE saturnUranus  {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE saturnNeptune {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE saturnPluto   {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE uranusNeptune {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE uranusPluto   {Conjunction,SextileTrine,SquareOpposition} \r\n");
      headerBuffer.append("@ATTRIBUTE neptunrPluto  {Conjunction,SextileTrine,SquareOpposition} \r\n");

      
      //headerBuffer.append("@ATTRIBUTE category {sport,scientist,military,painter,musician,actor,politician,writerJournalist,executive,murderer,alcoholic,mental} \r\n");
      headerBuffer.append("@ATTRIBUTE category {sport,scientist,military,painterMusicianActor , writerJournalist} \r\n");
      //headerBuffer.append("@ATTRIBUTE category {sport,scientist,military,painter, musician , actor ,politician,writer , journalist} \r\n");

      bWriter.append(headerBuffer.toString());
      bWriter.append("\r\n");
      bWriter.append("@DATA\r\n");
      bWriter.flush();

      RefUtil refUtil;
      for (GPerson person : gpersons)
      {
        StringBuffer sb = new StringBuffer();
        GPersonAnglePower anglePower = person.getAnglePower();
        
        refUtil = new RefUtil(anglePower);
        for(Planet planet : Planet.values)
        {
          String dir = (String) refUtil.getValue(planet.toString(Locale.ENGLISH).toLowerCase());
          sb.append(dir);
          sb.append(",");
          Double d = (Double) refUtil.getValue(planet.toString(Locale.ENGLISH).toLowerCase()+"Power");
          sb.append(d);
          sb.append(", " );
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
        sb.append(processAspect(aspect.getNeptunrPluto()) + " , ");
        
        String cat = person.getCategory();
        if (person.getCategory().equalsIgnoreCase("writer") || person.getCategory().equalsIgnoreCase("journalist"))
          cat = "writerJournalist";
        else if (person.getCategory().contains("mental"))
          cat = "mental";
        else if (person.getCategory().equalsIgnoreCase("painter") || person.getCategory().equalsIgnoreCase("musician") || person.getCategory().equalsIgnoreCase("actor"))
          cat = "painterMusicianActor";
        
        sb.append(cat);
        sb.append("\r\n");

        bWriter.append(sb);
        bWriter.flush();
      }

    }
    catch (Exception e)
    {
    }
  } // process()
  

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
