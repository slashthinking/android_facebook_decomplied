package com.google.common.collect;

import java.lang.reflect.Array;

class Platform
{
  static <T> T[] a(Class<T> paramClass, int paramInt)
  {
    return (Object[])Array.newInstance(paramClass, paramInt);
  }

  static <T> T[] a(T[] paramArrayOfT)
  {
    return (Object[])paramArrayOfT.clone();
  }

  static <T> T[] a(T[] paramArrayOfT, int paramInt)
  {
    return (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), paramInt);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Platform
 * JD-Core Version:    0.6.2
 */