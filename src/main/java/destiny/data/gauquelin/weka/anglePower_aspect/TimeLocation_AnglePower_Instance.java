/**
 * @author smallufo 
 * Created on 2009/3/25 at 上午 2:37:15
 */ 
package destiny.data.gauquelin.weka.anglePower_aspect;

import destiny.astrology.*;
import destiny.astrology.Aspect.Importance;
import destiny.core.calendar.Location;
import destiny.data.gauquelin.GPersonAnglePower;
import destiny.data.gauquelin.RefUtil;
import destiny.data.gauquelin.UtilHoroscopeAnglePower;
import destiny.data.gauquelin.weka.InstanceIF;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.*;

public class TimeLocation_AnglePower_Instance implements InstanceIF
{
  private static Instances instances;
  private HoroscopeContextIF horoscopeContext;

  public TimeLocation_AnglePower_Instance(IHoroscope horoscopeImpl, LocalDateTime time, Location location)
  {
    if (instances == null)
      parseInstances();
    
//    HoroscopeContextBean bean = new HoroscopeContextBean();
//    this.horoscopeContext = bean.getHoroscopeContextPlacidus(time , location);

    Set<Point> pointSet = new HashSet<>();
    pointSet.addAll(Arrays.asList(Planet.values));
    pointSet.addAll(Arrays.asList(Asteroid.values));
    pointSet.addAll(Arrays.asList(Hamburger.values));
    pointSet.addAll(Arrays.asList(FixedStar.values));
    pointSet.addAll(Arrays.asList(LunarNode.mean_values));
    this.horoscopeContext = horoscopeImpl.getHoroscope(time , location , pointSet , HouseSystem.PLACIDUS , Centric.GEO , Coordinate.ECLIPTIC);
  }
  
  private void parseInstances()
  {
    InputStream is = getClass().getResourceAsStream("anglePower_aspect.arff");
    Reader reader = new InputStreamReader(is);
    
    try
    {
      instances = new Instances(reader);
      instances.setClassIndex(instances.numAttributes()-1);
      
      /*
      Enumeration<Attribute> e = instances.enumerateAttributes();
      while(e.hasMoreElements())
      {
        System.out.println(e.nextElement());
      }
      */
    }
    catch (Exception e)
    {
      System.out.println("Exception : " + e);
    }
  }

  /**
   * 這是 anglePower + Aspect 的 instance
   */
  public Instance getInstance()
  {
    Instance instance = new Instance(instances.numAttributes());
    instance.setDataset(instances);
    
    // ================ AnglePower =================
    //horoscopeContext.setHouseSystem(HouseSystem.PLACIDUS);
    UtilHoroscopeAnglePower util = new UtilHoroscopeAnglePower(horoscopeContext);
    GPersonAnglePower anglePower = util.getAnglePower();
    RefUtil refUtil = new RefUtil(anglePower);
    for(Planet p : Planet.values)
    {
      String planetDirStr = p.toString(Locale.ENGLISH).toLowerCase()+"Dir";
      Attribute planetDir = instances.attribute(planetDirStr);
      instance.setValue(planetDir, (String)refUtil.getValue(p.toString(Locale.ENGLISH)));
      
      String planetPowerStr = p.toString(Locale.ENGLISH).toLowerCase()+"Power";
      Attribute planetPower = instances.attribute(planetPowerStr);
      instance.setValue(planetPower , (Double)refUtil.getValue(p.toString(Locale.ENGLISH).toLowerCase()+"Power"));
    }
    
    // ============ Aspect ============
    HoroscopeAspectsCalculator aspectCalculator = new HoroscopeAspectsCalculator(horoscopeContext.getHoroscope() , new HoroscopeAspectsCalculatorModern());
    
    for(HoroscopeAspectData data : aspectCalculator.getAspectDataSet(Arrays.asList(Planet.values) , Aspect.getAngles(Importance.HIGH)))
    {
      String aspectString = data.getAspect().toString(Locale.ENGLISH);
      Set<Point> twoPoints = new TreeSet<Point>(data.getTwoPoints());
      Iterator<Point> it = twoPoints.iterator();
      Point p1 = it.next();
      Point p2 = it.next();
      String propName = p1.toString(Locale.ENGLISH).toLowerCase()+p2.toString(Locale.ENGLISH);
      
      //看看是否有此 Attribute
      Attribute attr = instances.attribute(propName);
      if (attr != null)
      {
        if (aspectString.equalsIgnoreCase("Square") || aspectString.equalsIgnoreCase("Opposition"))
          aspectString = "SquareOpposition";
        else if (aspectString.equalsIgnoreCase("Sextile") || aspectString.equalsIgnoreCase("Trine"))
          aspectString = "SextileTrine";
        
        instance.setValue(attr, aspectString);
      }
    } // each aspect data

    return instance;
  }


}
