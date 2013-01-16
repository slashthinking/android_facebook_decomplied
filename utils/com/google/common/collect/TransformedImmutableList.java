package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.List;

abstract class TransformedImmutableList<D, E> extends ImmutableList<E>
{
  private final transient ImmutableList<D> a;

  TransformedImmutableList(ImmutableList<D> paramImmutableList)
  {
    this.a = ((ImmutableList)Preconditions.checkNotNull(paramImmutableList));
  }

  public ImmutableList<E> a(int paramInt1, int paramInt2)
  {
    return new TransformedImmutableList.TransformedView(this, this.a.a(paramInt1, paramInt2));
  }

  public UnmodifiableListIterator<E> a(int paramInt)
  {
    return new TransformedImmutableList.1(this, size(), paramInt);
  }

  abstract E b(D paramD);

  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this);
    while (true)
    {
      return bool;
      if ((paramObject instanceof List))
      {
        List localList = (List)paramObject;
        if ((size() != localList.size()) || (!Iterators.a(b(), localList.iterator())))
          bool = false;
      }
      else
      {
        bool = false;
      }
    }
  }

  public E get(int paramInt)
  {
    return b(this.a.get(paramInt));
  }

  public int hashCode()
  {
    int i = 1;
    Iterator localIterator = iterator();
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      int j = i * 31;
      if (localObject == null);
      for (int k = 0; ; k = localObject.hashCode())
      {
        i = k + j;
        break;
      }
    }
    return i;
  }

  public int indexOf(Object paramObject)
  {
    int i;
    if (paramObject == null)
      i = -1;
    while (true)
    {
      return i;
      for (i = 0; ; i++)
      {
        if (i >= size())
          break label36;
        if (get(i).equals(paramObject))
          break;
      }
      label36: i = -1;
    }
  }

  boolean l_()
  {
    return true;
  }

  public int lastIndexOf(Object paramObject)
  {
    int i = -1;
    if (paramObject == null);
    label40: 
    while (true)
    {
      return i;
      for (int j = -1 + size(); ; j--)
      {
        if (j < 0)
          break label40;
        if (get(j).equals(paramObject))
        {
          i = j;
          break;
        }
      }
    }
  }

  public int size()
  {
    return this.a.size();
  }

  public Object[] toArray()
  {
    return ObjectArrays.a(this);
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return ObjectArrays.a(this, paramArrayOfT);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.TransformedImmutableList
 * JD-Core Version:    0.6.2
 */