package com.karmascience.gifts.views;

import android.widget.ListView;
import com.karmascience.gifts.content.model.iTunesContentResults;
import com.karmascience.gifts.controllers.ProductsManager.iTunesRequestListener;

class iTunesRecommendationView$2
  implements ProductsManager.iTunesRequestListener
{
  public void a(int paramInt, String paramString)
  {
    if (this.a.l())
      this.a.a(paramInt, paramString);
  }

  public void a(iTunesContentResults paramiTunesContentResults)
  {
    iTunesRecommendationView.a(this.a, new iTunesRecommendationView.ResultsAdapter(this.a, paramiTunesContentResults.a(iTunesRecommendationView.a(this.a)), null));
    iTunesRecommendationView.c(this.a).setAdapter(iTunesRecommendationView.b(this.a));
    iTunesRecommendationView.c(this.a).setOnItemClickListener(iTunesRecommendationView.b(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.iTunesRecommendationView.2
 * JD-Core Version:    0.6.0
 */