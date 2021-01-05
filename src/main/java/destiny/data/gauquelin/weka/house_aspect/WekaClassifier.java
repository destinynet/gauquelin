/**
 * @author smallufo 
 * Created on 2009/3/19 at 上午 1:01:56
 */
package destiny.data.gauquelin.weka.house_aspect;

public class WekaClassifier
{
  public static double classify(Object[] i) {

    double p = Double.NaN;
    p = WekaClassifier.N2672ff0(i);
    return p;
  }

  static double N2672ff0(Object[] i)
  {
    double p = Double.NaN;
    if (i[8] == null)
    {
      p = 3;
    }
    else if (i[8].equals("1"))
    {
      p = WekaClassifier.N47fad11(i);
    }
    else if (i[8].equals("2"))
    {
      p = WekaClassifier.N281d5a5(i);
    }
    else if (i[8].equals("3"))
    {
      p = WekaClassifier.N19f31076(i);
    }
    else if (i[8].equals("4"))
    {
      p = WekaClassifier.N4bf8bd7(i);
    }
    else if (i[8].equals("5"))
    {
      p = WekaClassifier.N168be3012(i);
    }
    else if (i[8].equals("6"))
    {
      p = WekaClassifier.N199849b18(i);
    }
    else if (i[8].equals("7"))
    {
      p = WekaClassifier.N1e1b0f425(i);
    }
    else if (i[8].equals("8"))
    {
      p = WekaClassifier.N5960135(i);
    }
    else if (i[8].equals("9"))
    {
      p = WekaClassifier.Nc555cb41(i);
    }
    else if (i[8].equals("10"))
    {
      p = WekaClassifier.Nd89f9251(i);
    }
    else if (i[8].equals("11"))
    {
      p = WekaClassifier.Nccb40354(i);
    }
    else if (i[8].equals("12"))
    {
      p = WekaClassifier.N91296264(i);
    }
    return p;
  }

  static double N47fad11(Object[] i)
  {
    double p = Double.NaN;
    if (i[9] == null)
    {
      p = 1;
    }
    else if (i[9].equals("1"))
    {
      p = 1;
    }
    else if (i[9].equals("2"))
    {
      p = WekaClassifier.N1a3d8842(i);
    }
    else if (i[9].equals("3"))
    {
      p = 3;
    }
    else if (i[9].equals("4"))
    {
      p = 3;
    }
    else if (i[9].equals("5"))
    {
      p = 3;
    }
    else if (i[9].equals("6"))
    {
      p = 3;
    }
    else if (i[9].equals("7"))
    {
      p = 3;
    }
    else if (i[9].equals("8"))
    {
      p = 3;
    }
    else if (i[9].equals("9"))
    {
      p = 3;
    }
    else if (i[9].equals("10"))
    {
      p = 0;
    }
    else if (i[9].equals("11"))
    {
      p = 0;
    }
    else if (i[9].equals("12"))
    {
      p = 1;
    }
    return p;
  }

  static double N1a3d8842(Object[] i)
  {
    double p = Double.NaN;
    if (i[7] == null)
    {
      p = 3;
    }
    else if (i[7].equals("1"))
    {
      p = 3;
    }
    else if (i[7].equals("2"))
    {
      p = 3;
    }
    else if (i[7].equals("3"))
    {
      p = 3;
    }
    else if (i[7].equals("4"))
    {
      p = 2;
    }
    else if (i[7].equals("5"))
    {
      p = WekaClassifier.N1dbd56a3(i);
    }
    else if (i[7].equals("6"))
    {
      p = WekaClassifier.N19836974(i);
    }
    else if (i[7].equals("7"))
    {
      p = 3;
    }
    else if (i[7].equals("8"))
    {
      p = 3;
    }
    else if (i[7].equals("9"))
    {
      p = 3;
    }
    else if (i[7].equals("10"))
    {
      p = 3;
    }
    else if (i[7].equals("11"))
    {
      p = 3;
    }
    else if (i[7].equals("12"))
    {
      p = 3;
    }
    return p;
  }

  static double N1dbd56a3(Object[] i)
  {
    double p = Double.NaN;
    if (i[5] == null)
    {
      p = 1;
    }
    else if (i[5].equals("1"))
    {
      p = 1;
    }
    else if (i[5].equals("2"))
    {
      p = 2;
    }
    else if (i[5].equals("3"))
    {
      p = 2;
    }
    else if (i[5].equals("4"))
    {
      p = 3;
    }
    else if (i[5].equals("5"))
    {
      p = 1;
    }
    else if (i[5].equals("6"))
    {
      p = 1;
    }
    else if (i[5].equals("7"))
    {
      p = 2;
    }
    else if (i[5].equals("8"))
    {
      p = 1;
    }
    else if (i[5].equals("9"))
    {
      p = 3;
    }
    else if (i[5].equals("10"))
    {
      p = 1;
    }
    else if (i[5].equals("11"))
    {
      p = 2;
    }
    else if (i[5].equals("12"))
    {
      p = 2;
    }
    return p;
  }

  static double N19836974(Object[] i)
  {
    double p = Double.NaN;
    if (i[3] == null)
    {
      p = 1;
    }
    else if (i[3].equals("1"))
    {
      p = 1;
    }
    else if (i[3].equals("2"))
    {
      p = 3;
    }
    else if (i[3].equals("3"))
    {
      p = 0;
    }
    else if (i[3].equals("4"))
    {
      p = 4;
    }
    else if (i[3].equals("5"))
    {
      p = 3;
    }
    else if (i[3].equals("6"))
    {
      p = 2;
    }
    else if (i[3].equals("7"))
    {
      p = 1;
    }
    else if (i[3].equals("8"))
    {
      p = 3;
    }
    else if (i[3].equals("9"))
    {
      p = 3;
    }
    else if (i[3].equals("10"))
    {
      p = 1;
    }
    else if (i[3].equals("11"))
    {
      p = 5;
    }
    else if (i[3].equals("12"))
    {
      p = 1;
    }
    return p;
  }

  static double N281d5a5(Object[] i)
  {
    double p = Double.NaN;
    if (i[9] == null)
    {
      p = 1;
    }
    else if (i[9].equals("1"))
    {
      p = 1;
    }
    else if (i[9].equals("2"))
    {
      p = 1;
    }
    else if (i[9].equals("3"))
    {
      p = 1;
    }
    else if (i[9].equals("4"))
    {
      p = 3;
    }
    else if (i[9].equals("5"))
    {
      p = 3;
    }
    else if (i[9].equals("6"))
    {
      p = 3;
    }
    else if (i[9].equals("7"))
    {
      p = 1;
    }
    else if (i[9].equals("8"))
    {
      p = 1;
    }
    else if (i[9].equals("9"))
    {
      p = 1;
    }
    else if (i[9].equals("10"))
    {
      p = 1;
    }
    else if (i[9].equals("11"))
    {
      p = 0;
    }
    else if (i[9].equals("12"))
    {
      p = 0;
    }
    return p;
  }

  static double N19f31076(Object[] i)
  {
    double p = Double.NaN;
    if (i[7] == null)
    {
      p = 3;
    }
    else if (i[7].equals("1"))
    {
      p = 3;
    }
    else if (i[7].equals("2"))
    {
      p = 3;
    }
    else if (i[7].equals("3"))
    {
      p = 3;
    }
    else if (i[7].equals("4"))
    {
      p = 3;
    }
    else if (i[7].equals("5"))
    {
      p = 2;
    }
    else if (i[7].equals("6"))
    {
      p = 2;
    }
    else if (i[7].equals("7"))
    {
      p = 1;
    }
    else if (i[7].equals("8"))
    {
      p = 1;
    }
    else if (i[7].equals("9"))
    {
      p = 1;
    }
    else if (i[7].equals("10"))
    {
      p = 0;
    }
    else if (i[7].equals("11"))
    {
      p = 0;
    }
    else if (i[7].equals("12"))
    {
      p = 3;
    }
    return p;
  }

  static double N4bf8bd7(Object[] i)
  {
    double p = Double.NaN;
    if (i[7] == null)
    {
      p = 1;
    }
    else if (i[7].equals("1"))
    {
      p = 1;
    }
    else if (i[7].equals("2"))
    {
      p = 3;
    }
    else if (i[7].equals("3"))
    {
      p = 3;
    }
    else if (i[7].equals("4"))
    {
      p = 3;
    }
    else if (i[7].equals("5"))
    {
      p = 3;
    }
    else if (i[7].equals("6"))
    {
      p = 3;
    }
    else if (i[7].equals("7"))
    {
      p = WekaClassifier.N1b76a808(i);
    }
    else if (i[7].equals("8"))
    {
      p = WekaClassifier.Nb137ed9(i);
    }
    else if (i[7].equals("9"))
    {
      p = WekaClassifier.N17f7ef711(i);
    }
    else if (i[7].equals("10"))
    {
      p = 1;
    }
    else if (i[7].equals("11"))
    {
      p = 0;
    }
    else if (i[7].equals("12"))
    {
      p = 0;
    }
    return p;
  }

