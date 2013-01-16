package com.facebook.katana.orca;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import com.facebook.katana.feed.impl.DefaultFeedIntentBuilder;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidAppModule$NewsFeedIntentBuilderProvider extends AbstractProvider<IFeedIntentBuilder>
{
  private FbandroidAppModule$NewsFeedIntentBuilderProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public IFeedIntentBuilder a()
  {
    return new DefaultFeedIntentBuilder(FbandroidAppModule.a(this.a), (ViewPermalinkIntentFactory)b(ViewPermalinkIntentFactory.class), (FbErrorReporter)b(FbErrorReporter.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.NewsFeedIntentBuilderProvider
 * JD-Core Version:    0.6.0
 */