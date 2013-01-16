package com.facebook.graphql;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;

public final class GraphQlQueryRecommendedApplicationsConnection extends GraphQlQueryBaseCallable
{
  GraphQlQueryRecommendedApplicationsConnection(List<? extends GraphQlQueryBaseFieldCall> paramList, List<? extends GraphQlQueryBaseField> paramList1, String paramString)
  {
    super(paramList, paramList1, paramString, false);
  }

  public GraphQlQueryRecommendedApplicationsConnection a(List<GraphQlQueryRecommendedApplicationsConnection.RecommendedApplicationsConnectionField> paramList)
  {
    Preconditions.checkState(this.c.isEmpty(), "Can't add fields multiple times");
    return new GraphQlQueryRecommendedApplicationsConnection(this.a, (List)Preconditions.checkNotNull(paramList), this.b);
  }

  public GraphQlQueryRecommendedApplicationsConnection a(GraphQlQueryRecommendedApplicationsConnection.RecommendedApplicationsConnectionField[] paramArrayOfRecommendedApplicationsConnectionField)
  {
    Preconditions.checkState(this.c.isEmpty());
    return a(ImmutableList.a(paramArrayOfRecommendedApplicationsConnectionField));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryRecommendedApplicationsConnection
 * JD-Core Version:    0.6.0
 */