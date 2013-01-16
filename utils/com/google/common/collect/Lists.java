package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;

public final class Lists
{
  static int a(int paramInt)
  {
    if (paramInt >= 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      return Ints.b(5L + paramInt + paramInt / 10);
    }
  }

  public static <E> ArrayList<E> a()
  {
    return new ArrayList();
  }

  public static <E> ArrayList<E> a(Iterable<? extends E> paramIterable)
  {
    Preconditions.checkNotNull(paramIterable);
    if ((paramIterable instanceof Collection));
    for (ArrayList localArrayList = new ArrayList(Collections2.a(paramIterable)); ; localArrayList = a(paramIterable.iterator()))
      return localArrayList;
  }

  public static <E> ArrayList<E> a(Iterator<? extends E> paramIterator)
  {
    Preconditions.checkNotNull(paramIterator);
    ArrayList localArrayList = a();
    while (paramIterator.hasNext())
      localArrayList.add(paramIterator.next());
    return localArrayList;
  }

  public static <E> ArrayList<E> a(E[] paramArrayOfE)
  {
    Preconditions.checkNotNull(paramArrayOfE);
    ArrayList localArrayList = new ArrayList(a(paramArrayOfE.length));
    Collections.addAll(localArrayList, paramArrayOfE);
    return localArrayList;
  }

  public static <T> List<T> a(List<T> paramList)
  {
    Object localObject;
    if ((paramList instanceof Lists.ReverseList))
      localObject = ((Lists.ReverseList)paramList).a();
    while (true)
    {
      return localObject;
      if ((paramList instanceof RandomAccess))
        localObject = new Lists.RandomAccessReverseList(paramList);
      else
        localObject = new Lists.ReverseList(paramList);
    }
  }

  public static <F, T> List<T> a(List<F> paramList, Function<? super F, ? extends T> paramFunction)
  {
    if ((paramList instanceof RandomAccess));
    for (Object localObject = new Lists.TransformingRandomAccessList(paramList, paramFunction); ; localObject = new Lists.TransformingSequentialList(paramList, paramFunction))
      return localObject;
  }

  static boolean a(List<?> paramList, Object paramObject)
  {
    boolean bool = true;
    if (paramObject == Preconditions.checkNotNull(paramList));
    while (true)
    {
      return bool;
      if (!(paramObject instanceof List))
      {
        bool = false;
      }
      else
      {
        List localList = (List)paramObject;
        if ((paramList.size() != localList.size()) || (!Iterators.a(paramList.iterator(), localList.iterator())))
          bool = false;
      }
    }
  }

  static int b(List<?> paramList)
  {
    int i = 1;
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      int j = i * 31;
      if (localObject == null);
      for (int k = 0; ; k = localObject.hashCode())
      {
        i = k + j;
        break;
      }
    }
    return i;
  }

  public static <E> ArrayList<E> b(int paramInt)
  {
    if (paramInt >= 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      return new ArrayList(paramInt);
    }
  }

  public static <E> LinkedList<E> b()
  {
    return new LinkedList();
  }

  public static <E> ArrayList<E> c(int paramInt)
  {
    return new ArrayList(a(paramInt));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Lists
 * JD-Core Version:    0.6.2
 */