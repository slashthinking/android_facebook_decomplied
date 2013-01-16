package com.facebook.feed.data;

import android.os.Bundle;
import com.facebook.feed.model.DataLoaderConfig;
import com.facebook.feed.model.FetchResultState;
import com.facebook.orca.ops.OperationResultFutureCallback;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;

class AbstractDataLoader$3 extends OperationResultFutureCallback
{
  protected void a(ServiceException paramServiceException)
  {
    this.b.t = null;
  }

  public void a(OperationResult paramOperationResult)
  {
    this.b.t = null;
    ArrayList localArrayList = paramOperationResult.i();
    this.b.h.a().b(localArrayList);
    this.b.q.a(true, FetchResultState.SUCCESS, this.a, 0);
    this.b.y = System.currentTimeMillis();
  }

  protected void a(CancellationException paramCancellationException)
  {
    this.b.t = null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.data.AbstractDataLoader.3
 * JD-Core Version:    0.6.0
 */