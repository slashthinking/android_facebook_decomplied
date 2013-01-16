package com.facebook.orca.login;

import com.facebook.orca.ops.OrcaServiceOperation.OnCompletedListener;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;

class LoginApprovalFragment$1 extends OrcaServiceOperation.OnCompletedListener
{
  LoginApprovalFragment$1(LoginApprovalFragment paramLoginApprovalFragment)
  {
  }

  public void a(ServiceException paramServiceException)
  {
    LoginApprovalFragment.a(this.a, paramServiceException);
  }

  public void a(OperationResult paramOperationResult)
  {
    LoginApprovalFragment.a(this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.LoginApprovalFragment.1
 * JD-Core Version:    0.6.2
 */