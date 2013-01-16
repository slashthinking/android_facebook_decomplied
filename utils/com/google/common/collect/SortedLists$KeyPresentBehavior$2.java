package com.google.common.collect;

import java.util.Comparator;
import java.util.List;

 enum SortedLists$KeyPresentBehavior$2
{
  SortedLists$KeyPresentBehavior$2()
  {
    super(str, i, null);
  }

  <E> int resultIndex(Comparator<? super E> paramComparator, E paramE, List<? extends E> paramList, int paramInt)
  {
    int i = -1 + paramList.size();
    int j = paramInt;
    while (j < i)
    {
      int k = 1 + (j + i) >>> 1;
      if (paramComparator.compare(paramList.get(k), paramE) > 0)
        i = k - 1;
      else
        j = k;
    }
    return j;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.SortedLists.KeyPresentBehavior.2
 * JD-Core Version:    0.6.2
 */