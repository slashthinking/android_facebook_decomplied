package com.karmascience.gifts.views;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.facebook.widget.UrlImage;
import com.karmascience.gifts.AnalyticsWrapper;
import com.karmascience.gifts.AnalyticsWrapper.MetricsEvent;
import com.karmascience.gifts.ThreadingService;
import com.karmascience.gifts.content.model.CardFront;
import com.karmascience.gifts.content.model.CardFronts;
import com.karmascience.gifts.content.model.Image;

class CardFrontView$CardAdapter extends PagerAdapter
  implements View.OnClickListener
{
  private final CardFronts b;
  private int c;
  private int d;

  public CardFrontView$CardAdapter(CardFrontView paramCardFrontView, CardFronts paramCardFronts)
  {
    this.b = paramCardFronts;
  }

  private void a(int paramInt1, int paramInt2)
  {
    int k;
    int n;
    if ((this.d == 0) && (this.c == 0) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      int i = this.a.g().getResources().getDimensionPixelSize(2131230865);
      int j = this.a.g().getResources().getDimensionPixelSize(2131230864);
      k = paramInt1 - i * 2 - j * 2;
      int m = paramInt2 * 640 / 832;
      n = k * 832 / 640;
      if (m > k)
        break label109;
      this.c = m;
    }
    for (this.d = paramInt2; ; this.d = n)
    {
      return;
      label109: this.c = k;
    }
  }

  public Object a(ViewGroup paramViewGroup, int paramInt)
  {
    a(paramViewGroup.getWidth(), paramViewGroup.getHeight());
    FrameLayout localFrameLayout1 = new FrameLayout(paramViewGroup.getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    UrlImage localUrlImage1 = new UrlImage(paramViewGroup.getContext());
    localUrlImage1.setPlaceHolderDrawable(null);
    localUrlImage1.setAdjustViewBounds(true);
    localUrlImage1.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localFrameLayout1.addView(localUrlImage1, localLayoutParams);
    if (paramViewGroup.getWidth() == 0)
      this.a.o().a(new CardFrontView.CardAdapter.1(this, paramViewGroup, localFrameLayout1));
    while (true)
    {
      UrlImage localUrlImage2 = (UrlImage)localFrameLayout1.getChildAt(0);
      CardFront localCardFront = this.b.a(paramInt % this.b.a());
      FrameLayout localFrameLayout2 = new FrameLayout(paramViewGroup.getContext());
      localFrameLayout1.setBackgroundDrawable(new ColorDrawable(localCardFront.f()));
      localFrameLayout1.setOnClickListener(this);
      localFrameLayout1.setTag(Integer.valueOf(paramInt));
      localFrameLayout2.addView(localFrameLayout1, localLayoutParams);
      Image localImage = localCardFront.a();
      Uri localUri = null;
      if (localImage != null)
        localUri = localCardFront.a().a();
      localUrlImage2.setImageParams(localUri);
      paramViewGroup.addView(localFrameLayout2);
      return localFrameLayout2;
      localFrameLayout1.setLayoutParams(new ViewGroup.LayoutParams(this.c, this.d));
    }
  }

  public void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }

  public boolean a(View paramView, Object paramObject)
  {
    return paramView.equals(paramObject);
  }

  public int b()
  {
    return this.b.a();
  }

  public void onClick(View paramView)
  {
    if (CardFrontView.a(this.a));
    while (true)
    {
      return;
      int i = CardFrontView.e(this.a).getCurrentItem();
      int j = ((Integer)paramView.getTag()).intValue();
      if (i == j)
      {
        CardFront localCardFront = this.b.a(j);
        this.a.n().c("Clicked Card Front").a("card_front_id", localCardFront.b()).a();
        String str = (String)CardFrontView.c(this.a).getTag();
        CardFrontView.a(this.a, localCardFront, str);
        continue;
      }
      CardFrontView.e(this.a).setCurrentItem(j, true);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.CardFrontView.CardAdapter
 * JD-Core Version:    0.6.0
 */