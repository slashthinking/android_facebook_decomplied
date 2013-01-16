package com.karmascience.gifts.views;

import com.karmascience.gifts.AnalyticsWrapper;
import com.karmascience.gifts.AnalyticsWrapper.MetricsEvent;
import com.karmascience.gifts.ThreadingService;
import com.karmascience.gifts.controllers.ProductsManager;

class iTunesRecommendationView$SearchRunner
  implements Runnable
{
  private String b;

  private iTunesRecommendationView$SearchRunner(iTunesRecommendationView paramiTunesRecommendationView)
  {
  }

  public void a(String paramString)
  {
    this.b = paramString;
    this.a.o().b(this);
    this.a.o().a(this, 1000L);
  }

  public void run()
  {
    String str = this.b;
    this.a.n().c("Searched iTunes").a("query", str).a();
    this.a.r().a(iTunesRecommendationView.a(this.a), 50, str, new iTunesRecommendationView.SearchRunner.1(this, str));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.iTunesRecommendationView.SearchRunner
 * JD-Core Version:    0.6.0
 */