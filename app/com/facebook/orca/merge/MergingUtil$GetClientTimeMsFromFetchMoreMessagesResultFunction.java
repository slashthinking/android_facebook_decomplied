package com.facebook.orca.merge;

import com.facebook.orca.server.FetchMoreMessagesResult;
import com.google.common.base.Function;

class MergingUtil$GetClientTimeMsFromFetchMoreMessagesResultFunction
  implements Function<FetchMoreMessagesResult, Long>
{
  public Long a(FetchMoreMessagesResult paramFetchMoreMessagesResult)
  {
    return Long.valueOf(paramFetchMoreMessagesResult.f());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.merge.MergingUtil.GetClientTimeMsFromFetchMoreMessagesResultFunction
 * JD-Core Version:    0.6.0
 */