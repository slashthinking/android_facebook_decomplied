package com.google.common.collect;

class SingletonImmutableMap$Values<V> extends ImmutableCollection<V>
{
  final V singleValue;

  SingletonImmutableMap$Values(V paramV)
  {
    this.singleValue = paramV;
  }

  public UnmodifiableIterator<V> b()
  {
    return Iterators.a(this.singleValue);
  }

  public boolean contains(Object paramObject)
  {
    return this.singleValue.equals(paramObject);
  }

  public boolean isEmpty()
  {
    return false;
  }

  boolean l_()
  {
    return true;
  }

  public int size()
  {
    return 1;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.SingletonImmutableMap.Values
 * JD-Core Version:    0.6.2
 */