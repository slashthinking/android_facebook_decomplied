package com.google.common.base;

public final class Strings
{
  public static String emptyToNull(String paramString)
  {
    if (isNullOrEmpty(paramString))
      paramString = null;
    return paramString;
  }

  public static boolean isNullOrEmpty(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public static String nullToEmpty(String paramString)
  {
    if (paramString == null)
      paramString = "";
    return paramString;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.Strings
 * JD-Core Version:    0.6.2
 */