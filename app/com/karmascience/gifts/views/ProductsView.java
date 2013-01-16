package com.karmascience.gifts.views;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.widget.UrlImage;
import com.karmascience.gifts.AnalyticsWrapper;
import com.karmascience.gifts.AnalyticsWrapper.MetricsEvent;
import com.karmascience.gifts.Utils;
import com.karmascience.gifts.content.model.Product;
import com.karmascience.gifts.content.model.ProductCategories;
import com.karmascience.gifts.content.model.ProductCategory;
import com.karmascience.gifts.controllers.OrderManager;
import com.karmascience.gifts.controllers.OrderManager.UserInfo;
import com.karmascience.gifts.ui.IViewManager;
import com.karmascience.gifts.ui.PlaceholderDrawable;
import com.nineoldandroids.view.ViewHelper;
import java.util.ArrayList;

public class ProductsView extends KSViewController
{
  private static final String a = ProductsView.class.getName();
  private final Drawable b;
  private final Drawable c;
  private ListView d;
  private ProductsView.ProductsAdapter e;
  private String f;
  private ProductCategories g;
  private TextView h;
  private UrlImage i;
  private boolean j;
  private View k;
  private View l;

  public ProductsView(Activity paramActivity, Handler paramHandler, IViewManager paramIViewManager, Bundle paramBundle, String paramString)
  {
    super(paramActivity, paramHandler, paramIViewManager, paramBundle, paramString);
    int[] arrayOfInt1 = a(g());
    this.b = new PlaceholderDrawable(arrayOfInt1[0], arrayOfInt1[1]);
    int[] arrayOfInt2 = b(g());
    this.c = new PlaceholderDrawable(arrayOfInt2[0], arrayOfInt2[1]);
  }

  private void C()
  {
    this.l.setVisibility(8);
    this.k.setVisibility(0);
  }

  private void D()
  {
    this.l.setVisibility(0);
    this.k.setVisibility(8);
  }

  private void E()
  {
    int m = 0;
    C();
    ArrayList localArrayList = new ArrayList();
    if (this.f != null)
      if (this.f.equals("_RECOMMENDED_"))
      {
        String str3 = CommonViewUtils.d(p().d().b);
        localArrayList.add(new ProductsView.CategoryPair(null, g().getString(2131362245, new Object[] { str3 })));
      }
    while (true)
    {
      this.e = new ProductsView.ProductsAdapter(this, localArrayList);
      this.d.setAdapter(this.e);
      this.d.setOnItemClickListener(this.e);
      return;
      String str2 = this.g.b(this.f);
      localArrayList.add(new ProductsView.CategoryPair(this.f, str2));
      continue;
      String str1 = CommonViewUtils.d(p().d().b);
      localArrayList.add(new ProductsView.CategoryPair(null, g().getString(2131362245, new Object[] { str1 })));
      while (m < this.g.a())
      {
        ProductCategory localProductCategory = this.g.a(m);
        localArrayList.add(new ProductsView.CategoryPair(localProductCategory.b(), localProductCategory.a()));
        m++;
      }
    }
  }

  private void F()
  {
    new ProductsView.RecipientCantReceiveAlcoholDialogFragment(this, p().d().b, null).a(h().g(), "recipient_cant_receive_alcohol_dialog");
  }

  private void a(String paramString)
  {
    if ((Utils.a(paramString, this.f)) && (this.e != null) && (this.e.getCount() > 0));
    while (true)
    {
      return;
      this.f = paramString;
      E();
    }
  }

  public static final int[] a(Activity paramActivity)
  {
    int[] arrayOfInt = new int[2];
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int m = 2 * paramActivity.getResources().getDimensionPixelSize(2131230832) + 2 * paramActivity.getResources().getDimensionPixelSize(2131230837);
    int n = localDisplayMetrics.widthPixels - m;
    int i1 = n * 533 / 720;
    arrayOfInt[0] = n;
    arrayOfInt[1] = i1;
    return arrayOfInt;
  }

  private static final void b(View paramView, float paramFloat)
  {
    ViewHelper.setAlpha(paramView, paramFloat);
  }

  public static final int[] b(Activity paramActivity)
  {
    int[] arrayOfInt = new int[2];
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int m = 4 * paramActivity.getResources().getDimensionPixelSize(2131230832);
    int n = localDisplayMetrics.widthPixels / 2 - m;
    int i1 = n * 533 / 720;
    arrayOfInt[0] = n;
    arrayOfInt[1] = i1;
    return arrayOfInt;
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView1 = paramLayoutInflater.inflate(2130903512, paramViewGroup, false);
    this.d = ((ListView)localView1.findViewById(2131297743));
    View localView2 = paramLayoutInflater.inflate(2130903517, this.d, false);
    this.h = ((TextView)localView2.findViewById(2131297547));
    this.i = ((UrlImage)localView2.findViewById(2131297580));
    this.d.addHeaderView(localView2, null, false);
    View localView3 = new View(g());
    new AbsListView.LayoutParams(-1, 0);
    localView3.setLayoutParams(new AbsListView.LayoutParams(-1, g().getResources().getDimensionPixelSize(2131230832)));
    this.d.addFooterView(localView3, null, false);
    this.l = localView1.findViewById(2131297744);
    this.k = localView1.findViewById(2131296360);
    this.d.setEmptyView(localView1.findViewById(2131296479));
    return localView1;
  }

  public void a(Bundle paramBundle)
  {
    a(paramBundle.getString("selected_category_id"));
  }

  public void a(View paramView, Bundle paramBundle)
  {
    ProductsView.3 local3 = new ProductsView.3(this, new ProductsView.2(this, new ProductsView.1(this)));
    p().b(local3, o());
  }

  public void a(Product paramProduct, int paramInt)
  {
    n().c("Clicked Product").a("product_id", paramProduct.e()).a("row_number", Integer.toString(paramInt)).a();
    if ((paramProduct.q()) && (!this.j))
      F();
    while (true)
    {
      return;
      paramProduct.e();
      if (paramProduct.b() != 1)
        break;
      Bundle localBundle2 = CommonViewUtils.a(12);
      localBundle2.putParcelable("product_parcelable", paramProduct);
      localBundle2.putParcelable("sku_parcelable", paramProduct.a(0));
      b(localBundle2);
    }
    if (paramProduct.p());
    for (int m = 16; ; m = 13)
    {
      Bundle localBundle1 = CommonViewUtils.a(m);
      localBundle1.putParcelable("product_parcelable", paramProduct);
      b(localBundle1);
      break;
    }
  }

  public String b()
  {
    return g().getString(2131362227);
  }

  public void c()
  {
    n().c("Clicked Filter").a();
    if (this.g != null)
    {
      Bundle localBundle = CommonViewUtils.a(15);
      localBundle.putString("selected_category_id", this.f);
      b(localBundle);
    }
  }

  public String d()
  {
    return "Product Browse";
  }

  public void z()
  {
    super.z();
    this.d.setAdapter(null);
    this.d.setOnItemClickListener(null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.ProductsView
 * JD-Core Version:    0.6.0
 */