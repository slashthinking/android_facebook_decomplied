package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$FriendingPossibilitiesConnection
{
  public static final GraphQlQueryFriendingPossibilitiesConnection.FriendingPossibilitiesConnectionField a = new GraphQlQueryFriendingPossibilitiesConnection.FriendingPossibilitiesConnectionField("count");

  public static GraphQlQueryCallAfter1 a(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallAfter1(paramGraphQlQueryParam);
  }

  public static GraphQlQueryFriendingPossibilitiesConnection.FriendingPossibilitiesConnectionField a(GraphQlQueryFriendingPossibilitiesEdge paramGraphQlQueryFriendingPossibilitiesEdge)
  {
    return new GraphQlQueryFriendingPossibilitiesConnection.FriendingPossibilitiesConnectionField("edges", paramGraphQlQueryFriendingPossibilitiesEdge);
  }

  public static GraphQlQueryFriendingPossibilitiesConnection.FriendingPossibilitiesConnectionField a(GraphQlQueryPageInfo paramGraphQlQueryPageInfo)
  {
    return new GraphQlQueryFriendingPossibilitiesConnection.FriendingPossibilitiesConnectionField("page_info", paramGraphQlQueryPageInfo);
  }

  public static GraphQlQueryFriendingPossibilitiesConnection a(GraphQlQueryFriendingPossibilitiesConnection.CallOnFriendingPossibilitiesConnection[] paramArrayOfCallOnFriendingPossibilitiesConnection)
  {
    return new GraphQlQueryFriendingPossibilitiesConnection(ImmutableList.a(paramArrayOfCallOnFriendingPossibilitiesConnection), null, null);
  }

  public static GraphQlQueryCallFirst1 b(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallFirst1(paramGraphQlQueryParam);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.FriendingPossibilitiesConnection
 * JD-Core Version:    0.6.2
 */