package com.karmascience.gifts.controllers;

import android.util.SparseArray;
import com.facebook.common.util.Log;
import com.karmascience.gifts.ThreadingService;
import com.karmascience.gifts.content.GraphPOJOApiMethod;
import com.karmascience.gifts.content.graphql.ProductsQueryHelper.ProductsQueryCompanion;
import com.karmascience.gifts.content.model.Products;
import java.util.ArrayList;
import java.util.Iterator;

class ProductsManager$GraphQLProductsRequestBuilder$1 extends GraphPOJOApiMethod<Products>
{
  public void a(Products paramProducts)
  {
    try
    {
      ArrayList localArrayList = (ArrayList)ProductsManager.c(this.c.a).get(this.a);
      ProductsManager.c(this.c.a).remove(this.a);
      paramProducts.a(ProductsManager.f(this.c.a), this.b, ProductsManager.e(this.c.a));
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
        ((ProductsManager.GraphQLProductsRequestListener)localIterator.next()).a(paramProducts);
    }
    catch (Exception localException)
    {
      Log.b("Couldn't parse products request", localException);
    }
  }

  public void b(int paramInt, String paramString)
  {
    ArrayList localArrayList = (ArrayList)ProductsManager.c(this.c.a).get(this.a);
    ProductsManager.c(this.c.a).remove(this.a);
    if (localArrayList != null)
    {
      int i = localArrayList.size();
      for (int j = 0; j < i; j++)
      {
        ProductsManager.GraphQLProductsRequestListener localGraphQLProductsRequestListener = (ProductsManager.GraphQLProductsRequestListener)localArrayList.get(j);
        if ((localGraphQLProductsRequestListener == null) || (!localGraphQLProductsRequestListener.a(paramInt, paramString)))
          continue;
        ProductsManager.GraphQLProductsRequestBuilder.a(this.c, localGraphQLProductsRequestListener);
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.controllers.ProductsManager.GraphQLProductsRequestBuilder.1
 * JD-Core Version:    0.6.0
 */