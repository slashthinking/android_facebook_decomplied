package com.facebook.graphql;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;

public final class GraphQlQueryIcon extends GraphQlQueryBaseCallable
{
  GraphQlQueryIcon(List<? extends GraphQlQueryBaseFieldCall> paramList, List<? extends GraphQlQueryBaseField> paramList1, String paramString)
  {
    super(paramList, paramList1, paramString, false);
  }

  public GraphQlQueryIcon a(List<GraphQlQueryIcon.IconField> paramList)
  {
    Preconditions.checkState(this.c.isEmpty(), "Can't add fields multiple times");
    return new GraphQlQueryIcon(this.a, (List)Preconditions.checkNotNull(paramList), this.b);
  }

  public GraphQlQueryIcon a(GraphQlQueryIcon.IconField[] paramArrayOfIconField)
  {
    Preconditions.checkState(this.c.isEmpty());
    return a(ImmutableList.a(paramArrayOfIconField));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryIcon
 * JD-Core Version:    0.6.2
 */