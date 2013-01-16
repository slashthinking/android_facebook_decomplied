package com.facebook.analytics;

public enum AnalyticsConfig$Level
{
  static
  {
    CORE = new Level("CORE", 1);
    CORE_AND_SAMPLED = new Level("CORE_AND_SAMPLED", 2);
    UNSET = new Level("UNSET", 3);
    Level[] arrayOfLevel = new Level[4];
    arrayOfLevel[0] = NONE;
    arrayOfLevel[1] = CORE;
    arrayOfLevel[2] = CORE_AND_SAMPLED;
    arrayOfLevel[3] = UNSET;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsConfig.Level
 * JD-Core Version:    0.6.2
 */