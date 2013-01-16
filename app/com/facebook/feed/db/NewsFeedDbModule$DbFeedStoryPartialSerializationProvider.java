package com.facebook.feed.db;

import com.facebook.feed.cache.FastJsonNodeParser;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedDbModule$DbFeedStoryPartialSerializationProvider extends AbstractProvider<DbFeedStoryPartialSerialization>
{
  private NewsFeedDbModule$DbFeedStoryPartialSerializationProvider(NewsFeedDbModule paramNewsFeedDbModule)
  {
  }

  public DbFeedStoryPartialSerialization a()
  {
    return new DbFeedStoryPartialSerialization((FastJsonNodeParser)b(FastJsonNodeParser.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.NewsFeedDbModule.DbFeedStoryPartialSerializationProvider
 * JD-Core Version:    0.6.0
 */