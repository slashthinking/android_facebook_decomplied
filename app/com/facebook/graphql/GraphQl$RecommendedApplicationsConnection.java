package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$RecommendedApplicationsConnection
{
  public static final GraphQlQueryRecommendedApplicationsConnection.RecommendedApplicationsConnectionField a = new GraphQlQueryRecommendedApplicationsConnection.RecommendedApplicationsConnectionField("count");

  public static GraphQlQueryCallFirst1 a(long paramLong)
  {
    return new GraphQlQueryCallFirst1(paramLong);
  }

  public static GraphQlQueryCallOrderby1 a(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallOrderby1(paramGraphQlQueryParam);
  }

  public static GraphQlQueryCallPlatform1 a(String paramString)
  {
    return new GraphQlQueryCallPlatform1(paramString);
  }

  public static GraphQlQueryRecommendedApplicationsConnection.RecommendedApplicationsConnectionField a(GraphQlQueryApplication paramGraphQlQueryApplication)
  {
    return new GraphQlQueryRecommendedApplicationsConnection.RecommendedApplicationsConnectionField("nodes", paramGraphQlQueryApplication);
  }

  public static GraphQlQueryRecommendedApplicationsConnection a(GraphQlQueryRecommendedApplicationsConnection.CallOnRecommendedApplicationsConnection[] paramArrayOfCallOnRecommendedApplicationsConnection)
  {
    return new GraphQlQueryRecommendedApplicationsConnection(ImmutableList.a(paramArrayOfCallOnRecommendedApplicationsConnection), null, null);
  }

  public static GraphQlQueryCallCategory1 b(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallCategory1(paramGraphQlQueryParam);
  }

  public static GraphQlQueryCallEnvironment1 b(String paramString)
  {
    return new GraphQlQueryCallEnvironment1(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.RecommendedApplicationsConnection
 * JD-Core Version:    0.6.0
 */