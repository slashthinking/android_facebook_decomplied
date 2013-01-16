package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

abstract class AbstractMultimap<K, V>
  implements Multimap<K, V>, Serializable
{
  private static final long serialVersionUID = 2447537837011683357L;
  private transient Map<K, Collection<V>> a;
  private transient int b;
  private transient Set<K> c;
  private transient Multiset<K> d;
  private transient Collection<Map.Entry<K, V>> e;
  private transient Map<K, Collection<V>> f;

  protected AbstractMultimap(Map<K, Collection<V>> paramMap)
  {
    Preconditions.checkArgument(paramMap.isEmpty());
    this.a = paramMap;
  }

  private Collection<V> a(K paramK)
  {
    Collection localCollection = (Collection)this.a.get(paramK);
    if (localCollection == null)
    {
      localCollection = c(paramK);
      this.a.put(paramK, localCollection);
    }
    return localCollection;
  }

  private Collection<V> a(K paramK, Collection<V> paramCollection)
  {
    Object localObject;
    if ((paramCollection instanceof SortedSet))
      localObject = new AbstractMultimap.WrappedSortedSet(this, paramK, (SortedSet)paramCollection, null);
    while (true)
    {
      return localObject;
      if ((paramCollection instanceof Set))
        localObject = new AbstractMultimap.WrappedSet(this, paramK, (Set)paramCollection);
      else if ((paramCollection instanceof List))
        localObject = a(paramK, (List)paramCollection, null);
      else
        localObject = new AbstractMultimap.WrappedCollection(this, paramK, paramCollection, null);
    }
  }

  private Iterator<V> a(Collection<V> paramCollection)
  {
    if ((paramCollection instanceof List));
    for (Object localObject = ((List)paramCollection).listIterator(); ; localObject = paramCollection.iterator())
      return localObject;
  }

  private List<V> a(K paramK, List<V> paramList, AbstractMultimap<K, V>.WrappedCollection paramAbstractMultimap)
  {
    if ((paramList instanceof RandomAccess));
    for (Object localObject = new AbstractMultimap.RandomAccessWrappedList(this, paramK, paramList, paramAbstractMultimap); ; localObject = new AbstractMultimap.WrappedList(this, paramK, paramList, paramAbstractMultimap))
      return localObject;
  }

  private Set<K> a()
  {
    if ((this.a instanceof SortedMap));
    for (Object localObject = new AbstractMultimap.SortedKeySet(this, (SortedMap)this.a); ; localObject = new AbstractMultimap.KeySet(this, this.a))
      return localObject;
  }

  private int e(Object paramObject)
  {
    try
    {
      Collection localCollection = (Collection)this.a.remove(paramObject);
      int j = 0;
      if (localCollection != null)
      {
        j = localCollection.size();
        localCollection.clear();
        this.b -= j;
      }
      i = j;
      return i;
    }
    catch (ClassCastException localClassCastException)
    {
      while (true)
        i = 0;
    }
    catch (NullPointerException localNullPointerException)
    {
      while (true)
        int i = 0;
    }
  }

  private Map<K, Collection<V>> l()
  {
    if ((this.a instanceof SortedMap));
    for (Object localObject = new AbstractMultimap.SortedAsMap(this, (SortedMap)this.a); ; localObject = new AbstractMultimap.AsMap(this, this.a))
      return localObject;
  }

  final void a(Map<K, Collection<V>> paramMap)
  {
    this.a = paramMap;
    this.b = 0;
    Iterator localIterator = paramMap.values().iterator();
    if (localIterator.hasNext())
    {
      Collection localCollection = (Collection)localIterator.next();
      if (!localCollection.isEmpty());
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkArgument(bool);
        this.b += localCollection.size();
        break;
      }
    }
  }

  public boolean a(K paramK, Iterable<? extends V> paramIterable)
  {
    boolean bool1 = paramIterable.iterator().hasNext();
    boolean bool2 = false;
    if (!bool1)
      return bool2;
    Collection localCollection = a(paramK);
    int i = localCollection.size();
    if ((paramIterable instanceof Collection))
      bool2 = localCollection.addAll(Collections2.a(paramIterable));
    while (true)
    {
      this.b += localCollection.size() - i;
      break;
      Iterator localIterator = paramIterable.iterator();
      while (localIterator.hasNext())
        bool2 |= localCollection.add(localIterator.next());
    }
  }

  public boolean a(K paramK, V paramV)
  {
    if (a(paramK).add(paramV))
      this.b = (1 + this.b);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public Collection<V> b(K paramK)
  {
    Collection localCollection = (Collection)this.a.get(paramK);
    if (localCollection == null)
      localCollection = c(paramK);
    return a(paramK, localCollection);
  }

  public Map<K, Collection<V>> b()
  {
    Map localMap = this.f;
    if (localMap == null)
    {
      localMap = l();
      this.f = localMap;
    }
    return localMap;
  }

  public boolean b(Object paramObject1, Object paramObject2)
  {
    Collection localCollection = (Collection)this.a.get(paramObject1);
    if ((localCollection != null) && (localCollection.contains(paramObject2)));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  abstract Collection<V> c();

  Collection<V> c(K paramK)
  {
    return c();
  }

  public boolean c(Object paramObject1, Object paramObject2)
  {
    Collection localCollection = (Collection)this.a.get(paramObject1);
    if (localCollection == null);
    boolean bool1;
    for (boolean bool2 = false; ; bool2 = bool1)
    {
      return bool2;
      bool1 = localCollection.remove(paramObject2);
      if (bool1)
      {
        this.b = (-1 + this.b);
        if (localCollection.isEmpty())
          this.a.remove(paramObject1);
      }
    }
  }

  public int d()
  {
    return this.b;
  }

  public boolean d(Object paramObject)
  {
    return this.a.containsKey(paramObject);
  }

  public boolean e()
  {
    if (this.b == 0);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (paramObject == this)
      bool = true;
    while (true)
    {
      return bool;
      if ((paramObject instanceof Multimap))
      {
        Multimap localMultimap = (Multimap)paramObject;
        bool = this.a.equals(localMultimap.b());
      }
      else
      {
        bool = false;
      }
    }
  }

  public void f()
  {
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext())
      ((Collection)localIterator.next()).clear();
    this.a.clear();
    this.b = 0;
  }

  public Set<K> g()
  {
    Set localSet = this.c;
    if (localSet == null)
    {
      localSet = a();
      this.c = localSet;
    }
    return localSet;
  }

  public Multiset<K> h()
  {
    Object localObject = this.d;
    if (localObject == null)
    {
      localObject = new AbstractMultimap.1(this);
      this.d = ((Multiset)localObject);
    }
    return localObject;
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }

  public Collection<Map.Entry<K, V>> i()
  {
    Collection localCollection = this.e;
    if (localCollection == null)
    {
      localCollection = j();
      this.e = localCollection;
    }
    return localCollection;
  }

  Collection<Map.Entry<K, V>> j()
  {
    if ((this instanceof SetMultimap));
    for (Object localObject = new AbstractMultimap.3(this); ; localObject = new AbstractMultimap.4(this))
      return localObject;
  }

  Iterator<Map.Entry<K, V>> k()
  {
    return new AbstractMultimap.EntryIterator(this);
  }

  public String toString()
  {
    return this.a.toString();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractMultimap
 * JD-Core Version:    0.6.2
 */