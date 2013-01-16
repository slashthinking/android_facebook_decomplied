package com.karmascience.gifts.views;

import com.karmascience.gifts.content.model.Product;
import com.karmascience.gifts.controllers.OrderManager;
import com.karmascience.gifts.controllers.OrderManager.OrderSubmissionListener;
import com.karmascience.gifts.controllers.OrderManager.ProductInfo;

class OrderReviewView$1
  implements OrderManager.OrderSubmissionListener
{
  public void a()
  {
    this.a.u();
    if (this.a.p().b().a.m())
      this.a.b(CommonViewUtils.a(this.a.p().g(), true));
    while (true)
    {
      return;
      this.a.b(CommonViewUtils.a(8));
    }
  }

  public boolean a(int paramInt, String paramString)
  {
    if (this.a.l())
    {
      this.a.u();
      this.a.a(paramInt, paramString);
    }
    return false;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.OrderReviewView.1
 * JD-Core Version:    0.6.0
 */