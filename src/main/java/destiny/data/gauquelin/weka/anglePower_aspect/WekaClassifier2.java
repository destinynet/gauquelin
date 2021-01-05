/**
 * @author smallufo 
 * Created on 2009/3/25 at 上午 1:51:46
 */
package destiny.data.gauquelin.weka.anglePower_aspect;

/**
 * <pre>
 * Number of Leaves  :     352
 * 
 * Size of the tree :  530
 * 
 * 
 * Time taken to build model: 7.86 seconds
 * 
 * === Evaluation on test split ===
 * === Summary ===
 * 
 * Correctly Classified Instances        2102               36.3983 %
 * Incorrectly Classified Instances      3673               63.6017 %
 * Kappa statistic                          0.1684
 * Mean absolute error                      0.2853
 * Root mean squared error                  0.3867
 * Relative absolute error                 90.9908 %
 * Root relative squared error             97.6297 %
 * Total Number of Instances             5775     
 * 
 * === Detailed Accuracy By Class ===
 * 
 *                TP Rate   FP Rate   Precision   Recall  F-Measure   ROC Area  Class
 *                  0.507     0.069      0.562     0.507     0.533      0.846    sport
 *                  0.485     0.394      0.314     0.485     0.381      0.567    scientist
 *                  0.218     0.143      0.298     0.218     0.252      0.584    military
 *                  0.444     0.215      0.395     0.444     0.418      0.638    painterMusicianActor
 *                  0.023     0.017      0.158     0.023     0.04       0.594    writerJournalist
 * Weighted Avg.    0.364     0.202      0.348     0.364     0.343      0.633
 * 
 * === Confusion Matrix ===
 * 
 *    a   b   c   d   e   &lt;-- classified as
 *  437 285  81  41  18 |   a = sport
 *  107 758 263 410  25 |   b = scientist
 *   75 551 275 341  20 |   c = military
 *  112 441 196 616  22 |   d = painterMusicianActor
 *   47 381 107 150  16 |   e = writerJournalist
 * 
 * </pre>
 */
public class WekaClassifier2
{
  public static double classify(Object[] i) {

    double p = Double.NaN;
    p = WekaClassifier2.N1c154c2403(i);
    return p;
  }

  static double N1c154c2403(Object[] i)
  {
    double p = Double.NaN;
    if (i[16] == null)
    {
      p = 1;
    }
    else if (i[16].equals("east"))
    {
      p = WekaClassifier2.N1a3cd0e404(i);
    }
    else if (i[16].equals("top"))
    {
      p = WekaClassifier2.N10dbbc9438(i);
    }
    else if (i[16].equals("west"))
    {
      p = WekaClassifier2.N1bab9dc488(i);
    }
    else if (i[16].equals("bottom"))
    {
      p = WekaClassifier2.N48548e532(i);
    }
    return p;
  }

  static double N1a3cd0e404(Object[] i)
  {
    double p = Double.NaN;
    if (i[18] == null)
    {
      p = 1;
    }
    else if (i[18].equals("east"))
    {
      p = WekaClassifier2.Neb625c405(i);
    }
    else if (i[18].equals("top"))
    {
      p = WekaClassifier2.Nebb27a434(i);
    }
    else if (i[18].equals("west"))
    {
      p = WekaClassifier2.N1b34f18437(i);
    }
    else if (i[18].equals("bottom"))
    {
      p = 3;
    }
    return p;
  }

  static double Neb625c405(Object[] i)
  {
    double p = Double.NaN;
    if (i[14] == null)
    {
      p = 3;
    }
    else if (i[14].equals("east"))
    {
      p = WekaClassifier2.N186a43c406(i);
    }
    else if (i[14].equals("top"))
    {
      p = 0;
    }
    else if (i[14].equals("west"))
    {
      p = WekaClassifier2.N3b8c8414(i);
    }
    else if (i[14].equals("bottom"))
    {
      p = WekaClassifier2.N79a890431(i);
    }
    return p;
  }

  static double N186a43c406(Object[] i)
  {
    double p = Double.NaN;
    if (i[0] == null)
    {
      p = 3;
    }
    else if (i[0].equals("east"))
    {
      p = WekaClassifier2.N887991407(i);
    }
    else if (i[0].equals("top"))
    {
      p = 3;
    }
    else if (i[0].equals("west"))
    {
      p = WekaClassifier2.Nb5d521411(i);
    }
    else if (i[0].equals("bottom"))
    {
      p = WekaClassifier2.N1bb9d2e412(i);
    }
    return p;
  }

  static double N887991407(Object[] i)
  {
    double p = Double.NaN;
    if (i[6] == null)
    {
      p = 2;
    }
    else if (i[6].equals("east"))
    {
      p = WekaClassifier2.N1e545d8408(i);
    }
    else if (i[6].equals("top"))
    {
      p = 1;
    }
    else if (i[6].equals("west"))
    {
      p = 3;
    }
    else if (i[6].equals("bottom"))
    {
      p = 3;
    }
    return p;
  }

  static double N1e545d8408(Object[] i)
  {
    double p = Double.NaN;
    if (i[7] == null)
    {
      p = 2;
    }
    else if (((Double) i[7]).doubleValue() <= -0.32395175404906723)
    {
      p = 2;
    }
    else if (((Double) i[7]).doubleValue() > -0.32395175404906723)
    {
      p = WekaClassifier2.N14c721c409(i);
    }
    return p;
  }

  static double N14c721c409(Object[] i)
  {
    double p = Double.NaN;
    if (i[13] == null)
    {
      p = 3;
    }
    else if (((Double) i[13]).doubleValue() <= -0.30194073706892)
    {
      p = 3;
    }
    else if (((Double) i[13]).doubleValue() > -0.30194073706892)
    {
      p = WekaClassifier2.N1d7a58d410(i);
    }
    return p;
  }

  static double N1d7a58d410(Object[] i)
  {
    double p = Double.NaN;
    if (i[11] == null)
    {
      p = 2;
    }
    else if (((Double) i[11]).doubleValue() <= -0.14168868421180447)
    {
      p = 2;
    }
    else if (((Double) i[11]).doubleValue() > -0.14168868421180447)
    {
      p = 1;
    }
    return p;
  }

  static double Nb5d521411(Object[] i)
  {
    double p = Double.NaN;
    if (i[17] == null)
    {
      p = 2;
    }
    else if (((Double) i[17]).doubleValue() <= -0.539816295950959)
    {
      p = 2;
    }
    else if (((Double) i[17]).doubleValue() > -0.539816295950959)
    {
      p = 3;
    }
    return p;
  }

  static double N1bb9d2e412(Object[] i)
  {
    double p = Double.NaN;
    if (i[7] == null)
    {
      p = 1;
    }
    else if (((Double) i[7]).doubleValue() <= -0.22391708441361877)
    {
      p = 1;
    }
    else if (((Double) i[7]).doubleValue() > -0.22391708441361877)
    {
      p = WekaClassifier2.N4c6715413(i);
    }
    return p;
  }

  static double N4c6715413(Object[] i)
  {
    double p = Double.NaN;
    if (i[15] == null)
    {
      p = 2;
    }
    else if (((Double) i[15]).doubleValue() <= -0.11410386679562717)
    {
      p = 2;
    }
    else if (((Double) i[15]).doubleValue() > -0.11410386679562717)
    {
      p = 1;
    }
    return p;
  }

  static double N3b8c8414(Object[] i)
  {
    double p = Double.NaN;
    if (i[19] == null)
    {
      p = 0;
    }
    else if (((Double) i[19]).doubleValue() <= -0.4341367856475411)
    {
      p = WekaClassifier2.N585aae415(i);
    }
    else if (((Double) i[19]).doubleValue() > -0.4341367856475411)
    {
      p = WekaClassifier2.N4bb76d421(i);
    }
    return p;
  }

  static double N585aae415(Object[] i)
  {
    double p = Double.NaN;
    if (i[12] == null)
    {
      p = 2;
    }
    else if (i[12].equals("east"))
    {
      p = WekaClassifier2.Na988f9416(i);
    }
    else if (i[12].equals("top"))
    {
      p = WekaClassifier2.N60753418(i);
    }
    else if (i[12].equals("west"))
    {
      p = WekaClassifier2.N1cb001c419(i);
    }
    else if (i[12].equals("bottom"))
    {
      p = 0;
    }
    return p;
  }

  static double Na988f9416(Object[] i)
  {
    double p = Double.NaN;
    if (i[6] == null)
    {
      p = 0;
    }
    else if (i[6].equals("east"))
    {
      p = 0;
    }
    else if (i[6].equals("top"))
    {
      p = 2;
    }
    else if (i[6].equals("west"))
    {
      p = 0;
    }
    else if (i[6].equals("bottom"))
    {
      p = WekaClassifier2.N5fc710417(i);
    }
    return p;
  }

  static double N5fc710417(Object[] i)
  {
    double p = Double.NaN;
    if (i[15] == null)
    {
      p = 1;
    }
    else if (((Double) i[15]).doubleValue() <= -0.035583473228474626)
    {
      p = 1;
    }
    else if (((Double) i[15]).doubleValue() > -0.035583473228474626)
    {
      p = 2;
    }
    return p;
  }

  static double N60753418(Object[] i)
  {
    double p = Double.NaN;
    if (i[4] == null)
    {
      p = 0;
    }
    else if (i[4].equals("east"))
    {
      p = 0;
    }
    else if (i[4].equals("top"))
    {
      p = 1;
    }
    else if (i[4].equals("west"))
    {
      p = 2;
    }
    else if (i[4].equals("bottom"))
    {
      p = 2;
    }
    return p;
  }

  static double N1cb001c419(Object[] i)
  {
    double p = Double.NaN;
    if (i[8] == null)
    {
      p = 3;
    }
    else if (i[8].equals("east"))
    {
      p = 3;
    }
    else if (i[8].equals("top"))
    {
      p = 4;
    }
    else if (i[8].equals("west"))
    {
      p = 0;
    }
    else if (i[8].equals("bottom"))
    {
      p = WekaClassifier2.N745837420(i);
    }
    return p;
  }

