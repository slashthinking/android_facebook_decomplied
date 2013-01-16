package com.facebook.orca.prefs;

import com.facebook.orca.ops.OrcaServiceOperation.OnCompletedListener;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;

class GlobalNotificationPrefsSynchronizer$2 extends OrcaServiceOperation.OnCompletedListener
{
  public void a(ServiceException paramServiceException)
  {
    GlobalNotificationPrefsSynchronizer.a(this.a, paramServiceException);
  }

  public void a(OperationResult paramOperationResult)
  {
    GlobalNotificationPrefsSynchronizer.a(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.GlobalNotificationPrefsSynchronizer.2
 * JD-Core Version:    0.6.0
 */