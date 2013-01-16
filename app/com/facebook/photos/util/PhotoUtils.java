package com.facebook.photos.util;

import com.facebook.common.util.Tuple;

public class PhotoUtils
{
  public static String a(long paramLong1, long paramLong2)
  {
    Object[] arrayOfObject;
    if (paramLong2 > 2147483647L)
    {
      arrayOfObject = new Object[2];
      arrayOfObject[0] = Long.valueOf(paramLong2);
      arrayOfObject[1] = Long.valueOf(paramLong1);
    }
    for (String str = String.format("%s_%s", arrayOfObject); ; str = String.valueOf(paramLong1 + (paramLong2 << 32)))
      return str;
  }

  public static String a(String paramString)
  {
    return (String)c(paramString).a;
  }

  public static String b(String paramString)
  {
    return (String)c(paramString).b;
  }

  private static Tuple<String, String> c(String paramString)
  {
    int i = paramString.indexOf('_');
    if (i != -1);
    long l;
    for (Tuple localTuple = new Tuple(paramString.substring(i + 1), paramString.substring(0, i)); ; localTuple = new Tuple(String.valueOf(0xFFFFFFFF & l), String.valueOf(l >> 32)))
    {
      return localTuple;
      l = Long.valueOf(paramString).longValue();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.util.PhotoUtils
 * JD-Core Version:    0.6.0
 */