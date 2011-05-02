/**
 * Created by smallufo at 2009/3/13 下午 6:07:29
 */
package destiny.data.gauquelin;

import java.io.Serializable;
import java.util.Locale;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import destiny.astrology.HoroscopeAspectData;
import destiny.astrology.Planet;
import destiny.astrology.Point;

@Entity
@Table(name="aspect")
@Cacheable
/** 一個命盤的任兩顆星呈現什麼交角 */
public class GPersonAspect implements Serializable
{
  @Id
  @Column(name = "personId")
  private long personId;
  
  @OneToOne
  @PrimaryKeyJoinColumn
  private GPerson gperson;

  private String  sunMoon;
  private String  sunMercury;
  private String  sunVenus;
  private String  sunMars;
  private String  sunJupiter;
  private String  sunSaturn;
  private String  sunUranus;
  private String  sunNeptune;
  private String  sunPluto;
  private String  moonMercury;
  private String  moonVenus;
  private String  moonMars;
  private String  moonJupiter;
  private String  moonSaturn;
  private String  moonUranus;
  private String  moonNeptune;
  private String  moonPluto;
  private String  mercuryVenus;
  private String  mercuryMars;
  private String  mercuryJupiter;
  private String  mercurySaturn;
  private String  mercuryUranus;
  private String  mercuryNeptune;
  private String  mercuryPluto;
  private String  venusMars;
  private String  venusJupiter;
  private String  venusSaturn;
  private String  venusUranus;
  private String  venusNeptune;
  private String  venusPluto;
  private String  marsJupiter;
  private String  marsSaturn;
  private String  marsUranus;
  private String  marsNeptune;
  private String  marsPluto;
  private String  jupiterSaturn;
  private String  jupiterUranus;
  private String  jupiterNeptune;
  private String  jupiterPluto;
  private String  saturnUranus;
  private String  saturnNeptune;
  private String  saturnPluto;
  private String  uranusNeptune;
  private String  uranusPluto;
  private String  neptunrPluto;

  public GPersonAspect()
  {
  }

