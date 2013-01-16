package com.facebook.graphql;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;

public final class GraphQlQueryTimelineSectionsConnection extends GraphQlQueryBaseCallable
{
  GraphQlQueryTimelineSectionsConnection(List<? extends GraphQlQueryBaseFieldCall> paramList, List<? extends GraphQlQueryBaseField> paramList1, String paramString)
  {
    super(paramList, paramList1, paramString, false);
  }

  public GraphQlQueryTimelineSectionsConnection a(List<GraphQlQueryTimelineSectionsConnection.TimelineSectionsConnectionField> paramList)
  {
    Preconditions.checkState(this.c.isEmpty(), "Can't add fields multiple times");
    return new GraphQlQueryTimelineSectionsConnection(this.a, (List)Preconditions.checkNotNull(paramList), this.b);
  }

  public GraphQlQueryTimelineSectionsConnection a(GraphQlQueryTimelineSectionsConnection.TimelineSectionsConnectionField[] paramArrayOfTimelineSectionsConnectionField)
  {
    Preconditions.checkState(this.c.isEmpty());
    return a(ImmutableList.a(paramArrayOfTimelineSectionsConnectionField));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryTimelineSectionsConnection
 * JD-Core Version:    0.6.2
 */