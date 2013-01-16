package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$FeaturedFriendsConnection
{
  public static final GraphQlQueryFeaturedFriendsConnection.FeaturedFriendsConnectionField a = new GraphQlQueryFeaturedFriendsConnection.FeaturedFriendsConnectionField("count");

  public static GraphQlQueryCallFirst1 a(long paramLong)
  {
    return new GraphQlQueryCallFirst1(paramLong);
  }

  public static GraphQlQueryFeaturedFriendsConnection.FeaturedFriendsConnectionField a(GraphQlQueryUser paramGraphQlQueryUser)
  {
    return new GraphQlQueryFeaturedFriendsConnection.FeaturedFriendsConnectionField("nodes", paramGraphQlQueryUser);
  }

  public static GraphQlQueryFeaturedFriendsConnection a(GraphQlQueryFeaturedFriendsConnection.CallOnFeaturedFriendsConnection[] paramArrayOfCallOnFeaturedFriendsConnection)
  {
    return new GraphQlQueryFeaturedFriendsConnection(ImmutableList.a(paramArrayOfCallOnFeaturedFriendsConnection), null, null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.FeaturedFriendsConnection
 * JD-Core Version:    0.6.2
 */