package com.karmascience.gifts.views;

import android.app.Activity;
import android.view.View;
import com.karmascience.gifts.AnalyticsWrapper;
import com.karmascience.gifts.AnalyticsWrapper.MetricsEvent;
import com.karmascience.gifts.controllers.OrderManager;
import com.karmascience.gifts.controllers.OrderManager.UserInfo;
import com.karmascience.gifts.controllers.OrderManager.UserInfoListener;

class ProductsView$3
  implements OrderManager.UserInfoListener
{
  public void a(int paramInt, String paramString)
  {
    if (this.b.l())
    {
      this.b.e().setVisibility(4);
      this.b.n().c("Launch Failed").a();
      this.b.a(paramInt, paramString);
      this.b.g().finish();
    }
  }

  public void a(OrderManager.UserInfo paramUserInfo)
  {
    this.b.n().b(paramUserInfo.a);
    this.b.p().a(this.a, this.b.o());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.ProductsView.3
 * JD-Core Version:    0.6.0
 */