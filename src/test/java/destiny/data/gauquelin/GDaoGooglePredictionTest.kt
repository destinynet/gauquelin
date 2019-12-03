/**
 * @author smallufo
 * Created on 2011/5/1 at 上午9:29:53
 */
package destiny.data.gauquelin

import destiny.tools.spring.get
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.transaction.annotation.Transactional
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.PrintStream
import javax.inject.Inject

/** 將資料庫中的 GPerson , 輸出成 Google Prediction API 所需的 CSV 格式檔  */
@RunWith(SpringJUnit4ClassRunner::class)
@ContextConfiguration(locations = ["classpath:gauquelin.xml"])
@Transactional(transactionManager = "transactionManagerGauquelin")
open class GDaoGooglePredictionTest {
  @Inject
  private lateinit var dao: GDao

  @Test
  @javax.transaction.Transactional
  open fun testPredict() {
    val p: GPerson = dao.get(3L)!!
    println(p.csv)
  }

  /** 2011/5/4 ，輸出「工作」，每類工作上限 500人 , 全部 5000 人 */
  @Test
  @javax.transaction.Transactional
  open fun testExportJobEach5500() {
    val t = System.currentTimeMillis()
    val fos = FileOutputStream(File("jobs5500.csv"))
    val ps = PrintStream(fos)
    val max = 550
    processJob(fos, ps, "actor", max, false)
    processJob(fos, ps, "executive", max, false)
    processJob(fos, ps, "journalist", max, false)
    processJob(fos, ps, "military", max, false)
    processJob(fos, ps, "musician", max, false)
    processJob(fos, ps, "painter", max, false)
    processJob(fos, ps, "politician", max, false)
    processJob(fos, ps, "scientist", max, false)
    processJob(fos, ps, "sport", max, false)
    processJob(fos, ps, "writer", max, false)
    ps.close()
    fos.close()
    println("全部費時 " + (System.currentTimeMillis() - t) / 1000L + " 秒")
  }

  /** 2011/5/1 只輸出「工作」「奇數」的資料  。作為初步的成品。跑起來全部費時 2.6 小時
   * 一半的資料就有 9271 rows  */
  @Test
  @javax.transaction.Transactional
  open fun testExportJobCsvOdd() {
    val t = System.currentTimeMillis()
    val fos = FileOutputStream(File("gauquelinJobOdd.csv"))
    val ps = PrintStream(fos)
    processJob(fos, ps, "actor", Int.MAX_VALUE, true)
    processJob(fos, ps, "executive", Int.MAX_VALUE, true)
    processJob(fos, ps, "journalist", Int.MAX_VALUE, true)
    processJob(fos, ps, "military", Int.MAX_VALUE, true)
    processJob(fos, ps, "musician", Int.MAX_VALUE, true)
    processJob(fos, ps, "painter", Int.MAX_VALUE, true)
    processJob(fos, ps, "politician", Int.MAX_VALUE, true)
    processJob(fos, ps, "scientist", Int.MAX_VALUE, true)
    processJob(fos, ps, "sport", Int.MAX_VALUE, true)
    processJob(fos, ps, "writer", Int.MAX_VALUE, true)
    ps.close()
    fos.close()
    println("全部費時 " + (System.currentTimeMillis() - t) / 1000L + " 秒")
  }

  @Throws(IOException::class)
  private fun processJob(fos: FileOutputStream, ps: PrintStream, job: String, max: Int, half: Boolean) {
    var total = dao.getCount(job)
    if (total > max) total = max.toLong()
    val size = 10
    var pages = total / size + 1
    if (total % size == 0L) pages--
    println("job = $job , total = $total , pages = $pages")
    val t = System.currentTimeMillis()
    for (page in 0 until pages) {
      for (p in dao.findAllByCategory(job, (page * size).toInt(), size)) {
        if (half) {
          if (p.id % 2 == 1L) ps.println(p.csv)
        } else ps.println(p.csv)
      }
      fos.flush()
    }
    println("處理 job " + job + " , 費時 " + (System.currentTimeMillis() - t) / 1000L + " 秒")
  }

  /** (useless) 輸出所有 25478 筆資料，成 csv 格式。 跑起來很慢，花費  4.84 小時  */
  @Test
  @javax.transaction.Transactional
  open fun testExportCSV() {
    val fos = FileOutputStream(File("gauquelinAll.csv"))
    val total = dao.count()
    val size = 10
    val pages = total / size
    println("total = $total , pages = $pages")
    val t = System.currentTimeMillis()
    val ps = PrintStream(fos)
    for (page in 0..pages) {
      val pAble: Pageable = PageRequest.of((page * size).toInt(), size)
      for (p in dao.findAll(pAble)) { //System.out.println(" id = " + p.getId() + " , cat = " + p.getCategory() + " , raw = " + p.getRaw());
        ps.println(p.csv)
        //System.out.println(p.getCSV());
      }
      fos.flush()
    }
    ps.close()
    fos.close()
    println("費時 " + (System.currentTimeMillis() - t) / 1000L + " 秒")
  }

  /** (useless) 輸出「奇數」的資料，成 CSV 格式 。就算只輸出一半，也花費 4.98 小時  */
  @Test
  @javax.transaction.Transactional
  @Throws(IOException::class)
  open fun testExportCsvOdd() {
    val fos = FileOutputStream(File("gauquelinOdd.csv"))
    val total = dao.count()
    val size = 10
    val pages = total / size
    println("total = $total , pages = $pages")
    val t = System.currentTimeMillis()
    val ps = PrintStream(fos)
    for (page in 0..pages) {
      val pAble: Pageable = PageRequest.of((page * size).toInt(), size)
      for (p in dao.findAll(pAble)) {
        if (p.id % 2 == 1L) ps.println(p.csv)
      }
      fos.flush()
    }
    ps.close()
    fos.close()
    println("費時 " + (System.currentTimeMillis() - t) / 1000L + " 秒")
  }
}
