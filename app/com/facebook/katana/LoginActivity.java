package com.facebook.katana;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.analytics.InteractionLogger;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.analytics.performance.PerformanceLogger.MarkerConfig;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.common.util.Log;
import com.facebook.common.util.Toaster;
import com.facebook.content.SecureContextHelper;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.katana.activity.FacebookActivity;
import com.facebook.katana.activity.FacebookActivityDelegate;
import com.facebook.katana.activity.FbFragmentChromeActivity;
import com.facebook.katana.activity.NewUserRegistrationActivity;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.activity.findfriends.HowFound;
import com.facebook.katana.activity.findfriends.StepIntroActivity;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.platform.FacebookAuthenticationService;
import com.facebook.katana.provider.KeyValueManager;
import com.facebook.katana.provider.UserValuesManager;
import com.facebook.katana.security.MalwareDetector;
import com.facebook.katana.settings.AppLoggedOutSettingsManager;
import com.facebook.katana.util.ApplicationUtils;
import com.facebook.katana.util.DeviceContactpoints;
import com.facebook.katana.util.FB4AErrorReporting;
import com.facebook.katana.util.PlatformUtils;
import com.facebook.katana.util.RingtoneUtils;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.util.Utils;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities;
import com.facebook.katana.view.FacebookProgressCircleView;
import com.facebook.katana.view.LoggedOutWebViewActivity;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.annotations.AuthNotRequired;
import com.facebook.orca.app.AppInitLock;
import com.facebook.orca.common.util.SecureHashUtil;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.inject.FbInjector;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

