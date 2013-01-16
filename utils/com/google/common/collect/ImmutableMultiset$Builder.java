package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Set;

public class ImmutableMultiset$Builder<E> extends ImmutableCollection.Builder<E>
{
  final Multiset<E> a;

  public ImmutableMultiset$Builder()
  {
    this(LinkedHashMultiset.e());
  }

  ImmutableMultiset$Builder(Multiset<E> paramMultiset)
  {
    this.a = paramMultiset;
  }

  public Builder<E> a(E paramE, int paramInt)
  {
    this.a.a(Preconditions.checkNotNull(paramE), paramInt);
    return this;
  }

  public Builder<E> b(Iterable<? extends E> paramIterable)
  {
    if ((paramIterable instanceof Multiset))
    {
      Iterator localIterator = Multisets.b(paramIterable).a().iterator();
      while (localIterator.hasNext())
      {
        Multiset.Entry localEntry = (Multiset.Entry)localIterator.next();
        a(localEntry.a(), localEntry.b());
      }
    }
    super.a(paramIterable);
    return this;
  }

  public Builder<E> b(E paramE)
  {
    this.a.add(Preconditions.checkNotNull(paramE));
    return this;
  }

  public Builder<E> b(Iterator<? extends E> paramIterator)
  {
    super.a(paramIterator);
    return this;
  }

  public Builder<E> b(E[] paramArrayOfE)
  {
    super.a(paramArrayOfE);
    return this;
  }

  public ImmutableMultiset<E> b()
  {
    return ImmutableMultiset.a(this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableMultiset.Builder
 * JD-Core Version:    0.6.2
 */