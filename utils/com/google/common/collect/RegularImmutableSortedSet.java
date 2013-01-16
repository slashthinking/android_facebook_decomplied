package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

final class RegularImmutableSortedSet<E> extends ImmutableSortedSet<E>
{
  private final transient ImmutableList<E> b;

  RegularImmutableSortedSet(ImmutableList<E> paramImmutableList, Comparator<? super E> paramComparator)
  {
    super(paramComparator);
    this.b = paramImmutableList;
    if (!paramImmutableList.isEmpty());
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      return;
    }
  }

  private ImmutableSortedSet<E> a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == size()));
    while (true)
    {
      return this;
      if (paramInt1 < paramInt2)
        this = new RegularImmutableSortedSet(this.b.a(paramInt1, paramInt2), this.a);
      else
        this = a(this.a);
    }
  }

  private int e(Object paramObject)
  {
    Comparator localComparator = this.a;
    return Collections.binarySearch(this.b, paramObject, localComparator);
  }

  int a(Object paramObject)
  {
    int i = -1;
    if (paramObject == null);
    while (true)
    {
      return i;
      try
      {
        int j = SortedLists.a(this.b, paramObject, comparator(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.INVERTED_INSERTION_INDEX);
        int k = j;
        if ((k >= 0) && (this.b.get(k).equals(paramObject)));
        while (true)
        {
          i = k;
          break;
          k = i;
        }
      }
      catch (ClassCastException localClassCastException)
      {
      }
    }
  }

  ImmutableSortedSet<E> a(E paramE, boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = SortedLists.a(this.b, Preconditions.checkNotNull(paramE), comparator(), SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER); ; i = SortedLists.a(this.b, Preconditions.checkNotNull(paramE), comparator(), SortedLists.KeyPresentBehavior.FIRST_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER))
      return a(0, i);
  }

  ImmutableSortedSet<E> a(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2)
  {
    return b(paramE1, paramBoolean1).a(paramE2, paramBoolean2);
  }

  ImmutableSortedSet<E> b(E paramE, boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = SortedLists.a(this.b, Preconditions.checkNotNull(paramE), comparator(), SortedLists.KeyPresentBehavior.FIRST_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER); ; i = SortedLists.a(this.b, Preconditions.checkNotNull(paramE), comparator(), SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER))
      return a(i, size());
  }

  public UnmodifiableIterator<E> b()
  {
    return this.b.b();
  }

  public boolean contains(Object paramObject)
  {
    boolean bool = false;
    if (paramObject == null);
    while (true)
    {
      return bool;
      try
      {
        int i = e(paramObject);
        bool = false;
        if (i >= 0)
          bool = true;
      }
      catch (ClassCastException localClassCastException)
      {
        bool = false;
      }
    }
  }

  public boolean containsAll(Collection<?> paramCollection)
  {
    boolean bool;
    if ((!SortedIterables.a(comparator(), paramCollection)) || (paramCollection.size() <= 1))
      bool = super.containsAll(paramCollection);
    while (true)
    {
      return bool;
      UnmodifiableIterator localUnmodifiableIterator = b();
      Iterator localIterator = paramCollection.iterator();
      Object localObject1 = localIterator.next();
      try
      {
        int i;
        label110: 
        do
          while (true)
          {
            if (!localUnmodifiableIterator.hasNext())
              break label134;
            i = b(localUnmodifiableIterator.next(), localObject1);
            if (i != 0)
              break label110;
            if (!localIterator.hasNext())
            {
              bool = true;
              break;
            }
            Object localObject2 = localIterator.next();
            localObject1 = localObject2;
          }
        while (i <= 0);
        bool = false;
      }
      catch (NullPointerException localNullPointerException)
      {
        bool = false;
      }
      catch (ClassCastException localClassCastException)
      {
        bool = false;
      }
      continue;
      label134: bool = false;
    }
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this);
    while (true)
    {
      return bool;
      if (!(paramObject instanceof Set))
      {
        bool = false;
      }
      else
      {
        Set localSet = (Set)paramObject;
        if (size() != localSet.size())
        {
          bool = false;
        }
        else if (SortedIterables.a(this.a, localSet))
        {
          Iterator localIterator = localSet.iterator();
          try
          {
            UnmodifiableIterator localUnmodifiableIterator = b();
            int i;
            do
            {
              if (!localUnmodifiableIterator.hasNext())
                break;
              Object localObject1 = localUnmodifiableIterator.next();
              Object localObject2 = localIterator.next();
              if (localObject2 == null)
                break label117;
              i = b(localObject1, localObject2);
            }
            while (i == 0);
            label117: bool = false;
          }
          catch (ClassCastException localClassCastException)
          {
            bool = false;
          }
          catch (NoSuchElementException localNoSuchElementException)
          {
            bool = false;
          }
        }
        else
        {
          bool = containsAll(localSet);
        }
      }
    }
  }

  public E first()
  {
    return this.b.get(0);
  }

  ImmutableList<E> i()
  {
    return new ImmutableSortedAsList(this, this.b);
  }

  public boolean isEmpty()
  {
    return false;
  }

  boolean l_()
  {
    return this.b.l_();
  }

  public E last()
  {
    return this.b.get(-1 + size());
  }

  public int size()
  {
    return this.b.size();
  }

  public Object[] toArray()
  {
    return this.b.toArray();
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return this.b.toArray(paramArrayOfT);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.RegularImmutableSortedSet
 * JD-Core Version:    0.6.2
 */