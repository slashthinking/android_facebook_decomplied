package com.facebook.graphql;

public class GraphQl$RecommendedApplicationsFeedUnit
{
  public static final GraphQlQueryRecommendedApplicationsFeedUnit.RecommendedApplicationsFeedUnitField a = new GraphQlQueryRecommendedApplicationsFeedUnit.RecommendedApplicationsFeedUnitField("debug_info");
  public static final GraphQlQueryRecommendedApplicationsFeedUnit.RecommendedApplicationsFeedUnitField b = new GraphQlQueryRecommendedApplicationsFeedUnit.RecommendedApplicationsFeedUnitField("cache_id");

  public static GraphQlQueryRecommendedApplicationsFeedUnit.RecommendedApplicationsFeedUnitField a(GraphQlQueryRecommendedApplicationsFeedUnitItem paramGraphQlQueryRecommendedApplicationsFeedUnitItem)
  {
    return new GraphQlQueryRecommendedApplicationsFeedUnit.RecommendedApplicationsFeedUnitField("items", paramGraphQlQueryRecommendedApplicationsFeedUnitItem);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.RecommendedApplicationsFeedUnit
 * JD-Core Version:    0.6.0
 */