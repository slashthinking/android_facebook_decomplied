package com.facebook.graphql;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;

public final class GraphQlQueryPageRecommendationsConnection extends GraphQlQueryBaseCallable
{
  GraphQlQueryPageRecommendationsConnection(List<? extends GraphQlQueryBaseFieldCall> paramList, List<? extends GraphQlQueryBaseField> paramList1, String paramString)
  {
    super(paramList, paramList1, paramString, false);
  }

  public GraphQlQueryPageRecommendationsConnection a(String paramString)
  {
    if (this.b == null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "Alias already set");
      return new GraphQlQueryPageRecommendationsConnection(this.a, this.c, (String)Preconditions.checkNotNull(paramString));
    }
  }

  public GraphQlQueryPageRecommendationsConnection a(List<GraphQlQueryPageRecommendationsConnection.PageRecommendationsConnectionField> paramList)
  {
    Preconditions.checkState(this.c.isEmpty(), "Can't add fields multiple times");
    return new GraphQlQueryPageRecommendationsConnection(this.a, (List)Preconditions.checkNotNull(paramList), this.b);
  }

  public GraphQlQueryPageRecommendationsConnection a(GraphQlQueryPageRecommendationsConnection.PageRecommendationsConnectionField[] paramArrayOfPageRecommendationsConnectionField)
  {
    Preconditions.checkState(this.c.isEmpty());
    return a(ImmutableList.a(paramArrayOfPageRecommendationsConnectionField));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryPageRecommendationsConnection
 * JD-Core Version:    0.6.2
 */