  static double N745837420(Object[] i)
  {
    double p = Double.NaN;
    if (i[3] == null)
    {
      p = 2;
    }
    else if (((Double) i[3]).doubleValue() <= -0.1398773836026604)
    {
      p = 2;
    }
    else if (((Double) i[3]).doubleValue() > -0.1398773836026604)
    {
      p = 3;
    }
    return p;
  }

  static double N4bb76d421(Object[] i)
  {
    double p = Double.NaN;
    if (i[4] == null)
    {
      p = 1;
    }
    else if (i[4].equals("east"))
    {
      p = 1;
    }
    else if (i[4].equals("top"))
    {
      p = 2;
    }
    else if (i[4].equals("west"))
    {
      p = WekaClassifier2.Nf7867f422(i);
    }
    else if (i[4].equals("bottom"))
    {
      p = 1;
    }
    return p;
  }

  static double Nf7867f422(Object[] i)
  {
    double p = Double.NaN;
    if (i[12] == null)
    {
      p = 2;
    }
    else if (i[12].equals("east"))
    {
      p = WekaClassifier2.N9f0179423(i);
    }
    else if (i[12].equals("top"))
    {
      p = WekaClassifier2.N119af40424(i);
    }
    else if (i[12].equals("west"))
    {
      p = WekaClassifier2.Nfdd76c427(i);
    }
    else if (i[12].equals("bottom"))
    {
      p = WekaClassifier2.N5ed711430(i);
    }
    return p;
  }

  static double N9f0179423(Object[] i)
  {
    double p = Double.NaN;
    if (i[9] == null)
    {
      p = 0;
    }
    else if (((Double) i[9]).doubleValue() <= -0.37466986202530755)
    {
      p = 0;
    }
    else if (((Double) i[9]).doubleValue() > -0.37466986202530755)
    {
      p = 2;
    }
    return p;
  }

  static double N119af40424(Object[] i)
  {
    double p = Double.NaN;
    if (i[5] == null)
    {
      p = 1;
    }
    else if (((Double) i[5]).doubleValue() <= -0.10299976170063019)
    {
      p = WekaClassifier2.N140b737425(i);
    }
    else if (((Double) i[5]).doubleValue() > -0.10299976170063019)
    {
      p = 2;
    }
    return p;
  }

  static double N140b737425(Object[] i)
  {
    double p = Double.NaN;
    if (i[5] == null)
    {
      p = 3;
    }
    else if (((Double) i[5]).doubleValue() <= -0.42696306109428406)
    {
      p = 3;
    }
    else if (((Double) i[5]).doubleValue() > -0.42696306109428406)
    {
      p = WekaClassifier2.N1bcb0d6426(i);
    }
    return p;
  }

  static double N1bcb0d6426(Object[] i)
  {
    double p = Double.NaN;
    if (i[17] == null)
    {
      p = 0;
    }
    else if (((Double) i[17]).doubleValue() <= 0.3873497384469431)
    {
      p = 0;
    }
    else if (((Double) i[17]).doubleValue() > 0.3873497384469431)
    {
      p = 1;
    }
    return p;
  }

  static double Nfdd76c427(Object[] i)
  {
    double p = Double.NaN;
    if (i[10] == null)
    {
      p = 3;
    }
    else if (i[10].equals("east"))
    {
      p = 3;
    }
    else if (i[10].equals("top"))
    {
      p = 1;
    }
    else if (i[10].equals("west"))
    {
      p = WekaClassifier2.N149f4fc428(i);
    }
    else if (i[10].equals("bottom"))
    {
      p = WekaClassifier2.N73015e429(i);
    }
    return p;
  }

  static double N149f4fc428(Object[] i)
  {
    double p = Double.NaN;
    if (i[8] == null)
    {
      p = 0;
    }
    else if (i[8].equals("east"))
    {
      p = 0;
    }
    else if (i[8].equals("top"))
    {
      p = 1;
    }
    else if (i[8].equals("west"))
    {
      p = 4;
    }
    else if (i[8].equals("bottom"))
    {
      p = 0;
    }
    return p;
  }

  static double N73015e429(Object[] i)
  {
    double p = Double.NaN;
    if (i[8] == null)
    {
      p = 2;
    }
    else if (i[8].equals("east"))
    {
      p = 2;
    }
    else if (i[8].equals("top"))
    {
      p = 4;
    }
    else if (i[8].equals("west"))
    {
      p = 1;
    }
    else if (i[8].equals("bottom"))
    {
      p = 4;
    }
    return p;
  }

  static double N5ed711430(Object[] i)
  {
    double p = Double.NaN;
    if (i[13] == null)
    {
      p = 4;
    }
    else if (((Double) i[13]).doubleValue() <= -0.2523404930562371)
    {
      p = 4;
    }
    else if (((Double) i[13]).doubleValue() > -0.2523404930562371)
    {
      p = 1;
    }
    return p;
  }

  static double N79a890431(Object[] i)
  {
    double p = Double.NaN;
    if (i[12] == null)
    {
      p = 1;
    }
    else if (i[12].equals("east"))
    {
      p = 1;
    }
    else if (i[12].equals("top"))
    {
      p = 1;
    }
    else if (i[12].equals("west"))
    {
      p = WekaClassifier2.N1299cbf432(i);
    }
    else if (i[12].equals("bottom"))
    {
      p = 2;
    }
    return p;
  }

  static double N1299cbf432(Object[] i)
  {
    double p = Double.NaN;
    if (i[19] == null)
    {
      p = 1;
    }
    else if (((Double) i[19]).doubleValue() <= -0.4250729781209867)
    {
      p = WekaClassifier2.Nf1f482433(i);
    }
    else if (((Double) i[19]).doubleValue() > -0.4250729781209867)
    {
      p = 2;
    }
    return p;
  }

  static double Nf1f482433(Object[] i)
  {
    double p = Double.NaN;
    if (i[7] == null)
    {
      p = 0;
    }
    else if (((Double) i[7]).doubleValue() <= -0.17322728238368243)
    {
      p = 0;
    }
    else if (((Double) i[7]).doubleValue() > -0.17322728238368243)
    {
      p = 1;
    }
    return p;
  }

  static double Nebb27a434(Object[] i)
  {
    double p = Double.NaN;
    if (i[14] == null)
    {
      p = 0;
    }
    else if (i[14].equals("east"))
    {
      p = 0;
    }
    else if (i[14].equals("top"))
    {
      p = 0;
    }
    else if (i[14].equals("west"))
    {
      p = 0;
    }
    else if (i[14].equals("bottom"))
    {
      p = WekaClassifier2.N127043435(i);
    }
    return p;
  }

  static double N127043435(Object[] i)
  {
    double p = Double.NaN;
    if (i[8] == null)
    {
      p = 1;
    }
    else if (i[8].equals("east"))
    {
      p = WekaClassifier2.N887102436(i);
    }
    else if (i[8].equals("top"))
    {
      p = 2;
    }
    else if (i[8].equals("west"))
    {
      p = 3;
    }
    else if (i[8].equals("bottom"))
    {
      p = 1;
    }
    return p;
  }

  static double N887102436(Object[] i)
  {
    double p = Double.NaN;
    if (i[1] == null)
    {
      p = 1;
    }
    else if (((Double) i[1]).doubleValue() <= -0.002182380776151422)
    {
      p = 1;
    }
    else if (((Double) i[1]).doubleValue() > -0.002182380776151422)
    {
      p = 4;
    }
    return p;
  }

  static double N1b34f18437(Object[] i)
  {
    double p = Double.NaN;
    if (i[10] == null)
    {
      p = 1;
    }
    else if (i[10].equals("east"))
    {
      p = 1;
    }
    else if (i[10].equals("top"))
    {
      p = 3;
    }
    else if (i[10].equals("west"))
    {
      p = 2;
    }
    else if (i[10].equals("bottom"))
    {
      p = 1;
    }
    return p;
  }

  static double N10dbbc9438(Object[] i)
  {
    double p = Double.NaN;
    if (i[14] == null)
    {
      p = 1;
    }
    else if (i[14].equals("east"))
    {
      p = WekaClassifier2.Na3a141439(i);
    }
    else if (i[14].equals("top"))
    {
      p = WekaClassifier2.N1d884a6459(i);
    }
    else if (i[14].equals("west"))
    {
      p = WekaClassifier2.N1da9830462(i);
    }
    else if (i[14].equals("bottom"))
    {
      p = WekaClassifier2.Na0363c467(i);
    }
    return p;
  }

  static double Na3a141439(Object[] i)
  {
    double p = Double.NaN;
    if (i[18] == null)
    {
      p = 1;
    }
    else if (i[18].equals("east"))
    {
      p = WekaClassifier2.Nafca52440(i);
    }
    else if (i[18].equals("top"))
    {
      p = WekaClassifier2.N15f360c450(i);
    }
    else if (i[18].equals("west"))
    {
      p = WekaClassifier2.N1b118e1458(i);
    }
    else if (i[18].equals("bottom"))
    {
      p = 1;
    }
    return p;
  }

  static double Nafca52440(Object[] i)
  {
    double p = Double.NaN;
    if (i[19] == null)
    {
      p = 1;
    }
    else if (((Double) i[19]).doubleValue() <= -0.6201131970824751)
    {
      p = WekaClassifier2.N10c0b64441(i);
    }
    else if (((Double) i[19]).doubleValue() > -0.6201131970824751)
    {
      p = WekaClassifier2.N1cfaf37448(i);
    }
    return p;
  }

  static double N10c0b64441(Object[] i)
  {
    double p = Double.NaN;
    if (i[3] == null)
    {
      p = 2;
    }
    else if (((Double) i[3]).doubleValue() <= -0.44466088938961634)
    {
      p = WekaClassifier2.N1c001f5442(i);
    }
    else if (((Double) i[3]).doubleValue() > -0.44466088938961634)
    {
      p = WekaClassifier2.Nc09d8c443(i);
    }
    return p;
  }

  static double N1c001f5442(Object[] i)
  {
    double p = Double.NaN;
    if (i[15] == null)
    {
      p = 1;
    }
    else if (((Double) i[15]).doubleValue() <= -0.2403753716432321)
    {
      p = 1;
    }
    else if (((Double) i[15]).doubleValue() > -0.2403753716432321)
    {
      p = 2;
    }
    return p;
  }

