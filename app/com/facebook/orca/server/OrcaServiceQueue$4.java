package com.facebook.orca.server;

import android.os.HandlerThread;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;

class OrcaServiceQueue$4
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    if (Thread.currentThread().getId() == OrcaServiceQueue.a(this.b).getId());
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool);
      OrcaServiceQueue.b(this.b, this.a, paramOperationResult);
      OrcaServiceQueue.a(this.b, null);
      OrcaServiceQueue.a(this.b, 0L);
      return;
    }
  }

  public void a(Throwable paramThrowable)
  {
    if (Thread.currentThread().getId() == OrcaServiceQueue.a(this.b).getId());
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool);
      OrcaServiceQueue.b(this.b, this.a, OperationResult.a(ErrorCodeUtil.b(paramThrowable), ErrorCodeUtil.c(paramThrowable)));
      OrcaServiceQueue.a(this.b, null);
      OrcaServiceQueue.a(this.b, 0L);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.OrcaServiceQueue.4
 * JD-Core Version:    0.6.0
 */