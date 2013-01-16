package com.facebook.orca.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.fragment.NavigableFragmentController.FragmentActionBuilder;
import com.facebook.orca.auth.AuthDataStore;
import com.facebook.orca.auth.PasswordCredentials;
import com.facebook.orca.common.dialogs.ErrorDialogBuilder;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.OperationProgressIndicator;
import com.facebook.orca.ops.OrcaServiceFragment;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.protocol.base.ApiErrorResult;
import com.facebook.orca.server.ErrorCode;
import com.facebook.orca.server.OperationResult;

public class PasswordCredentialsFragment extends AuthFragmentBase
  implements AnalyticsActivity, PasswordCredentialsFragmentControl
{
  private AuthDataStore b;
  private OrcaServiceFragment c;
  private PasswordCredentials d;
  private AuthStateMachineMonitor e;
  private FbErrorReporter f;

  private void O()
  {
    P();
  }

  private void P()
  {
    this.e.b();
    b(new Intent("com.facebook.orca.login.AuthStateMachineMonitor.AUTH_COMPLETE"));
  }

  private void R()
  {
    b(new NavigableFragmentController.FragmentActionBuilder(LoginApprovalFragment.class).a().c().putExtras(LoginApprovalFragment.a(this.d.a())));
  }

  public static Bundle a(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("orca:authparam:phone", paramString1);
    localBundle.putString("orca:authparam:name", paramString2);
    localBundle.putString("orca:authparam:photourl", paramString3);
    return localBundle;
  }

  private void a(int paramInt, Throwable paramThrowable)
  {
    this.f.a("MESSENGER_LOGIN_ERROR", "login error: " + paramInt, paramThrowable, false, 1000);
  }

  private void a(ServiceException paramServiceException)
  {
    ErrorCode localErrorCode1 = paramServiceException.a();
    ErrorCode localErrorCode2 = ErrorCode.API_ERROR;
    int i = 0;
    if (localErrorCode1 == localErrorCode2)
    {
      i = ((ApiErrorResult)paramServiceException.b().h()).a();
      if (i == 406)
        R();
    }
    while (true)
    {
      return;
      if ((i == 400) || (i == 401))
      {
        a(i, paramServiceException);
        ((ErrorDialogBuilder)Q().a(ErrorDialogBuilder.class)).b(2131362216).a();
      }
      else
      {
        a(i, paramServiceException);
        ((ErrorDialogBuilder)Q().a(ErrorDialogBuilder.class)).a(paramServiceException).a();
      }
    }
  }

  public void B()
  {
    super.B();
    if (this.b.e())
      P();
  }

  public void D()
  {
    Fragment[] arrayOfFragment = new Fragment[1];
    arrayOfFragment[0] = this.c;
    a(arrayOfFragment);
    super.D();
  }

  public void N()
  {
    Bundle localBundle = m();
    if (localBundle != null)
    {
      localBundle.remove("orca:authparam:phone");
      localBundle.remove("orca:authparam:name");
      localBundle.remove("orca:authparam:photourl");
    }
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = a(PasswordCredentialsFragmentControl.class, paramViewGroup);
    PasswordCredentialsFragment.ViewControl localViewControl = (PasswordCredentialsFragment.ViewControl)localView;
    Bundle localBundle = m();
    if ((localBundle != null) && (localBundle.get("orca:authparam:phone") != null))
      localViewControl.setUser(localBundle.getString("orca:authparam:phone"), localBundle.getString("orca:authparam:name"), localBundle.getString("orca:authparam:photourl"));
    return localView;
  }

  public String a()
  {
    return "login_screen";
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    FbInjector localFbInjector = Q();
    this.e = ((AuthStateMachineMonitor)localFbInjector.a(AuthStateMachineMonitor.class));
    this.f = ((FbErrorReporter)localFbInjector.a(FbErrorReporter.class));
    this.c = OrcaServiceFragment.a(this, "authenticateOperation");
    this.c.a(new PasswordCredentialsFragment.1(this));
    if (paramBundle != null)
      this.d = ((PasswordCredentials)paramBundle.getParcelable("passwordCredentials"));
  }

  public void a(PasswordCredentials paramPasswordCredentials, OperationProgressIndicator paramOperationProgressIndicator)
  {
    if (this.c.a());
    while (true)
    {
      return;
      this.d = paramPasswordCredentials;
      this.b.b();
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("passwordCredentials", paramPasswordCredentials);
      this.c.a(paramOperationProgressIndicator);
      this.c.a("auth_password", localBundle);
    }
  }

  public void c(Intent paramIntent)
  {
    b(paramIntent);
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.e.a();
    this.b = d().a();
  }

  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    paramBundle.putParcelable("passwordCredentials", this.d);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.PasswordCredentialsFragment
 * JD-Core Version:    0.6.2
 */