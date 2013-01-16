package com.facebook.analytics.performance;

import com.facebook.analytics.HoneyClientEvent;
import com.facebook.debug.Assert;

class HoneyPerformanceEvent extends HoneyClientEvent
{
  public HoneyPerformanceEvent(String paramString1, String paramString2, String paramString3, double paramDouble, long paramLong, String paramString4)
  {
    super("perf");
    a(paramLong);
    Assert.a(paramString1);
    d(paramString1);
    Assert.a(paramString2);
    h(paramString2);
    Assert.a(paramString3);
    b("marker", paramString3);
    if (paramDouble != 0.0D)
      a("value", paramDouble);
    if (paramString4 != null)
      b("scenario", paramString4);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.performance.HoneyPerformanceEvent
 * JD-Core Version:    0.6.2
 */