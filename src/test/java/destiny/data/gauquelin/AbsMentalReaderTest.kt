/**
 * Created by smallufo on 2019-04-20.
 */
package destiny.data.gauquelin

import mu.KotlinLogging
import kotlin.test.Test


class AbsMentalReaderTest {

  private val logger = KotlinLogging.logger {  }

  /**
   * ACD 嚴重幻想 , size = 332
   */
  @Test
  fun acd() {
    val t0 = System.currentTimeMillis()
    logger.info("ACD size = {}" , AbsMentalReader.acd.size)
    val t1 = System.currentTimeMillis()
    logger.info("ACD 費時 {} millis" , (t1-t0))
  }

  /**
   * hallucination
   * 幻覺 , size = 1136
   */
  @Test
  fun halp() {
    val t0 = System.currentTimeMillis()
    logger.info("HALP size = {}" , AbsMentalReader.halp.size)
    val t1 = System.currentTimeMillis()
    logger.info("HALP 費時 {} millis" , (t1-t0))
  }

  /**
   * mentally Deranged
   * 心智瘋狂 , size = 876
   */
  @Test
  fun md() {
    val t0 = System.currentTimeMillis()
    logger.info("MD size = {}" , AbsMentalReader.md.size)
    val t1 = System.currentTimeMillis()
    logger.info("MD 費時 {} millis" , (t1-t0))
  }

  /**
   * Manic Depressive 躁鬱症 , size = 911
   */
  @Test
  fun mdp() {
    val t0 = System.currentTimeMillis()
    logger.info("MDP size = {}" , AbsMentalReader.mdp.size)
    val t1 = System.currentTimeMillis()
    logger.info("MDP 費時 {} millis" , (t1-t0))
  }

  /**
   * schizophrenics 精神分裂 , size = 1265
   */
  @Test
  fun sch() {
    val t0 = System.currentTimeMillis()
    logger.info("SCH size = {}" , AbsMentalReader.sch.size)
    val t1 = System.currentTimeMillis()
    logger.info("SCH 費時 {} millis" , (t1-t0))
  }
}