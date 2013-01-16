package com.karmascience.gifts.content.model;

import com.facebook.common.util.Log;
import com.karmascience.gifts.ThreadingService;
import com.karmascience.gifts.content.GraphPOJOApiMethod;
import java.util.Iterator;
import java.util.List;

class Products$1 extends GraphPOJOApiMethod<Products>
{
  public void a(Products paramProducts)
  {
    try
    {
      Products.a(this.b, Products.a(paramProducts));
      Products.b(this.b).addAll(Products.b(paramProducts));
      Iterator localIterator = Products.c(this.b).iterator();
      while (localIterator.hasNext())
      {
        Products.OnChangeListener localOnChangeListener = (Products.OnChangeListener)localIterator.next();
        if (localOnChangeListener == null)
          continue;
        localOnChangeListener.a();
      }
    }
    catch (Exception localException)
    {
      Log.b("Couldn't parse more products", localException);
      Products.a(this.b, false);
    }
  }

  public void b(int paramInt, String paramString)
  {
    Products.d(this.b);
    if (Products.e(this.b) < 3)
      Products.a(this.b, this.a);
    while (true)
    {
      return;
      Products.a(this.b, false);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.content.model.Products.1
 * JD-Core Version:    0.6.0
 */