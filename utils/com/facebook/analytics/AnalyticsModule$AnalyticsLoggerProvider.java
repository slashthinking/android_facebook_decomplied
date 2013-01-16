package com.facebook.analytics;

import android.os.PowerManager;
import android.view.WindowManager;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.annotations.MeUserId;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;

class AnalyticsModule$AnalyticsLoggerProvider extends AbstractProvider<AnalyticsLogger>
{
  private AnalyticsModule$AnalyticsLoggerProvider(AnalyticsModule paramAnalyticsModule)
  {
  }

  public AnalyticsLogger a()
  {
    return new AnalyticsLogger(AnalyticsModule.a(this.a), a(String.class, MeUserId.class), (AnalyticsConfig)b(AnalyticsConfig.class), (AndroidThreadUtil)b(AndroidThreadUtil.class), a(AnalyticsServiceOperation.class), (PowerManager)b(PowerManager.class, FromApplication.class), (WindowManager)b(WindowManager.class, FromApplication.class), (Clock)b(Clock.class), (AnalyticsDeviceUtils)b(AnalyticsDeviceUtils.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsModule.AnalyticsLoggerProvider
 * JD-Core Version:    0.6.2
 */