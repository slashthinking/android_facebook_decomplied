package com.facebook.orca.login;

import com.facebook.orca.ops.OrcaServiceOperation.OnCompletedListener;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;

class LogoutFragment$1 extends OrcaServiceOperation.OnCompletedListener
{
  LogoutFragment$1(LogoutFragment paramLogoutFragment)
  {
  }

  public void a(ServiceException paramServiceException)
  {
    LogoutFragment.b(this.a);
  }

  public void a(OperationResult paramOperationResult)
  {
    LogoutFragment.a(this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.LogoutFragment.1
 * JD-Core Version:    0.6.2
 */