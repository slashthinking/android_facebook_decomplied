package com.karmascience.gifts.controllers;

import android.net.Uri;
import com.karmascience.gifts.ThreadingService;
import com.karmascience.gifts.content.GraphPOJOApiMethod;

class OrderManager$2 extends GraphPOJOApiMethod<OrderManager.BasicUser>
{
  public void a(OrderManager.BasicUser paramBasicUser)
  {
    this.c.b(this.a, Uri.parse(OrderManager.BasicUser.a(paramBasicUser)), OrderManager.BasicUser.b(paramBasicUser), OrderManager.BasicUser.c(paramBasicUser));
    if (this.b != null)
      this.b.a(OrderManager.Order.c(OrderManager.a(this.c)).a());
  }

  public void b(int paramInt, String paramString)
  {
    if (this.b != null)
      this.b.a(paramInt, paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.controllers.OrderManager.2
 * JD-Core Version:    0.6.0
 */