package com.facebook.timeline;

import android.os.Bundle;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.ListenableFuture;

public abstract interface TimelineDataFetcher$BackendFetch
{
  public abstract ListenableFuture<OperationResult> a(String paramString, Bundle paramBundle);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineDataFetcher.BackendFetch
 * JD-Core Version:    0.6.0
 */