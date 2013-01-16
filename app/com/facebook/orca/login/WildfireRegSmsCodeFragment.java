package com.facebook.orca.login;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.facebook.orca.ops.OperationProgressIndicator;
import com.facebook.orca.ops.OrcaServiceFragment;
import com.facebook.orca.ops.OrcaServiceOperation.State;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.phonenumber.identification.VerifyPhoneNumberParams;
import com.facebook.orca.prefs.AuthPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.protocol.base.ApiErrorResult;
import com.facebook.orca.server.ErrorCode;
import com.facebook.orca.server.OperationResult;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import javax.inject.Provider;

public class WildfireRegSmsCodeFragment extends AuthFragmentBase
  implements AnalyticsActivity, WildfireRegSmsCodeFragmentControl, WildfireRegistrationOperation.Listener
{
  private static final Class<?> b = WildfireRegSmsCodeFragment.class;
  private WildfireRegSmsCodeFragment.ViewControl Y;
  private AnalyticsLogger Z;
  private ObjectMapper aa;
  private OrcaSharedPreferences ab;
  private OrcaPhoneNumberUtil ac;
  private SecureContextHelper ad;
  private WildfireAnalyticsUtils ae;
  private WildfireRegistrationOperation af;
  private Provider<String> ag;
  private OrcaServiceFragment ah;
  private int c;
  private boolean d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;

  private void P()
  {
    this.Z.a(this.ae.b("manual_sms_success"));
    WildfireRegSmsCodeFragment.ViewControl localViewControl = this.Y;
    Resources localResources = q();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.ac.c(this.g);
    localViewControl.setSmsCodePrompt(localResources.getString(2131362373, arrayOfObject));
  }

  private void R()
  {
    Uri.Builder localBuilder = Uri.parse("https://m.facebook.com/r.php").buildUpon();
    localBuilder.appendQueryParameter("locale", FBLocaleMapper.a(Locale.getDefault()));
    this.ad.b(new Intent("android.intent.action.VIEW", localBuilder.build()), p());
    a(PasswordCredentialsFragment.class);
    this.d = false;
    this.Y.stopShowingProgress();
  }

  public static Bundle a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("orca:authparam:firstname", paramString1);
    localBundle.putString("orca:authparam:lastname", paramString2);
    localBundle.putString("orca:authparam:phonenumber", paramString3);
    localBundle.putString("orca:authparam:countrycode", paramString4);
    return localBundle;
  }

  private void a(ApiErrorResult paramApiErrorResult)
  {
    this.Y.stopShowingProgress();
    this.d = false;
    try
    {
      JsonNode localJsonNode2 = this.aa.readTree(paramApiErrorResult.c());
      localJsonNode1 = localJsonNode2;
      if (localJsonNode1 != null)
      {
        String str1 = localJsonNode1.get("error_title").asText();
        String str2 = localJsonNode1.get("error_message").asText();
        ErrorDialogBuilder.a(p()).a(str1).b(str2).a();
        BLog.e(b, str1 + ": " + str2);
        this.Z.a(this.ae.b("service_error").b("title", str1).b("message", str2));
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

  private void b(ServiceException paramServiceException)
  {
    BLog.e(b, "SMS request failed with error " + paramServiceException.getMessage());
    int j;
    if (paramServiceException.a() == ErrorCode.API_ERROR)
    {
      ApiErrorResult localApiErrorResult = (ApiErrorResult)paramServiceException.b().h();
      j = localApiErrorResult.a();
      BLog.e(b, "API error code: " + j);
      if (j == 2)
        a(localApiErrorResult);
    }
    while (true)
    {
      return;
      if (j == 368)
      {
        this.Z.a(this.ae.b("sentry_block"));
        R();
        continue;
      }
      this.Z.a(this.ae.b("manual_sms_failure").b("phone_number", this.g).b("country_code", this.h).a("error_code", j));
      ErrorDialogBuilder.a(p()).a(2131362339).a(paramServiceException).a();
    }
  }

  public void D()
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.af.a());
    localLinkedList.add(this.ah);
    a((Fragment[])localLinkedList.toArray(new OrcaServiceFragment[0]));
    super.D();
  }

  public void N()
  {
    b(new Intent("com.facebook.orca.login.AuthStateMachineMonitor.AUTH_COMPLETE"));
    this.d = false;
    this.Y.stopShowingProgress();
  }

  public void O()
  {
    Bundle localBundle = WildfireRegPhoneNumberFragment.a(this.e, this.f);
    b(new NavigableFragmentController.FragmentActionBuilder(WildfireRegPhoneNumberFragment.class).a().c().putExtras(localBundle));
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = a(WildfireRegSmsCodeFragmentControl.class, paramViewGroup);
    this.Y = ((WildfireRegSmsCodeFragment.ViewControl)localView);
    return localView;
  }

  public String a()
  {
    return "wildfire_reg_sms_code";
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (paramBundle != null)
    {
      this.c = paramBundle.getInt("numFails");
      this.d = paramBundle.getBoolean("isProgressIndicatorShowing");
    }
    this.e = m().getString("orca:authparam:firstname");
    this.f = m().getString("orca:authparam:lastname");
    this.g = m().getString("orca:authparam:phonenumber");
    this.h = m().getString("orca:authparam:countrycode");
    FbInjector localFbInjector = Q();
    this.Z = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    this.aa = ((ObjectMapper)localFbInjector.a(ObjectMapper.class));
    this.ab = ((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class));
    this.ac = ((OrcaPhoneNumberUtil)localFbInjector.a(OrcaPhoneNumberUtil.class));
    this.ae = ((WildfireAnalyticsUtils)localFbInjector.a(WildfireAnalyticsUtils.class));
    this.ad = ((SecureContextHelper)localFbInjector.a(SecureContextHelper.class));
    this.af = ((WildfireRegistrationOperation)localFbInjector.a(WildfireRegistrationOperation.class));
    this.ag = localFbInjector.b(String.class, PhoneIsoCountryCode.class);
    this.af.a(this);
    this.af.a(this);
    this.af.a("wildfire_registration_manual");
    this.ah = OrcaServiceFragment.a(this, "requestSmsOperation");
    this.ah.a(new WildfireRegSmsCodeFragment.1(this));
  }

  public void a(OperationProgressIndicator paramOperationProgressIndicator)
  {
    if (this.ah.b() != OrcaServiceOperation.State.INIT);
    while (true)
    {
      return;
      VerifyPhoneNumberParams localVerifyPhoneNumberParams = new VerifyPhoneNumberParams(this.g, this.h);
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("verifyPhoneNumberParams", localVerifyPhoneNumberParams);
      localBundle.putString("flow", "PARTIAL_REGISTRATION");
      localBundle.putString("reg_instance", this.ab.a(AuthPrefKeys.k, null));
      this.ah.a(paramOperationProgressIndicator);
      this.ah.a("verify_phone_number_manual", localBundle);
    }
  }

  public void a(ServiceException paramServiceException)
  {
    this.Y.stopShowingProgress();
    this.d = false;
    BLog.e(b, "Registration failed with error " + paramServiceException.getMessage());
    this.c = (1 + this.c);
    if (this.c >= 3)
      R();
    while (true)
    {
      return;
      BLog.e(b, "Registration failed with error " + paramServiceException.getMessage());
      if (paramServiceException.a() == ErrorCode.API_ERROR)
      {
        ApiErrorResult localApiErrorResult = (ApiErrorResult)paramServiceException.b().h();
        int j = localApiErrorResult.a();
        BLog.e(b, "API error code: " + j);
        if (j == 3301)
        {
          this.Z.a(this.ae.b("confirmation_code_invalid").b("code", this.i).a("error_code", j));
          this.Y.setSmsCodePromptResource(2131362371);
          this.Y.showSmsCodeError();
          continue;
        }
        if (j == 3302)
        {
          this.Z.a(this.ae.b("confirmation_code_invalid").b("code", this.i).a("error_code", j));
          this.Y.setSmsCodePromptResource(2131362372);
          this.Y.showSmsCodeError();
          continue;
        }
        if (j == 2)
        {
          a(localApiErrorResult);
          continue;
        }
        if (j == 368)
        {
          this.Z.a(this.ae.b("sentry_block"));
          R();
          continue;
        }
      }
      ErrorDialogBuilder.a(p()).a(2131362339).a(paramServiceException).a();
    }
  }

  public void a(String paramString)
  {
    if (this.af.b());
    while (true)
    {
      return;
      this.Y.beginShowingProgress();
      this.d = true;
      this.af.a(this.e, this.f, this.g, this.h, paramString);
      this.Z.a(this.ae.b("manual_sms_code_entered").b("code", paramString));
    }
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.af.a(d().a());
    WildfireRegSmsCodeFragment.ViewControl localViewControl = this.Y;
    Resources localResources = q();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.ac.c(this.g);
    localViewControl.setSmsCodePrompt(localResources.getString(2131362370, arrayOfObject));
    if (this.d)
      this.Y.beginShowingProgress();
  }

  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    paramBundle.putInt("numFails", this.c);
    paramBundle.putBoolean("isProgressIndicatorShowing", this.d);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.WildfireRegSmsCodeFragment
 * JD-Core Version:    0.6.0
 */