package com.facebook.graphql;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet.Builder;
import java.util.Map;

class GraphQlQueryBaseObjectImpl$FieldImpl
  implements GraphQlQueryBaseField
{
  final String a;
  final String b;
  final String c;
  final GraphQlQueryBaseObject d;

  GraphQlQueryBaseObjectImpl$FieldImpl(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, null, null);
  }

  GraphQlQueryBaseObjectImpl$FieldImpl(String paramString1, String paramString2, String paramString3, GraphQlQueryBaseObject paramGraphQlQueryBaseObject)
  {
    this.a = ((String)Preconditions.checkNotNull(paramString1));
    this.b = ((String)Preconditions.checkNotNull(paramString2));
    this.c = paramString3;
    this.d = paramGraphQlQueryBaseObject;
  }

  public GraphQlQueryBaseObject a()
  {
    return this.d;
  }

  public boolean a(StringBuilder paramStringBuilder, Map<GraphQlQueryParam, String> paramMap, ImmutableSet.Builder<GraphQlQueryParam> paramBuilder)
  {
    if (this.c != null)
    {
      paramStringBuilder.append(this.c);
      paramStringBuilder.append("?");
    }
    paramStringBuilder.append(this.b);
    if (this.d != null)
      this.d.a(paramStringBuilder, paramMap, paramBuilder);
    return true;
  }

  public String b()
  {
    return this.b;
  }

  public String c()
  {
    return this.a;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryBaseObjectImpl.FieldImpl
 * JD-Core Version:    0.6.2
 */