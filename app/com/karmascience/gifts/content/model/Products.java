package com.karmascience.gifts.content.model;

import com.facebook.graphql.model.GraphQLPageInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.karmascience.gifts.ThreadingService;
import com.karmascience.gifts.content.AsyncMethodRunner;
import com.karmascience.gifts.content.graphql.ProductsQueryHelper.ProductsQueryCompanion;
import java.util.ArrayList;
import java.util.List;

public class Products
{
  private AsyncMethodRunner a;
  private ProductsQueryHelper.ProductsQueryCompanion b;
  private ThreadingService c;
  private boolean d;
  private int e;
  private final List<Products.OnChangeListener> f = new ArrayList();

  @JsonProperty("page_info")
  private GraphQLPageInfo mPageInfo = null;

  @JsonProperty("nodes")
  private final List<Product> mProducts = null;

  private void a(String paramString)
  {
    Products.1 local1 = new Products.1(this, "GetMoreProducts", this.c, 2, Products.class, paramString);
    String str = this.b.a(paramString);
    this.a.a(local1, str);
  }

  public int a()
  {
    if (this.mProducts != null);
    for (int i = this.mProducts.size(); ; i = 0)
      return i;
  }

  public Product a(int paramInt)
  {
    if ((this.mProducts != null) && (paramInt >= 0) && (paramInt < this.mProducts.size()));
    for (Product localProduct = (Product)this.mProducts.get(paramInt); ; localProduct = null)
      return localProduct;
  }

  public void a(AsyncMethodRunner paramAsyncMethodRunner, ProductsQueryHelper.ProductsQueryCompanion paramProductsQueryCompanion, ThreadingService paramThreadingService)
  {
    this.a = paramAsyncMethodRunner;
    this.b = paramProductsQueryCompanion;
    this.c = paramThreadingService;
  }

  public void a(Products.OnChangeListener paramOnChangeListener)
  {
    this.f.add(paramOnChangeListener);
  }

  public boolean b()
  {
    if ((this.mPageInfo != null) && (this.mPageInfo.hasNextPage) && (this.a != null) && (this.b != null) && (this.c != null));
    for (int i = 1; ; i = 0)
      return i;
  }

  public void c()
  {
    if ((!this.d) && (this.mPageInfo != null) && (this.mPageInfo.hasNextPage) && (this.a != null) && (this.b != null) && (this.c != null))
    {
      String str = this.mPageInfo.endCursor;
      this.d = true;
      this.e = 0;
      a(str);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.content.model.Products
 * JD-Core Version:    0.6.0
 */