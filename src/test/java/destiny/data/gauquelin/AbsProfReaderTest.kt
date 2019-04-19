/**
 * Created by smallufo on 2019-04-18.
 */
package destiny.data.gauquelin

import mu.KotlinLogging
import kotlin.test.Test


class AbsProfReaderTest {

  private val logger = KotlinLogging.logger { }

  /**
   * 共 1408 人
   * 有 name , list size = 1317
   * 無 name , list size =   91
   */
  @Test
  fun actor() {
    val t0 = System.currentTimeMillis()
    AbsProfReader.actors.groupBy { it.name != null }.also { map: Map<Boolean, List<GPerson2>> ->
      logger.info("有 name , list size = {}", map.getValue(true).size)
      logger.info("無 name , list size = {}", map.getValue(false).size)
    }
    val t1 = System.currentTimeMillis()
    logger.info("actor 費時 {} millis", (t1 - t0))
  }

  /**
   * [writer] 與 [journalist] 放在一起，但只有 [writer] 有名字
   * http://cura.free.fr/gauq/902gdA6y.html
   *
   * 記者，沒有名字
   *
   * 共 674人
   *
   * 有 name , list size = 0
   * 無 name , list size = 674
   */
  fun journalist() {
    val t0 = System.currentTimeMillis()
    AbsProfReader.journalists.groupBy { it.name != null }.also { map: Map<Boolean, List<GPerson2>> ->
      logger.info("有 name , list size = {}", map[true]?.size ?: 0)
      logger.info("無 name , list size = {}", map[false]?.size ?: 0)
    }
    val t1 = System.currentTimeMillis()
    logger.info("journalist 費時 {} millis", (t1 - t0))
  }

  /**
   * 軍人 , 編號 1 到 3047
   *
   * #131 日期錯誤 (1869 無 2/29)
   * #312 缺
   *
   * 最終有效共 3045 rows
   *
   * 有 name , list size = 2640
   * 無 name , list size =  405
   */
  @Test
  fun military() {
    val t0 = System.currentTimeMillis()
    AbsProfReader.military.groupBy { it.name != null }.also { map: Map<Boolean, List<GPerson2>> ->
      logger.info("有 name , list size = {}", map.getValue(true).size)
      logger.info("無 name , list size = {}", map.getValue(false).size)
    }
    val t1 = System.currentTimeMillis()
    logger.info("military 費時 {} millis", (t1 - t0))
  }

  /**
   * Musician 音樂家 , 1248位
   *
   * 有 name , list size = 1193
   * 無 name , list size =   55
   */
  @Test
  fun musician() {
    val t0 = System.currentTimeMillis()
    AbsProfReader.musicians.groupBy { it.name != null }.also { map: Map<Boolean, List<GPerson2>> ->
      logger.info("有 name , list size = {}", map.getValue(true).size)
      logger.info("無 name , list size = {}", map.getValue(false).size)
    }
    val t1 = System.currentTimeMillis()
    logger.info("musician 費時 {} millis", (t1 - t0))
  }


  /**
   * Painter 畫家 , 1472 位
   *
   * 有 name , list size = 1409
   * 無 name , list size =   63
   */
  @Test
  fun painter() {
    val t0 = System.currentTimeMillis()
    AbsProfReader.painters.groupBy { it.name != null }.also { map: Map<Boolean, List<GPerson2>> ->
      logger.info("有 name , list size = {}", map.getValue(true).size)
      logger.info("無 name , list size = {}", map.getValue(false).size)
    }
    val t1 = System.currentTimeMillis()
    logger.info("painter 費時 {} millis", (t1 - t0))
  }


  /**
   * Politician 政治家 , 1002 位
   *
   * 有 name , list size = 1317
   * 無 name , list size =   91
   */
  @Test
  fun politician() {
    val t0 = System.currentTimeMillis()
    AbsProfReader.politicans.groupBy { it.name != null }.also { map: Map<Boolean, List<GPerson2>> ->
      logger.info("有 name , list size = {}", map.getValue(true).size)
      logger.info("無 name , list size = {}", map.getValue(false).size)
    }
    val t1 = System.currentTimeMillis()
    logger.info("politician 費時 {} millis", (t1 - t0))
  }


  /**
   * Scientist 科學家 and Medical Doctors 醫生
   * 1~3647 , 但缺 2652 , 2683(同262) , 3315 , 3335
   * 故總共只有 3643位
   *
   * 有 name , list size = 3206
   * 無 name , list size =  437
   */
  @Test
  fun scientist() {
    val t0 = System.currentTimeMillis()
    AbsProfReader.scientists.groupBy { it.name != null }.also { map: Map<Boolean, List<GPerson2>> ->
      logger.info("有 name , list size = {}", map.getValue(true).size)
      logger.info("無 name , list size = {}", map.getValue(false).size)
    }
    val t1 = System.currentTimeMillis()
    logger.info("scientist 費時 {} millis", (t1 - t0))
  }

  /**
   * SPORTS CHAMPIONS 運動冠軍 , 2087 位
   * #513 與 #1153重複，故刪除 1153
   *
   * 有 name , list size = 1855
   * 無 name , list size =  232
   */
  @Test
  fun sport() {
    val t0 = System.currentTimeMillis()
    AbsProfReader.sports.groupBy { it.name != null }.also { map: Map<Boolean, List<GPerson2>> ->
      logger.info("有 name , list size = {}", map.getValue(true).size)
      logger.info("無 name , list size = {}", map.getValue(false).size)
    }
    val t1 = System.currentTimeMillis()
    logger.info("sport 費時 {} millis", (t1 - t0))
  }

  /**
   * Writer 作家 , 1352位
   *
   * [writer] 與 [journalist] 放在一起，但只有 [writer] 有名字
   * http://cura.free.fr/gauq/902gdA6y.html
   *
   * 有 name , list size = 1285
   * 無 name , list size =   67
   */
  @Test
  fun writer() {
    val t0 = System.currentTimeMillis()
    AbsProfReader.writers.groupBy { it.name != null }.also { map: Map<Boolean, List<GPerson2>> ->
      logger.info("有 name , list size = {}", map.getValue(true).size)
      logger.info("無 name , list size = {}", map.getValue(false).size)
    }
    val t1 = System.currentTimeMillis()
    logger.info("writer 費時 {} millis", (t1 - t0))
  }
}