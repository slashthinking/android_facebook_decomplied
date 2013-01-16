package com.facebook.orca.protocol.methods;

import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.users.User;
import com.google.common.collect.ImmutableList;

class FetchThreadsFqlHelper$ThreadsResult
{
  final ImmutableList<ThreadSummary> a;
  final ImmutableList<String> b;
  final ImmutableList<String> c;
  final ImmutableList<User> d;
  final int e;
  final long f;

  public FetchThreadsFqlHelper$ThreadsResult(ImmutableList<ThreadSummary> paramImmutableList, ImmutableList<String> paramImmutableList1, ImmutableList<String> paramImmutableList2, ImmutableList<User> paramImmutableList3, int paramInt, long paramLong)
  {
    this.a = paramImmutableList;
    this.b = paramImmutableList1;
    this.c = paramImmutableList2;
    this.d = paramImmutableList3;
    this.e = paramInt;
    this.f = paramLong;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.FetchThreadsFqlHelper.ThreadsResult
 * JD-Core Version:    0.6.0
 */