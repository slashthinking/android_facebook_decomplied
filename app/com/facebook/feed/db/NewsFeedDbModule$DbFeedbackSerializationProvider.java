package com.facebook.feed.db;

import com.facebook.feed.cache.FastJsonNodeParser;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedDbModule$DbFeedbackSerializationProvider extends AbstractProvider<DbFeedbackSerialization>
{
  private NewsFeedDbModule$DbFeedbackSerializationProvider(NewsFeedDbModule paramNewsFeedDbModule)
  {
  }

  public DbFeedbackSerialization a()
  {
    return new DbFeedbackSerialization((FastJsonNodeParser)b(FastJsonNodeParser.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.NewsFeedDbModule.DbFeedbackSerializationProvider
 * JD-Core Version:    0.6.0
 */