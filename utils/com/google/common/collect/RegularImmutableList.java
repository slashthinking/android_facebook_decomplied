package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.List;

class RegularImmutableList<E> extends ImmutableList<E>
{
  private final transient int a;
  private final transient int b;
  private final transient Object[] d;

  RegularImmutableList(Object[] paramArrayOfObject)
  {
    this(paramArrayOfObject, 0, paramArrayOfObject.length);
  }

  RegularImmutableList(Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.d = paramArrayOfObject;
  }

  public ImmutableList<E> a(int paramInt1, int paramInt2)
  {
    Preconditions.checkPositionIndexes(paramInt1, paramInt2, this.b);
    if (paramInt1 == paramInt2);
    for (Object localObject = ImmutableList.d(); ; localObject = new RegularImmutableList(this.d, paramInt1 + this.a, paramInt2 - paramInt1))
      return localObject;
  }

  public UnmodifiableListIterator<E> a(int paramInt)
  {
    return new RegularImmutableList.1(this, this.b, paramInt);
  }

  public UnmodifiableIterator<E> b()
  {
    return Iterators.a(this.d, this.a, this.b);
  }

  public boolean contains(Object paramObject)
  {
    if (indexOf(paramObject) != -1);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (paramObject == this)
      bool = true;
    while (true)
    {
      return bool;
      if (!(paramObject instanceof List))
      {
        bool = false;
      }
      else
      {
        List localList = (List)paramObject;
        if (size() != localList.size())
        {
          bool = false;
        }
        else
        {
          int i = this.a;
          if ((paramObject instanceof RegularImmutableList))
          {
            RegularImmutableList localRegularImmutableList = (RegularImmutableList)paramObject;
            int k = localRegularImmutableList.a;
            while (true)
            {
              if (k >= localRegularImmutableList.a + localRegularImmutableList.b)
                break label196;
              Object[] arrayOfObject2 = this.d;
              int m = i + 1;
              if (!arrayOfObject2[i].equals(localRegularImmutableList.d[k]))
              {
                bool = false;
                break;
              }
              k++;
              i = m;
            }
          }
          Iterator localIterator = localList.iterator();
          while (true)
          {
            if (!localIterator.hasNext())
              break label196;
            Object localObject = localIterator.next();
            Object[] arrayOfObject1 = this.d;
            int j = i + 1;
            if (!arrayOfObject1[i].equals(localObject))
            {
              bool = false;
              break;
            }
            i = j;
          }
          label196: bool = true;
        }
      }
    }
  }

  public E get(int paramInt)
  {
    Preconditions.checkElementIndex(paramInt, this.b);
    return this.d[(paramInt + this.a)];
  }

  public int hashCode()
  {
    int i = 1;
    for (int j = this.a; j < this.a + this.b; j++)
      i = i * 31 + this.d[j].hashCode();
    return i;
  }

  public int indexOf(Object paramObject)
  {
    int j;
    if (paramObject != null)
    {
      j = this.a;
      if (j < this.a + this.b)
        if (!this.d[j].equals(paramObject));
    }
    for (int i = j - this.a; ; i = -1)
    {
      return i;
      j++;
      break;
    }
  }

  public boolean isEmpty()
  {
    return false;
  }

  boolean l_()
  {
    if ((this.a != 0) || (this.b != this.d.length));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public int lastIndexOf(Object paramObject)
  {
    int j;
    if (paramObject != null)
    {
      j = -1 + (this.a + this.b);
      if (j >= this.a)
        if (!this.d[j].equals(paramObject));
    }
    for (int i = j - this.a; ; i = -1)
    {
      return i;
      j--;
      break;
    }
  }

  public int size()
  {
    return this.b;
  }

  public Object[] toArray()
  {
    Object[] arrayOfObject = new Object[size()];
    System.arraycopy(this.d, this.a, arrayOfObject, 0, this.b);
    return arrayOfObject;
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    if (paramArrayOfT.length < this.b)
      paramArrayOfT = ObjectArrays.a(paramArrayOfT, this.b);
    while (true)
    {
      System.arraycopy(this.d, this.a, paramArrayOfT, 0, this.b);
      return paramArrayOfT;
      if (paramArrayOfT.length > this.b)
        paramArrayOfT[this.b] = null;
    }
  }

  public String toString()
  {
    StringBuilder localStringBuilder = Collections2.a(size()).append('[').append(this.d[this.a]);
    for (int i = 1 + this.a; i < this.a + this.b; i++)
      localStringBuilder.append(", ").append(this.d[i]);
    return ']';
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.RegularImmutableList
 * JD-Core Version:    0.6.2
 */