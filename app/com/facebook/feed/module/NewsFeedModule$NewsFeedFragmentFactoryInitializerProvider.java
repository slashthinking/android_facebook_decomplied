package com.facebook.feed.module;

import com.facebook.feed.activity.NewsFeedFragmentFactoryInitializer;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$NewsFeedFragmentFactoryInitializerProvider extends AbstractProvider<NewsFeedFragmentFactoryInitializer>
{
  private NewsFeedModule$NewsFeedFragmentFactoryInitializerProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public NewsFeedFragmentFactoryInitializer a()
  {
    return new NewsFeedFragmentFactoryInitializer();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.NewsFeedFragmentFactoryInitializerProvider
 * JD-Core Version:    0.6.0
 */