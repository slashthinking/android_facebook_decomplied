package com.facebook.graphql;

import com.google.common.base.Preconditions;
import java.util.List;

public final class GraphQlQueryRootCallActor extends GraphQlQueryBaseRootCall
{
  private GraphQlQueryRootCallActor(String paramString, GraphQlQueryActor paramGraphQlQueryActor, List<String> paramList, List<GraphQlQueryParam> paramList1)
  {
    super(paramString, paramGraphQlQueryActor, paramList, paramList1);
  }

  GraphQlQueryRootCallActor(String paramString, List<String> paramList, List<GraphQlQueryParam> paramList1)
  {
    super(paramString, null, paramList, paramList1);
  }

  public GraphQlQuery a(GraphQlQueryActor paramGraphQlQueryActor)
  {
    return new GraphQlQuery(new GraphQlQueryRootCallActor(this.a, (GraphQlQueryActor)Preconditions.checkNotNull(paramGraphQlQueryActor), this.b, this.c));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryRootCallActor
 * JD-Core Version:    0.6.2
 */