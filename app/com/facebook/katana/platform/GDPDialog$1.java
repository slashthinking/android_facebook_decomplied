package com.facebook.katana.platform;

import android.os.Bundle;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.ops.OrcaServiceOperation.OnCompletedListener;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.ErrorCode;
import com.facebook.orca.server.ErrorCodeUtil;
import com.facebook.orca.server.OperationResult;

class GDPDialog$1 extends OrcaServiceOperation.OnCompletedListener
{
  public void a(ServiceException paramServiceException)
  {
    BLog.d(GDPDialog.L(), "Failed to load", paramServiceException);
    Bundle localBundle = AuthorizeAppResults.a(paramServiceException);
    if (ErrorCodeUtil.a(paramServiceException) == ErrorCode.CONNECTION_FAILURE)
      this.a.a(GDPState.DISPLAYING_PERMISSIONS_LOAD_FAILURE, localBundle);
    while (true)
    {
      return;
      this.a.a(GDPState.CANCELED, localBundle);
    }
  }

  public void a(OperationResult paramOperationResult)
  {
    this.a.a(GDPState.DISPLAYING_PERMISSIONS, paramOperationResult.f());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.GDPDialog.1
 * JD-Core Version:    0.6.0
 */