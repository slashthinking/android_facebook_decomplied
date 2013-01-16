package com.facebook.ipc.feed;

import com.facebook.base.BuildConstants;
import com.facebook.ipc.intent.FacebookOnlyIntentActionFactory;
import com.facebook.orca.inject.AbstractProvider;

class FeedIpcModule$FacebookOnlyIntentActionFactoryProvider extends AbstractProvider<FacebookOnlyIntentActionFactory>
{
  private FeedIpcModule$FacebookOnlyIntentActionFactoryProvider(FeedIpcModule paramFeedIpcModule)
  {
  }

  public FacebookOnlyIntentActionFactory a()
  {
    return new FacebookOnlyIntentActionFactory(BuildConstants.c());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.feed.FeedIpcModule.FacebookOnlyIntentActionFactoryProvider
 * JD-Core Version:    0.6.0
 */