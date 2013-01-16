package com.facebook.feed.db;

import com.facebook.feed.cache.FastJsonNodeParser;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedDbModule$DbPagesYouMayLikeFeedUnitPartialSerializationProvider extends AbstractProvider<DbPagesYouMayLikeFeedUnitPartialSerialization>
{
  private NewsFeedDbModule$DbPagesYouMayLikeFeedUnitPartialSerializationProvider(NewsFeedDbModule paramNewsFeedDbModule)
  {
  }

  public DbPagesYouMayLikeFeedUnitPartialSerialization a()
  {
    return new DbPagesYouMayLikeFeedUnitPartialSerialization((FastJsonNodeParser)b(FastJsonNodeParser.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.NewsFeedDbModule.DbPagesYouMayLikeFeedUnitPartialSerializationProvider
 * JD-Core Version:    0.6.0
 */