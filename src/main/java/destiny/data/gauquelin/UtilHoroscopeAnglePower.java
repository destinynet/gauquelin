/**
 * @author smallufo 
 * Created on 2009/3/25 at 上午 2:14:01
 */ 
package destiny.data.gauquelin;

import destiny.astrology.Horoscope;
import destiny.astrology.Planet;
import destiny.astrology.PositionWithAzimuth;
import destiny.astrology.Utils;

import java.io.Serializable;

public class UtilHoroscopeAnglePower implements Serializable
{
  private GPersonAnglePower anglePower;
  
  public UtilHoroscopeAnglePower(Horoscope h)
  {
    anglePower = new GPersonAnglePower();
    
    double degEast = h.getCuspDegree(1);
    double degTop = h.getCuspDegree(10);
    double degWest = h.getCuspDegree(7);
    double degBottom = h.getCuspDegree(4);
    for(Planet planet : Planet.values)
    {
      //與四個頂點，哪個點最近
      String nearestAngle = null;
      double tempError = 360.0;

      PositionWithAzimuth positionWithAzimuth = h.getPosition(planet);
      assert positionWithAzimuth!= null;

      double planetDeg = positionWithAzimuth.getLng();
      // ========================= 方向 ===========================
      if (Horoscope.Companion.getAngle(planetDeg , degEast) < tempError) {
        tempError = Horoscope.Companion.getAngle(planetDeg, degEast);
        nearestAngle = "east";
      }
      if (Horoscope.Companion.getAngle(planetDeg , degTop) < tempError) {
        tempError = Horoscope.Companion.getAngle(planetDeg, degTop);
        nearestAngle = "top";
      }

      if (Horoscope.Companion.getAngle(planetDeg, degWest) < tempError) {
        tempError = Horoscope.Companion.getAngle(planetDeg, degWest);
        nearestAngle = "west";
      }
      if (Horoscope.Companion.getAngle(planetDeg, degBottom) < tempError) {
        tempError = Horoscope.Companion.getAngle(planetDeg, degBottom);
        nearestAngle = "bottom";
      }

      // =================== 力量 ======================
      double smaller=0,larger=0,orientalCusp=0,occidentalCusp=0,cuspDeg=0,power=0;
      assert nearestAngle != null;
      if (nearestAngle.equals("east"))
      {
        larger = Utils.getNormalizeDegree(degEast + 10);
        smaller = Utils.getNormalizeDegree(degEast - 20);
        cuspDeg = degEast;
        orientalCusp = degTop;
        occidentalCusp = degBottom;
      }
      else if (nearestAngle.equals("top"))
      {
        larger = Utils.getNormalizeDegree(degTop + 10);
        smaller = Utils.getNormalizeDegree(degTop -20);
        cuspDeg = degTop;
        orientalCusp = degWest;
        occidentalCusp = degEast;
      }
      else if (nearestAngle.equals("west"))
      {
        larger = Utils.getNormalizeDegree(degWest );
        smaller = Utils.getNormalizeDegree(degWest -20);
        cuspDeg = degWest;
        orientalCusp = degBottom;
        occidentalCusp = degTop;
      }
      else if (nearestAngle.equals("bottom"))
      {
        larger = Utils.getNormalizeDegree(degBottom);
        smaller = Utils.getNormalizeDegree(degBottom -20);
        cuspDeg = degBottom;
        orientalCusp = degEast;
        occidentalCusp = degWest;
      }
      power = getPower(orientalCusp , smaller , cuspDeg , larger , occidentalCusp , planetDeg);

      anglePower.setValue(planet , nearestAngle , power);
    }
  }
  
  public GPersonAnglePower getAnglePower()
  {
    return this.anglePower;
  }
  
  private double getPower(double orientalCusp , double smaller , double cuspDeg , double larger , double occidentalCusp , double degree)
  {
    // 先求出中心度數（最強點)
    double center = Utils.getNormalizeDegree((Horoscope.Companion.getAngle(smaller, larger) / 2 ) + smaller);
    // 離中心點幾度
    double distance = Horoscope.Companion.getAngle(center , degree);
    // 再算影響範圍的半徑 ( smaller 到 larger 除以 2)
    double radius = Horoscope.Companion.getAngle(smaller , larger) / 2;

    if (Horoscope.Companion.isOccidental(degree, larger))
    {
      //比「大」更大
      double half = Horoscope.Companion.getAngle(occidentalCusp, cuspDeg);
      return - (distance - radius) / (half - radius);
    }
    else if (Horoscope.Companion.isOriental(degree , smaller))
    {
      //比「小」更小
      double half = Horoscope.Companion.getAngle(orientalCusp, cuspDeg)/2;
      return - (distance - radius) / (half - radius);
    }
    else
    {
      // 在範圍內
      return 1 - (distance/radius);
    }
  }


}
