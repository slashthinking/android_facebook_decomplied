package com.facebook.analytics;

import java.net.URI;

public abstract interface NetworkDataLogger
{
  public abstract void a(URI paramURI, long paramLong);

  public abstract void a(URI paramURI, String paramString, long paramLong);

  public abstract void a(URI paramURI, String paramString, long paramLong1, long paramLong2);
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.NetworkDataLogger
 * JD-Core Version:    0.6.2
 */