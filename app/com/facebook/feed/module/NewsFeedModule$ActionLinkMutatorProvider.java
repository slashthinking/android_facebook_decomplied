package com.facebook.feed.module;

import com.facebook.feed.data.ActionLinkMutator;
import com.facebook.feed.data.ProfileMutator;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$ActionLinkMutatorProvider extends AbstractProvider<ActionLinkMutator>
{
  private NewsFeedModule$ActionLinkMutatorProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public ActionLinkMutator a()
  {
    return new ActionLinkMutator((ProfileMutator)b(ProfileMutator.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.ActionLinkMutatorProvider
 * JD-Core Version:    0.6.0
 */