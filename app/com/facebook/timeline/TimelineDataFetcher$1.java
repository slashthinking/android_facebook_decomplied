package com.facebook.timeline;

import android.os.Bundle;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashSet;

class TimelineDataFetcher$1
  implements TimelineReplayableFetcher.RetryHandler
{
  public void a(FutureCallback<OperationResult> paramFutureCallback)
  {
    ListenableFuture localListenableFuture = TimelineDataFetcher.a(this.d).a(this.a, this.b);
    Futures.a(localListenableFuture, this.c);
    TimelineDataFetcher.b(this.d).add(localListenableFuture);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineDataFetcher.1
 * JD-Core Version:    0.6.0
 */