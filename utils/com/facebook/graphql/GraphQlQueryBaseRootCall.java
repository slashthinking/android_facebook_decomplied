package com.facebook.graphql;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet.Builder;
import java.util.List;
import java.util.Map;

public class GraphQlQueryBaseRootCall extends GraphQlQueryBaseFieldCallImpl
{
  final GraphQlQueryBaseObject d;

  GraphQlQueryBaseRootCall(String paramString, GraphQlQueryBaseObject paramGraphQlQueryBaseObject, List<String> paramList, List<GraphQlQueryParam> paramList1)
  {
    super((String)Preconditions.checkNotNull(paramString), paramList, paramList1);
    this.d = paramGraphQlQueryBaseObject;
  }

  public boolean a(StringBuilder paramStringBuilder, Map<GraphQlQueryParam, String> paramMap, ImmutableSet.Builder<GraphQlQueryParam> paramBuilder)
  {
    super.a(paramStringBuilder, paramMap, paramBuilder);
    if (this.d != null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool);
      this.d.a(paramStringBuilder, paramMap, paramBuilder);
      return true;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryBaseRootCall
 * JD-Core Version:    0.6.2
 */