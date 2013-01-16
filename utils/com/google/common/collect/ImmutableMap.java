package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class ImmutableMap<K, V>
  implements Serializable, Map<K, V>
{
  public static <K, V> ImmutableMap<K, V> a(K paramK, V paramV)
  {
    return new SingletonImmutableMap(Preconditions.checkNotNull(paramK), Preconditions.checkNotNull(paramV));
  }

  public static <K, V> ImmutableMap<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2)
  {
    Map.Entry[] arrayOfEntry = new Map.Entry[2];
    arrayOfEntry[0] = b(paramK1, paramV1);
    arrayOfEntry[1] = b(paramK2, paramV2);
    return new RegularImmutableMap(arrayOfEntry);
  }

  public static <K, V> ImmutableMap<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    Map.Entry[] arrayOfEntry = new Map.Entry[3];
    arrayOfEntry[0] = b(paramK1, paramV1);
    arrayOfEntry[1] = b(paramK2, paramV2);
    arrayOfEntry[2] = b(paramK3, paramV3);
    return new RegularImmutableMap(arrayOfEntry);
  }

  public static <K, V> ImmutableMap<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4)
  {
    Map.Entry[] arrayOfEntry = new Map.Entry[4];
    arrayOfEntry[0] = b(paramK1, paramV1);
    arrayOfEntry[1] = b(paramK2, paramV2);
    arrayOfEntry[2] = b(paramK3, paramV3);
    arrayOfEntry[3] = b(paramK4, paramV4);
    return new RegularImmutableMap(arrayOfEntry);
  }

  public static <K, V> ImmutableMap<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5)
  {
    Map.Entry[] arrayOfEntry = new Map.Entry[5];
    arrayOfEntry[0] = b(paramK1, paramV1);
    arrayOfEntry[1] = b(paramK2, paramV2);
    arrayOfEntry[2] = b(paramK3, paramV3);
    arrayOfEntry[3] = b(paramK4, paramV4);
    arrayOfEntry[4] = b(paramK5, paramV5);
    return new RegularImmutableMap(arrayOfEntry);
  }

  public static <K, V> ImmutableMap<K, V> a(Map<? extends K, ? extends V> paramMap)
  {
    Object localObject;
    if (((paramMap instanceof ImmutableMap)) && (!(paramMap instanceof ImmutableSortedMap)))
    {
      localObject = (ImmutableMap)paramMap;
      if (((ImmutableMap)localObject).d());
    }
    while (true)
    {
      return localObject;
      Map.Entry[] arrayOfEntry = (Map.Entry[])paramMap.entrySet().toArray(new Map.Entry[0]);
      int i = arrayOfEntry.length;
      int j = 0;
      switch (i)
      {
      default:
      case 0:
      case 1:
      }
      while (true)
        if (j < arrayOfEntry.length)
        {
          arrayOfEntry[j] = b(arrayOfEntry[j].getKey(), arrayOfEntry[j].getValue());
          j++;
          continue;
          localObject = j();
          break;
          localObject = new SingletonImmutableMap(b(arrayOfEntry[0].getKey(), arrayOfEntry[0].getValue()));
          break;
        }
      localObject = new RegularImmutableMap(arrayOfEntry);
    }
  }

  static <K, V> Map.Entry<K, V> b(K paramK, V paramV)
  {
    return Maps.a(Preconditions.checkNotNull(paramK, "null key"), Preconditions.checkNotNull(paramV, "null value"));
  }

  public static <K, V> ImmutableMap<K, V> j()
  {
    return EmptyImmutableMap.a;
  }

  public static <K, V> ImmutableMap.Builder<K, V> k()
  {
    return new ImmutableMap.Builder();
  }

  public abstract ImmutableSet<Map.Entry<K, V>> a();

  public abstract ImmutableSet<K> b();

  public abstract ImmutableCollection<V> c();

  public final void clear()
  {
    throw new UnsupportedOperationException();
  }

  public boolean containsKey(Object paramObject)
  {
    if (get(paramObject) != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  abstract boolean d();

  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (paramObject == this)
      bool = true;
    while (true)
    {
      return bool;
      if ((paramObject instanceof Map))
      {
        Map localMap = (Map)paramObject;
        bool = a().equals(localMap.entrySet());
      }
      else
      {
        bool = false;
      }
    }
  }

  public abstract V get(Object paramObject);

  public int hashCode()
  {
    return a().hashCode();
  }

  public boolean isEmpty()
  {
    if (size() == 0);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public final V put(K paramK, V paramV)
  {
    throw new UnsupportedOperationException();
  }

  public final void putAll(Map<? extends K, ? extends V> paramMap)
  {
    throw new UnsupportedOperationException();
  }

  public final V remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }

  public String toString()
  {
    return Maps.b(this);
  }

  Object writeReplace()
  {
    return new ImmutableMap.SerializedForm(this);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableMap
 * JD-Core Version:    0.6.2
 */