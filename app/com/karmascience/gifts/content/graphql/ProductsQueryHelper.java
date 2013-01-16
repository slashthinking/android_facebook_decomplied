package com.karmascience.gifts.content.graphql;

import com.facebook.orca.common.util.StringUtil;
import java.util.List;

public class ProductsQueryHelper
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  private String e;
  private String f;
  private String g;
  private int h = 20;

  public ProductsQueryHelper(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }

  private String a(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!StringUtil.a(this.e))
      localStringBuilder.append("node(" + this.e + ")");
    for (String str = "products"; ; str = "all_products")
    {
      localStringBuilder.append('{');
      localStringBuilder.append(str);
      a(localStringBuilder, "includes", new Object[] { "itunes_desktop", "alcohol" });
      if (!StringUtil.a(this.f))
      {
        Object[] arrayOfObject3 = new Object[1];
        arrayOfObject3[0] = this.f;
        a(localStringBuilder, "recipient", arrayOfObject3);
      }
      if (!StringUtil.a(this.g))
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = this.g;
        a(localStringBuilder, "query", arrayOfObject2);
      }
      if (paramBoolean)
        a(localStringBuilder, "after", new Object[] { "%s" });
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(this.h);
      a(localStringBuilder, "first", arrayOfObject1);
      localStringBuilder.append(paramString);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
      localStringBuilder.append("node(295377273895016)");
    }
  }

  private static void a(StringBuilder paramStringBuilder, String paramString, Object[] paramArrayOfObject)
  {
    paramStringBuilder.append('.');
    paramStringBuilder.append(paramString);
    paramStringBuilder.append('(');
    int i = paramArrayOfObject.length;
    for (int j = 0; j < i; j++)
    {
      paramStringBuilder.append(paramArrayOfObject[j]);
      if (j + 1 >= i)
        continue;
      paramStringBuilder.append(',');
    }
    paramStringBuilder.append(')');
  }

  public ProductsQueryHelper.ProductsQueryCompanion a()
  {
    Object[] arrayOfObject = new Object[8];
    arrayOfObject[0] = Integer.valueOf(this.a);
    arrayOfObject[1] = Integer.valueOf(this.b);
    arrayOfObject[2] = Integer.valueOf(this.c);
    arrayOfObject[3] = Integer.valueOf(this.d);
    arrayOfObject[4] = Integer.valueOf(this.a);
    arrayOfObject[5] = Integer.valueOf(this.b);
    arrayOfObject[6] = Integer.valueOf(this.c);
    arrayOfObject[7] = Integer.valueOf(this.d);
    String str = String.format("{page_info,count,nodes{id,product_type,min_price,max_price,brand,name,display_name,choose_sku_line,choose_sku_sentence,must_pick_sku,sender_must_prepay,description,images.size(%d,%d)as full_images{uri},images.size(%d,%d)as thumb_images{uri},skus{nodes{id,description,name,price,shipping_price,images.size(%d,%d)as full_images{uri},images.size(%d,%d)as thumb_images{uri}}}}}", arrayOfObject);
    return new ProductsQueryHelper.ProductsQueryCompanion(a(str, false), a(str, true), null);
  }

  public void a(int paramInt)
  {
    this.h = paramInt;
  }

  public void a(String paramString)
  {
    this.f = paramString;
  }

  public void a(List<String> paramList)
  {
    StringBuilder localStringBuilder;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localStringBuilder = new StringBuilder();
      int i = paramList.size();
      for (int j = 0; j < i; j++)
      {
        localStringBuilder.append((String)paramList.get(j));
        if (j + 1 >= i)
          continue;
        localStringBuilder.append(',');
      }
    }
    for (this.e = localStringBuilder.toString(); ; this.e = null)
      return;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.content.graphql.ProductsQueryHelper
 * JD-Core Version:    0.6.0
 */