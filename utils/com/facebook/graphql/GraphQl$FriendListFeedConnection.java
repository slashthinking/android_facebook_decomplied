package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$FriendListFeedConnection
{
  public static final GraphQlQueryFriendListFeedConnection.FriendListFeedConnectionField a = new GraphQlQueryFriendListFeedConnection.FriendListFeedConnectionField("count");

  public static GraphQlQueryCallAfter1 a(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallAfter1(paramGraphQlQueryParam);
  }

  public static GraphQlQueryFriendListFeedConnection.FriendListFeedConnectionField a(GraphQlQueryFriendListFeedEdge paramGraphQlQueryFriendListFeedEdge)
  {
    return new GraphQlQueryFriendListFeedConnection.FriendListFeedConnectionField("edges", paramGraphQlQueryFriendListFeedEdge);
  }

  public static GraphQlQueryFriendListFeedConnection.FriendListFeedConnectionField a(GraphQlQueryPageInfo paramGraphQlQueryPageInfo)
  {
    return new GraphQlQueryFriendListFeedConnection.FriendListFeedConnectionField("page_info", paramGraphQlQueryPageInfo);
  }

  public static GraphQlQueryFriendListFeedConnection a(GraphQlQueryFriendListFeedConnection.CallOnFriendListFeedConnection[] paramArrayOfCallOnFriendListFeedConnection)
  {
    return new GraphQlQueryFriendListFeedConnection(ImmutableList.a(paramArrayOfCallOnFriendListFeedConnection), null, null);
  }

  public static GraphQlQueryCallBefore1 b(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallBefore1(paramGraphQlQueryParam);
  }

  public static GraphQlQueryCallFirst1 c(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallFirst1(paramGraphQlQueryParam);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.FriendListFeedConnection
 * JD-Core Version:    0.6.2
 */