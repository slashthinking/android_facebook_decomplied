package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$PhoneNumber
{
  public static final GraphQlQueryPhoneNumber.PhoneNumberField a = new GraphQlQueryPhoneNumber.PhoneNumberField("universal_number");
  public static final GraphQlQueryPhoneNumber.PhoneNumberField b = new GraphQlQueryPhoneNumber.PhoneNumberField("display_number");

  public static GraphQlQueryPhoneNumber a(GraphQlQueryPhoneNumber.PhoneNumberField[] paramArrayOfPhoneNumberField)
  {
    return new GraphQlQueryPhoneNumber(ImmutableList.a(paramArrayOfPhoneNumberField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.PhoneNumber
 * JD-Core Version:    0.6.2
 */