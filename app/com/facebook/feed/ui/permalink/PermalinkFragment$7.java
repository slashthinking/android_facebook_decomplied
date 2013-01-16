package com.facebook.feed.ui.permalink;

import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.cache.PendingFeedbackCache;
import com.facebook.orca.ops.OperationResultFutureCallback;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;

class PermalinkFragment$7 extends OperationResultFutureCallback
{
  public void a(ServiceException paramServiceException)
  {
    PermalinkFragment.a(this.c, paramServiceException, PermalinkFragment.ErrorBannerType.COMMENT_POST_FAILED);
    HoneyClientEvent localHoneyClientEvent = PermalinkFragment.f(this.c).a("comment_failure_permalink", this.a);
    PermalinkFragment.g(this.c).a(localHoneyClientEvent);
    PermalinkFragment.m(this.c).b(this.b);
    PermalinkFragment.k(this.c).notifyDataSetChanged();
  }

  public void a(OperationResult paramOperationResult)
  {
    PermalinkFragment.m(this.c).a(this.b, paramOperationResult.f());
    PermalinkFragment.k(this.c).notifyDataSetChanged();
    PermalinkFragment.b(this.c, false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.permalink.PermalinkFragment.7
 * JD-Core Version:    0.6.0
 */