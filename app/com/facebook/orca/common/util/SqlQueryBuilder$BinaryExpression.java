package com.facebook.orca.common.util;

public class SqlQueryBuilder$BinaryExpression extends SqlQueryBuilder.Expression
{
  private final String a;
  private final String b;
  private final String c;

  public SqlQueryBuilder$BinaryExpression(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }

  public String a()
  {
    return this.a + this.c + "?";
  }

  public String[] b()
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = this.b;
    return arrayOfString;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.SqlQueryBuilder.BinaryExpression
 * JD-Core Version:    0.6.0
 */