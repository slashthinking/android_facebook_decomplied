package com.karmascience.gifts.controllers;

import android.app.Activity;
import com.karmascience.gifts.AnalyticsWrapper;
import com.karmascience.gifts.ThreadingService;
import com.karmascience.gifts.content.AsyncMethodRunner;

public class SingletonManager
{
  private final OrderManager a;
  private final ProductsManager b;
  private final ThreadingService c = new ThreadingService();
  private final AnalyticsWrapper d;
  private final AsyncMethodRunner e;
  private final CardManager f;

  public SingletonManager(Activity paramActivity)
  {
    this.d = new AnalyticsWrapper(paramActivity);
    this.e = new AsyncMethodRunner(paramActivity);
    this.a = a(this.e);
    this.f = a(this.e, this.c);
    this.b = a(this.c, this.e, paramActivity);
  }

  protected CardManager a(AsyncMethodRunner paramAsyncMethodRunner, ThreadingService paramThreadingService)
  {
    return new CardManager(paramAsyncMethodRunner, paramThreadingService);
  }

  protected OrderManager a(AsyncMethodRunner paramAsyncMethodRunner)
  {
    return new OrderManager(paramAsyncMethodRunner);
  }

  protected ProductsManager a(ThreadingService paramThreadingService, AsyncMethodRunner paramAsyncMethodRunner, Activity paramActivity)
  {
    return new ProductsManager(paramThreadingService, paramAsyncMethodRunner, paramActivity);
  }

  public Object a(String paramString)
  {
    Object localObject;
    if ("ks_threading_service".equals(paramString))
      localObject = this.c;
    while (true)
    {
      return localObject;
      if ("ks_metric_service".equals(paramString))
      {
        localObject = this.d;
        continue;
      }
      if ("ks_order_manager".equals(paramString))
      {
        localObject = this.a;
        continue;
      }
      if ("ks_products_manager".equals(paramString))
      {
        localObject = this.b;
        continue;
      }
      if ("ks_card_manager".equals(paramString))
      {
        localObject = this.f;
        continue;
      }
      if ("ks_method_runner".equals(paramString))
      {
        localObject = this.e;
        continue;
      }
      localObject = null;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.controllers.SingletonManager
 * JD-Core Version:    0.6.0
 */