  static double Nc09d8c443(Object[] i)
  {
    double p = Double.NaN;
    if (i[10] == null)
    {
      p = 1;
    }
    else if (i[10].equals("east"))
    {
      p = WekaClassifier2.N1a7652d444(i);
    }
    else if (i[10].equals("top"))
    {
      p = WekaClassifier2.Ne39f71445(i);
    }
    else if (i[10].equals("west"))
    {
      p = WekaClassifier2.N1f8ced7446(i);
    }
    else if (i[10].equals("bottom"))
    {
      p = WekaClassifier2.N1d3ac38447(i);
    }
    return p;
  }

  static double N1a7652d444(Object[] i)
  {
    double p = Double.NaN;
    if (i[5] == null)
    {
      p = 2;
    }
    else if (((Double) i[5]).doubleValue() <= -0.16069982945919037)
    {
      p = 2;
    }
    else if (((Double) i[5]).doubleValue() > -0.16069982945919037)
    {
      p = 1;
    }
    return p;
  }

  static double Ne39f71445(Object[] i)
  {
    double p = Double.NaN;
    if (i[11] == null)
    {
      p = 1;
    }
    else if (((Double) i[11]).doubleValue() <= 0.10633334476153777)
    {
      p = 1;
    }
    else if (((Double) i[11]).doubleValue() > 0.10633334476153777)
    {
      p = 2;
    }
    return p;
  }

  static double N1f8ced7446(Object[] i)
  {
    double p = Double.NaN;
    if (i[11] == null)
    {
      p = 1;
    }
    else if (((Double) i[11]).doubleValue() <= -0.1371864242521066)
    {
      p = 1;
    }
    else if (((Double) i[11]).doubleValue() > -0.1371864242521066)
    {
      p = 2;
    }
    return p;
  }

  static double N1d3ac38447(Object[] i)
  {
    double p = Double.NaN;
    if (i[8] == null)
    {
      p = 1;
    }
    else if (i[8].equals("east"))
    {
      p = 1;
    }
    else if (i[8].equals("top"))
    {
      p = 3;
    }
    else if (i[8].equals("west"))
    {
      p = 1;
    }
    else if (i[8].equals("bottom"))
    {
      p = 3;
    }
    return p;
  }

  static double N1cfaf37448(Object[] i)
  {
    double p = Double.NaN;
    if (i[25] == null)
    {
      p = 3;
    }
    else if (i[25].equals("Conjunction"))
    {
      p = WekaClassifier2.N1f867af449(i);
    }
    else if (i[25].equals("SextileTrine"))
    {
      p = 1;
    }
    else if (i[25].equals("SquareOpposition"))
    {
      p = 3;
    }
    return p;
  }

  static double N1f867af449(Object[] i)
  {
    double p = Double.NaN;
    if (i[10] == null)
    {
      p = 3;
    }
    else if (i[10].equals("east"))
    {
      p = 3;
    }
    else if (i[10].equals("top"))
    {
      p = 2;
    }
    else if (i[10].equals("west"))
    {
      p = 2;
    }
    else if (i[10].equals("bottom"))
    {
      p = 3;
    }
    return p;
  }

  static double N15f360c450(Object[] i)
  {
    double p = Double.NaN;
    if (i[15] == null)
    {
      p = 2;
    }
    else if (((Double) i[15]).doubleValue() <= -0.5085477487930062)
    {
      p = WekaClassifier2.N1d56a3a451(i);
    }
    else if (((Double) i[15]).doubleValue() > -0.5085477487930062)
    {
      p = WekaClassifier2.N6fbd9a453(i);
    }
    return p;
  }

  static double N1d56a3a451(Object[] i)
  {
    double p = Double.NaN;
    if (i[41] == null)
    {
      p = 1;
    }
    else if (i[41].equals("Conjunction"))
    {
      p = WekaClassifier2.N312cbb452(i);
    }
    else if (i[41].equals("SextileTrine"))
    {
      p = 2;
    }
    else if (i[41].equals("SquareOpposition"))
    {
      p = 2;
    }
    return p;
  }

  static double N312cbb452(Object[] i)
  {
    double p = Double.NaN;
    if (i[17] == null)
    {
      p = 2;
    }
    else if (((Double) i[17]).doubleValue() <= 0.3913425076139788)
    {
      p = 2;
    }
    else if (((Double) i[17]).doubleValue() > 0.3913425076139788)
    {
      p = 1;
    }
    return p;
  }

  static double N6fbd9a453(Object[] i)
  {
    double p = Double.NaN;
    if (i[12] == null)
    {
      p = 2;
    }
    else if (i[12].equals("east"))
    {
      p = WekaClassifier2.N8e45b454(i);
    }
    else if (i[12].equals("top"))
    {
      p = 1;
    }
    else if (i[12].equals("west"))
    {
      p = WekaClassifier2.N127202b457(i);
    }
    else if (i[12].equals("bottom"))
    {
      p = 2;
    }
    return p;
  }

  static double N8e45b454(Object[] i)
  {
    double p = Double.NaN;
    if (i[30] == null)
    {
      p = 1;
    }
    else if (i[30].equals("Conjunction"))
    {
      p = WekaClassifier2.N1c81ca3455(i);
    }
    else if (i[30].equals("SextileTrine"))
    {
      p = 2;
    }
    else if (i[30].equals("SquareOpposition"))
    {
      p = WekaClassifier2.Nd03c4d456(i);
    }
    return p;
  }

  static double N1c81ca3455(Object[] i)
  {
    double p = Double.NaN;
    if (i[6] == null)
    {
      p = 4;
    }
    else if (i[6].equals("east"))
    {
      p = 4;
    }
    else if (i[6].equals("top"))
    {
      p = 1;
    }
    else if (i[6].equals("west"))
    {
      p = 0;
    }
    else if (i[6].equals("bottom"))
    {
      p = 2;
    }
    return p;
  }

  static double Nd03c4d456(Object[] i)
  {
    double p = Double.NaN;
    if (i[0] == null)
    {
      p = 2;
    }
    else if (i[0].equals("east"))
    {
      p = 2;
    }
    else if (i[0].equals("top"))
    {
      p = 1;
    }
    else if (i[0].equals("west"))
    {
      p = 0;
    }
    else if (i[0].equals("bottom"))
    {
      p = 2;
    }
    return p;
  }

  static double N127202b457(Object[] i)
  {
    double p = Double.NaN;
    if (i[13] == null)
    {
      p = 2;
    }
    else if (((Double) i[13]).doubleValue() <= -0.6540018906611232)
    {
      p = 2;
    }
    else if (((Double) i[13]).doubleValue() > -0.6540018906611232)
    {
      p = 1;
    }
    return p;
  }

  static double N1b118e1458(Object[] i)
  {
    double p = Double.NaN;
    if (i[3] == null)
    {
      p = 3;
    }
    else if (((Double) i[3]).doubleValue() <= -0.37740915430241107)
    {
      p = 3;
    }
    else if (((Double) i[3]).doubleValue() > -0.37740915430241107)
    {
      p = 1;
    }
    return p;
  }

  static double N1d884a6459(Object[] i)
  {
    double p = Double.NaN;
    if (i[12] == null)
    {
      p = 3;
    }
    else if (i[12].equals("east"))
    {
      p = WekaClassifier2.N1ece9b5460(i);
    }
    else if (i[12].equals("top"))
    {
      p = 3;
    }
    else if (i[12].equals("west"))
    {
      p = 3;
    }
    else if (i[12].equals("bottom"))
    {
      p = WekaClassifier2.Ne37030461(i);
    }
    return p;
  }

  static double N1ece9b5460(Object[] i)
  {
    double p = Double.NaN;
    if (i[18] == null)
    {
      p = 3;
    }
    else if (i[18].equals("east"))
    {
      p = 3;
    }
    else if (i[18].equals("top"))
    {
      p = 1;
    }
    else if (i[18].equals("west"))
    {
      p = 3;
    }
    else if (i[18].equals("bottom"))
    {
      p = 1;
    }
    return p;
  }

  static double Ne37030461(Object[] i)
  {
    double p = Double.NaN;
    if (i[9] == null)
    {
      p = 3;
    }
    else if (((Double) i[9]).doubleValue() <= 0.718257950293427)
    {
      p = 3;
    }
    else if (((Double) i[9]).doubleValue() > 0.718257950293427)
    {
      p = 2;
    }
    return p;
  }

  static double N1da9830462(Object[] i)
  {
    double p = Double.NaN;
    if (i[18] == null)
    {
      p = 3;
    }
    else if (i[18].equals("east"))
    {
      p = 3;
    }
    else if (i[18].equals("top"))
    {
      p = WekaClassifier2.N3d8285463(i);
    }
    else if (i[18].equals("west"))
    {
      p = 0;
    }
    else if (i[18].equals("bottom"))
    {
      p = 0;
    }
    return p;
  }

  static double N3d8285463(Object[] i)
  {
    double p = Double.NaN;
    if (i[17] == null)
    {
      p = 0;
    }
    else if (((Double) i[17]).doubleValue() <= -0.22091895470126222)
    {
      p = WekaClassifier2.N440bbc464(i);
    }
    else if (((Double) i[17]).doubleValue() > -0.22091895470126222)
    {
      p = 0;
    }
    return p;
  }

  static double N440bbc464(Object[] i)
  {
    double p = Double.NaN;
    if (i[15] == null)
    {
      p = 2;
    }
    else if (((Double) i[15]).doubleValue() <= -0.33466104159687293)
    {
      p = WekaClassifier2.N15e8edc465(i);
    }
    else if (((Double) i[15]).doubleValue() > -0.33466104159687293)
    {
      p = 0;
    }
    return p;
  }

  static double N15e8edc465(Object[] i)
  {
    double p = Double.NaN;
    if (i[1] == null)
    {
      p = 2;
    }
    else if (((Double) i[1]).doubleValue() <= -0.41062998367205084)
    {
      p = 2;
    }
    else if (((Double) i[1]).doubleValue() > -0.41062998367205084)
    {
      p = WekaClassifier2.Nf52e04466(i);
    }
    return p;
  }

