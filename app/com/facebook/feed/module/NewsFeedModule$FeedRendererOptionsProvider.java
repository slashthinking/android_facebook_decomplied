package com.facebook.feed.module;

import com.facebook.feed.prefs.FeedRendererOptions;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class NewsFeedModule$FeedRendererOptionsProvider extends AbstractProvider<FeedRendererOptions>
{
  private NewsFeedModule$FeedRendererOptionsProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public FeedRendererOptions a()
  {
    return new FeedRendererOptions((OrcaSharedPreferences)b(OrcaSharedPreferences.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.FeedRendererOptionsProvider
 * JD-Core Version:    0.6.0
 */