@AuthNotRequired
public class LoginActivity extends FbFragmentActivity
  implements View.OnClickListener, AnalyticsActivity, NotNewNavEnabled
{
  private static final Class<?> n = LoginActivity.class;
  private FacebookProgressCircleView A;
  private long B;
  private int C = 0;
  private boolean D = true;
  private boolean E;
  private boolean F;
  private boolean G = false;
  private boolean H = false;
  private boolean I = false;
  private PerformanceLogger J;
  private boolean K = false;
  private EditText L;
  private EditText M;
  private EditText N;
  private boolean O = false;
  private final Handler P = new Handler();
  private String Q;
  private List<Intent> R = null;
  private final Runnable S = new LoginActivity.11(this);
  private AppSession o;
  private AppSessionListener p;
  private String q;
  private String r;
  private String s;
  private String t;
  private String u;
  private boolean v;
  private boolean w;
  private boolean x;
  private boolean y;
  private boolean z = false;

  public static Intent a(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, LoginActivity.class);
    localIntent.putExtra("calling_intent", paramActivity.getIntent());
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.addFlags(67108864);
    return localIntent;
  }

  private String a(String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    Object[] arrayOfObject1;
    String str1;
    label37: label54: Object[] arrayOfObject2;
    if (paramString1 != null)
    {
      arrayOfObject1 = new Object[3];
      if (paramInt == 0)
        break label181;
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = Integer.valueOf(paramInt);
      str1 = StringLocaleUtil.a("[%d]", arrayOfObject3);
      arrayOfObject1[0] = str1;
      if ((paramString2 == null) || (paramString2.length() <= 0))
        break label188;
      arrayOfObject1[1] = paramString2;
      if (paramException == null)
        break label194;
      arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = paramException.getClass().getName();
    }
    label181: label188: label194: for (String str2 = StringLocaleUtil.a("[%s]", arrayOfObject2); ; str2 = "")
    {
      arrayOfObject1[2] = str2;
      String str3 = StringLocaleUtil.a("%s %s %s", arrayOfObject1);
      if (str3.length() > 0)
      {
        if (paramString1.length() > 0)
          paramString1 = paramString1 + "\n";
        paramString1 = paramString1 + StringLocaleUtil.a("(%s)", new Object[] { str3 });
      }
      return paramString1;
      paramString1 = "";
      break;
      str1 = "";
      break label37;
      paramString2 = "";
      break label54;
    }
  }

  private void a(int paramInt, Dialog paramDialog)
  {
    switch (paramInt)
    {
    default:
    case 2:
    case 3:
    }
    while (true)
    {
      return;
      l();
      AlertDialog localAlertDialog2 = (AlertDialog)paramDialog;
      localAlertDialog2.setTitle(this.r);
      localAlertDialog2.setMessage(this.q);
      continue;
      l();
      AlertDialog localAlertDialog1 = (AlertDialog)paramDialog;
      localAlertDialog1.setTitle(this.r);
      localAlertDialog1.setMessage(this.q);
      localAlertDialog1.setButton(-1, this.t, new LoginActivity.9(this));
      localAlertDialog1.setButton(-2, this.u, new LoginActivity.10(this));
    }
  }

  private void a(Uri paramUri)
  {
    SecureContextHelper localSecureContextHelper = (SecureContextHelper)C().a(SecureContextHelper.class);
    if (((AppLoggedOutSettingsManager)FbInjector.a(this).a(AppLoggedOutSettingsManager.class)).b())
      localSecureContextHelper.a(new Intent(this, LoggedOutWebViewActivity.class).setData(paramUri), this);
    while (true)
    {
      return;
      localSecureContextHelper.b(new Intent("android.intent.action.VIEW", paramUri), this);
    }
  }

  private void a(EditText paramEditText)
  {
    paramEditText.setOnFocusChangeListener(new LoginActivity.6(this));
  }

  private void a(LoginActivity.LoginState paramLoginState)
  {
    String str1 = this.L.getText().toString();
    if (StringUtils.c(str1))
    {
      Utils.b(this);
      Toaster.a(this, 2131362999);
    }
    while (true)
    {
      return;
      String str2;
      if (paramLoginState == LoginActivity.LoginState.PASSWORD_ENTRY)
      {
        str2 = this.M.getText().toString();
        if (StringUtils.c(str2))
        {
          Utils.b(this);
          Toaster.a(this, 2131362994);
          continue;
        }
      }
      else
      {
        str2 = this.N.getText().toString();
        if (StringUtils.c(str2))
        {
          Utils.b(this);
          Toaster.a(this, 2131363002);
          continue;
        }
      }
      a(str1, str2, "password");
    }
  }

  private void a(String paramString1, String paramString2, String paramString3)
  {
    this.J.a("Login");
    this.o = new AppSession();
    this.o.a(this.p);
    this.Q = this.o.a(this, paramString1.toLowerCase(), paramString2, paramString3);
    Utils.b(this);
    findViewById(2131296669).setVisibility(4);
    findViewById(2131296674).setVisibility(4);
    b(false);
    this.A.setVisibility(0);
    this.B = SystemClock.elapsedRealtime();
    this.C = 0;
    this.D = false;
    this.E = false;
    this.F = false;
    this.P.postDelayed(this.S, 200L);
  }

  private boolean a(String paramString)
  {
    boolean bool1 = true;
    this.v = false;
    this.w = bool1;
    this.t = getString(2131361888);
    this.u = getString(2131362848);
    this.s = null;
    boolean bool2 = StringUtils.c(paramString);
    int i = 0;
    if (bool2)
      return i;
    while (true)
    {
      try
      {
        while (true)
        {
          JSONObject localJSONObject = new JSONObject(paramString);
          try
          {
            String str7 = localJSONObject.getString("error_title");
            String str8 = localJSONObject.getString("error_message");
            str2 = str8;
            str1 = str7;
          }
          catch (JSONException localJSONException2)
          {
            try
            {
              label92: String str6 = localJSONObject.getString("url");
              str3 = str6;
            }
            catch (JSONException localJSONException2)
            {
              try
              {
                while (true)
                {
                  String str2;
                  String str1;
                  String str3;
                  String str5 = localJSONObject.getString("machine_id");
                  str4 = str5;
                  if (!StringUtils.c(str3))
                    this.s = str3;
                  if ((StringUtils.c(str1)) || (StringUtils.c(str2)))
                    break label303;
                  this.r = str1;
                  this.q = str2;
                  try
                  {
                    while (true)
                    {
                      this.w = localJSONObject.getBoolean("finish_after_loading_url");
                      try
                      {
                        while (true)
                        {
                          label174: this.v = localJSONObject.getBoolean("start_internal_webview_from_url");
                          try
                          {
                            while (true)
                            {
                              label186: this.t = localJSONObject.getString("positive_button_string");
                              try
                              {
                                label198: this.u = localJSONObject.getString("negative_button_string");
                                label210: if ((!StringUtils.c(str4)) && (StringUtils.c(KeyValueManager.a(this, "machine_id", ""))))
                                  KeyValueManager.a(this, "machine_id", str4);
                                i = bool1;
                                break;
                                localJSONException1 = localJSONException1;
                                str1 = null;
                                str2 = null;
                                break label92;
                                localJSONException2 = localJSONException2;
                                str3 = null;
                              }
                              catch (JSONException localJSONException7)
                              {
                                break label210;
                              }
                            }
                          }
                          catch (JSONException localJSONException6)
                          {
                            break label198;
                          }
                        }
                      }
                      catch (JSONException localJSONException5)
                      {
                        break label186;
                      }
                    }
                  }
                  catch (JSONException localJSONException4)
                  {
                    break label174;
                  }
                }
              }
              catch (JSONException localJSONException3)
              {
                while (true)
                  String str4 = null;
              }
            }
          }
        }
      }
      catch (JSONException localJSONException8)
      {
        i = 0;
      }
      break;
      label303: bool1 = false;
    }
  }

  public static void b(Activity paramActivity)
  {
    Intent localIntent1 = new Intent(paramActivity, LoginActivity.class);
    Intent localIntent2;
    if (((paramActivity instanceof FacebookActivity)) && (((FacebookActivity)paramActivity).t().a()))
    {
      Log.c(n, "toLogin: skipping stale activity " + paramActivity);
      localIntent2 = localIntent1;
    }
    while (true)
    {
      paramActivity.startActivity(localIntent2);
      paramActivity.overridePendingTransition(0, 0);
      paramActivity.finish();
      return;
      if ((paramActivity instanceof FbFragmentChromeActivity))
      {
        ErrorReporting.a("intent_reuse_blacklist", "skipping blacklisted activity FbFragmentChromeActivity", true);
        localIntent2 = localIntent1;
        continue;
      }
      if (!(paramActivity instanceof LogoutActivity))
      {
        Log.c(n, "toLogin: preserving intent for activity " + paramActivity);
        localIntent2 = a(paramActivity);
        continue;
      }
      localIntent2 = localIntent1;
    }
  }

  private void b(boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = 0;
      if (paramBoolean)
        break label50;
      findViewById(2131296681).setVisibility(i);
      findViewById(2131296680).setVisibility(i);
      findViewById(2131296682).setVisibility(i);
    }
    while (true)
    {
      return;
      i = 8;
      break;
      label50: findViewById(2131296681).setVisibility(i);
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      if (localDisplayMetrics.widthPixels <= localDisplayMetrics.heightPixels)
      {
        findViewById(2131296680).setVisibility(0);
        findViewById(2131296682).setVisibility(8);
        continue;
      }
      findViewById(2131296680).setVisibility(8);
      findViewById(2131296682).setVisibility(0);
    }
  }

  public static void c(Activity paramActivity)
  {
    Intent localIntent = a(paramActivity);
    localIntent.putExtra("login_redirect", true);
    paramActivity.startActivityForResult(localIntent, 2210);
  }

  private void l()
  {
    FbErrorReporter localFbErrorReporter = (FbErrorReporter)FbInjector.a(this).a(FbErrorReporter.class);
    View localView1 = findViewById(2131296683);
    if (localView1 != null)
    {
      localView1.setVisibility(4);
      View localView2 = findViewById(2131296668);
      if (localView2 == null)
        break label98;
      localView2.setVisibility(0);
    }
    while (true)
    {
      return;
      localFbErrorReporter.a("LoginSplashIsNull", "Login splash is null in ensureLoginViewRootVisible, useful variables: " + this.r + " -- " + this.q, true);
      break;
      label98: localFbErrorReporter.a("LoginRootIsNull", "Login root is null in ensureLoginViewRootVisible, useful variables: " + this.r + " -- " + this.q, true);
    }
  }

  private void m()
  {
    SecureContextHelper localSecureContextHelper = (SecureContextHelper)C().a(SecureContextHelper.class);
    if (this.s != null)
    {
      if (this.v)
        break label63;
      localSecureContextHelper.b(new Intent("android.intent.action.VIEW").setData(Uri.parse(this.s)), this);
    }
    while (true)
    {
      if (this.w)
        finish();
      return;
      label63: localSecureContextHelper.a(new Intent(this, LoggedOutWebViewActivity.class).setData(Uri.parse(this.s)), this);
    }
  }

  private void n()
  {
    this.J.b("Login");
    FB4AErrorReporting.a(this, ((UniqueIdForDeviceHolder)FbInjector.a(this).a(UniqueIdForDeviceHolder.class)).b());
    if (getIntent().getBooleanExtra("login_redirect", false))
    {
      setResult(-1);
      finish();
      return;
    }
    boolean bool = getIntent().hasExtra("calling_intent");
    Object localObject = null;
    if (bool)
    {
      Intent localIntent = new Intent((Intent)getIntent().getParcelableExtra("calling_intent"));
      localIntent.setFlags(0xEFFFFFFF & localIntent.getFlags());
      localObject = localIntent;
    }
    if ((!this.x) && (Boolean.TRUE.equals(Gatekeeper.a(this, "new_android_ci_enabled"))) && (!KeyValueManager.a(this, "first_time_contact_import_displayed")))
    {
      KeyValueManager.a(this, "first_time_contact_import_displayed", Boolean.valueOf(true));
      localObject = new Intent(this, StepIntroActivity.class);
      HowFound.b("first_app_run");
    }
    while (true)
    {
      if (localObject == null)
        localObject = ApplicationUtils.a(this);
      String str = getIntent().getStringExtra("activity_launcher");
      if (str != null)
        ((Intent)localObject).putExtra("activity_launcher", str);
      startActivity((Intent)localObject);
      finish();
      break;
      if ((localObject != null) || (!Boolean.TRUE.equals(Gatekeeper.a(this, "android_sync_setup_flow_enabled"))) || (!PlatformUtils.a(this)) || (UserValuesManager.a(this)))
        continue;
      localObject = new Intent(this, SyncContactsSetupActivity.class);
      ((Intent)localObject).putExtra("add_account", this.x);
      if (!this.x)
        continue;
      FacebookAuthenticationService.a(getIntent(), (Intent)localObject);
      this.y = true;
    }
  }

  public String a()
  {
    return FB4A_AnalyticEntities.f;
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    FbInjector localFbInjector = FbInjector.a(this);
    this.J = ((PerformanceLogger)localFbInjector.a(PerformanceLogger.class));
    this.J.a(new PerformanceLogger.MarkerConfig("NNFWarmStart").a(new Class[] { LoginActivity.class, FbFragmentChromeActivity.class }));
    this.J.a(new PerformanceLogger.MarkerConfig("NNFFreshContentStart").a(new Class[] { LoginActivity.class, FbFragmentChromeActivity.class }));
    this.J.a(new PerformanceLogger.MarkerConfig("NNFPrefetchStart").a(new Class[] { LoginActivity.class, FbFragmentChromeActivity.class }));
    this.J.a(new PerformanceLogger.MarkerConfig("NNFWarmStartToNewsFeedFragmentCreate").a(new Class[] { LoginActivity.class, FbFragmentChromeActivity.class }));
    this.J.a("ActiveSession");
    AppInitLock localAppInitLock = (AppInitLock)localFbInjector.a(AppInitLock.class);
    String str1;
    String str2;
    String str4;
    String str3;
    if (localAppInitLock.c())
    {
      new LoginActivity.MalwareDetectorAsyncTask(this, (MalwareDetector)localFbInjector.a(MalwareDetector.class), this).execute(new Void[0]);
      this.x = getIntent().getBooleanExtra("add_account", false);
      str1 = getIntent().getStringExtra("reg_login_nonce");
      str2 = getIntent().getStringExtra("username");
      if (str2 != null)
        break label958;
      str4 = AppSession.a(this);
      str3 = null;
    }
    while (true)
    {
      while (true)
      {
        this.J.a("VersionUpgrade");
        VersionTasks.a(this).a();
        this.J.b("VersionUpgrade");
        AppSession localAppSession = AppSession.a(this, true);
        if (localAppSession != null);
        switch (LoginActivity.12.a[localAppSession.i().ordinal()])
        {
        default:
          label340: if (UserValuesManager.b(this))
            break;
        case 1:
        }
        try
        {
          String str5 = ((RingtoneUtils)FbInjector.a(this).a(RingtoneUtils.class)).a(this);
          if (str5 != null)
          {
            SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this).edit();
            localEditor.putString("ringtone", str5);
            localEditor.commit();
            UserValuesManager.b(this, true);
          }
          label408: if ((this.x) && (PlatformUtils.a(this)) && (FacebookAuthenticationService.a(this) > 0))
          {
            Toaster.a(this, 2131362974);
            finish();
          }
          while (true)
          {
            return;
            localAppInitLock.a(new LoginActivity.1(this, localFbInjector));
            break;
            if (this.x)
              break label340;
            j();
            this.J.b("ActiveSession");
            continue;
            this.J.c("ColdStart");
            this.J.c("NNFColdStart");
            this.J.c("NNFWarmStart");
            this.J.c("NNFFreshContentStart");
            this.J.c("NNFPrefetchStart");
            setContentView(2130903140);
            this.L = ((EditText)findViewById(2131296671));
            this.L.setTypeface(Typeface.DEFAULT);
            this.M = ((EditText)findViewById(2131296672));
            this.M.setTypeface(Typeface.DEFAULT);
            this.N = ((EditText)findViewById(2131296496));
            this.N.setTypeface(Typeface.DEFAULT);
            findViewById(2131296673).setOnClickListener(this);
            findViewById(2131296676).setOnClickListener(this);
            TextView localTextView = (TextView)findViewById(2131296681);
            localTextView.setOnClickListener(this);
            SpannableString localSpannableString = new SpannableString(getString(2131362997));
            localSpannableString.setSpan(new UnderlineSpan(), 0, localSpannableString.length(), 0);
            localTextView.setText(localSpannableString);
            findViewById(2131296680).setOnClickListener(this);
            findViewById(2131296682).setOnClickListener(this);
            if (str4 != null)
              this.L.setText(str4);
            if (paramBundle != null)
              this.q = paramBundle.getString("error_message");
            a(this.L);
            a(this.M);
            a(this.N);
            LoginActivity.2 local2 = new LoginActivity.2(this);
            this.M.setOnEditorActionListener(local2);
            this.N.setOnEditorActionListener(local2);
            this.p = new LoginActivity.LoginAppSessionListener(this, null);
            this.o = new AppSession();
            ((AppLoggedOutSettingsManager)FbInjector.a(this).a(AppLoggedOutSettingsManager.class)).a(this);
            LoginActivity.3 local3 = new LoginActivity.3(this);
            this.A = ((FacebookProgressCircleView)findViewById(2131296684));
            View localView1 = findViewById(2131296677);
            View localView2 = findViewById(2131296683);
            if ((!StringUtils.c(str4)) && (!StringUtils.c(str3)))
            {
              this.P.post(new LoginActivity.4(this, localView2));
              a(str4, str3, "app_registration_login_nonce");
              continue;
            }
            this.P.postDelayed(new LoginActivity.5(this, localView2, localView1, local3), 1000L);
          }
        }
        catch (IOException localIOException)
        {
          break label408;
        }
      }
      label958: str3 = str1;
      str4 = str2;
    }
  }

  public String i()
  {
    return null;
  }

  protected void j()
  {
    new InteractionLogger(getApplicationContext()).a();
  }

  protected void k()
  {
    Context localContext = getApplicationContext();
    TreeMap localTreeMap = new TreeMap();
    localTreeMap.put("prev_uid_hashed", AppSession.b(localContext));
    localTreeMap.put("curr_uid_hashed", SecureHashUtil.a(String.valueOf(this.o.b().userId)));
    localTreeMap.put("prev_user_login_time", Long.toString(AppSession.c(localContext)));
    localTreeMap.put("prev_user_logout_time", Long.toString(AppSession.d(localContext)));
    new InteractionLogger(localContext).a(localTreeMap);
    KeyValueManager.a(localContext, "last_login_time", Long.valueOf(System.currentTimeMillis()));
  }

  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    getWindow().setFormat(1);
  }

  public void onBackPressed()
  {
    if (this.O)
    {
      this.M.setText("");
      this.N.setText("");
      this.O = false;
      findViewById(2131296674).setVisibility(8);
      findViewById(2131296669).setVisibility(0);
      b(true);
      this.A.setVisibility(8);
      this.E = true;
    }
    while (true)
    {
      return;
      finish();
    }
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131296673)
      a(LoginActivity.LoginState.PASSWORD_ENTRY);
    while (true)
    {
      return;
      if (i == 2131296676)
      {
        a(LoginActivity.LoginState.LOGIN_APPROVALS_CODE_ENTRY);
        continue;
      }
      if (i == 2131296681)
      {
        if (((AppLoggedOutSettingsManager)FbInjector.a(this).a(AppLoggedOutSettingsManager.class)).a())
        {
          ((SecureContextHelper)C().a(SecureContextHelper.class)).a(new Intent(this, NewUserRegistrationActivity.class), this);
          continue;
        }
        Collection localCollection = DeviceContactpoints.a(getApplicationContext());
        a(Uri.parse(Constants.URL.b(this, ((AppLoggedOutSettingsManager)FbInjector.a(this).a(AppLoggedOutSettingsManager.class)).c())).buildUpon().appendQueryParameter("contactpoints", TextUtils.join(",", localCollection)).build());
        continue;
      }
      if ((i != 2131296680) && (i != 2131296682))
        continue;
      a(Uri.parse(Constants.URL.b(this, "help.php")));
    }
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    View localView = findViewById(2131296679);
    if (localView == null)
      return;
    if (localView.getVisibility() == 0);
    for (boolean bool = true; ; bool = false)
    {
      b(bool);
      break;
    }
  }

  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default:
      localObject = super.onCreateDialog(paramInt);
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return localObject;
      localObject = new ProgressDialog(this);
      ((ProgressDialog)localObject).setProgressStyle(0);
      ((ProgressDialog)localObject).setMessage(getText(2131362996));
      ((ProgressDialog)localObject).setIndeterminate(true);
      ((ProgressDialog)localObject).setCancelable(false);
      continue;
      localObject = AlertDialogs.a(this, this.r, 17301543, this.q, getString(2131361888), null, null, null, null, true);
      continue;
      localObject = AlertDialogs.a(this, this.r, 17301543, this.q, this.t, new LoginActivity.7(this), this.u, new LoginActivity.8(this), null, false);
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (this.A.getVisibility() == 0);
    for (boolean bool = true; ; bool = super.onCreateOptionsMenu(paramMenu))
      return bool;
  }

  public void onDestroy()
  {
    if ((isFinishing()) && (this.x) && (!this.y))
      FacebookAuthenticationService.a(getIntent(), 400, "User canceled");
    super.onDestroy();
  }

  public void onPause()
  {
    super.onPause();
    this.z = false;
    if (this.o != null)
      this.o.b(this.p);
  }

  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    a(paramInt, paramDialog);
    super.onPrepareDialog(paramInt, paramDialog);
  }

  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (this.A.getVisibility() == 0);
    for (boolean bool = true; ; bool = super.onPrepareOptionsMenu(paramMenu))
      return bool;
  }

  protected void onRestoreInstanceState(Bundle paramBundle)
  {
  }

  public void onResume()
  {
    super.onResume();
    this.z = true;
    View localView = findViewById(2131296670);
    if (localView != null)
      localView.requestFocus();
    this.o = AppSession.a(this, true);
    if (this.o != null)
      switch (LoginActivity.12.a[this.o.i().ordinal()])
      {
      default:
        removeDialog(1);
        this.o = null;
      case 1:
      case 2:
      }
    while (true)
    {
      return;
      this.F = true;
      if ((SystemClock.elapsedRealtime() - this.B < 60000L) && (!this.D))
      {
        this.o.a(this.p);
        this.P.post(this.S);
        continue;
      }
      if (this.x)
        continue;
      n();
      continue;
      this.o.a(this.p);
      this.P.post(this.S);
      continue;
      removeDialog(1);
    }
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.q != null)
      paramBundle.putString("error_message", this.q);
  }

  public boolean onSearchRequested()
  {
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.LoginActivity
 * JD-Core Version:    0.6.0
 */