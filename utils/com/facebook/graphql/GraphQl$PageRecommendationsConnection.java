package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$PageRecommendationsConnection
{
  public static final GraphQlQueryPageRecommendationsConnection.PageRecommendationsConnectionField a = new GraphQlQueryPageRecommendationsConnection.PageRecommendationsConnectionField("count");

  public static GraphQlQueryCallCreatedByViewerFriend0 a()
  {
    return new GraphQlQueryCallCreatedByViewerFriend0();
  }

  public static GraphQlQueryCallFirst1 a(long paramLong)
  {
    return new GraphQlQueryCallFirst1(paramLong);
  }

  public static GraphQlQueryCallFirst1 a(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallFirst1(paramGraphQlQueryParam);
  }

  public static GraphQlQueryPageRecommendationsConnection.PageRecommendationsConnectionField a(GraphQlQueryContactRecommendationField paramGraphQlQueryContactRecommendationField)
  {
    return new GraphQlQueryPageRecommendationsConnection.PageRecommendationsConnectionField("nodes", paramGraphQlQueryContactRecommendationField);
  }

  public static GraphQlQueryPageRecommendationsConnection a(GraphQlQueryPageRecommendationsConnection.CallOnPageRecommendationsConnection[] paramArrayOfCallOnPageRecommendationsConnection)
  {
    return new GraphQlQueryPageRecommendationsConnection(ImmutableList.a(paramArrayOfCallOnPageRecommendationsConnection), null, null);
  }

  public static GraphQlQueryCallCreatedByViewerNonfriend0 b()
  {
    return new GraphQlQueryCallCreatedByViewerNonfriend0();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.PageRecommendationsConnection
 * JD-Core Version:    0.6.2
 */