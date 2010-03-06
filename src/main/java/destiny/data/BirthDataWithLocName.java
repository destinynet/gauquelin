/**
 * @author smallufo 
 * Created on 2008/4/1 at 上午 5:43:00
 */ 
package destiny.data;

import destiny.core.Gender;
import destiny.core.calendar.Location;
import destiny.core.calendar.Time;

public class BirthDataWithLocName extends BirthData
{
  /** 命造姓名 */
  private String name;
  private String locationName = "";
  
  public BirthDataWithLocName(String name , Gender gender , Time time , Location location)
  {
    super(gender , time , location);
    this.name = name;
  }

  public String getLocationName()
  {
    return locationName;
  }

  public void setLocationName(String locationName)
  {
    this.locationName = locationName;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }
  
}
