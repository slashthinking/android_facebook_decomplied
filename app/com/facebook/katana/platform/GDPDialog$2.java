package com.facebook.katana.platform;

import android.os.Bundle;
import com.facebook.katana.server.protocol.AuthorizeAppMethod.Result;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.ops.OrcaServiceOperation.OnCompletedListener;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.ErrorCode;
import com.facebook.orca.server.ErrorCodeUtil;
import com.facebook.orca.server.OperationResult;

class GDPDialog$2 extends OrcaServiceOperation.OnCompletedListener
{
  public void a(ServiceException paramServiceException)
  {
    BLog.d(GDPDialog.L(), "Failed to send", paramServiceException);
    Bundle localBundle = AuthorizeAppResults.a(paramServiceException);
    if (ErrorCodeUtil.a(paramServiceException) == ErrorCode.CONNECTION_FAILURE)
      this.a.a(GDPState.DISPLAYING_SEND_APPROVAL_FAILURE, localBundle);
    while (true)
    {
      return;
      this.a.a(GDPState.CANCELED, localBundle);
    }
  }

  public void a(OperationResult paramOperationResult)
  {
    AuthorizeAppMethod.Result localResult = (AuthorizeAppMethod.Result)paramOperationResult.g().getParcelable("result");
    Bundle localBundle = AuthorizeAppResults.a(localResult.a(), localResult.c(), localResult.b());
    this.a.a(GDPState.APPROVED, localBundle);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.GDPDialog.2
 * JD-Core Version:    0.6.0
 */