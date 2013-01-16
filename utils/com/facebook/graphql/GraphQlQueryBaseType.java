package com.facebook.graphql;

import com.google.common.collect.ImmutableSet.Builder;
import java.util.Map;

public abstract interface GraphQlQueryBaseType
{
  public abstract boolean a(StringBuilder paramStringBuilder, Map<GraphQlQueryParam, String> paramMap, ImmutableSet.Builder<GraphQlQueryParam> paramBuilder);
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryBaseType
 * JD-Core Version:    0.6.2
 */