package com.facebook.graphql;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.UnmodifiableIterator;
import java.util.List;
import java.util.Map;

public class GraphQlQueryBaseObjectImpl
  implements GraphQlQueryBaseObject
{
  final String b;
  final ImmutableList<? extends GraphQlQueryBaseField> c;
  final boolean d;

  GraphQlQueryBaseObjectImpl(List<? extends GraphQlQueryBaseField> paramList, String paramString, boolean paramBoolean)
  {
    this.b = paramString;
    this.d = paramBoolean;
    if (paramList != null);
    for (this.c = ImmutableList.a(paramList); ; this.c = ImmutableList.d())
      return;
  }

  public boolean a(StringBuilder paramStringBuilder, Map<GraphQlQueryParam, String> paramMap, ImmutableSet.Builder<GraphQlQueryParam> paramBuilder)
  {
    if (this.b != null)
    {
      paramStringBuilder.append(" as ");
      paramStringBuilder.append(this.b);
    }
    paramStringBuilder.append('{');
    if (!this.c.isEmpty());
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "Must specify fields on a GraphQL object");
      UnmodifiableIterator localUnmodifiableIterator = this.c.b();
      ((GraphQlQueryBaseField)localUnmodifiableIterator.next()).a(paramStringBuilder, paramMap, paramBuilder);
      while (localUnmodifiableIterator.hasNext())
      {
        paramStringBuilder.append(',');
        ((GraphQlQueryBaseField)localUnmodifiableIterator.next()).a(paramStringBuilder, paramMap, paramBuilder);
      }
    }
    if (this.d)
      paramStringBuilder.append(",__type__{name}");
    paramStringBuilder.append('}');
    return true;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryBaseObjectImpl
 * JD-Core Version:    0.6.2
 */