package com.facebook.debug;

public final class LogPrefixer
{
  public static final String a(Class<?> paramClass)
  {
    return "fb:" + paramClass.getSimpleName();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.debug.LogPrefixer
 * JD-Core Version:    0.6.0
 */