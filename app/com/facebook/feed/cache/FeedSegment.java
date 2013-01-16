package com.facebook.feed.cache;

import com.facebook.graphql.model.FeedUnitEdge;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.List;

public class FeedSegment
{
  private final ImmutableList<FeedUnitEdge> a;
  private final GraphQLPageInfo b;
  private boolean c;
  private final long d;

  public FeedSegment(List<FeedUnitEdge> paramList, GraphQLPageInfo paramGraphQLPageInfo, long paramLong, boolean paramBoolean)
  {
    this.a = ImmutableList.a((Collection)Preconditions.checkNotNull(paramList));
    this.b = paramGraphQLPageInfo;
    this.d = paramLong;
    this.c = paramBoolean;
  }

  public GraphQLPageInfo a()
  {
    return this.b;
  }

  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public ImmutableList<FeedUnitEdge> b()
  {
    return this.a;
  }

  public String c()
  {
    return this.b.endCursor;
  }

  public String d()
  {
    return this.b.startCursor;
  }

  public int e()
  {
    return this.a.size();
  }

  public boolean f()
  {
    return this.c;
  }

  public long g()
  {
    return this.d;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.cache.FeedSegment
 * JD-Core Version:    0.6.0
 */