package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class ImmutableList$Builder<E> extends ImmutableCollection.Builder<E>
{
  private final ArrayList<E> a = Lists.a();

  public Builder<E> b(Iterable<? extends E> paramIterable)
  {
    if ((paramIterable instanceof Collection))
    {
      Collection localCollection = (Collection)paramIterable;
      this.a.ensureCapacity(this.a.size() + localCollection.size());
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
    this.a.ensureCapacity(this.a.size() + paramArrayOfE.length);
    super.a(paramArrayOfE);
    return this;
  }

  public ImmutableList<E> b()
  {
    return ImmutableList.a(this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableList.Builder
 * JD-Core Version:    0.6.2
 */