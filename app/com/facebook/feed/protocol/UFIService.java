package com.facebook.feed.protocol;

import android.os.Bundle;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.ListenableFuture;

public class UFIService
{
  private OrcaServiceOperationFactory a;

  public UFIService(OrcaServiceOperationFactory paramOrcaServiceOperationFactory)
  {
    this.a = paramOrcaServiceOperationFactory;
  }

  public ListenableFuture<OperationResult> a(ToggleLikeParams paramToggleLikeParams)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("toggleLikeParams", paramToggleLikeParams);
    return this.a.a("toggle_like", localBundle).d();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.UFIService
 * JD-Core Version:    0.6.0
 */