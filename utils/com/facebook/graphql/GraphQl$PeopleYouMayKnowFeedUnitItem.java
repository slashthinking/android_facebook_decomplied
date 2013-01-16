package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$PeopleYouMayKnowFeedUnitItem
{
  public static final GraphQlQueryPeopleYouMayKnowFeedUnitItem.PeopleYouMayKnowFeedUnitItemField a = new GraphQlQueryPeopleYouMayKnowFeedUnitItem.PeopleYouMayKnowFeedUnitItemField("tracking");

  public static GraphQlQueryPeopleYouMayKnowFeedUnitItem.PeopleYouMayKnowFeedUnitItemField a(GraphQlQueryUser paramGraphQlQueryUser)
  {
    return new GraphQlQueryPeopleYouMayKnowFeedUnitItem.PeopleYouMayKnowFeedUnitItemField("profile", paramGraphQlQueryUser);
  }

  public static GraphQlQueryPeopleYouMayKnowFeedUnitItem a(GraphQlQueryPeopleYouMayKnowFeedUnitItem.PeopleYouMayKnowFeedUnitItemField[] paramArrayOfPeopleYouMayKnowFeedUnitItemField)
  {
    return new GraphQlQueryPeopleYouMayKnowFeedUnitItem(ImmutableList.a(paramArrayOfPeopleYouMayKnowFeedUnitItemField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.PeopleYouMayKnowFeedUnitItem
 * JD-Core Version:    0.6.2
 */