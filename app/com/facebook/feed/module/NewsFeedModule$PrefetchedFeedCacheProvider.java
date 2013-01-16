package com.facebook.feed.module;

import com.facebook.feed.cache.PrefetchedFeedCache;
import com.facebook.feed.db.DbPrefetchFeedHandler;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$PrefetchedFeedCacheProvider extends AbstractProvider<PrefetchedFeedCache>
{
  private NewsFeedModule$PrefetchedFeedCacheProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public PrefetchedFeedCache a()
  {
    return new PrefetchedFeedCache((DbPrefetchFeedHandler)b(DbPrefetchFeedHandler.class), (Clock)b(Clock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.PrefetchedFeedCacheProvider
 * JD-Core Version:    0.6.0
 */