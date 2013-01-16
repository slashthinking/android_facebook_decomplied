package com.karmascience.gifts;

import android.content.Context;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.inject.FbInjector;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AnalyticsWrapper
{
  private final AnalyticsLogger a;
  private String b;
  private String c;

  public AnalyticsWrapper(Context paramContext)
  {
    this.a = ((AnalyticsLogger)FbInjector.a(paramContext).a(AnalyticsLogger.class));
  }

  private void a(AnalyticsWrapper.MetricsEvent paramMetricsEvent)
  {
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent(AnalyticsWrapper.MetricsEvent.a(paramMetricsEvent));
    localHoneyClientEvent.d("gifts");
    AnalyticsWrapper.MetricsEvent.b(paramMetricsEvent).put("sender_id", this.c);
    AnalyticsWrapper.MetricsEvent.b(paramMetricsEvent).put("recipient_id", this.b);
    Iterator localIterator = AnalyticsWrapper.MetricsEvent.b(paramMetricsEvent).keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHoneyClientEvent.b(str, (String)AnalyticsWrapper.MetricsEvent.b(paramMetricsEvent).get(str));
    }
    this.a.a(localHoneyClientEvent);
  }

  public void a(String paramString)
  {
    this.b = paramString;
  }

  public void b(String paramString)
  {
    this.c = paramString;
  }

  public AnalyticsWrapper.MetricsEvent c(String paramString)
  {
    return new AnalyticsWrapper.MetricsEvent(paramString, this, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.AnalyticsWrapper
 * JD-Core Version:    0.6.0
 */