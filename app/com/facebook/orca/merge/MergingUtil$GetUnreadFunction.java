package com.facebook.orca.merge;

import com.facebook.orca.threads.ThreadSummary;
import com.google.common.base.Function;

class MergingUtil$GetUnreadFunction
  implements Function<ThreadSummary, Boolean>
{
  public Boolean a(ThreadSummary paramThreadSummary)
  {
    return Boolean.valueOf(paramThreadSummary.t());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.merge.MergingUtil.GetUnreadFunction
 * JD-Core Version:    0.6.0
 */