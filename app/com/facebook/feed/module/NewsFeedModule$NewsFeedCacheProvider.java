package com.facebook.feed.module;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.feed.cache.DefaultNewsFeedCache;
import com.facebook.feed.cache.NewsFeedCache;
import com.facebook.feed.data.FeedStoryMutator;
import com.facebook.feed.data.FeedbackMutator;
import com.facebook.feed.prefs.NewsFeedServerSuppliedParameters;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$NewsFeedCacheProvider extends AbstractProvider<NewsFeedCache>
{
  private NewsFeedModule$NewsFeedCacheProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public NewsFeedCache a()
  {
    return new DefaultNewsFeedCache((Clock)b(Clock.class), (NewsFeedServerSuppliedParameters)b(NewsFeedServerSuppliedParameters.class), (FeedbackMutator)b(FeedbackMutator.class), (FeedStoryMutator)b(FeedStoryMutator.class), (FbErrorReporter)b(FbErrorReporter.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.NewsFeedCacheProvider
 * JD-Core Version:    0.6.0
 */