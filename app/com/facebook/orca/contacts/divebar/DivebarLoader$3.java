package com.facebook.orca.contacts.divebar;

import com.facebook.orca.debug.BLog;
import com.facebook.orca.ops.OperationResultFutureCallback;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;

class DivebarLoader$3 extends OperationResultFutureCallback
{
  protected void a(ServiceException paramServiceException)
  {
    BLog.a("orca:FriendListsLoader", "SYNC_TOP_LAST_ACTIVE error", paramServiceException);
  }

  public void a(OperationResult paramOperationResult)
  {
    DivebarLoader.a(this.a, paramOperationResult);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.divebar.DivebarLoader.3
 * JD-Core Version:    0.6.0
 */