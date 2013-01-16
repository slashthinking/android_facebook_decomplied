package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$StoryInsights
{
  public static final GraphQlQueryStoryInsights.StoryInsightsField a = new GraphQlQueryStoryInsights.StoryInsightsField("total_reach");
  public static final GraphQlQueryStoryInsights.StoryInsightsField b = new GraphQlQueryStoryInsights.StoryInsightsField("organic_reach");
  public static final GraphQlQueryStoryInsights.StoryInsightsField c = new GraphQlQueryStoryInsights.StoryInsightsField("viral_reach");
  public static final GraphQlQueryStoryInsights.StoryInsightsField d = new GraphQlQueryStoryInsights.StoryInsightsField("paid_reach");

  public static GraphQlQueryStoryInsights a(GraphQlQueryStoryInsights.StoryInsightsField[] paramArrayOfStoryInsightsField)
  {
    return new GraphQlQueryStoryInsights(ImmutableList.a(paramArrayOfStoryInsightsField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.StoryInsights
 * JD-Core Version:    0.6.2
 */