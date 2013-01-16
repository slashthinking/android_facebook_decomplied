package com.facebook.analytics;

import com.facebook.orca.database.DbPropertyUtil;

public class AnalyticsPropertyUtil extends DbPropertyUtil<AnalyticsDbPropertyKey>
{
  public AnalyticsPropertyUtil(AnalyticsDatabaseSupplier paramAnalyticsDatabaseSupplier)
  {
    super(paramAnalyticsDatabaseSupplier, "analytics_db_properties");
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsPropertyUtil
 * JD-Core Version:    0.6.2
 */