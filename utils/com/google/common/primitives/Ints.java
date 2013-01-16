package com.google.common.primitives;

import com.google.common.base.Preconditions;

public final class Ints
{
  public static int a(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 < paramInt2)
      i = -1;
    while (true)
    {
      return i;
      if (paramInt1 > paramInt2)
        i = 1;
      else
        i = 0;
    }
  }

  public static int a(long paramLong)
  {
    int i = (int)paramLong;
    if (i == paramLong);
    for (boolean bool = true; ; bool = false)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Long.valueOf(paramLong);
      Preconditions.checkArgument(bool, "Out of range: %s", arrayOfObject);
      return i;
    }
  }

  public static int a(int[] paramArrayOfInt)
  {
    int i = 1;
    if (paramArrayOfInt.length > 0);
    int m;
    int k;
    for (int j = i; ; k = 0)
    {
      Preconditions.checkArgument(j);
      m = paramArrayOfInt[0];
      while (i < paramArrayOfInt.length)
      {
        if (paramArrayOfInt[i] > m)
          m = paramArrayOfInt[i];
        i++;
      }
    }
    return m;
  }

  public static int b(long paramLong)
  {
    int i;
    if (paramLong > 2147483647L)
      i = 2147483647;
    while (true)
    {
      return i;
      if (paramLong < -2147483648L)
        i = -2147483648;
      else
        i = (int)paramLong;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.primitives.Ints
 * JD-Core Version:    0.6.2
 */