/**
 * Created by smallufo at 2009/3/12 下午 9:00:18
 */
package destiny.data.gauquelin;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="house")
@Cacheable
public class GPersonHouse implements Serializable
{
  /** 資料庫的 id */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long    id;

  @ManyToOne
  @JoinColumn(name="personId" , insertable=false , updatable=false)
  private GPerson gperson;

  private String  house;

  private int     sun     = 0;
  private int     moon    = 0;
  private int     mercury = 0;
  private int     venus   = 0;
  private int     mars    = 0;
  private int     jupiter = 0;
  private int     saturn  = 0;
  private int     uranus  = 0;
  private int     neptune = 0;
  private int     pluto   = 0;

  

  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }

  public GPerson getGperson()
  {
    return gperson;
  }

  public void setGperson(GPerson gperson)
  {
    this.gperson = gperson;
  }

  public String getHouse()
  {
    return house;
  }

  public void setHouse(String house)
  {
    this.house = house;
  }

  public int getSun()
  {
    return sun;
  }

  public void setSun(int sun)
  {
    this.sun = sun;
  }

  public int getMoon()
  {
    return moon;
  }

  public void setMoon(int moon)
  {
    this.moon = moon;
  }

  public int getMercury()
  {
    return mercury;
  }

  public void setMercury(int mercury)
  {
    this.mercury = mercury;
  }

  public int getVenus()
  {
    return venus;
  }

  public void setVenus(int venus)
  {
    this.venus = venus;
  }

  public int getMars()
  {
    return mars;
  }

  public void setMars(int mars)
  {
    this.mars = mars;
  }

  public int getJupiter()
  {
    return jupiter;
  }

  public void setJupiter(int jupiter)
  {
    this.jupiter = jupiter;
  }

  public int getSaturn()
  {
    return saturn;
  }

  public void setSaturn(int saturn)
  {
    this.saturn = saturn;
  }

  public int getUranus()
  {
    return uranus;
  }

  public void setUranus(int uranus)
  {
    this.uranus = uranus;
  }

  public int getNeptune()
  {
    return neptune;
  }

  public void setNeptune(int neptune)
  {
    this.neptune = neptune;
  }

  public int getPluto()
  {
    return pluto;
  }

  public void setPluto(int pluto)
  {
    this.pluto = pluto;
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((gperson == null) ? 0 : gperson.hashCode());
    result = prime * result + ((house == null) ? 0 : house.hashCode());
    result = prime * result + jupiter;
    result = prime * result + mars;
    result = prime * result + mercury;
    result = prime * result + moon;
    result = prime * result + neptune;
    result = prime * result + pluto;
    result = prime * result + saturn;
    result = prime * result + sun;
    result = prime * result + uranus;
    result = prime * result + venus;
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
    GPersonHouse other = (GPersonHouse) obj;
    if (gperson == null)
    {
      if (other.gperson != null)
        return false;
    }
    else if (!gperson.equals(other.gperson))
      return false;
    if (house == null)
    {
      if (other.house != null)
        return false;
    }
    else if (!house.equals(other.house))
      return false;
    if (jupiter != other.jupiter)
      return false;
    if (mars != other.mars)
      return false;
    if (mercury != other.mercury)
      return false;
    if (moon != other.moon)
      return false;
    if (neptune != other.neptune)
      return false;
    if (pluto != other.pluto)
      return false;
    if (saturn != other.saturn)
      return false;
    if (sun != other.sun)
      return false;
    if (uranus != other.uranus)
      return false;
    if (venus != other.venus)
      return false;
    return true;
  }

  @Override
  public String toString()
  {
    return "GPersonHouse [sun=" + sun + ", moon=" + moon + ", mercury=" + mercury + ", venus=" + venus + ", mars=" + mars + ", jupiter=" + jupiter + ", saturn=" + saturn + ", neptune=" + neptune + ", uranus=" + uranus + ", pluto=" + pluto + "]";
  }


}
