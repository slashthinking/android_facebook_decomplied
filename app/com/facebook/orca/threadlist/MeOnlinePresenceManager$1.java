package com.facebook.orca.threadlist;

import com.facebook.orca.ops.OrcaServiceOperation.OnCompletedListener;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;

class MeOnlinePresenceManager$1 extends OrcaServiceOperation.OnCompletedListener
{
  public void a(ServiceException paramServiceException)
  {
  }

  public void a(OperationResult paramOperationResult)
  {
    MeOnlinePresenceManager.a(this.a, Boolean.getBoolean(paramOperationResult.f()));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.MeOnlinePresenceManager.1
 * JD-Core Version:    0.6.0
 */