  static double Nf52e04466(Object[] i)
  {
    double p = Double.NaN;
    if (i[10] == null)
    {
      p = 0;
    }
    else if (i[10].equals("east"))
    {
      p = 0;
    }
    else if (i[10].equals("top"))
    {
      p = 2;
    }
    else if (i[10].equals("west"))
    {
      p = 2;
    }
    else if (i[10].equals("bottom"))
    {
      p = 3;
    }
    return p;
  }

  static double Na0363c467(Object[] i)
  {
    double p = Double.NaN;
    if (i[18] == null)
    {
      p = 1;
    }
    else if (i[18].equals("east"))
    {
      p = 1;
    }
    else if (i[18].equals("top"))
    {
      p = WekaClassifier2.N48c264468(i);
    }
    else if (i[18].equals("west"))
    {
      p = WekaClassifier2.N1359448482(i);
    }
    else if (i[18].equals("bottom"))
    {
      p = 1;
    }
    return p;
  }

  static double N48c264468(Object[] i)
  {
    double p = Double.NaN;
    if (i[19] == null)
    {
      p = 0;
    }
    else if (((Double) i[19]).doubleValue() <= -0.7442521285502527)
    {
      p = 0;
    }
    else if (((Double) i[19]).doubleValue() > -0.7442521285502527)
    {
      p = WekaClassifier2.Nd23a8f469(i);
    }
    return p;
  }

  static double Nd23a8f469(Object[] i)
  {
    double p = Double.NaN;
    if (i[12] == null)
    {
      p = 1;
    }
    else if (i[12].equals("east"))
    {
      p = WekaClassifier2.N2a8a9470(i);
    }
    else if (i[12].equals("top"))
    {
      p = WekaClassifier2.N1d9b479474(i);
    }
    else if (i[12].equals("west"))
    {
      p = 1;
    }
    else if (i[12].equals("bottom"))
    {
      p = WekaClassifier2.N15b422e477(i);
    }
    return p;
  }

  static double N2a8a9470(Object[] i)
  {
    double p = Double.NaN;
    if (i[24] == null)
    {
      p = 1;
    }
    else if (i[24].equals("Conjunction"))
    {
      p = 1;
    }
    else if (i[24].equals("SextileTrine"))
    {
      p = WekaClassifier2.N8f07de471(i);
    }
    else if (i[24].equals("SquareOpposition"))
    {
      p = 1;
    }
    return p;
  }

  static double N8f07de471(Object[] i)
  {
    double p = Double.NaN;
    if (i[10] == null)
    {
      p = 0;
    }
    else if (i[10].equals("east"))
    {
      p = WekaClassifier2.N4dc0bb472(i);
    }
    else if (i[10].equals("top"))
    {
      p = 2;
    }
    else if (i[10].equals("west"))
    {
      p = 4;
    }
    else if (i[10].equals("bottom"))
    {
      p = WekaClassifier2.Na86662473(i);
    }
    return p;
  }

  static double N4dc0bb472(Object[] i)
  {
    double p = Double.NaN;
    if (i[13] == null)
    {
      p = 3;
    }
    else if (((Double) i[13]).doubleValue() <= -0.1852734630217059)
    {
      p = 3;
    }
    else if (((Double) i[13]).doubleValue() > -0.1852734630217059)
    {
      p = 0;
    }
    return p;
  }

  static double Na86662473(Object[] i)
  {
    double p = Double.NaN;
    if (i[9] == null)
    {
      p = 4;
    }
    else if (((Double) i[9]).doubleValue() <= -0.3307625389270838)
    {
      p = 4;
    }
    else if (((Double) i[9]).doubleValue() > -0.3307625389270838)
    {
      p = 2;
    }
    return p;
  }

  static double N1d9b479474(Object[] i)
  {
    double p = Double.NaN;
    if (i[10] == null)
    {
      p = 1;
    }
    else if (i[10].equals("east"))
    {
      p = 1;
    }
    else if (i[10].equals("top"))
    {
      p = WekaClassifier2.N1d78445475(i);
    }
    else if (i[10].equals("west"))
    {
      p = 2;
    }
    else if (i[10].equals("bottom"))
    {
      p = WekaClassifier2.N2cd51c476(i);
    }
    return p;
  }

  static double N1d78445475(Object[] i)
  {
    double p = Double.NaN;
    if (i[15] == null)
    {
      p = 1;
    }
    else if (((Double) i[15]).doubleValue() <= -0.36378017979563765)
    {
      p = 1;
    }
    else if (((Double) i[15]).doubleValue() > -0.36378017979563765)
    {
      p = 0;
    }
    return p;
  }

  static double N2cd51c476(Object[] i)
  {
    double p = Double.NaN;
    if (i[13] == null)
    {
      p = 0;
    }
    else if (((Double) i[13]).doubleValue() <= 0.36486388817858206)
    {
      p = 0;
    }
    else if (((Double) i[13]).doubleValue() > 0.36486388817858206)
    {
      p = 4;
    }
    return p;
  }

  static double N15b422e477(Object[] i)
  {
    double p = Double.NaN;
    if (i[10] == null)
    {
      p = 1;
    }
    else if (i[10].equals("east"))
    {
      p = WekaClassifier2.N55fa81478(i);
    }
    else if (i[10].equals("top"))
    {
      p = 2;
    }
    else if (i[10].equals("west"))
    {
      p = 1;
    }
    else if (i[10].equals("bottom"))
    {
      p = WekaClassifier2.N1a7fa99481(i);
    }
    return p;
  }

  static double N55fa81478(Object[] i)
  {
    double p = Double.NaN;
    if (i[27] == null)
    {
      p = 1;
    }
    else if (i[27].equals("Conjunction"))
    {
      p = 1;
    }
    else if (i[27].equals("SextileTrine"))
    {
      p = WekaClassifier2.Nb12b53479(i);
    }
    else if (i[27].equals("SquareOpposition"))
    {
      p = 4;
    }
    return p;
  }

  static double Nb12b53479(Object[] i)
  {
    double p = Double.NaN;
    if (i[8] == null)
    {
      p = 0;
    }
    else if (i[8].equals("east"))
    {
      p = 0;
    }
    else if (i[8].equals("top"))
    {
      p = WekaClassifier2.N1935ca7480(i);
    }
    else if (i[8].equals("west"))
    {
      p = 2;
    }
    else if (i[8].equals("bottom"))
    {
      p = 1;
    }
    return p;
  }

  static double N1935ca7480(Object[] i)
  {
    double p = Double.NaN;
    if (i[19] == null)
    {
      p = 0;
    }
    else if (((Double) i[19]).doubleValue() <= -0.09999847754351775)
    {
      p = 0;
    }
    else if (((Double) i[19]).doubleValue() > -0.09999847754351775)
    {
      p = 1;
    }
    return p;
  }

  static double N1a7fa99481(Object[] i)
  {
    double p = Double.NaN;
    if (i[24] == null)
    {
      p = 1;
    }
    else if (i[24].equals("Conjunction"))
    {
      p = 1;
    }
    else if (i[24].equals("SextileTrine"))
    {
      p = 1;
    }
    else if (i[24].equals("SquareOpposition"))
    {
      p = 4;
    }
    return p;
  }

  static double N1359448482(Object[] i)
  {
    double p = Double.NaN;
    if (i[19] == null)
    {
      p = 0;
    }
    else if (((Double) i[19]).doubleValue() <= -0.2572163934074583)
    {
      p = WekaClassifier2.N9a3afb483(i);
    }
    else if (((Double) i[19]).doubleValue() > -0.2572163934074583)
    {
      p = 0;
    }
    return p;
  }

  static double N9a3afb483(Object[] i)
  {
    double p = Double.NaN;
    if (i[12] == null)
    {
      p = 0;
    }
    else if (i[12].equals("east"))
    {
      p = 0;
    }
    else if (i[12].equals("top"))
    {
      p = WekaClassifier2.N196622e484(i);
    }
    else if (i[12].equals("west"))
    {
      p = WekaClassifier2.N7f651485(i);
    }
    else if (i[12].equals("bottom"))
    {
      p = WekaClassifier2.Nbc7325486(i);
    }
    return p;
  }

  static double N196622e484(Object[] i)
  {
    double p = Double.NaN;
    if (i[4] == null)
    {
      p = 0;
    }
    else if (i[4].equals("east"))
    {
      p = 0;
    }
    else if (i[4].equals("top"))
    {
      p = 1;
    }
    else if (i[4].equals("west"))
    {
      p = 0;
    }
    else if (i[4].equals("bottom"))
    {
      p = 0;
    }
    return p;
  }

  static double N7f651485(Object[] i)
  {
    double p = Double.NaN;
    if (i[13] == null)
    {
      p = 2;
    }
    else if (((Double) i[13]).doubleValue() <= -0.26599750193387484)
    {
      p = 2;
    }
    else if (((Double) i[13]).doubleValue() > -0.26599750193387484)
    {
      p = 0;
    }
    return p;
  }

  static double Nbc7325486(Object[] i)
  {
    double p = Double.NaN;
    if (i[17] == null)
    {
      p = 1;
    }
    else if (((Double) i[17]).doubleValue() <= -0.39874789107852165)
    {
      p = WekaClassifier2.N2ba66a487(i);
    }
    else if (((Double) i[17]).doubleValue() > -0.39874789107852165)
    {
      p = 0;
    }
    return p;
  }

  static double N2ba66a487(Object[] i)
  {
    double p = Double.NaN;
    if (i[10] == null)
    {
      p = 0;
    }
    else if (i[10].equals("east"))
    {
      p = 0;
    }
    else if (i[10].equals("top"))
    {
      p = 0;
    }
    else if (i[10].equals("west"))
    {
      p = 1;
    }
    else if (i[10].equals("bottom"))
    {
      p = 4;
    }
    return p;
  }

  static double N1bab9dc488(Object[] i)
  {
    double p = Double.NaN;
    if (i[18] == null)
    {
      p = 1;
    }
    else if (i[18].equals("east"))
    {
      p = 1;
    }
    else if (i[18].equals("top"))
    {
      p = WekaClassifier2.N4daa489(i);
    }
    else if (i[18].equals("west"))
    {
      p = WekaClassifier2.Na1eeed495(i);
    }
    else if (i[18].equals("bottom"))
    {
      p = WekaClassifier2.Nc32da8529(i);
    }
    return p;
  }

