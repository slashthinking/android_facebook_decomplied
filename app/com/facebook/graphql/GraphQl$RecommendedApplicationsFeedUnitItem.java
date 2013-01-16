package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$RecommendedApplicationsFeedUnitItem
{
  public static final GraphQlQueryRecommendedApplicationsFeedUnitItem.RecommendedApplicationsFeedUnitItemField a = new GraphQlQueryRecommendedApplicationsFeedUnitItem.RecommendedApplicationsFeedUnitItemField("tracking");

  public static GraphQlQueryRecommendedApplicationsFeedUnitItem.RecommendedApplicationsFeedUnitItemField a(GraphQlQueryApplication paramGraphQlQueryApplication)
  {
    return new GraphQlQueryRecommendedApplicationsFeedUnitItem.RecommendedApplicationsFeedUnitItemField("profile", paramGraphQlQueryApplication);
  }

  public static GraphQlQueryRecommendedApplicationsFeedUnitItem.RecommendedApplicationsFeedUnitItemField a(GraphQlQueryImage paramGraphQlQueryImage)
  {
    return new GraphQlQueryRecommendedApplicationsFeedUnitItem.RecommendedApplicationsFeedUnitItemField("banner", paramGraphQlQueryImage);
  }

  public static GraphQlQueryRecommendedApplicationsFeedUnitItem.RecommendedApplicationsFeedUnitItemField a(GraphQlQuerySponsoredData paramGraphQlQuerySponsoredData)
  {
    return new GraphQlQueryRecommendedApplicationsFeedUnitItem.RecommendedApplicationsFeedUnitItemField("sponsored_data", paramGraphQlQuerySponsoredData);
  }

  public static GraphQlQueryRecommendedApplicationsFeedUnitItem.RecommendedApplicationsFeedUnitItemField a(GraphQlQueryTextWithEntities paramGraphQlQueryTextWithEntities)
  {
    return new GraphQlQueryRecommendedApplicationsFeedUnitItem.RecommendedApplicationsFeedUnitItemField("body", paramGraphQlQueryTextWithEntities);
  }

  public static GraphQlQueryRecommendedApplicationsFeedUnitItem a(GraphQlQueryRecommendedApplicationsFeedUnitItem.RecommendedApplicationsFeedUnitItemField[] paramArrayOfRecommendedApplicationsFeedUnitItemField)
  {
    return new GraphQlQueryRecommendedApplicationsFeedUnitItem(ImmutableList.a(paramArrayOfRecommendedApplicationsFeedUnitItemField), null);
  }

  public static GraphQlQueryRecommendedApplicationsFeedUnitItem.RecommendedApplicationsFeedUnitItemField b(GraphQlQueryImage paramGraphQlQueryImage)
  {
    return new GraphQlQueryRecommendedApplicationsFeedUnitItem.RecommendedApplicationsFeedUnitItemField("icon", paramGraphQlQueryImage);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.RecommendedApplicationsFeedUnitItem
 * JD-Core Version:    0.6.0
 */