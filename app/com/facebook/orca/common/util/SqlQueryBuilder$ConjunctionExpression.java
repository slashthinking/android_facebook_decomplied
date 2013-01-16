package com.facebook.orca.common.util;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SqlQueryBuilder$ConjunctionExpression extends SqlQueryBuilder.Expression
{
  private final String a;
  private List<SqlQueryBuilder.Expression> b = Lists.a();

  public SqlQueryBuilder$ConjunctionExpression(String paramString)
  {
    this.a = paramString;
  }

  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    Iterator localIterator = this.b.iterator();
    for (int i = 1; localIterator.hasNext(); i = 0)
    {
      SqlQueryBuilder.Expression localExpression = (SqlQueryBuilder.Expression)localIterator.next();
      if (i == 0)
      {
        localStringBuilder.append(" ");
        localStringBuilder.append(this.a);
        localStringBuilder.append(" ");
      }
      localStringBuilder.append(localExpression.a());
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }

  public void a(SqlQueryBuilder.Expression paramExpression)
  {
    this.b.add(paramExpression);
  }

  public String[] b()
  {
    ArrayList localArrayList = Lists.a();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      localArrayList.addAll(Arrays.asList(((SqlQueryBuilder.Expression)localIterator.next()).b()));
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.SqlQueryBuilder.ConjunctionExpression
 * JD-Core Version:    0.6.0
 */