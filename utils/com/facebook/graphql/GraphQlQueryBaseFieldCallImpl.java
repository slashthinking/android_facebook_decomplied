package com.facebook.graphql;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet.Builder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GraphQlQueryBaseFieldCallImpl
  implements GraphQlQueryBaseFieldCall
{
  final String a;
  final ImmutableList<String> b;
  final ImmutableList<GraphQlQueryParam> c;

  GraphQlQueryBaseFieldCallImpl(String paramString, List<String> paramList, List<GraphQlQueryParam> paramList1)
  {
    this.a = ((String)Preconditions.checkNotNull(paramString));
    if (paramList != null)
    {
      this.b = ImmutableList.a(paramList);
      if (paramList1 == null)
        break label50;
    }
    label50: for (this.c = ImmutableList.a(paramList1); ; this.c = ImmutableList.d())
    {
      return;
      this.b = ImmutableList.d();
      break;
    }
  }

  GraphQlQueryBaseFieldCallImpl(String paramString, GraphQlQueryParam[] paramArrayOfGraphQlQueryParam)
  {
    this(paramString, null, ImmutableList.a(paramArrayOfGraphQlQueryParam));
  }

  GraphQlQueryBaseFieldCallImpl(String paramString, String[] paramArrayOfString)
  {
    this(paramString, ImmutableList.a(paramArrayOfString), null);
  }

  public boolean a(StringBuilder paramStringBuilder, Map<GraphQlQueryParam, String> paramMap, ImmutableSet.Builder<GraphQlQueryParam> paramBuilder)
  {
    Preconditions.checkNotNull(paramStringBuilder);
    boolean bool1;
    if (paramMap != null)
    {
      Iterator localIterator3 = this.c.iterator();
      boolean bool3;
      do
      {
        String str2;
        do
        {
          if (!localIterator3.hasNext())
            break;
          str2 = (String)paramMap.get((GraphQlQueryParam)localIterator3.next());
        }
        while (str2 == null);
        bool3 = str2.equals("null");
        bool1 = false;
      }
      while (!bool3);
    }
    while (true)
    {
      return bool1;
      paramStringBuilder.append(this.a);
      paramStringBuilder.append('(');
      if (!this.b.isEmpty())
      {
        Iterator localIterator2 = this.b.iterator();
        for (int j = 1; localIterator2.hasNext(); j = 0)
        {
          String str1 = (String)localIterator2.next();
          if (j == 0)
            paramStringBuilder.append(',');
          paramStringBuilder.append(GraphQlUtil.a(str1));
        }
      }
      if (!this.c.isEmpty())
      {
        Iterator localIterator1 = this.c.iterator();
        int i = 1;
        if (localIterator1.hasNext())
        {
          GraphQlQueryParam localGraphQlQueryParam = (GraphQlQueryParam)localIterator1.next();
          if (i == 0)
            paramStringBuilder.append(',');
          boolean bool2;
          if (paramMap != null)
            if ((String)paramMap.get(localGraphQlQueryParam) != null)
            {
              bool2 = true;
              label239: Object[] arrayOfObject = new Object[1];
              arrayOfObject[0] = localGraphQlQueryParam.a();
              Preconditions.checkState(bool2, "Must specify a value for each parameter used, none found for %s", arrayOfObject);
              paramStringBuilder.append(GraphQlUtil.a((String)paramMap.get(localGraphQlQueryParam)));
            }
          while (true)
          {
            if (paramBuilder != null)
              paramBuilder.b(localGraphQlQueryParam);
            i = 0;
            break;
            bool2 = false;
            break label239;
            paramStringBuilder.append('<');
            paramStringBuilder.append(GraphQlUtil.a(localGraphQlQueryParam.a()));
            paramStringBuilder.append('>');
          }
        }
      }
      paramStringBuilder.append(')');
      bool1 = true;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQlQueryBaseFieldCallImpl
 * JD-Core Version:    0.6.2
 */