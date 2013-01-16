package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$FriendListFeedEdge
{
  public static final GraphQlQueryFriendListFeedEdge.FriendListFeedEdgeField a = new GraphQlQueryFriendListFeedEdge.FriendListFeedEdgeField("cursor");
  public static final GraphQlQueryFriendListFeedEdge.FriendListFeedEdgeField b = new GraphQlQueryFriendListFeedEdge.FriendListFeedEdgeField("sort_key");

  public static GraphQlQueryFriendListFeedEdge.FriendListFeedEdgeField a(GraphQlQueryFeedUnit paramGraphQlQueryFeedUnit)
  {
    return new GraphQlQueryFriendListFeedEdge.FriendListFeedEdgeField("node", paramGraphQlQueryFeedUnit);
  }

  public static GraphQlQueryFriendListFeedEdge a(GraphQlQueryFriendListFeedEdge.FriendListFeedEdgeField[] paramArrayOfFriendListFeedEdgeField)
  {
    return new GraphQlQueryFriendListFeedEdge(ImmutableList.a(paramArrayOfFriendListFeedEdgeField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.FriendListFeedEdge
 * JD-Core Version:    0.6.2
 */