  public void setAspect(HoroscopeAspectData data)
  {
    Set<Point> twoPoints = data.getTwoPoints();
    String localeString = data.getAspect().toString(Locale.ENGLISH);
    
    if (twoPoints.contains(Planet.SUN) && twoPoints.contains(Planet.MOON))
      setSunMoon(localeString);
    else if (twoPoints.contains(Planet.SUN) && twoPoints.contains(Planet.MERCURY))
      setSunMercury(localeString);
    else if (twoPoints.contains(Planet.SUN) && twoPoints.contains(Planet.VENUS))
      setSunVenus(localeString);
    else if (twoPoints.contains(Planet.SUN) && twoPoints.contains(Planet.MARS))
      setSunMars(localeString);
    else if (twoPoints.contains(Planet.SUN) && twoPoints.contains(Planet.JUPITER))
      setSunJupiter(localeString);
    else if (twoPoints.contains(Planet.SUN) && twoPoints.contains(Planet.SATURN))
      setSunSaturn(localeString);
    else if (twoPoints.contains(Planet.SUN) && twoPoints.contains(Planet.URANUS))
      setSunUranus(localeString);
    else if (twoPoints.contains(Planet.SUN) && twoPoints.contains(Planet.NEPTUNE))
      setSunNeptune(localeString);
    else if (twoPoints.contains(Planet.SUN) && twoPoints.contains(Planet.PLUTO))
      setSunPluto(localeString);
    
    else if (twoPoints.contains(Planet.MOON) && twoPoints.contains(Planet.MERCURY))
      setMoonMercury(localeString);
    else if (twoPoints.contains(Planet.MOON) && twoPoints.contains(Planet.VENUS))
      setMoonVenus(localeString);
    else if (twoPoints.contains(Planet.MOON) && twoPoints.contains(Planet.MARS))
      setMoonMars(localeString);
    else if (twoPoints.contains(Planet.MOON) && twoPoints.contains(Planet.JUPITER))
      setMoonJupiter(localeString);
    else if (twoPoints.contains(Planet.MOON) && twoPoints.contains(Planet.SATURN))
      setMoonSaturn(localeString);
    else if (twoPoints.contains(Planet.MOON) && twoPoints.contains(Planet.URANUS))
      setMoonUranus(localeString);
    else if (twoPoints.contains(Planet.MOON) && twoPoints.contains(Planet.NEPTUNE))
      setMoonNeptune(localeString);
    else if (twoPoints.contains(Planet.MOON) && twoPoints.contains(Planet.PLUTO))
      setMoonPluto(localeString);
    
    else if (twoPoints.contains(Planet.MERCURY) && twoPoints.contains(Planet.VENUS))
      setMercuryVenus(localeString);
    else if (twoPoints.contains(Planet.MERCURY) && twoPoints.contains(Planet.MARS))
      setMercuryMars(localeString);
    else if (twoPoints.contains(Planet.MERCURY) && twoPoints.contains(Planet.JUPITER))
      setMercuryJupiter(localeString);
    else if (twoPoints.contains(Planet.MERCURY) && twoPoints.contains(Planet.SATURN))
      setMercurySaturn(localeString);
    else if (twoPoints.contains(Planet.MERCURY) && twoPoints.contains(Planet.URANUS))
      setMercuryUranus(localeString);
    else if (twoPoints.contains(Planet.MERCURY) && twoPoints.contains(Planet.NEPTUNE))
      setMercuryNeptune(localeString);
    else if (twoPoints.contains(Planet.MERCURY) && twoPoints.contains(Planet.PLUTO))
      setMercuryPluto(localeString);
    
    else if (twoPoints.contains(Planet.VENUS) && twoPoints.contains(Planet.MARS))
      setVenusMars(localeString);
    else if (twoPoints.contains(Planet.VENUS) && twoPoints.contains(Planet.JUPITER))
      setVenusJupiter(localeString);
    else if (twoPoints.contains(Planet.VENUS) && twoPoints.contains(Planet.SATURN))
      setVenusSaturn(localeString);
    else if (twoPoints.contains(Planet.VENUS) && twoPoints.contains(Planet.URANUS))
      setVenusUranus(localeString);
    else if (twoPoints.contains(Planet.VENUS) && twoPoints.contains(Planet.NEPTUNE))
      setVenusNeptune(localeString);
    else if (twoPoints.contains(Planet.VENUS) && twoPoints.contains(Planet.PLUTO))
      setVenusPluto(localeString);
    
    else if (twoPoints.contains(Planet.MARS) && twoPoints.contains(Planet.JUPITER))
      setMarsJupiter(localeString);
    else if (twoPoints.contains(Planet.MARS) && twoPoints.contains(Planet.SATURN))
      setMarsSaturn(localeString);
    else if (twoPoints.contains(Planet.MARS) && twoPoints.contains(Planet.URANUS))
      setMarsUranus(localeString);
    else if (twoPoints.contains(Planet.MARS) && twoPoints.contains(Planet.NEPTUNE))
      setMarsNeptune(localeString);
    else if (twoPoints.contains(Planet.MARS) && twoPoints.contains(Planet.PLUTO))
      setMarsPluto(localeString);
    
    else if (twoPoints.contains(Planet.JUPITER) && twoPoints.contains(Planet.SATURN))
      setJupiterSaturn(localeString);
    else if (twoPoints.contains(Planet.JUPITER) && twoPoints.contains(Planet.URANUS))
      setJupiterUranus(localeString);
    else if (twoPoints.contains(Planet.JUPITER) && twoPoints.contains(Planet.NEPTUNE))
      setJupiterNeptune(localeString);
    else if (twoPoints.contains(Planet.JUPITER) && twoPoints.contains(Planet.PLUTO))
      setJupiterPluto(localeString);
    
    else if (twoPoints.contains(Planet.SATURN) && twoPoints.contains(Planet.URANUS))
      setSaturnUranus(localeString);
    else if (twoPoints.contains(Planet.SATURN) && twoPoints.contains(Planet.NEPTUNE))
      setSaturnNeptune(localeString);
    else if (twoPoints.contains(Planet.SATURN) && twoPoints.contains(Planet.PLUTO))
      setSaturnPluto(localeString);
    
    else if (twoPoints.contains(Planet.URANUS) && twoPoints.contains(Planet.NEPTUNE))
      setUranusNeptune(localeString);
    else if (twoPoints.contains(Planet.URANUS) && twoPoints.contains(Planet.PLUTO))
      setUranusPluto(localeString);
    
    else if (twoPoints.contains(Planet.NEPTUNE) && twoPoints.contains(Planet.PLUTO))
      setNeptunrPluto(localeString);
    
      
  }

