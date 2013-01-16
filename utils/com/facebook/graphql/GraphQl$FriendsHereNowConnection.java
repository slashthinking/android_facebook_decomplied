package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$FriendsHereNowConnection
{
  public static final GraphQlQueryFriendsHereNowConnection.FriendsHereNowConnectionField a = new GraphQlQueryFriendsHereNowConnection.FriendsHereNowConnectionField("count");

  public static GraphQlQueryCallFirst1 a(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallFirst1(paramGraphQlQueryParam);
  }

  public static GraphQlQueryFriendsHereNowConnection.FriendsHereNowConnectionField a(GraphQlQueryUser paramGraphQlQueryUser)
  {
    return new GraphQlQueryFriendsHereNowConnection.FriendsHereNowConnectionField("nodes", paramGraphQlQueryUser);
  }

  public static GraphQlQueryFriendsHereNowConnection a(GraphQlQueryFriendsHereNowConnection.CallOnFriendsHereNowConnection[] paramArrayOfCallOnFriendsHereNowConnection)
  {
    return new GraphQlQueryFriendsHereNowConnection(ImmutableList.a(paramArrayOfCallOnFriendsHereNowConnection), null, null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.FriendsHereNowConnection
 * JD-Core Version:    0.6.2
 */