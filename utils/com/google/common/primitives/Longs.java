package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class Longs
{
  public static int a(long paramLong)
  {
    return (int)(paramLong ^ paramLong >>> 32);
  }

  public static int a(long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong1 < paramLong2)
      i = -1;
    while (true)
    {
      return i;
      if (paramLong1 > paramLong2)
        i = 1;
      else
        i = 0;
    }
  }

  public static List<Long> a(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong.length == 0);
    for (Object localObject = Collections.emptyList(); ; localObject = new Longs.LongArrayAsList(paramArrayOfLong))
      return localObject;
  }

  public static long[] a(Collection<Long> paramCollection)
  {
    if ((paramCollection instanceof Longs.LongArrayAsList));
    long[] arrayOfLong;
    for (Object localObject = ((Longs.LongArrayAsList)paramCollection).a(); ; localObject = arrayOfLong)
    {
      return localObject;
      Object[] arrayOfObject = paramCollection.toArray();
      int i = arrayOfObject.length;
      arrayOfLong = new long[i];
      for (int j = 0; j < i; j++)
        arrayOfLong[j] = ((Long)Preconditions.checkNotNull(arrayOfObject[j])).longValue();
    }
  }

  private static int c(long[] paramArrayOfLong, long paramLong, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (i < paramInt2)
      if (paramArrayOfLong[i] != paramLong);
    while (true)
    {
      return i;
      i++;
      break;
      i = -1;
    }
  }

  private static int d(long[] paramArrayOfLong, long paramLong, int paramInt1, int paramInt2)
  {
    int i = paramInt2 - 1;
    if (i >= paramInt1)
      if (paramArrayOfLong[i] != paramLong);
    while (true)
    {
      return i;
      i--;
      break;
      i = -1;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.primitives.Longs
 * JD-Core Version:    0.6.2
 */