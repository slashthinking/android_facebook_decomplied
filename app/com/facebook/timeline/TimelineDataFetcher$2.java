package com.facebook.timeline;

import com.facebook.feed.protocol.FetchParcelableResult;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashSet;
import java.util.concurrent.CancellationException;

class TimelineDataFetcher$2
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    TimelineDataFetcher.b(this.d).remove(this.a);
    if ((paramOperationResult.h() instanceof FetchParcelableResult))
    {
      FetchParcelableResult localFetchParcelableResult = (FetchParcelableResult)paramOperationResult.h();
      if (localFetchParcelableResult.a() != null)
        TimelineDataFetcher.a(this.d, this.b, this.c, localFetchParcelableResult.a());
    }
  }

  public void a(Throwable paramThrowable)
  {
    TimelineDataFetcher.b(this.d).remove(this.a);
    if (!(paramThrowable instanceof CancellationException))
      TimelineDataFetcher.a(this.d, this.b, this.c, paramThrowable);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineDataFetcher.2
 * JD-Core Version:    0.6.0
 */