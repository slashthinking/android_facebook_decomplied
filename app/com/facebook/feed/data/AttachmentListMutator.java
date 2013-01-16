package com.facebook.feed.data;

import com.facebook.graphql.model.FeedStoryAttachment;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import java.util.List;

public class AttachmentListMutator
{
  public ImmutableList<FeedStoryAttachment> a(List<FeedStoryAttachment> paramList, FeedStoryAttachment paramFeedStoryAttachment)
  {
    Preconditions.checkNotNull(paramList);
    Preconditions.checkNotNull(paramFeedStoryAttachment);
    ImmutableList.Builder localBuilder = new ImmutableList.Builder();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      FeedStoryAttachment localFeedStoryAttachment = (FeedStoryAttachment)localIterator.next();
      if (localFeedStoryAttachment.equals(paramFeedStoryAttachment))
        localFeedStoryAttachment = paramFeedStoryAttachment;
      localBuilder.b(localFeedStoryAttachment);
    }
    return localBuilder.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.data.AttachmentListMutator
 * JD-Core Version:    0.6.0
 */