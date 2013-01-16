package com.facebook.orca.login;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.content.SecureContextHelper;
import com.facebook.fragment.NavigableFragmentController.FragmentActionBuilder;
import com.facebook.orca.app.IntendedAudience;
import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.locale.FBLocaleMapper;
import com.facebook.orca.nux.LearnMoreActivity;
import com.facebook.orca.ops.OrcaServiceFragment;
import com.facebook.orca.ops.OrcaServiceOperation.State;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.prefs.AuthPrefKeys;
import com.facebook.orca.prefs.InternalPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.protocol.base.ApiErrorResult;
import com.facebook.orca.server.ErrorCode;
import com.facebook.orca.server.OperationResult;
import com.google.common.base.Optional;
import java.util.Locale;
import java.util.UUID;

public class WildfireRegStartFragment extends AuthFragmentBase
  implements AnalyticsActivity, WildfireRegStartFragmentControl
{
  private static final Class<?> b = WildfireRegStartFragment.class;
  private OrcaSharedPreferences Y;
  private SecureContextHelper Z;
  private WildfireAnalyticsUtils aa;
  private OrcaServiceFragment ab;
  private boolean c;
  private boolean d;
  private Optional<Boolean> e;
  private WildfireRegStartFragment.ViewControl f;
  private AnalyticsLogger g;
  private AuthStateMachineMonitor h;
  private OrcaAppType i;

  private void T()
  {
    BLog.b(b, "Attempting to start registration check operation...");
    if (this.ab.b() != OrcaServiceOperation.State.INIT);
    while (true)
    {
      return;
      if (!this.e.isPresent())
      {
        BLog.b(b, "Preparing to start registration check operation...");
        this.f.beginShowingProgress();
        this.d = true;
        this.ab.a("get_wildfire_reg_gk", new Bundle());
        BLog.b(b, "Started registration check operation");
        continue;
      }
      BLog.b(b, "Using cached registration check result...");
      b(((Boolean)this.e.get()).booleanValue());
    }
  }

  private void U()
  {
    Uri.Builder localBuilder = Uri.parse("https://m.facebook.com/r.php").buildUpon();
    localBuilder.appendQueryParameter("locale", FBLocaleMapper.a(Locale.getDefault()));
    this.Z.b(new Intent("android.intent.action.VIEW", localBuilder.build()), p());
    a(PasswordCredentialsFragment.class);
    this.d = false;
    this.f.stopShowingProgress();
  }

  private Uri a(String paramString)
  {
    Uri.Builder localBuilder = Uri.parse(paramString).buildUpon();
    localBuilder.appendQueryParameter("cid", this.i.b());
    localBuilder.appendQueryParameter("locale", FBLocaleMapper.a(Locale.getDefault()));
    return localBuilder.build();
  }

  private void a(ServiceException paramServiceException)
  {
    BLog.e(b, "Registration check failed with error " + paramServiceException.getMessage());
    if (paramServiceException.a() == ErrorCode.API_ERROR)
    {
      int j = ((ApiErrorResult)paramServiceException.b().h()).a();
      BLog.e(b, "API error code: " + j);
    }
    b(false);
  }

  private void a(OperationResult paramOperationResult)
  {
    Bundle localBundle = (Bundle)paramOperationResult.h();
    BLog.c(b, "Registration check succeeded: " + localBundle.getBoolean("messenger_wildfire_android"));
    if ((localBundle.getBoolean("messenger_wildfire_android")) || (this.i.h() != IntendedAudience.PUBLIC));
    for (boolean bool = true; ; bool = false)
    {
      b(bool);
      return;
    }
  }

  private void b(boolean paramBoolean)
  {
    this.e = Optional.of(Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      BLog.c(b, "Registration enabled");
      this.f.stopShowingProgress();
      this.d = false;
    }
    while (true)
    {
      return;
      BLog.c(b, "Registration disabled");
      if (this.c)
      {
        U();
        continue;
      }
      a(false);
    }
  }

  public void D()
  {
    Fragment[] arrayOfFragment = new Fragment[1];
    arrayOfFragment[0] = this.ab;
    a(arrayOfFragment);
    super.D();
  }

  public void N()
  {
    this.g.a(this.aa.a("create_tapped"));
    OrcaSharedPreferences.Editor localEditor = this.Y.b();
    localEditor.a(InternalPrefKeys.b, true);
    localEditor.a();
    b(new NavigableFragmentController.FragmentActionBuilder(WildfireRegNameFragment.class).c());
  }

  public void O()
  {
    this.Z.b(new Intent("android.intent.action.VIEW", a("https://m.facebook.com/srr")), p());
  }

  public void P()
  {
    this.Z.b(new Intent("android.intent.action.VIEW", a("https://m.facebook.com/dup")), p());
  }

  public void R()
  {
    this.Z.b(new Intent("android.intent.action.VIEW", a("https://m.facebook.com/help/mobilecookies")), p());
  }

  public void S()
  {
    Intent localIntent = new Intent(p(), LearnMoreActivity.class);
    localIntent.putExtra("layout", 2130903437);
    this.Z.a(localIntent, p());
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = a(WildfireRegStartFragmentControl.class, paramViewGroup);
    this.f = ((WildfireRegStartFragment.ViewControl)localView);
    return localView;
  }

  public String a()
  {
    return "wildfire_reg";
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    Bundle localBundle = m();
    if (localBundle != null)
      this.c = localBundle.getBoolean("orca:authparam:redirectsignup", false);
    if (paramBundle != null)
    {
      this.d = paramBundle.getBoolean("isProgressIndicatorShowing", false);
      this.e = ((Optional)paramBundle.getSerializable("wildfireGkResult"));
    }
    if (this.e == null)
      this.e = Optional.absent();
    FbInjector localFbInjector = Q();
    this.g = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    this.h = ((AuthStateMachineMonitor)localFbInjector.a(AuthStateMachineMonitor.class));
    this.i = ((OrcaAppType)localFbInjector.a(OrcaAppType.class));
    this.Y = ((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class));
    this.Z = ((SecureContextHelper)localFbInjector.a(SecureContextHelper.class));
    this.aa = ((WildfireAnalyticsUtils)localFbInjector.a(WildfireAnalyticsUtils.class));
    if (!this.Y.a(AuthPrefKeys.k))
    {
      OrcaSharedPreferences.Editor localEditor = this.Y.b();
      localEditor.a(AuthPrefKeys.k, UUID.randomUUID().toString());
      localEditor.a();
    }
    this.ab = OrcaServiceFragment.a(this, "getWildfireRegGkOperation");
    this.ab.a(new WildfireRegStartFragment.1(this));
    this.g.a(this.aa.a("start_registration"));
  }

  public void a(boolean paramBoolean)
  {
    NavigableFragmentController.FragmentActionBuilder localFragmentActionBuilder = new NavigableFragmentController.FragmentActionBuilder(PasswordCredentialsFragment.class);
    if (paramBoolean)
    {
      this.g.a(this.aa.a("login_tapped"));
      localFragmentActionBuilder.a();
    }
    b(localFragmentActionBuilder.c());
    this.f.stopShowingProgress();
    this.d = false;
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.h.a();
    if (this.d)
      this.f.beginShowingProgress();
  }

  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    paramBundle.putBoolean("isProgressIndicatorShowing", this.d);
    paramBundle.putSerializable("wildfireGkResult", this.e);
  }

  public void f()
  {
    super.f();
    T();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.WildfireRegStartFragment
 * JD-Core Version:    0.6.0
 */