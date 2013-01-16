package com.facebook.orca.threadview;

import com.facebook.orca.ops.OperationResultFutureCallback;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;

class ThreadViewLoader$2 extends OperationResultFutureCallback
{
  protected void a(ServiceException paramServiceException)
  {
    ThreadViewLoader.b(this.a, null);
    ThreadViewLoader.b(this.a, paramServiceException);
  }

  public void a(OperationResult paramOperationResult)
  {
    ThreadViewLoader.b(this.a, null);
    ThreadViewLoader.b(this.a, paramOperationResult);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewLoader.2
 * JD-Core Version:    0.6.0
 */