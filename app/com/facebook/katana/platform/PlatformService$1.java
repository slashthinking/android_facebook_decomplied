package com.facebook.katana.platform;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.facebook.katana.server.protocol.AuthorizeAppMethod.Result;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.ops.OperationResultFutureCallback;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;

class PlatformService$1 extends OperationResultFutureCallback
{
  protected void a(ServiceException paramServiceException)
  {
    this.a.setData(AuthorizeAppResults.a(paramServiceException));
    try
    {
      this.b.send(this.a);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        BLog.d(PlatformService.a(), "Unable to respond to token refresh request", localRemoteException);
    }
  }

  public void a(OperationResult paramOperationResult)
  {
    if (paramOperationResult.c())
    {
      AuthorizeAppMethod.Result localResult = (AuthorizeAppMethod.Result)paramOperationResult.g().getParcelable("result");
      this.a.setData(AuthorizeAppResults.a(localResult.a(), localResult.c(), localResult.b()));
    }
    try
    {
      while (true)
      {
        this.b.send(this.a);
        return;
        this.a.setData(AuthorizeAppResults.a(new ServiceException(paramOperationResult)));
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        BLog.d(PlatformService.a(), "Unable to respond to token refresh request", localRemoteException);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.PlatformService.1
 * JD-Core Version:    0.6.0
 */