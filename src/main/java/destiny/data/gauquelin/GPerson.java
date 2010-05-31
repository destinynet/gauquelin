/**
 * @author smallufo 
 * Created on 2009/3/5 at 下午 9:20:23
 */ 
package destiny.data.gauquelin;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import destiny.core.calendar.Location;
import destiny.core.calendar.Time;

@Entity
@Table(name="person")
@Cacheable
public class GPerson implements Serializable
{
  /** 資料庫的 id */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;
  
  private String category;
  
  /** 原始的 number ，每種職業會有獨一的 number . 不同職業的 number 會重複，不可拿來做 index */
  private int number;

  private String name;
  
  /** 男生 = 1 , 女生 = 0 , 未定義則為 -1 */
  private int gender = -1;
  
  /** 「未調整過時區」的原始出生時間 */
  private Timestamp gmtTimestamp;
  
  private String location;
  
  /** 地點 */
  private String place;
  
  /** 原始資料 */
  private String raw;
  
  /** 星體位於什麼宮 */
  @OneToMany(mappedBy="gperson" ,  cascade=CascadeType.ALL , fetch=FetchType.LAZY , orphanRemoval=true)
  @MapKey(name="house")
  private Map<String , GPersonHouse> houseMap = Collections.synchronizedMap(new HashMap<String , GPersonHouse>());
  
  /** 星體交角資料 */
  @OneToOne(mappedBy="gperson")
  @JoinColumn(name="personId")
  private GPersonAspect aspect;
  
  /** 交角強度 */
  @OneToOne(mappedBy="gperson")
  @JoinColumn(name="personId")
  private GPersonAnglePower anglePower;
  
  public GPerson()
  {
  }

  public void setId(long id)
  {
    this.id = id;
  }

  public long getId()
  {
    return id;
  }

  public String getCategory()
  {
    return category;
  }

  public void setCategory(String category)
  {
    this.category = category;
  }
  
  public int getNumber()
  {
    return number;
  }

  public void setNumber(int number)
  {
    this.number = number;
  }

  public int getGender()
  {
    return gender;
  }

  public void setGender(int gender)
  {
    this.gender = gender;
  }

  /** 資料都是 gmt 的 */
  public Time getGmtTime()
  {
    Calendar cal = Calendar.getInstance();
    cal.setTime(gmtTimestamp);
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH)+1;
    int day = cal.get(Calendar.DAY_OF_MONTH);
    int hour = cal.get(Calendar.HOUR_OF_DAY);
    int min = cal.get(Calendar.MINUTE);
    int sec = cal.get(Calendar.SECOND);
    
    return new Time(year , month , day , hour , min , sec);
  }
  
  public Timestamp getGmtTimestamp()
  {
    return gmtTimestamp;
  }

  public void setGmtTimestamp(Timestamp timestamp)
  {
    this.gmtTimestamp = timestamp;
  }

  public String getPlace()
  {
    return place;
  }

  public void setPlace(String place)
  {
    this.place = place;
  }

  public String getRaw()
  {
    return raw;
  }

  public void setRaw(String raw)
  {
    this.raw = raw;
  }

  public String getLocation()
  {
    return location;
  }

  public void setLocation(String location)
  {
    this.location = location;
  }
  
  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }
  
  @Override
  public String toString()
  {
    StringBuffer sb = new StringBuffer();
    sb.append("["+id+"] ");
    sb.append(" " + category);
    sb.append("\t");
    sb.append(number);
    sb.append("\t" + name);
    sb.append(" ");
    if (gender==1)
      sb.append("M");
    else if (gender == 0)
      sb.append("F");
    else
      sb.append("?");
    sb.append(" ");
    
    sb.append("gmt = " + gmtTimestamp);
    sb.append(" ");
    
    Location loc = Location.get(location);
    sb.append("loc = " + loc);
    
    sb.append(" ");
    sb.append(place);
    /*
    for(String house : houseMap.keySet())
      sb.append("\n分宮法：\t"+house);
    if (aspect != null)
      sb.append("\n日月交 : " + aspect.getSunMoon());
    */
    return sb.toString();
  }


  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + gender;
    result = prime * result + ((location == null) ? 0 : location.hashCode());
    result = prime * result + ((gmtTimestamp == null) ? 0 : gmtTimestamp.hashCode());
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
    GPerson other = (GPerson) obj;
    if (gender != other.gender)
      return false;
    if (location == null)
    {
      if (other.location != null)
        return false;
    }
    else if (!location.equals(other.location))
      return false;
    if (gmtTimestamp == null)
    {
      if (other.gmtTimestamp != null)
        return false;
    }
    else if (!gmtTimestamp.equals(other.gmtTimestamp))
      return false;
    return true;
  }

  public Map<String, GPersonHouse> getHouseMap()
  {
    return houseMap;
  }

  public void setHouseMap(Map<String, GPersonHouse> houseMap)
  {
    this.houseMap = houseMap;
  }

  public GPersonAspect getAspect()
  {
    return aspect;
  }

  public void setAspect(GPersonAspect aspect)
  {
    this.aspect = aspect;
  }

  public GPersonAnglePower getAnglePower()
  {
    return anglePower;
  }

  public void setAnglePower(GPersonAnglePower anglePower)
  {
    this.anglePower = anglePower;
  }

  
}
