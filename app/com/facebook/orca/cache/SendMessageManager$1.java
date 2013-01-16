package com.facebook.orca.cache;

import com.facebook.orca.ops.OrcaServiceOperation.OnCompletedListener;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.threads.Message;

class SendMessageManager$1 extends OrcaServiceOperation.OnCompletedListener
{
  public void a(ServiceException paramServiceException)
  {
    SendMessageManager.a(this.c, paramServiceException, this.a);
  }

  public void a(OperationResult paramOperationResult)
  {
    SendMessageManager.a(this.c, paramOperationResult, this.a, this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.cache.SendMessageManager.1
 * JD-Core Version:    0.6.0
 */