  static double N1b76a808(Object[] i)
  {
    double p = Double.NaN;
    if (i[5] == null)
    {
      p = 1;
    }
    else if (i[5].equals("1"))
    {
      p = 1;
    }
    else if (i[5].equals("2"))
    {
      p = 2;
    }
    else if (i[5].equals("3"))
    {
      p = 2;
    }
    else if (i[5].equals("4"))
    {
      p = 3;
    }
    else if (i[5].equals("5"))
    {
      p = 2;
    }
    else if (i[5].equals("6"))
    {
      p = 1;
    }
    else if (i[5].equals("7"))
    {
      p = 2;
    }
    else if (i[5].equals("8"))
    {
      p = 1;
    }
    else if (i[5].equals("9"))
    {
      p = 1;
    }
    else if (i[5].equals("10"))
    {
      p = 2;
    }
    else if (i[5].equals("11"))
    {
      p = 1;
    }
    else if (i[5].equals("12"))
    {
      p = 2;
    }
    return p;
  }

  static double Nb137ed9(Object[] i)
  {
    double p = Double.NaN;
    if (i[6] == null)
    {
      p = 1;
    }
    else if (i[6].equals("1"))
    {
      p = 1;
    }
    else if (i[6].equals("2"))
    {
      p = 2;
    }
    else if (i[6].equals("3"))
    {
      p = 1;
    }
    else if (i[6].equals("4"))
    {
      p = WekaClassifier.Ncee68210(i);
    }
    else if (i[6].equals("5"))
    {
      p = 1;
    }
    else if (i[6].equals("6"))
    {
      p = 1;
    }
    else if (i[6].equals("7"))
    {
      p = 1;
    }
    else if (i[6].equals("8"))
    {
      p = 0;
    }
    else if (i[6].equals("9"))
    {
      p = 0;
    }
    else if (i[6].equals("10"))
    {
      p = 1;
    }
    else if (i[6].equals("11"))
    {
      p = 2;
    }
    else if (i[6].equals("12"))
    {
      p = 2;
    }
    return p;
  }

  static double Ncee68210(Object[] i)
  {
    double p = Double.NaN;
    if (i[9] == null)
    {
      p = 3;
    }
    else if (i[9].equals("1"))
    {
      p = 3;
    }
    else if (i[9].equals("2"))
    {
      p = 3;
    }
    else if (i[9].equals("3"))
    {
      p = 3;
    }
    else if (i[9].equals("4"))
    {
      p = 2;
    }
    else if (i[9].equals("5"))
    {
      p = 3;
    }
    else if (i[9].equals("6"))
    {
      p = 3;
    }
    else if (i[9].equals("7"))
    {
      p = 3;
    }
    else if (i[9].equals("8"))
    {
      p = 3;
    }
    else if (i[9].equals("9"))
    {
      p = 3;
    }
    else if (i[9].equals("10"))
    {
      p = 3;
    }
    else if (i[9].equals("11"))
    {
      p = 3;
    }
    else if (i[9].equals("12"))
    {
      p = 3;
    }
    return p;
  }

  static double N17f7ef711(Object[] i)
  {
    double p = Double.NaN;
    if (i[0] == null)
    {
      p = 1;
    }
    else if (i[0].equals("1"))
    {
      p = 1;
    }
    else if (i[0].equals("2"))
    {
      p = 5;
    }
    else if (i[0].equals("3"))
    {
      p = 0;
    }
    else if (i[0].equals("4"))
    {
      p = 4;
    }
    else if (i[0].equals("5"))
    {
      p = 1;
    }
    else if (i[0].equals("6"))
    {
      p = 1;
    }
    else if (i[0].equals("7"))
    {
      p = 4;
    }
    else if (i[0].equals("8"))
    {
      p = 5;
    }
    else if (i[0].equals("9"))
    {
      p = 0;
    }
    else if (i[0].equals("10"))
    {
      p = 1;
    }
    else if (i[0].equals("11"))
    {
      p = 5;
    }
    else if (i[0].equals("12"))
    {
      p = 1;
    }
    return p;
  }

  static double N168be3012(Object[] i)
  {
    double p = Double.NaN;
    if (i[7] == null)
    {
      p = 0;
    }
    else if (i[7].equals("1"))
    {
      p = 0;
    }
    else if (i[7].equals("2"))
    {
      p = 1;
    }
    else if (i[7].equals("3"))
    {
      p = 3;
    }
    else if (i[7].equals("4"))
    {
      p = 3;
    }
    else if (i[7].equals("5"))
    {
      p = 3;
    }
    else if (i[7].equals("6"))
    {
      p = 3;
    }
    else if (i[7].equals("7"))
    {
      p = 3;
    }
    else if (i[7].equals("8"))
    {
      p = WekaClassifier.N19e4c4b13(i);
    }
    else if (i[7].equals("9"))
    {
      p = 1;
    }
    else if (i[7].equals("10"))
    {
      p = WekaClassifier.N1db323316(i);
    }
    else if (i[7].equals("11"))
    {
      p = WekaClassifier.N1bcda3317(i);
    }
    else if (i[7].equals("12"))
    {
      p = 0;
    }
    return p;
  }

  static double N19e4c4b13(Object[] i)
  {
    double p = Double.NaN;
    if (i[3] == null)
    {
      p = 1;
    }
    else if (i[3].equals("1"))
    {
      p = 1;
    }
    else if (i[3].equals("2"))
    {
      p = WekaClassifier.N1a2d7ef14(i);
    }
    else if (i[3].equals("3"))
    {
      p = 3;
    }
    else if (i[3].equals("4"))
    {
      p = 3;
    }
    else if (i[3].equals("5"))
    {
      p = 2;
    }
    else if (i[3].equals("6"))
    {
      p = 1;
    }
    else if (i[3].equals("7"))
    {
      p = 1;
    }
    else if (i[3].equals("8"))
    {
      p = 2;
    }
    else if (i[3].equals("9"))
    {
      p = WekaClassifier.Nebdfd15(i);
    }
    else if (i[3].equals("10"))
    {
      p = 2;
    }
    else if (i[3].equals("11"))
    {
      p = 1;
    }
    else if (i[3].equals("12"))
    {
      p = 1;
    }
    return p;
  }

  static double N1a2d7ef14(Object[] i)
  {
    double p = Double.NaN;
    if (i[2] == null)
    {
      p = 2;
    }
    else if (i[2].equals("1"))
    {
      p = 2;
    }
    else if (i[2].equals("2"))
    {
      p = 2;
    }
    else if (i[2].equals("3"))
    {
      p = 1;
    }
    else if (i[2].equals("4"))
    {
      p = 2;
    }
    else if (i[2].equals("5"))
    {
      p = 2;
    }
    else if (i[2].equals("6"))
    {
      p = 2;
    }
    else if (i[2].equals("7"))
    {
      p = 2;
    }
    else if (i[2].equals("8"))
    {
      p = 2;
    }
    else if (i[2].equals("9"))
    {
      p = 2;
    }
    else if (i[2].equals("10"))
    {
      p = 2;
    }
    else if (i[2].equals("11"))
    {
      p = 1;
    }
    else if (i[2].equals("12"))
    {
      p = 2;
    }
    return p;
  }

  static double Nebdfd15(Object[] i)
  {
    double p = Double.NaN;
    if (i[9] == null)
    {
      p = 1;
    }
    else if (i[9].equals("1"))
    {
      p = 1;
    }
    else if (i[9].equals("2"))
    {
      p = 1;
    }
    else if (i[9].equals("3"))
    {
      p = 1;
    }
    else if (i[9].equals("4"))
    {
      p = 1;
    }
    else if (i[9].equals("5"))
    {
      p = 1;
    }
    else if (i[9].equals("6"))
    {
      p = 1;
    }
    else if (i[9].equals("7"))
    {
      p = 2;
    }
    else if (i[9].equals("8"))
    {
      p = 1;
    }
    else if (i[9].equals("9"))
    {
      p = 1;
    }
    else if (i[9].equals("10"))
    {
      p = 1;
    }
    else if (i[9].equals("11"))
    {
      p = 1;
    }
    else if (i[9].equals("12"))
    {
      p = 1;
    }
    return p;
  }

  static double N1db323316(Object[] i)
  {
    double p = Double.NaN;
    if (i[2] == null)
    {
      p = 1;
    }
    else if (i[2].equals("1"))
    {
      p = 1;
    }
    else if (i[2].equals("2"))
    {
      p = 5;
    }
    else if (i[2].equals("3"))
    {
      p = 2;
    }
    else if (i[2].equals("4"))
    {
      p = 2;
    }
    else if (i[2].equals("5"))
    {
      p = 3;
    }
    else if (i[2].equals("6"))
    {
      p = 1;
    }
    else if (i[2].equals("7"))
    {
      p = 1;
    }
    else if (i[2].equals("8"))
    {
      p = 1;
    }
    else if (i[2].equals("9"))
    {
      p = 1;
    }
    else if (i[2].equals("10"))
    {
      p = 1;
    }
    else if (i[2].equals("11"))
    {
      p = 2;
    }
    else if (i[2].equals("12"))
    {
      p = 0;
    }
    return p;
  }

