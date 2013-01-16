package com.google.common.collect;

import java.util.Collection;

abstract class ImmutableSet$ArrayImmutableSet<E> extends ImmutableSet<E>
{
  final transient Object[] a;

  ImmutableSet$ArrayImmutableSet(Object[] paramArrayOfObject)
  {
    this.a = paramArrayOfObject;
  }

  public UnmodifiableIterator<E> b()
  {
    return Iterators.a(this.a);
  }

  public boolean containsAll(Collection<?> paramCollection)
  {
    boolean bool = true;
    if (paramCollection == this);
    label85: 
    while (true)
    {
      return bool;
      if (!(paramCollection instanceof ArrayImmutableSet))
      {
        bool = super.containsAll(paramCollection);
      }
      else if (paramCollection.size() > size())
      {
        bool = false;
      }
      else
      {
        Object[] arrayOfObject = ((ArrayImmutableSet)paramCollection).a;
        int i = arrayOfObject.length;
        for (int j = 0; ; j++)
        {
          if (j >= i)
            break label85;
          if (!contains(arrayOfObject[j]))
          {
            bool = false;
            break;
          }
        }
      }
    }
  }

  ImmutableList<E> i()
  {
    return new ImmutableAsList(this.a, this);
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
    return this.a.length;
  }

  public Object[] toArray()
  {
    Object[] arrayOfObject = new Object[size()];
    System.arraycopy(this.a, 0, arrayOfObject, 0, size());
    return arrayOfObject;
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    int i = size();
    if (paramArrayOfT.length < i)
      paramArrayOfT = ObjectArrays.a(paramArrayOfT, i);
    while (true)
    {
      System.arraycopy(this.a, 0, paramArrayOfT, 0, i);
      return paramArrayOfT;
      if (paramArrayOfT.length > i)
        paramArrayOfT[i] = null;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableSet.ArrayImmutableSet
 * JD-Core Version:    0.6.2
 */