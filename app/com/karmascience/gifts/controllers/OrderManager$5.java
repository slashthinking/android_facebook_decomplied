package com.karmascience.gifts.controllers;

import com.karmascience.gifts.ThreadingService;
import com.karmascience.gifts.content.ShareOrderApiMethod;

class OrderManager$5 extends ShareOrderApiMethod<OrderManager.Gift>
{
  public void a(OrderManager.Gift paramGift)
  {
    if (OrderManager.Order.f(OrderManager.a(this.c)) == null)
      OrderManager.Order.a(OrderManager.a(this.c), paramGift);
    if (this.a != null)
    {
      this.a.a();
      OrderManager.a(this.c, false);
    }
  }

  public void b(int paramInt, String paramString)
  {
    if (this.a != null)
    {
      if (this.a.a(paramInt, paramString))
        this.c.a(this.a, this.b);
      OrderManager.a(this.c, false);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.controllers.OrderManager.5
 * JD-Core Version:    0.6.0
 */