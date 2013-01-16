package com.facebook.orca.threadlist;

import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.threads.ThreadsCollection;

public class ThreadListLoader$Result
{
  public final ThreadsCollection a;
  public final long b;
  public final long c;
  public final DataFreshnessResult d;

  public ThreadListLoader$Result(ThreadsCollection paramThreadsCollection, long paramLong1, long paramLong2, DataFreshnessResult paramDataFreshnessResult)
  {
    this.a = paramThreadsCollection;
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramDataFreshnessResult;
  }

  public boolean a()
  {
    return this.a.d();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.ThreadListLoader.Result
 * JD-Core Version:    0.6.0
 */