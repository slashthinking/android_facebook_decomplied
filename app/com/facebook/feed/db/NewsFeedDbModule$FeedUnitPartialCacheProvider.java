package com.facebook.feed.db;

import com.facebook.feed.cache.FeedUnitPartialCache;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedDbModule$FeedUnitPartialCacheProvider extends AbstractProvider<FeedUnitPartialCache>
{
  public FeedUnitPartialCache a()
  {
    return new FeedUnitPartialCache((AndroidThreadUtil)b(AndroidThreadUtil.class), (DbFeedbackHandler)b(DbFeedbackHandler.class), (DbFeedUnitPartialHandler)b(DbFeedUnitPartialHandler.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.NewsFeedDbModule.FeedUnitPartialCacheProvider
 * JD-Core Version:    0.6.0
 */