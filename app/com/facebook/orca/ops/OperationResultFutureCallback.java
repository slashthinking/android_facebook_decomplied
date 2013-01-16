package com.facebook.orca.ops;

import com.facebook.orca.server.OperationResult;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.CancellationException;

public abstract class OperationResultFutureCallback
  implements FutureCallback<OperationResult>
{
  protected abstract void a(ServiceException paramServiceException);

  public abstract void a(OperationResult paramOperationResult);

  public final void a(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof CancellationException))
      a((CancellationException)paramThrowable);
    while (true)
    {
      return;
      if ((paramThrowable instanceof ServiceException))
      {
        a((ServiceException)paramThrowable);
        continue;
      }
      b(paramThrowable);
    }
  }

  protected void a(CancellationException paramCancellationException)
  {
  }

  protected void b(Throwable paramThrowable)
  {
    Throwables.propagate(paramThrowable);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.ops.OperationResultFutureCallback
 * JD-Core Version:    0.6.0
 */