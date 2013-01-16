package com.facebook.orca.merge;

import com.facebook.orca.server.FetchThreadResult;
import com.facebook.orca.threads.ThreadSummary;
import com.google.common.base.Function;

class MergingUtil$GetThreadSummaryFunction
  implements Function<FetchThreadResult, ThreadSummary>
{
  public ThreadSummary a(FetchThreadResult paramFetchThreadResult)
  {
    return paramFetchThreadResult.a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.merge.MergingUtil.GetThreadSummaryFunction
 * JD-Core Version:    0.6.0
 */