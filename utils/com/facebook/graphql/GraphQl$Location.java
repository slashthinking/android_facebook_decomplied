package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$Location
{
  public static final GraphQlQueryLocation.LocationField a = new GraphQlQueryLocation.LocationField("latitude");
  public static final GraphQlQueryLocation.LocationField b = new GraphQlQueryLocation.LocationField("longitude");
  public static final GraphQlQueryLocation.LocationField c = new GraphQlQueryLocation.LocationField("timezone");

  public static GraphQlQueryLocation a(GraphQlQueryLocation.LocationField[] paramArrayOfLocationField)
  {
    return new GraphQlQueryLocation(ImmutableList.a(paramArrayOfLocationField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.Location
 * JD-Core Version:    0.6.2
 */