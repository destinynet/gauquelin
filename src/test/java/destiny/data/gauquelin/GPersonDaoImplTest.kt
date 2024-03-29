/**
 * @author smallufo
 * Created on 2009/3/5 at 下午 10:38:28
 */
package destiny.data.gauquelin

import destiny.core.astrology.Aspect
import destiny.core.astrology.AspectsCalculatorImplBuilder.Companion.aspectsCalculatorImpl
import destiny.core.astrology.HoroscopeConfigBuilder.Companion.horoscope
import destiny.core.astrology.HouseSystem.*
import destiny.core.astrology.IHoroscopeModel
import destiny.core.astrology.Planet
import destiny.core.calendar.LocationTools
import destiny.core.calendar.TimeTools
import org.springframework.data.domain.PageRequest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertNotNull


class GPersonDaoImplTest : AbstractGauquelinTest() {


  private var readers = listOf<TextDataReader>()

  @BeforeTest
  fun onSetUp() {

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
       */

    //法國 2154 (2161) 人
    //readers.add(new SuccessfulFrench2154Reader(geolocationFinder));
  }

  fun _testStoreData() {
    for (reader in readers) {
      for (person in reader.persons) {
        gDao.save(person)
      }
    }
  }

  // @Test //太耗時，別測
  fun testFindNoAspectData() {
    System.err.println("gDao = " + gDao)
    for (p in gDao.findAll())
      assertNotNull(p.aspect)
  }

  fun _testProcessAll() {
    val start = 0
    val pageSize = 200
    val count = gDao.count() - start
    println("總共 $count  筆資料")


    var h: IHoroscopeModel
    for (i in 0..count / pageSize) {
      val pr = PageRequest.of((i * pageSize + start).toInt(), pageSize)
      val persons = gDao.findAll(pr)

      for (p in persons) {

        h = horoscopeFeature.getModel(p.gmtTime, LocationTools.decode(p.location!!))

        var updated = false
        if (p.aspect == null) {
          val aspect = processAspect(h)
          aspect.gperson = p
          p.aspect = aspect
          updated = true
        }

        if (p.houseMap.size < 7) {
          processHouses(p, h)
          updated = true
        }

        if (p.anglePower == null) {
          processAnglePower(p, h)
          updated = true
        }

        //System.err.println(p.toString() +"\n"+p.getAnglePower());
        if (updated)
          gDao.save(p)
      }
    } //for
  }

  /** 處理高格林星體強勢度數  */
  private fun processAnglePower(p: GPerson, hc: IHoroscopeModel) {
    var anglePower: GPersonAnglePower? = p.anglePower
    if (anglePower == null)
      anglePower = GPersonAnglePower()

    val util = UtilHoroscopeAnglePower(hc)
    anglePower = util.anglePower

    anglePower.gperson = p
    p.anglePower = anglePower
  }

  @Test
  fun testGet() {
    val pageSize = 10

    val cat = "sport"

    val count = gDao.getCount(cat)
    println("總共 $count  筆資料")

    var h: IHoroscopeModel
    //HoroscopeContextBean bean = new HoroscopeContextBean();
    for (i in 0..count / pageSize) {
      val persons = gDao.findAllByCategory(cat, (i * pageSize).toInt(), pageSize)
      for (p in persons) {
        h = horoscopeFeature.getModel(p.gmtTime, LocationTools.decode(p.location!!))
        //hc = horoscopeContextBean.getHoroscopeContextPlacidus(p.getGmtTime(), Location.get(p.getLocation()));
        System.err.println(p)
        val aspect = processAspect(h)
        aspect.gperson = p
        p.aspect = aspect
        processHouses(p, h)

        //gDao.update(p);
      }
    } //for
  }


  private fun processAspect(hc: IHoroscopeModel): GPersonAspect {
    val gpa = GPersonAspect()

    val aspectCalculator = aspectsCalculatorImpl { modern {} }

    for (data in aspectCalculator.getAspectDataSet(hc.positionMap, Planet.list, Aspect.getAspects(Aspect.Importance.HIGH))) {
      gpa.setAspect(data)
    } // each aspect data
    return gpa
  }

