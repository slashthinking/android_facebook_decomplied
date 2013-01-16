package com.karmascience.gifts.views;

import android.app.Activity;
import android.content.res.Resources;
import android.widget.ListView;
import android.widget.TextView;
import com.karmascience.gifts.content.model.iTunesSearchResults;
import com.karmascience.gifts.controllers.ProductsManager.iTunesSearchRequestListener;

class iTunesRecommendationView$SearchRunner$1
  implements ProductsManager.iTunesSearchRequestListener
{
  public void a(int paramInt, String paramString)
  {
    if (this.b.a.l())
      this.b.a.a(paramInt, paramString);
  }

  public void a(iTunesSearchResults paramiTunesSearchResults)
  {
    int i;
    Resources localResources2;
    Object[] arrayOfObject2;
    if (this.a.equals(iTunesRecommendationView.SearchRunner.a(this.b)))
    {
      iTunesRecommendationView.ResultsAdapter localResultsAdapter = new iTunesRecommendationView.ResultsAdapter(this.b.a, paramiTunesSearchResults.b(), null);
      iTunesRecommendationView.c(this.b.a).setAdapter(localResultsAdapter);
      iTunesRecommendationView.c(this.b.a).setOnItemClickListener(localResultsAdapter);
      i = paramiTunesSearchResults.a();
      if (i <= 0)
        break label142;
      localResources2 = this.b.a.g().getResources();
      arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Integer.valueOf(i);
      arrayOfObject2[1] = this.a.toUpperCase();
    }
    label142: Resources localResources1;
    Object[] arrayOfObject1;
    for (String str = localResources2.getQuantityString(2131427351, i, arrayOfObject2); ; str = localResources1.getString(2131362321, arrayOfObject1))
    {
      iTunesRecommendationView.f(this.b.a).setText(str);
      return;
      localResources1 = this.b.a.g().getResources();
      arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = this.a.toUpperCase();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.iTunesRecommendationView.SearchRunner.1
 * JD-Core Version:    0.6.0
 */