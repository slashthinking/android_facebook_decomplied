package com.karmascience.gifts.controllers;

import com.facebook.common.util.Log;
import com.karmascience.gifts.ThreadingService;
import com.karmascience.gifts.content.iTunesContentApiMethod;
import com.karmascience.gifts.content.model.iTunesSearchResults;

class ProductsManager$2 extends iTunesContentApiMethod<iTunesSearchResults>
{
  public void a(iTunesSearchResults paramiTunesSearchResults)
  {
    if (this.a != null);
    try
    {
      this.a.a(paramiTunesSearchResults);
      return;
    }
    catch (Exception localException)
    {
      while (true)
        Log.b("Can't parse iTunes search results", localException);
    }
  }

  public void b(int paramInt, String paramString)
  {
    if (this.a != null)
      this.a.a(paramInt, paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.controllers.ProductsManager.2
 * JD-Core Version:    0.6.0
 */