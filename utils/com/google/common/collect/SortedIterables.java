package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

final class SortedIterables
{
  public static <E> Collection<E> a(Comparator<? super E> paramComparator, Iterator<E> paramIterator)
  {
    TreeSet localTreeSet = Sets.a(paramComparator);
    Iterators.a(localTreeSet, paramIterator);
    return localTreeSet;
  }

  public static boolean a(Comparator<?> paramComparator, Iterable<?> paramIterable)
  {
    Preconditions.checkNotNull(paramComparator);
    Preconditions.checkNotNull(paramIterable);
    Object localObject;
    if ((paramIterable instanceof SortedSet))
    {
      localObject = ((SortedSet)paramIterable).comparator();
      if (localObject == null)
        localObject = Ordering.b();
    }
    while (true)
    {
      return paramComparator.equals(localObject);
      if ((paramIterable instanceof SortedIterable))
        localObject = ((SortedIterable)paramIterable).comparator();
      else
        localObject = null;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.SortedIterables
 * JD-Core Version:    0.6.2
 */