  public GPerson getGperson()
  {
    return gperson;
  }

  public void setGperson(GPerson gperson)
  {
    this.gperson = gperson;
  }

  public String getSunVenus()
  {
    return sunVenus;
  }

  public void setSunVenus(String sunVenus)
  {
    this.sunVenus = sunVenus;
  }

  public String getSunMars()
  {
    return sunMars;
  }

  public void setSunMars(String sunMars)
  {
    this.sunMars = sunMars;
  }

  public String getSunJupiter()
  {
    return sunJupiter;
  }

  public void setSunJupiter(String sunJupiter)
  {
    this.sunJupiter = sunJupiter;
  }

  public String getSunSaturn()
  {
    return sunSaturn;
  }

  public void setSunSaturn(String sunSaturn)
  {
    this.sunSaturn = sunSaturn;
  }

  public String getSunUranus()
  {
    return sunUranus;
  }

  public void setSunUranus(String sunUranus)
  {
    this.sunUranus = sunUranus;
  }

  public String getSunNeptune()
  {
    return sunNeptune;
  }

  public void setSunNeptune(String sunNeptune)
  {
    this.sunNeptune = sunNeptune;
  }

  public String getSunPluto()
  {
    return sunPluto;
  }

  public void setSunPluto(String sunPluto)
  {
    this.sunPluto = sunPluto;
  }

  public String getMoonMercury()
  {
    return moonMercury;
  }

  public void setMoonMercury(String moonMercury)
  {
    this.moonMercury = moonMercury;
  }

  public String getMoonVenus()
  {
    return moonVenus;
  }

  public void setMoonVenus(String moonVenus)
  {
    this.moonVenus = moonVenus;
  }

  public String getMoonMars()
  {
    return moonMars;
  }

  public void setMoonMars(String moonMars)
  {
    this.moonMars = moonMars;
  }

  public String getMoonJupiter()
  {
    return moonJupiter;
  }

  public void setMoonJupiter(String moonJupiter)
  {
    this.moonJupiter = moonJupiter;
  }

  public String getMoonSaturn()
  {
    return moonSaturn;
  }

  public void setMoonSaturn(String moonSaturn)
  {
    this.moonSaturn = moonSaturn;
  }

  public String getMoonUranus()
  {
    return moonUranus;
  }

  public void setMoonUranus(String moonUranus)
  {
    this.moonUranus = moonUranus;
  }

  public String getMoonNeptune()
  {
    return moonNeptune;
  }

  public void setMoonNeptune(String moonNeptune)
  {
    this.moonNeptune = moonNeptune;
  }

  public String getMoonPluto()
  {
    return moonPluto;
  }

  public void setMoonPluto(String moonPluto)
  {
    this.moonPluto = moonPluto;
  }

  public String getMercuryVenus()
  {
    return mercuryVenus;
  }

  public void setMercuryVenus(String mercuryVenus)
  {
    this.mercuryVenus = mercuryVenus;
  }

  public String getMercuryMars()
  {
    return mercuryMars;
  }

  public void setMercuryMars(String mercuryMars)
  {
    this.mercuryMars = mercuryMars;
  }

  public String getMercuryJupiter()
  {
    return mercuryJupiter;
  }

  public void setMercuryJupiter(String mercuryJupiter)
  {
    this.mercuryJupiter = mercuryJupiter;
  }

  public String getMercurySaturn()
  {
    return mercurySaturn;
  }

  public void setMercurySaturn(String mercurySaturn)
  {
    this.mercurySaturn = mercurySaturn;
  }

  public String getMercuryUranus()
  {
    return mercuryUranus;
  }

  public void setMercuryUranus(String mercuryUranus)
  {
    this.mercuryUranus = mercuryUranus;
  }

  public String getMercuryNeptune()
  {
    return mercuryNeptune;
  }

