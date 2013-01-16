package com.facebook.orca.merge;

import com.facebook.orca.server.FetchMoreMessagesResult;
import com.facebook.orca.threads.MessagesCollection;
import com.google.common.base.Function;

class MergingUtil$GetMessagesCollectionFromFetchMoreMessagesResultFunction
  implements Function<FetchMoreMessagesResult, MessagesCollection>
{
  public MessagesCollection a(FetchMoreMessagesResult paramFetchMoreMessagesResult)
  {
    return paramFetchMoreMessagesResult.a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.merge.MergingUtil.GetMessagesCollectionFromFetchMoreMessagesResultFunction
 * JD-Core Version:    0.6.0
 */