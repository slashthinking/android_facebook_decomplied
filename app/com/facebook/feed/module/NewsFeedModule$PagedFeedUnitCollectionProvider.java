package com.facebook.feed.module;

import com.facebook.feed.cache.PendingStoryCache;
import com.facebook.feed.cache.PendingStoryFragmentCache;
import com.facebook.feed.data.PagedFeedUnitCollection;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$PagedFeedUnitCollectionProvider extends AbstractProvider<PagedFeedUnitCollection>
{
  private NewsFeedModule$PagedFeedUnitCollectionProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public PagedFeedUnitCollection a()
  {
    return new PagedFeedUnitCollection((PendingStoryCache)b(PendingStoryCache.class, PendingStoryFragmentCache.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.PagedFeedUnitCollectionProvider
 * JD-Core Version:    0.6.0
 */