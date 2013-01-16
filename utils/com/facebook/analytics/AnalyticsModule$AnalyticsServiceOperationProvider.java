package com.facebook.analytics;

import android.content.Context;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;

class AnalyticsModule$AnalyticsServiceOperationProvider extends AbstractProvider<AnalyticsServiceOperation>
{
  private AnalyticsModule$AnalyticsServiceOperationProvider(AnalyticsModule paramAnalyticsModule)
  {
  }

  public AnalyticsServiceOperation a()
  {
    return new AnalyticsServiceOperation((Context)b(Context.class, FromApplication.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsModule.AnalyticsServiceOperationProvider
 * JD-Core Version:    0.6.2
 */