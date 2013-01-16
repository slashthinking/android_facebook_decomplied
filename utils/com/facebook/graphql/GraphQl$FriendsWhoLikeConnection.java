package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$FriendsWhoLikeConnection
{
  public static final GraphQlQueryFriendsWhoLikeConnection.FriendsWhoLikeConnectionField a = new GraphQlQueryFriendsWhoLikeConnection.FriendsWhoLikeConnectionField("count");

  public static GraphQlQueryCallFirst1 a(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallFirst1(paramGraphQlQueryParam);
  }

  public static GraphQlQueryCallLast1 a(long paramLong)
  {
    return new GraphQlQueryCallLast1(paramLong);
  }

  public static GraphQlQueryFriendsWhoLikeConnection.FriendsWhoLikeConnectionField a(GraphQlQueryUser paramGraphQlQueryUser)
  {
    return new GraphQlQueryFriendsWhoLikeConnection.FriendsWhoLikeConnectionField("nodes", paramGraphQlQueryUser);
  }

  public static GraphQlQueryFriendsWhoLikeConnection a(GraphQlQueryFriendsWhoLikeConnection.CallOnFriendsWhoLikeConnection[] paramArrayOfCallOnFriendsWhoLikeConnection)
  {
    return new GraphQlQueryFriendsWhoLikeConnection(ImmutableList.a(paramArrayOfCallOnFriendsWhoLikeConnection), null, null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.FriendsWhoLikeConnection
 * JD-Core Version:    0.6.2
 */