package com.facebook.graphql;

import com.google.common.collect.ImmutableList;
import java.util.List;

public class GraphQl$FeedUnit
{
  public static GraphQlQueryFeedUnitImpl a(List<? extends GraphQlQueryFieldFeedUnit> paramList)
  {
    return new GraphQlQueryFeedUnitImpl(paramList, null);
  }

  public static GraphQlQueryFeedUnitImpl a(GraphQlQueryFieldFeedUnit[] paramArrayOfGraphQlQueryFieldFeedUnit)
  {
    return new GraphQlQueryFeedUnitImpl(ImmutableList.a(paramArrayOfGraphQlQueryFieldFeedUnit), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.FeedUnit
 * JD-Core Version:    0.6.2
 */