package com.facebook.feed.background;

import com.facebook.background.AbstractBackgroundTask;
import com.facebook.background.BackgroundResult;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.feed.cache.NewsFeedCache;
import com.facebook.feed.prefs.NewsFeedServerSuppliedParameters;
import com.facebook.hardware.ScreenPowerState;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.inject.Provider;

public class PrefetchNewsFeedBackgroundTask extends AbstractBackgroundTask
{
  public static Class<?> a = PrefetchNewsFeedBackgroundTask.class;
  private final Clock b;
  private final NewsFeedServerSuppliedParameters c;
  private final ScreenPowerState d;
  private final ExecutorService e;
  private PrefetchNewsFeedBackgroundTask.PrefetchNewsFeedWorker f = null;
  private boolean g = false;

  public PrefetchNewsFeedBackgroundTask(Clock paramClock, OrcaSharedPreferences paramOrcaSharedPreferences, NewsFeedServerSuppliedParameters paramNewsFeedServerSuppliedParameters, OrcaServiceOperationFactory paramOrcaServiceOperationFactory, NewsFeedCache paramNewsFeedCache, DeviceConditionHelper paramDeviceConditionHelper, ScreenPowerState paramScreenPowerState, ExecutorService paramExecutorService, Provider<Boolean> paramProvider, Provider<String> paramProvider1)
  {
    super("PREFETCH_NEWS_FEED");
    this.b = ((Clock)Preconditions.checkNotNull(paramClock));
    this.c = ((NewsFeedServerSuppliedParameters)Preconditions.checkNotNull(paramNewsFeedServerSuppliedParameters));
    this.d = ((ScreenPowerState)Preconditions.checkNotNull(paramScreenPowerState));
    this.e = ((ExecutorService)Preconditions.checkNotNull(paramExecutorService));
    this.f = new PrefetchNewsFeedBackgroundTask.PrefetchNewsFeedWorker(paramClock, paramOrcaSharedPreferences, paramNewsFeedServerSuppliedParameters, paramOrcaServiceOperationFactory, paramNewsFeedCache, paramDeviceConditionHelper, paramScreenPowerState, paramProvider, paramProvider1);
  }

  public boolean b()
  {
    return this.f.a();
  }

  public ListenableFuture<BackgroundResult> c()
  {
    if (!this.g)
    {
      this.d.a(new PrefetchNewsFeedBackgroundTask.1(this));
      this.g = true;
    }
    return this.f.b();
  }

  public long h()
  {
    return this.b.a() + this.c.c();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.background.PrefetchNewsFeedBackgroundTask
 * JD-Core Version:    0.6.0
 */