  static double N1bcda3317(Object[] i)
  {
    double p = Double.NaN;
    if (i[3] == null)
    {
      p = 3;
    }
    else if (i[3].equals("1"))
    {
      p = 3;
    }
    else if (i[3].equals("2"))
    {
      p = 1;
    }
    else if (i[3].equals("3"))
    {
      p = 0;
    }
    else if (i[3].equals("4"))
    {
      p = 1;
    }
    else if (i[3].equals("5"))
    {
      p = 1;
    }
    else if (i[3].equals("6"))
    {
      p = 1;
    }
    else if (i[3].equals("7"))
    {
      p = 1;
    }
    else if (i[3].equals("8"))
    {
      p = 2;
    }
    else if (i[3].equals("9"))
    {
      p = 0;
    }
    else if (i[3].equals("10"))
    {
      p = 1;
    }
    else if (i[3].equals("11"))
    {
      p = 0;
    }
    else if (i[3].equals("12"))
    {
      p = 2;
    }
    return p;
  }

  static double N199849b18(Object[] i)
  {
    double p = Double.NaN;
    if (i[9] == null)
    {
      p = 3;
    }
    else if (i[9].equals("1"))
    {
      p = 3;
    }
    else if (i[9].equals("2"))
    {
      p = 3;
    }
    else if (i[9].equals("3"))
    {
      p = 3;
    }
    else if (i[9].equals("4"))
    {
      p = 0;
    }
    else if (i[9].equals("5"))
    {
      p = WekaClassifier.N1d0ef6619(i);
    }
    else if (i[9].equals("6"))
    {
      p = 1;
    }
    else if (i[9].equals("7"))
    {
      p = WekaClassifier.N16fa31921(i);
    }
    else if (i[9].equals("8"))
    {
      p = WekaClassifier.N1734cd423(i);
    }
    else if (i[9].equals("9"))
    {
      p = 3;
    }
    else if (i[9].equals("10"))
    {
      p = 3;
    }
    else if (i[9].equals("11"))
    {
      p = 1;
    }
    else if (i[9].equals("12"))
    {
      p = 3;
    }
    return p;
  }

  static double N1d0ef6619(Object[] i)
  {
    double p = Double.NaN;
    if (i[7] == null)
    {
      p = 0;
    }
    else if (i[7].equals("1"))
    {
      p = 0;
    }
    else if (i[7].equals("2"))
    {
      p = 0;
    }
    else if (i[7].equals("3"))
    {
      p = 0;
    }
    else if (i[7].equals("4"))
    {
      p = 0;
    }
    else if (i[7].equals("5"))
    {
      p = 0;
    }
    else if (i[7].equals("6"))
    {
      p = 0;
    }
    else if (i[7].equals("7"))
    {
      p = 0;
    }
    else if (i[7].equals("8"))
    {
      p = 0;
    }
    else if (i[7].equals("9"))
    {
      p = 0;
    }
    else if (i[7].equals("10"))
    {
      p = 1;
    }
    else if (i[7].equals("11"))
    {
      p = WekaClassifier.N15127820(i);
    }
    else if (i[7].equals("12"))
    {
      p = 1;
    }
    return p;
  }

  static double N15127820(Object[] i)
  {
    double p = Double.NaN;
    if (i[6] == null)
    {
      p = 1;
    }
    else if (i[6].equals("1"))
    {
      p = 1;
    }
    else if (i[6].equals("2"))
    {
      p = 1;
    }
    else if (i[6].equals("3"))
    {
      p = 1;
    }
    else if (i[6].equals("4"))
    {
      p = 1;
    }
    else if (i[6].equals("5"))
    {
      p = 1;
    }
    else if (i[6].equals("6"))
    {
      p = 1;
    }
    else if (i[6].equals("7"))
    {
      p = 1;
    }
    else if (i[6].equals("8"))
    {
      p = 1;
    }
    else if (i[6].equals("9"))
    {
      p = 1;
    }
    else if (i[6].equals("10"))
    {
      p = 2;
    }
    else if (i[6].equals("11"))
    {
      p = 5;
    }
    else if (i[6].equals("12"))
    {
      p = 3;
    }
    return p;
  }

  static double N16fa31921(Object[] i)
  {
    double p = Double.NaN;
    if (i[7] == null)
    {
      p = 1;
    }
    else if (i[7].equals("1"))
    {
      p = 1;
    }
    else if (i[7].equals("2"))
    {
      p = 1;
    }
    else if (i[7].equals("3"))
    {
      p = 1;
    }
    else if (i[7].equals("4"))
    {
      p = 1;
    }
    else if (i[7].equals("5"))
    {
      p = 1;
    }
    else if (i[7].equals("6"))
    {
      p = 1;
    }
    else if (i[7].equals("7"))
    {
      p = 1;
    }
    else if (i[7].equals("8"))
    {
      p = 2;
    }
    else if (i[7].equals("9"))
    {
      p = WekaClassifier.N3cc42c22(i);
    }
    else if (i[7].equals("10"))
    {
      p = 5;
    }
    else if (i[7].equals("11"))
    {
      p = 1;
    }
    else if (i[7].equals("12"))
    {
      p = 1;
    }
    return p;
  }

  static double N3cc42c22(Object[] i)
  {
    double p = Double.NaN;
    if (i[2] == null)
    {
      p = 1;
    }
    else if (i[2].equals("1"))
    {
      p = 1;
    }
    else if (i[2].equals("2"))
    {
      p = 1;
    }
    else if (i[2].equals("3"))
    {
      p = 1;
    }
    else if (i[2].equals("4"))
    {
      p = 3;
    }
    else if (i[2].equals("5"))
    {
      p = 1;
    }
    else if (i[2].equals("6"))
    {
      p = 2;
    }
    else if (i[2].equals("7"))
    {
      p = 1;
    }
    else if (i[2].equals("8"))
    {
      p = 2;
    }
    else if (i[2].equals("9"))
    {
      p = 3;
    }
    else if (i[2].equals("10"))
    {
      p = 1;
    }
    else if (i[2].equals("11"))
    {
      p = 1;
    }
    else if (i[2].equals("12"))
    {
      p = 3;
    }
    return p;
  }

  static double N1734cd423(Object[] i)
  {
    double p = Double.NaN;
    if (i[7] == null)
    {
      p = 3;
    }
    else if (i[7].equals("1"))
    {
      p = 3;
    }
    else if (i[7].equals("2"))
    {
      p = 3;
    }
    else if (i[7].equals("3"))
    {
      p = 3;
    }
    else if (i[7].equals("4"))
    {
      p = 3;
    }
    else if (i[7].equals("5"))
    {
      p = 3;
    }
    else if (i[7].equals("6"))
    {
      p = 2;
    }
    else if (i[7].equals("7"))
    {
      p = 3;
    }
    else if (i[7].equals("8"))
    {
      p = 3;
    }
    else if (i[7].equals("9"))
    {
      p = WekaClassifier.Nb92f9024(i);
    }
    else if (i[7].equals("10"))
    {
      p = 3;
    }
    else if (i[7].equals("11"))
    {
      p = 3;
    }
    else if (i[7].equals("12"))
    {
      p = 3;
    }
    return p;
  }

  static double Nb92f9024(Object[] i)
  {
    double p = Double.NaN;
    if (i[1] == null)
    {
      p = 5;
    }
    else if (i[1].equals("1"))
    {
      p = 5;
    }
    else if (i[1].equals("2"))
    {
      p = 1;
    }
    else if (i[1].equals("3"))
    {
      p = 1;
    }
    else if (i[1].equals("4"))
    {
      p = 2;
    }
    else if (i[1].equals("5"))
    {
      p = 2;
    }
    else if (i[1].equals("6"))
    {
      p = 3;
    }
    else if (i[1].equals("7"))
    {
      p = 1;
    }
    else if (i[1].equals("8"))
    {
      p = 2;
    }
    else if (i[1].equals("9"))
    {
      p = 1;
    }
    else if (i[1].equals("10"))
    {
      p = 5;
    }
    else if (i[1].equals("11"))
    {
      p = 3;
    }
    else if (i[1].equals("12"))
    {
      p = 1;
    }
    return p;
  }

  static double N1e1b0f425(Object[] i)
  {
    double p = Double.NaN;
    if (i[7] == null)
    {
      p = 1;
    }
    else if (i[7].equals("1"))
    {
      p = WekaClassifier.N28717826(i);
    }
    else if (i[7].equals("2"))
    {
      p = 0;
    }
    else if (i[7].equals("3"))
    {
      p = 0;
    }
    else if (i[7].equals("4"))
    {
      p = 0;
    }
    else if (i[7].equals("5"))
    {
      p = 0;
    }
    else if (i[7].equals("6"))
    {
      p = WekaClassifier.N1a9024830(i);
    }
    else if (i[7].equals("7"))
    {
      p = WekaClassifier.Nd4e39131(i);
    }
    else if (i[7].equals("8"))
    {
      p = 3;
    }
    else if (i[7].equals("9"))
    {
      p = WekaClassifier.Na8701932(i);
    }
    else if (i[7].equals("10"))
    {
      p = 1;
    }
    else if (i[7].equals("11"))
    {
      p = 1;
    }
    else if (i[7].equals("12"))
    {
      p = WekaClassifier.N57acef33(i);
    }
    return p;
  }

