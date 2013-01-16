package com.facebook.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class AnalyticsLogger$6 extends BroadcastReceiver
{
  AnalyticsLogger$6(AnalyticsLogger paramAnalyticsLogger)
  {
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (isInitialStickyBroadcast());
    while (true)
    {
      return;
      if (!AnalyticsLogger.d(this.a))
        AnalyticsLogger.a(this.a, paramContext);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsLogger.6
 * JD-Core Version:    0.6.2
 */