  static double N4daa489(Object[] i)
  {
    double p = Double.NaN;
    if (i[14] == null)
    {
      p = 1;
    }
    else if (i[14].equals("east"))
    {
      p = 1;
    }
    else if (i[14].equals("top"))
    {
      p = WekaClassifier2.N1eb1172490(i);
    }
    else if (i[14].equals("west"))
    {
      p = 3;
    }
    else if (i[14].equals("bottom"))
    {
      p = WekaClassifier2.N124bbbe494(i);
    }
    return p;
  }

  static double N1eb1172490(Object[] i)
  {
    double p = Double.NaN;
    if (i[12] == null)
    {
      p = 2;
    }
    else if (i[12].equals("east"))
    {
      p = 2;
    }
    else if (i[12].equals("top"))
    {
      p = WekaClassifier2.N1c68283491(i);
    }
    else if (i[12].equals("west"))
    {
      p = 3;
    }
    else if (i[12].equals("bottom"))
    {
      p = WekaClassifier2.N1ec94ea493(i);
    }
    return p;
  }

  static double N1c68283491(Object[] i)
  {
    double p = Double.NaN;
    if (i[26] == null)
    {
      p = 1;
    }
    else if (i[26].equals("Conjunction"))
    {
      p = 1;
    }
    else if (i[26].equals("SextileTrine"))
    {
      p = WekaClassifier2.N1a279d5492(i);
    }
    else if (i[26].equals("SquareOpposition"))
    {
      p = 3;
    }
    return p;
  }

  static double N1a279d5492(Object[] i)
  {
    double p = Double.NaN;
    if (i[52] == null)
    {
      p = 1;
    }
    else if (i[52].equals("Conjunction"))
    {
      p = 1;
    }
    else if (i[52].equals("SextileTrine"))
    {
      p = 3;
    }
    else if (i[52].equals("SquareOpposition"))
    {
      p = 1;
    }
    return p;
  }

  static double N1ec94ea493(Object[] i)
  {
    double p = Double.NaN;
    if (i[15] == null)
    {
      p = 2;
    }
    else if (((Double) i[15]).doubleValue() <= 0.1303156812968581)
    {
      p = 2;
    }
    else if (((Double) i[15]).doubleValue() > 0.1303156812968581)
    {
      p = 3;
    }
    return p;
  }

  static double N124bbbe494(Object[] i)
  {
    double p = Double.NaN;
    if (i[11] == null)
    {
      p = 3;
    }
    else if (((Double) i[11]).doubleValue() <= -0.11180563021175896)
    {
      p = 3;
    }
    else if (((Double) i[11]).doubleValue() > -0.11180563021175896)
    {
      p = 1;
    }
    return p;
  }

  static double Na1eeed495(Object[] i)
  {
    double p = Double.NaN;
    if (i[14] == null)
    {
      p = 1;
    }
    else if (i[14].equals("east"))
    {
      p = WekaClassifier2.N14d0d01496(i);
    }
    else if (i[14].equals("top"))
    {
      p = WekaClassifier2.N18a9400511(i);
    }
    else if (i[14].equals("west"))
    {
      p = WekaClassifier2.N34c76f521(i);
    }
    else if (i[14].equals("bottom"))
    {
      p = WekaClassifier2.N1f262ad523(i);
    }
    return p;
  }

  static double N14d0d01496(Object[] i)
  {
    double p = Double.NaN;
    if (i[12] == null)
    {
      p = 1;
    }
    else if (i[12].equals("east"))
    {
      p = WekaClassifier2.N190f6c3497(i);
    }
    else if (i[12].equals("top"))
    {
      p = WekaClassifier2.N1cfe3507(i);
    }
    else if (i[12].equals("west"))
    {
      p = WekaClassifier2.Nf74015508(i);
    }
    else if (i[12].equals("bottom"))
    {
      p = WekaClassifier2.N905fb7509(i);
    }
    return p;
  }

  static double N190f6c3497(Object[] i)
  {
    double p = Double.NaN;
    if (i[8] == null)
    {
      p = 1;
    }
    else if (i[8].equals("east"))
    {
      p = WekaClassifier2.N38ba8f498(i);
    }
    else if (i[8].equals("top"))
    {
      p = WekaClassifier2.Nec59c7500(i);
    }
    else if (i[8].equals("west"))
    {
      p = WekaClassifier2.Nfa4259501(i);
    }
    else if (i[8].equals("bottom"))
    {
      p = WekaClassifier2.N930ee7503(i);
    }
    return p;
  }

  static double N38ba8f498(Object[] i)
  {
    double p = Double.NaN;
    if (i[10] == null)
    {
      p = 0;
    }
    else if (i[10].equals("east"))
    {
      p = 0;
    }
    else if (i[10].equals("top"))
    {
      p = WekaClassifier2.N6010c2499(i);
    }
    else if (i[10].equals("west"))
    {
      p = 2;
    }
    else if (i[10].equals("bottom"))
    {
      p = 1;
    }
    return p;
  }

  static double N6010c2499(Object[] i)
  {
    double p = Double.NaN;
    if (i[6] == null)
    {
      p = 2;
    }
    else if (i[6].equals("east"))
    {
      p = 2;
    }
    else if (i[6].equals("top"))
    {
      p = 1;
    }
    else if (i[6].equals("west"))
    {
      p = 2;
    }
    else if (i[6].equals("bottom"))
    {
      p = 1;
    }
    return p;
  }

  static double Nec59c7500(Object[] i)
  {
    double p = Double.NaN;
    if (i[3] == null)
    {
      p = 1;
    }
    else if (((Double) i[3]).doubleValue() <= -0.21849911105969566)
    {
      p = 1;
    }
    else if (((Double) i[3]).doubleValue() > -0.21849911105969566)
    {
      p = 3;
    }
    return p;
  }

  static double Nfa4259501(Object[] i)
  {
    double p = Double.NaN;
    if (i[0] == null)
    {
      p = 4;
    }
    else if (i[0].equals("east"))
    {
      p = 4;
    }
    else if (i[0].equals("top"))
    {
      p = 4;
    }
    else if (i[0].equals("west"))
    {
      p = 3;
    }
    else if (i[0].equals("bottom"))
    {
      p = WekaClassifier2.N19eee5502(i);
    }
    return p;
  }

  static double N19eee5502(Object[] i)
  {
    double p = Double.NaN;
    if (i[9] == null)
    {
      p = 2;
    }
    else if (((Double) i[9]).doubleValue() <= -0.267301379885594)
    {
      p = 2;
    }
    else if (((Double) i[9]).doubleValue() > -0.267301379885594)
    {
      p = 1;
    }
    return p;
  }

  static double N930ee7503(Object[] i)
  {
    double p = Double.NaN;
    if (i[0] == null)
    {
      p = 2;
    }
    else if (i[0].equals("east"))
    {
      p = 2;
    }
    else if (i[0].equals("top"))
    {
      p = 0;
    }
    else if (i[0].equals("west"))
    {
      p = WekaClassifier2.Nb7716c504(i);
    }
    else if (i[0].equals("bottom"))
    {
      p = WekaClassifier2.N1779d1c505(i);
    }
    return p;
  }

  static double Nb7716c504(Object[] i)
  {
    double p = Double.NaN;
    if (i[1] == null)
    {
      p = 0;
    }
    else if (((Double) i[1]).doubleValue() <= -0.18522799388688463)
    {
      p = 0;
    }
    else if (((Double) i[1]).doubleValue() > -0.18522799388688463)
    {
      p = 2;
    }
    return p;
  }

  static double N1779d1c505(Object[] i)
  {
    double p = Double.NaN;
    if (i[9] == null)
    {
      p = 2;
    }
    else if (((Double) i[9]).doubleValue() <= -0.4239711423854398)
    {
      p = 2;
    }
    else if (((Double) i[9]).doubleValue() > -0.4239711423854398)
    {
      p = WekaClassifier2.N1ebbdeb506(i);
    }
    return p;
  }

  static double N1ebbdeb506(Object[] i)
  {
    double p = Double.NaN;
    if (i[9] == null)
    {
      p = 4;
    }
    else if (((Double) i[9]).doubleValue() <= -0.09119899125694673)
    {
      p = 4;
    }
    else if (((Double) i[9]).doubleValue() > -0.09119899125694673)
    {
      p = 3;
    }
    return p;
  }

  static double N1cfe3507(Object[] i)
  {
    double p = Double.NaN;
    if (i[19] == null)
    {
      p = 1;
    }
    else if (((Double) i[19]).doubleValue() <= 0.0036446656429508506)
    {
      p = 1;
    }
    else if (((Double) i[19]).doubleValue() > 0.0036446656429508506)
    {
      p = 0;
    }
    return p;
  }

  static double Nf74015508(Object[] i)
  {
    double p = Double.NaN;
    if (i[10] == null)
    {
      p = 0;
    }
    else if (i[10].equals("east"))
    {
      p = 0;
    }
    else if (i[10].equals("top"))
    {
      p = 1;
    }
    else if (i[10].equals("west"))
    {
      p = 2;
    }
    else if (i[10].equals("bottom"))
    {
      p = 2;
    }
    return p;
  }

  static double N905fb7509(Object[] i)
  {
    double p = Double.NaN;
    if (i[13] == null)
    {
      p = 1;
    }
    else if (((Double) i[13]).doubleValue() <= -0.49213193728273724)
    {
      p = WekaClassifier2.N7c19ee510(i);
    }
    else if (((Double) i[13]).doubleValue() > -0.49213193728273724)
    {
      p = 2;
    }
    return p;
  }

  static double N7c19ee510(Object[] i)
  {
    double p = Double.NaN;
    if (i[17] == null)
    {
      p = 3;
    }
    else if (((Double) i[17]).doubleValue() <= -0.15216492647006707)
    {
      p = 3;
    }
    else if (((Double) i[17]).doubleValue() > -0.15216492647006707)
    {
      p = 1;
    }
    return p;
  }

  static double N18a9400511(Object[] i)
  {
    double p = Double.NaN;
    if (i[12] == null)
    {
      p = 2;
    }
    else if (i[12].equals("east"))
    {
      p = WekaClassifier2.Nfacd6a512(i);
    }
    else if (i[12].equals("top"))
    {
      p = WekaClassifier2.N104e8ae518(i);
    }
    else if (i[12].equals("west"))
    {
      p = 1;
    }
    else if (i[12].equals("bottom"))
    {
      p = 1;
    }
    return p;
  }

