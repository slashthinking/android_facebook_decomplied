package com.facebook.orca.merge;

import com.facebook.orca.server.FetchThreadResult;
import com.facebook.orca.threads.MessagesCollection;
import com.google.common.base.Function;

class MergingUtil$GetMessagesCollectionFunction
  implements Function<FetchThreadResult, MessagesCollection>
{
  public MessagesCollection a(FetchThreadResult paramFetchThreadResult)
  {
    return paramFetchThreadResult.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.merge.MergingUtil.GetMessagesCollectionFunction
 * JD-Core Version:    0.6.0
 */