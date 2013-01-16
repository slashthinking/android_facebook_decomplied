package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract interface Multimap<K, V>
{
  public abstract boolean a(K paramK, Iterable<? extends V> paramIterable);

  public abstract boolean a(K paramK, V paramV);

  public abstract Collection<V> b(K paramK);

  public abstract Map<K, Collection<V>> b();

  public abstract boolean b(Object paramObject1, Object paramObject2);

  public abstract boolean c(Object paramObject1, Object paramObject2);

  public abstract int d();

  public abstract boolean d(Object paramObject);

  public abstract boolean e();

  public abstract void f();

  public abstract Set<K> g();

  public abstract Multiset<K> h();

  public abstract Collection<Map.Entry<K, V>> i();
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Multimap
 * JD-Core Version:    0.6.2
 */