package com.karmascience.gifts.controllers;

import android.net.Uri;
import com.karmascience.gifts.ThreadingService;
import com.karmascience.gifts.content.GraphPOJOApiMethod;

class OrderManager$1 extends GraphPOJOApiMethod<OrderManager.BasicUser>
{
  public void a(OrderManager.BasicUser paramBasicUser)
  {
    this.c.a(this.a, Uri.parse(OrderManager.BasicUser.a(paramBasicUser)), OrderManager.BasicUser.b(paramBasicUser), OrderManager.BasicUser.c(paramBasicUser));
    if (this.b != null)
      this.b.a(OrderManager.Order.b(OrderManager.a(this.c)).a());
  }

  public void b(int paramInt, String paramString)
  {
    if (this.b != null)
      this.b.a(paramInt, paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.controllers.OrderManager.1
 * JD-Core Version:    0.6.0
 */