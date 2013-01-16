package com.facebook.orca.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.OrcaServiceFragment;

public class SilentLoginFragment extends AuthFragmentBase
  implements AnalyticsActivity
{
  private MeUserAuthDataStore b;
  private OrcaAuthStateMachineMonitor c;
  private OrcaServiceFragment d;

  private boolean N()
  {
    int i = 1;
    if (b());
    while (true)
    {
      return i;
      if (this.b.d())
      {
        P();
        continue;
      }
      i = 0;
    }
  }

  private void O()
  {
    Bundle localBundle = new Bundle();
    this.d.a("login", localBundle);
  }

  private void P()
  {
    this.c.d();
    b(new Intent("com.facebook.orca.login.OrcaAuthStateMachineMonitor.LOGIN_COMPLETE"));
  }

  private void R()
  {
    this.b.a();
    M();
  }

  public void B()
  {
    super.B();
    if (N());
    while (true)
    {
      return;
      if (!this.d.a())
      {
        if (this.b.e())
        {
          O();
          continue;
        }
        M();
        continue;
      }
    }
  }

  public void D()
  {
    Fragment[] arrayOfFragment = new Fragment[1];
    arrayOfFragment[0] = this.d;
    a(arrayOfFragment);
    super.D();
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (b());
    for (View localView = null; ; localView = a(AuthFragmentControlBase.class, paramViewGroup))
      return localView;
  }

  public String a()
  {
    return "login_silent";
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    FbInjector localFbInjector = Q();
    this.c = ((OrcaAuthStateMachineMonitor)localFbInjector.a(OrcaAuthStateMachineMonitor.class));
    this.b = ((MeUserAuthDataStore)localFbInjector.a(MeUserAuthDataStore.class));
    this.d = OrcaServiceFragment.a(this, "loginOperation");
    this.d.a(new SilentLoginFragment.1(this));
    if (this.a != null)
      N();
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    N();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.SilentLoginFragment
 * JD-Core Version:    0.6.0
 */