  static double N28717826(Object[] i)
  {
    double p = Double.NaN;
    if (i[6] == null)
    {
      p = 2;
    }
    else if (i[6].equals("1"))
    {
      p = 2;
    }
    else if (i[6].equals("2"))
    {
      p = WekaClassifier.N131bdfd27(i);
    }
    else if (i[6].equals("3"))
    {
      p = WekaClassifier.Nb035dc28(i);
    }
    else if (i[6].equals("4"))
    {
      p = 1;
    }
    else if (i[6].equals("5"))
    {
      p = 3;
    }
    else if (i[6].equals("6"))
    {
      p = 0;
    }
    else if (i[6].equals("7"))
    {
      p = WekaClassifier.Na02c0129(i);
    }
    else if (i[6].equals("8"))
    {
      p = 0;
    }
    else if (i[6].equals("9"))
    {
      p = 0;
    }
    else if (i[6].equals("10"))
    {
      p = 1;
    }
    else if (i[6].equals("11"))
    {
      p = 0;
    }
    else if (i[6].equals("12"))
    {
      p = 0;
    }
    return p;
  }

  static double N131bdfd27(Object[] i)
  {
    double p = Double.NaN;
    if (i[4] == null)
    {
      p = 5;
    }
    else if (i[4].equals("1"))
    {
      p = 5;
    }
    else if (i[4].equals("2"))
    {
      p = 2;
    }
    else if (i[4].equals("3"))
    {
      p = 3;
    }
    else if (i[4].equals("4"))
    {
      p = 4;
    }
    else if (i[4].equals("5"))
    {
      p = 0;
    }
    else if (i[4].equals("6"))
    {
      p = 1;
    }
    else if (i[4].equals("7"))
    {
      p = 3;
    }
    else if (i[4].equals("8"))
    {
      p = 2;
    }
    else if (i[4].equals("9"))
    {
      p = 1;
    }
    else if (i[4].equals("10"))
    {
      p = 4;
    }
    else if (i[4].equals("11"))
    {
      p = 1;
    }
    else if (i[4].equals("12"))
    {
      p = 1;
    }
    return p;
  }

  static double Nb035dc28(Object[] i)
  {
    double p = Double.NaN;
    if (i[5] == null)
    {
      p = 1;
    }
    else if (i[5].equals("1"))
    {
      p = 1;
    }
    else if (i[5].equals("2"))
    {
      p = 1;
    }
    else if (i[5].equals("3"))
    {
      p = 1;
    }
    else if (i[5].equals("4"))
    {
      p = 3;
    }
    else if (i[5].equals("5"))
    {
      p = 1;
    }
    else if (i[5].equals("6"))
    {
      p = 1;
    }
    else if (i[5].equals("7"))
    {
      p = 1;
    }
    else if (i[5].equals("8"))
    {
      p = 0;
    }
    else if (i[5].equals("9"))
    {
      p = 2;
    }
    else if (i[5].equals("10"))
    {
      p = 1;
    }
    else if (i[5].equals("11"))
    {
      p = 5;
    }
    else if (i[5].equals("12"))
    {
      p = 1;
    }
    return p;
  }

  static double Na02c0129(Object[] i)
  {
    double p = Double.NaN;
    if (i[9] == null)
    {
      p = 2;
    }
    else if (i[9].equals("1"))
    {
      p = 2;
    }
    else if (i[9].equals("2"))
    {
      p = 2;
    }
    else if (i[9].equals("3"))
    {
      p = 2;
    }
    else if (i[9].equals("4"))
    {
      p = 2;
    }
    else if (i[9].equals("5"))
    {
      p = 0;
    }
    else if (i[9].equals("6"))
    {
      p = 2;
    }
    else if (i[9].equals("7"))
    {
      p = 2;
    }
    else if (i[9].equals("8"))
    {
      p = 2;
    }
    else if (i[9].equals("9"))
    {
      p = 2;
    }
    else if (i[9].equals("10"))
    {
      p = 2;
    }
    else if (i[9].equals("11"))
    {
      p = 2;
    }
    else if (i[9].equals("12"))
    {
      p = 2;
    }
    return p;
  }

  static double N1a9024830(Object[] i)
  {
    double p = Double.NaN;
    if (i[9] == null)
    {
      p = 1;
    }
    else if (i[9].equals("1"))
    {
      p = 1;
    }
    else if (i[9].equals("2"))
    {
      p = 1;
    }
    else if (i[9].equals("3"))
    {
      p = 1;
    }
    else if (i[9].equals("4"))
    {
      p = 1;
    }
    else if (i[9].equals("5"))
    {
      p = 1;
    }
    else if (i[9].equals("6"))
    {
      p = 1;
    }
    else if (i[9].equals("7"))
    {
      p = 1;
    }
    else if (i[9].equals("8"))
    {
      p = 1;
    }
    else if (i[9].equals("9"))
    {
      p = 1;
    }
    else if (i[9].equals("10"))
    {
      p = 5;
    }
    else if (i[9].equals("11"))
    {
      p = 3;
    }
    else if (i[9].equals("12"))
    {
      p = 1;
    }
    return p;
  }

  static double Nd4e39131(Object[] i)
  {
    double p = Double.NaN;
    if (i[9] == null)
    {
      p = 3;
    }
    else if (i[9].equals("1"))
    {
      p = 3;
    }
    else if (i[9].equals("2"))
    {
      p = 3;
    }
    else if (i[9].equals("3"))
    {
      p = 3;
    }
    else if (i[9].equals("4"))
    {
      p = 3;
    }
    else if (i[9].equals("5"))
    {
      p = 3;
    }
    else if (i[9].equals("6"))
    {
      p = 3;
    }
    else if (i[9].equals("7"))
    {
      p = 3;
    }
    else if (i[9].equals("8"))
    {
      p = 3;
    }
    else if (i[9].equals("9"))
    {
      p = 3;
    }
    else if (i[9].equals("10"))
    {
      p = 3;
    }
    else if (i[9].equals("11"))
    {
      p = 3;
    }
    else if (i[9].equals("12"))
    {
      p = 1;
    }
    return p;
  }

  static double Na8701932(Object[] i)
  {
    double p = Double.NaN;
    if (i[6] == null)
    {
      p = 2;
    }
    else if (i[6].equals("1"))
    {
      p = 2;
    }
    else if (i[6].equals("2"))
    {
      p = 1;
    }
    else if (i[6].equals("3"))
    {
      p = 1;
    }
    else if (i[6].equals("4"))
    {
      p = 3;
    }
    else if (i[6].equals("5"))
    {
      p = 1;
    }
    else if (i[6].equals("6"))
    {
      p = 3;
    }
    else if (i[6].equals("7"))
    {
      p = 3;
    }
    else if (i[6].equals("8"))
    {
      p = 3;
    }
    else if (i[6].equals("9"))
    {
      p = 1;
    }
    else if (i[6].equals("10"))
    {
      p = 1;
    }
    else if (i[6].equals("11"))
    {
      p = 2;
    }
    else if (i[6].equals("12"))
    {
      p = 2;
    }
    return p;
  }

  static double N57acef33(Object[] i)
  {
    double p = Double.NaN;
    if (i[2] == null)
    {
      p = 1;
    }
    else if (i[2].equals("1"))
    {
      p = 1;
    }
    else if (i[2].equals("2"))
    {
      p = WekaClassifier.N1ab78134(i);
    }
    else if (i[2].equals("3"))
    {
      p = 3;
    }
    else if (i[2].equals("4"))
    {
      p = 5;
    }
    else if (i[2].equals("5"))
    {
      p = 2;
    }
    else if (i[2].equals("6"))
    {
      p = 4;
    }
    else if (i[2].equals("7"))
    {
      p = 1;
    }
    else if (i[2].equals("8"))
    {
      p = 3;
    }
    else if (i[2].equals("9"))
    {
      p = 1;
    }
    else if (i[2].equals("10"))
    {
      p = 2;
    }
    else if (i[2].equals("11"))
    {
      p = 4;
    }
    else if (i[2].equals("12"))
    {
      p = 0;
    }
    return p;
  }

  static double N1ab78134(Object[] i)
  {
    double p = Double.NaN;
    if (i[9] == null)
    {
      p = 5;
    }
    else if (i[9].equals("1"))
    {
      p = 5;
    }
    else if (i[9].equals("2"))
    {
      p = 5;
    }
    else if (i[9].equals("3"))
    {
      p = 5;
    }
    else if (i[9].equals("4"))
    {
      p = 5;
    }
    else if (i[9].equals("5"))
    {
      p = 5;
    }
    else if (i[9].equals("6"))
    {
      p = 0;
    }
    else if (i[9].equals("7"))
    {
      p = 5;
    }
    else if (i[9].equals("8"))
    {
      p = 2;
    }
    else if (i[9].equals("9"))
    {
      p = 5;
    }
    else if (i[9].equals("10"))
    {
      p = 5;
    }
    else if (i[9].equals("11"))
    {
      p = 5;
    }
    else if (i[9].equals("12"))
    {
      p = 5;
    }
    return p;
  }

  static double N5960135(Object[] i)
  {
    double p = Double.NaN;
    if (i[9] == null)
    {
      p = 2;
    }
    else if (i[9].equals("1"))
    {
      p = 2;
    }
    else if (i[9].equals("2"))
    {
      p = 1;
    }
    else if (i[9].equals("3"))
    {
      p = 1;
    }
    else if (i[9].equals("4"))
    {
      p = 1;
    }
    else if (i[9].equals("5"))
    {
      p = 1;
    }
    else if (i[9].equals("6"))
    {
      p = 0;
    }
    else if (i[9].equals("7"))
    {
      p = WekaClassifier.Nbb42a536(i);
    }
    else if (i[9].equals("8"))
    {
      p = 1;
    }
    else if (i[9].equals("9"))
    {
      p = WekaClassifier.N185b74239(i);
    }
    else if (i[9].equals("10"))
    {
      p = 3;
    }
    else if (i[9].equals("11"))
    {
      p = 3;
    }
    else if (i[9].equals("12"))
    {
      p = 3;
    }
    return p;
  }

