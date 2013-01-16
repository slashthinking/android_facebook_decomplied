package com.facebook.graphql;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;

public final class GraphQlQueryPageStarRatersConnection extends GraphQlQueryBaseCallable
{
  GraphQlQueryPageStarRatersConnection(List<? extends GraphQlQueryBaseFieldCall> paramList, List<? extends GraphQlQueryBaseField> paramList1, String paramString)
  {
    super(paramList, paramList1, paramString, false);
  }

  public GraphQlQueryPageStarRatersConnection a(List<GraphQlQueryPageStarRatersConnection.PageStarRatersConnectionField> paramList)
  {
    Preconditions.checkState(this.c.isEmpty(), "Can't add fields multiple times");
    return new GraphQlQueryPageStarRatersConnection(this.a, (List)Preconditions.checkNotNull(paramList), this.b);
  }

  public GraphQlQueryPageStarRatersConnection a(GraphQlQueryPageStarRatersConnection.PageStarRatersConnectionField[] paramArrayOfPageStarRatersConnectionField)
  {
    Preconditions.checkState(this.c.isEmpty());
    return a(ImmutableList.a(paramArrayOfPageStarRatersConnectionField));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryPageStarRatersConnection
 * JD-Core Version:    0.6.2
 */