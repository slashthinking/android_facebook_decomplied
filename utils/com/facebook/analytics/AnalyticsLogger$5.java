package com.facebook.analytics;

class AnalyticsLogger$5
  implements Runnable
{
  AnalyticsLogger$5(AnalyticsLogger paramAnalyticsLogger, HoneyAnalyticsEvent paramHoneyAnalyticsEvent)
  {
  }

  public void run()
  {
    if ((AnalyticsLogger.a(this.b).a() == AnalyticsConfig.Level.CORE) || (AnalyticsLogger.a(this.b).a() == AnalyticsConfig.Level.CORE_AND_SAMPLED) || (AnalyticsLogger.c(this.b, this.a)) || ((AnalyticsLogger.b(this.b)) && ((AnalyticsLogger.c(this.b) == AnalyticsConfig.Level.CORE) || (AnalyticsLogger.c(this.b) == AnalyticsConfig.Level.CORE_AND_SAMPLED))))
      AnalyticsLogger.d(this.b, this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsLogger.5
 * JD-Core Version:    0.6.2
 */