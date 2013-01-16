package com.facebook.katana.service.method;

public abstract interface ServiceOperationListener
{
  public abstract void a(ServiceOperation paramServiceOperation, long paramLong1, long paramLong2);

  public abstract void a_(ServiceOperation paramServiceOperation, int paramInt, String paramString, Exception paramException);

  public abstract void b(ServiceOperation paramServiceOperation, int paramInt, String paramString, Exception paramException);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.ServiceOperationListener
 * JD-Core Version:    0.6.0
 */