package com.facebook.graphql;

import com.google.common.base.Preconditions;
import java.util.List;

public final class GraphQlQueryRootCallStory extends GraphQlQueryBaseRootCall
{
  private GraphQlQueryRootCallStory(String paramString, GraphQlQueryStory paramGraphQlQueryStory, List<String> paramList, List<GraphQlQueryParam> paramList1)
  {
    super(paramString, paramGraphQlQueryStory, paramList, paramList1);
  }

  GraphQlQueryRootCallStory(String paramString, List<String> paramList, List<GraphQlQueryParam> paramList1)
  {
    super(paramString, null, paramList, paramList1);
  }

  public GraphQlQuery a(GraphQlQueryStory paramGraphQlQueryStory)
  {
    return new GraphQlQuery(new GraphQlQueryRootCallStory(this.a, (GraphQlQueryStory)Preconditions.checkNotNull(paramGraphQlQueryStory), this.b, this.c));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryRootCallStory
 * JD-Core Version:    0.6.2
 */