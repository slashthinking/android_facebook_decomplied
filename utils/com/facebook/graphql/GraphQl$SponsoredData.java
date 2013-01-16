package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$SponsoredData
{
  public static final GraphQlQuerySponsoredData.SponsoredDataField a = new GraphQlQuerySponsoredData.SponsoredDataField("impression_logging_url");
  public static final GraphQlQuerySponsoredData.SponsoredDataField b = new GraphQlQuerySponsoredData.SponsoredDataField("third_party_impression_logging_urls");
  public static final GraphQlQuerySponsoredData.SponsoredDataField c = new GraphQlQuerySponsoredData.SponsoredDataField("third_party_click_tracking_url");
  public static final GraphQlQuerySponsoredData.SponsoredDataField d = new GraphQlQuerySponsoredData.SponsoredDataField("is_non_connected_page_post");

  public static GraphQlQuerySponsoredData.SponsoredDataField a(GraphQlQueryUser paramGraphQlQueryUser)
  {
    return new GraphQlQuerySponsoredData.SponsoredDataField("user", paramGraphQlQueryUser);
  }

  public static GraphQlQuerySponsoredData a(GraphQlQuerySponsoredData.SponsoredDataField[] paramArrayOfSponsoredDataField)
  {
    return new GraphQlQuerySponsoredData(ImmutableList.a(paramArrayOfSponsoredDataField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.SponsoredData
 * JD-Core Version:    0.6.2
 */