package com.facebook.feed.db;

import com.facebook.graphql.model.FeedHomeStories;

class DbFeedResult
{
  static DbFeedResult a = new DbFeedResult(null, -1L);
  final FeedHomeStories b;
  final long c;

  DbFeedResult(FeedHomeStories paramFeedHomeStories, long paramLong)
  {
    this.b = paramFeedHomeStories;
    this.c = paramLong;
  }

  boolean a()
  {
    if ((this.b != null) && (this.c < System.currentTimeMillis()));
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.DbFeedResult
 * JD-Core Version:    0.6.0
 */