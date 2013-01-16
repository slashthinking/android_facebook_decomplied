package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$SimilarApplicationsConnection
{
  public static final GraphQlQuerySimilarApplicationsConnection.SimilarApplicationsConnectionField a = new GraphQlQuerySimilarApplicationsConnection.SimilarApplicationsConnectionField("count");

  public static GraphQlQueryCallFirst1 a(long paramLong)
  {
    return new GraphQlQueryCallFirst1(paramLong);
  }

  public static GraphQlQuerySimilarApplicationsConnection.SimilarApplicationsConnectionField a(GraphQlQueryApplication paramGraphQlQueryApplication)
  {
    return new GraphQlQuerySimilarApplicationsConnection.SimilarApplicationsConnectionField("nodes", paramGraphQlQueryApplication);
  }

  public static GraphQlQuerySimilarApplicationsConnection a(GraphQlQuerySimilarApplicationsConnection.CallOnSimilarApplicationsConnection[] paramArrayOfCallOnSimilarApplicationsConnection)
  {
    return new GraphQlQuerySimilarApplicationsConnection(ImmutableList.a(paramArrayOfCallOnSimilarApplicationsConnection), null, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.SimilarApplicationsConnection
 * JD-Core Version:    0.6.0
 */