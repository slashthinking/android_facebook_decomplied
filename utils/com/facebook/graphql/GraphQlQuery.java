package com.facebook.graphql;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import java.util.Iterator;
import java.util.Map;

public final class GraphQlQuery
{
  private final GraphQlQueryBaseRootCall a;

  GraphQlQuery(GraphQlQueryBaseRootCall paramGraphQlQueryBaseRootCall)
  {
    this.a = ((GraphQlQueryBaseRootCall)Preconditions.checkNotNull(paramGraphQlQueryBaseRootCall));
  }

  private String a(Map<GraphQlQueryParam, String> paramMap, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramMap);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean)
    {
      ImmutableSet.Builder localBuilder = new ImmutableSet.Builder();
      this.a.a(localStringBuilder, null, localBuilder);
      localStringBuilder.append('%');
      Iterator localIterator = localBuilder.b().iterator();
      int i = 1;
      if (localIterator.hasNext())
      {
        GraphQlQueryParam localGraphQlQueryParam = (GraphQlQueryParam)localIterator.next();
        if (i == 0)
          localStringBuilder.append(',');
        localStringBuilder.append('(');
        String str = (String)paramMap.get(localGraphQlQueryParam);
        if (str != null);
        for (boolean bool = true; ; bool = false)
        {
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = localGraphQlQueryParam.a();
          Preconditions.checkState(bool, "Parameter not specified: %s", arrayOfObject);
          localStringBuilder.append(GraphQlUtil.a(localGraphQlQueryParam.a()));
          localStringBuilder.append(',');
          localStringBuilder.append(GraphQlUtil.a(str));
          localStringBuilder.append(')');
          i = 0;
          break;
        }
      }
    }
    else
    {
      this.a.a(localStringBuilder, paramMap, null);
    }
    return localStringBuilder.toString();
  }

  public String a(Map<GraphQlQueryParam, String> paramMap)
  {
    return b(paramMap);
  }

  public String b(Map<GraphQlQueryParam, String> paramMap)
  {
    return a(paramMap, false);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQuery
 * JD-Core Version:    0.6.2
 */