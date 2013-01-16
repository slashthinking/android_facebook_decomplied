package com.facebook.orca.threadlist;

import com.facebook.orca.ops.OperationResultFutureCallback;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;

class ThreadListLoader$2 extends OperationResultFutureCallback
{
  protected void a(ServiceException paramServiceException)
  {
    ThreadListLoader.b(this.a, null);
    ThreadListLoader.b(this.a, paramServiceException);
  }

  public void a(OperationResult paramOperationResult)
  {
    ThreadListLoader.b(this.a, null);
    ThreadListLoader.b(this.a, paramOperationResult);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.ThreadListLoader.2
 * JD-Core Version:    0.6.0
 */