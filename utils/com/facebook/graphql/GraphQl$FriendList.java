package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$FriendList
{
  public static final GraphQlQueryFriendList.FriendListField a = new GraphQlQueryFriendList.FriendListField("id");
  public static final GraphQlQueryFriendList.FriendListField b = new GraphQlQueryFriendList.FriendListField("url.site(mobile)");
  public static final GraphQlQueryFriendList.FriendListField c = new GraphQlQueryFriendList.FriendListField("name");
  public static final GraphQlQueryFriendList.FriendListField d = new GraphQlQueryFriendList.FriendListField("list_type");

  public static GraphQlQueryFriendList.FriendListField a(GraphQlQueryFriendListFeedConnection paramGraphQlQueryFriendListFeedConnection)
  {
    return new GraphQlQueryFriendList.FriendListField("list_feed", paramGraphQlQueryFriendListFeedConnection);
  }

  public static GraphQlQueryFriendList a(GraphQlQueryFriendList.FriendListField[] paramArrayOfFriendListField)
  {
    return new GraphQlQueryFriendList(ImmutableList.a(paramArrayOfFriendListField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.FriendList
 * JD-Core Version:    0.6.2
 */