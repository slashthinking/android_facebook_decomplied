package com.facebook.orca.module;

import android.support.v4.content.LocalBroadcastManager;
import com.facebook.app.UserActivityManager;
import com.facebook.debug.UiThreadWatchdog;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class UiModule$UiThreadCheckerProvider extends AbstractProvider<UiThreadWatchdog>
{
  private UiModule$UiThreadCheckerProvider(UiModule paramUiModule)
  {
  }

  public UiThreadWatchdog a()
  {
    return new UiThreadWatchdog((UserActivityManager)b(UserActivityManager.class), (LocalBroadcastManager)b(LocalBroadcastManager.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class), (Clock)b(Clock.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.module.UiModule.UiThreadCheckerProvider
 * JD-Core Version:    0.6.2
 */