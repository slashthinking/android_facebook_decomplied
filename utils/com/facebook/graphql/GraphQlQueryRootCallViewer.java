package com.facebook.graphql;

import com.google.common.base.Preconditions;
import java.util.List;

public final class GraphQlQueryRootCallViewer extends GraphQlQueryBaseRootCall
{
  private GraphQlQueryRootCallViewer(String paramString, GraphQlQueryViewer paramGraphQlQueryViewer, List<String> paramList, List<GraphQlQueryParam> paramList1)
  {
    super(paramString, paramGraphQlQueryViewer, paramList, paramList1);
  }

  GraphQlQueryRootCallViewer(String paramString, List<String> paramList, List<GraphQlQueryParam> paramList1)
  {
    super(paramString, null, paramList, paramList1);
  }

  public GraphQlQuery a(GraphQlQueryViewer paramGraphQlQueryViewer)
  {
    return new GraphQlQuery(new GraphQlQueryRootCallViewer(this.a, (GraphQlQueryViewer)Preconditions.checkNotNull(paramGraphQlQueryViewer), this.b, this.c));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryRootCallViewer
 * JD-Core Version:    0.6.2
 */