package com.google.common.collect;

import java.util.Map.Entry;

public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V>
  implements BiMap<K, V>
{
  private static final ImmutableBiMap<Object, Object> a = new ImmutableBiMap.EmptyBiMap();

  public static <K, V> ImmutableBiMap<K, V> e()
  {
    return a;
  }

  public ImmutableSet<Map.Entry<K, V>> a()
  {
    return f().a();
  }

  public ImmutableSet<K> b()
  {
    return f().b();
  }

  public boolean containsKey(Object paramObject)
  {
    return f().containsKey(paramObject);
  }

  public boolean containsValue(Object paramObject)
  {
    return g().containsKey(paramObject);
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject == this) || (f().equals(paramObject)));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  abstract ImmutableMap<K, V> f();

  public abstract ImmutableBiMap<V, K> g();

  public V get(Object paramObject)
  {
    return f().get(paramObject);
  }

  public ImmutableSet<V> h()
  {
    return g().b();
  }

  public int hashCode()
  {
    return f().hashCode();
  }

  public boolean isEmpty()
  {
    return f().isEmpty();
  }

  public int size()
  {
    return f().size();
  }

  public String toString()
  {
    return f().toString();
  }

  Object writeReplace()
  {
    return new ImmutableBiMap.SerializedForm(this);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableBiMap
 * JD-Core Version:    0.6.2
 */