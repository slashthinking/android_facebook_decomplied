package com.facebook.graphql;

public class GraphQl$CelebrationsFeedUnit
{
  public static final GraphQlQueryCelebrationsFeedUnit.CelebrationsFeedUnitField a = new GraphQlQueryCelebrationsFeedUnit.CelebrationsFeedUnitField("debug_info");
  public static final GraphQlQueryCelebrationsFeedUnit.CelebrationsFeedUnitField b = new GraphQlQueryCelebrationsFeedUnit.CelebrationsFeedUnitField("cache_id");

  public static GraphQlQueryCelebrationsFeedUnit.CelebrationsFeedUnitField a(GraphQlQueryCelebrationsFeedUnitItem paramGraphQlQueryCelebrationsFeedUnitItem)
  {
    return new GraphQlQueryCelebrationsFeedUnit.CelebrationsFeedUnitField("items", paramGraphQlQueryCelebrationsFeedUnitItem);
  }

  public static GraphQlQueryCelebrationsFeedUnit.CelebrationsFeedUnitField a(GraphQlQueryTextWithEntities paramGraphQlQueryTextWithEntities)
  {
    return new GraphQlQueryCelebrationsFeedUnit.CelebrationsFeedUnitField("title", paramGraphQlQueryTextWithEntities);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.CelebrationsFeedUnit
 * JD-Core Version:    0.6.2
 */