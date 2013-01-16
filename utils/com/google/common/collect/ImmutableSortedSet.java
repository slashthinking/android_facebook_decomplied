package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E>
  implements SortedIterable<E>, SortedSet<E>
{
  private static final Comparator<Comparable> b = Ordering.b();
  private static final ImmutableSortedSet<Comparable> d = new EmptyImmutableSortedSet(b);
  final transient Comparator<? super E> a;

  ImmutableSortedSet(Comparator<? super E> paramComparator)
  {
    this.a = paramComparator;
  }

  static int a(Comparator<?> paramComparator, Object paramObject1, Object paramObject2)
  {
    return paramComparator.compare(paramObject1, paramObject2);
  }

  static <E> ImmutableSortedSet<E> a(Comparator<? super E> paramComparator)
  {
    if (b.equals(paramComparator));
    for (Object localObject = f(); ; localObject = new EmptyImmutableSortedSet(paramComparator))
      return localObject;
  }

  private static <E> ImmutableSortedSet<E> b(Comparator<? super E> paramComparator, Iterator<? extends E> paramIterator)
  {
    ImmutableList localImmutableList = ImmutableList.a(SortedIterables.a(paramComparator, paramIterator));
    if (localImmutableList.isEmpty());
    for (Object localObject = a(paramComparator); ; localObject = new RegularImmutableSortedSet(localImmutableList, paramComparator))
      return localObject;
  }

  private static <E> ImmutableSortedSet<E> f()
  {
    return d;
  }

  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    throw new InvalidObjectException("Use SerializedForm");
  }

  abstract int a(Object paramObject);

  abstract ImmutableSortedSet<E> a(E paramE, boolean paramBoolean);

  abstract ImmutableSortedSet<E> a(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2);

  int b(Object paramObject1, Object paramObject2)
  {
    return a(this.a, paramObject1, paramObject2);
  }

  abstract ImmutableSortedSet<E> b(E paramE, boolean paramBoolean);

  ImmutableSortedSet<E> b(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2)
  {
    Preconditions.checkNotNull(paramE1);
    Preconditions.checkNotNull(paramE2);
    if (this.a.compare(paramE1, paramE2) <= 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      return a(paramE1, paramBoolean1, paramE2, paramBoolean2);
    }
  }

  public abstract UnmodifiableIterator<E> b();

  public ImmutableSortedSet<E> c(E paramE)
  {
    return c(paramE, false);
  }

  public ImmutableSortedSet<E> c(E paramE1, E paramE2)
  {
    return b(paramE1, true, paramE2, false);
  }

  ImmutableSortedSet<E> c(E paramE, boolean paramBoolean)
  {
    return a(Preconditions.checkNotNull(paramE), paramBoolean);
  }

  public Comparator<? super E> comparator()
  {
    return this.a;
  }

  public ImmutableSortedSet<E> d(E paramE)
  {
    return d(paramE, true);
  }

  ImmutableSortedSet<E> d(E paramE, boolean paramBoolean)
  {
    return b(Preconditions.checkNotNull(paramE), paramBoolean);
  }

  Object writeReplace()
  {
    return new ImmutableSortedSet.SerializedForm(this.a, toArray());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableSortedSet
 * JD-Core Version:    0.6.2
 */