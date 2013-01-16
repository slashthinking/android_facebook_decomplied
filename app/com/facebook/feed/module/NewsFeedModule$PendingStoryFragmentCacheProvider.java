package com.facebook.feed.module;

import com.facebook.feed.cache.PendingStoryCache;
import com.facebook.feed.cache.PendingStoryCentralCache;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$PendingStoryFragmentCacheProvider extends AbstractProvider<PendingStoryCache>
{
  private NewsFeedModule$PendingStoryFragmentCacheProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public PendingStoryCache a()
  {
    return new PendingStoryCache((PendingStoryCache)b(PendingStoryCache.class, PendingStoryCentralCache.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.PendingStoryFragmentCacheProvider
 * JD-Core Version:    0.6.0
 */