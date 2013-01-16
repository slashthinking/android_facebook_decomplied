package com.facebook.pages.identity.ui.about;

import android.widget.RatingBar;
import android.widget.Toast;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.ops.OperationResultFutureCallback;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;
import com.facebook.pages.identity.analytics.PageIdentityAnalytics;
import com.facebook.pages.identity.data.PageIdentityData;

class PageIdentityViewerRatingCardView$4 extends OperationResultFutureCallback
{
  PageIdentityViewerRatingCardView$4(PageIdentityViewerRatingCardView paramPageIdentityViewerRatingCardView)
  {
  }

  protected void a(ServiceException paramServiceException)
  {
    PageIdentityViewerRatingCardView.c(this.a).setRating(0.0F);
    PageIdentityViewerRatingCardView.f(this.a).d(PageIdentityViewerRatingCardView.d(this.a).a(), PageIdentityViewerRatingCardView.e(this.a));
    Toast.makeText(this.a.getContext(), 2131361885, 1).show();
    PageIdentityViewerRatingCardView.g(this.a).a("page_identity_rate_page_fail", paramServiceException.getMessage(), paramServiceException, false);
  }

  public void a(OperationResult paramOperationResult)
  {
    PageIdentityViewerRatingCardView.f(this.a).c(PageIdentityViewerRatingCardView.d(this.a).a(), PageIdentityViewerRatingCardView.e(this.a));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.about.PageIdentityViewerRatingCardView.4
 * JD-Core Version:    0.6.2
 */