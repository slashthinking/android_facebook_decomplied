package com.facebook.orca.login;

import android.os.Bundle;
import android.support.v4.app.NestedFragment;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.auth.AuthDataStore;
import com.facebook.orca.auth.FacebookCredentials;
import com.facebook.orca.common.names.NameJoiner;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.nux.OrcaNuxManager;
import com.facebook.orca.ops.OrcaServiceFragment;
import com.facebook.orca.ops.OrcaServiceOperation.State;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.prefs.AuthPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.server.ConfirmPhoneAndRegisterPartialAccountResult;
import com.facebook.orca.server.OperationResult;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

public class WildfireRegistrationOperation
{
  private static final Class<?> a = WildfireRegistrationOperation.class;
  private WildfireRegistrationOperation.Listener b;
  private AnalyticsLogger c;
  private AuthDataStore d;
  private AuthStateMachineMonitor e;
  private OrcaSharedPreferences f;
  private OrcaNuxManager g;
  private WildfireAnalyticsUtils h;
  private final LoginAfterAuthCoordinator i;
  private final NameJoiner j;
  private String k;
  private OrcaServiceFragment l;

  @Inject
  public WildfireRegistrationOperation(AnalyticsLogger paramAnalyticsLogger, AuthStateMachineMonitor paramAuthStateMachineMonitor, OrcaSharedPreferences paramOrcaSharedPreferences, OrcaNuxManager paramOrcaNuxManager, WildfireAnalyticsUtils paramWildfireAnalyticsUtils, LoginAfterAuthCoordinator paramLoginAfterAuthCoordinator, NameJoiner paramNameJoiner)
  {
    this.c = paramAnalyticsLogger;
    this.e = paramAuthStateMachineMonitor;
    this.f = paramOrcaSharedPreferences;
    this.g = paramOrcaNuxManager;
    this.h = paramWildfireAnalyticsUtils;
    this.i = paramLoginAfterAuthCoordinator;
    this.j = paramNameJoiner;
  }

  private void a(ServiceException paramServiceException)
  {
    BLog.e(a, "Registration failed with error " + paramServiceException.getMessage());
    this.b.a(paramServiceException);
  }

  private void a(OperationResult paramOperationResult)
  {
    BLog.c(a, "Registration succeeded");
    ConfirmPhoneAndRegisterPartialAccountResult localConfirmPhoneAndRegisterPartialAccountResult = (ConfirmPhoneAndRegisterPartialAccountResult)paramOperationResult.h();
    this.i.a();
    this.d.a(new FacebookCredentials(localConfirmPhoneAndRegisterPartialAccountResult.b(), 0L), true);
    this.c.a(this.h.a(this.k, "registration_success").a("user_id", localConfirmPhoneAndRegisterPartialAccountResult.a()));
    this.f.b().a(AuthPrefKeys.k).a();
    this.g.a();
    this.e.b();
    this.b.N();
  }

  public ImmutableList<OrcaServiceFragment> a()
  {
    return ImmutableList.a(this.l);
  }

  public void a(NestedFragment paramNestedFragment)
  {
    this.l = OrcaServiceFragment.a(paramNestedFragment, "registerPartialAccountOperation");
    this.l.a(new WildfireRegistrationOperation.1(this));
  }

  public void a(AuthDataStore paramAuthDataStore)
  {
    this.d = paramAuthDataStore;
  }

  public void a(WildfireRegistrationOperation.Listener paramListener)
  {
    this.b = paramListener;
  }

  public void a(String paramString)
  {
    this.k = paramString;
  }

  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    String str = this.j.a(paramString1, paramString2);
    Bundle localBundle = new Bundle();
    localBundle.putString("phone", paramString3);
    localBundle.putString("countryCode", paramString4);
    localBundle.putString("confirmationCode", paramString5);
    localBundle.putString("fullName", str);
    localBundle.putString("firstName", paramString1);
    localBundle.putString("lastName", paramString2);
    this.l.a("register_partial_acct", localBundle);
  }

  public boolean b()
  {
    if (this.l.b() != OrcaServiceOperation.State.INIT);
    for (int m = 1; ; m = 0)
      return m;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.WildfireRegistrationOperation
 * JD-Core Version:    0.6.0
 */