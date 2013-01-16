package com.google.common.collect;

import java.util.Comparator;
import java.util.List;

 enum SortedLists$KeyPresentBehavior$3
{
  SortedLists$KeyPresentBehavior$3()
  {
    super(str, i, null);
  }

  <E> int resultIndex(Comparator<? super E> paramComparator, E paramE, List<? extends E> paramList, int paramInt)
  {
    int i = 0;
    int j = paramInt;
    if (i < j)
    {
      int k = i + j >>> 1;
      if (paramComparator.compare(paramList.get(k), paramE) < 0);
      for (int m = k + 1; ; m = i)
      {
        i = m;
        break;
        j = k;
      }
    }
    return i;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.SortedLists.KeyPresentBehavior.3
 * JD-Core Version:    0.6.2
 */