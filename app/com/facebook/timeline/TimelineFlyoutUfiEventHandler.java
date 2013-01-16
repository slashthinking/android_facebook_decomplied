package com.facebook.timeline;

import android.os.Bundle;
import com.facebook.common.util.event.FbEventSubscriberListManager;
import com.facebook.feed.protocol.FetchFeedbackParams;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.FeedbackableGraphQLNode;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.server.DataFreshnessParam;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;

public class TimelineFlyoutUfiEventHandler
{
  private final TimelineAllSectionsData a;
  private final FeedEventBus b;
  private final FbEventSubscriberListManager c;
  private final OrcaServiceOperationFactory d;
  private final TimelineDataFetcher e;
  private String f;

  public TimelineFlyoutUfiEventHandler(TimelineAllSectionsData paramTimelineAllSectionsData, FeedEventBus paramFeedEventBus, OrcaServiceOperationFactory paramOrcaServiceOperationFactory, TimelineDataFetcher paramTimelineDataFetcher)
  {
    this.a = ((TimelineAllSectionsData)Preconditions.checkNotNull(paramTimelineAllSectionsData));
    this.b = ((FeedEventBus)Preconditions.checkNotNull(paramFeedEventBus));
    this.d = ((OrcaServiceOperationFactory)Preconditions.checkNotNull(paramOrcaServiceOperationFactory));
    this.e = ((TimelineDataFetcher)Preconditions.checkNotNull(paramTimelineDataFetcher));
    this.c = new FbEventSubscriberListManager();
    this.c.a(new TimelineFlyoutUfiEventHandler.1(this));
    this.c.a(this.b);
  }

  private void a(Feedback paramFeedback)
  {
    FeedbackableGraphQLNode localFeedbackableGraphQLNode = this.a.a(null, paramFeedback.legacyApiPostId);
    if (localFeedbackableGraphQLNode != null)
    {
      this.a.a(localFeedbackableGraphQLNode, paramFeedback);
      this.e.i();
    }
  }

  public void a()
  {
    this.c.a(this.b);
  }

  public void b()
  {
    this.c.b(this.b);
  }

  public void c()
  {
    if (this.f != null)
    {
      FetchFeedbackParams localFetchFeedbackParams = new FetchFeedbackParams(this.f, 25, 25, DataFreshnessParam.DO_NOT_CHECK_SERVER);
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("fetchFeedbackParams", localFetchFeedbackParams);
      Futures.a(this.d.a("fetch_feedback", localBundle).e(), new TimelineFlyoutUfiEventHandler.2(this));
    }
    this.f = null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineFlyoutUfiEventHandler
 * JD-Core Version:    0.6.0
 */