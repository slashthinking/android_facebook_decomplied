package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$PageStarRatersConnection
{
  public static final GraphQlQueryPageStarRatersConnection.PageStarRatersConnectionField a = new GraphQlQueryPageStarRatersConnection.PageStarRatersConnectionField("count");

  public static GraphQlQueryCallIsViewerFriend0 a()
  {
    return new GraphQlQueryCallIsViewerFriend0();
  }

  public static GraphQlQueryPageStarRatersConnection.PageStarRatersConnectionField a(GraphQlQueryPageStarRatersEdge paramGraphQlQueryPageStarRatersEdge)
  {
    return new GraphQlQueryPageStarRatersConnection.PageStarRatersConnectionField("edges", paramGraphQlQueryPageStarRatersEdge);
  }

  public static GraphQlQueryPageStarRatersConnection a(GraphQlQueryPageStarRatersConnection.CallOnPageStarRatersConnection[] paramArrayOfCallOnPageStarRatersConnection)
  {
    return new GraphQlQueryPageStarRatersConnection(ImmutableList.a(paramArrayOfCallOnPageStarRatersConnection), null, null);
  }

  public static GraphQlQueryPageStarRatersConnection a(GraphQlQueryPageStarRatersConnection.PageStarRatersConnectionField[] paramArrayOfPageStarRatersConnectionField)
  {
    return new GraphQlQueryPageStarRatersConnection(null, ImmutableList.a(paramArrayOfPageStarRatersConnectionField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.PageStarRatersConnection
 * JD-Core Version:    0.6.2
 */