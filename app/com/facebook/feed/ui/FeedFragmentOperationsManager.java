package com.facebook.feed.ui;

import com.facebook.orca.server.OperationResult;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.List;

public class FeedFragmentOperationsManager
{
  private List<ListenableFuture<OperationResult>> a = Lists.a();

  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((ListenableFuture)localIterator.next()).cancel(true);
  }

  public void a(ListenableFuture<OperationResult> paramListenableFuture)
  {
    if (this.a.contains(paramListenableFuture));
    while (true)
    {
      return;
      this.a.add(paramListenableFuture);
    }
  }

  public void b(ListenableFuture<OperationResult> paramListenableFuture)
  {
    this.a.remove(paramListenableFuture);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.FeedFragmentOperationsManager
 * JD-Core Version:    0.6.0
 */