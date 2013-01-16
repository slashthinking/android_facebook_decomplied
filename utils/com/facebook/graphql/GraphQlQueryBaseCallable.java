package com.facebook.graphql;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet.Builder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class GraphQlQueryBaseCallable extends GraphQlQueryBaseObjectImpl
{
  final ImmutableList<? extends GraphQlQueryBaseFieldCall> a;

  GraphQlQueryBaseCallable(List<? extends GraphQlQueryBaseFieldCall> paramList, List<? extends GraphQlQueryBaseField> paramList1, String paramString, boolean paramBoolean)
  {
    super(paramList1, paramString, paramBoolean);
    boolean bool;
    if ((paramList != null) || (paramList1 != null))
    {
      bool = true;
      Preconditions.checkArgument(bool, "Callables should be created with either fields or fieldcalls, not emptily");
      if (paramList == null)
        break label45;
    }
    label45: for (this.a = ImmutableList.a(paramList); ; this.a = ImmutableList.d())
    {
      return;
      bool = false;
      break;
    }
  }

  public boolean a(StringBuilder paramStringBuilder, Map<GraphQlQueryParam, String> paramMap, ImmutableSet.Builder<GraphQlQueryParam> paramBuilder)
  {
    Preconditions.checkNotNull(paramStringBuilder);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      GraphQlQueryBaseFieldCall localGraphQlQueryBaseFieldCall = (GraphQlQueryBaseFieldCall)localIterator.next();
      paramStringBuilder.append('.');
      if (!localGraphQlQueryBaseFieldCall.a(paramStringBuilder, paramMap, paramBuilder))
        paramStringBuilder.deleteCharAt(-1 + paramStringBuilder.length());
    }
    super.a(paramStringBuilder, paramMap, paramBuilder);
    return true;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryBaseCallable
 * JD-Core Version:    0.6.2
 */