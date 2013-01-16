package com.facebook.feed.module;

import android.app.Activity;
import android.content.Context;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.feed.renderer.IFeedUnitRenderer;
import com.facebook.feed.ui.FeedAdapterFactory;
import com.facebook.feed.ui.FeedImageLoader;
import com.facebook.feed.ui.FeedStoryMenuHelper;
import com.facebook.feed.ui.FeedUnitViewFactory;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.megaphone.data.MegaphoneStore;
import com.facebook.orca.annotations.DefaultExecutorService;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.task.IncrementalTaskExecutor;
import java.util.concurrent.ExecutorService;

class NewsFeedModule$FeedAdapterFactoryProvider extends AbstractProvider<FeedAdapterFactory>
{
  private NewsFeedModule$FeedAdapterFactoryProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public FeedAdapterFactory a()
  {
    return new FeedAdapterFactory((Context)b(Activity.class), (IFeedUnitRenderer)b(IFeedUnitRenderer.class), (FeedImageLoader)b(FeedImageLoader.class), (IncrementalTaskExecutor)b(IncrementalTaskExecutor.class), (FeedEventBus)b(FeedEventBus.class), (FeedStoryMenuHelper)b(FeedStoryMenuHelper.class), (MegaphoneStore)b(MegaphoneStore.class), (FbErrorReporter)b(FbErrorReporter.class), (FeedUnitViewFactory)b(FeedUnitViewFactory.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class), (ExecutorService)b(ExecutorService.class, DefaultExecutorService.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.FeedAdapterFactoryProvider
 * JD-Core Version:    0.6.0
 */