package com.facebook.graphql;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;

public final class GraphQlQueryPlaceImpl extends GraphQlQueryBaseObjectImpl
  implements GraphQlQueryPlace
{
  GraphQlQueryPlaceImpl(List<? extends GraphQlQueryBaseField> paramList, String paramString)
  {
    super((List)Preconditions.checkNotNull(paramList), paramString, true);
  }

  public GraphQlQueryPlaceImpl a(GraphQlQueryFieldPlace paramGraphQlQueryFieldPlace)
  {
    return a(new GraphQlQueryFieldPlace[] { paramGraphQlQueryFieldPlace });
  }

  public GraphQlQueryPlaceImpl a(List<GraphQlQueryFieldPlace> paramList)
  {
    return new GraphQlQueryPlaceImpl(ImmutableList.e().b((Iterable)Preconditions.checkNotNull(this.c)).b(paramList).b(), this.b);
  }

  public GraphQlQueryPlaceImpl a(GraphQlQueryFieldPlace[] paramArrayOfGraphQlQueryFieldPlace)
  {
    return a(ImmutableList.a(paramArrayOfGraphQlQueryFieldPlace));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryPlaceImpl
 * JD-Core Version:    0.6.2
 */