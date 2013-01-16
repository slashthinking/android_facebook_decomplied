package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

class Longs$LongArrayAsList extends AbstractList<Long>
  implements Serializable, RandomAccess
{
  private static final long serialVersionUID;
  final long[] array;
  final int end;
  final int start;

  Longs$LongArrayAsList(long[] paramArrayOfLong)
  {
    this(paramArrayOfLong, 0, paramArrayOfLong.length);
  }

  Longs$LongArrayAsList(long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    this.array = paramArrayOfLong;
    this.start = paramInt1;
    this.end = paramInt2;
  }

  public Long a(int paramInt)
  {
    Preconditions.checkElementIndex(paramInt, size());
    return Long.valueOf(this.array[(paramInt + this.start)]);
  }

  public Long a(int paramInt, Long paramLong)
  {
    Preconditions.checkElementIndex(paramInt, size());
    long l = this.array[(paramInt + this.start)];
    this.array[(paramInt + this.start)] = ((Long)Preconditions.checkNotNull(paramLong)).longValue();
    return Long.valueOf(l);
  }

  long[] a()
  {
    int i = size();
    long[] arrayOfLong = new long[i];
    System.arraycopy(this.array, this.start, arrayOfLong, 0, i);
    return arrayOfLong;
  }

  public boolean contains(Object paramObject)
  {
    if (((paramObject instanceof Long)) && (Longs.a(this.array, ((Long)paramObject).longValue(), this.start, this.end) != -1));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this);
    while (true)
    {
      return bool;
      if ((paramObject instanceof LongArrayAsList))
      {
        LongArrayAsList localLongArrayAsList = (LongArrayAsList)paramObject;
        int i = size();
        if (localLongArrayAsList.size() != i)
          bool = false;
        else
          for (int j = 0; ; j++)
          {
            if (j >= i)
              break label88;
            if (this.array[(j + this.start)] != localLongArrayAsList.array[(j + localLongArrayAsList.start)])
            {
              bool = false;
              break;
            }
          }
      }
      else
      {
        label88: bool = super.equals(paramObject);
      }
    }
  }

  public int hashCode()
  {
    int i = 1;
    for (int j = this.start; j < this.end; j++)
      i = i * 31 + Longs.a(this.array[j]);
    return i;
  }

  public int indexOf(Object paramObject)
  {
    int j;
    if ((paramObject instanceof Long))
    {
      j = Longs.a(this.array, ((Long)paramObject).longValue(), this.start, this.end);
      if (j < 0);
    }
    for (int i = j - this.start; ; i = -1)
      return i;
  }

  public boolean isEmpty()
  {
    return false;
  }

  public int lastIndexOf(Object paramObject)
  {
    int j;
    if ((paramObject instanceof Long))
    {
      j = Longs.b(this.array, ((Long)paramObject).longValue(), this.start, this.end);
      if (j < 0);
    }
    for (int i = j - this.start; ; i = -1)
      return i;
  }

  public int size()
  {
    return this.end - this.start;
  }

  public List<Long> subList(int paramInt1, int paramInt2)
  {
    Preconditions.checkPositionIndexes(paramInt1, paramInt2, size());
    if (paramInt1 == paramInt2);
    for (Object localObject = Collections.emptyList(); ; localObject = new LongArrayAsList(this.array, paramInt1 + this.start, paramInt2 + this.start))
      return localObject;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(10 * size());
    localStringBuilder.append('[').append(this.array[this.start]);
    for (int i = 1 + this.start; i < this.end; i++)
      localStringBuilder.append(", ").append(this.array[i]);
    return ']';
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.primitives.Longs.LongArrayAsList
 * JD-Core Version:    0.6.2
 */