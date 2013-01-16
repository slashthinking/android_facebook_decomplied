package com.facebook.feed.ui.permalink;

import android.app.Activity;
import android.content.Context;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.feed.protocol.FetchSingleStoryResult;
import com.facebook.feed.ui.FeedFragmentOperationsManager;
import com.facebook.graphql.model.FeedStory;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.net.OrcaNetworkManager;
import com.facebook.orca.ops.OperationResultFutureCallback;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.ErrorCode;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.ListenableFuture;

class PermalinkFragment$2 extends OperationResultFutureCallback
{
  public void a(ServiceException paramServiceException)
  {
    PermalinkFragment.b(this.c).b(this.a);
    if (paramServiceException.a() == ErrorCode.CONNECTION_FAILURE)
      PermalinkFragment.a(this.c, PermalinkFragment.ErrorBannerType.NO_CONNECTION, false);
    while (true)
    {
      return;
      if (PermalinkFragment.c(this.c))
      {
        ((IFeedIntentBuilder)this.b.a(IFeedIntentBuilder.class)).a((Context)this.b.a(Activity.class), PermalinkFragment.d(this.c));
        continue;
      }
      PermalinkFragment.a(this.c, PermalinkFragment.ErrorBannerType.FETCH_STORY_FAILED, true);
    }
  }

  public void a(OperationResult paramOperationResult)
  {
    PermalinkFragment.b(this.c).b(this.a);
    FetchSingleStoryResult localFetchSingleStoryResult = (FetchSingleStoryResult)paramOperationResult.h();
    PermalinkFragment.a(this.c, localFetchSingleStoryResult.a);
    HoneyClientEvent localHoneyClientEvent = PermalinkFragment.f(this.c).a(PermalinkFragment.e(this.c).k());
    PermalinkFragment.g(this.c).b(localHoneyClientEvent);
    if (!PermalinkFragment.a(this.c).b())
      PermalinkFragment.a(this.c, PermalinkFragment.ErrorBannerType.NO_CONNECTION, false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.permalink.PermalinkFragment.2
 * JD-Core Version:    0.6.0
 */