package com.facebook.orca.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.fragment.NavigableFragmentController.FragmentActionBuilder;
import com.facebook.orca.annotations.IsWildfireRegEnabled;
import com.facebook.orca.auth.AuthDataStore;
import com.facebook.orca.auth.FirstPartySsoSessionInfo;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.OperationProgressIndicator;
import com.facebook.orca.ops.OrcaServiceFragment;
import com.facebook.orca.ops.ServiceException;
import javax.inject.Provider;

public class FirstPartySsoFragment extends AuthFragmentBase
  implements AnalyticsActivity, FirstPartySsoFragmentControl
{
  private AuthDataStore b;
  private OrcaServiceFragment c;
  private FirstPartySsoSessionInfo d;
  private SsoLoginUtil e;
  private AuthStateMachineMonitor f;
  private Provider<Boolean> g;
  private FirstPartySsoFragment.ViewControl h;

  private boolean O()
  {
    boolean bool = true;
    if (b());
    while (true)
    {
      return bool;
      if (this.b.e())
      {
        R();
      }
      else if (!this.e.a(p()))
      {
        N();
      }
      else
      {
        this.d = this.e.d(p());
        if (this.d == null)
          N();
        else
          bool = false;
      }
    }
  }

  private void P()
  {
    R();
  }

  private void R()
  {
    this.f.b();
    b(new Intent("com.facebook.orca.login.AuthStateMachineMonitor.AUTH_COMPLETE"));
  }

  private void a(ServiceException paramServiceException)
  {
    N();
  }

  public void B()
  {
    super.B();
    this.f.a();
    O();
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
    if ((!this.e.c(n())) && (((Boolean)this.g.b()).booleanValue()))
      b(new Intent("com.facebook.orca.login.AuthStateMachineMonitor.EXIT_TO_WILDFIRE_REGISTRATION"));
    while (true)
    {
      return;
      NavigableFragmentController.FragmentActionBuilder localFragmentActionBuilder = new NavigableFragmentController.FragmentActionBuilder(PasswordCredentialsFragment.class);
      if (this.e.a(p()))
        localFragmentActionBuilder.a();
      b(localFragmentActionBuilder.c());
    }
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView;
    if (b())
      localView = null;
    while (true)
    {
      return localView;
      localView = a(FirstPartySsoFragmentControl.class, paramViewGroup);
      this.h = ((FirstPartySsoFragment.ViewControl)localView);
    }
  }

  public String a()
  {
    return "login_sso";
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    FbInjector localFbInjector = Q();
    this.e = ((SsoLoginUtil)localFbInjector.a(SsoLoginUtil.class));
    this.f = ((AuthStateMachineMonitor)localFbInjector.a(AuthStateMachineMonitor.class));
    this.g = localFbInjector.b(Boolean.class, IsWildfireRegEnabled.class);
    this.c = OrcaServiceFragment.a(this, "authenticateOperation");
    this.c.a(new FirstPartySsoFragment.1(this));
    if ((d() != null) && (this.a != null))
    {
      this.b = d().a();
      O();
    }
  }

  public void a(OperationProgressIndicator paramOperationProgressIndicator)
  {
    if (this.c.a());
    while (true)
    {
      return;
      this.b.b();
      Bundle localBundle = new Bundle();
      localBundle.putString("accessToken", this.d.b());
      this.c.a(paramOperationProgressIndicator);
      this.c.a("auth_sso", localBundle);
    }
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.b = d().a();
    O();
    if ((this.d != null) && (this.h != null))
      this.h.setSsoSessionInfo(this.d);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.FirstPartySsoFragment
 * JD-Core Version:    0.6.2
 */