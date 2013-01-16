package com.facebook.analytics;

import java.util.Iterator;
import java.util.Queue;

class AnalyticsLogger$3
  implements Runnable
{
  AnalyticsLogger$3(AnalyticsLogger paramAnalyticsLogger, Queue paramQueue)
  {
  }

  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      HoneyAnalyticsEvent localHoneyAnalyticsEvent = (HoneyAnalyticsEvent)localIterator.next();
      if (localHoneyAnalyticsEvent.a("startup_core"))
        AnalyticsLogger.a(this.b, localHoneyAnalyticsEvent);
      else
        AnalyticsLogger.b(this.b, localHoneyAnalyticsEvent);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsLogger.3
 * JD-Core Version:    0.6.2
 */