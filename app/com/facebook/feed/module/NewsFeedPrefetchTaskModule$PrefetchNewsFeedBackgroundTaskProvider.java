package com.facebook.feed.module;

import com.facebook.device.DeviceConditionHelper;
import com.facebook.feed.annotations.IsNativeNewsFeedPrefetchEnabled;
import com.facebook.feed.background.PrefetchNewsFeedBackgroundTask;
import com.facebook.feed.cache.NewsFeedCache;
import com.facebook.feed.prefs.NewsFeedServerSuppliedParameters;
import com.facebook.hardware.ScreenPowerState;
import com.facebook.orca.annotations.DefaultExecutorService;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.annotations.MeUserId;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import java.util.concurrent.ExecutorService;

class NewsFeedPrefetchTaskModule$PrefetchNewsFeedBackgroundTaskProvider extends AbstractProvider<PrefetchNewsFeedBackgroundTask>
{
  private NewsFeedPrefetchTaskModule$PrefetchNewsFeedBackgroundTaskProvider(NewsFeedPrefetchTaskModule paramNewsFeedPrefetchTaskModule)
  {
  }

  public PrefetchNewsFeedBackgroundTask a()
  {
    return new PrefetchNewsFeedBackgroundTask((Clock)b(Clock.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class), (NewsFeedServerSuppliedParameters)b(NewsFeedServerSuppliedParameters.class), (OrcaServiceOperationFactory)b(OrcaServiceOperationFactory.class, FromApplication.class), (NewsFeedCache)b(NewsFeedCache.class), (DeviceConditionHelper)b(DeviceConditionHelper.class), (ScreenPowerState)b(ScreenPowerState.class), (ExecutorService)b(ExecutorService.class, DefaultExecutorService.class), a(Boolean.class, IsNativeNewsFeedPrefetchEnabled.class), a(String.class, MeUserId.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedPrefetchTaskModule.PrefetchNewsFeedBackgroundTaskProvider
 * JD-Core Version:    0.6.0
 */