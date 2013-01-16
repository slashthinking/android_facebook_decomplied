package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public final class Sets
{
  static int a(Set<?> paramSet)
  {
    Iterator localIterator = paramSet.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (localObject != null);
      for (int j = localObject.hashCode(); ; j = 0)
      {
        i += j;
        break;
      }
    }
    return i;
  }

  public static <E> Sets.SetView<E> a(Set<E> paramSet, Set<?> paramSet1)
  {
    Preconditions.checkNotNull(paramSet, "set1");
    Preconditions.checkNotNull(paramSet1, "set2");
    return new Sets.3(paramSet, Predicates.not(Predicates.in(paramSet1)), paramSet1);
  }

  public static <E> HashSet<E> a()
  {
    return new HashSet();
  }

  public static <E> HashSet<E> a(int paramInt)
  {
    return new HashSet(Maps.b(paramInt));
  }

  public static <E> HashSet<E> a(Iterable<? extends E> paramIterable)
  {
    if ((paramIterable instanceof Collection));
    for (HashSet localHashSet = new HashSet(Collections2.a(paramIterable)); ; localHashSet = a(paramIterable.iterator()))
      return localHashSet;
  }

  public static <E> HashSet<E> a(Iterator<? extends E> paramIterator)
  {
    HashSet localHashSet = a();
    while (paramIterator.hasNext())
      localHashSet.add(paramIterator.next());
    return localHashSet;
  }

  public static <E> HashSet<E> a(E[] paramArrayOfE)
  {
    HashSet localHashSet = a(paramArrayOfE.length);
    Collections.addAll(localHashSet, paramArrayOfE);
    return localHashSet;
  }

  public static <E> Set<E> a(Map<E, Boolean> paramMap)
  {
    return new Sets.SetFromMap(paramMap);
  }

  public static <E> TreeSet<E> a(Comparator<? super E> paramComparator)
  {
    return new TreeSet((Comparator)Preconditions.checkNotNull(paramComparator));
  }

  static boolean a(Set<?> paramSet, Object paramObject)
  {
    boolean bool1 = true;
    boolean bool3;
    if (paramSet == paramObject)
      bool3 = bool1;
    while (true)
    {
      return bool3;
      boolean bool2 = paramObject instanceof Set;
      bool3 = false;
      if (bool2)
      {
        Set localSet = (Set)paramObject;
        try
        {
          if (paramSet.size() == localSet.size())
          {
            boolean bool4 = paramSet.containsAll(localSet);
            if (!bool4);
          }
          while (true)
          {
            bool3 = bool1;
            break;
            bool1 = false;
          }
        }
        catch (ClassCastException localClassCastException)
        {
          bool3 = false;
        }
        catch (NullPointerException localNullPointerException)
        {
          bool3 = false;
        }
      }
    }
  }

  public static <E> LinkedHashSet<E> b()
  {
    return new LinkedHashSet();
  }

  public static <E extends Comparable> TreeSet<E> b(Iterable<? extends E> paramIterable)
  {
    TreeSet localTreeSet = c();
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
      localTreeSet.add((Comparable)localIterator.next());
    return localTreeSet;
  }

  public static <E extends Comparable> TreeSet<E> c()
  {
    return new TreeSet();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Sets
 * JD-Core Version:    0.6.2
 */