  private fun processHouses(p: GPerson, hc: IHoroscopeModel) {
    val housePlacidus = GPersonHouse()

    val gmtJulDay = TimeTools.getGmtJulDay(hc.lmt, hc.location)


    val horoscopePlacidus = horoscopeFeature.getModel(hc.lmt, hc.location, horoscope { houseSystem = PLACIDUS })
    //hc.setHouseSystem(HouseSystem.PLACIDUS);
    p.houseMap["placidus"] = processHouse(housePlacidus, horoscopePlacidus)

    val houseKoch = GPersonHouse()
    val horoscopeKoch = horoscopeFeature.getModel(hc.lmt, hc.location, horoscope { houseSystem = KOCH })
    //hc.setHouseSystem(HouseSystem.KOCH);
    p.houseMap["Koch"] = processHouse(houseKoch, horoscopeKoch)


    val houseRegiomontanus = GPersonHouse()
    val horoscopeReg = horoscopeFeature.getModel(hc.lmt, hc.location, horoscope { houseSystem = REGIOMONTANUS })
    //hc.setHouseSystem(HouseSystem.REGIOMONTANUS);
    p.houseMap["Regiomontanus"] = processHouse(houseRegiomontanus, horoscopeReg)


    val housePorphyrius = GPersonHouse()
    val horoscopePor = horoscopeFeature.getModel(hc.lmt, hc.location, horoscope { houseSystem = PORPHYRIUS })
    //hc.setHouseSystem(HouseSystem.PORPHYRIUS);
    p.houseMap["Porphyrius"] = processHouse(housePorphyrius, horoscopePor)


    val houseCampanus = GPersonHouse()
    val horoscopeCampanus = horoscopeFeature.getModel(hc.lmt, hc.location, horoscope { houseSystem = CAMPANUS })
    //hc.setHouseSystem(HouseSystem.CAMPANUS);
    p.houseMap["Campanus"] = processHouse(houseCampanus, horoscopeCampanus)


    val houseEqual = GPersonHouse()
    val horoscopeEqual = horoscopeFeature.getModel(hc.lmt, hc.location, horoscope { houseSystem = EQUAL })
    //hc.setHouseSystem(HouseSystem.EQUAL);
    p.houseMap["Equal"] = processHouse(houseEqual, horoscopeEqual)


    val houseAlcabitius = GPersonHouse()
    val horoscopeAlc = horoscopeFeature.getModel(hc.lmt, hc.location, horoscope { houseSystem = ALCABITIUS })
    //hc.setHouseSystem(HouseSystem.ALCABITIUS);
    p.houseMap["Alcabitius"] = processHouse(houseAlcabitius, horoscopeAlc)
  }

  private fun processHouse(house: GPersonHouse, hc: IHoroscopeModel): GPersonHouse {

    //    hc.getHouseOpt(Planet.SUN).ifPresent(house::setSun);
    //    hc.getHouseOpt(Planet.MOON).ifPresent(house::setMoon);
    //    hc.getHouseOpt(Planet.MERCURY).ifPresent(house::setMercury);
    //    hc.getHouseOpt(Planet.VENUS).ifPresent(house::setVenus);
    //    hc.getHouseOpt(Planet.MARS).ifPresent(house::setMars);
    //    hc.getHouseOpt(Planet.JUPITER).ifPresent(house::setJupiter);
    //    hc.getHouseOpt(Planet.SATURN).ifPresent(house::setSaturn);
    //    hc.getHouseOpt(Planet.URANUS).ifPresent(house::setUranus);
    //    hc.getHouseOpt(Planet.NEPTUNE).ifPresent(house::setNeptune);
    //    hc.getHouseOpt(Planet.PLUTO).ifPresent(house::setPluto);

    return house
  }
}
