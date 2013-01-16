package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$StreetAddress
{
  public static final GraphQlQueryStreetAddress.StreetAddressField a = new GraphQlQueryStreetAddress.StreetAddressField("street");
  public static final GraphQlQueryStreetAddress.StreetAddressField b = new GraphQlQueryStreetAddress.StreetAddressField("city");
  public static final GraphQlQueryStreetAddress.StreetAddressField c = new GraphQlQueryStreetAddress.StreetAddressField("postal_code");
  public static final GraphQlQueryStreetAddress.StreetAddressField d = new GraphQlQueryStreetAddress.StreetAddressField("country");
  public static final GraphQlQueryStreetAddress.StreetAddressField e = new GraphQlQueryStreetAddress.StreetAddressField("full_address");

  public static GraphQlQueryStreetAddress a(GraphQlQueryStreetAddress.StreetAddressField[] paramArrayOfStreetAddressField)
  {
    return new GraphQlQueryStreetAddress(ImmutableList.a(paramArrayOfStreetAddressField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.StreetAddress
 * JD-Core Version:    0.6.2
 */