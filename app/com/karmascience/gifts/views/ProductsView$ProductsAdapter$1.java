package com.karmascience.gifts.views;

import android.view.View;
import com.karmascience.gifts.content.model.Products;
import com.karmascience.gifts.controllers.ProductsManager.GraphQLProductsRequestListener;
import java.util.List;

class ProductsView$ProductsAdapter$1
  implements ProductsManager.GraphQLProductsRequestListener
{
  public void a(Products paramProducts)
  {
    ProductsView.ProductsAdapter.a(this.a, null);
    if (ProductsView.b(this.a.a) != this.a);
    while (true)
    {
      return;
      if (paramProducts != null)
        paramProducts.a(new ProductsView.ProductsAdapter.1.1(this));
      ProductsView.e(this.a.a);
      ProductsView.ProductsAdapter.a(this.a).add(paramProducts);
      this.a.notifyDataSetInvalidated();
      this.a.notifyDataSetChanged();
    }
  }

  public boolean a(int paramInt, String paramString)
  {
    ProductsView.ProductsAdapter.a(this.a, null);
    if (ProductsView.b(this.a.a) != this.a);
    while (true)
    {
      return false;
      if (!this.a.a.l())
        continue;
      this.a.a.e().setVisibility(4);
      this.a.a.a(paramInt, paramString);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.ProductsView.ProductsAdapter.1
 * JD-Core Version:    0.6.0
 */