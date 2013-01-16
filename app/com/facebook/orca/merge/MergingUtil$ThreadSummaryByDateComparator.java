package com.facebook.orca.merge;

import com.facebook.orca.threads.ThreadSummary;
import java.util.Comparator;

public class MergingUtil$ThreadSummaryByDateComparator
  implements Comparator<ThreadSummary>
{
  public int a(ThreadSummary paramThreadSummary1, ThreadSummary paramThreadSummary2)
  {
    int i;
    if (paramThreadSummary1.k() > paramThreadSummary2.k())
      i = -1;
    while (true)
    {
      return i;
      if (paramThreadSummary2.k() > paramThreadSummary1.k())
      {
        i = 1;
        continue;
      }
      i = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.merge.MergingUtil.ThreadSummaryByDateComparator
 * JD-Core Version:    0.6.0
 */