/**
 * Created by smallufo at 2009/3/19 下午 9:16:36
 */
package destiny.data.gauquelin.weka.house_aspect;

import destiny.astrology.*;
import destiny.astrology.Aspect.Importance;
import destiny.core.calendar.Location;
import destiny.core.calendar.Time;
import destiny.data.gauquelin.weka.InstanceIF;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.*;

/** 從 time , location 取得 instance */
public class TimeLocation_House_Aspect_Instance implements InstanceIF
{
  private static Instances instances;
  private HoroscopeContext context;
  
  public TimeLocation_House_Aspect_Instance(Time time , Location location)
  {
    if (instances == null)
      parseInstances();
    
    HoroscopeContextBean bean = new HoroscopeContextBean();
    this.context = bean.getHoroscopeContextPlacidus(time.toLocalDateTime(), location);
  }
  
  @SuppressWarnings("rawtypes" )
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
      
      Enumeration e = instances.enumerateAttributes();
      while(e.hasMoreElements())
      {
        System.out.println(e.nextElement());
      }
    }
    catch (Exception e)
    {
    }
  }
  

  /**
   * 這是 House + Aspect 的 instance
   */
  public Instance getInstance()
  {
    Instance instance = new Instance(instances.numAttributes());
    instance.setDataset(instances);
    
    
    // ============ House =============
    context.setHouseSystem(HouseSystem.PLACIDUS);
    for(Planet p : Planet.values)
    {
      String attrString = p.toString(Locale.ENGLISH).toLowerCase();
      Attribute attr = instances.attribute(attrString);
      instance.setValue(attr, String.valueOf(context.getHouse(p)));
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
