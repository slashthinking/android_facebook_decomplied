package com.facebook.feed.module;

import com.facebook.feed.data.FeedbackMutator;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$FeedbackMutatorProvider extends AbstractProvider<FeedbackMutator>
{
  private NewsFeedModule$FeedbackMutatorProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public FeedbackMutator a()
  {
    return new FeedbackMutator();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.FeedbackMutatorProvider
 * JD-Core Version:    0.6.0
 */