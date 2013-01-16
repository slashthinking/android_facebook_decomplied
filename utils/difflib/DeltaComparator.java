package difflib;

import java.io.Serializable;
import java.util.Comparator;

public class DeltaComparator
  implements Serializable, Comparator<Delta>
{
  public static final Comparator<Delta> a = new DeltaComparator();
  private static final long serialVersionUID = 1L;

  public int a(Delta paramDelta1, Delta paramDelta2)
  {
    int i = paramDelta1.a().a();
    int j = paramDelta2.a().a();
    int k;
    if (i > j)
      k = 1;
    while (true)
    {
      return k;
      if (i < j)
        k = -1;
      else
        k = 0;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     difflib.DeltaComparator
 * JD-Core Version:    0.6.2
 */