  public void setMercuryNeptune(String mercuryNeptune)
  {
    this.mercuryNeptune = mercuryNeptune;
  }

  public String getMercuryPluto()
  {
    return mercuryPluto;
  }

  public void setMercuryPluto(String mercuryPluto)
  {
    this.mercuryPluto = mercuryPluto;
  }

  public String getVenusMars()
  {
    return venusMars;
  }

  public void setVenusMars(String venusMars)
  {
    this.venusMars = venusMars;
  }

  public String getVenusJupiter()
  {
    return venusJupiter;
  }

  public void setVenusJupiter(String venusJupiter)
  {
    this.venusJupiter = venusJupiter;
  }

  public String getVenusSaturn()
  {
    return venusSaturn;
  }

  public void setVenusSaturn(String venusSaturn)
  {
    this.venusSaturn = venusSaturn;
  }

  public String getVenusUranus()
  {
    return venusUranus;
  }

  public void setVenusUranus(String venusUranus)
  {
    this.venusUranus = venusUranus;
  }

  public String getVenusNeptune()
  {
    return venusNeptune;
  }

  public void setVenusNeptune(String venusNeptune)
  {
    this.venusNeptune = venusNeptune;
  }

  public String getVenusPluto()
  {
    return venusPluto;
  }

  public void setVenusPluto(String venusPluto)
  {
    this.venusPluto = venusPluto;
  }

  public String getMarsJupiter()
  {
    return marsJupiter;
  }

  public void setMarsJupiter(String marsJupiter)
  {
    this.marsJupiter = marsJupiter;
  }

  public String getMarsSaturn()
  {
    return marsSaturn;
  }

  public void setMarsSaturn(String marsSaturn)
  {
    this.marsSaturn = marsSaturn;
  }

  public String getMarsUranus()
  {
    return marsUranus;
  }

  public void setMarsUranus(String marsUranus)
  {
    this.marsUranus = marsUranus;
  }

  public String getMarsNeptune()
  {
    return marsNeptune;
  }

  public void setMarsNeptune(String marsNeptune)
  {
    this.marsNeptune = marsNeptune;
  }

  public String getMarsPluto()
  {
    return marsPluto;
  }

  public void setMarsPluto(String marsPluto)
  {
    this.marsPluto = marsPluto;
  }

  public String getJupiterSaturn()
  {
    return jupiterSaturn;
  }

  public void setJupiterSaturn(String jupiterSaturn)
  {
    this.jupiterSaturn = jupiterSaturn;
  }

  public String getJupiterUranus()
  {
    return jupiterUranus;
  }

  public void setJupiterUranus(String jupiterUranus)
  {
    this.jupiterUranus = jupiterUranus;
  }

  public String getJupiterNeptune()
  {
    return jupiterNeptune;
  }

  public void setJupiterNeptune(String jupiterNeptune)
  {
    this.jupiterNeptune = jupiterNeptune;
  }

  public String getJupiterPluto()
  {
    return jupiterPluto;
  }

  public void setJupiterPluto(String jupiterPluto)
  {
    this.jupiterPluto = jupiterPluto;
  }

  public String getSaturnUranus()
  {
    return saturnUranus;
  }

  public void setSaturnUranus(String saturnUranus)
  {
    this.saturnUranus = saturnUranus;
  }

  public String getSaturnNeptune()
  {
    return saturnNeptune;
  }

  public void setSaturnNeptune(String saturnNeptune)
  {
    this.saturnNeptune = saturnNeptune;
  }

  public String getSaturnPluto()
  {
    return saturnPluto;
  }

  public void setSaturnPluto(String saturnPluto)
  {
    this.saturnPluto = saturnPluto;
  }

  public String getUranusNeptune()
  {
    return uranusNeptune;
  }

  public void setUranusNeptune(String uranusNeptune)
  {
    this.uranusNeptune = uranusNeptune;
  }

  public String getUranusPluto()
  {
    return uranusPluto;
  }

  public void setUranusPluto(String uranusPluto)
  {
    this.uranusPluto = uranusPluto;
  }

  public String getNeptunrPluto()
  {
    return neptunrPluto;
  }

  public void setNeptunrPluto(String neptunrPluto)
  {
    this.neptunrPluto = neptunrPluto;
  }

