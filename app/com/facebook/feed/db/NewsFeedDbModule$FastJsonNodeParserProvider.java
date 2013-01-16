package com.facebook.feed.db;

import com.facebook.feed.cache.FastJsonNodeParser;
import com.facebook.orca.inject.AbstractProvider;
import com.fasterxml.jackson.core.JsonFactory;

class NewsFeedDbModule$FastJsonNodeParserProvider extends AbstractProvider<FastJsonNodeParser>
{
  private NewsFeedDbModule$FastJsonNodeParserProvider(NewsFeedDbModule paramNewsFeedDbModule)
  {
  }

  public FastJsonNodeParser a()
  {
    return new FastJsonNodeParser((JsonFactory)b(JsonFactory.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.NewsFeedDbModule.FastJsonNodeParserProvider
 * JD-Core Version:    0.6.0
 */