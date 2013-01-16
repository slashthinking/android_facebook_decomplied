package com.facebook.orca.cache;

import com.facebook.orca.ops.OrcaServiceOperation.OnCompletedListener;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;

class SendMessageManager$2 extends OrcaServiceOperation.OnCompletedListener
{
  public void a(ServiceException paramServiceException)
  {
    this.b.a(this.a, paramServiceException);
  }

  public void a(OperationResult paramOperationResult)
  {
    SendMessageManager.a(this.b, paramOperationResult);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.cache.SendMessageManager.2
 * JD-Core Version:    0.6.0
 */