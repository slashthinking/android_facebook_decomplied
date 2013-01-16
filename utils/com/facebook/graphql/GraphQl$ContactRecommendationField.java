package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$ContactRecommendationField
{
  public static final GraphQlQueryContactRecommendationField.ContactRecommendationFieldField a = new GraphQlQueryContactRecommendationField.ContactRecommendationFieldField("id");
  public static final GraphQlQueryContactRecommendationField.ContactRecommendationFieldField b = new GraphQlQueryContactRecommendationField.ContactRecommendationFieldField("url.site(mobile)");
  public static final GraphQlQueryContactRecommendationField.ContactRecommendationFieldField c = new GraphQlQueryContactRecommendationField.ContactRecommendationFieldField("creation_time");
  public static final GraphQlQueryContactRecommendationField.ContactRecommendationFieldField d = new GraphQlQueryContactRecommendationField.ContactRecommendationFieldField("label");
  public static final GraphQlQueryContactRecommendationField.ContactRecommendationFieldField e = new GraphQlQueryContactRecommendationField.ContactRecommendationFieldField("page_rating");

  public static GraphQlQueryContactRecommendationField.ContactRecommendationFieldField a(GraphQlQueryActor paramGraphQlQueryActor)
  {
    return new GraphQlQueryContactRecommendationField.ContactRecommendationFieldField("creator", paramGraphQlQueryActor);
  }

  public static GraphQlQueryContactRecommendationField.ContactRecommendationFieldField a(GraphQlQueryTextWithEntities paramGraphQlQueryTextWithEntities)
  {
    return new GraphQlQueryContactRecommendationField.ContactRecommendationFieldField("value", paramGraphQlQueryTextWithEntities);
  }

  public static GraphQlQueryContactRecommendationField a(GraphQlQueryContactRecommendationField.ContactRecommendationFieldField[] paramArrayOfContactRecommendationFieldField)
  {
    return new GraphQlQueryContactRecommendationField(ImmutableList.a(paramArrayOfContactRecommendationFieldField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.ContactRecommendationField
 * JD-Core Version:    0.6.2
 */