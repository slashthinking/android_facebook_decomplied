package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.SortedMap;

public class ImmutableSortedMap<K, V> extends ImmutableSortedMapFauxverideShim<K, V>
  implements SortedMap<K, V>
{
  private static final Comparator<Comparable> b = Ordering.b();
  private static final ImmutableSortedMap<Comparable, Object> c = new ImmutableSortedMap(ImmutableList.d(), b);
  private static final long serialVersionUID;
  final transient ImmutableList<Map.Entry<K, V>> a;
  private final transient Comparator<? super K> d;
  private transient ImmutableSet<Map.Entry<K, V>> e;
  private transient ImmutableSortedSet<K> f;
  private transient ImmutableCollection<V> g;

  ImmutableSortedMap(ImmutableList<Map.Entry<K, V>> paramImmutableList, Comparator<? super K> paramComparator)
  {
    this.a = paramImmutableList;
    this.d = paramComparator;
  }

  private int a(Object paramObject, SortedLists.KeyPresentBehavior paramKeyPresentBehavior, SortedLists.KeyAbsentBehavior paramKeyAbsentBehavior)
  {
    return SortedLists.a(l(), Preconditions.checkNotNull(paramObject), e(), paramKeyPresentBehavior, paramKeyAbsentBehavior);
  }

  private ImmutableSortedMap<K, V> a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2);
    for (ImmutableSortedMap localImmutableSortedMap = new ImmutableSortedMap(this.a.a(paramInt1, paramInt2), this.d); ; localImmutableSortedMap = a(this.d))
      return localImmutableSortedMap;
  }

  private static <K, V> ImmutableSortedMap<K, V> a(Comparator<? super K> paramComparator)
  {
    if (b.equals(paramComparator));
    for (ImmutableSortedMap localImmutableSortedMap = c; ; localImmutableSortedMap = new ImmutableSortedMap(ImmutableList.d(), paramComparator))
      return localImmutableSortedMap;
  }

  private static <K, V> void c(List<Map.Entry<K, V>> paramList, Comparator<? super K> paramComparator)
  {
    Collections.sort(paramList, new ImmutableSortedMap.1(paramComparator));
  }

  private static <K, V> void d(List<Map.Entry<K, V>> paramList, Comparator<? super K> paramComparator)
  {
    for (int i = 1; i < paramList.size(); i++)
      if (paramComparator.compare(((Map.Entry)paramList.get(i - 1)).getKey(), ((Map.Entry)paramList.get(i)).getKey()) == 0)
        throw new IllegalArgumentException("Duplicate keys in mappings " + paramList.get(i - 1) + " and " + paramList.get(i));
  }

  private ImmutableSet<Map.Entry<K, V>> h()
  {
    if (isEmpty());
    for (Object localObject = ImmutableSet.d(); ; localObject = new ImmutableSortedMap.EntrySet(this))
      return localObject;
  }

  private ImmutableSortedSet<K> i()
  {
    if (isEmpty());
    for (Object localObject = ImmutableSortedSet.a(this.d); ; localObject = new RegularImmutableSortedSet(new ImmutableSortedMap.2(this, this.a), this.d))
      return localObject;
  }

  private ImmutableList<K> l()
  {
    return new ImmutableSortedMap.4(this, this.a);
  }

  public ImmutableSet<Map.Entry<K, V>> a()
  {
    ImmutableSet localImmutableSet = this.e;
    if (localImmutableSet == null)
    {
      localImmutableSet = h();
      this.e = localImmutableSet;
    }
    return localImmutableSet;
  }

  public ImmutableSortedMap<K, V> a(K paramK)
  {
    return a(paramK, false);
  }

  ImmutableSortedMap<K, V> a(K paramK, boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 1 + a(paramK, SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER); ; i = a(paramK, SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER))
      return a(0, i);
  }

  ImmutableSortedMap<K, V> a(K paramK1, boolean paramBoolean1, K paramK2, boolean paramBoolean2)
  {
    Preconditions.checkNotNull(paramK1);
    Preconditions.checkNotNull(paramK2);
    if (this.d.compare(paramK1, paramK2) <= 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      return b(paramK1, paramBoolean1).a(paramK2, paramBoolean2);
    }
  }

  public ImmutableSortedMap<K, V> b(K paramK)
  {
    return b(paramK, true);
  }

  ImmutableSortedMap<K, V> b(K paramK, boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = a(paramK, SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER); ; i = 1 + a(paramK, SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER))
      return a(i, size());
  }

  public ImmutableCollection<V> c()
  {
    Object localObject = this.g;
    if (localObject == null)
    {
      localObject = new ImmutableSortedMap.Values(this);
      this.g = ((ImmutableCollection)localObject);
    }
    return localObject;
  }

  public ImmutableSortedMap<K, V> c(K paramK1, K paramK2)
  {
    return a(paramK1, true, paramK2, false);
  }

  public Comparator<? super K> comparator()
  {
    return this.d;
  }

  public boolean containsValue(Object paramObject)
  {
    if (paramObject == null);
    for (boolean bool = false; ; bool = Iterators.a(g(), paramObject))
      return bool;
  }

  boolean d()
  {
    return this.a.l_();
  }

  Comparator<Object> e()
  {
    return this.d;
  }

  public ImmutableSortedSet<K> f()
  {
    ImmutableSortedSet localImmutableSortedSet = this.f;
    if (localImmutableSortedSet == null)
    {
      localImmutableSortedSet = i();
      this.f = localImmutableSortedSet;
    }
    return localImmutableSortedSet;
  }

  public K firstKey()
  {
    if (isEmpty())
      throw new NoSuchElementException();
    return ((Map.Entry)this.a.get(0)).getKey();
  }

  UnmodifiableIterator<V> g()
  {
    return new ImmutableSortedMap.3(this, this.a.b());
  }

  public V get(Object paramObject)
  {
    Object localObject = null;
    if (paramObject == null);
    while (true)
    {
      return localObject;
      try
      {
        int i = a(paramObject, SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.INVERTED_INSERTION_INDEX);
        localObject = null;
        if (i >= 0)
          localObject = ((Map.Entry)this.a.get(i)).getValue();
      }
      catch (ClassCastException localClassCastException)
      {
        localObject = null;
      }
    }
  }

  public K lastKey()
  {
    if (isEmpty())
      throw new NoSuchElementException();
    return ((Map.Entry)this.a.get(-1 + size())).getKey();
  }

  public int size()
  {
    return this.a.size();
  }

  Object writeReplace()
  {
    return new ImmutableSortedMap.SerializedForm(this);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableSortedMap
 * JD-Core Version:    0.6.2
 */