/**
 * Created by smallufo on 2019-04-20.
 */
package destiny.data.gauquelin

/**
 * http://cura.free.fr/gauq/902gdD9b.html
 * 五種心智問題 ... 格式都一樣
 *
 * ACD : "ACUTE DELUSIONS" : mental_ACD.txt  , size = 332
 * HALP : "HALLUCINATING PSYCHOSIS" 幻覺 : mental_HALP.txt , size = 1136
 * MD : "MENTALLY DERANGED" 精神錯亂 : mental_MD.txt , size = 876
 * MDP : MANIC-DEPRESSIVE PSYCHOSIS , Manic Depressive 躁鬱症 : mental_MDP.txt , size = 911
 * SCH : SCHIZOPHRENICS , 精神分裂 mental_SCH.txt , size = 1265
 */
class AbsMentalReader(private val dataFile: String) {

  val list : List<GPerson2> by lazy {
    javaClass.getResourceAsStream(dataFile).bufferedReader(Charsets.UTF_8).useLines { lines ->
      lines
        .filterNot { it.startsWith("#") }
        .filterNot { it.isEmpty() }
        .map { line -> ParseUtils.parseMental(line) }
        .filterNotNull()
        .toList()
    }
  }

  companion object {
    val acd = AbsMentalReader("mental_ACD.txt").list
    val halp = AbsMentalReader("mental_HALP.txt").list
    val md = AbsMentalReader("mental_MD.txt").list
    val mdp = AbsMentalReader("mental_MDP.txt").list
    val sch = AbsMentalReader("mental_SCH.txt").list
  }
}