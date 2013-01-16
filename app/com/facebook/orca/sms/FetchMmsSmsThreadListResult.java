package com.facebook.orca.sms;

import com.facebook.orca.threads.ThreadsCollection;
import com.facebook.orca.users.User;
import com.google.common.collect.ImmutableList;

class FetchMmsSmsThreadListResult
{
  private final ThreadsCollection a;
  private final ImmutableList<User> b;

  FetchMmsSmsThreadListResult(ThreadsCollection paramThreadsCollection, ImmutableList<User> paramImmutableList)
  {
    this.a = paramThreadsCollection;
    this.b = paramImmutableList;
  }

  ThreadsCollection a()
  {
    return this.a;
  }

  ImmutableList<User> b()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.FetchMmsSmsThreadListResult
 * JD-Core Version:    0.6.0
 */