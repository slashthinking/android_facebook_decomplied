package com.facebook.timeline;

import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.FutureCallback;

public abstract interface TimelineReplayableFetcher$RetryHandler
{
  public abstract void a(FutureCallback<OperationResult> paramFutureCallback);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineReplayableFetcher.RetryHandler
 * JD-Core Version:    0.6.0
 */