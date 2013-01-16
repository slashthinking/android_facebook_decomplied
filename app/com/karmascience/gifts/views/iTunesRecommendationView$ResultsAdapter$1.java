package com.karmascience.gifts.views;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

class iTunesRecommendationView$ResultsAdapter$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Bundle localBundle = CommonViewUtils.a(12);
    localBundle.putParcelable("product_parcelable", iTunesRecommendationView.d(this.a.e));
    localBundle.putParcelable("sku_parcelable", iTunesRecommendationView.e(this.a.e));
    this.a.e.b(localBundle);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.iTunesRecommendationView.ResultsAdapter.1
 * JD-Core Version:    0.6.0
 */