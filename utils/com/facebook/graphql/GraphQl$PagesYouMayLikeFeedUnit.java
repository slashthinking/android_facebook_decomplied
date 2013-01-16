package com.facebook.graphql;

public class GraphQl$PagesYouMayLikeFeedUnit
{
  public static final GraphQlQueryPagesYouMayLikeFeedUnit.PagesYouMayLikeFeedUnitField a = new GraphQlQueryPagesYouMayLikeFeedUnit.PagesYouMayLikeFeedUnitField("debug_info");
  public static final GraphQlQueryPagesYouMayLikeFeedUnit.PagesYouMayLikeFeedUnitField b = new GraphQlQueryPagesYouMayLikeFeedUnit.PagesYouMayLikeFeedUnitField("cache_id");

  public static GraphQlQueryPagesYouMayLikeFeedUnit.PagesYouMayLikeFeedUnitField a(GraphQlQueryPagesYouMayLikeFeedUnitItem paramGraphQlQueryPagesYouMayLikeFeedUnitItem)
  {
    return new GraphQlQueryPagesYouMayLikeFeedUnit.PagesYouMayLikeFeedUnitField("items", paramGraphQlQueryPagesYouMayLikeFeedUnitItem);
  }

  public static GraphQlQueryPagesYouMayLikeFeedUnit.PagesYouMayLikeFeedUnitField a(GraphQlQueryTextWithEntities paramGraphQlQueryTextWithEntities)
  {
    return new GraphQlQueryPagesYouMayLikeFeedUnit.PagesYouMayLikeFeedUnitField("title", paramGraphQlQueryTextWithEntities);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.PagesYouMayLikeFeedUnit
 * JD-Core Version:    0.6.2
 */