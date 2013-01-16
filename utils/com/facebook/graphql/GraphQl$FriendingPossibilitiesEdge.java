package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$FriendingPossibilitiesEdge
{
  public static final GraphQlQueryFriendingPossibilitiesEdge.FriendingPossibilitiesEdgeField a = new GraphQlQueryFriendingPossibilitiesEdge.FriendingPossibilitiesEdgeField("cursor");
  public static final GraphQlQueryFriendingPossibilitiesEdge.FriendingPossibilitiesEdgeField b = new GraphQlQueryFriendingPossibilitiesEdge.FriendingPossibilitiesEdgeField("time");

  public static GraphQlQueryFriendingPossibilitiesEdge.FriendingPossibilitiesEdgeField a(GraphQlQueryUser paramGraphQlQueryUser)
  {
    return new GraphQlQueryFriendingPossibilitiesEdge.FriendingPossibilitiesEdgeField("node", paramGraphQlQueryUser);
  }

  public static GraphQlQueryFriendingPossibilitiesEdge a(GraphQlQueryFriendingPossibilitiesEdge.FriendingPossibilitiesEdgeField[] paramArrayOfFriendingPossibilitiesEdgeField)
  {
    return new GraphQlQueryFriendingPossibilitiesEdge(ImmutableList.a(paramArrayOfFriendingPossibilitiesEdgeField), null);
  }

  public static GraphQlQueryFriendingPossibilitiesEdge.FriendingPossibilitiesEdgeField b(GraphQlQueryUser paramGraphQlQueryUser)
  {
    return new GraphQlQueryFriendingPossibilitiesEdge.FriendingPossibilitiesEdgeField("suggesters", paramGraphQlQueryUser);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.FriendingPossibilitiesEdge
 * JD-Core Version:    0.6.2
 */