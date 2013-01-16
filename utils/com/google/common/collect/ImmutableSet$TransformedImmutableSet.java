package com.google.common.collect;

abstract class ImmutableSet$TransformedImmutableSet<D, E> extends ImmutableSet<E>
{
  final int hashCode;
  final D[] source;

  ImmutableSet$TransformedImmutableSet(D[] paramArrayOfD, int paramInt)
  {
    this.source = paramArrayOfD;
    this.hashCode = paramInt;
  }

  abstract E a(D paramD);

  public UnmodifiableIterator<E> b()
  {
    return new ImmutableSet.TransformedImmutableSet.1(this, this.source.length);
  }

  boolean c()
  {
    return true;
  }

  public final int hashCode()
  {
    return this.hashCode;
  }

  public boolean isEmpty()
  {
    return false;
  }

  public int size()
  {
    return this.source.length;
  }

  public Object[] toArray()
  {
    return toArray(new Object[size()]);
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    int i = size();
    if (paramArrayOfT.length < i)
      paramArrayOfT = ObjectArrays.a(paramArrayOfT, i);
    while (true)
    {
      for (int j = 0; j < this.source.length; j++)
        paramArrayOfT[j] = a(this.source[j]);
      if (paramArrayOfT.length > i)
        paramArrayOfT[i] = null;
    }
    return paramArrayOfT;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableSet.TransformedImmutableSet
 * JD-Core Version:    0.6.2
 */