package com.facebook.analytics;

public enum TimeSpentAnalyticsClientEvent$Dispatch
{
  static
  {
    CLOCK_RESET = new Dispatch("CLOCK_RESET", 3);
    Dispatch[] arrayOfDispatch = new Dispatch[4];
    arrayOfDispatch[0] = FORCE;
    arrayOfDispatch[1] = FORCE_RESET;
    arrayOfDispatch[2] = PASSIVE;
    arrayOfDispatch[3] = CLOCK_RESET;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.TimeSpentAnalyticsClientEvent.Dispatch
 * JD-Core Version:    0.6.2
 */