/**
 * @author smallufo 
 * Created on 2009/3/20 at 上午 4:47:05
 */
package destiny.data.gauquelin;

import java.io.Serializable;
import java.util.Locale;

import destiny.astrology.Planet;

/** 計算星體在四個角點的力量 */
public class GPersonAnglePower implements Serializable
{
  private long    personId;
  private GPerson gperson;

  private String  sun;
  private double  sunPower;

  private String  moon;
  private double  moonPower;

  private String  mercury;
  private double  mercuryPower;

  private String  venus;
  private double  venusPower;

  private String  mars;
  private double  marsPower;

  private String  jupiter;
  private double  jupiterPower;

  private String  saturn;
  private double  saturnPower;

  private String  uranus;
  private double  uranusPower;

  private String  neptune;
  private double  neptunePower;

  private String  pluto;
  private double  plutoPower;

  public GPersonAnglePower()
  {
  }

  public void setValue(Planet planet, String direction, double power)
  {
    RefUtil r = new RefUtil(this);
    r.setValue(planet.toString(Locale.ENGLISH), direction);
    r.setValue(planet.toString(Locale.ENGLISH) + "Power", power);
  }

  @Override
  public String toString()
  {
    StringBuffer sb = new StringBuffer();
    RefUtil r = new RefUtil(this);
    for (String prop : RefUtil.getProperties(getClass()))
    {
      sb.append(prop);
      sb.append(":");
      sb.append(r.getValue(prop));
      sb.append("\n ");
    }
    return sb.toString();
  }

  public long getPersonId()
  {
    return personId;
  }

  public void setPersonId(long id)
  {
    this.personId = id;
  }

  public GPerson getGperson()
  {
    return gperson;
  }

  public void setGperson(GPerson gperson)
  {
    this.gperson = gperson;
  }

  public String getSun()
  {
    return sun;
  }

  public void setSun(String sun)
  {
    this.sun = sun;
  }

  public Double getSunPower()
  {
    return sunPower;
  }

  public void setSunPower(Double sunPower)
  {
    this.sunPower = sunPower;
  }

  public String getMoon()
  {
    return moon;
  }

  public void setMoon(String moon)
  {
    this.moon = moon;
  }

  public Double getMoonPower()
  {
    return moonPower;
  }

  public void setMoonPower(Double moonPower)
  {
    this.moonPower = moonPower;
  }

  public String getMercury()
  {
    return mercury;
  }

  public void setMercury(String mercury)
  {
    this.mercury = mercury;
  }

  public Double getMercuryPower()
  {
    return mercuryPower;
  }

  public void setMercuryPower(Double mercuryPower)
  {
    this.mercuryPower = mercuryPower;
  }

  public String getVenus()
  {
    return venus;
  }

  public void setVenus(String venus)
  {
    this.venus = venus;
  }

  public Double getVenusPower()
  {
    return venusPower;
  }

  public void setVenusPower(Double venusPower)
  {
    this.venusPower = venusPower;
  }

  public String getMars()
  {
    return mars;
  }

  public void setMars(String mars)
  {
    this.mars = mars;
  }

  public Double getMarsPower()
  {
    return marsPower;
  }

  public void setMarsPower(Double marsPower)
  {
    this.marsPower = marsPower;
  }

  public String getJupiter()
  {
    return jupiter;
  }

  public void setJupiter(String jupiter)
  {
    this.jupiter = jupiter;
  }

  public Double getJupiterPower()
  {
    return jupiterPower;
  }

  public void setJupiterPower(Double jupiterPower)
  {
    this.jupiterPower = jupiterPower;
  }

  public String getSaturn()
  {
    return saturn;
  }

  public void setSaturn(String saturn)
  {
    this.saturn = saturn;
  }

  public Double getSaturnPower()
  {
    return saturnPower;
  }

  public void setSaturnPower(Double saturnPower)
  {
    this.saturnPower = saturnPower;
  }

  public String getUranus()
  {
    return uranus;
  }

  public void setUranus(String uranus)
  {
    this.uranus = uranus;
  }

  public Double getUranusPower()
  {
    return uranusPower;
  }

  public void setUranusPower(Double uranusPower)
  {
    this.uranusPower = uranusPower;
  }

  public String getNeptune()
  {
    return neptune;
  }

  public void setNeptune(String neptune)
  {
    this.neptune = neptune;
  }

  public Double getNeptunePower()
  {
    return neptunePower;
  }

  public void setNeptunePower(Double neptunePower)
  {
    this.neptunePower = neptunePower;
  }

  public String getPluto()
  {
    return pluto;
  }

  public void setPluto(String pluto)
  {
    this.pluto = pluto;
  }

  public Double getPlutoPower()
  {
    return plutoPower;
  }

  public void setPlutoPower(Double plutoPower)
  {
    this.plutoPower = plutoPower;
  }

}
