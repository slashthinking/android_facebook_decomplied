package com.facebook.orca.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.OperationProgressIndicator;
import com.facebook.orca.ops.OrcaServiceFragment;

public class LogoutFragment extends AuthFragmentBase
  implements AnalyticsActivity
{
  public static String b = "delete_account_flag";
  private OrcaServiceFragment c;
  private OperationProgressIndicator d;
  private AuthStateMachineMonitor e;

  private void O()
  {
    this.e.c();
    b(new Intent("com.facebook.orca.login.AuthStateMachineMonitor.LOGOUT_COMPLETE"));
  }

  private void P()
  {
    c();
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
    if (this.c.a());
    while (true)
    {
      return;
      Bundle localBundle = new Bundle();
      this.c.a(this.d);
      if (n().getIntent().getBooleanExtra(b, false))
        this.c.a("auth_delete_partial_user", localBundle);
      else
        this.c.a("auth_logout", localBundle);
    }
  }

  public String a()
  {
    return "logout";
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.e = ((AuthStateMachineMonitor)Q().a(AuthStateMachineMonitor.class));
    this.c = OrcaServiceFragment.a(this, "authLogout");
    this.c.a(new LogoutFragment.1(this));
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.d = d().b().a;
    N();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.LogoutFragment
 * JD-Core Version:    0.6.2
 */