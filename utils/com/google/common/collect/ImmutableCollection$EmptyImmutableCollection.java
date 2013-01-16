package com.google.common.collect;

class ImmutableCollection$EmptyImmutableCollection extends ImmutableCollection<Object>
{
  private static final Object[] a = new Object[0];

  public UnmodifiableIterator<Object> b()
  {
    return Iterators.a;
  }

  public boolean contains(Object paramObject)
  {
    return false;
  }

  ImmutableList<Object> i()
  {
    return ImmutableList.d();
  }

  public boolean isEmpty()
  {
    return true;
  }

  boolean l_()
  {
    return false;
  }

  public int size()
  {
    return 0;
  }

  public Object[] toArray()
  {
    return a;
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    if (paramArrayOfT.length > 0)
      paramArrayOfT[0] = null;
    return paramArrayOfT;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableCollection.EmptyImmutableCollection
 * JD-Core Version:    0.6.2
 */