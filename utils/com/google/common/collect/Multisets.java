package com.google.common.collect;

import com.google.common.primitives.Ints;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class Multisets
{
  static int a(Iterable<?> paramIterable)
  {
    if ((paramIterable instanceof Multiset));
    for (int i = ((Multiset)paramIterable).f().size(); ; i = 11)
      return i;
  }

  public static <E> Multiset.Entry<E> a(E paramE, int paramInt)
  {
    return new Multisets.ImmutableEntry(paramE, paramInt);
  }

  static <E> Iterator<E> a(Multiset<E> paramMultiset)
  {
    return new Multisets.MultisetIteratorImpl(paramMultiset, paramMultiset.a().iterator());
  }

  static boolean a(Multiset<?> paramMultiset, Object paramObject)
  {
    boolean bool;
    if (paramObject == paramMultiset)
      bool = true;
    while (true)
    {
      return bool;
      if ((paramObject instanceof Multiset))
      {
        Multiset localMultiset = (Multiset)paramObject;
        if ((paramMultiset.size() != localMultiset.size()) || (paramMultiset.a().size() != localMultiset.a().size()))
        {
          bool = false;
        }
        else
        {
          Iterator localIterator = localMultiset.a().iterator();
          while (true)
            if (localIterator.hasNext())
            {
              Multiset.Entry localEntry = (Multiset.Entry)localIterator.next();
              if (paramMultiset.a(localEntry.a()) != localEntry.b())
              {
                bool = false;
                break;
              }
            }
          bool = true;
        }
      }
      else
      {
        bool = false;
      }
    }
  }

  static <E> boolean a(Multiset<E> paramMultiset, Collection<? extends E> paramCollection)
  {
    if (paramCollection.isEmpty());
    for (boolean bool = false; ; bool = true)
    {
      return bool;
      if ((paramCollection instanceof Multiset))
      {
        Iterator localIterator = b(paramCollection).a().iterator();
        while (localIterator.hasNext())
        {
          Multiset.Entry localEntry = (Multiset.Entry)localIterator.next();
          paramMultiset.a(localEntry.a(), localEntry.b());
        }
      }
      Iterators.a(paramMultiset, paramCollection.iterator());
    }
  }

  static int b(Multiset<?> paramMultiset)
  {
    Iterator localIterator = paramMultiset.a().iterator();
    for (long l = 0L; localIterator.hasNext(); l += ((Multiset.Entry)localIterator.next()).b());
    return Ints.b(l);
  }

  static <T> Multiset<T> b(Iterable<T> paramIterable)
  {
    return (Multiset)paramIterable;
  }

  static boolean b(Multiset<?> paramMultiset, Collection<?> paramCollection)
  {
    if ((paramCollection instanceof Multiset))
      paramCollection = ((Multiset)paramCollection).f();
    return paramMultiset.f().removeAll(paramCollection);
  }

  static boolean c(Multiset<?> paramMultiset, Collection<?> paramCollection)
  {
    if ((paramCollection instanceof Multiset))
      paramCollection = ((Multiset)paramCollection).f();
    return paramMultiset.f().retainAll(paramCollection);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Multisets
 * JD-Core Version:    0.6.2
 */