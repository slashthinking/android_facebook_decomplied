package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$FriendsWhoVisitedConnection
{
  public static final GraphQlQueryFriendsWhoVisitedConnection.FriendsWhoVisitedConnectionField a = new GraphQlQueryFriendsWhoVisitedConnection.FriendsWhoVisitedConnectionField("count");

  public static GraphQlQueryCallFirst1 a(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallFirst1(paramGraphQlQueryParam);
  }

  public static GraphQlQueryFriendsWhoVisitedConnection.FriendsWhoVisitedConnectionField a(GraphQlQueryUser paramGraphQlQueryUser)
  {
    return new GraphQlQueryFriendsWhoVisitedConnection.FriendsWhoVisitedConnectionField("nodes", paramGraphQlQueryUser);
  }

  public static GraphQlQueryFriendsWhoVisitedConnection a(GraphQlQueryFriendsWhoVisitedConnection.CallOnFriendsWhoVisitedConnection[] paramArrayOfCallOnFriendsWhoVisitedConnection)
  {
    return new GraphQlQueryFriendsWhoVisitedConnection(ImmutableList.a(paramArrayOfCallOnFriendsWhoVisitedConnection), null, null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.FriendsWhoVisitedConnection
 * JD-Core Version:    0.6.2
 */