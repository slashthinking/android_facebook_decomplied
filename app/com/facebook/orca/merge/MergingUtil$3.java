package com.facebook.orca.merge;

import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.threads.ThreadsCollection;
import com.google.common.base.Function;
import java.util.Collection;

final class MergingUtil$3
  implements Function<ThreadsCollection, Collection<ThreadSummary>>
{
  public Collection<ThreadSummary> a(ThreadsCollection paramThreadsCollection)
  {
    return paramThreadsCollection.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.merge.MergingUtil.3
 * JD-Core Version:    0.6.0
 */