package com.google.common.base;

public final class Preconditions
{
  private static String badElementIndex(int paramInt1, int paramInt2, String paramString)
  {
    Object[] arrayOfObject2;
    if (paramInt1 < 0)
    {
      arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = paramString;
      arrayOfObject2[1] = Integer.valueOf(paramInt1);
    }
    Object[] arrayOfObject1;
    for (String str = format("%s (%s) must not be negative", arrayOfObject2); ; str = format("%s (%s) must be less than size (%s)", arrayOfObject1))
    {
      return str;
      if (paramInt2 < 0)
        throw new IllegalArgumentException("negative size: " + paramInt2);
      arrayOfObject1 = new Object[3];
      arrayOfObject1[0] = paramString;
      arrayOfObject1[1] = Integer.valueOf(paramInt1);
      arrayOfObject1[2] = Integer.valueOf(paramInt2);
    }
  }

  private static String badPositionIndex(int paramInt1, int paramInt2, String paramString)
  {
    Object[] arrayOfObject2;
    if (paramInt1 < 0)
    {
      arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = paramString;
      arrayOfObject2[1] = Integer.valueOf(paramInt1);
    }
    Object[] arrayOfObject1;
    for (String str = format("%s (%s) must not be negative", arrayOfObject2); ; str = format("%s (%s) must not be greater than size (%s)", arrayOfObject1))
    {
      return str;
      if (paramInt2 < 0)
        throw new IllegalArgumentException("negative size: " + paramInt2);
      arrayOfObject1 = new Object[3];
      arrayOfObject1[0] = paramString;
      arrayOfObject1[1] = Integer.valueOf(paramInt1);
      arrayOfObject1[2] = Integer.valueOf(paramInt2);
    }
  }

  private static String badPositionIndexes(int paramInt1, int paramInt2, int paramInt3)
  {
    String str;
    if ((paramInt1 < 0) || (paramInt1 > paramInt3))
      str = badPositionIndex(paramInt1, paramInt3, "start index");
    while (true)
    {
      return str;
      if ((paramInt2 < 0) || (paramInt2 > paramInt3))
      {
        str = badPositionIndex(paramInt2, paramInt3, "end index");
      }
      else
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Integer.valueOf(paramInt2);
        arrayOfObject[1] = Integer.valueOf(paramInt1);
        str = format("end index (%s) must not be less than start index (%s)", arrayOfObject);
      }
    }
  }

  public static void checkArgument(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException();
  }

  public static void checkArgument(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException(String.valueOf(paramObject));
  }

  public static void checkArgument(boolean paramBoolean, String paramString, Object[] paramArrayOfObject)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException(format(paramString, paramArrayOfObject));
  }

  public static int checkElementIndex(int paramInt1, int paramInt2)
  {
    return checkElementIndex(paramInt1, paramInt2, "index");
  }

  public static int checkElementIndex(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 < 0) || (paramInt1 >= paramInt2))
      throw new IndexOutOfBoundsException(badElementIndex(paramInt1, paramInt2, paramString));
    return paramInt1;
  }

  public static <T> T checkNotNull(T paramT)
  {
    if (paramT == null)
      throw new NullPointerException();
    return paramT;
  }

  public static <T> T checkNotNull(T paramT, Object paramObject)
  {
    if (paramT == null)
      throw new NullPointerException(String.valueOf(paramObject));
    return paramT;
  }

  public static <T> T checkNotNull(T paramT, String paramString, Object[] paramArrayOfObject)
  {
    if (paramT == null)
      throw new NullPointerException(format(paramString, paramArrayOfObject));
    return paramT;
  }

  public static int checkPositionIndex(int paramInt1, int paramInt2)
  {
    return checkPositionIndex(paramInt1, paramInt2, "index");
  }

  public static int checkPositionIndex(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 < 0) || (paramInt1 > paramInt2))
      throw new IndexOutOfBoundsException(badPositionIndex(paramInt1, paramInt2, paramString));
    return paramInt1;
  }

  public static void checkPositionIndexes(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt2 < paramInt1) || (paramInt2 > paramInt3))
      throw new IndexOutOfBoundsException(badPositionIndexes(paramInt1, paramInt2, paramInt3));
  }

  public static void checkState(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new IllegalStateException();
  }

  public static void checkState(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
      throw new IllegalStateException(String.valueOf(paramObject));
  }

  public static void checkState(boolean paramBoolean, String paramString, Object[] paramArrayOfObject)
  {
    if (!paramBoolean)
      throw new IllegalStateException(format(paramString, paramArrayOfObject));
  }

  static String format(String paramString, Object[] paramArrayOfObject)
  {
    int i = 0;
    String str = String.valueOf(paramString);
    StringBuilder localStringBuilder = new StringBuilder(str.length() + 16 * paramArrayOfObject.length);
    int j = 0;
    while (true)
    {
      int i1;
      if (i < paramArrayOfObject.length)
      {
        i1 = str.indexOf("%s", j);
        if (i1 != -1);
      }
      else
      {
        localStringBuilder.append(str.substring(j));
        if (i >= paramArrayOfObject.length)
          break label181;
        localStringBuilder.append(" [");
        int k = i + 1;
        localStringBuilder.append(paramArrayOfObject[i]);
        int n;
        for (int m = k; m < paramArrayOfObject.length; m = n)
        {
          localStringBuilder.append(", ");
          n = m + 1;
          localStringBuilder.append(paramArrayOfObject[m]);
        }
      }
      localStringBuilder.append(str.substring(j, i1));
      int i2 = i + 1;
      localStringBuilder.append(paramArrayOfObject[i]);
      j = i1 + 2;
      i = i2;
    }
    localStringBuilder.append(']');
    label181: return localStringBuilder.toString();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.Preconditions
 * JD-Core Version:    0.6.2
 */