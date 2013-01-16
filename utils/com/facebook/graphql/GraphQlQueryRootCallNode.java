package com.facebook.graphql;

import com.google.common.base.Preconditions;
import java.util.List;

public final class GraphQlQueryRootCallNode extends GraphQlQueryBaseRootCall
{
  private GraphQlQueryRootCallNode(String paramString, GraphQlQueryNode paramGraphQlQueryNode, List<String> paramList, List<GraphQlQueryParam> paramList1)
  {
    super(paramString, paramGraphQlQueryNode, paramList, paramList1);
  }

  GraphQlQueryRootCallNode(String paramString, List<String> paramList, List<GraphQlQueryParam> paramList1)
  {
    super(paramString, null, paramList, paramList1);
  }

  public GraphQlQuery a(GraphQlQueryNode paramGraphQlQueryNode)
  {
    return new GraphQlQuery(new GraphQlQueryRootCallNode(this.a, (GraphQlQueryNode)Preconditions.checkNotNull(paramGraphQlQueryNode), this.b, this.c));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryRootCallNode
 * JD-Core Version:    0.6.2
 */