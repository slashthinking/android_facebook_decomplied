package com.facebook.katana.features.uberbar;

import com.facebook.ipc.data.uberbar.UberbarResult;
import com.facebook.ipc.data.uberbar.UberbarResult.FriendStatus;
import com.facebook.ipc.data.uberbar.UberbarResultBuilder;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;

class UberbarResultsFragment$4
  implements UberbarResultView.AddFriendButtonListener
{
  public void a(UberbarResult paramUberbarResult)
  {
    List localList = UberbarResultsFragment.b(this.a).a();
    UberbarResultsFragment.d(this.a).a(paramUberbarResult, UberbarResultsFragment.c(this.a), localList);
    ListenableFuture localListenableFuture = UberbarResultsFragment.a(this.a, paramUberbarResult.i);
    UberbarResult localUberbarResult = UberbarResultBuilder.a(paramUberbarResult).a(UberbarResult.FriendStatus.OUTGOING_REQUEST).a();
    ArrayList localArrayList = Lists.a(localList);
    localArrayList.set(localArrayList.indexOf(paramUberbarResult), localUberbarResult);
    UberbarResultsFragment.b(this.a).a(localArrayList);
    Futures.a(localListenableFuture, new UberbarResultsFragment.4.1(this, localList));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.uberbar.UberbarResultsFragment.4
 * JD-Core Version:    0.6.0
 */