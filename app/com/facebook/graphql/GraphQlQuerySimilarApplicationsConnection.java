package com.facebook.graphql;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;

public final class GraphQlQuerySimilarApplicationsConnection extends GraphQlQueryBaseCallable
{
  GraphQlQuerySimilarApplicationsConnection(List<? extends GraphQlQueryBaseFieldCall> paramList, List<? extends GraphQlQueryBaseField> paramList1, String paramString)
  {
    super(paramList, paramList1, paramString, false);
  }

  public GraphQlQuerySimilarApplicationsConnection a(List<GraphQlQuerySimilarApplicationsConnection.SimilarApplicationsConnectionField> paramList)
  {
    Preconditions.checkState(this.c.isEmpty(), "Can't add fields multiple times");
    return new GraphQlQuerySimilarApplicationsConnection(this.a, (List)Preconditions.checkNotNull(paramList), this.b);
  }

  public GraphQlQuerySimilarApplicationsConnection a(GraphQlQuerySimilarApplicationsConnection.SimilarApplicationsConnectionField[] paramArrayOfSimilarApplicationsConnectionField)
  {
    Preconditions.checkState(this.c.isEmpty());
    return a(ImmutableList.a(paramArrayOfSimilarApplicationsConnectionField));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQuerySimilarApplicationsConnection
 * JD-Core Version:    0.6.0
 */