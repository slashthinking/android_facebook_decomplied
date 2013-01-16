package com.karmascience.gifts.controllers;

import com.facebook.common.util.Log;
import com.karmascience.gifts.ThreadingService;
import com.karmascience.gifts.content.iTunesContentApiMethod;
import com.karmascience.gifts.content.model.iTunesContentResults;

class ProductsManager$1 extends iTunesContentApiMethod<iTunesContentResults>
{
  public void a(iTunesContentResults paramiTunesContentResults)
  {
    try
    {
      if (this.a != null)
        this.a.a(paramiTunesContentResults);
      return;
    }
    catch (Exception localException)
    {
      while (true)
        Log.b("Can't parse iTunes results", localException);
    }
  }

  public void b(int paramInt, String paramString)
  {
    if (this.a != null)
      this.a.a(paramInt, paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.controllers.ProductsManager.1
 * JD-Core Version:    0.6.0
 */