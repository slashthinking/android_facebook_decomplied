package com.facebook.orca.server;

import com.google.common.util.concurrent.ListenableFuture;

public class FutureOperationResult extends OperationResult
{
  private final ListenableFuture<OperationResult> a;

  public FutureOperationResult(ListenableFuture<OperationResult> paramListenableFuture)
  {
    this.a = paramListenableFuture;
  }

  public ListenableFuture<OperationResult> a()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.FutureOperationResult
 * JD-Core Version:    0.6.0
 */