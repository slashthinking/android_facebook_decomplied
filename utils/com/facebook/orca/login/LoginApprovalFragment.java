package com.facebook.orca.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.auth.PasswordCredentials;
import com.facebook.orca.common.dialogs.ErrorDialogBuilder;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.OperationProgressIndicator;
import com.facebook.orca.ops.OrcaServiceFragment;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.protocol.base.ApiErrorResult;
import com.facebook.orca.server.ErrorCode;
import com.facebook.orca.server.OperationResult;

public class LoginApprovalFragment extends AuthFragmentBase
  implements AnalyticsActivity, LoginApprovalFragmentControl
{
  private OrcaServiceFragment b;
  private String c;
  private AuthStateMachineMonitor d;
  private FbErrorReporter e;

  private void N()
  {
    O();
  }

  private void O()
  {
    this.d.b();
    b(new Intent("com.facebook.orca.login.AuthStateMachineMonitor.AUTH_COMPLETE"));
  }

  public static Bundle a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("orca:authparam:email", paramString);
    return localBundle;
  }

  private void a(ServiceException paramServiceException)
  {
    if (paramServiceException.a() == ErrorCode.API_ERROR);
    for (int i = ((ApiErrorResult)paramServiceException.b().h()).a(); ; i = 0)
    {
      this.e.a("MESSENGER_LOGIN_ERROR", "login approval error: " + i, paramServiceException, false, 1000);
      ((ErrorDialogBuilder)Q().a(ErrorDialogBuilder.class)).a(paramServiceException).a();
      return;
    }
  }

  public void D()
  {
    Fragment[] arrayOfFragment = new Fragment[1];
    arrayOfFragment[0] = this.b;
    a(arrayOfFragment);
    super.D();
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return a(LoginApprovalFragmentControl.class, paramViewGroup);
  }

  public String a()
  {
    return "login_approval";
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.d = ((AuthStateMachineMonitor)Q().a(AuthStateMachineMonitor.class));
    this.e = ((FbErrorReporter)Q().a(FbErrorReporter.class));
    this.b = OrcaServiceFragment.a(this, "authenticateOperation");
    this.b.a(new LoginApprovalFragment.1(this));
    this.c = m().getString("orca:authparam:email");
  }

  public void a(String paramString, OperationProgressIndicator paramOperationProgressIndicator)
  {
    if (this.b.a());
    while (true)
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("passwordCredentials", new PasswordCredentials(this.c, paramString));
      this.b.a(paramOperationProgressIndicator);
      this.b.a("auth_password", localBundle);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.LoginApprovalFragment
 * JD-Core Version:    0.6.2
 */