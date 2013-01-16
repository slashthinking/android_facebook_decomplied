package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$FriendListsConnection
{
  public static final GraphQlQueryFriendListsConnection.FriendListsConnectionField a = new GraphQlQueryFriendListsConnection.FriendListsConnectionField("count");

  public static GraphQlQueryCallWithMember1 a(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallWithMember1(paramGraphQlQueryParam);
  }

  public static GraphQlQueryFriendListsConnection.FriendListsConnectionField a(GraphQlQueryFriendList paramGraphQlQueryFriendList)
  {
    return new GraphQlQueryFriendListsConnection.FriendListsConnectionField("nodes", paramGraphQlQueryFriendList);
  }

  public static GraphQlQueryFriendListsConnection a(GraphQlQueryFriendListsConnection.CallOnFriendListsConnection[] paramArrayOfCallOnFriendListsConnection)
  {
    return new GraphQlQueryFriendListsConnection(ImmutableList.a(paramArrayOfCallOnFriendListsConnection), null, null);
  }

  public static GraphQlQueryFriendListsConnection a(GraphQlQueryFriendListsConnection.FriendListsConnectionField[] paramArrayOfFriendListsConnectionField)
  {
    return new GraphQlQueryFriendListsConnection(null, ImmutableList.a(paramArrayOfFriendListsConnectionField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.FriendListsConnection
 * JD-Core Version:    0.6.2
 */