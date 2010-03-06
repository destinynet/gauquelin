/**
 * @author smallufo 
 * Created on 2009/3/7 at 下午 10:51:46
 */ 
package destiny.data.gauquelin;

import java.io.Serializable;

public class NameData implements Serializable
{
  private int year;
  private int month;
  private int day;
  private String name;
  
  public NameData(int year , int month , int day , String name)
  {
    this.year = year;
    this.month = month;
    this.day = day;
    this.name = name;
  }

  public int getYear()
  {
    return year;
  }

  public int getMonth()
  {
    return month;
  }

  public int getDay()
  {
    return day;
  }

  public String getName()
  {
    return name;
  }

  @Override
  public String toString()
  {
    return year+"/"+month+"/"+day+ " : " + name;
  }
  
}
