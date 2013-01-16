package com.facebook.analytics;

import android.content.Context;
import android.content.Intent;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.debug.BLog;

public class AnalyticsServiceManager
  implements INeedInit
{
  private static final Class<?> a = AnalyticsServiceManager.class;
  private final Context b;
  private final AnalyticsServiceManager.AnalyticsServiceConnection c;
  private IAnalyticsService d;

  public AnalyticsServiceManager(Context paramContext)
  {
    this.b = paramContext;
    this.c = new AnalyticsServiceManager.AnalyticsServiceConnection(this, null);
  }

  private void c()
  {
    if (this.d == null)
    {
      Intent localIntent = new Intent(this.b, AnalyticsService.class);
      if (!this.b.bindService(localIntent, this.c, 1))
        BLog.e(a, "Failed to bind to the analytics service.");
    }
  }

  public IAnalyticsService b()
  {
    return this.d;
  }

  public void i_()
  {
    c();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsServiceManager
 * JD-Core Version:    0.6.2
 */