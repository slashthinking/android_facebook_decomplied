package com.facebook.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.orca.common.util.Clock;

class AnalyticsLogger$TimeChangeReceiver extends BroadcastReceiver
{
  AnalyticsLogger$TimeChangeReceiver(AnalyticsLogger paramAnalyticsLogger)
  {
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AnalyticsLogger.a(this.a, TimeSpentAnalyticsClientEvent.Dispatch.CLOCK_RESET);
    AnalyticsLogger.b(this.a, AnalyticsLogger.g(this.a).a());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsLogger.TimeChangeReceiver
 * JD-Core Version:    0.6.2
 */