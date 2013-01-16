package com.karmascience.gifts.views;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.widget.UrlImage;
import com.karmascience.gifts.AnalyticsWrapper;
import com.karmascience.gifts.AnalyticsWrapper.MetricsEvent;
import com.karmascience.gifts.content.model.CardFront;
import com.karmascience.gifts.content.model.Image;
import com.karmascience.gifts.content.model.Product;
import com.karmascience.gifts.content.model.Sku;
import com.karmascience.gifts.controllers.OrderManager;
import com.karmascience.gifts.controllers.OrderManager.CardInfo;
import com.karmascience.gifts.controllers.OrderManager.ProductInfo;
import com.karmascience.gifts.controllers.OrderManager.UserInfo;
import com.karmascience.gifts.ui.IViewManager;

public class OrderReviewView extends KSViewController
  implements View.OnClickListener
{
  private UrlImage a;
  private TextView b;
  private LinearLayout c;
  private TextView d;
  private TextView e;
  private TextView f;
  private View g;
  private TextView h;
  private TextView i;
  private UrlImage j;
  private TextView k;
  private TextView l;

  public OrderReviewView(Activity paramActivity, Handler paramHandler, IViewManager paramIViewManager, Bundle paramBundle, String paramString)
  {
    super(paramActivity, paramHandler, paramIViewManager, paramBundle, paramString);
  }

  private void C()
  {
    OrderManager.UserInfo localUserInfo = p().d();
    this.b.setText(localUserInfo.b);
    this.a.setImageParams(localUserInfo.c);
    OrderManager.ProductInfo localProductInfo = p().b();
    int m;
    int n;
    label188: OrderManager.CardInfo localCardInfo;
    UrlImage localUrlImage;
    if (localProductInfo.b != null)
    {
      m = localProductInfo.b.d();
      n = localProductInfo.b.e();
      int i1 = m + n;
      this.d.setText(CommonViewUtils.c(m));
      this.f.setText(CommonViewUtils.c(n));
      this.e.setText(CommonViewUtils.c(i1));
      this.c.removeAllViews();
      View localView = D();
      this.c.addView(localView);
      if (!p().b().a.m())
        break label304;
      this.l.setText(2131362272);
      String str3 = CommonViewUtils.d(localUserInfo.b);
      String str4 = g().getString(2131362274, new Object[] { str3 });
      this.k.setText(str4);
      localCardInfo = p().f();
      this.i.setText(localCardInfo.c);
      localUrlImage = this.j;
      if (localCardInfo.a.a() == null)
        break label354;
    }
    label304: label354: for (Uri localUri = localCardInfo.a.a().a(); ; localUri = null)
    {
      localUrlImage.setImageParams(localUri);
      this.h.setText(localCardInfo.a.c());
      this.j.setBackgroundDrawable(new ColorDrawable(localCardInfo.a.f()));
      return;
      m = localProductInfo.a.i();
      n = localProductInfo.a.r();
      break;
      this.l.setText(2131362271);
      String str1 = CommonViewUtils.d(localUserInfo.b);
      String str2 = g().getString(2131362273, new Object[] { str1 });
      this.k.setText(str2);
      break label188;
    }
  }

  private View D()
  {
    OrderManager.ProductInfo localProductInfo = p().b();
    View localView1;
    String str5;
    label98: int m;
    Uri localUri;
    String str2;
    label140: TextView localTextView1;
    if (localProductInfo.b != null)
    {
      localView1 = View.inflate(g(), 2130903447, null);
      View localView2 = localView1.findViewById(2131297573);
      String str1 = localProductInfo.a.c();
      if (localProductInfo.b == null)
        break label270;
      String str4 = localProductInfo.a.b("itunes_recommended_content_title");
      if ((!localProductInfo.a.p()) || (str4 == null))
        break label258;
      str5 = g().getResources().getString(2131362276, new Object[] { str4 });
      m = localProductInfo.b.d();
      Image localImage = localProductInfo.b.f();
      localUri = null;
      if (localImage != null)
        localUri = localProductInfo.b.f().a();
      str2 = str5;
      UrlImage localUrlImage = (UrlImage)localView2.findViewById(2131297574);
      localUrlImage.setAdjustViewBounds(true);
      localUrlImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localUrlImage.setImageParams(localUri);
      ((TextView)localView2.findViewById(2131297576)).setText(str1);
      localTextView1 = (TextView)localView2.findViewById(2131297577);
      TextView localTextView2 = (TextView)localView2.findViewById(2131297578);
      localTextView2.setText(CommonViewUtils.b(m));
      if (m < 0)
        localTextView2.setVisibility(8);
      if (str2 == null)
        break label316;
      localTextView1.setText(str2);
    }
    while (true)
    {
      return localView1;
      localView1 = View.inflate(g(), 2130903446, null);
      break;
      label258: str5 = localProductInfo.b.a();
      break label98;
      label270: m = localProductInfo.a.i();
      if (localProductInfo.a.o() != null)
      {
        localUri = localProductInfo.a.o().a();
        str2 = null;
        break label140;
      }
      localUri = null;
      str2 = null;
      break label140;
      label316: String str3 = CommonViewUtils.d(p().d().b);
      localTextView1.setText(g().getResources().getString(2131362266, new Object[] { str3 }));
    }
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView1 = paramLayoutInflater.inflate(2130903443, paramViewGroup, false);
    View localView2 = localView1.findViewById(2131297579);
    this.b = ((TextView)localView2.findViewById(2131297582));
    this.a = ((UrlImage)localView2.findViewById(2131297580));
    this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.c = ((LinearLayout)localView1.findViewById(2131297552));
    this.d = ((TextView)localView1.findViewById(2131297564));
    this.f = ((TextView)localView1.findViewById(2131297567));
    this.e = ((TextView)localView1.findViewById(2131297570));
    this.g = localView1.findViewById(2131297556);
    this.h = ((TextView)localView1.findViewById(2131297559));
    this.i = ((TextView)localView1.findViewById(2131297560));
    this.j = ((UrlImage)localView1.findViewById(2131297557));
    this.j.setAdjustViewBounds(true);
    this.k = ((TextView)localView1.findViewById(2131297555));
    this.l = ((TextView)localView1.findViewById(2131297554));
    Button localButton = (Button)localView1.findViewById(2131297571);
    localButton.setOnClickListener(this);
    if (p().b().a.m())
    {
      localButton.setBackgroundResource(2130837613);
      localButton.setText(2131362268);
    }
    while (true)
    {
      localView1.findViewById(2131297572).setOnClickListener(this);
      return localView1;
      localButton.setBackgroundResource(2130837620);
      localButton.setText(2131362267);
    }
  }

  public void a()
  {
    super.a();
    C();
  }

  public String d()
  {
    return "Order Review";
  }

  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131297571)
    {
      n().c("Clicked Give Gift").a();
      p().a(new OrderReviewView.1(this), o());
      t();
    }
    while (true)
    {
      return;
      if (paramView.getId() == 2131297572)
      {
        b(CommonViewUtils.b("http://www.facebook.com/gifts_terms"));
        continue;
      }
    }
  }

  public boolean v()
  {
    if (p().h());
    for (int m = 1; ; m = 0)
      return m;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.OrderReviewView
 * JD-Core Version:    0.6.0
 */