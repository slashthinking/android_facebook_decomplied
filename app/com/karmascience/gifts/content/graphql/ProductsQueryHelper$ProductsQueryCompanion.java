package com.karmascience.gifts.content.graphql;

public class ProductsQueryHelper$ProductsQueryCompanion
{
  private final String a;
  private final String b;

  private ProductsQueryHelper$ProductsQueryCompanion(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }

  public String a()
  {
    return this.a;
  }

  public String a(String paramString)
  {
    return String.format(this.b, new Object[] { paramString });
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.content.graphql.ProductsQueryHelper.ProductsQueryCompanion
 * JD-Core Version:    0.6.0
 */