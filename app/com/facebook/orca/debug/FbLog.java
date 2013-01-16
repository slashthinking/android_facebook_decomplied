package com.facebook.orca.debug;

public abstract interface FbLog
{
  public abstract int a(int paramInt, String paramString1, String paramString2);

  public abstract int a(WtfToken paramWtfToken, String paramString1, String paramString2);

  public abstract int a(WtfToken paramWtfToken, String paramString1, String paramString2, Throwable paramThrowable);

  public abstract int a(WtfToken paramWtfToken, String paramString, Throwable paramThrowable);

  public abstract int a(String paramString1, String paramString2);

  public abstract int a(String paramString1, String paramString2, Throwable paramThrowable);

  public abstract int a(String paramString, Throwable paramThrowable);

  public abstract int b(String paramString1, String paramString2);

  public abstract int b(String paramString1, String paramString2, Throwable paramThrowable);

  public abstract int c(String paramString1, String paramString2);

  public abstract int c(String paramString1, String paramString2, Throwable paramThrowable);

  public abstract int d(String paramString1, String paramString2);

  public abstract int d(String paramString1, String paramString2, Throwable paramThrowable);

  public abstract int e(String paramString1, String paramString2);

  public abstract int e(String paramString1, String paramString2, Throwable paramThrowable);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.debug.FbLog
 * JD-Core Version:    0.6.0
 */