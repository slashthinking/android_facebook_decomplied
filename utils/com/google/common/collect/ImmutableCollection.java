package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;

public abstract class ImmutableCollection<E>
  implements Serializable, Collection<E>
{
  static final ImmutableCollection<Object> c = new ImmutableCollection.EmptyImmutableCollection(null);
  private transient ImmutableList<E> a;

  public final boolean add(E paramE)
  {
    throw new UnsupportedOperationException();
  }

  public final boolean addAll(Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException();
  }

  public abstract UnmodifiableIterator<E> b();

  public final void clear()
  {
    throw new UnsupportedOperationException();
  }

  public boolean contains(Object paramObject)
  {
    if ((paramObject != null) && (Iterators.a(b(), paramObject)));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean containsAll(Collection<?> paramCollection)
  {
    return Collections2.a(this, paramCollection);
  }

  public ImmutableList<E> h()
  {
    ImmutableList localImmutableList = this.a;
    if (localImmutableList == null)
    {
      localImmutableList = i();
      this.a = localImmutableList;
    }
    return localImmutableList;
  }

  ImmutableList<E> i()
  {
    Object localObject;
    switch (size())
    {
    default:
      localObject = new ImmutableAsList(toArray(), this);
    case 0:
    case 1:
    }
    while (true)
    {
      return localObject;
      localObject = ImmutableList.d();
      continue;
      localObject = ImmutableList.a(b().next());
    }
  }

  public boolean isEmpty()
  {
    if (size() == 0);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  abstract boolean l_();

  public final boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }

  public final boolean removeAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }

  public final boolean retainAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }

  public Object[] toArray()
  {
    return ObjectArrays.a(this);
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return ObjectArrays.a(this, paramArrayOfT);
  }

  public String toString()
  {
    return Collections2.a(this);
  }

  Object writeReplace()
  {
    return new ImmutableCollection.SerializedForm(toArray());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableCollection
 * JD-Core Version:    0.6.2
 */