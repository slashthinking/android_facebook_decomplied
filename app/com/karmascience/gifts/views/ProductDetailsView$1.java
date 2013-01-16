package com.karmascience.gifts.views;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.LinearLayout;

class ProductDetailsView$1
  implements ViewPager.OnPageChangeListener
{
  View a = ProductDetailsView.a(this.b).getChildAt(0);

  public void a(int paramInt)
  {
    if (this.a != null)
      this.a.setSelected(false);
    View localView = ProductDetailsView.a(this.b).getChildAt(paramInt);
    if (localView != null)
      localView.setSelected(true);
    this.a = localView;
  }

  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
  }

  public void b(int paramInt)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.ProductDetailsView.1
 * JD-Core Version:    0.6.0
 */