  static double Nbb42a536(Object[] i)
  {
    double p = Double.NaN;
    if (i[7] == null)
    {
      p = 1;
    }
    else if (i[7].equals("1"))
    {
      p = WekaClassifier.N14600937(i);
    }
    else if (i[7].equals("2"))
    {
      p = WekaClassifier.N1ad19ff38(i);
    }
    else if (i[7].equals("3"))
    {
      p = 0;
    }
    else if (i[7].equals("4"))
    {
      p = 0;
    }
    else if (i[7].equals("5"))
    {
      p = 0;
    }
    else if (i[7].equals("6"))
    {
      p = 0;
    }
    else if (i[7].equals("7"))
    {
      p = 0;
    }
    else if (i[7].equals("8"))
    {
      p = 0;
    }
    else if (i[7].equals("9"))
    {
      p = 0;
    }
    else if (i[7].equals("10"))
    {
      p = 0;
    }
    else if (i[7].equals("11"))
    {
      p = 0;
    }
    else if (i[7].equals("12"))
    {
      p = 3;
    }
    return p;
  }

  static double N14600937(Object[] i)
  {
    double p = Double.NaN;
    if (i[6] == null)
    {
      p = 2;
    }
    else if (i[6].equals("1"))
    {
      p = 2;
    }
    else if (i[6].equals("2"))
    {
      p = 1;
    }
    else if (i[6].equals("3"))
    {
      p = 0;
    }
    else if (i[6].equals("4"))
    {
      p = 1;
    }
    else if (i[6].equals("5"))
    {
      p = 1;
    }
    else if (i[6].equals("6"))
    {
      p = 1;
    }
    else if (i[6].equals("7"))
    {
      p = 1;
    }
    else if (i[6].equals("8"))
    {
      p = 1;
    }
    else if (i[6].equals("9"))
    {
      p = 1;
    }
    else if (i[6].equals("10"))
    {
      p = 1;
    }
    else if (i[6].equals("11"))
    {
      p = 1;
    }
    else if (i[6].equals("12"))
    {
      p = 4;
    }
    return p;
  }

  static double N1ad19ff38(Object[] i)
  {
    double p = Double.NaN;
    if (i[13] == null)
    {
      p = 2;
    }
    else if (i[13].equals("Conjunction"))
    {
      p = 2;
    }
    else if (i[13].equals("SextileTrine"))
    {
      p = 0;
    }
    else if (i[13].equals("SquareOpposition"))
    {
      p = 0;
    }
    return p;
  }

  static double N185b74239(Object[] i)
  {
    double p = Double.NaN;
    if (i[7] == null)
    {
      p = 1;
    }
    else if (i[7].equals("1"))
    {
      p = 1;
    }
    else if (i[7].equals("2"))
    {
      p = 2;
    }
    else if (i[7].equals("3"))
    {
      p = 2;
    }
    else if (i[7].equals("4"))
    {
      p = 2;
    }
    else if (i[7].equals("5"))
    {
      p = 2;
    }
    else if (i[7].equals("6"))
    {
      p = 2;
    }
    else if (i[7].equals("7"))
    {
      p = 2;
    }
    else if (i[7].equals("8"))
    {
      p = 2;
    }
    else if (i[7].equals("9"))
    {
      p = 2;
    }
    else if (i[7].equals("10"))
    {
      p = 2;
    }
    else if (i[7].equals("11"))
    {
      p = WekaClassifier.N1c2625340(i);
    }
    else if (i[7].equals("12"))
    {
      p = 1;
    }
    return p;
  }

  static double N1c2625340(Object[] i)
  {
    double p = Double.NaN;
    if (i[5] == null)
    {
      p = 2;
    }
    else if (i[5].equals("1"))
    {
      p = 2;
    }
    else if (i[5].equals("2"))
    {
      p = 2;
    }
    else if (i[5].equals("3"))
    {
      p = 1;
    }
    else if (i[5].equals("4"))
    {
      p = 2;
    }
    else if (i[5].equals("5"))
    {
      p = 1;
    }
    else if (i[5].equals("6"))
    {
      p = 2;
    }
    else if (i[5].equals("7"))
    {
      p = 1;
    }
    else if (i[5].equals("8"))
    {
      p = 2;
    }
    else if (i[5].equals("9"))
    {
      p = 2;
    }
    else if (i[5].equals("10"))
    {
      p = 3;
    }
    else if (i[5].equals("11"))
    {
      p = 1;
    }
    else if (i[5].equals("12"))
    {
      p = 1;
    }
    return p;
  }

  static double Nc555cb41(Object[] i)
  {
    double p = Double.NaN;
    if (i[9] == null)
    {
      p = 1;
    }
    else if (i[9].equals("1"))
    {
      p = 1;
    }
    else if (i[9].equals("2"))
    {
      p = 1;
    }
    else if (i[9].equals("3"))
    {
      p = 1;
    }
    else if (i[9].equals("4"))
    {
      p = 1;
    }
    else if (i[9].equals("5"))
    {
      p = 1;
    }
    else if (i[9].equals("6"))
    {
      p = 1;
    }
    else if (i[9].equals("7"))
    {
      p = 0;
    }
    else if (i[9].equals("8"))
    {
      p = WekaClassifier.N183aeee42(i);
    }
    else if (i[9].equals("9"))
    {
      p = WekaClassifier.Nb8bd7845(i);
    }
    else if (i[9].equals("10"))
    {
      p = WekaClassifier.N12301d848(i);
    }
    else if (i[9].equals("11"))
    {
      p = 3;
    }
    else if (i[9].equals("12"))
    {
      p = 3;
    }
    return p;
  }

  static double N183aeee42(Object[] i)
  {
    double p = Double.NaN;
    if (i[7] == null)
    {
      p = 0;
    }
    else if (i[7].equals("1"))
    {
      p = 0;
    }
    else if (i[7].equals("2"))
    {
      p = WekaClassifier.N51a6b443(i);
    }
    else if (i[7].equals("3"))
    {
      p = WekaClassifier.N97a0b844(i);
    }
    else if (i[7].equals("4"))
    {
      p = 0;
    }
    else if (i[7].equals("5"))
    {
      p = 0;
    }
    else if (i[7].equals("6"))
    {
      p = 0;
    }
    else if (i[7].equals("7"))
    {
      p = 0;
    }
    else if (i[7].equals("8"))
    {
      p = 0;
    }
    else if (i[7].equals("9"))
    {
      p = 0;
    }
    else if (i[7].equals("10"))
    {
      p = 0;
    }
    else if (i[7].equals("11"))
    {
      p = 0;
    }
    else if (i[7].equals("12"))
    {
      p = 0;
    }
    return p;
  }

  static double N51a6b443(Object[] i)
  {
    double p = Double.NaN;
    if (i[2] == null)
    {
      p = 5;
    }
    else if (i[2].equals("1"))
    {
      p = 5;
    }
    else if (i[2].equals("2"))
    {
      p = 1;
    }
    else if (i[2].equals("3"))
    {
      p = 2;
    }
    else if (i[2].equals("4"))
    {
      p = 0;
    }
    else if (i[2].equals("5"))
    {
      p = 0;
    }
    else if (i[2].equals("6"))
    {
      p = 1;
    }
    else if (i[2].equals("7"))
    {
      p = 1;
    }
    else if (i[2].equals("8"))
    {
      p = 3;
    }
    else if (i[2].equals("9"))
    {
      p = 1;
    }
    else if (i[2].equals("10"))
    {
      p = 5;
    }
    else if (i[2].equals("11"))
    {
      p = 2;
    }
    else if (i[2].equals("12"))
    {
      p = 1;
    }
    return p;
  }

  static double N97a0b844(Object[] i)
  {
    double p = Double.NaN;
    if (i[0] == null)
    {
      p = 1;
    }
    else if (i[0].equals("1"))
    {
      p = 1;
    }
    else if (i[0].equals("2"))
    {
      p = 0;
    }
    else if (i[0].equals("3"))
    {
      p = 2;
    }
    else if (i[0].equals("4"))
    {
      p = 0;
    }
    else if (i[0].equals("5"))
    {
      p = 2;
    }
    else if (i[0].equals("6"))
    {
      p = 1;
    }
    else if (i[0].equals("7"))
    {
      p = 0;
    }
    else if (i[0].equals("8"))
    {
      p = 2;
    }
    else if (i[0].equals("9"))
    {
      p = 1;
    }
    else if (i[0].equals("10"))
    {
      p = 1;
    }
    else if (i[0].equals("11"))
    {
      p = 2;
    }
    else if (i[0].equals("12"))
    {
      p = 0;
    }
    return p;
  }

