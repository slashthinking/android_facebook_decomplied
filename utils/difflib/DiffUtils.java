package difflib;

import difflib.myers.MyersDiff;
import java.util.List;
import java.util.regex.Pattern;

public class DiffUtils
{
  private static DiffAlgorithm a = new MyersDiff();
  private static Pattern b = Pattern.compile("^@@\\s+-(?:(\\d+)(?:,(\\d+))?)\\s+\\+(?:(\\d+)(?:,(\\d+))?)\\s+@@$");

  public static Patch a(List<?> paramList1, List<?> paramList2)
  {
    return a(paramList1, paramList2, a);
  }

  public static Patch a(List<?> paramList1, List<?> paramList2, DiffAlgorithm paramDiffAlgorithm)
  {
    return paramDiffAlgorithm.a(paramList1, paramList2);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     difflib.DiffUtils
 * JD-Core Version:    0.6.2
 */