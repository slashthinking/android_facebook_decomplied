package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$NewsFeedEdge
{
  public static final GraphQlQueryNewsFeedEdge.NewsFeedEdgeField a = new GraphQlQueryNewsFeedEdge.NewsFeedEdgeField("cursor");
  public static final GraphQlQueryNewsFeedEdge.NewsFeedEdgeField b = new GraphQlQueryNewsFeedEdge.NewsFeedEdgeField("sort_key");
  public static final GraphQlQueryNewsFeedEdge.NewsFeedEdgeField c = new GraphQlQueryNewsFeedEdge.NewsFeedEdgeField("deduplication_key");

  @Deprecated
  public static final GraphQlQueryNewsFeedEdge.NewsFeedEdgeField d = new GraphQlQueryNewsFeedEdge.NewsFeedEdgeField("view_time");

  @Deprecated
  public static final GraphQlQueryNewsFeedEdge.NewsFeedEdgeField e = new GraphQlQueryNewsFeedEdge.NewsFeedEdgeField("position");

  public static GraphQlQueryNewsFeedEdge.NewsFeedEdgeField a(GraphQlQueryFeedUnit paramGraphQlQueryFeedUnit)
  {
    return new GraphQlQueryNewsFeedEdge.NewsFeedEdgeField("node", paramGraphQlQueryFeedUnit);
  }

  public static GraphQlQueryNewsFeedEdge a(GraphQlQueryNewsFeedEdge.NewsFeedEdgeField[] paramArrayOfNewsFeedEdgeField)
  {
    return new GraphQlQueryNewsFeedEdge(ImmutableList.a(paramArrayOfNewsFeedEdgeField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.NewsFeedEdge
 * JD-Core Version:    0.6.2
 */