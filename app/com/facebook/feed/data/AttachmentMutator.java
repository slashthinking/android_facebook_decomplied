package com.facebook.feed.data;

import com.facebook.graphql.model.FeedStoryAttachment;
import com.facebook.graphql.model.FeedStoryAttachmentBuilder;
import com.facebook.graphql.model.GraphQLActionLink;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

public class AttachmentMutator
{
  private final ActionLinkMutator a;
  private final ActionLinkListMutator b;

  public AttachmentMutator(ActionLinkMutator paramActionLinkMutator, ActionLinkListMutator paramActionLinkListMutator)
  {
    this.a = paramActionLinkMutator;
    this.b = paramActionLinkListMutator;
  }

  public FeedStoryAttachment a(FeedStoryAttachment paramFeedStoryAttachment, GraphQLActionLink paramGraphQLActionLink)
  {
    Preconditions.checkNotNull(paramFeedStoryAttachment);
    Preconditions.checkNotNull(paramFeedStoryAttachment.actionLinks);
    GraphQLActionLink localGraphQLActionLink = this.a.a(paramGraphQLActionLink);
    ImmutableList localImmutableList = this.b.a(paramFeedStoryAttachment.actionLinks, localGraphQLActionLink);
    FeedStoryAttachmentBuilder localFeedStoryAttachmentBuilder = new FeedStoryAttachmentBuilder(paramFeedStoryAttachment);
    localFeedStoryAttachmentBuilder.a(localImmutableList);
    return localFeedStoryAttachmentBuilder.k();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.data.AttachmentMutator
 * JD-Core Version:    0.6.0
 */