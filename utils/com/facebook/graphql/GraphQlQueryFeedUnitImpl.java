package com.facebook.graphql;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;

public final class GraphQlQueryFeedUnitImpl extends GraphQlQueryBaseObjectImpl
  implements GraphQlQueryFeedUnit
{
  GraphQlQueryFeedUnitImpl(List<? extends GraphQlQueryBaseField> paramList, String paramString)
  {
    super((List)Preconditions.checkNotNull(paramList), paramString, true);
  }

  public GraphQlQueryFeedUnitImpl a(GraphQlQueryFieldFeedUnit paramGraphQlQueryFieldFeedUnit)
  {
    return a(new GraphQlQueryFieldFeedUnit[] { paramGraphQlQueryFieldFeedUnit });
  }

  public GraphQlQueryFeedUnitImpl a(List<GraphQlQueryFieldFeedUnit> paramList)
  {
    return new GraphQlQueryFeedUnitImpl(ImmutableList.e().b((Iterable)Preconditions.checkNotNull(this.c)).b(paramList).b(), this.b);
  }

  public GraphQlQueryFeedUnitImpl a(GraphQlQueryFieldFeedUnit[] paramArrayOfGraphQlQueryFieldFeedUnit)
  {
    return a(ImmutableList.a(paramArrayOfGraphQlQueryFieldFeedUnit));
  }

  public GraphQlQueryFeedUnitImpl b(GraphQlQueryFieldFeedUnit paramGraphQlQueryFieldFeedUnit)
  {
    return new GraphQlQueryFeedUnitImpl(ImmutableList.e().b((Iterable)Preconditions.checkNotNull(this.c)).b(new GraphQlQueryFeedUnitImpl.FeedUnitGenericField(paramGraphQlQueryFieldFeedUnit, paramGraphQlQueryFieldFeedUnit.c())).b(), this.b);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryFeedUnitImpl
 * JD-Core Version:    0.6.2
 */