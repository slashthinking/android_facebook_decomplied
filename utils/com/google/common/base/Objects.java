package com.google.common.base;

import java.util.Arrays;

public final class Objects
{
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2))));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public static <T> T firstNonNull(T paramT1, T paramT2)
  {
    if (paramT1 != null);
    while (true)
    {
      return paramT1;
      paramT1 = Preconditions.checkNotNull(paramT2);
    }
  }

  public static int hashCode(Object[] paramArrayOfObject)
  {
    return Arrays.hashCode(paramArrayOfObject);
  }

  private static String simpleName(Class<?> paramClass)
  {
    String str = paramClass.getName().replaceAll("\\$[0-9]+", "\\$");
    int i = str.lastIndexOf('$');
    if (i == -1)
      i = str.lastIndexOf('.');
    return str.substring(i + 1);
  }

  public static Objects.ToStringHelper toStringHelper(Class<?> paramClass)
  {
    return new Objects.ToStringHelper(simpleName(paramClass), null);
  }

  public static Objects.ToStringHelper toStringHelper(Object paramObject)
  {
    return new Objects.ToStringHelper(simpleName(paramObject.getClass()), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.Objects
 * JD-Core Version:    0.6.2
 */