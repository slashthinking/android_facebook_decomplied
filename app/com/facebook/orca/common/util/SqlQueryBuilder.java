package com.facebook.orca.common.util;

public class SqlQueryBuilder
{
  public static SqlQueryBuilder.AndExpression a()
  {
    return new SqlQueryBuilder.AndExpression();
  }

  public static SqlQueryBuilder.AndExpression a(SqlQueryBuilder.Expression[] paramArrayOfExpression)
  {
    SqlQueryBuilder.AndExpression localAndExpression = new SqlQueryBuilder.AndExpression();
    int i = paramArrayOfExpression.length;
    for (int j = 0; j < i; j++)
      localAndExpression.a(paramArrayOfExpression[j]);
    return localAndExpression;
  }

  public static SqlQueryBuilder.Expression a(String paramString)
  {
    return new SqlQueryBuilder.RawExpression(paramString);
  }

  public static SqlQueryBuilder.Expression a(String paramString1, String paramString2)
  {
    return new SqlQueryBuilder.EqualityExpression(paramString1, paramString2);
  }

  public static SqlQueryBuilder.Expression b(String paramString1, String paramString2)
  {
    return new SqlQueryBuilder.LtExpression(paramString1, paramString2);
  }

  public static SqlQueryBuilder.OrExpression b(SqlQueryBuilder.Expression[] paramArrayOfExpression)
  {
    SqlQueryBuilder.OrExpression localOrExpression = new SqlQueryBuilder.OrExpression();
    int i = paramArrayOfExpression.length;
    for (int j = 0; j < i; j++)
      localOrExpression.a(paramArrayOfExpression[j]);
    return localOrExpression;
  }

  public static SqlQueryBuilder.Expression c(String paramString1, String paramString2)
  {
    return new SqlQueryBuilder.LteExpression(paramString1, paramString2);
  }

  public static SqlQueryBuilder.Expression d(String paramString1, String paramString2)
  {
    return new SqlQueryBuilder.GtExpression(paramString1, paramString2);
  }

  public static SqlQueryBuilder.Expression e(String paramString1, String paramString2)
  {
    return new SqlQueryBuilder.GteExpression(paramString1, paramString2);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.SqlQueryBuilder
 * JD-Core Version:    0.6.0
 */