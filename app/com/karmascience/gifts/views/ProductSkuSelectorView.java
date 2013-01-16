package com.karmascience.gifts.views;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.karmascience.gifts.AnalyticsWrapper;
import com.karmascience.gifts.AnalyticsWrapper.MetricsEvent;
import com.karmascience.gifts.content.model.Product;
import com.karmascience.gifts.content.model.Sku;
import com.karmascience.gifts.ui.IViewManager;
import com.karmascience.gifts.ui.PlaceholderDrawable;
import java.util.HashMap;
import java.util.Map;

public class ProductSkuSelectorView extends KSViewController
{
  private Product a;
  private final PlaceholderDrawable b;
  private ListView c;
  private ProductSkuSelectorView.SkuAdapter d;
  private TextView e;
  private TextView f;

  public ProductSkuSelectorView(Activity paramActivity, Handler paramHandler, IViewManager paramIViewManager, Bundle paramBundle, String paramString)
  {
    super(paramActivity, paramHandler, paramIViewManager, paramBundle, paramString);
    this.a = ((Product)paramBundle.getParcelable("product_parcelable"));
    int[] arrayOfInt = a(g());
    this.b = new PlaceholderDrawable(arrayOfInt[0], arrayOfInt[1]);
  }

  private void a(Product paramProduct)
  {
    this.a = paramProduct;
    this.d = new ProductSkuSelectorView.SkuAdapter(this, paramProduct);
    this.c.setAdapter(this.d);
    this.f.setText(paramProduct.d());
    this.e.setText(paramProduct.c());
  }

  private void a(Sku paramSku, int paramInt)
  {
    Bundle localBundle;
    if (paramSku != null)
    {
      paramSku.c();
      localBundle = CommonViewUtils.a(12);
      localBundle.putParcelable("sku_parcelable", paramSku);
      n().c("Clicked SKU Option").a("product_id", this.a.e()).a("sku_id", paramSku.c()).a();
    }
    while (true)
    {
      localBundle.putParcelable("product_parcelable", this.a);
      b(localBundle);
      return;
      localBundle = CommonViewUtils.a(12);
      localBundle.putParcelable("sku_parcelable", null);
      n().c("Clicked SKU Option").a("product_id", this.a.e()).a();
    }
  }

  public static final int[] a(Activity paramActivity)
  {
    int[] arrayOfInt = new int[2];
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = (localDisplayMetrics.widthPixels - (2 * paramActivity.getResources().getDimensionPixelSize(2131230832) + paramActivity.getResources().getDimensionPixelSize(2131230833))) / 2 - 2 * paramActivity.getResources().getDimensionPixelSize(2131230837);
    int j = i * 533 / 720;
    arrayOfInt[0] = i;
    arrayOfInt[1] = j;
    return arrayOfInt;
  }

  public Map<String, String> B()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("product_id", this.a.e());
    return localHashMap;
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView1 = paramLayoutInflater.inflate(2130903506, paramViewGroup, false);
    this.c = ((ListView)localView1.findViewById(2131297725));
    this.c.setEmptyView(localView1.findViewById(2131296479));
    View localView2 = paramLayoutInflater.inflate(2130903507, this.c, false);
    this.e = ((TextView)localView2.findViewById(2131297576));
    this.f = ((TextView)localView2.findViewById(2131297726));
    this.c.addHeaderView(localView2, null, false);
    View localView3 = new View(g());
    localView3.setLayoutParams(new AbsListView.LayoutParams(-1, g().getResources().getDimensionPixelSize(2131230837)));
    this.c.addFooterView(localView3, null, false);
    return localView1;
  }

  public void a(View paramView, Bundle paramBundle)
  {
    super.a(paramView, paramBundle);
    if (this.d == null)
      a(this.a);
  }

  public String d()
  {
    return "Product SKU Selection";
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.ProductSkuSelectorView
 * JD-Core Version:    0.6.0
 */