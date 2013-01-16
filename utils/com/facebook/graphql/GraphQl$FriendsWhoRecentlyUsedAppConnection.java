package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$FriendsWhoRecentlyUsedAppConnection
{
  public static final GraphQlQueryFriendsWhoRecentlyUsedAppConnection.FriendsWhoRecentlyUsedAppConnectionField a = new GraphQlQueryFriendsWhoRecentlyUsedAppConnection.FriendsWhoRecentlyUsedAppConnectionField("count");

  public static GraphQlQueryCallLast1 a(long paramLong)
  {
    return new GraphQlQueryCallLast1(paramLong);
  }

  public static GraphQlQueryFriendsWhoRecentlyUsedAppConnection.FriendsWhoRecentlyUsedAppConnectionField a(GraphQlQueryPageInfo paramGraphQlQueryPageInfo)
  {
    return new GraphQlQueryFriendsWhoRecentlyUsedAppConnection.FriendsWhoRecentlyUsedAppConnectionField("page_info", paramGraphQlQueryPageInfo);
  }

  public static GraphQlQueryFriendsWhoRecentlyUsedAppConnection.FriendsWhoRecentlyUsedAppConnectionField a(GraphQlQueryUser paramGraphQlQueryUser)
  {
    return new GraphQlQueryFriendsWhoRecentlyUsedAppConnection.FriendsWhoRecentlyUsedAppConnectionField("nodes", paramGraphQlQueryUser);
  }

  public static GraphQlQueryFriendsWhoRecentlyUsedAppConnection a(GraphQlQueryFriendsWhoRecentlyUsedAppConnection.CallOnFriendsWhoRecentlyUsedAppConnection[] paramArrayOfCallOnFriendsWhoRecentlyUsedAppConnection)
  {
    return new GraphQlQueryFriendsWhoRecentlyUsedAppConnection(ImmutableList.a(paramArrayOfCallOnFriendsWhoRecentlyUsedAppConnection), null, null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.FriendsWhoRecentlyUsedAppConnection
 * JD-Core Version:    0.6.2
 */