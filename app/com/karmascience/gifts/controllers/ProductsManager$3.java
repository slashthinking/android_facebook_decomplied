package com.karmascience.gifts.controllers;

import com.facebook.common.util.Log;
import com.karmascience.gifts.ThreadingService;
import com.karmascience.gifts.content.GraphPOJOApiMethod;
import com.karmascience.gifts.content.model.ProductCategories;
import java.util.ArrayList;
import java.util.Iterator;

class ProductsManager$3 extends GraphPOJOApiMethod<ProductCategories>
{
  public void a(ProductCategories paramProductCategories)
  {
    try
    {
      ProductsManager.a(this.a, paramProductCategories);
      Iterator localIterator = ProductsManager.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        ProductsManager.GraphQLProductCategoriesRequestListener localGraphQLProductCategoriesRequestListener = (ProductsManager.GraphQLProductCategoriesRequestListener)localIterator.next();
        if (localGraphQLProductCategoriesRequestListener == null)
          continue;
        localGraphQLProductCategoriesRequestListener.a(ProductsManager.b(this.a));
      }
    }
    catch (Exception localException)
    {
      Log.b("Can't parse product categories", localException);
      b(1003, null);
    }
  }

  public void b(int paramInt, String paramString)
  {
    Iterator localIterator = ProductsManager.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      ProductsManager.GraphQLProductCategoriesRequestListener localGraphQLProductCategoriesRequestListener = (ProductsManager.GraphQLProductCategoriesRequestListener)localIterator.next();
      if ((localGraphQLProductCategoriesRequestListener == null) || (!localGraphQLProductCategoriesRequestListener.a(paramInt, paramString)))
        continue;
      this.a.a(localGraphQLProductCategoriesRequestListener);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.controllers.ProductsManager.3
 * JD-Core Version:    0.6.0
 */