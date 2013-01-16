package com.facebook.orca.login;

import android.content.Intent;
import com.facebook.orca.auth.PasswordCredentials;
import com.facebook.orca.ops.OperationProgressIndicator;

public abstract interface PasswordCredentialsFragmentControl extends AuthFragmentControlBase
{
  public abstract void N();

  public abstract void a(PasswordCredentials paramPasswordCredentials, OperationProgressIndicator paramOperationProgressIndicator);

  public abstract void c(Intent paramIntent);
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.PasswordCredentialsFragmentControl
 * JD-Core Version:    0.6.2
 */