package com.facebook.timeline;

import com.facebook.feed.protocol.FetchParcelableResult;
import com.facebook.graphql.model.Timeline;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.CancellationException;

class TimelineDataFetcher$3
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    FetchParcelableResult localFetchParcelableResult = (FetchParcelableResult)paramOperationResult.h();
    Timeline localTimeline = (Timeline)localFetchParcelableResult.a;
    TimelineDataFetcher.d(this.a).a(localTimeline);
    if (TimelineDataFetcher.c(this.a) != null)
      TimelineDataFetcher.c(this.a).b(localFetchParcelableResult.e());
  }

  public void a(Throwable paramThrowable)
  {
    if (!(paramThrowable instanceof CancellationException))
      TimelineDataFetcher.c(this.a).j_();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineDataFetcher.3
 * JD-Core Version:    0.6.0
 */