  static double Nb8bd7845(Object[] i)
  {
    double p = Double.NaN;
    if (i[7] == null)
    {
      p = 1;
    }
    else if (i[7].equals("1"))
    {
      p = 1;
    }
    else if (i[7].equals("2"))
    {
      p = WekaClassifier.N9f379b46(i);
    }
    else if (i[7].equals("3"))
    {
      p = 1;
    }
    else if (i[7].equals("4"))
    {
      p = WekaClassifier.Nfbb4ec47(i);
    }
    else if (i[7].equals("5"))
    {
      p = 1;
    }
    else if (i[7].equals("6"))
    {
      p = 1;
    }
    else if (i[7].equals("7"))
    {
      p = 1;
    }
    else if (i[7].equals("8"))
    {
      p = 1;
    }
    else if (i[7].equals("9"))
    {
      p = 1;
    }
    else if (i[7].equals("10"))
    {
      p = 1;
    }
    else if (i[7].equals("11"))
    {
      p = 2;
    }
    else if (i[7].equals("12"))
    {
      p = 1;
    }
    return p;
  }

  static double N9f379b46(Object[] i)
  {
    double p = Double.NaN;
    if (i[2] == null)
    {
      p = 2;
    }
    else if (i[2].equals("1"))
    {
      p = 2;
    }
    else if (i[2].equals("2"))
    {
      p = 4;
    }
    else if (i[2].equals("3"))
    {
      p = 2;
    }
    else if (i[2].equals("4"))
    {
      p = 2;
    }
    else if (i[2].equals("5"))
    {
      p = 1;
    }
    else if (i[2].equals("6"))
    {
      p = 5;
    }
    else if (i[2].equals("7"))
    {
      p = 0;
    }
    else if (i[2].equals("8"))
    {
      p = 2;
    }
    else if (i[2].equals("9"))
    {
      p = 5;
    }
    else if (i[2].equals("10"))
    {
      p = 2;
    }
    else if (i[2].equals("11"))
    {
      p = 0;
    }
    else if (i[2].equals("12"))
    {
      p = 3;
    }
    return p;
  }

  static double Nfbb4ec47(Object[] i)
  {
    double p = Double.NaN;
    if (i[6] == null)
    {
      p = 0;
    }
    else if (i[6].equals("1"))
    {
      p = 0;
    }
    else if (i[6].equals("2"))
    {
      p = 0;
    }
    else if (i[6].equals("3"))
    {
      p = 0;
    }
    else if (i[6].equals("4"))
    {
      p = 0;
    }
    else if (i[6].equals("5"))
    {
      p = 0;
    }
    else if (i[6].equals("6"))
    {
      p = 1;
    }
    else if (i[6].equals("7"))
    {
      p = 0;
    }
    else if (i[6].equals("8"))
    {
      p = 3;
    }
    else if (i[6].equals("9"))
    {
      p = 0;
    }
    else if (i[6].equals("10"))
    {
      p = 0;
    }
    else if (i[6].equals("11"))
    {
      p = 1;
    }
    else if (i[6].equals("12"))
    {
      p = 0;
    }
    return p;
  }

  static double N12301d848(Object[] i)
  {
    double p = Double.NaN;
    if (i[7] == null)
    {
      p = 1;
    }
    else if (i[7].equals("1"))
    {
      p = 1;
    }
    else if (i[7].equals("2"))
    {
      p = 2;
    }
    else if (i[7].equals("3"))
    {
      p = 1;
    }
    else if (i[7].equals("4"))
    {
      p = 1;
    }
    else if (i[7].equals("5"))
    {
      p = 1;
    }
    else if (i[7].equals("6"))
    {
      p = 1;
    }
    else if (i[7].equals("7"))
    {
      p = 1;
    }
    else if (i[7].equals("8"))
    {
      p = 1;
    }
    else if (i[7].equals("9"))
    {
      p = 1;
    }
    else if (i[7].equals("10"))
    {
      p = 3;
    }
    else if (i[7].equals("11"))
    {
      p = WekaClassifier.N14e1be049(i);
    }
    else if (i[7].equals("12"))
    {
      p = WekaClassifier.N108297050(i);
    }
    return p;
  }

  static double N14e1be049(Object[] i)
  {
    double p = Double.NaN;
    if (i[2] == null)
    {
      p = 1;
    }
    else if (i[2].equals("1"))
    {
      p = 1;
    }
    else if (i[2].equals("2"))
    {
      p = 2;
    }
    else if (i[2].equals("3"))
    {
      p = 1;
    }
    else if (i[2].equals("4"))
    {
      p = 3;
    }
    else if (i[2].equals("5"))
    {
      p = 1;
    }
    else if (i[2].equals("6"))
    {
      p = 2;
    }
    else if (i[2].equals("7"))
    {
      p = 2;
    }
    else if (i[2].equals("8"))
    {
      p = 5;
    }
    else if (i[2].equals("9"))
    {
      p = 2;
    }
    else if (i[2].equals("10"))
    {
      p = 1;
    }
    else if (i[2].equals("11"))
    {
      p = 1;
    }
    else if (i[2].equals("12"))
    {
      p = 1;
    }
    return p;
  }

  static double N108297050(Object[] i)
  {
    double p = Double.NaN;
    if (i[1] == null)
    {
      p = 1;
    }
    else if (i[1].equals("1"))
    {
      p = 1;
    }
    else if (i[1].equals("2"))
    {
      p = 3;
    }
    else if (i[1].equals("3"))
    {
      p = 2;
    }
    else if (i[1].equals("4"))
    {
      p = 2;
    }
    else if (i[1].equals("5"))
    {
      p = 1;
    }
    else if (i[1].equals("6"))
    {
      p = 1;
    }
    else if (i[1].equals("7"))
    {
      p = 1;
    }
    else if (i[1].equals("8"))
    {
      p = 1;
    }
    else if (i[1].equals("9"))
    {
      p = 3;
    }
    else if (i[1].equals("10"))
    {
      p = 3;
    }
    else if (i[1].equals("11"))
    {
      p = 1;
    }
    else if (i[1].equals("12"))
    {
      p = 2;
    }
    return p;
  }

  static double Nd89f9251(Object[] i)
  {
    double p = Double.NaN;
    if (i[9] == null)
    {
      p = 3;
    }
    else if (i[9].equals("1"))
    {
      p = 3;
    }
    else if (i[9].equals("2"))
    {
      p = 3;
    }
    else if (i[9].equals("3"))
    {
      p = 1;
    }
    else if (i[9].equals("4"))
    {
      p = 1;
    }
    else if (i[9].equals("5"))
    {
      p = 1;
    }
    else if (i[9].equals("6"))
    {
      p = 1;
    }
    else if (i[9].equals("7"))
    {
      p = 1;
    }
    else if (i[9].equals("8"))
    {
      p = 0;
    }
    else if (i[9].equals("9"))
    {
      p = 0;
    }
    else if (i[9].equals("10"))
    {
      p = 1;
    }
    else if (i[9].equals("11"))
    {
      p = WekaClassifier.N1d454bc52(i);
    }
    else if (i[9].equals("12"))
    {
      p = 3;
    }
    return p;
  }

  static double N1d454bc52(Object[] i)
  {
    double p = Double.NaN;
    if (i[7] == null)
    {
      p = 1;
    }
    else if (i[7].equals("1"))
    {
      p = 1;
    }
    else if (i[7].equals("2"))
    {
      p = 1;
    }
    else if (i[7].equals("3"))
    {
      p = 1;
    }
    else if (i[7].equals("4"))
    {
      p = 1;
    }
    else if (i[7].equals("5"))
    {
      p = 1;
    }
    else if (i[7].equals("6"))
    {
      p = 1;
    }
    else if (i[7].equals("7"))
    {
      p = 1;
    }
    else if (i[7].equals("8"))
    {
      p = 1;
    }
    else if (i[7].equals("9"))
    {
      p = 1;
    }
    else if (i[7].equals("10"))
    {
      p = 1;
    }
    else if (i[7].equals("11"))
    {
      p = 3;
    }
    else if (i[7].equals("12"))
    {
      p = WekaClassifier.N10708b553(i);
    }
    return p;
  }

  static double N10708b553(Object[] i)
  {
    double p = Double.NaN;
    if (i[0] == null)
    {
      p = 2;
    }
    else if (i[0].equals("1"))
    {
      p = 2;
    }
    else if (i[0].equals("2"))
    {
      p = 1;
    }
    else if (i[0].equals("3"))
    {
      p = 1;
    }
    else if (i[0].equals("4"))
    {
      p = 3;
    }
    else if (i[0].equals("5"))
    {
      p = 1;
    }
    else if (i[0].equals("6"))
    {
      p = 3;
    }
    else if (i[0].equals("7"))
    {
      p = 2;
    }
    else if (i[0].equals("8"))
    {
      p = 2;
    }
    else if (i[0].equals("9"))
    {
      p = 2;
    }
    else if (i[0].equals("10"))
    {
      p = 1;
    }
    else if (i[0].equals("11"))
    {
      p = 2;
    }
    else if (i[0].equals("12"))
    {
      p = 1;
    }
    return p;
  }

