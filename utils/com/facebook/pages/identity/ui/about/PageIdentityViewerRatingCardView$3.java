package com.facebook.pages.identity.ui.about;

import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;

class PageIdentityViewerRatingCardView$3
  implements RatingBar.OnRatingBarChangeListener
{
  PageIdentityViewerRatingCardView$3(PageIdentityViewerRatingCardView paramPageIdentityViewerRatingCardView)
  {
  }

  public void onRatingChanged(RatingBar paramRatingBar, float paramFloat, boolean paramBoolean)
  {
    if (!paramBoolean);
    while (true)
    {
      return;
      if (paramFloat < 1.0F)
        PageIdentityViewerRatingCardView.c(this.a).setRating(1.0F);
      else
        PageIdentityViewerRatingCardView.a(this.a, (int)paramFloat);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.about.PageIdentityViewerRatingCardView.3
 * JD-Core Version:    0.6.2
 */