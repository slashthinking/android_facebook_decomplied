package com.facebook.orca.server;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

class OrcaServiceQueue$OperationHolder
{
  private final Operation a;
  private final long b;
  private long c;
  private long d;
  private ListenableFuture<OperationResult> e;
  private OperationResult f;
  private List<ICompletionHandler> g = Lists.a();
  private OrcaServiceProgressCallback h;

  OrcaServiceQueue$OperationHolder(Operation paramOperation)
  {
    this.a = paramOperation;
    this.b = System.currentTimeMillis();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.OrcaServiceQueue.OperationHolder
 * JD-Core Version:    0.6.0
 */