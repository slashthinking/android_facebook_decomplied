package com.facebook.orca.merge;

import com.facebook.orca.server.FetchThreadResult;
import com.google.common.base.Function;

class MergingUtil$GetClientTimeMsFunction
  implements Function<FetchThreadResult, Long>
{
  public Long a(FetchThreadResult paramFetchThreadResult)
  {
    return Long.valueOf(paramFetchThreadResult.f());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.merge.MergingUtil.GetClientTimeMsFunction
 * JD-Core Version:    0.6.0
 */