package com.facebook.analytics;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class AnalyticsServiceManager$AnalyticsServiceConnection
  implements ServiceConnection
{
  private AnalyticsServiceManager$AnalyticsServiceConnection(AnalyticsServiceManager paramAnalyticsServiceManager)
  {
  }

  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AnalyticsServiceManager.a(this.a, IAnalyticsService.Stub.a(paramIBinder));
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    AnalyticsServiceManager.a(this.a, null);
    AnalyticsServiceManager.a(this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsServiceManager.AnalyticsServiceConnection
 * JD-Core Version:    0.6.2
 */