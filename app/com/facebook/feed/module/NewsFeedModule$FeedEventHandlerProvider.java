package com.facebook.feed.module;

import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$FeedEventHandlerProvider extends AbstractProvider<FeedEventBus>
{
  private NewsFeedModule$FeedEventHandlerProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public FeedEventBus a()
  {
    return new FeedEventBus();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.FeedEventHandlerProvider
 * JD-Core Version:    0.6.0
 */