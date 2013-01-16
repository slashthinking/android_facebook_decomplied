package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$PageStarRatersEdge
{
  public static final GraphQlQueryPageStarRatersEdge.PageStarRatersEdgeField a = new GraphQlQueryPageStarRatersEdge.PageStarRatersEdgeField("cursor");
  public static final GraphQlQueryPageStarRatersEdge.PageStarRatersEdgeField b = new GraphQlQueryPageStarRatersEdge.PageStarRatersEdgeField("rating");

  public static GraphQlQueryPageStarRatersEdge.PageStarRatersEdgeField a(GraphQlQueryUser paramGraphQlQueryUser)
  {
    return new GraphQlQueryPageStarRatersEdge.PageStarRatersEdgeField("node", paramGraphQlQueryUser);
  }

  public static GraphQlQueryPageStarRatersEdge a(GraphQlQueryPageStarRatersEdge.PageStarRatersEdgeField[] paramArrayOfPageStarRatersEdgeField)
  {
    return new GraphQlQueryPageStarRatersEdge(ImmutableList.a(paramArrayOfPageStarRatersEdgeField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.PageStarRatersEdge
 * JD-Core Version:    0.6.2
 */