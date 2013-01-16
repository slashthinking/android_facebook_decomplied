package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.Equivalences;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Joiner.MapJoiner;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;

public final class Maps
{
  static final Joiner.MapJoiner a = Collections2.a.withKeyValueSeparator("=");

  public static <K, V> ImmutableMap<K, V> a(Iterable<V> paramIterable, Function<? super V, K> paramFunction)
  {
    return a(paramIterable.iterator(), paramFunction);
  }

  public static <K, V> ImmutableMap<K, V> a(Iterator<V> paramIterator, Function<? super V, K> paramFunction)
  {
    Preconditions.checkNotNull(paramFunction);
    ImmutableMap.Builder localBuilder = ImmutableMap.k();
    while (paramIterator.hasNext())
    {
      Object localObject = paramIterator.next();
      localBuilder.b(paramFunction.apply(localObject), localObject);
    }
    return localBuilder.b();
  }

  public static <K, V> MapDifference<K, V> a(Map<? extends K, ? extends V> paramMap1, Map<? extends K, ? extends V> paramMap2)
  {
    return a(paramMap1, paramMap2, Equivalences.equals());
  }

  public static <K, V> MapDifference<K, V> a(Map<? extends K, ? extends V> paramMap1, Map<? extends K, ? extends V> paramMap2, Equivalence<? super V> paramEquivalence)
  {
    boolean bool1 = true;
    Preconditions.checkNotNull(paramEquivalence);
    HashMap localHashMap1 = a();
    HashMap localHashMap2 = new HashMap(paramMap2);
    HashMap localHashMap3 = a();
    HashMap localHashMap4 = a();
    Iterator localIterator = paramMap1.entrySet().iterator();
    boolean bool2 = bool1;
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject1 = localEntry.getKey();
      Object localObject2 = localEntry.getValue();
      Object localObject3;
      if (paramMap2.containsKey(localObject1))
      {
        localObject3 = localHashMap2.remove(localObject1);
        if (paramEquivalence.equivalent(localObject2, localObject3))
          localHashMap3.put(localObject1, localObject2);
      }
      label133: for (boolean bool3 = bool2; ; bool3 = false)
      {
        bool2 = bool3;
        break;
        localHashMap4.put(localObject1, Maps.ValueDifferenceImpl.a(localObject2, localObject3));
        bool2 = false;
        break label133;
        localHashMap1.put(localObject1, localObject2);
      }
    }
    if ((bool2) && (localHashMap2.isEmpty()));
    while (true)
    {
      return a(bool1, localHashMap1, localHashMap2, localHashMap3, localHashMap4);
      bool1 = false;
    }
  }

  private static <K, V> MapDifference<K, V> a(boolean paramBoolean, Map<K, V> paramMap1, Map<K, V> paramMap2, Map<K, V> paramMap3, Map<K, MapDifference.ValueDifference<V>> paramMap)
  {
    return new Maps.MapDifferenceImpl(paramBoolean, Collections.unmodifiableMap(paramMap1), Collections.unmodifiableMap(paramMap2), Collections.unmodifiableMap(paramMap3), Collections.unmodifiableMap(paramMap));
  }

  static <V> V a(Map<?, V> paramMap, Object paramObject)
  {
    try
    {
      Object localObject2 = paramMap.get(paramObject);
      localObject1 = localObject2;
      return localObject1;
    }
    catch (ClassCastException localClassCastException)
    {
      while (true)
        Object localObject1 = null;
    }
  }

  public static <K, V> HashMap<K, V> a()
  {
    return new HashMap();
  }

  public static <K, V> HashMap<K, V> a(int paramInt)
  {
    return new HashMap(b(paramInt));
  }

  public static <K, V> HashMap<K, V> a(Map<? extends K, ? extends V> paramMap)
  {
    return new HashMap(paramMap);
  }

  public static <K, V> Map.Entry<K, V> a(K paramK, V paramV)
  {
    return new ImmutableEntry(paramK, paramV);
  }

  static <K, V> Map.Entry<K, V> a(Map.Entry<K, V> paramEntry)
  {
    Preconditions.checkNotNull(paramEntry);
    return new Maps.1(paramEntry);
  }

  public static <K, V> TreeMap<K, V> a(SortedMap<K, ? extends V> paramSortedMap)
  {
    return new TreeMap(paramSortedMap);
  }

  static <K, V> boolean a(Collection<Map.Entry<K, V>> paramCollection, Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry));
    for (boolean bool = false; ; bool = paramCollection.contains(a((Map.Entry)paramObject)))
      return bool;
  }

  static int b(int paramInt)
  {
    boolean bool;
    int i;
    if (paramInt < 3)
      if (paramInt >= 0)
      {
        bool = true;
        Preconditions.checkArgument(bool);
        i = paramInt + 1;
      }
    while (true)
    {
      return i;
      bool = false;
      break;
      if (paramInt < 1073741824)
        i = paramInt + paramInt / 3;
      else
        i = 2147483647;
    }
  }

  static String b(Map<?, ?> paramMap)
  {
    StringBuilder localStringBuilder = Collections2.a(paramMap.size()).append('{');
    a.appendTo(localStringBuilder, paramMap);
    return '}';
  }

  public static <K, V> LinkedHashMap<K, V> b()
  {
    return new LinkedHashMap();
  }

  static <K, V> boolean b(Collection<Map.Entry<K, V>> paramCollection, Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry));
    for (boolean bool = false; ; bool = paramCollection.remove(a((Map.Entry)paramObject)))
      return bool;
  }

  static boolean b(Map<?, ?> paramMap, Object paramObject)
  {
    try
    {
      boolean bool2 = paramMap.containsKey(paramObject);
      bool1 = bool2;
      return bool1;
    }
    catch (ClassCastException localClassCastException)
    {
      while (true)
        boolean bool1 = false;
    }
  }

  public static <K, V> ConcurrentMap<K, V> c()
  {
    return new MapMaker().n();
  }

  public static <K extends Comparable, V> TreeMap<K, V> d()
  {
    return new TreeMap();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Maps
 * JD-Core Version:    0.6.2
 */