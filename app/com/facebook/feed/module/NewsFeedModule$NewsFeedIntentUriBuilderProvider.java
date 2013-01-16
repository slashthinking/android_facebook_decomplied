package com.facebook.feed.module;

import com.facebook.feed.NewsFeedIntentUriBuilder;
import com.facebook.feed.annotations.IsNativeNewsFeedEnabled;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$NewsFeedIntentUriBuilderProvider extends AbstractProvider<NewsFeedIntentUriBuilder>
{
  private NewsFeedModule$NewsFeedIntentUriBuilderProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public NewsFeedIntentUriBuilder a()
  {
    return new NewsFeedIntentUriBuilder(a(Boolean.class, IsNativeNewsFeedEnabled.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.NewsFeedIntentUriBuilderProvider
 * JD-Core Version:    0.6.0
 */