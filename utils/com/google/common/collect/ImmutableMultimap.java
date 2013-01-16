package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class ImmutableMultimap<K, V>
  implements Multimap<K, V>, Serializable
{
  private static final long serialVersionUID;
  private transient ImmutableCollection<Map.Entry<K, V>> a;
  final transient ImmutableMap<K, ? extends ImmutableCollection<V>> b;
  final transient int c;
  private transient ImmutableMultiset<K> d;
  private transient ImmutableCollection<V> e;

  ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> paramImmutableMap, int paramInt)
  {
    this.b = paramImmutableMap;
    this.c = paramInt;
  }

  private ImmutableMultiset<K> a()
  {
    ImmutableMultiset.Builder localBuilder = ImmutableMultiset.k();
    Iterator localIterator = this.b.a().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localBuilder.a(localEntry.getKey(), ((ImmutableCollection)localEntry.getValue()).size());
    }
    return localBuilder.b();
  }

  public static <K, V> ImmutableMultimap<K, V> b(Multimap<? extends K, ? extends V> paramMultimap)
  {
    Object localObject;
    if ((paramMultimap instanceof ImmutableMultimap))
    {
      localObject = (ImmutableMultimap)paramMultimap;
      if (((ImmutableMultimap)localObject).k());
    }
    while (true)
    {
      return localObject;
      localObject = ImmutableListMultimap.a(paramMultimap);
    }
  }

  public static <K, V> ImmutableMultimap<K, V> c()
  {
    return ImmutableListMultimap.a();
  }

  public static <K, V> ImmutableMultimap.Builder<K, V> j()
  {
    return new ImmutableMultimap.Builder();
  }

  public boolean a(K paramK, Iterable<? extends V> paramIterable)
  {
    throw new UnsupportedOperationException();
  }

  public boolean a(K paramK, V paramV)
  {
    throw new UnsupportedOperationException();
  }

  public boolean b(Object paramObject1, Object paramObject2)
  {
    Collection localCollection = (Collection)this.b.get(paramObject1);
    if ((localCollection != null) && (localCollection.contains(paramObject2)));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public abstract ImmutableCollection<V> c(K paramK);

  public boolean c(Object paramObject1, Object paramObject2)
  {
    throw new UnsupportedOperationException();
  }

  public int d()
  {
    return this.c;
  }

  public boolean d(Object paramObject)
  {
    return this.b.containsKey(paramObject);
  }

  public boolean e()
  {
    if (this.c == 0);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean equals(Object paramObject)
  {
    Multimap localMultimap;
    if ((paramObject instanceof Multimap))
      localMultimap = (Multimap)paramObject;
    for (boolean bool = this.b.equals(localMultimap.b()); ; bool = false)
      return bool;
  }

  public void f()
  {
    throw new UnsupportedOperationException();
  }

  public int hashCode()
  {
    return this.b.hashCode();
  }

  boolean k()
  {
    return this.b.d();
  }

  public ImmutableSet<K> l()
  {
    return this.b.b();
  }

  public ImmutableMap<K, Collection<V>> m()
  {
    return this.b;
  }

  public ImmutableCollection<Map.Entry<K, V>> n()
  {
    Object localObject = this.a;
    if (localObject == null)
    {
      localObject = new ImmutableMultimap.EntryCollection(this);
      this.a = ((ImmutableCollection)localObject);
    }
    return localObject;
  }

  public ImmutableMultiset<K> o()
  {
    ImmutableMultiset localImmutableMultiset = this.d;
    if (localImmutableMultiset == null)
    {
      localImmutableMultiset = a();
      this.d = localImmutableMultiset;
    }
    return localImmutableMultiset;
  }

  public ImmutableCollection<V> p()
  {
    Object localObject = this.e;
    if (localObject == null)
    {
      localObject = new ImmutableMultimap.Values(this);
      this.e = ((ImmutableCollection)localObject);
    }
    return localObject;
  }

  public String toString()
  {
    return this.b.toString();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableMultimap
 * JD-Core Version:    0.6.2
 */