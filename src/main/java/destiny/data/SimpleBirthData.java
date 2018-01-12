/**
 * @author smallufo 
 * Created on 2008/7/26 at 上午 3:53:39
 */
package destiny.data;

import destiny.core.Gender;
import destiny.core.IGender;
import destiny.core.calendar.IDate;

/** 只有性別 , 生日 */
public class SimpleBirthData extends BirthDataObject implements IGender, IDate
{
  /** 性別 */
  protected Gender  gender;

  protected boolean ad;

  /** 年月日 */
  protected int     year, month, day;

  public SimpleBirthData(Gender gender, int year, int month, int day)
  {
    this.gender = gender;
    if (year <= 0)
    {
      this.ad = false;
      this.year = -(year - 1); //取正值
    }
    else
    {
      this.ad = true;
      this.year = year;
    }
    this.month = month;
    this.day = day;    
  }

  
  @Override
  public Gender getGender()
  {
    return gender;
  }

  @Override
  public int getYear()
  {
    return year;
  }

  @Override
  public int getMonth()
  {
    return month;
  }

  @Override
  public int getDay()
  {
    return day;
  }

  @Override
  public boolean isAd()
  {
    return ad;
  }

  @Override
  public String toString()
  {
    //傳回格式 男/2008-07-26
    return gender.toString() + "/" + year+"-"+(month<10?"0":"")+month +"-"+ (day<10?"0":"")+day ;
  }
}
