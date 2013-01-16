package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$CelebrationsFeedUnitItem
{
  public static GraphQlQueryCelebrationsFeedUnitItem.CelebrationsFeedUnitItemField a(GraphQlQueryTextWithEntities paramGraphQlQueryTextWithEntities)
  {
    return new GraphQlQueryCelebrationsFeedUnitItem.CelebrationsFeedUnitItemField("description", paramGraphQlQueryTextWithEntities);
  }

  public static GraphQlQueryCelebrationsFeedUnitItem.CelebrationsFeedUnitItemField a(GraphQlQueryUser paramGraphQlQueryUser)
  {
    return new GraphQlQueryCelebrationsFeedUnitItem.CelebrationsFeedUnitItemField("profile", paramGraphQlQueryUser);
  }

  public static GraphQlQueryCelebrationsFeedUnitItem a(GraphQlQueryCelebrationsFeedUnitItem.CelebrationsFeedUnitItemField[] paramArrayOfCelebrationsFeedUnitItemField)
  {
    return new GraphQlQueryCelebrationsFeedUnitItem(ImmutableList.a(paramArrayOfCelebrationsFeedUnitItemField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.CelebrationsFeedUnitItem
 * JD-Core Version:    0.6.2
 */