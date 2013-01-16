package com.facebook.analytics;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ReliabilityAnalyticsClientEvent
{
  public static HoneyClientEvent a(String paramString1, String paramString2, Map<String, String> paramMap, String paramString3, String paramString4)
  {
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent(paramString1.toLowerCase());
    localHoneyClientEvent.b("status", paramString2.toLowerCase());
    if (paramString3 != null)
      localHoneyClientEvent.e(paramString3);
    if (paramString4 != null)
      localHoneyClientEvent.f(paramString4);
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localHoneyClientEvent.b((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    return localHoneyClientEvent;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.ReliabilityAnalyticsClientEvent
 * JD-Core Version:    0.6.2
 */