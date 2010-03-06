/**
 * @author smallufo 
 * Created on 2009/3/21 at 下午 11:00:58
 */ 
package destiny.data.mining;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import destiny.core.Gender;
import destiny.core.calendar.Location;
import destiny.core.calendar.Time;

@Entity
@Table(name = "person")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class MiningPerson implements Serializable
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;
  
  private String name;
  
  private boolean gender;
  
  private Timestamp lmt;
  
  private String location;
  
  private String locationName;
  
  private String email;
  
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdTime;
  
  public MiningPerson()
  {
    this.createdTime = new Timestamp(System.currentTimeMillis());
  }
  
  public MiningPerson(String name , Gender g , Time time , Location location , String locationName , String email)
  {
    this.name = name;
    this.gender = (g == Gender.男 ? true : false); 
    this.lmt = time.getTimestamp();
    this.location = location.getDebugString();
    this.locationName = locationName;
    this.email = email;
    this.createdTime = new Timestamp(System.currentTimeMillis());
  }
  
  @Override
  public String toString()
  {
    return "Person [id=" + id + ", name=" + name + ", gender=" + gender + ", lmt=" + lmt + ", createdTime=" + createdTime + ", location=" + location + ", locationName=" + locationName + ", email=" + email + " , createdTime = " + createdTime +"]";
  }


  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public boolean isGender()
  {
    return gender;
  }

  public void setGender(boolean gender)
  {
    this.gender = gender;
  }

  public Timestamp getLmt()
  {
    return lmt;
  }

  public void setLmt(Timestamp lmt)
  {
    this.lmt = lmt;
  }

  public String getLocation()
  {
    return location;
  }

  public void setLocation(String location)
  {
    this.location = location;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getLocationName()
  {
    return locationName;
  }

  public void setLocationName(String locationName)
  {
    this.locationName = locationName;
  }

  public Date getCreatedTime()
  {
    return createdTime;
  }

  public void setCreatedTime(Timestamp createdTime)
  {
    this.createdTime = createdTime;
  }
  
  
}
