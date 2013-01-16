package com.google.common.collect;

import com.google.common.primitives.Ints;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public abstract class ImmutableMultiset<E> extends ImmutableCollection<E>
  implements Multiset<E>
{
  private transient ImmutableSet<Multiset.Entry<E>> a;

  private static <E> ImmutableMultiset<E> a(Multiset<? extends E> paramMultiset)
  {
    ImmutableMap.Builder localBuilder = ImmutableMap.k();
    Iterator localIterator = paramMultiset.a().iterator();
    long l1 = 0L;
    int i;
    if (localIterator.hasNext())
    {
      Multiset.Entry localEntry = (Multiset.Entry)localIterator.next();
      i = localEntry.b();
      if (i <= 0)
        break label116;
      localBuilder.b(localEntry.a(), Integer.valueOf(i));
    }
    label116: for (long l2 = l1 + i; ; l2 = l1)
    {
      l1 = l2;
      break;
      if (l1 == 0L);
      for (Object localObject = j(); ; localObject = new RegularImmutableMultiset(localBuilder.b(), Ints.b(l1)))
        return localObject;
    }
  }

  public static <E> ImmutableMultiset<E> a(Iterable<? extends E> paramIterable)
  {
    ImmutableMultiset localImmutableMultiset;
    if ((paramIterable instanceof ImmutableMultiset))
    {
      localImmutableMultiset = (ImmutableMultiset)paramIterable;
      if (!localImmutableMultiset.l_())
        return localImmutableMultiset;
    }
    if ((paramIterable instanceof Multiset));
    for (Object localObject = Multisets.b(paramIterable); ; localObject = LinkedHashMultiset.a(paramIterable))
    {
      localImmutableMultiset = a((Multiset)localObject);
      break;
    }
  }

  public static <E> ImmutableMultiset<E> j()
  {
    return EmptyImmutableMultiset.a;
  }

  public static <E> ImmutableMultiset.Builder<E> k()
  {
    return new ImmutableMultiset.Builder();
  }

  public final int a(E paramE, int paramInt)
  {
    throw new UnsupportedOperationException();
  }

  public Set<Multiset.Entry<E>> a()
  {
    ImmutableSet localImmutableSet = this.a;
    if (localImmutableSet == null)
    {
      localImmutableSet = g();
      this.a = localImmutableSet;
    }
    return localImmutableSet;
  }

  public final int b(Object paramObject, int paramInt)
  {
    throw new UnsupportedOperationException();
  }

  public UnmodifiableIterator<E> b()
  {
    return new ImmutableMultiset.1(this, d());
  }

  public boolean contains(Object paramObject)
  {
    if (a(paramObject) > 0);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean containsAll(Collection<?> paramCollection)
  {
    return f().containsAll(paramCollection);
  }

  abstract UnmodifiableIterator<Multiset.Entry<E>> d();

  abstract int e();

  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (paramObject == this)
      bool = true;
    while (true)
    {
      return bool;
      if ((paramObject instanceof Multiset))
      {
        Multiset localMultiset = (Multiset)paramObject;
        if (size() != localMultiset.size())
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
              if (a(localEntry.a()) != localEntry.b())
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

  ImmutableSet<Multiset.Entry<E>> g()
  {
    return new ImmutableMultiset.EntrySet(this);
  }

  public int hashCode()
  {
    return Sets.a(a());
  }

  public String toString()
  {
    return a().toString();
  }

  Object writeReplace()
  {
    return new ImmutableMultiset.SerializedForm(this);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableMultiset
 * JD-Core Version:    0.6.2
 */