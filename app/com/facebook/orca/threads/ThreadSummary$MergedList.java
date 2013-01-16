package com.facebook.orca.threads;

import com.google.common.collect.ImmutableList;
import java.util.AbstractList;

class ThreadSummary$MergedList extends AbstractList<ThreadParticipant>
{
  private final ImmutableList<ThreadParticipant> a;
  private final ImmutableList<ThreadParticipant> b;

  ThreadSummary$MergedList(ImmutableList<ThreadParticipant> paramImmutableList1, ImmutableList<ThreadParticipant> paramImmutableList2)
  {
    this.a = paramImmutableList1;
    this.b = paramImmutableList2;
  }

  public ThreadParticipant a(int paramInt)
  {
    if (paramInt < this.a.size());
    for (ThreadParticipant localThreadParticipant = (ThreadParticipant)this.a.get(paramInt); ; localThreadParticipant = (ThreadParticipant)this.b.get(paramInt - this.a.size()))
      return localThreadParticipant;
  }

  public int size()
  {
    return this.a.size() + this.b.size();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.ThreadSummary.MergedList
 * JD-Core Version:    0.6.0
 */