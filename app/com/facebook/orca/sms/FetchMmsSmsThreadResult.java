package com.facebook.orca.sms;

import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.users.User;
import com.google.common.collect.ImmutableList;

class FetchMmsSmsThreadResult
{
  private final ThreadSummary a;
  private final ImmutableList<User> b;

  FetchMmsSmsThreadResult(ThreadSummary paramThreadSummary, ImmutableList<User> paramImmutableList)
  {
    this.a = paramThreadSummary;
    this.b = paramImmutableList;
  }

  ThreadSummary a()
  {
    return this.a;
  }

  ImmutableList<User> b()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.FetchMmsSmsThreadResult
 * JD-Core Version:    0.6.0
 */