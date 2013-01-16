package com.facebook.feed.db;

import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.orca.app.UserInteractionController;
import com.facebook.orca.inject.AbstractProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

class NewsFeedDbModule$DbFeedHomeStoriesSerializationProvider extends AbstractProvider<DbFeedHomeStoriesSerialization>
{
  private NewsFeedDbModule$DbFeedHomeStoriesSerializationProvider(NewsFeedDbModule paramNewsFeedDbModule)
  {
  }

  public DbFeedHomeStoriesSerialization a()
  {
    return new DbFeedHomeStoriesSerialization((ObjectMapper)b(ObjectMapper.class), (UserInteractionController)b(UserInteractionController.class), (PerformanceLogger)b(PerformanceLogger.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.NewsFeedDbModule.DbFeedHomeStoriesSerializationProvider
 * JD-Core Version:    0.6.0
 */