package com.facebook.pages.identity.data;

import com.facebook.graphql.model.GraphQueryResultEntry;
import com.facebook.graphql.model.PageRecommendation;
import com.facebook.graphql.model.PageRecommendationList;
import com.facebook.graphql.model.PageStarRatersEdge;
import com.facebook.graphql.model.PageStarRatersList;
import com.google.common.collect.ImmutableList;
import java.util.List;

public class PageRecommendationData
{
  public final int a;
  public final ImmutableList<PageRecommendation> b;
  public final ImmutableList<PageStarRatersEdge> c;

  public PageRecommendationData(int paramInt, List<PageRecommendation> paramList, List<PageStarRatersEdge> paramList1)
  {
    this.a = paramInt;
    this.b = ImmutableList.a(paramList);
    this.c = ImmutableList.a(paramList1);
  }

  public static PageRecommendationData a(GraphQueryResultEntry paramGraphQueryResultEntry)
  {
    return new PageRecommendationData(paramGraphQueryResultEntry.recommendations.count, paramGraphQueryResultEntry.recommendations.recommendations, paramGraphQueryResultEntry.pageRaters.raters);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.data.PageRecommendationData
 * JD-Core Version:    0.6.2
 */