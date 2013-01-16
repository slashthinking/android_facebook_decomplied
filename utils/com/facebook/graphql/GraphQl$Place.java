package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$Place
{
  public static final GraphQlQueryPlaceImpl.PlaceGenericField a = new GraphQlQueryPlaceImpl.PlaceGenericField("name");
  public static final GraphQlQueryPlaceImpl.PlaceGenericField b = new GraphQlQueryPlaceImpl.PlaceGenericField("place_type");

  public static GraphQlQueryPlaceImpl.PlaceGenericField a(GraphQlQueryLocation paramGraphQlQueryLocation)
  {
    return new GraphQlQueryPlaceImpl.PlaceGenericField("location", paramGraphQlQueryLocation);
  }

  public static GraphQlQueryPlaceImpl a(GraphQlQueryFieldPlace[] paramArrayOfGraphQlQueryFieldPlace)
  {
    return new GraphQlQueryPlaceImpl(ImmutableList.a(paramArrayOfGraphQlQueryFieldPlace), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.Place
 * JD-Core Version:    0.6.2
 */