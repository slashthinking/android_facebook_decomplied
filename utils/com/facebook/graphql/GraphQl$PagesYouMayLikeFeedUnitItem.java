package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$PagesYouMayLikeFeedUnitItem
{
  public static final GraphQlQueryPagesYouMayLikeFeedUnitItem.PagesYouMayLikeFeedUnitItemField a = new GraphQlQueryPagesYouMayLikeFeedUnitItem.PagesYouMayLikeFeedUnitItemField("tracking");

  public static GraphQlQueryPagesYouMayLikeFeedUnitItem.PagesYouMayLikeFeedUnitItemField a(GraphQlQueryPage paramGraphQlQueryPage)
  {
    return new GraphQlQueryPagesYouMayLikeFeedUnitItem.PagesYouMayLikeFeedUnitItemField("profile", paramGraphQlQueryPage);
  }

  public static GraphQlQueryPagesYouMayLikeFeedUnitItem.PagesYouMayLikeFeedUnitItemField a(GraphQlQuerySponsoredData paramGraphQlQuerySponsoredData)
  {
    return new GraphQlQueryPagesYouMayLikeFeedUnitItem.PagesYouMayLikeFeedUnitItemField("sponsored_data", paramGraphQlQuerySponsoredData);
  }

  public static GraphQlQueryPagesYouMayLikeFeedUnitItem.PagesYouMayLikeFeedUnitItemField a(GraphQlQueryTextWithEntities paramGraphQlQueryTextWithEntities)
  {
    return new GraphQlQueryPagesYouMayLikeFeedUnitItem.PagesYouMayLikeFeedUnitItemField("social_context", paramGraphQlQueryTextWithEntities);
  }

  public static GraphQlQueryPagesYouMayLikeFeedUnitItem a(GraphQlQueryPagesYouMayLikeFeedUnitItem.PagesYouMayLikeFeedUnitItemField[] paramArrayOfPagesYouMayLikeFeedUnitItemField)
  {
    return new GraphQlQueryPagesYouMayLikeFeedUnitItem(ImmutableList.a(paramArrayOfPagesYouMayLikeFeedUnitItemField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.PagesYouMayLikeFeedUnitItem
 * JD-Core Version:    0.6.2
 */