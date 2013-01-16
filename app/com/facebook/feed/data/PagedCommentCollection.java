package com.facebook.feed.data;

import com.facebook.feed.cache.PendingFeedbackCache;
import com.facebook.feed.util.FeedCommentComparator;
import com.facebook.graphql.model.FeedComment;
import com.facebook.graphql.model.GraphQLPageInfo;
import java.util.List;

public class PagedCommentCollection extends PagedGraphQLObjectCollection<FeedComment>
{
  public static final FeedComment a = new FeedComment();
  private final PendingFeedbackCache b;

  public PagedCommentCollection(PendingFeedbackCache paramPendingFeedbackCache)
  {
    super(FeedCommentComparator.a, a);
    this.b = paramPendingFeedbackCache;
  }

  public int a()
  {
    return super.a() + this.b.a();
  }

  public FeedComment a(int paramInt)
  {
    if (paramInt < super.a());
    for (FeedComment localFeedComment = (FeedComment)super.b(paramInt); ; localFeedComment = (FeedComment)this.b.b().get(paramInt - super.a()))
      return localFeedComment;
  }

  public void a(List<? extends FeedComment> paramList, GraphQLPageInfo paramGraphQLPageInfo)
  {
    if (!paramList.isEmpty())
      this.b.c();
    super.a(paramList, paramGraphQLPageInfo);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.data.PagedCommentCollection
 * JD-Core Version:    0.6.0
 */