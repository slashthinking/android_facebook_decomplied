package com.google.common.base;

public final class Ascii
{
  public static boolean isUpperCase(char paramChar)
  {
    if ((paramChar >= 'A') && (paramChar <= 'Z'));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public static char toLowerCase(char paramChar)
  {
    if (isUpperCase(paramChar))
      paramChar = (char)(paramChar ^ 0x20);
    return paramChar;
  }

  public static String toLowerCase(String paramString)
  {
    int i = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(i);
    for (int j = 0; j < i; j++)
      localStringBuilder.append(toLowerCase(paramString.charAt(j)));
    return localStringBuilder.toString();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.Ascii
 * JD-Core Version:    0.6.2
 */