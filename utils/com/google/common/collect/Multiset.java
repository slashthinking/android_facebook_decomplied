package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public abstract interface Multiset<E> extends Collection<E>
{
  public abstract int a(Object paramObject);

  public abstract int a(E paramE, int paramInt);

  public abstract Set<Multiset.Entry<E>> a();

  public abstract boolean add(E paramE);

  public abstract int b(Object paramObject, int paramInt);

  public abstract boolean contains(Object paramObject);

  public abstract boolean containsAll(Collection<?> paramCollection);

  public abstract Set<E> f();

  public abstract Iterator<E> iterator();

  public abstract boolean remove(Object paramObject);
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Multiset
 * JD-Core Version:    0.6.2
 */