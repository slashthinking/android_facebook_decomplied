package com.facebook.analytics;

import com.facebook.orca.debug.BLog;
import com.fasterxml.jackson.databind.JsonNode;

class AnalyticsLogger$4
  implements Runnable
{
  AnalyticsLogger$4(AnalyticsLogger paramAnalyticsLogger, HoneyAnalyticsEvent paramHoneyAnalyticsEvent)
  {
  }

  public void run()
  {
    if ((AnalyticsLogger.a(this.b).a() == AnalyticsConfig.Level.CORE_AND_SAMPLED) || ((AnalyticsLogger.b(this.b)) && (AnalyticsLogger.c(this.b) == AnalyticsConfig.Level.CORE_AND_SAMPLED)) || (AnalyticsLogger.c(this.b, this.a)))
      AnalyticsLogger.d(this.b, this.a);
    while (true)
    {
      return;
      BLog.b(AnalyticsLogger.f(), "Event not logged: " + this.a.e().toString());
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsLogger.4
 * JD-Core Version:    0.6.2
 */