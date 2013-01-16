package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.List;

final class SingletonImmutableList<E> extends ImmutableList<E>
{
  final transient E a;

  SingletonImmutableList(E paramE)
  {
    this.a = Preconditions.checkNotNull(paramE);
  }

  public ImmutableList<E> a(int paramInt1, int paramInt2)
  {
    Preconditions.checkPositionIndexes(paramInt1, paramInt2, 1);
    if (paramInt1 == paramInt2)
      this = ImmutableList.d();
    return this;
  }

  public UnmodifiableListIterator<E> a(int paramInt)
  {
    Preconditions.checkPositionIndex(paramInt, 1);
    return new SingletonImmutableList.1(this, paramInt);
  }

  public UnmodifiableIterator<E> b()
  {
    return Iterators.a(this.a);
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
      if ((paramObject instanceof List))
      {
        List localList = (List)paramObject;
        if ((localList.size() != i) || (!this.a.equals(localList.get(0))))
          j = 0;
      }
      else
      {
        j = 0;
      }
    }
  }

  public E get(int paramInt)
  {
    Preconditions.checkElementIndex(paramInt, 1);
    return this.a;
  }

  public int hashCode()
  {
    return 31 + this.a.hashCode();
  }

  public int indexOf(Object paramObject)
  {
    if (this.a.equals(paramObject));
    for (int i = 0; ; i = -1)
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

  public int lastIndexOf(Object paramObject)
  {
    if (this.a.equals(paramObject));
    for (int i = 0; ; i = -1)
      return i;
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
 * Qualified Name:     com.google.common.collect.SingletonImmutableList
 * JD-Core Version:    0.6.2
 */