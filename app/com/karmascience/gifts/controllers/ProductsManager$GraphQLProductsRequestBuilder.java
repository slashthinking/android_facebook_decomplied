package com.karmascience.gifts.controllers;

import android.util.SparseArray;
import com.karmascience.gifts.content.AsyncMethodRunner;
import com.karmascience.gifts.content.graphql.ProductsQueryHelper;
import com.karmascience.gifts.content.graphql.ProductsQueryHelper.ProductsQueryCompanion;
import com.karmascience.gifts.content.model.Products;
import java.util.ArrayList;
import java.util.Collections;

public class ProductsManager$GraphQLProductsRequestBuilder
{
  private final ProductsManager.GraphQLProductsRequestListener b;
  private final ArrayList<String> c;
  private String d;
  private int e = 20;

  public ProductsManager$GraphQLProductsRequestBuilder(ProductsManager paramProductsManager, ProductsManager.GraphQLProductsRequestListener paramGraphQLProductsRequestListener)
  {
    this.b = paramGraphQLProductsRequestListener;
    this.c = new ArrayList();
  }

  private void a(ProductsManager.GraphQLProductsRequestListener paramGraphQLProductsRequestListener)
  {
    int i = b();
    if (ProductsManager.c(this.a).get(i) != null)
      ((ArrayList)ProductsManager.c(this.a).get(i)).add(paramGraphQLProductsRequestListener);
    while (true)
    {
      return;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramGraphQLProductsRequestListener);
      ProductsManager.c(this.a).put(i, localArrayList);
      ProductsQueryHelper localProductsQueryHelper = new ProductsQueryHelper(ProductsManager.d(this.a).a, ProductsManager.d(this.a).b, ProductsManager.d(this.a).c, ProductsManager.d(this.a).d);
      localProductsQueryHelper.a(this.d);
      if (this.c.size() > 0)
        localProductsQueryHelper.a(this.c);
      localProductsQueryHelper.a(this.e);
      ProductsQueryHelper.ProductsQueryCompanion localProductsQueryCompanion = localProductsQueryHelper.a();
      ProductsManager.GraphQLProductsRequestBuilder.1 local1 = new ProductsManager.GraphQLProductsRequestBuilder.1(this, "GetProducts", ProductsManager.e(this.a), 2, Products.class, i, localProductsQueryCompanion);
      ProductsManager.f(this.a).a(local1, localProductsQueryCompanion.a());
    }
  }

  private int b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.d != null)
    {
      localStringBuilder.append("for_user=");
      localStringBuilder.append(this.d);
      localStringBuilder.append("&");
    }
    if (this.c.size() > 0)
    {
      Collections.sort(this.c);
      int i = this.c.size();
      for (int j = 0; j < i; j++)
      {
        String str = (String)this.c.get(j);
        if (str == null)
          continue;
        localStringBuilder.append("category=");
        localStringBuilder.append(str);
        localStringBuilder.append("&");
      }
    }
    return localStringBuilder.toString().hashCode();
  }

  public GraphQLProductsRequestBuilder a(int paramInt)
  {
    if (paramInt > 0)
      this.e = paramInt;
    return this;
  }

  public GraphQLProductsRequestBuilder a(String paramString)
  {
    this.c.add(paramString);
    return this;
  }

  public void a()
  {
    a(this.b);
  }

  public GraphQLProductsRequestBuilder b(String paramString)
  {
    this.d = paramString;
    return this;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.controllers.ProductsManager.GraphQLProductsRequestBuilder
 * JD-Core Version:    0.6.0
 */