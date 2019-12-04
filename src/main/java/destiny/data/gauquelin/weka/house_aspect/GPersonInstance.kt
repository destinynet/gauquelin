/**
 * Created by smallufo at 2009/3/19 下午 7:46:29
 */
package destiny.data.gauquelin.weka.house_aspect;

import java.io.File;
import java.io.FileReader;
import java.net.URL;

import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import destiny.data.gauquelin.GPerson;
import destiny.data.gauquelin.GPersonAspect;
import destiny.data.gauquelin.GPersonHouse;
import destiny.data.gauquelin.RefUtil;
import destiny.data.gauquelin.weka.InstanceIF;

public class GPersonInstance implements InstanceIF
{
  private GPerson gperson;
  private Instances instances;
  
  public GPersonInstance(GPerson gperson)
  {
    this.gperson = gperson;
    if (instances == null)
      parseInstances();
  }
  
  private void parseInstances()
  {
    URL url = getClass().getResource("header.arff");
    File file;
    
    try
    {
      file = new File(url.toURI());
      FileReader fReader = new FileReader(file);
      instances = new Instances(fReader);
      instances.setClassIndex(instances.numAttributes()-1);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  @Override
  public Instance getInstance()
  {
    System.err.println("instances = " + instances);
    Instance instance = new Instance(instances.numAttributes());
    instance.setDataset(instances);
    

    //====================== House ==========================
    GPersonHouse house = gperson.getHouseMap().get("placidus");
    
    for (String prop : RefUtil.getProperties(GPersonHouse.class))
    {
      Attribute attr = instances.attribute(prop); 
      if (attr!= null)
      {
        //System.out.println(prop + " : " + getValue(house, prop));
        RefUtil r = new RefUtil(house);
        instance.setValue(attr, r.getValue(prop).toString());
      }
    }
    
    //====================== Aspect ==========================
    
    for (String prop : RefUtil.getProperties(GPersonAspect.class))
    {
      Attribute attr = instances.attribute(prop); 
      if (attr!= null)
      {
        RefUtil r = new RefUtil(gperson.getAspect());
        Object value = r.getValue(prop);
        if (value != null)
        {
          String aspectString = value.toString();
          if (aspectString.equalsIgnoreCase("Square") || aspectString.equalsIgnoreCase("Opposition"))
            aspectString = "SquareOpposition";
          else if (aspectString.equalsIgnoreCase("Sextile") || aspectString.equalsIgnoreCase("Trine"))
            aspectString = "SextileTrine";
          instance.setValue(attr, aspectString);
        }
          
      }
    }
    
    return instance;
  }
}