  static double Nccb40354(Object[] i)
  {
    double p = Double.NaN;
    if (i[9] == null)
    {
      p = 3;
    }
    else if (i[9].equals("1"))
    {
      p = 3;
    }
    else if (i[9].equals("2"))
    {
      p = 3;
    }
    else if (i[9].equals("3"))
    {
      p = 3;
    }
    else if (i[9].equals("4"))
    {
      p = 1;
    }
    else if (i[9].equals("5"))
    {
      p = 1;
    }
    else if (i[9].equals("6"))
    {
      p = 1;
    }
    else if (i[9].equals("7"))
    {
      p = 1;
    }
    else if (i[9].equals("8"))
    {
      p = 1;
    }
    else if (i[9].equals("9"))
    {
      p = 0;
    }
    else if (i[9].equals("10"))
    {
      p = WekaClassifier.N13e5c7355(i);
    }
    else if (i[9].equals("11"))
    {
      p = WekaClassifier.N1095f9558(i);
    }
    else if (i[9].equals("12"))
    {
      p = WekaClassifier.N1aefbc562(i);
    }
    return p;
  }

  static double N13e5c7355(Object[] i)
  {
    double p = Double.NaN;
    if (i[7] == null)
    {
      p = 0;
    }
    else if (i[7].equals("1"))
    {
      p = 0;
    }
    else if (i[7].equals("2"))
    {
      p = 0;
    }
    else if (i[7].equals("3"))
    {
      p = 0;
    }
    else if (i[7].equals("4"))
    {
      p = WekaClassifier.N127a89c56(i);
    }
    else if (i[7].equals("5"))
    {
      p = WekaClassifier.Naed0b957(i);
    }
    else if (i[7].equals("6"))
    {
      p = 0;
    }
    else if (i[7].equals("7"))
    {
      p = 0;
    }
    else if (i[7].equals("8"))
    {
      p = 0;
    }
    else if (i[7].equals("9"))
    {
      p = 0;
    }
    else if (i[7].equals("10"))
    {
      p = 0;
    }
    else if (i[7].equals("11"))
    {
      p = 0;
    }
    else if (i[7].equals("12"))
    {
      p = 0;
    }
    return p;
  }

  static double N127a89c56(Object[] i)
  {
    double p = Double.NaN;
    if (i[33] == null)
    {
      p = 0;
    }
    else if (i[33].equals("Conjunction"))
    {
      p = 0;
    }
    else if (i[33].equals("SextileTrine"))
    {
      p = 4;
    }
    else if (i[33].equals("SquareOpposition"))
    {
      p = 1;
    }
    return p;
  }

  static double Naed0b957(Object[] i)
  {
    double p = Double.NaN;
    if (i[2] == null)
    {
      p = 2;
    }
    else if (i[2].equals("1"))
    {
      p = 2;
    }
    else if (i[2].equals("2"))
    {
      p = 0;
    }
    else if (i[2].equals("3"))
    {
      p = 0;
    }
    else if (i[2].equals("4"))
    {
      p = 0;
    }
    else if (i[2].equals("5"))
    {
      p = 3;
    }
    else if (i[2].equals("6"))
    {
      p = 1;
    }
    else if (i[2].equals("7"))
    {
      p = 2;
    }
    else if (i[2].equals("8"))
    {
      p = 5;
    }
    else if (i[2].equals("9"))
    {
      p = 1;
    }
    else if (i[2].equals("10"))
    {
      p = 2;
    }
    else if (i[2].equals("11"))
    {
      p = 1;
    }
    else if (i[2].equals("12"))
    {
      p = 2;
    }
    return p;
  }

  static double N1095f9558(Object[] i)
  {
    double p = Double.NaN;
    if (i[7] == null)
    {
      p = 1;
    }
    else if (i[7].equals("1"))
    {
      p = 1;
    }
    else if (i[7].equals("2"))
    {
      p = 1;
    }
    else if (i[7].equals("3"))
    {
      p = 1;
    }
    else if (i[7].equals("4"))
    {
      p = WekaClassifier.N623e1759(i);
    }
    else if (i[7].equals("5"))
    {
      p = WekaClassifier.N9dd39961(i);
    }
    else if (i[7].equals("6"))
    {
      p = 2;
    }
    else if (i[7].equals("7"))
    {
      p = 1;
    }
    else if (i[7].equals("8"))
    {
      p = 1;
    }
    else if (i[7].equals("9"))
    {
      p = 1;
    }
    else if (i[7].equals("10"))
    {
      p = 1;
    }
    else if (i[7].equals("11"))
    {
      p = 1;
    }
    else if (i[7].equals("12"))
    {
      p = 2;
    }
    return p;
  }

  static double N623e1759(Object[] i)
  {
    double p = Double.NaN;
    if (i[0] == null)
    {
      p = 3;
    }
    else if (i[0].equals("1"))
    {
      p = WekaClassifier.N1da824260(i);
    }
    else if (i[0].equals("2"))
    {
      p = 1;
    }
    else if (i[0].equals("3"))
    {
      p = 1;
    }
    else if (i[0].equals("4"))
    {
      p = 0;
    }
    else if (i[0].equals("5"))
    {
      p = 1;
    }
    else if (i[0].equals("6"))
    {
      p = 1;
    }
    else if (i[0].equals("7"))
    {
      p = 2;
    }
    else if (i[0].equals("8"))
    {
      p = 2;
    }
    else if (i[0].equals("9"))
    {
      p = 2;
    }
    else if (i[0].equals("10"))
    {
      p = 1;
    }
    else if (i[0].equals("11"))
    {
      p = 2;
    }
    else if (i[0].equals("12"))
    {
      p = 1;
    }
    return p;
  }

  static double N1da824260(Object[] i)
  {
    double p = Double.NaN;
    if (i[2] == null)
    {
      p = 2;
    }
    else if (i[2].equals("1"))
    {
      p = 2;
    }
    else if (i[2].equals("2"))
    {
      p = 3;
    }
    else if (i[2].equals("3"))
    {
      p = 3;
    }
    else if (i[2].equals("4"))
    {
      p = 3;
    }
    else if (i[2].equals("5"))
    {
      p = 3;
    }
    else if (i[2].equals("6"))
    {
      p = 3;
    }
    else if (i[2].equals("7"))
    {
      p = 3;
    }
    else if (i[2].equals("8"))
    {
      p = 3;
    }
    else if (i[2].equals("9"))
    {
      p = 3;
    }
    else if (i[2].equals("10"))
    {
      p = 3;
    }
    else if (i[2].equals("11"))
    {
      p = 3;
    }
    else if (i[2].equals("12"))
    {
      p = 1;
    }
    return p;
  }

  static double N9dd39961(Object[] i)
  {
    double p = Double.NaN;
    if (i[2] == null)
    {
      p = 1;
    }
    else if (i[2].equals("1"))
    {
      p = 1;
    }
    else if (i[2].equals("2"))
    {
      p = 4;
    }
    else if (i[2].equals("3"))
    {
      p = 1;
    }
    else if (i[2].equals("4"))
    {
      p = 2;
    }
    else if (i[2].equals("5"))
    {
      p = 2;
    }
    else if (i[2].equals("6"))
    {
      p = 3;
    }
    else if (i[2].equals("7"))
    {
      p = 1;
    }
    else if (i[2].equals("8"))
    {
      p = 4;
    }
    else if (i[2].equals("9"))
    {
      p = 1;
    }
    else if (i[2].equals("10"))
    {
      p = 2;
    }
    else if (i[2].equals("11"))
    {
      p = 1;
    }
    else if (i[2].equals("12"))
    {
      p = 0;
    }
    return p;
  }

  static double N1aefbc562(Object[] i)
  {
    double p = Double.NaN;
    if (i[7] == null)
    {
      p = 2;
    }
    else if (i[7].equals("1"))
    {
      p = 2;
    }
    else if (i[7].equals("2"))
    {
      p = 2;
    }
    else if (i[7].equals("3"))
    {
      p = 1;
    }
    else if (i[7].equals("4"))
    {
      p = 1;
    }
    else if (i[7].equals("5"))
    {
      p = 3;
    }
    else if (i[7].equals("6"))
    {
      p = 1;
    }
    else if (i[7].equals("7"))
    {
      p = 1;
    }
    else if (i[7].equals("8"))
    {
      p = 1;
    }
    else if (i[7].equals("9"))
    {
      p = 1;
    }
    else if (i[7].equals("10"))
    {
      p = 1;
    }
    else if (i[7].equals("11"))
    {
      p = 3;
    }
    else if (i[7].equals("12"))
    {
      p = WekaClassifier.N1134ea863(i);
    }
    return p;
  }

  static double N1134ea863(Object[] i)
  {
    double p = Double.NaN;
    if (i[4] == null)
    {
      p = 2;
    }
    else if (i[4].equals("1"))
    {
      p = 2;
    }
    else if (i[4].equals("2"))
    {
      p = 1;
    }
    else if (i[4].equals("3"))
    {
      p = 2;
    }
    else if (i[4].equals("4"))
    {
      p = 3;
    }
    else if (i[4].equals("5"))
    {
      p = 3;
    }
    else if (i[4].equals("6"))
    {
      p = 1;
    }
    else if (i[4].equals("7"))
    {
      p = 2;
    }
    else if (i[4].equals("8"))
    {
      p = 1;
    }
    else if (i[4].equals("9"))
    {
      p = 1;
    }
    else if (i[4].equals("10"))
    {
      p = 3;
    }
    else if (i[4].equals("11"))
    {
      p = 3;
    }
    else if (i[4].equals("12"))
    {
      p = 3;
    }
    return p;
  }

