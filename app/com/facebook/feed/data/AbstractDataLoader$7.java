package com.facebook.feed.data;

import com.facebook.feed.model.DataLoaderConfig;
import com.facebook.orca.net.OrcaNetworkManager;
import com.facebook.orca.ops.OperationResultFutureCallback;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;
import java.util.concurrent.CancellationException;

class AbstractDataLoader$7 extends OperationResultFutureCallback
{
  private void a()
  {
    AbstractDataLoader.a(this.a, null);
  }

  protected void a(ServiceException paramServiceException)
  {
    a();
  }

  public void a(OperationResult paramOperationResult)
  {
    a();
    this.a.h.a().f();
    this.a.q.a(false);
    if (this.a.e.b())
      this.a.a();
  }

  protected void a(CancellationException paramCancellationException)
  {
    a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.data.AbstractDataLoader.7
 * JD-Core Version:    0.6.0
 */