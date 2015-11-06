/**
 * @author smallufo 
 * Created on 2009/3/5 at 下午 10:38:28
 */ 
package destiny.data.gauquelin;

import destiny.astrology.*;
import destiny.astrology.Aspect.Importance;
import destiny.core.calendar.Location;
import destiny.tools.location.GeolocationFinder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:gauquelin.xml"})
public class GPersonDaoImplTest// extends AbstractGauquelinTest
{
  @Inject
  protected GDao gDao;
  
  @Inject
  protected GeolocationFinder geolocationFinder;

  @Inject
  private HoroscopeContextBean horoscopeContextBean;
  
  protected List<TextDataReader> readers = Collections.synchronizedList(new ArrayList<TextDataReader>());
  
  //@Override
  protected void onSetUp() throws Exception
  {
    /*
    readers.add(new SportReader());
    readers.add(new Sport450Reader());
    
    readers.add(new ScientistReader());
    readers.add(new MilitaryReader());
    readers.add(new PainterReader());
    readers.add(new MusicianReader());
    readers.add(new ActorReader());
    readers.add(new PoliticianReader());
    readers.add(new WriterReader());
    readers.add(new JournalistReader());
    readers.add(new MurdererReader());
    readers.add(new AlcoholicReader());
    //心智五種
    readers.add(new AcuteDelusionReader()); // ACD
    readers.add(new HallucinatingReader()); // HALP
    readers.add(new MentallyDerangedReader()); // MD
    readers.add(new ManicDepressiveReader()); // MDP
    readers.add(new SchizophrenicsReader()); // SCH
    */
    
    //法國 2154 (2161) 人
    //readers.add(new SuccessfulFrench2154Reader(geolocationFinder));
  }

  public void _testStoreData()
  {
    for(TextDataReader reader : readers)
    {
      for(GPerson person : reader.getPersons())
      {
        gDao.save(person);
      }
    }
  }
  
  // @Test //太耗時，別測
  public void testFindNoAspectData()
  {
    System.err.println("gDao = " + gDao);
    for(GPerson p : gDao.findAll())
      assertNotNull(p.getAspect());
  }
  
  public void _testProcessAll()
  {
    int start = 0;
    int pageSize = 200;
    long count = gDao.getCount() - start;
    System.out.println("總共 " +count + "  筆資料");
    
    HoroscopeContext hc;
    for (int i=0 ; i <= count/pageSize ; i++)
    {
      List<GPerson> persons = gDao.findAll(i*pageSize + start , pageSize);
      
      for(GPerson p : persons)
      {
        hc = horoscopeContextBean.getHoroscopeContext(p.getGmtTime(), Location.get(p.getLocation()));

        boolean updated = false;
        if (p.getAspect() == null)
        {
          GPersonAspect aspect = processAspect(hc);
          aspect.setGperson(p);
          p.setAspect(aspect);
          updated = true;
        }
        
        if (p.getHouseMap().size() < 7)
        {
          processHouses(p , hc);
          updated = true;
        }
        
        if (p.getAnglePower() == null)
        {
          processAnglePower(p , hc);
          updated = true;
        }
        
        //System.err.println(p.toString() +"\n"+p.getAnglePower());        
        if (updated)
          gDao.update(p);
      }
    }//for
  }
  
  /** 處理高格林星體強勢度數 */
  private void processAnglePower(GPerson p, HoroscopeContext hc)
  {
    GPersonAnglePower anglePower = p.getAnglePower();
    if (anglePower == null)
      anglePower = new GPersonAnglePower();
    
    UtilHoroscopeAnglePower util = new UtilHoroscopeAnglePower(hc);
    anglePower = util.getAnglePower();

    anglePower.setGperson(p);
    p.setAnglePower(anglePower);
  }

  @Test
  public void testGet()
  {
    int pageSize = 10;
    
    String cat = "sport";
    
    long count = gDao.getCount(cat);
    System.out.println("總共 " +count + "  筆資料");
    
    HoroscopeContext hc;
    //HoroscopeContextBean bean = new HoroscopeContextBean();
    for (int i=0 ; i <= count/pageSize ; i++)
    {
      List<GPerson> persons = gDao.findAllByCategory(cat , i*pageSize , pageSize);
      for(GPerson p : persons)
      {
        hc = horoscopeContextBean.getHoroscopeContext(p.getGmtTime(), Location.get(p.getLocation()));
        System.err.println(p);
        GPersonAspect aspect = processAspect(hc);
        aspect.setGperson(p);
        p.setAspect(aspect);
        processHouses(p , hc);
        
        //gDao.update(p);
      }
    }//for
  }
  
  
  private GPersonAspect processAspect(HoroscopeContext hc)
  {
    GPersonAspect gpa = new GPersonAspect();
    HoroscopeAspectsCalculator aspectCalculator = new HoroscopeAspectsCalculator(hc.getHoroscope() , new HoroscopeAspectsCalculatorModern());
    
    for(HoroscopeAspectData data : aspectCalculator.getAspectDataSet(Arrays.asList(Planet.values) , Aspect.getAngles(Importance.HIGH)))
    {
      gpa.setAspect(data);
    } // each aspect data
    return gpa;
  }
  
  private void processHouses(GPerson p , HoroscopeContext hc)
  {
    GPersonHouse housePlacidus = new GPersonHouse();
    hc.setHouseSystem(HouseSystem.PLACIDUS);
    p.getHouseMap().put("placidus", processHouse(housePlacidus , hc));
    
    GPersonHouse houseKoch = new GPersonHouse();
    hc.setHouseSystem(HouseSystem.KOCH);
    p.getHouseMap().put("Koch", processHouse(houseKoch , hc));
    
    
    GPersonHouse houseRegiomontanus = new GPersonHouse();
    hc.setHouseSystem(HouseSystem.REGIOMONTANUS);
    p.getHouseMap().put("Regiomontanus", processHouse(houseRegiomontanus , hc));
    
    
    GPersonHouse housePorphyrius = new GPersonHouse();
    hc.setHouseSystem(HouseSystem.PORPHYRIUS);
    p.getHouseMap().put("Porphyrius", processHouse(housePorphyrius , hc));
    
    
    GPersonHouse houseCampanus = new GPersonHouse();
    hc.setHouseSystem(HouseSystem.CAMPANUS);
    p.getHouseMap().put("Campanus", processHouse(houseCampanus , hc));
    
    
    GPersonHouse houseEqual = new GPersonHouse();
    hc.setHouseSystem(HouseSystem.EQUAL);
    p.getHouseMap().put("Equal", processHouse(houseEqual , hc));
    
    
    GPersonHouse houseAlcabitius = new GPersonHouse();
    hc.setHouseSystem(HouseSystem.ALCABITIUS);
    p.getHouseMap().put("Alcabitius", processHouse(houseAlcabitius , hc));
  }
  
  private GPersonHouse processHouse(GPersonHouse house, HoroscopeContext hc)
  {
    house.setSun(hc.getHouse(Planet.SUN));
    house.setMoon(hc.getHouse(Planet.MOON));
    house.setMercury(hc.getHouse(Planet.MERCURY));
    house.setVenus(hc.getHouse(Planet.VENUS));
    house.setMars(hc.getHouse(Planet.MARS));
    house.setJupiter(hc.getHouse(Planet.JUPITER));
    house.setSaturn(hc.getHouse(Planet.SATURN));
    house.setUranus(hc.getHouse(Planet.URANUS));
    house.setNeptune(hc.getHouse(Planet.NEPTUNE));
    house.setPluto(hc.getHouse(Planet.PLUTO));
    
    return house;
  }
}
