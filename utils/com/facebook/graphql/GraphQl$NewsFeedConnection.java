package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$NewsFeedConnection
{
  public static final GraphQlQueryNewsFeedConnection.NewsFeedConnectionField a = new GraphQlQueryNewsFeedConnection.NewsFeedConnectionField("count");

  public static GraphQlQueryCallAfter1 a(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallAfter1(paramGraphQlQueryParam);
  }

  public static GraphQlQueryCallEnvironment1 a(String paramString)
  {
    return new GraphQlQueryCallEnvironment1(paramString);
  }

  public static GraphQlQueryNewsFeedConnection.NewsFeedConnectionField a(GraphQlQueryNewsFeedEdge paramGraphQlQueryNewsFeedEdge)
  {
    return new GraphQlQueryNewsFeedConnection.NewsFeedConnectionField("edges", paramGraphQlQueryNewsFeedEdge);
  }

  public static GraphQlQueryNewsFeedConnection.NewsFeedConnectionField a(GraphQlQueryPageInfo paramGraphQlQueryPageInfo)
  {
    return new GraphQlQueryNewsFeedConnection.NewsFeedConnectionField("page_info", paramGraphQlQueryPageInfo);
  }

  public static GraphQlQueryNewsFeedConnection a(GraphQlQueryNewsFeedConnection.CallOnNewsFeedConnection[] paramArrayOfCallOnNewsFeedConnection)
  {
    return new GraphQlQueryNewsFeedConnection(ImmutableList.a(paramArrayOfCallOnNewsFeedConnection), null, null);
  }

  public static GraphQlQueryCallBefore1 b(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallBefore1(paramGraphQlQueryParam);
  }

  public static GraphQlQueryCallFirst1 c(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallFirst1(paramGraphQlQueryParam);
  }

  public static GraphQlQueryCallOrderby1 d(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallOrderby1(paramGraphQlQueryParam);
  }

  public static GraphQlQueryCallStoryTypes1 e(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallStoryTypes1(paramGraphQlQueryParam);
  }

  public static GraphQlQueryCallViewMode1 f(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallViewMode1(paramGraphQlQueryParam);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.NewsFeedConnection
 * JD-Core Version:    0.6.2
 */