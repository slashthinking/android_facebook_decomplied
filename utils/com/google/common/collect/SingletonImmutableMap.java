package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class SingletonImmutableMap<K, V> extends ImmutableMap<K, V>
{
  final transient K a;
  final transient V b;
  private transient Map.Entry<K, V> c;
  private transient ImmutableSet<Map.Entry<K, V>> d;
  private transient ImmutableSet<K> e;
  private transient ImmutableCollection<V> f;

  SingletonImmutableMap(K paramK, V paramV)
  {
    this.a = paramK;
    this.b = paramV;
  }

  SingletonImmutableMap(Map.Entry<K, V> paramEntry)
  {
    this.c = paramEntry;
    this.a = paramEntry.getKey();
    this.b = paramEntry.getValue();
  }

  private Map.Entry<K, V> e()
  {
    Map.Entry localEntry = this.c;
    if (localEntry == null)
    {
      localEntry = Maps.a(this.a, this.b);
      this.c = localEntry;
    }
    return localEntry;
  }

  public ImmutableSet<Map.Entry<K, V>> a()
  {
    ImmutableSet localImmutableSet = this.d;
    if (localImmutableSet == null)
    {
      localImmutableSet = ImmutableSet.b(e());
      this.d = localImmutableSet;
    }
    return localImmutableSet;
  }

  public ImmutableSet<K> b()
  {
    ImmutableSet localImmutableSet = this.e;
    if (localImmutableSet == null)
    {
      localImmutableSet = ImmutableSet.b(this.a);
      this.e = localImmutableSet;
    }
    return localImmutableSet;
  }

  public ImmutableCollection<V> c()
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      localObject = new SingletonImmutableMap.Values(this.b);
      this.f = ((ImmutableCollection)localObject);
    }
    return localObject;
  }

  public boolean containsKey(Object paramObject)
  {
    return this.a.equals(paramObject);
  }

  public boolean containsValue(Object paramObject)
  {
    return this.b.equals(paramObject);
  }

  boolean d()
  {
    return false;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool2;
    if (paramObject == this)
      bool2 = true;
    Map localMap;
    int i;
    do
    {
      boolean bool1;
      do
      {
        return bool2;
        bool1 = paramObject instanceof Map;
        bool2 = false;
      }
      while (!bool1);
      localMap = (Map)paramObject;
      i = localMap.size();
      bool2 = false;
    }
    while (i != 1);
    Map.Entry localEntry = (Map.Entry)localMap.entrySet().iterator().next();
    if ((this.a.equals(localEntry.getKey())) && (this.b.equals(localEntry.getValue())));
    for (boolean bool3 = true; ; bool3 = false)
    {
      bool2 = bool3;
      break;
    }
  }

  public V get(Object paramObject)
  {
    if (this.a.equals(paramObject));
    for (Object localObject = this.b; ; localObject = null)
      return localObject;
  }

  public int hashCode()
  {
    return this.a.hashCode() ^ this.b.hashCode();
  }

  public boolean isEmpty()
  {
    return false;
  }

  public int size()
  {
    return 1;
  }

  public String toString()
  {
    return '{' + this.a.toString() + '=' + this.b.toString() + '}';
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.SingletonImmutableMap
 * JD-Core Version:    0.6.2
 */