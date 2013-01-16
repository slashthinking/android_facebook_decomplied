package com.google.common.collect;

import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedSet;

final class Synchronized
{
  static <K, V> Multimap<K, V> a(Multimap<K, V> paramMultimap, Object paramObject)
  {
    if (((paramMultimap instanceof Synchronized.SynchronizedMultimap)) || ((paramMultimap instanceof ImmutableMultimap)));
    while (true)
    {
      return paramMultimap;
      paramMultimap = new Synchronized.SynchronizedMultimap(paramMultimap, paramObject);
    }
  }

  static <E> Multiset<E> a(Multiset<E> paramMultiset, Object paramObject)
  {
    if (((paramMultiset instanceof Synchronized.SynchronizedMultiset)) || ((paramMultiset instanceof ImmutableMultiset)));
    while (true)
    {
      return paramMultiset;
      paramMultiset = new Synchronized.SynchronizedMultiset(paramMultiset, paramObject);
    }
  }

  static <E> Set<E> a(Set<E> paramSet, Object paramObject)
  {
    return new Synchronized.SynchronizedSet(paramSet, paramObject);
  }

  private static <E> List<E> b(List<E> paramList, Object paramObject)
  {
    if ((paramList instanceof RandomAccess));
    for (Object localObject = new Synchronized.SynchronizedRandomAccessList(paramList, paramObject); ; localObject = new Synchronized.SynchronizedList(paramList, paramObject))
      return localObject;
  }

  private static <E> SortedSet<E> b(SortedSet<E> paramSortedSet, Object paramObject)
  {
    return new Synchronized.SynchronizedSortedSet(paramSortedSet, paramObject);
  }

  private static <E> Collection<E> c(Collection<E> paramCollection, Object paramObject)
  {
    return new Synchronized.SynchronizedCollection(paramCollection, paramObject, null);
  }

  private static <E> Set<E> c(Set<E> paramSet, Object paramObject)
  {
    if ((paramSet instanceof SortedSet));
    for (Object localObject = b((SortedSet)paramSet, paramObject); ; localObject = a(paramSet, paramObject))
      return localObject;
  }

  private static <E> Collection<E> d(Collection<E> paramCollection, Object paramObject)
  {
    Object localObject;
    if ((paramCollection instanceof SortedSet))
      localObject = b((SortedSet)paramCollection, paramObject);
    while (true)
    {
      return localObject;
      if ((paramCollection instanceof Set))
        localObject = a((Set)paramCollection, paramObject);
      else if ((paramCollection instanceof List))
        localObject = b((List)paramCollection, paramObject);
      else
        localObject = c(paramCollection, paramObject);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Synchronized
 * JD-Core Version:    0.6.2
 */