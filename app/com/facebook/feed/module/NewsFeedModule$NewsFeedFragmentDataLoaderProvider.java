package com.facebook.feed.module;

import android.app.Activity;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.feed.annotations.IsNativeNewsFeedLogFetchErrorsEnabled;
import com.facebook.feed.annotations.IsNativeNewsFeedPrefetchEnabled;
import com.facebook.feed.cache.PendingStoryCache;
import com.facebook.feed.cache.PendingStoryCentralCache;
import com.facebook.feed.data.NewsFeedFragmentDataLoader;
import com.facebook.feed.prefs.NewsFeedServerSuppliedParameters;
import com.facebook.megaphone.data.MegaphoneStore;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.annotations.DefaultExecutorService;
import com.facebook.orca.annotations.MeUserId;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.net.OrcaNetworkManager;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import java.util.concurrent.ExecutorService;

class NewsFeedModule$NewsFeedFragmentDataLoaderProvider extends AbstractProvider<NewsFeedFragmentDataLoader>
{
  private NewsFeedModule$NewsFeedFragmentDataLoaderProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public NewsFeedFragmentDataLoader a()
  {
    return new NewsFeedFragmentDataLoader((FbFragmentActivity)b(Activity.class), (PerformanceLogger)b(PerformanceLogger.class), (MegaphoneStore)b(MegaphoneStore.class), (OrcaServiceOperationFactory)b(OrcaServiceOperationFactory.class), (OrcaNetworkManager)b(OrcaNetworkManager.class), (AndroidThreadUtil)b(AndroidThreadUtil.class), (PendingStoryCache)b(PendingStoryCache.class, PendingStoryCentralCache.class), a(String.class, MeUserId.class), (FbErrorReporter)b(FbErrorReporter.class), (NewsFeedServerSuppliedParameters)b(NewsFeedServerSuppliedParameters.class), a(Boolean.class, IsNativeNewsFeedPrefetchEnabled.class), a(Boolean.class, IsNativeNewsFeedLogFetchErrorsEnabled.class), (ExecutorService)b(ExecutorService.class, DefaultExecutorService.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.NewsFeedFragmentDataLoaderProvider
 * JD-Core Version:    0.6.0
 */