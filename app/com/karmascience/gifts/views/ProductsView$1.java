package com.karmascience.gifts.views;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.karmascience.gifts.content.model.ProductCategories;
import com.karmascience.gifts.controllers.ProductsManager.GraphQLProductCategoriesRequestListener;

class ProductsView$1
  implements ProductsManager.GraphQLProductCategoriesRequestListener
{
  public void a(ProductCategories paramProductCategories)
  {
    ProductsView.a(this.a, paramProductCategories);
    ProductsView.a(this.a, null);
    ProductsView.a(this.a).setSelectionAfterHeaderView();
    ProductsView.a(this.a).setAdapter(ProductsView.b(this.a));
    ProductsView.a(this.a).setOnItemClickListener(ProductsView.b(this.a));
    this.a.e().setVisibility(0);
    String str = this.a.s().getString("initial_category_id");
    ProductsView.a(this.a, str);
  }

  public boolean a(int paramInt, String paramString)
  {
    if (this.a.l())
    {
      this.a.e().setVisibility(4);
      this.a.a(paramInt, paramString);
    }
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.ProductsView.1
 * JD-Core Version:    0.6.0
 */