  static double Nfacd6a512(Object[] i)
  {
    double p = Double.NaN;
    if (i[2] == null)
    {
      p = 2;
    }
    else if (i[2].equals("east"))
    {
      p = WekaClassifier2.N1c41cea513(i);
    }
    else if (i[2].equals("top"))
    {
      p = WekaClassifier2.N2b7924515(i);
    }
    else if (i[2].equals("west"))
    {
      p = 2;
    }
    else if (i[2].equals("bottom"))
    {
      p = 1;
    }
    return p;
  }

  static double N1c41cea513(Object[] i)
  {
    double p = Double.NaN;
    if (i[0] == null)
    {
      p = 3;
    }
    else if (i[0].equals("east"))
    {
      p = WekaClassifier2.N46675a514(i);
    }
    else if (i[0].equals("top"))
    {
      p = 2;
    }
    else if (i[0].equals("west"))
    {
      p = 1;
    }
    else if (i[0].equals("bottom"))
    {
      p = 2;
    }
    return p;
  }

  static double N46675a514(Object[] i)
  {
    double p = Double.NaN;
    if (i[11] == null)
    {
      p = 2;
    }
    else if (((Double) i[11]).doubleValue() <= -0.226271429395891)
    {
      p = 2;
    }
    else if (((Double) i[11]).doubleValue() > -0.226271429395891)
    {
      p = 3;
    }
    return p;
  }

  static double N2b7924515(Object[] i)
  {
    double p = Double.NaN;
    if (i[19] == null)
    {
      p = 1;
    }
    else if (((Double) i[19]).doubleValue() <= -0.005626881100890953)
    {
      p = WekaClassifier2.N1e5086516(i);
    }
    else if (((Double) i[19]).doubleValue() > -0.005626881100890953)
    {
      p = 2;
    }
    return p;
  }

  static double N1e5086516(Object[] i)
  {
    double p = Double.NaN;
    if (i[15] == null)
    {
      p = 1;
    }
    else if (((Double) i[15]).doubleValue() <= -0.2720844729101185)
    {
      p = 1;
    }
    else if (((Double) i[15]).doubleValue() > -0.2720844729101185)
    {
      p = WekaClassifier2.N38c4de517(i);
    }
    return p;
  }

  static double N38c4de517(Object[] i)
  {
    double p = Double.NaN;
    if (i[7] == null)
    {
      p = 1;
    }
    else if (((Double) i[7]).doubleValue() <= -0.20986348742865965)
    {
      p = 1;
    }
    else if (((Double) i[7]).doubleValue() > -0.20986348742865965)
    {
      p = 3;
    }
    return p;
  }

  static double N104e8ae518(Object[] i)
  {
    double p = Double.NaN;
    if (i[52] == null)
    {
      p = 3;
    }
    else if (i[52].equals("Conjunction"))
    {
      p = WekaClassifier2.N1482b52519(i);
    }
    else if (i[52].equals("SextileTrine"))
    {
      p = WekaClassifier2.N114279d520(i);
    }
    else if (i[52].equals("SquareOpposition"))
    {
      p = 2;
    }
    return p;
  }

  static double N1482b52519(Object[] i)
  {
    double p = Double.NaN;
    if (i[8] == null)
    {
      p = 2;
    }
    else if (i[8].equals("east"))
    {
      p = 2;
    }
    else if (i[8].equals("top"))
    {
      p = 3;
    }
    else if (i[8].equals("west"))
    {
      p = 1;
    }
    else if (i[8].equals("bottom"))
    {
      p = 1;
    }
    return p;
  }

  static double N114279d520(Object[] i)
  {
    double p = Double.NaN;
    if (i[8] == null)
    {
      p = 2;
    }
    else if (i[8].equals("east"))
    {
      p = 2;
    }
    else if (i[8].equals("top"))
    {
      p = 1;
    }
    else if (i[8].equals("west"))
    {
      p = 1;
    }
    else if (i[8].equals("bottom"))
    {
      p = 3;
    }
    return p;
  }

  static double N34c76f521(Object[] i)
  {
    double p = Double.NaN;
    if (i[28] == null)
    {
      p = 1;
    }
    else if (i[28].equals("Conjunction"))
    {
      p = 1;
    }
    else if (i[28].equals("SextileTrine"))
    {
      p = 3;
    }
    else if (i[28].equals("SquareOpposition"))
    {
      p = WekaClassifier2.N1117085522(i);
    }
    return p;
  }

  static double N1117085522(Object[] i)
  {
    double p = Double.NaN;
    if (i[12] == null)
    {
      p = 3;
    }
    else if (i[12].equals("east"))
    {
      p = 3;
    }
    else if (i[12].equals("top"))
    {
      p = 1;
    }
    else if (i[12].equals("west"))
    {
      p = 3;
    }
    else if (i[12].equals("bottom"))
    {
      p = 3;
    }
    return p;
  }

  static double N1f262ad523(Object[] i)
  {
    double p = Double.NaN;
    if (i[17] == null)
    {
      p = 0;
    }
    else if (((Double) i[17]).doubleValue() <= -0.3386912159193371)
    {
      p = WekaClassifier2.N2c6fbb524(i);
    }
    else if (((Double) i[17]).doubleValue() > -0.3386912159193371)
    {
      p = 0;
    }
    return p;
  }

  static double N2c6fbb524(Object[] i)
  {
    double p = Double.NaN;
    if (i[15] == null)
    {
      p = 0;
    }
    else if (((Double) i[15]).doubleValue() <= -0.3948562824426992)
    {
      p = WekaClassifier2.N15b74a5525(i);
    }
    else if (((Double) i[15]).doubleValue() > -0.3948562824426992)
    {
      p = WekaClassifier2.Nb657528(i);
    }
    return p;
  }

  static double N15b74a5525(Object[] i)
  {
    double p = Double.NaN;
    if (i[12] == null)
    {
      p = 3;
    }
    else if (i[12].equals("east"))
    {
      p = 3;
    }
    else if (i[12].equals("top"))
    {
      p = WekaClassifier2.N14709a4526(i);
    }
    else if (i[12].equals("west"))
    {
      p = WekaClassifier2.Nca107d527(i);
    }
    else if (i[12].equals("bottom"))
    {
      p = 0;
    }
    return p;
  }

  static double N14709a4526(Object[] i)
  {
    double p = Double.NaN;
    if (i[7] == null)
    {
      p = 0;
    }
    else if (((Double) i[7]).doubleValue() <= -0.04010936607778712)
    {
      p = 0;
    }
    else if (((Double) i[7]).doubleValue() > -0.04010936607778712)
    {
      p = 2;
    }
    return p;
  }

  static double Nca107d527(Object[] i)
  {
    double p = Double.NaN;
    if (i[19] == null)
    {
      p = 1;
    }
    else if (((Double) i[19]).doubleValue() <= -0.25999396810012837)
    {
      p = 1;
    }
    else if (((Double) i[19]).doubleValue() > -0.25999396810012837)
    {
      p = 2;
    }
    return p;
  }

  static double Nb657528(Object[] i)
  {
    double p = Double.NaN;
    if (i[19] == null)
    {
      p = 1;
    }
    else if (((Double) i[19]).doubleValue() <= -0.15597205040672096)
    {
      p = 1;
    }
    else if (((Double) i[19]).doubleValue() > -0.15597205040672096)
    {
      p = 0;
    }
    return p;
  }

  static double Nc32da8529(Object[] i)
  {
    double p = Double.NaN;
    if (i[14] == null)
    {
      p = 0;
    }
    else if (i[14].equals("east"))
    {
      p = 0;
    }
    else if (i[14].equals("top"))
    {
      p = WekaClassifier2.N1ea9e1e530(i);
    }
    else if (i[14].equals("west"))
    {
      p = 0;
    }
    else if (i[14].equals("bottom"))
    {
      p = 0;
    }
    return p;
  }

  static double N1ea9e1e530(Object[] i)
  {
    double p = Double.NaN;
    if (i[7] == null)
    {
      p = 2;
    }
    else if (((Double) i[7]).doubleValue() <= -0.3473441647547641)
    {
      p = 2;
    }
    else if (((Double) i[7]).doubleValue() > -0.3473441647547641)
    {
      p = WekaClassifier2.N33000c531(i);
    }
    return p;
  }

  static double N33000c531(Object[] i)
  {
    double p = Double.NaN;
    if (i[7] == null)
    {
      p = 1;
    }
    else if (((Double) i[7]).doubleValue() <= 0.027818306162206374)
    {
      p = 1;
    }
    else if (((Double) i[7]).doubleValue() > 0.027818306162206374)
    {
      p = 3;
    }
    return p;
  }

  static double N48548e532(Object[] i)
  {
    double p = Double.NaN;
    if (i[18] == null)
    {
      p = 0;
    }
    else if (i[18].equals("east"))
    {
      p = WekaClassifier2.Na75aae533(i);
    }
    else if (i[18].equals("top"))
    {
      p = 3;
    }
    else if (i[18].equals("west"))
    {
      p = WekaClassifier2.Nfc533d541(i);
    }
    else if (i[18].equals("bottom"))
    {
      p = WekaClassifier2.N9120e8555(i);
    }
    return p;
  }

  static double Na75aae533(Object[] i)
  {
    double p = Double.NaN;
    if (i[14] == null)
    {
      p = 0;
    }
    else if (i[14].equals("east"))
    {
      p = 0;
    }
    else if (i[14].equals("top"))
    {
      p = WekaClassifier2.N132718a534(i);
    }
    else if (i[14].equals("west"))
    {
      p = WekaClassifier2.N1793e97540(i);
    }
    else if (i[14].equals("bottom"))
    {
      p = 0;
    }
    return p;
  }

  static double N132718a534(Object[] i)
  {
    double p = Double.NaN;
    if (i[15] == null)
    {
      p = 0;
    }
    else if (((Double) i[15]).doubleValue() <= -0.059159392050291595)
    {
      p = 0;
    }
    else if (((Double) i[15]).doubleValue() > -0.059159392050291595)
    {
      p = WekaClassifier2.Nbc2e1a535(i);
    }
    return p;
  }

