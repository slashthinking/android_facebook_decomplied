package com.facebook.feed.module;

import com.facebook.feed.data.ActionLinkListMutator;
import com.facebook.feed.data.ActionLinkMutator;
import com.facebook.feed.data.AttachmentMutator;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$AttachmentMutatorProvider extends AbstractProvider<AttachmentMutator>
{
  private NewsFeedModule$AttachmentMutatorProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public AttachmentMutator a()
  {
    return new AttachmentMutator((ActionLinkMutator)b(ActionLinkMutator.class), (ActionLinkListMutator)b(ActionLinkListMutator.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.AttachmentMutatorProvider
 * JD-Core Version:    0.6.0
 */