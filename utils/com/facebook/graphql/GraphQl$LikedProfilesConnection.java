package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$LikedProfilesConnection
{
  public static final GraphQlQueryLikedProfilesConnection.LikedProfilesConnectionField a = new GraphQlQueryLikedProfilesConnection.LikedProfilesConnectionField("count");

  public static GraphQlQueryCallFirst1 a(long paramLong)
  {
    return new GraphQlQueryCallFirst1(paramLong);
  }

  public static GraphQlQueryLikedProfilesConnection.LikedProfilesConnectionField a(GraphQlQueryProfile paramGraphQlQueryProfile)
  {
    return new GraphQlQueryLikedProfilesConnection.LikedProfilesConnectionField("nodes", paramGraphQlQueryProfile);
  }

  public static GraphQlQueryLikedProfilesConnection a(GraphQlQueryLikedProfilesConnection.CallOnLikedProfilesConnection[] paramArrayOfCallOnLikedProfilesConnection)
  {
    return new GraphQlQueryLikedProfilesConnection(ImmutableList.a(paramArrayOfCallOnLikedProfilesConnection), null, null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.LikedProfilesConnection
 * JD-Core Version:    0.6.2
 */