  static double Nbc2e1a535(Object[] i)
  {
    double p = Double.NaN;
    if (i[19] == null)
    {
      p = 0;
    }
    else if (((Double) i[19]).doubleValue() <= 0.22536449583391616)
    {
      p = WekaClassifier2.N76b692536(i);
    }
    else if (((Double) i[19]).doubleValue() > 0.22536449583391616)
    {
      p = 0;
    }
    return p;
  }

  static double N76b692536(Object[] i)
  {
    double p = Double.NaN;
    if (i[10] == null)
    {
      p = 2;
    }
    else if (i[10].equals("east"))
    {
      p = WekaClassifier2.N1cc2b7a537(i);
    }
    else if (i[10].equals("top"))
    {
      p = 2;
    }
    else if (i[10].equals("west"))
    {
      p = WekaClassifier2.N13a90f4538(i);
    }
    else if (i[10].equals("bottom"))
    {
      p = WekaClassifier2.N28d08539(i);
    }
    return p;
  }

  static double N1cc2b7a537(Object[] i)
  {
    double p = Double.NaN;
    if (i[13] == null)
    {
      p = 3;
    }
    else if (((Double) i[13]).doubleValue() <= 0.03686979685653191)
    {
      p = 3;
    }
    else if (((Double) i[13]).doubleValue() > 0.03686979685653191)
    {
      p = 2;
    }
    return p;
  }

  static double N13a90f4538(Object[] i)
  {
    double p = Double.NaN;
    if (i[11] == null)
    {
      p = 0;
    }
    else if (((Double) i[11]).doubleValue() <= -0.5027419872899692)
    {
      p = 0;
    }
    else if (((Double) i[11]).doubleValue() > -0.5027419872899692)
    {
      p = 1;
    }
    return p;
  }

  static double N28d08539(Object[] i)
  {
    double p = Double.NaN;
    if (i[11] == null)
    {
      p = 3;
    }
    else if (((Double) i[11]).doubleValue() <= -0.19132739435876053)
    {
      p = 3;
    }
    else if (((Double) i[11]).doubleValue() > -0.19132739435876053)
    {
      p = 0;
    }
    return p;
  }

  static double N1793e97540(Object[] i)
  {
    double p = Double.NaN;
    if (i[15] == null)
    {
      p = 2;
    }
    else if (((Double) i[15]).doubleValue() <= -0.5161173019862612)
    {
      p = 2;
    }
    else if (((Double) i[15]).doubleValue() > -0.5161173019862612)
    {
      p = 1;
    }
    return p;
  }

  static double Nfc533d541(Object[] i)
  {
    double p = Double.NaN;
    if (i[14] == null)
    {
      p = 3;
    }
    else if (i[14].equals("east"))
    {
      p = WekaClassifier2.N1bcf45b542(i);
    }
    else if (i[14].equals("top"))
    {
      p = 1;
    }
    else if (i[14].equals("west"))
    {
      p = WekaClassifier2.N11eddf1544(i);
    }
    else if (i[14].equals("bottom"))
    {
      p = 3;
    }
    return p;
  }

  static double N1bcf45b542(Object[] i)
  {
    double p = Double.NaN;
    if (i[3] == null)
    {
      p = 3;
    }
    else if (((Double) i[3]).doubleValue() <= 0.4679410509075258)
    {
      p = WekaClassifier2.N4e9ce6543(i);
    }
    else if (((Double) i[3]).doubleValue() > 0.4679410509075258)
    {
      p = 1;
    }
    return p;
  }

  static double N4e9ce6543(Object[] i)
  {
    double p = Double.NaN;
    if (i[7] == null)
    {
      p = 3;
    }
    else if (((Double) i[7]).doubleValue() <= 0.45149714582846245)
    {
      p = 3;
    }
    else if (((Double) i[7]).doubleValue() > 0.45149714582846245)
    {
      p = 1;
    }
    return p;
  }

  static double N11eddf1544(Object[] i)
  {
    double p = Double.NaN;
    if (i[12] == null)
    {
      p = 2;
    }
    else if (i[12].equals("east"))
    {
      p = WekaClassifier2.N17d3a6a545(i);
    }
    else if (i[12].equals("top"))
    {
      p = WekaClassifier2.N14ee262552(i);
    }
    else if (i[12].equals("west"))
    {
      p = WekaClassifier2.N1f61ba5554(i);
    }
    else if (i[12].equals("bottom"))
    {
      p = 3;
    }
    return p;
  }

  static double N17d3a6a545(Object[] i)
  {
    double p = Double.NaN;
    if (i[13] == null)
    {
      p = 3;
    }
    else if (((Double) i[13]).doubleValue() <= -0.08031706043447229)
    {
      p = 3;
    }
    else if (((Double) i[13]).doubleValue() > -0.08031706043447229)
    {
      p = WekaClassifier2.N8627c3546(i);
    }
    return p;
  }

  static double N8627c3546(Object[] i)
  {
    double p = Double.NaN;
    if (i[11] == null)
    {
      p = 2;
    }
    else if (((Double) i[11]).doubleValue() <= 0.4141517048003862)
    {
      p = WekaClassifier2.N19c9d88547(i);
    }
    else if (((Double) i[11]).doubleValue() > 0.4141517048003862)
    {
      p = 3;
    }
    return p;
  }

  static double N19c9d88547(Object[] i)
  {
    double p = Double.NaN;
    if (i[10] == null)
    {
      p = 2;
    }
    else if (i[10].equals("east"))
    {
      p = 2;
    }
    else if (i[10].equals("top"))
    {
      p = 3;
    }
    else if (i[10].equals("west"))
    {
      p = WekaClassifier2.N12a7fd6548(i);
    }
    else if (i[10].equals("bottom"))
    {
      p = WekaClassifier2.N982d8e550(i);
    }
    return p;
  }

  static double N12a7fd6548(Object[] i)
  {
    double p = Double.NaN;
    if (i[15] == null)
    {
      p = 1;
    }
    else if (((Double) i[15]).doubleValue() <= -0.33996184609072266)
    {
      p = WekaClassifier2.N12ec15a549(i);
    }
    else if (((Double) i[15]).doubleValue() > -0.33996184609072266)
    {
      p = 2;
    }
    return p;
  }

  static double N12ec15a549(Object[] i)
  {
    double p = Double.NaN;
    if (i[19] == null)
    {
      p = 1;
    }
    else if (((Double) i[19]).doubleValue() <= -0.18668373451504072)
    {
      p = 1;
    }
    else if (((Double) i[19]).doubleValue() > -0.18668373451504072)
    {
      p = 2;
    }
    return p;
  }

  static double N982d8e550(Object[] i)
  {
    double p = Double.NaN;
    if (i[5] == null)
    {
      p = 1;
    }
    else if (((Double) i[5]).doubleValue() <= 0.04276065155863762)
    {
      p = WekaClassifier2.Nd6e8d0551(i);
    }
    else if (((Double) i[5]).doubleValue() > 0.04276065155863762)
    {
      p = 2;
    }
    return p;
  }

  static double Nd6e8d0551(Object[] i)
  {
    double p = Double.NaN;
    if (i[13] == null)
    {
      p = 1;
    }
    else if (((Double) i[13]).doubleValue() <= 0.6092584346372674)
    {
      p = 1;
    }
    else if (((Double) i[13]).doubleValue() > 0.6092584346372674)
    {
      p = 2;
    }
    return p;
  }

  static double N14ee262552(Object[] i)
  {
    double p = Double.NaN;
    if (i[36] == null)
    {
      p = 1;
    }
    else if (i[36].equals("Conjunction"))
    {
      p = 1;
    }
    else if (i[36].equals("SextileTrine"))
    {
      p = 2;
    }
    else if (i[36].equals("SquareOpposition"))
    {
      p = WekaClassifier2.N1f095ba553(i);
    }
    return p;
  }

  static double N1f095ba553(Object[] i)
  {
    double p = Double.NaN;
    if (i[4] == null)
    {
      p = 2;
    }
    else if (i[4].equals("east"))
    {
      p = 2;
    }
    else if (i[4].equals("top"))
    {
      p = 2;
    }
    else if (i[4].equals("west"))
    {
      p = 3;
    }
    else if (i[4].equals("bottom"))
    {
      p = 1;
    }
    return p;
  }

  static double N1f61ba5554(Object[] i)
  {
    double p = Double.NaN;
    if (i[8] == null)
    {
      p = 3;
    }
    else if (i[8].equals("east"))
    {
      p = 3;
    }
    else if (i[8].equals("top"))
    {
      p = 2;
    }
    else if (i[8].equals("west"))
    {
      p = 2;
    }
    else if (i[8].equals("bottom"))
    {
      p = 1;
    }
    return p;
  }

  static double N9120e8555(Object[] i)
  {
    double p = Double.NaN;
    if (i[14] == null)
    {
      p = 0;
    }
    else if (i[14].equals("east"))
    {
      p = WekaClassifier2.N77947556(i);
    }
    else if (i[14].equals("top"))
    {
      p = WekaClassifier2.N1914b58560(i);
    }
    else if (i[14].equals("west"))
    {
      p = WekaClassifier2.N18dba4b572(i);
    }
    else if (i[14].equals("bottom"))
    {
      p = WekaClassifier2.N12b2373576(i);
    }
    return p;
  }

  static double N77947556(Object[] i)
  {
    double p = Double.NaN;
    if (i[12] == null)
    {
      p = 0;
    }
    else if (i[12].equals("east"))
    {
      p = 0;
    }
    else if (i[12].equals("top"))
    {
      p = 0;
    }
    else if (i[12].equals("west"))
    {
      p = WekaClassifier2.Nab5071557(i);
    }
    else if (i[12].equals("bottom"))
    {
      p = WekaClassifier2.N938f00559(i);
    }
    return p;
  }

  static double Nab5071557(Object[] i)
  {
    double p = Double.NaN;
    if (i[10] == null)
    {
      p = 0;
    }
    else if (i[10].equals("east"))
    {
      p = 0;
    }
    else if (i[10].equals("top"))
    {
      p = 0;
    }
    else if (i[10].equals("west"))
    {
      p = WekaClassifier2.N12e2d1c558(i);
    }
    else if (i[10].equals("bottom"))
    {
      p = 2;
    }
    return p;
  }

