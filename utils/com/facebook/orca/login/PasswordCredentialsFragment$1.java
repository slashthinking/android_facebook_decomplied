package com.facebook.orca.login;

import com.facebook.orca.ops.OrcaServiceOperation.OnCompletedListener;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;

class PasswordCredentialsFragment$1 extends OrcaServiceOperation.OnCompletedListener
{
  PasswordCredentialsFragment$1(PasswordCredentialsFragment paramPasswordCredentialsFragment)
  {
  }

  public void a(ServiceException paramServiceException)
  {
    PasswordCredentialsFragment.a(this.a, paramServiceException);
  }

  public void a(OperationResult paramOperationResult)
  {
    PasswordCredentialsFragment.a(this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.PasswordCredentialsFragment.1
 * JD-Core Version:    0.6.2
 */