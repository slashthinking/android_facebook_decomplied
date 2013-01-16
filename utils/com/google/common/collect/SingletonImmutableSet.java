package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Set;

final class SingletonImmutableSet<E> extends ImmutableSet<E>
{
  final transient E a;
  private transient Integer b;

  SingletonImmutableSet(E paramE)
  {
    this.a = Preconditions.checkNotNull(paramE);
  }

  SingletonImmutableSet(E paramE, int paramInt)
  {
    this.a = paramE;
    this.b = Integer.valueOf(paramInt);
  }

  public UnmodifiableIterator<E> b()
  {
    return Iterators.a(this.a);
  }

  boolean c()
  {
    return false;
  }

  public boolean contains(Object paramObject)
  {
    return this.a.equals(paramObject);
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (paramObject == this);
    while (true)
    {
      return i;
      int j;
      if ((paramObject instanceof Set))
      {
        Set localSet = (Set)paramObject;
        if ((localSet.size() != i) || (!this.a.equals(localSet.iterator().next())))
          j = 0;
      }
      else
      {
        j = 0;
      }
    }
  }

  public final int hashCode()
  {
    Integer localInteger1 = this.b;
    Integer localInteger2;
    if (localInteger1 == null)
    {
      localInteger2 = Integer.valueOf(this.a.hashCode());
      this.b = localInteger2;
    }
    for (int i = localInteger2.intValue(); ; i = localInteger1.intValue())
      return i;
  }

  public boolean isEmpty()
  {
    return false;
  }

  boolean l_()
  {
    return false;
  }

  public int size()
  {
    return 1;
  }

  public Object[] toArray()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.a;
    return arrayOfObject;
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    if (paramArrayOfT.length == 0)
      paramArrayOfT = ObjectArrays.a(paramArrayOfT, 1);
    while (true)
    {
      paramArrayOfT[0] = this.a;
      return paramArrayOfT;
      if (paramArrayOfT.length > 1)
        paramArrayOfT[1] = null;
    }
  }

  public String toString()
  {
    String str = this.a.toString();
    return 2 + str.length() + '[' + str + ']';
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.SingletonImmutableSet
 * JD-Core Version:    0.6.2
 */