/**
 * @author smallufo 
 * Created on 2009/3/25 at 上午 2:37:15
 */ 
package destiny.data.gauquelin.weka.anglePower_aspect;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import destiny.astrology.Aspect;
import destiny.astrology.HoroscopeAspectData;
import destiny.astrology.HoroscopeAspectsCalculator;
import destiny.astrology.HoroscopeAspectsCalculatorModern;
import destiny.astrology.HoroscopeContext;
import destiny.astrology.HoroscopeContextBean;
import destiny.astrology.HouseSystem;
import destiny.astrology.Planet;
import destiny.astrology.Point;
import destiny.astrology.Aspect.Importance;
import destiny.core.calendar.Location;
import destiny.core.calendar.Time;
import destiny.data.gauquelin.GPersonAnglePower;
import destiny.data.gauquelin.RefUtil;
import destiny.data.gauquelin.UtilHoroscopeAnglePower;
import destiny.data.gauquelin.weka.InstanceIF;

public class TimeLocation_AnglePower_Instance implements InstanceIF
{
  private static Instances instances;
  private HoroscopeContext context;
  
  public TimeLocation_AnglePower_Instance(Time time , Location location)
  {
    if (instances == null)
      parseInstances();
    
    HoroscopeContextBean bean = new HoroscopeContextBean();
    this.context = bean.getHoroscopeContext(time , location);
  }
  
  private void parseInstances()
  {
    //URL url = getClass().getResource("house_aspect.arff");
    URL url = getClass().getResource("anglePower_aspect.arff");
    File file;
    
    try
    {
      file = new File(url.toURI());
      FileReader fReader = new FileReader(file);
      instances = new Instances(fReader);
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
    context.setHouseSystem(HouseSystem.PLACIDUS);
    UtilHoroscopeAnglePower util = new UtilHoroscopeAnglePower(context);
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
    HoroscopeAspectsCalculator aspectCalculator = new HoroscopeAspectsCalculator(context.getHoroscope() , new HoroscopeAspectsCalculatorModern());
    
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
