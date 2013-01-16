package com.facebook.analytics;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class AnalyticsServiceOperation$AnalyticsServiceConnection
  implements ServiceConnection
{
  private AnalyticsServiceOperation$AnalyticsServiceConnection(AnalyticsServiceOperation paramAnalyticsServiceOperation)
  {
  }

  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    IAnalyticsService localIAnalyticsService = IAnalyticsService.Stub.a(paramIBinder);
    AnalyticsServiceOperation.a(this.a, localIAnalyticsService);
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsServiceOperation.AnalyticsServiceConnection
 * JD-Core Version:    0.6.2
 */