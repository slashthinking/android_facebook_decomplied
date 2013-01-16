package com.facebook.orca.merge;

import com.google.common.collect.PeekingIterator;
import java.util.Comparator;

final class MergingUtil$1
  implements Comparator<PeekingIterator<T>>
{
  public int a(PeekingIterator<T> paramPeekingIterator1, PeekingIterator<T> paramPeekingIterator2)
  {
    int i;
    if ((!paramPeekingIterator1.hasNext()) && (!paramPeekingIterator2.hasNext()))
      i = 0;
    while (true)
    {
      return i;
      if (!paramPeekingIterator1.hasNext())
      {
        i = 1;
        continue;
      }
      if (!paramPeekingIterator2.hasNext())
      {
        i = -1;
        continue;
      }
      i = this.a.compare(paramPeekingIterator1.a(), paramPeekingIterator2.a());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.merge.MergingUtil.1
 * JD-Core Version:    0.6.0
 */