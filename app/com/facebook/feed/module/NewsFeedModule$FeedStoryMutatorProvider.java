package com.facebook.feed.module;

import com.facebook.feed.data.ActionLinkListMutator;
import com.facebook.feed.data.ActionLinkMutator;
import com.facebook.feed.data.AttachmentListMutator;
import com.facebook.feed.data.AttachmentMutator;
import com.facebook.feed.data.FeedStoryMutator;
import com.facebook.feed.data.FeedbackMutator;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$FeedStoryMutatorProvider extends AbstractProvider<FeedStoryMutator>
{
  private NewsFeedModule$FeedStoryMutatorProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public FeedStoryMutator a()
  {
    return new FeedStoryMutator((FeedbackMutator)b(FeedbackMutator.class), (AttachmentMutator)b(AttachmentMutator.class), (AttachmentListMutator)b(AttachmentListMutator.class), (ActionLinkMutator)b(ActionLinkMutator.class), (ActionLinkListMutator)b(ActionLinkListMutator.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.FeedStoryMutatorProvider
 * JD-Core Version:    0.6.0
 */