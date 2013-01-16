package com.karmascience.gifts.views;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.karmascience.gifts.AnalyticsWrapper;
import com.karmascience.gifts.AnalyticsWrapper.MetricsEvent;
import com.karmascience.gifts.ThreadingService;
import com.karmascience.gifts.content.model.CardCategories;
import com.karmascience.gifts.content.model.CardCategory;
import com.karmascience.gifts.content.model.CardFront;
import com.karmascience.gifts.controllers.CardManager;
import com.karmascience.gifts.controllers.CardManager.GraphQLCardFrontsRequestListener;
import com.karmascience.gifts.controllers.OrderManager;
import com.karmascience.gifts.ui.IViewManager;

public class CardFrontView extends KSViewController
{
  private final boolean a;
  private final boolean b;
  private ViewPager c;
  private View d;
  private LinearLayout e;
  private CardCategories f;
  private View g;
  private int h;
  private int i;
  private View j;
  private CardManager.GraphQLCardFrontsRequestListener k;

  public CardFrontView(Activity paramActivity, Handler paramHandler, IViewManager paramIViewManager, Bundle paramBundle, String paramString)
  {
    super(paramActivity, paramHandler, paramIViewManager, paramBundle, paramString);
    this.a = paramBundle.getBoolean("read_only");
    this.b = paramBundle.getBoolean("is_order_review", false);
  }

  private void C()
  {
    int i1;
    int i5;
    if ((this.g != null) && (this.g.getWidth() > 0) && (this.g.getHeight() > 0))
      if ((this.i == 0) && (this.h == 0))
      {
        int m = g().getResources().getDimensionPixelSize(2131230865);
        int n = g().getResources().getDimensionPixelSize(2131230864);
        i1 = this.g.getWidth() - m * 2 - n * 2;
        int i2 = this.g.getPaddingBottom() + this.g.getPaddingTop();
        int i3 = this.g.getHeight() - i2;
        int i4 = i3 * 640 / 832;
        i5 = i1 * 832 / 640;
        if (i4 > i1)
          break label154;
        this.h = i4;
        this.i = i3;
      }
    while (true)
    {
      return;
      label154: this.h = i1;
      this.i = i5;
      continue;
      o().a(new CardFrontView.5(this), 50L);
    }
  }

  private View a(CardCategory paramCardCategory, ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, boolean paramBoolean)
  {
    View localView = paramLayoutInflater.inflate(2130903090, paramViewGroup, false);
    localView.setSelected(paramBoolean);
    ((TextView)localView.findViewById(2131296482)).setText(paramCardCategory.b());
    localView.setTag(paramCardCategory.a());
    localView.setOnClickListener(new CardFrontView.2(this));
    if (paramBoolean)
      this.j = localView;
    return localView;
  }

  private void a(CardCategories paramCardCategories)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(g());
    int m = 0;
    if (m < paramCardCategories.a())
    {
      CardCategory localCardCategory = paramCardCategories.a(m);
      LinearLayout localLinearLayout = this.e;
      if (m == 0);
      for (boolean bool = true; ; bool = false)
      {
        View localView1 = a(localCardCategory, localLinearLayout, localLayoutInflater, bool);
        this.e.addView(localView1);
        if (m + 1 < paramCardCategories.a())
        {
          View localView2 = localLayoutInflater.inflate(2130903089, this.e, false);
          this.e.addView(localView2);
        }
        m++;
        break;
      }
    }
  }

  private void a(CardCategory paramCardCategory)
  {
    if (paramCardCategory == null);
    while (true)
    {
      return;
      n().c("Clicked Card Category").a("card_category_id", paramCardCategory.a()).a();
      this.k = new CardFrontView.3(this);
      this.c.setAdapter(null);
      this.d.setVisibility(0);
      if ((this.i == 0) && (this.h == 0))
      {
        C();
        o().a(new CardFrontView.4(this, paramCardCategory));
        continue;
      }
      q().a(paramCardCategory.a(), this.h, this.i, this.k);
    }
  }

  private void a(CardFront paramCardFront, String paramString)
  {
    p().a(paramCardFront, this.f.a(paramString));
    if (this.b);
    for (Bundle localBundle = CommonViewUtils.c(null); ; localBundle = CommonViewUtils.a(6))
    {
      b(localBundle);
      return;
    }
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView1 = paramLayoutInflater.inflate(2130903088, paramViewGroup, false);
    this.g = localView1.findViewById(2131296477);
    this.c = ((ViewPager)localView1.findViewById(2131296478));
    this.d = localView1.findViewById(2131296479);
    int m = g().getResources().getDimensionPixelSize(2131230866);
    this.c.setPageMargin(m);
    this.c.setClipChildren(false);
    this.c.setOffscreenPageLimit(2);
    this.e = ((LinearLayout)localView1.findViewById(2131296481));
    View localView2 = localView1.findViewById(2131296476);
    q().a(new CardFrontView.1(this, localView2, localView1));
    return localView1;
  }

  public String d()
  {
    return "Card Front Selection";
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.CardFrontView
 * JD-Core Version:    0.6.0
 */