  static double N91296264(Object[] i)
  {
    double p = Double.NaN;
    if (i[9] == null)
    {
      p = 3;
    }
    else if (i[9].equals("1"))
    {
      p = WekaClassifier.N33fef865(i);
    }
    else if (i[9].equals("2"))
    {
      p = 3;
    }
    else if (i[9].equals("3"))
    {
      p = 3;
    }
    else if (i[9].equals("4"))
    {
      p = 1;
    }
    else if (i[9].equals("5"))
    {
      p = 1;
    }
    else if (i[9].equals("6"))
    {
      p = 1;
    }
    else if (i[9].equals("7"))
    {
      p = 1;
    }
    else if (i[9].equals("8"))
    {
      p = 3;
    }
    else if (i[9].equals("9"))
    {
      p = 0;
    }
    else if (i[9].equals("10"))
    {
      p = 0;
    }
    else if (i[9].equals("11"))
    {
      p = WekaClassifier.N28d5bb67(i);
    }
    else if (i[9].equals("12"))
    {
      p = WekaClassifier.N1c4ac8670(i);
    }
    return p;
  }

  static double N33fef865(Object[] i)
  {
    double p = Double.NaN;
    if (i[7] == null)
    {
      p = 3;
    }
    else if (i[7].equals("1"))
    {
      p = 3;
    }
    else if (i[7].equals("2"))
    {
      p = WekaClassifier.N1a8541766(i);
    }
    else if (i[7].equals("3"))
    {
      p = 2;
    }
    else if (i[7].equals("4"))
    {
      p = 1;
    }
    else if (i[7].equals("5"))
    {
      p = 1;
    }
    else if (i[7].equals("6"))
    {
      p = 1;
    }
    else if (i[7].equals("7"))
    {
      p = 3;
    }
    else if (i[7].equals("8"))
    {
      p = 3;
    }
    else if (i[7].equals("9"))
    {
      p = 3;
    }
    else if (i[7].equals("10"))
    {
      p = 3;
    }
    else if (i[7].equals("11"))
    {
      p = 3;
    }
    else if (i[7].equals("12"))
    {
      p = 2;
    }
    return p;
  }

  static double N1a8541766(Object[] i)
  {
    double p = Double.NaN;
    if (i[6] == null)
    {
      p = 2;
    }
    else if (i[6].equals("1"))
    {
      p = 2;
    }
    else if (i[6].equals("2"))
    {
      p = 3;
    }
    else if (i[6].equals("3"))
    {
      p = 2;
    }
    else if (i[6].equals("4"))
    {
      p = 1;
    }
    else if (i[6].equals("5"))
    {
      p = 3;
    }
    else if (i[6].equals("6"))
    {
      p = 2;
    }
    else if (i[6].equals("7"))
    {
      p = 2;
    }
    else if (i[6].equals("8"))
    {
      p = 2;
    }
    else if (i[6].equals("9"))
    {
      p = 2;
    }
    else if (i[6].equals("10"))
    {
      p = 2;
    }
    else if (i[6].equals("11"))
    {
      p = 2;
    }
    else if (i[6].equals("12"))
    {
      p = 2;
    }
    return p;
  }

  static double N28d5bb67(Object[] i)
  {
    double p = Double.NaN;
    if (i[7] == null)
    {
      p = 0;
    }
    else if (i[7].equals("1"))
    {
      p = 0;
    }
    else if (i[7].equals("2"))
    {
      p = 0;
    }
    else if (i[7].equals("3"))
    {
      p = 0;
    }
    else if (i[7].equals("4"))
    {
      p = 0;
    }
    else if (i[7].equals("5"))
    {
      p = WekaClassifier.Ne7ffa968(i);
    }
    else if (i[7].equals("6"))
    {
      p = WekaClassifier.N141ef4969(i);
    }
    else if (i[7].equals("7"))
    {
      p = 0;
    }
    else if (i[7].equals("8"))
    {
      p = 0;
    }
    else if (i[7].equals("9"))
    {
      p = 0;
    }
    else if (i[7].equals("10"))
    {
      p = 0;
    }
    else if (i[7].equals("11"))
    {
      p = 0;
    }
    else if (i[7].equals("12"))
    {
      p = 0;
    }
    return p;
  }

  static double Ne7ffa968(Object[] i)
  {
    double p = Double.NaN;
    if (i[6] == null)
    {
      p = 2;
    }
    else if (i[6].equals("1"))
    {
      p = 2;
    }
    else if (i[6].equals("2"))
    {
      p = 2;
    }
    else if (i[6].equals("3"))
    {
      p = 2;
    }
    else if (i[6].equals("4"))
    {
      p = 2;
    }
    else if (i[6].equals("5"))
    {
      p = 2;
    }
    else if (i[6].equals("6"))
    {
      p = 5;
    }
    else if (i[6].equals("7"))
    {
      p = 3;
    }
    else if (i[6].equals("8"))
    {
      p = 1;
    }
    else if (i[6].equals("9"))
    {
      p = 0;
    }
    else if (i[6].equals("10"))
    {
      p = 2;
    }
    else if (i[6].equals("11"))
    {
      p = 2;
    }
    else if (i[6].equals("12"))
    {
      p = 2;
    }
    return p;
  }

  static double N141ef4969(Object[] i)
  {
    double p = Double.NaN;
    if (i[4] == null)
    {
      p = 0;
    }
    else if (i[4].equals("1"))
    {
      p = 0;
    }
    else if (i[4].equals("2"))
    {
      p = 2;
    }
    else if (i[4].equals("3"))
    {
      p = 2;
    }
    else if (i[4].equals("4"))
    {
      p = 3;
    }
    else if (i[4].equals("5"))
    {
      p = 1;
    }
    else if (i[4].equals("6"))
    {
      p = 1;
    }
    else if (i[4].equals("7"))
    {
      p = 1;
    }
    else if (i[4].equals("8"))
    {
      p = 0;
    }
    else if (i[4].equals("9"))
    {
      p = 0;
    }
    else if (i[4].equals("10"))
    {
      p = 1;
    }
    else if (i[4].equals("11"))
    {
      p = 2;
    }
    else if (i[4].equals("12"))
    {
      p = 1;
    }
    return p;
  }

  static double N1c4ac8670(Object[] i)
  {
    double p = Double.NaN;
    if (i[7] == null)
    {
      p = 1;
    }
    else if (i[7].equals("1"))
    {
      p = 1;
    }
    else if (i[7].equals("2"))
    {
      p = 2;
    }
    else if (i[7].equals("3"))
    {
      p = WekaClassifier.N11a9fa871(i);
    }
    else if (i[7].equals("4"))
    {
      p = 1;
    }
    else if (i[7].equals("5"))
    {
      p = 1;
    }
    else if (i[7].equals("6"))
    {
      p = WekaClassifier.Ne7d55072(i);
    }
    else if (i[7].equals("7"))
    {
      p = 2;
    }
    else if (i[7].equals("8"))
    {
      p = 0;
    }
    else if (i[7].equals("9"))
    {
      p = 1;
    }
    else if (i[7].equals("10"))
    {
      p = 1;
    }
    else if (i[7].equals("11"))
    {
      p = 1;
    }
    else if (i[7].equals("12"))
    {
      p = 3;
    }
    return p;
  }

  static double N11a9fa871(Object[] i)
  {
    double p = Double.NaN;
    if (i[6] == null)
    {
      p = 1;
    }
    else if (i[6].equals("1"))
    {
      p = 1;
    }
    else if (i[6].equals("2"))
    {
      p = 1;
    }
    else if (i[6].equals("3"))
    {
      p = 1;
    }
    else if (i[6].equals("4"))
    {
      p = 1;
    }
    else if (i[6].equals("5"))
    {
      p = 1;
    }
    else if (i[6].equals("6"))
    {
      p = 2;
    }
    else if (i[6].equals("7"))
    {
      p = 2;
    }
    else if (i[6].equals("8"))
    {
      p = 2;
    }
    else if (i[6].equals("9"))
    {
      p = 1;
    }
    else if (i[6].equals("10"))
    {
      p = 1;
    }
    else if (i[6].equals("11"))
    {
      p = 1;
    }
    else if (i[6].equals("12"))
    {
      p = 1;
    }
    return p;
  }

  static double Ne7d55072(Object[] i)
  {
    double p = Double.NaN;
    if (i[1] == null)
    {
      p = 0;
    }
    else if (i[1].equals("1"))
    {
      p = 0;
    }
    else if (i[1].equals("2"))
    {
      p = 5;
    }
    else if (i[1].equals("3"))
    {
      p = 5;
    }
    else if (i[1].equals("4"))
    {
      p = 5;
    }
    else if (i[1].equals("5"))
    {
      p = 1;
    }
    else if (i[1].equals("6"))
    {
      p = 2;
    }
    else if (i[1].equals("7"))
    {
      p = 2;
    }
    else if (i[1].equals("8"))
    {
      p = 0;
    }
    else if (i[1].equals("9"))
    {
      p = 5;
    }
    else if (i[1].equals("10"))
    {
      p = 2;
    }
    else if (i[1].equals("11"))
    {
      p = 5;
    }
    else if (i[1].equals("12"))
    {
      p = 1;
    }
    return p;
  }
}
