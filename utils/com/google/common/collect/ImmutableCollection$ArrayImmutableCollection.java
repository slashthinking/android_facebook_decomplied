package com.google.common.collect;

class ImmutableCollection$ArrayImmutableCollection<E> extends ImmutableCollection<E>
{
  private final E[] elements;

  ImmutableCollection$ArrayImmutableCollection(E[] paramArrayOfE)
  {
    this.elements = paramArrayOfE;
  }

  public UnmodifiableIterator<E> b()
  {
    return Iterators.a(this.elements);
  }

  ImmutableList<E> i()
  {
    if (this.elements.length == 1);
    for (Object localObject = new SingletonImmutableList(this.elements[0]); ; localObject = new RegularImmutableList(this.elements))
      return localObject;
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
    return this.elements.length;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableCollection.ArrayImmutableCollection
 * JD-Core Version:    0.6.2
 */