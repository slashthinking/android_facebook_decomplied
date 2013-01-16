package com.facebook.common.util;

public abstract interface FbErrorReporter
{
  public abstract void a(String paramString);

  public abstract void a(String paramString1, String paramString2);

  public abstract void a(String paramString1, String paramString2, Throwable paramThrowable);

  public abstract void a(String paramString1, String paramString2, Throwable paramThrowable, boolean paramBoolean);

  public abstract void a(String paramString1, String paramString2, Throwable paramThrowable, boolean paramBoolean, int paramInt);

  public abstract void a(String paramString1, String paramString2, boolean paramBoolean);

  public abstract void b(String paramString);

  public abstract void b(String paramString1, String paramString2);

  public abstract void c(String paramString);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.util.FbErrorReporter
 * JD-Core Version:    0.6.0
 */