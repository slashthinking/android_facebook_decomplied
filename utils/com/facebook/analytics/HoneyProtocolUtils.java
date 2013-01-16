package com.facebook.analytics;

import com.facebook.orca.common.util.StringLocaleUtil;

public class HoneyProtocolUtils
{
  public static String a(long paramLong)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Double.valueOf(paramLong / 1000.0D);
    return StringLocaleUtil.a("%.3f", arrayOfObject);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.HoneyProtocolUtils
 * JD-Core Version:    0.6.2
 */