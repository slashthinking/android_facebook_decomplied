package com.facebook.ipc.feed;

import com.facebook.ipc.intent.FacebookOnlyIntentActionFactory;
import com.facebook.orca.inject.AbstractProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

class FeedIpcModule$ViewPermalinkIntentFactoryProvider extends AbstractProvider<ViewPermalinkIntentFactory>
{
  private FeedIpcModule$ViewPermalinkIntentFactoryProvider(FeedIpcModule paramFeedIpcModule)
  {
  }

  public ViewPermalinkIntentFactory a()
  {
    return new ViewPermalinkIntentFactory((FacebookOnlyIntentActionFactory)b(FacebookOnlyIntentActionFactory.class), (ObjectMapper)b(ObjectMapper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.feed.FeedIpcModule.ViewPermalinkIntentFactoryProvider
 * JD-Core Version:    0.6.0
 */