  public String getSunMoon()
  {
    return sunMoon;
  }

  public void setSunMoon(String sunMoon)
  {
    this.sunMoon = sunMoon;
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((gperson == null) ? 0 : gperson.hashCode());
    result = prime * result + ((jupiterNeptune == null) ? 0 : jupiterNeptune.hashCode());
    result = prime * result + ((jupiterPluto == null) ? 0 : jupiterPluto.hashCode());
    result = prime * result + ((jupiterSaturn == null) ? 0 : jupiterSaturn.hashCode());
    result = prime * result + ((jupiterUranus == null) ? 0 : jupiterUranus.hashCode());
    result = prime * result + ((marsJupiter == null) ? 0 : marsJupiter.hashCode());
    result = prime * result + ((marsNeptune == null) ? 0 : marsNeptune.hashCode());
    result = prime * result + ((marsPluto == null) ? 0 : marsPluto.hashCode());
    result = prime * result + ((marsSaturn == null) ? 0 : marsSaturn.hashCode());
    result = prime * result + ((marsUranus == null) ? 0 : marsUranus.hashCode());
    result = prime * result + ((mercuryJupiter == null) ? 0 : mercuryJupiter.hashCode());
    result = prime * result + ((mercuryMars == null) ? 0 : mercuryMars.hashCode());
    result = prime * result + ((mercuryNeptune == null) ? 0 : mercuryNeptune.hashCode());
    result = prime * result + ((mercuryPluto == null) ? 0 : mercuryPluto.hashCode());
    result = prime * result + ((mercurySaturn == null) ? 0 : mercurySaturn.hashCode());
    result = prime * result + ((mercuryUranus == null) ? 0 : mercuryUranus.hashCode());
    result = prime * result + ((mercuryVenus == null) ? 0 : mercuryVenus.hashCode());
    result = prime * result + ((moonJupiter == null) ? 0 : moonJupiter.hashCode());
    result = prime * result + ((moonMars == null) ? 0 : moonMars.hashCode());
    result = prime * result + ((moonMercury == null) ? 0 : moonMercury.hashCode());
    result = prime * result + ((moonNeptune == null) ? 0 : moonNeptune.hashCode());
    result = prime * result + ((moonPluto == null) ? 0 : moonPluto.hashCode());
    result = prime * result + ((moonSaturn == null) ? 0 : moonSaturn.hashCode());
    result = prime * result + ((moonUranus == null) ? 0 : moonUranus.hashCode());
    result = prime * result + ((moonVenus == null) ? 0 : moonVenus.hashCode());
    result = prime * result + ((neptunrPluto == null) ? 0 : neptunrPluto.hashCode());
    result = prime * result + ((saturnNeptune == null) ? 0 : saturnNeptune.hashCode());
    result = prime * result + ((saturnPluto == null) ? 0 : saturnPluto.hashCode());
    result = prime * result + ((saturnUranus == null) ? 0 : saturnUranus.hashCode());
    result = prime * result + ((sunJupiter == null) ? 0 : sunJupiter.hashCode());
    result = prime * result + ((sunMars == null) ? 0 : sunMars.hashCode());
    result = prime * result + ((sunMoon == null) ? 0 : sunMoon.hashCode());
    result = prime * result + ((sunNeptune == null) ? 0 : sunNeptune.hashCode());
    result = prime * result + ((sunPluto == null) ? 0 : sunPluto.hashCode());
    result = prime * result + ((sunSaturn == null) ? 0 : sunSaturn.hashCode());
    result = prime * result + ((sunUranus == null) ? 0 : sunUranus.hashCode());
    result = prime * result + ((sunVenus == null) ? 0 : sunVenus.hashCode());
    result = prime * result + ((uranusNeptune == null) ? 0 : uranusNeptune.hashCode());
    result = prime * result + ((uranusPluto == null) ? 0 : uranusPluto.hashCode());
    result = prime * result + ((venusJupiter == null) ? 0 : venusJupiter.hashCode());
    result = prime * result + ((venusMars == null) ? 0 : venusMars.hashCode());
    result = prime * result + ((venusNeptune == null) ? 0 : venusNeptune.hashCode());
    result = prime * result + ((venusPluto == null) ? 0 : venusPluto.hashCode());
    result = prime * result + ((venusSaturn == null) ? 0 : venusSaturn.hashCode());
    result = prime * result + ((venusUranus == null) ? 0 : venusUranus.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    GPersonAspect other = (GPersonAspect) obj;
    if (gperson == null)
    {
      if (other.gperson != null)
        return false;
    }
    else if (!gperson.equals(other.gperson))
      return false;
    if (jupiterNeptune == null)
    {
      if (other.jupiterNeptune != null)
        return false;
    }
    else if (!jupiterNeptune.equals(other.jupiterNeptune))
      return false;
    if (jupiterPluto == null)
    {
      if (other.jupiterPluto != null)
        return false;
    }
    else if (!jupiterPluto.equals(other.jupiterPluto))
      return false;
    if (jupiterSaturn == null)
    {
      if (other.jupiterSaturn != null)
        return false;
    }
    else if (!jupiterSaturn.equals(other.jupiterSaturn))
      return false;
    if (jupiterUranus == null)
    {
      if (other.jupiterUranus != null)
        return false;
    }
    else if (!jupiterUranus.equals(other.jupiterUranus))
      return false;
    if (marsJupiter == null)
    {
      if (other.marsJupiter != null)
        return false;
    }
    else if (!marsJupiter.equals(other.marsJupiter))
      return false;
    if (marsNeptune == null)
    {
      if (other.marsNeptune != null)
        return false;
    }
    else if (!marsNeptune.equals(other.marsNeptune))
      return false;
    if (marsPluto == null)
    {
      if (other.marsPluto != null)
        return false;
    }
    else if (!marsPluto.equals(other.marsPluto))
      return false;
    if (marsSaturn == null)
    {
      if (other.marsSaturn != null)
        return false;
    }
    else if (!marsSaturn.equals(other.marsSaturn))
      return false;
    if (marsUranus == null)
    {
      if (other.marsUranus != null)
        return false;
    }
    else if (!marsUranus.equals(other.marsUranus))
      return false;
    if (mercuryJupiter == null)
    {
      if (other.mercuryJupiter != null)
        return false;
    }
    else if (!mercuryJupiter.equals(other.mercuryJupiter))
      return false;
    if (mercuryMars == null)
    {
      if (other.mercuryMars != null)
        return false;
    }
    else if (!mercuryMars.equals(other.mercuryMars))
      return false;
    if (mercuryNeptune == null)
    {
      if (other.mercuryNeptune != null)
        return false;
    }
    else if (!mercuryNeptune.equals(other.mercuryNeptune))
      return false;
    if (mercuryPluto == null)
    {
      if (other.mercuryPluto != null)
        return false;
    }
    else if (!mercuryPluto.equals(other.mercuryPluto))
      return false;
    if (mercurySaturn == null)
    {
      if (other.mercurySaturn != null)
        return false;
    }
    else if (!mercurySaturn.equals(other.mercurySaturn))
      return false;
    if (mercuryUranus == null)
    {
      if (other.mercuryUranus != null)
        return false;
    }
    else if (!mercuryUranus.equals(other.mercuryUranus))
      return false;
    if (mercuryVenus == null)
    {
      if (other.mercuryVenus != null)
        return false;
    }
    else if (!mercuryVenus.equals(other.mercuryVenus))
      return false;
    if (moonJupiter == null)
    {
      if (other.moonJupiter != null)
        return false;
    }
    else if (!moonJupiter.equals(other.moonJupiter))
      return false;
    if (moonMars == null)
    {
      if (other.moonMars != null)
        return false;
    }
    else if (!moonMars.equals(other.moonMars))
      return false;
    if (moonMercury == null)
    {
      if (other.moonMercury != null)
        return false;
    }
    else if (!moonMercury.equals(other.moonMercury))
      return false;
    if (moonNeptune == null)
    {
      if (other.moonNeptune != null)
        return false;
    }
    else if (!moonNeptune.equals(other.moonNeptune))
      return false;
    if (moonPluto == null)
    {
      if (other.moonPluto != null)
        return false;
    }
    else if (!moonPluto.equals(other.moonPluto))
      return false;
    if (moonSaturn == null)
    {
      if (other.moonSaturn != null)
        return false;
    }
    else if (!moonSaturn.equals(other.moonSaturn))
      return false;
    if (moonUranus == null)
    {
      if (other.moonUranus != null)
        return false;
    }
    else if (!moonUranus.equals(other.moonUranus))
      return false;
    if (moonVenus == null)
    {
      if (other.moonVenus != null)
        return false;
    }
    else if (!moonVenus.equals(other.moonVenus))
      return false;
    if (neptunrPluto == null)
    {
      if (other.neptunrPluto != null)
        return false;
    }
    else if (!neptunrPluto.equals(other.neptunrPluto))
      return false;
    if (saturnNeptune == null)
    {
      if (other.saturnNeptune != null)
        return false;
    }
    else if (!saturnNeptune.equals(other.saturnNeptune))
      return false;
    if (saturnPluto == null)
    {
      if (other.saturnPluto != null)
        return false;
    }
    else if (!saturnPluto.equals(other.saturnPluto))
      return false;
    if (saturnUranus == null)
    {
      if (other.saturnUranus != null)
        return false;
    }
    else if (!saturnUranus.equals(other.saturnUranus))
      return false;
    if (sunJupiter == null)
    {
      if (other.sunJupiter != null)
        return false;
    }
    else if (!sunJupiter.equals(other.sunJupiter))
      return false;
    if (sunMars == null)
    {
      if (other.sunMars != null)
        return false;
    }
    else if (!sunMars.equals(other.sunMars))
      return false;
    if (sunMoon == null)
    {
      if (other.sunMoon != null)
        return false;
    }
    else if (!sunMoon.equals(other.sunMoon))
      return false;
    if (sunNeptune == null)
    {
      if (other.sunNeptune != null)
        return false;
    }
    else if (!sunNeptune.equals(other.sunNeptune))
      return false;
    if (sunPluto == null)
    {
      if (other.sunPluto != null)
        return false;
    }
    else if (!sunPluto.equals(other.sunPluto))
      return false;
    if (sunSaturn == null)
    {
      if (other.sunSaturn != null)
        return false;
    }
    else if (!sunSaturn.equals(other.sunSaturn))
      return false;
    if (sunUranus == null)
    {
      if (other.sunUranus != null)
        return false;
    }
    else if (!sunUranus.equals(other.sunUranus))
      return false;
    if (sunVenus == null)
    {
      if (other.sunVenus != null)
        return false;
    }
    else if (!sunVenus.equals(other.sunVenus))
      return false;
    if (uranusNeptune == null)
    {
      if (other.uranusNeptune != null)
        return false;
    }
    else if (!uranusNeptune.equals(other.uranusNeptune))
      return false;
    if (uranusPluto == null)
    {
      if (other.uranusPluto != null)
        return false;
    }
    else if (!uranusPluto.equals(other.uranusPluto))
      return false;
    if (venusJupiter == null)
    {
      if (other.venusJupiter != null)
        return false;
    }
    else if (!venusJupiter.equals(other.venusJupiter))
      return false;
    if (venusMars == null)
    {
      if (other.venusMars != null)
        return false;
    }
    else if (!venusMars.equals(other.venusMars))
      return false;
    if (venusNeptune == null)
    {
      if (other.venusNeptune != null)
        return false;
    }
    else if (!venusNeptune.equals(other.venusNeptune))
      return false;
    if (venusPluto == null)
    {
      if (other.venusPluto != null)
        return false;
    }
    else if (!venusPluto.equals(other.venusPluto))
      return false;
    if (venusSaturn == null)
    {
      if (other.venusSaturn != null)
        return false;
    }
    else if (!venusSaturn.equals(other.venusSaturn))
      return false;
    if (venusUranus == null)
    {
      if (other.venusUranus != null)
        return false;
    }
    else if (!venusUranus.equals(other.venusUranus))
      return false;
    return true;
  }

  public String getSunMercury()
  {
    return sunMercury;
  }

  public void setSunMercury(String sunMercury)
  {
    this.sunMercury = sunMercury;
  }

  public long getPersonId()
  {
    return personId;
  }

  public void setPersonId(long personId)
  {
    this.personId = personId;
  }
}
