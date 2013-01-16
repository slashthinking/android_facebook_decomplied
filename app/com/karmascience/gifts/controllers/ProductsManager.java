package com.karmascience.gifts.controllers;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import com.karmascience.gifts.ThreadingService;
import com.karmascience.gifts.content.AsyncMethodRunner;
import com.karmascience.gifts.content.model.ProductCategories;
import com.karmascience.gifts.content.model.iTunesContentResults;
import com.karmascience.gifts.content.model.iTunesSearchResults;
import com.karmascience.gifts.views.ProductsView;
import java.util.ArrayList;

public class ProductsManager
{
  private static final String a = ProductsManager.class.getName();
  private final SparseArray<ArrayList<ProductsManager.GraphQLProductsRequestListener>> b = new SparseArray();
  private final ArrayList<ProductsManager.GraphQLProductCategoriesRequestListener> c = new ArrayList();
  private final ThreadingService d;
  private final AsyncMethodRunner e;
  private final ProductsManager.ProductImageDimensionHolder f;
  private ProductCategories g;

  public ProductsManager(ThreadingService paramThreadingService, AsyncMethodRunner paramAsyncMethodRunner, Activity paramActivity)
  {
    this.e = paramAsyncMethodRunner;
    this.d = paramThreadingService;
    this.f = new ProductsManager.ProductImageDimensionHolder(a(paramActivity), ProductsView.b(paramActivity));
  }

  private static final int[] a(Activity paramActivity)
  {
    int[] arrayOfInt = new int[2];
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = localDisplayMetrics.widthPixels;
    int j = i * 533 / 720;
    arrayOfInt[0] = i;
    arrayOfInt[1] = j;
    return arrayOfInt;
  }

  public ProductCategories a()
  {
    return this.g;
  }

  public ProductsManager.GraphQLProductsRequestBuilder a(ProductsManager.GraphQLProductsRequestListener paramGraphQLProductsRequestListener)
  {
    return new ProductsManager.GraphQLProductsRequestBuilder(this, paramGraphQLProductsRequestListener);
  }

  public void a(ProductsManager.GraphQLProductCategoriesRequestListener paramGraphQLProductCategoriesRequestListener)
  {
    if (this.c.isEmpty())
    {
      this.c.add(paramGraphQLProductCategoriesRequestListener);
      ProductsManager.3 local3 = new ProductsManager.3(this, "GetCategories", this.d, 2, ProductCategories.class);
      this.e.a(local3, "node(295377273895016){product_categories{nodes{id,name,classification}}}");
    }
    while (true)
    {
      return;
      this.c.add(paramGraphQLProductCategoriesRequestListener);
    }
  }

  public void a(String paramString1, int paramInt, String paramString2, ProductsManager.iTunesSearchRequestListener paramiTunesSearchRequestListener)
  {
    ProductsManager.2 local2 = new ProductsManager.2(this, paramString1, paramInt, paramString2, this.d, iTunesSearchResults.class, paramiTunesSearchRequestListener);
    this.e.a(local2, null);
  }

  public void a(String[] paramArrayOfString, int paramInt, ProductsManager.iTunesRequestListener paramiTunesRequestListener)
  {
    ProductsManager.1 local1 = new ProductsManager.1(this, paramArrayOfString, paramInt, this.d, iTunesContentResults.class, paramiTunesRequestListener);
    this.e.a(local1, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.controllers.ProductsManager
 * JD-Core Version:    0.6.0
 */