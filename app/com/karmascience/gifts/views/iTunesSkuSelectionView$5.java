package com.karmascience.gifts.views;

import com.facebook.common.util.Log;
import com.karmascience.gifts.content.model.iTunesContentResults;
import com.karmascience.gifts.controllers.ProductsManager.iTunesRequestListener;

class iTunesSkuSelectionView$5
  implements ProductsManager.iTunesRequestListener
{
  public void a(int paramInt, String paramString)
  {
    Log.b("Getting iTunes data failed: " + paramInt + " => " + paramString);
  }

  public void a(iTunesContentResults paramiTunesContentResults)
  {
    iTunesSkuSelectionView.a(this.a, paramiTunesContentResults);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.iTunesSkuSelectionView.5
 * JD-Core Version:    0.6.0
 */