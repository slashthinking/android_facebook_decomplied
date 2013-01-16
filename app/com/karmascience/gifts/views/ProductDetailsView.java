package com.karmascience.gifts.views;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.widget.UrlImage;
import com.karmascience.gifts.AnalyticsWrapper;
import com.karmascience.gifts.AnalyticsWrapper.MetricsEvent;
import com.karmascience.gifts.content.model.Product;
import com.karmascience.gifts.content.model.Sku;
import com.karmascience.gifts.controllers.OrderManager;
import com.karmascience.gifts.controllers.OrderManager.UserInfo;
import com.karmascience.gifts.ui.IViewManager;
import com.karmascience.gifts.ui.PlaceholderDrawable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDetailsView extends KSViewController
  implements View.OnClickListener
{
  private static final String a = ProductDetailsView.class.getSimpleName();
  private final Drawable b;
  private TextView c;
  private ViewPager d;
  private WebView e;
  private FrameLayout f;
  private Product g;
  private Sku h;
  private LinearLayout i;
  private TextView j;
  private TextView k;
  private Button l;
  private boolean m = s().getBoolean("is_order_review");
  private String n = s().getString("order_product_id");

  public ProductDetailsView(Activity paramActivity, Handler paramHandler, IViewManager paramIViewManager, Bundle paramBundle, String paramString)
  {
    super(paramActivity, paramHandler, paramIViewManager, paramBundle, paramString);
    this.g = ((Product)paramBundle.getParcelable("product_parcelable"));
    this.h = ((Sku)paramBundle.getParcelable("sku_parcelable"));
    int[] arrayOfInt = a(g());
    this.b = new PlaceholderDrawable(arrayOfInt[0], arrayOfInt[1]);
  }

  private View a(Product paramProduct, ViewGroup paramViewGroup)
  {
    View localView = ((LayoutInflater)g().getSystemService("layout_inflater")).inflate(2130903255, paramViewGroup, false);
    UrlImage localUrlImage = (UrlImage)localView.findViewById(2131297026);
    TextView localTextView1 = (TextView)localView.findViewById(2131297027);
    TextView localTextView2 = (TextView)localView.findViewById(2131297028);
    localUrlImage.setImageParams(Uri.parse(paramProduct.b("itunes_recommended_image_url")));
    localTextView1.setText(paramProduct.b("itunes_recommended_content_title"));
    localTextView2.setText(paramProduct.b("itunes_recommended_content_info"));
    return localView;
  }

  private void a(Product paramProduct, Sku paramSku, View paramView)
  {
    if (paramProduct != null)
    {
      paramView.setVisibility(0);
      String str1 = paramProduct.c();
      this.j.setText(str1);
      String str6;
      if (paramSku != null)
      {
        this.k.setText(paramSku.a());
        this.k.setVisibility(0);
        if (this.g.c("itunes_has_recommended"))
        {
          this.f.setVisibility(0);
          this.f.removeAllViews();
          this.f.addView(a(this.g, this.f));
        }
        if (paramSku == null)
          break label334;
        String str5 = paramSku.b();
        if ((str5 == null) || (str5.trim().equals("")))
          break label325;
        str6 = str5;
        label125: this.e.loadDataWithBaseURL(null, "<style> h3, p, ul, li { font-family: Roboto; font-size: 12; color:#333333; } h3 { color:#000000; } p { } ul { } li { } p.forwhom { color:#808080; } </style> " + str6, "text/html", "UTF-8", null);
        this.c.setText(CommonViewUtils.b(paramSku.d()));
      }
      for (List localList = paramSku.g(); ; localList = paramProduct.s())
      {
        ProductDetailsView.ProductImagePageAdapter localProductImagePageAdapter = new ProductDetailsView.ProductImagePageAdapter(this, localList);
        this.d.setAdapter(localProductImagePageAdapter);
        this.i.removeAllViews();
        if (localProductImagePageAdapter.b() <= 1)
          break label416;
        for (int i1 = 0; i1 < localProductImagePageAdapter.b(); i1++)
        {
          View localView = View.inflate(g(), 2130903095, null);
          this.i.addView(localView);
          if (i1 != 0)
            continue;
          localView.setSelected(true);
        }
        String str2 = CommonViewUtils.d(p().d().b);
        String str3 = g().getResources().getString(2131362258, new Object[] { str2 });
        this.k.setText(str3);
        this.k.setVisibility(0);
        break;
        label325: str6 = paramProduct.j();
        break label125;
        label334: this.e.loadDataWithBaseURL(null, "<style> h3, p, ul, li { font-family: Roboto; font-size: 12; color:#333333; } h3 { color:#000000; } p { } ul { } li { } p.forwhom { color:#808080; } </style> " + paramProduct.j(), "text/html", "UTF-8", null);
        String str4 = CommonViewUtils.a(paramProduct.h(), paramProduct.i());
        this.c.setText(str4);
      }
      this.d.setOnPageChangeListener(new ProductDetailsView.1(this));
    }
    while (true)
    {
      return;
      label416: this.i.setVisibility(8);
    }
  }

  public static int[] a(Activity paramActivity)
  {
    int[] arrayOfInt = new int[2];
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i1 = localDisplayMetrics.widthPixels;
    int i2 = i1 * 533 / 720;
    arrayOfInt[0] = i1;
    arrayOfInt[1] = i2;
    return arrayOfInt;
  }

  public Map<String, String> B()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("product_id", this.g.e());
    if (this.h != null)
      localHashMap.put("sku_id", this.h.c());
    return localHashMap;
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903504, paramViewGroup, false);
    this.d = ((ViewPager)localView.findViewById(2131297718));
    int[] arrayOfInt = a(g());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(arrayOfInt[0], arrayOfInt[1]);
    this.d.setLayoutParams(localLayoutParams);
    this.c = ((TextView)localView.findViewById(2131297578));
    this.e = ((WebView)localView.findViewById(2131297723));
    this.f = ((FrameLayout)localView.findViewById(2131297722));
    this.l = ((Button)localView.findViewById(2131297720));
    Button localButton = (Button)localView.findViewById(2131297721);
    if (this.m)
    {
      localButton.setVisibility(0);
      this.l.setVisibility(8);
    }
    localButton.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.i = ((LinearLayout)localView.findViewById(2131297719));
    this.j = ((TextView)localView.findViewById(2131297576));
    this.k = ((TextView)localView.findViewById(2131297716));
    a(this.g, this.h, localView);
    return localView;
  }

  public String d()
  {
    return "Product Details";
  }

  public void onClick(View paramView)
  {
    String str;
    if (paramView.getId() == 2131297720)
    {
      AnalyticsWrapper.MetricsEvent localMetricsEvent = n().c("Clicked Add Product").a("product_id", this.g.e());
      if (this.h == null)
        break label99;
      str = this.h.c();
      localMetricsEvent.a("sku_id", str).a();
      p().a(this.g, this.h);
      if (!this.g.q())
        break label104;
    }
    label99: label104: for (Bundle localBundle = CommonViewUtils.a(18); ; localBundle = CommonViewUtils.a(4))
    {
      b(localBundle);
      return;
      str = null;
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.ProductDetailsView
 * JD-Core Version:    0.6.0
 */