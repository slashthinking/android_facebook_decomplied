package com.facebook.orca.login;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.content.SecureContextHelper;
import com.facebook.fragment.NavigableFragmentController.FragmentActionBuilder;
import com.facebook.orca.annotations.PhoneIsoCountryCode;
import com.facebook.orca.common.dialogs.ErrorDialogBuilder;
import com.facebook.orca.common.util.OrcaPhoneNumberUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.locale.FBLocaleMapper;
import com.facebook.orca.ops.OrcaServiceFragment;
import com.facebook.orca.ops.OrcaServiceOperation.State;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.phonenumber.identification.VerifyPhoneNumberParams;
import com.facebook.orca.phonenumber.identification.VerifyPhoneNumberResult;
import com.facebook.orca.prefs.AuthPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.protocol.base.ApiErrorResult;
import com.facebook.orca.server.ErrorCode;
import com.facebook.orca.server.OperationResult;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import javax.inject.Provider;

public class WildfireRegNameFragment extends AuthFragmentBase
  implements AnalyticsActivity, WildfireRegNameFragmentControl, WildfireRegistrationOperation.Listener, WildfireUserLookupOperation.Listener
{
  private static final Class<?> b = WildfireRegNameFragment.class;
  private int Y;
  private boolean Z;
  private boolean aa;
  private WildfireRegNameFragment.ViewControl ab;
  private AnalyticsLogger ac;
  private OrcaSharedPreferences ad;
  private OrcaPhoneNumberUtil ae;
  private ObjectMapper af;
  private Provider<String> ag;
  private SecureContextHelper ah;
  private WildfireAnalyticsUtils ai;
  private WildfireRegistrationOperation aj;
  private WildfireUserLookupOperation ak;
  private OrcaServiceFragment al;
  private OrcaServiceFragment am;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private boolean h;
  private boolean i;

  private void O()
  {
    this.c = ((TelephonyManager)p().getSystemService("phone")).getLine1Number();
    this.d = ((String)this.ag.b());
    this.e = this.ad.a(AuthPrefKeys.l, null);
    this.ac.a(this.ai.a("sms_cache_used"));
  }

  private void P()
  {
    BLog.c(b, "Clearing cached confirmation code.");
    this.ad.b().a(AuthPrefKeys.l).a(AuthPrefKeys.m).a();
    this.ac.a(this.ai.a("sms_cache_cleared"));
  }

  private void R()
  {
    BLog.b(b, "Attempting to start phone verification operation...");
    if ((this.al.b() != OrcaServiceOperation.State.INIT) || (this.h));
    while (true)
    {
      return;
      BLog.b(b, "Preparing to start phone verification operation...");
      this.c = ((TelephonyManager)p().getSystemService("phone")).getLine1Number();
      this.d = ((String)this.ag.b());
      VerifyPhoneNumberParams localVerifyPhoneNumberParams = new VerifyPhoneNumberParams(this.c, this.d);
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("verifyPhoneNumberParams", localVerifyPhoneNumberParams);
      localBundle.putString("flow", "PARTIAL_REGISTRATION");
      localBundle.putString("reg_instance", this.ad.a(AuthPrefKeys.k, null));
      this.al.a("verify_phone_number", localBundle);
      this.h = true;
      BLog.b(b, "Started phone verification operation");
    }
  }

  private void S()
  {
    BLog.b(b, "Attempting to restart phone verification operation...");
    if (!this.al.a());
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "Attempted to restart the phone verification operation while it was still running.");
      BLog.c(b, "Restarting phone verification operation...");
      this.e = null;
      this.h = false;
      this.i = false;
      P();
      R();
      return;
    }
  }

  private void T()
  {
    BLog.c(b, "Registration data verification succeeded");
    this.ab.setNamePromptResource(2131362360);
    this.ab.hideFirstNameError();
    this.ab.hideLastNameError();
    this.Z = true;
    this.ac.a(this.ai.a("reg_data_ok"));
    if (this.e != null)
      U();
    while (true)
    {
      return;
      if (this.i)
      {
        V();
        continue;
      }
    }
  }

  private void U()
  {
    BLog.c(b, "Registration verification succeeded. Registering account...");
    this.aj.a(this.f, this.g, this.c, this.d, this.e);
  }

  private void V()
  {
    b(new NavigableFragmentController.FragmentActionBuilder(WildfireRegPhoneNumberFragment.class).a().c().putExtras(WildfireRegPhoneNumberFragment.a(this.f, this.g)));
    this.aa = false;
    this.ab.stopShowingProgress();
  }

  private void W()
  {
    Uri.Builder localBuilder = Uri.parse("https://m.facebook.com/r.php").buildUpon();
    localBuilder.appendQueryParameter("locale", FBLocaleMapper.a(Locale.getDefault()));
    this.ah.b(new Intent("android.intent.action.VIEW", localBuilder.build()), p());
    a(PasswordCredentialsFragment.class);
    this.aa = false;
    this.ab.stopShowingProgress();
  }

  private void a(ApiErrorResult paramApiErrorResult)
  {
    this.ab.stopShowingProgress();
    this.aa = false;
    try
    {
      JsonNode localJsonNode2 = this.af.readTree(paramApiErrorResult.c());
      localJsonNode1 = localJsonNode2;
      if (localJsonNode1 != null)
      {
        String str1 = localJsonNode1.get("error_title").asText();
        String str2 = localJsonNode1.get("error_message").asText();
        ErrorDialogBuilder.a(p()).a(str1).b(str2).a();
        BLog.e(b, str1 + ": " + str2);
        this.ac.a(this.ai.a("service_error").b("title", str1).b("message", str2));
      }
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        BLog.e(b, "Unable to parse error data! " + localIOException.getMessage());
        JsonNode localJsonNode1 = null;
      }
    }
  }

  private void a(OperationResult paramOperationResult)
  {
    BLog.c(b, "Phone verification succeeded");
    this.e = ((VerifyPhoneNumberResult)paramOperationResult.h()).a();
    a(this.e);
    this.ac.a(this.ai.a("sms_auto_success"));
    if (this.Z)
      U();
  }

  private void a(String paramString)
  {
    BLog.c(b, "Caching confirmation code.");
    this.ad.b().a(AuthPrefKeys.l, paramString).a(AuthPrefKeys.m, System.nanoTime()).a();
    this.ac.a(this.ai.a("sms_cache_set"));
  }

  private void b(ServiceException paramServiceException)
  {
    BLog.e(b, "Phone verification failed with error " + paramServiceException.getMessage());
    this.i = true;
    String str = paramServiceException.a().toString();
    if (paramServiceException.a() == ErrorCode.API_ERROR)
    {
      int j = ((ApiErrorResult)paramServiceException.b().h()).a();
      str = j + "";
      BLog.e(b, "API error code: " + j);
    }
    this.ac.a(this.ai.a("sms_auto_failure").b("phone_number", this.c).b("country_code", this.d).b("error_code", str));
    if (this.Z)
      V();
  }

  private void c(ServiceException paramServiceException)
  {
    ApiErrorResult localApiErrorResult;
    int j;
    if (paramServiceException.a() == ErrorCode.API_ERROR)
    {
      localApiErrorResult = (ApiErrorResult)paramServiceException.b().h();
      j = localApiErrorResult.a();
      if (j != 3116);
    }
    while (true)
    {
      try
      {
        localJsonNode = this.af.readTree(localApiErrorResult.c());
        if (localJsonNode.get("name") == null)
          continue;
        this.ab.setNamePrompt(localJsonNode.get("name").get("error_body").asText());
        this.ab.showFirstNameError();
        this.ab.showLastNameError();
        this.ac.a(this.ai.a("invalid_name_restart").b("first_name", this.f).b("last_name", this.g).a("error_code", localJsonNode.get("name").get("error_code").asInt()));
        this.ab.stopShowingProgress();
        this.aa = false;
        this.Y = (1 + this.Y);
        if (this.Y < 3)
          continue;
        W();
        return;
      }
      catch (IOException localIOException)
      {
        JsonNode localJsonNode;
        BLog.e(b, "Unable to parse error data! " + localIOException.getMessage());
        W();
        continue;
        if (localJsonNode.get("phone") == null)
          continue;
        if (localJsonNode.get("phone").get("error_code").asInt() != 3128)
          continue;
        String str = localJsonNode.get("phone").get("existing_uid").asText();
        if (!localJsonNode.get("phone").get("is_existing_user_partial").asBoolean())
          continue;
        BLog.c(b, "Error was caused by the phone number belonging to a partial account. False alarm.");
        this.ac.a(this.ai.a("already_wf_user").b("user_id", str));
        T();
        continue;
        this.ac.a(this.ai.a("already_fb_user").b("user_id", str));
        this.ak.a(str, this.c);
        continue;
        BLog.e(b, "Error with phone number validation: " + localJsonNode.get("phone").get("error_body").asText());
        this.ac.a(this.ai.a("invalid_phone_number").b("phone_number", this.c).b("country_code", this.d).a("error_code", localJsonNode.get("phone").get("error_code").asInt()));
        V();
        continue;
      }
      if (j == 2)
      {
        a(localApiErrorResult);
        continue;
      }
      if (j == 368)
      {
        this.ac.a(this.ai.a("sentry_block"));
        W();
        continue;
      }
      this.ab.stopShowingProgress();
      this.aa = false;
      this.ab.setNamePromptResource(2131362360);
      ErrorDialogBuilder.a(p()).a(2131362339).a(paramServiceException).a();
    }
  }

  public void D()
  {
    BLog.b(b, "Destroyed");
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.aj.a());
    localLinkedList.addAll(this.ak.a());
    localLinkedList.add(this.al);
    localLinkedList.add(this.am);
    a((Fragment[])localLinkedList.toArray(new OrcaServiceFragment[0]));
    super.D();
  }

  public void N()
  {
    P();
    b(new Intent("com.facebook.orca.login.AuthStateMachineMonitor.AUTH_COMPLETE"));
    this.aa = false;
    this.ab.stopShowingProgress();
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = a(WildfireRegNameFragmentControl.class, paramViewGroup);
    this.ab = ((WildfireRegNameFragment.ViewControl)localView);
    return localView;
  }

  public String a()
  {
    return "wildfire_reg_name";
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (paramBundle != null)
    {
      this.c = paramBundle.getString("phoneNumber");
      this.d = paramBundle.getString("countryCode");
      this.e = paramBundle.getString("confirmationCode");
      this.f = paramBundle.getString("firstName");
      this.g = paramBundle.getString("lastName");
      this.h = paramBundle.getBoolean("phoneVerificationStarted", false);
      this.i = paramBundle.getBoolean("phoneVerificationFailed", false);
      this.Y = paramBundle.getInt("numNameVerificationFails", 0);
      this.Z = paramBundle.getBoolean("isNameVerificationComplete", false);
      this.aa = paramBundle.getBoolean("isProgressIndicatorShowing", false);
    }
    FbInjector localFbInjector = Q();
    this.ac = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    this.ad = ((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class));
    this.ae = ((OrcaPhoneNumberUtil)localFbInjector.a(OrcaPhoneNumberUtil.class));
    this.af = ((ObjectMapper)localFbInjector.a(ObjectMapper.class));
    this.ag = localFbInjector.b(String.class, PhoneIsoCountryCode.class);
    this.ah = ((SecureContextHelper)localFbInjector.a(SecureContextHelper.class));
    this.ai = ((WildfireAnalyticsUtils)localFbInjector.a(WildfireAnalyticsUtils.class));
    this.aj = ((WildfireRegistrationOperation)localFbInjector.a(WildfireRegistrationOperation.class));
    this.ak = ((WildfireUserLookupOperation)localFbInjector.a(WildfireUserLookupOperation.class));
    this.aj.a(this);
    this.aj.a(this);
    this.aj.a("wildfire_registration");
    this.ak.a(this);
    this.ak.a(this);
    if ((this.e == null) && (this.ad.a(AuthPrefKeys.l)) && (this.ad.a(AuthPrefKeys.m)))
    {
      if (System.nanoTime() - this.ad.a(AuthPrefKeys.m, 0L) >= 3600000000000L)
        break label425;
      BLog.c(b, "Using cached confirmation code.");
      O();
    }
    for (this.h = true; ; this.h = false)
    {
      this.al = OrcaServiceFragment.a(this, "phoneVerificationOperation");
      this.al.a(new WildfireRegNameFragment.1(this));
      this.am = OrcaServiceFragment.a(this, "regDataVerificationOperation");
      this.am.a(new WildfireRegNameFragment.2(this));
      return;
      label425: BLog.d(b, "Cached confirmation code expired.");
      P();
    }
  }

  public void a(ServiceException paramServiceException)
  {
    Object localObject = paramServiceException.a().toString();
    ApiErrorResult localApiErrorResult;
    int j;
    String str;
    if (paramServiceException.a() == ErrorCode.API_ERROR)
    {
      localApiErrorResult = (ApiErrorResult)paramServiceException.b().h();
      j = localApiErrorResult.a();
      str = j + "";
      BLog.e(b, "API error code: " + j);
      if ((j == 3301) || (j == 3302))
      {
        this.ac.a(this.ai.a("confirmation_code_invalid").b("code", this.e).a("error_code", j));
        S();
      }
    }
    while (true)
    {
      return;
      if (j == 2)
      {
        a(localApiErrorResult);
        continue;
      }
      if (j == 368)
      {
        this.ac.a(this.ai.a("sentry_block"));
        W();
        continue;
      }
      localObject = str;
      this.ab.stopShowingProgress();
      this.aa = false;
      this.ac.a(this.ai.a("registration_failure").b("error_code", (String)localObject));
      ErrorDialogBuilder.a(p()).a(2131362339).a(paramServiceException).a();
    }
  }

  public void a(String paramString1, String paramString2)
  {
    if (this.am.b() != OrcaServiceOperation.State.INIT);
    while (true)
    {
      return;
      this.f = paramString1;
      this.g = paramString2;
      Bundle localBundle = new Bundle();
      localBundle.putString("firstName", paramString1);
      localBundle.putString("lastName", paramString2);
      localBundle.putString("phone", this.ae.b(this.c));
      localBundle.putString("countryCode", this.d);
      this.ab.beginShowingProgress();
      this.aa = true;
      this.am.a("verify_reg_data", localBundle);
      this.ac.a(this.ai.a("name_entered").b("first_name", this.f).b("last_name", this.g));
    }
  }

  public void c(Intent paramIntent)
  {
    b(paramIntent);
    this.aa = false;
    this.ab.stopShowingProgress();
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.aj.a(d().a());
    if (this.aa)
      this.ab.beginShowingProgress();
  }

  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    paramBundle.putString("phoneNumber", this.c);
    paramBundle.putString("countryCode", this.d);
    paramBundle.putString("confirmationCode", this.e);
    paramBundle.putString("firstName", this.f);
    paramBundle.putString("lastName", this.g);
    paramBundle.putBoolean("phoneVerificationStarted", this.h);
    paramBundle.putBoolean("phoneVerificationFailed", this.i);
    paramBundle.putInt("numNameVerificationFails", this.Y);
    paramBundle.putBoolean("isNameVerificationComplete", this.Z);
    paramBundle.putBoolean("isProgressIndicatorShowing", this.aa);
  }

  public void f()
  {
    super.f();
    R();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.WildfireRegNameFragment
 * JD-Core Version:    0.6.0
 */