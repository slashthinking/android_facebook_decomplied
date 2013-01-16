package com.facebook.analytics;

import com.google.common.collect.ImmutableMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ReliabilityAnalyticsLogger
{
  private final AnalyticsLogger a;

  public ReliabilityAnalyticsLogger(AnalyticsLogger paramAnalyticsLogger)
  {
    this.a = paramAnalyticsLogger;
  }

  public void a(String paramString1, String paramString2, int paramInt)
  {
    a("messaging_push_notif_" + paramString1, paramString2, ImmutableMap.a("total_deleted", Integer.toString(paramInt)), null, null);
  }

  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a("messaging_push_notif_" + paramString3, paramString4, ImmutableMap.a("thread_id", paramString2), "message_id", paramString1);
  }

  public void a(String paramString1, String paramString2, Map<String, String> paramMap, String paramString3, String paramString4)
  {
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent(paramString1.toLowerCase()).b("status", paramString2.toLowerCase());
    if (paramString4 != null)
      localHoneyClientEvent.f(paramString4);
    if (paramString3 != null)
      localHoneyClientEvent.e(paramString3);
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localHoneyClientEvent.b((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    this.a.a(localHoneyClientEvent);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.ReliabilityAnalyticsLogger
 * JD-Core Version:    0.6.2
 */