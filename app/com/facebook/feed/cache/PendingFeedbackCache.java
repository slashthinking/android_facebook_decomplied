package com.facebook.feed.cache;

import com.facebook.common.collect.MapWithSecondaryOrdering;
import com.facebook.feed.util.FeedCommentComparator;
import com.facebook.graphql.model.FeedComment;
import com.facebook.graphql.model.FeedCommentBuilder;
import com.facebook.graphql.model.FeedOptimisticPublishState;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.FeedbackBuilder;
import com.google.common.base.Preconditions;
import java.util.List;

public class PendingFeedbackCache
{
  private final MapWithSecondaryOrdering<String, FeedComment> a = new MapWithSecondaryOrdering(FeedCommentComparator.a);

  public int a()
  {
    return this.a.size();
  }

  public FeedComment a(String paramString)
  {
    return (FeedComment)this.a.get(paramString);
  }

  public void a(String paramString, FeedComment paramFeedComment)
  {
    this.a.put(Preconditions.checkNotNull(paramString), Preconditions.checkNotNull(paramFeedComment));
  }

  public void a(String paramString1, String paramString2)
  {
    if (!this.a.containsKey(Preconditions.checkNotNull(paramString1)));
    while (true)
    {
      return;
      FeedComment localFeedComment1 = (FeedComment)this.a.get(paramString1);
      Feedback localFeedback = FeedbackBuilder.c(paramString2);
      FeedComment localFeedComment2 = new FeedCommentBuilder(localFeedComment1).a(localFeedback).a(FeedOptimisticPublishState.SUCCESS).g();
      this.a.put(paramString1, localFeedComment2);
    }
  }

  public List<FeedComment> b()
  {
    return this.a.a();
  }

  public void b(String paramString)
  {
    if (paramString == null);
    while (true)
    {
      return;
      this.a.remove(paramString);
    }
  }

  public void c()
  {
    this.a.clear();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.cache.PendingFeedbackCache
 * JD-Core Version:    0.6.0
 */