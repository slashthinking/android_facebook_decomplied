package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

final class SortedLists
{
  public static <E> int a(List<? extends E> paramList, E paramE, Comparator<? super E> paramComparator, SortedLists.KeyPresentBehavior paramKeyPresentBehavior, SortedLists.KeyAbsentBehavior paramKeyAbsentBehavior)
  {
    Preconditions.checkNotNull(paramComparator);
    Preconditions.checkNotNull(paramList);
    Preconditions.checkNotNull(paramKeyPresentBehavior);
    Preconditions.checkNotNull(paramKeyAbsentBehavior);
    if (!(paramList instanceof RandomAccess))
      paramList = Lists.a(paramList);
    int i = 0;
    int j = -1 + paramList.size();
    int m;
    while (true)
    {
      if (i > j)
        break label138;
      m = i + j >>> 1;
      int n = paramComparator.compare(paramE, paramList.get(m));
      if (n < 0)
      {
        j = m - 1;
      }
      else
      {
        if (n <= 0)
          break;
        i = m + 1;
      }
    }
    label138: for (int k = i + paramKeyPresentBehavior.resultIndex(paramComparator, paramE, paramList.subList(i, j + 1), m - i); ; k = paramKeyAbsentBehavior.resultIndex(i))
      return k;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.SortedLists
 * JD-Core Version:    0.6.2
 */