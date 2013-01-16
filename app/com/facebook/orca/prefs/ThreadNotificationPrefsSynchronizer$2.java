package com.facebook.orca.prefs;

import com.facebook.orca.ops.OrcaServiceOperation.OnCompletedListener;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;

class ThreadNotificationPrefsSynchronizer$2 extends OrcaServiceOperation.OnCompletedListener
{
  public void a(ServiceException paramServiceException)
  {
    ThreadNotificationPrefsSynchronizer.a(this.a, paramServiceException);
  }

  public void a(OperationResult paramOperationResult)
  {
    ThreadNotificationPrefsSynchronizer.a(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.ThreadNotificationPrefsSynchronizer.2
 * JD-Core Version:    0.6.0
 */