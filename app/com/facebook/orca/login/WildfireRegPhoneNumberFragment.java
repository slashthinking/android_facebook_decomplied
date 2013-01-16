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
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.content.SecureContextHelper;
import com.facebook.fragment.NavigableFragmentController.FragmentActionBuilder;
import com.facebook.orca.annotations.PhoneIsoCountryCode;
import com.facebook.orca.common.dialogs.ErrorDialogBuilder;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.locale.FBLocaleMapper;
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
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import javax.inject.Provider;

public class WildfireRegPhoneNumberFragment extends AuthFragmentBase
  implements AnalyticsActivity, WildfireRegPhoneNumberFragmentControl, WildfireUserLookupOperation.Listener
{
  private static final Class<?> b = WildfireRegPhoneNumberFragment.class;
  private AnalyticsLogger Y;
  private ObjectMapper Z;
  private OrcaSharedPreferences aa;
  private Provider<String> ab;
  private PhoneNumberUtil ac;
  private SecureContextHelper ad;
  private WildfireAnalyticsUtils ae;
  private WildfireUserLookupOperation af;
  private OrcaServiceFragment ag;
  private OrcaServiceFragment ah;
  private String c;
  private String d;
  private String e;
  private String f;
  private int g;
  private boolean h;
  private WildfireRegPhoneNumberFragment.ViewControl i;

  private void N()
  {
    BLog.c(b, "Registration data verification succeeded");
    this.Y.a(this.ae.b("manual_phone_number_ok").b("phone_number", this.e).b("country_code", this.f));
    O();
  }

  private void O()
  {
    VerifyPhoneNumberParams localVerifyPhoneNumberParams = new VerifyPhoneNumberParams(this.e, this.f);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("verifyPhoneNumberParams", localVerifyPhoneNumberParams);
    localBundle.putString("flow", "PARTIAL_REGISTRATION");
    localBundle.putString("reg_instance", this.aa.a(AuthPrefKeys.k, null));
    this.ah.a("verify_phone_number_manual", localBundle);
  }

  private void P()
  {
    BLog.c(b, "SMS request succeeded");
    this.Y.a(this.ae.b("manual_sms_success"));
    R();
  }

  private void R()
  {
    Bundle localBundle = WildfireRegSmsCodeFragment.a(this.c, this.d, this.e, this.f);
    b(new NavigableFragmentController.FragmentActionBuilder(WildfireRegSmsCodeFragment.class).a().c().putExtras(localBundle));
    this.h = false;
    this.i.stopShowingProgress();
  }

  private void S()
  {
    Uri.Builder localBuilder = Uri.parse("https://m.facebook.com/r.php").buildUpon();
    localBuilder.appendQueryParameter("locale", FBLocaleMapper.a(Locale.getDefault()));
    this.ad.b(new Intent("android.intent.action.VIEW", localBuilder.build()), p());
    a(PasswordCredentialsFragment.class);
    this.h = false;
    this.i.stopShowingProgress();
  }

  public static Bundle a(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("orca:authparam:firstname", paramString1);
    localBundle.putString("orca:authparam:lastname", paramString2);
    return localBundle;
  }

  private void a(ServiceException paramServiceException)
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
        localJsonNode = this.Z.readTree(localApiErrorResult.c());
        if (localJsonNode.get("phone") == null)
          continue;
        if (localJsonNode.get("phone").get("error_code").asInt() != 3128)
          continue;
        str = localJsonNode.get("phone").get("existing_uid").asText();
        if (!localJsonNode.get("phone").get("is_existing_user_partial").asBoolean())
          continue;
        BLog.c(b, "Error was caused by the phone number belonging to a partial account. False alarm.");
        this.Y.a(this.ae.b("already_wf_user").b("user_id", str));
        O();
        return;
      }
      catch (IOException localIOException)
      {
        JsonNode localJsonNode;
        String str;
        BLog.e(b, "Unable to parse error data! " + localIOException.getMessage());
        S();
        continue;
        this.Y.a(this.ae.b("already_fb_user").b("user_id", str));
        this.af.a(str, this.e);
        continue;
        this.Y.a(this.ae.b("manual_phone_number_invalid").b("phone_number", this.e).b("country_code", this.f).a("error_code", localJsonNode.get("phone").get("error_code").asInt()));
        ErrorDialogBuilder.a(n()).a(2131362339).b(localJsonNode.get("phone").get("error_body").asText()).a();
        this.i.stopShowingProgress();
        this.h = false;
        this.g = (1 + this.g);
        if (this.g < 3)
          continue;
        S();
        continue;
      }
      if (j == 2)
      {
        a(localApiErrorResult);
        continue;
      }
      if (j == 368)
      {
        this.Y.a(this.ae.b("sentry_block"));
        S();
        continue;
      }
      this.i.stopShowingProgress();
      this.h = false;
      ErrorDialogBuilder.a(n()).a(2131362339).a(paramServiceException).a();
    }
  }

  private void a(ApiErrorResult paramApiErrorResult)
  {
    this.i.stopShowingProgress();
    this.h = false;
    try
    {
      JsonNode localJsonNode2 = this.Z.readTree(paramApiErrorResult.c());
      localJsonNode1 = localJsonNode2;
      if (localJsonNode1 != null)
      {
        String str1 = localJsonNode1.get("error_title").asText();
        String str2 = localJsonNode1.get("error_message").asText();
        ErrorDialogBuilder.a(p()).a(str1).b(str2).a();
        BLog.e(b, str1 + ": " + str2);
        this.Y.a(this.ae.b("service_error").b("title", str1).b("message", str2));
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
    this.i.stopShowingProgress();
    this.h = false;
    BLog.e(b, "SMS request failed with error " + paramServiceException.getMessage());
    ApiErrorResult localApiErrorResult;
    int j;
    if (paramServiceException.a() == ErrorCode.API_ERROR)
    {
      localApiErrorResult = (ApiErrorResult)paramServiceException.b().h();
      j = localApiErrorResult.a();
      BLog.e(b, "API error code: " + j);
      if (j == 3308)
      {
        BLog.e(b, "We have already requested too many SMSes for this number. Continuing to confirmation code entry screen anyway.");
        R();
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
        this.Y.a(this.ae.b("sentry_block"));
        S();
        continue;
      }
      this.Y.a(this.ae.b("manual_sms_failure").b("phone_number", this.e).b("country_code", this.f).a("error_code", j));
      ErrorDialogBuilder.a(p()).a(2131362339).a(paramServiceException).a();
    }
  }

  public void D()
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.af.a());
    localLinkedList.add(this.ag);
    localLinkedList.add(this.ah);
    a((Fragment[])localLinkedList.toArray(new OrcaServiceFragment[0]));
    super.D();
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = a(WildfireRegPhoneNumberFragmentControl.class, paramViewGroup);
    this.i = ((WildfireRegPhoneNumberFragment.ViewControl)localView);
    return localView;
  }

  public String a()
  {
    return "wildfire_reg_phone_number";
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    FbInjector localFbInjector = Q();
    this.Y = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    this.Z = ((ObjectMapper)localFbInjector.a(ObjectMapper.class));
    this.aa = ((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class));
    this.ab = localFbInjector.b(String.class, PhoneIsoCountryCode.class);
    this.ac = ((PhoneNumberUtil)localFbInjector.a(PhoneNumberUtil.class));
    this.ad = ((SecureContextHelper)localFbInjector.a(SecureContextHelper.class));
    this.ae = ((WildfireAnalyticsUtils)localFbInjector.a(WildfireAnalyticsUtils.class));
    this.af = ((WildfireUserLookupOperation)localFbInjector.a(WildfireUserLookupOperation.class));
    this.af.a(this);
    this.af.a(this);
    this.c = m().getString("orca:authparam:firstname");
    this.d = m().getString("orca:authparam:lastname");
    this.f = ((String)this.ab.b());
    if (paramBundle != null)
    {
      this.e = paramBundle.getString("phoneNumber");
      this.f = paramBundle.getString("countryCode");
      this.g = paramBundle.getInt("numVerificationFails", 0);
      this.h = paramBundle.getBoolean("isProgressIndicatorShowing", false);
    }
    this.ag = OrcaServiceFragment.a(this, "regDataVerificationOperation");
    this.ag.a(new WildfireRegPhoneNumberFragment.1(this));
    this.ah = OrcaServiceFragment.a(this, "requestSmsOperation");
    this.ah.a(new WildfireRegPhoneNumberFragment.2(this));
  }

  public void a(String paramString)
  {
    this.f = paramString;
  }

  public void b(String paramString1, String paramString2)
  {
    if (this.ag.b() != OrcaServiceOperation.State.INIT);
    while (true)
    {
      return;
      try
      {
        Phonenumber.PhoneNumber localPhoneNumber = this.ac.parse(paramString1, paramString2);
        this.e = this.ac.format(localPhoneNumber, PhoneNumberUtil.PhoneNumberFormat.E164);
        this.f = paramString2;
        Bundle localBundle = new Bundle();
        localBundle.putString("phone", this.e);
        localBundle.putString("countryCode", this.f);
        this.i.beginShowingProgress();
        this.h = true;
        this.ag.a("verify_reg_data", localBundle);
        this.Y.a(this.ae.b("manual_phone_number_entered").b("phone_number", this.e).b("country_code", this.f));
      }
      catch (NumberParseException localNumberParseException)
      {
        ErrorDialogBuilder.a(p()).a(2131362339).b(2131362365).a();
      }
    }
  }

  public void c(Intent paramIntent)
  {
    b(paramIntent);
    this.h = false;
    this.i.stopShowingProgress();
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.i.setCountryCode(this.f);
    if (this.h)
      this.i.beginShowingProgress();
  }

  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    paramBundle.putString("phoneNumber", this.e);
    paramBundle.putString("countryCode", this.f);
    paramBundle.putInt("numVerificationFails", this.g);
    paramBundle.putBoolean("isProgressIndicatorShowing", this.h);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.WildfireRegPhoneNumberFragment
 * JD-Core Version:    0.6.0
 */