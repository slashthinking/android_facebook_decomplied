package com.facebook.pages.identity.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.PageStarRatersEdge;
import com.facebook.orca.debug.BLog;

class PageRecommendationRowView$1
  implements View.OnClickListener
{
  PageRecommendationRowView$1(PageRecommendationRowView paramPageRecommendationRowView, PageStarRatersEdge paramPageStarRatersEdge)
  {
  }

  public void onClick(View paramView)
  {
    if ((PageRecommendationRowView.b() != null) && (!PageRecommendationRowView.b().a(this.a.rater.id)))
    {
      BLog.e(PageRecommendationRowView.c(), "Failed rhandle friend rating click event");
      throw new RuntimeException("Failed rhandle friend rating click event");
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.PageRecommendationRowView.1
 * JD-Core Version:    0.6.2
 */