  static double N12e2d1c558(Object[] i)
  {
    double p = Double.NaN;
    if (i[13] == null)
    {
      p = 0;
    }
    else if (((Double) i[13]).doubleValue() <= -0.006829565963354878)
    {
      p = 0;
    }
    else if (((Double) i[13]).doubleValue() > -0.006829565963354878)
    {
      p = 1;
    }
    return p;
  }

  static double N938f00559(Object[] i)
  {
    double p = Double.NaN;
    if (i[15] == null)
    {
      p = 2;
    }
    else if (((Double) i[15]).doubleValue() <= -0.6611669162835161)
    {
      p = 2;
    }
    else if (((Double) i[15]).doubleValue() > -0.6611669162835161)
    {
      p = 0;
    }
    return p;
  }

  static double N1914b58560(Object[] i)
  {
    double p = Double.NaN;
    if (i[8] == null)
    {
      p = 1;
    }
    else if (i[8].equals("east"))
    {
      p = WekaClassifier2.N1e9b9ae561(i);
    }
    else if (i[8].equals("top"))
    {
      p = WekaClassifier2.N8a366d567(i);
    }
    else if (i[8].equals("west"))
    {
      p = 1;
    }
    else if (i[8].equals("bottom"))
    {
      p = WekaClassifier2.Ne301d6571(i);
    }
    return p;
  }

  static double N1e9b9ae561(Object[] i)
  {
    double p = Double.NaN;
    if (i[26] == null)
    {
      p = 2;
    }
    else if (i[26].equals("Conjunction"))
    {
      p = WekaClassifier2.N19d7364562(i);
    }
    else if (i[26].equals("SextileTrine"))
    {
      p = WekaClassifier2.N197c904564(i);
    }
    else if (i[26].equals("SquareOpposition"))
    {
      p = WekaClassifier2.N109c593566(i);
    }
    return p;
  }

  static double N19d7364562(Object[] i)
  {
    double p = Double.NaN;
    if (i[0] == null)
    {
      p = 1;
    }
    else if (i[0].equals("east"))
    {
      p = 1;
    }
    else if (i[0].equals("top"))
    {
      p = WekaClassifier2.N2cbe3563(i);
    }
    else if (i[0].equals("west"))
    {
      p = 2;
    }
    else if (i[0].equals("bottom"))
    {
      p = 4;
    }
    return p;
  }

  static double N2cbe3563(Object[] i)
  {
    double p = Double.NaN;
    if (i[15] == null)
    {
      p = 0;
    }
    else if (((Double) i[15]).doubleValue() <= -0.1896192782015502)
    {
      p = 0;
    }
    else if (((Double) i[15]).doubleValue() > -0.1896192782015502)
    {
      p = 2;
    }
    return p;
  }

  static double N197c904564(Object[] i)
  {
    double p = Double.NaN;
    if (i[52] == null)
    {
      p = 1;
    }
    else if (i[52].equals("Conjunction"))
    {
      p = 1;
    }
    else if (i[52].equals("SextileTrine"))
    {
      p = 1;
    }
    else if (i[52].equals("SquareOpposition"))
    {
      p = WekaClassifier2.Ne3e05565(i);
    }
    return p;
  }

  static double Ne3e05565(Object[] i)
  {
    double p = Double.NaN;
    if (i[12] == null)
    {
      p = 4;
    }
    else if (i[12].equals("east"))
    {
      p = 4;
    }
    else if (i[12].equals("top"))
    {
      p = 4;
    }
    else if (i[12].equals("west"))
    {
      p = 2;
    }
    else if (i[12].equals("bottom"))
    {
      p = 2;
    }
    return p;
  }

  static double N109c593566(Object[] i)
  {
    double p = Double.NaN;
    if (i[12] == null)
    {
      p = 1;
    }
    else if (i[12].equals("east"))
    {
      p = 1;
    }
    else if (i[12].equals("top"))
    {
      p = 4;
    }
    else if (i[12].equals("west"))
    {
      p = 0;
    }
    else if (i[12].equals("bottom"))
    {
      p = 1;
    }
    return p;
  }

  static double N8a366d567(Object[] i)
  {
    double p = Double.NaN;
    if (i[4] == null)
    {
      p = 2;
    }
    else if (i[4].equals("east"))
    {
      p = WekaClassifier2.N1fb42e6568(i);
    }
    else if (i[4].equals("top"))
    {
      p = 2;
    }
    else if (i[4].equals("west"))
    {
      p = WekaClassifier2.N46338f570(i);
    }
    else if (i[4].equals("bottom"))
    {
      p = 1;
    }
    return p;
  }

  static double N1fb42e6568(Object[] i)
  {
    double p = Double.NaN;
    if (i[12] == null)
    {
      p = 1;
    }
    else if (i[12].equals("east"))
    {
      p = WekaClassifier2.Ne50f28569(i);
    }
    else if (i[12].equals("top"))
    {
      p = 2;
    }
    else if (i[12].equals("west"))
    {
      p = 2;
    }
    else if (i[12].equals("bottom"))
    {
      p = 1;
    }
    return p;
  }

  static double Ne50f28569(Object[] i)
  {
    double p = Double.NaN;
    if (i[1] == null)
    {
      p = 1;
    }
    else if (((Double) i[1]).doubleValue() <= -0.011928260887130154)
    {
      p = 1;
    }
    else if (((Double) i[1]).doubleValue() > -0.011928260887130154)
    {
      p = 3;
    }
    return p;
  }

  static double N46338f570(Object[] i)
  {
    double p = Double.NaN;
    if (i[53] == null)
    {
      p = 1;
    }
    else if (i[53].equals("Conjunction"))
    {
      p = 1;
    }
    else if (i[53].equals("SextileTrine"))
    {
      p = 1;
    }
    else if (i[53].equals("SquareOpposition"))
    {
      p = 0;
    }
    return p;
  }

  static double Ne301d6571(Object[] i)
  {
    double p = Double.NaN;
    if (i[34] == null)
    {
      p = 1;
    }
    else if (i[34].equals("Conjunction"))
    {
      p = 1;
    }
    else if (i[34].equals("SextileTrine"))
    {
      p = 2;
    }
    else if (i[34].equals("SquareOpposition"))
    {
      p = 1;
    }
    return p;
  }

  static double N18dba4b572(Object[] i)
  {
    double p = Double.NaN;
    if (i[12] == null)
    {
      p = 1;
    }
    else if (i[12].equals("east"))
    {
      p = 1;
    }
    else if (i[12].equals("top"))
    {
      p = WekaClassifier2.N1c1bed5573(i);
    }
    else if (i[12].equals("west"))
    {
      p = WekaClassifier2.N123c26575(i);
    }
    else if (i[12].equals("bottom"))
    {
      p = 1;
    }
    return p;
  }

  static double N1c1bed5573(Object[] i)
  {
    double p = Double.NaN;
    if (i[5] == null)
    {
      p = 3;
    }
    else if (((Double) i[5]).doubleValue() <= -0.24307580292224884)
    {
      p = 3;
    }
    else if (((Double) i[5]).doubleValue() > -0.24307580292224884)
    {
      p = WekaClassifier2.Nd79f28574(i);
    }
    return p;
  }

  static double Nd79f28574(Object[] i)
  {
    double p = Double.NaN;
    if (i[15] == null)
    {
      p = 1;
    }
    else if (((Double) i[15]).doubleValue() <= 0.01864303814146906)
    {
      p = 1;
    }
    else if (((Double) i[15]).doubleValue() > 0.01864303814146906)
    {
      p = 2;
    }
    return p;
  }

  static double N123c26575(Object[] i)
  {
    double p = Double.NaN;
    if (i[43] == null)
    {
      p = 2;
    }
    else if (i[43].equals("Conjunction"))
    {
      p = 2;
    }
    else if (i[43].equals("SextileTrine"))
    {
      p = 1;
    }
    else if (i[43].equals("SquareOpposition"))
    {
      p = 2;
    }
    return p;
  }

  static double N12b2373576(Object[] i)
  {
    double p = Double.NaN;
    if (i[54] == null)
    {
      p = 1;
    }
    else if (i[54].equals("Conjunction"))
    {
      p = 1;
    }
    else if (i[54].equals("SextileTrine"))
    {
      p = 3;
    }
    else if (i[54].equals("SquareOpposition"))
    {
      p = WekaClassifier2.N12483d5577(i);
    }
    return p;
  }

  static double N12483d5577(Object[] i)
  {
    double p = Double.NaN;
    if (i[4] == null)
    {
      p = 1;
    }
    else if (i[4].equals("east"))
    {
      p = WekaClassifier2.N4b19a3578(i);
    }
    else if (i[4].equals("top"))
    {
      p = WekaClassifier2.N803b41579(i);
    }
    else if (i[4].equals("west"))
    {
      p = 3;
    }
    else if (i[4].equals("bottom"))
    {
      p = WekaClassifier2.Nb25cf9580(i);
    }
    return p;
  }

  static double N4b19a3578(Object[] i)
  {
    double p = Double.NaN;
    if (i[10] == null)
    {
      p = 3;
    }
    else if (i[10].equals("east"))
    {
      p = 3;
    }
    else if (i[10].equals("top"))
    {
      p = 1;
    }
    else if (i[10].equals("west"))
    {
      p = 3;
    }
    else if (i[10].equals("bottom"))
    {
      p = 1;
    }
    return p;
  }

  static double N803b41579(Object[] i)
  {
    double p = Double.NaN;
    if (i[1] == null)
    {
      p = 2;
    }
    else if (((Double) i[1]).doubleValue() <= -0.2835853954119309)
    {
      p = 2;
    }
    else if (((Double) i[1]).doubleValue() > -0.2835853954119309)
    {
      p = 3;
    }
    return p;
  }

  static double Nb25cf9580(Object[] i)
  {
    double p = Double.NaN;
    if (i[15] == null)
    {
      p = 2;
    }
    else if (((Double) i[15]).doubleValue() <= -0.07423969603177362)
    {
      p = 2;
    }
    else if (((Double) i[15]).doubleValue() > -0.07423969603177362)
    {
      p = 3;
    }
    return p;
  }
}
