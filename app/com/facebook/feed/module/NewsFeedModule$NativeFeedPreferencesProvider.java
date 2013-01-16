package com.facebook.feed.module;

import com.facebook.orca.activity.IProvidePreferences;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$NativeFeedPreferencesProvider extends AbstractProvider<IProvidePreferences>
{
  private NewsFeedModule$NativeFeedPreferencesProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public IProvidePreferences a()
  {
    return new NewsFeedModule.NativeFeedPreferencesProvider.1(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.NativeFeedPreferencesProvider
 * JD-Core Version:    0.6.0
 */