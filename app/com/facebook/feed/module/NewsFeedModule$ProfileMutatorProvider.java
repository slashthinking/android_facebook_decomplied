package com.facebook.feed.module;

import com.facebook.feed.data.ProfileMutator;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$ProfileMutatorProvider extends AbstractProvider<ProfileMutator>
{
  private NewsFeedModule$ProfileMutatorProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public ProfileMutator a()
  {
    return new ProfileMutator();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.ProfileMutatorProvider
 * JD-Core Version:    0.6.0
 */