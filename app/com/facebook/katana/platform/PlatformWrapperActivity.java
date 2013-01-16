package com.facebook.katana.platform;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.util.ErrorReporting;
import com.facebook.katana.LoginActivity;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSession.LoginStatus;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.orca.annotations.AuthNotRequired;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;

@AuthNotRequired
public class PlatformWrapperActivity extends BaseFacebookActivity
  implements AbstractPlatformActionExecutor.CompletionCallback
{
  private static final Class<?> n = PlatformWrapperActivity.class;
  private String o;
  private AbstractPlatformActionExecutor p;
  private AuthDialogActionExecutorFactory q;
  private ShareDialogActionExecutorFactory r;
  private ComposeDialogActionExecutorFactory s;

  private AbstractPlatformActionExecutor a(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("com.facebook.platform.protocol.PROTOCOL_ACTION");
    Object localObject;
    if ("com.facebook.platform.action.request.LOGIN_DIALOG".equals(str))
      localObject = b(paramIntent);
    while (true)
    {
      if (localObject != null)
        ((AbstractPlatformActionExecutor)localObject).a(this);
      return localObject;
      if ("com.facebook.platform.action.request.SHARE_DIALOG".equals(str))
      {
        localObject = c(paramIntent);
        continue;
      }
      if ("com.facebook.platform.action.request.COMPOSE_DIALOG".equals(str))
      {
        localObject = d(paramIntent);
        continue;
      }
      a(str);
      localObject = null;
    }
  }

  private void a(String paramString)
  {
    if (paramString == null);
    for (String str = StringLocaleUtil.a("Expected non-null '%s' extra.", new Object[] { "com.facebook.platform.protocol.PROTOCOL_ACTION" }); ; str = StringLocaleUtil.a("Unrecognized '%s' extra: '%s'.", new Object[] { "com.facebook.platform.protocol.PROTOCOL_ACTION", paramString }))
    {
      b(str);
      return;
    }
  }

  private void a(boolean paramBoolean, Intent paramIntent)
  {
    if (paramBoolean);
    for (int i = -1; ; i = 0)
    {
      setResult(i, paramIntent);
      finish();
      return;
    }
  }

  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle == null)
      paramBundle = new Bundle();
    paramBundle.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", 20121101);
    String str = f(getIntent().getExtras());
    if (str != null)
      paramBundle.putString("com.facebook.platform.protocol.PROTOCOL_ACTION", str);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    a(paramBoolean, localIntent);
  }

  private AuthDialogActionExecutor b(Intent paramIntent)
  {
    AuthDialogActionExecutor localAuthDialogActionExecutor = null;
    PlatformActivityLoginDialogRequest localPlatformActivityLoginDialogRequest = new PlatformActivityLoginDialogRequest();
    if (Boolean.FALSE.equals(Gatekeeper.a(this, "fbandroid_native_gdp")))
      a(false, new PlatformActivityErrorIntentBuilder("com.facebook.platform.action.reply.LOGIN_DIALOG", "ServiceDisabled", "Please fall back to the previous version of the SSO Login Dialog").a());
    while (true)
    {
      return localAuthDialogActionExecutor;
      if (localPlatformActivityLoginDialogRequest.c(paramIntent))
      {
        localAuthDialogActionExecutor = this.q.a(localPlatformActivityLoginDialogRequest, this.o);
        continue;
      }
      a(false, localPlatformActivityLoginDialogRequest.e());
      localAuthDialogActionExecutor = null;
    }
  }

  private void b(String paramString)
  {
    e(AuthorizeAppResults.a("ProtocolError", paramString));
  }

  private ShareDialogActionExecutor c(Intent paramIntent)
  {
    PlatformActivityShareDialogRequest localPlatformActivityShareDialogRequest = new PlatformActivityShareDialogRequest();
    if (localPlatformActivityShareDialogRequest.c(paramIntent));
    for (ShareDialogActionExecutor localShareDialogActionExecutor = this.r.a(this, localPlatformActivityShareDialogRequest); ; localShareDialogActionExecutor = null)
    {
      return localShareDialogActionExecutor;
      a(false, localPlatformActivityShareDialogRequest.e());
    }
  }

  private ComposeDialogActionExecutor d(Intent paramIntent)
  {
    PlatformActivityComposeDialogRequest localPlatformActivityComposeDialogRequest = new PlatformActivityComposeDialogRequest();
    if (localPlatformActivityComposeDialogRequest.c(paramIntent));
    for (ComposeDialogActionExecutor localComposeDialogActionExecutor = this.s.a(this, localPlatformActivityComposeDialogRequest); ; localComposeDialogActionExecutor = null)
    {
      return localComposeDialogActionExecutor;
      a(false, localPlatformActivityComposeDialogRequest.e());
    }
  }

  private String f(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("com.facebook.platform.protocol.PROTOCOL_ACTION");
    String str2;
    if ("com.facebook.platform.action.request.LOGIN_DIALOG".equals(str1))
      str2 = "com.facebook.platform.action.reply.LOGIN_DIALOG";
    while (true)
    {
      return str2;
      if ("com.facebook.platform.action.request.COMPOSE_DIALOG".equals(str1))
      {
        str2 = "com.facebook.platform.action.reply.COMPOSE_DIALOG";
        continue;
      }
      if ("com.facebook.platform.action.request.SHARE_DIALOG".equals(str1))
      {
        str2 = "com.facebook.platform.action.reply.SHARE_DIALOG";
        continue;
      }
      str2 = null;
    }
  }

  private String i()
  {
    String str1 = getCallingPackage();
    if ((getIntent().getExtras() != null) && (("com.facebook.katana".equals(str1)) || ("com.facebook.wakizashi".equals(str1))));
    for (String str2 = getIntent().getExtras().getString("calling_package_key"); ; str2 = null)
      return str2;
  }

  private boolean j()
  {
    AppSession localAppSession = AppSession.a(this, false);
    int i = 0;
    if (localAppSession != null)
    {
      AppSession.LoginStatus localLoginStatus1 = localAppSession.i();
      AppSession.LoginStatus localLoginStatus2 = AppSession.LoginStatus.STATUS_LOGGED_IN;
      i = 0;
      if (localLoginStatus1 == localLoginStatus2)
        i = 1;
    }
    return i;
  }

  protected void a(Bundle paramBundle)
  {
    BLog.b(n, "onActivityCreate " + paramBundle);
    super.a(paramBundle);
    if (paramBundle != null)
    {
      this.o = paramBundle.getString("calling_package");
      FbInjector localFbInjector = FbInjector.a(this);
      this.q = ((AuthDialogActionExecutorFactory)localFbInjector.a(AuthDialogActionExecutorFactory.class));
      this.r = ((ShareDialogActionExecutorFactory)localFbInjector.a(ShareDialogActionExecutorFactory.class));
      this.s = ((ComposeDialogActionExecutorFactory)localFbInjector.a(ComposeDialogActionExecutorFactory.class));
      if (this.o != null)
        break label125;
      ErrorReporting.a("sso", "getCallingPackage==null; finish() called. see t1118578", true);
      b("The calling package was null");
    }
    while (true)
    {
      return;
      this.o = i();
      break;
      label125: this.p = a(getIntent());
      if (this.p == null)
        continue;
      BLog.b(n, "Starting UI or Login screen");
      if (!j())
      {
        LoginActivity.c(this);
        continue;
      }
      this.p.a(paramBundle);
    }
  }

  public void b(Bundle paramBundle)
  {
    d(paramBundle);
  }

  public void c(Bundle paramBundle)
  {
    e(paramBundle);
  }

  protected void d(Bundle paramBundle)
  {
    a(true, paramBundle);
  }

  protected void e(Bundle paramBundle)
  {
    a(false, paramBundle);
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    BLog.b(n, "onActivityResult");
    switch (paramInt1)
    {
    default:
      this.p.a(paramInt1, paramInt2, paramIntent);
    case 2210:
    }
    while (true)
    {
      return;
      if (paramInt2 == 0)
      {
        e(AuthorizeAppResults.a("User canceled login"));
        continue;
      }
      this.p.a(null);
    }
  }

  protected void onDestroy()
  {
    BLog.b(n, "onDestroy");
    super.onDestroy();
    if (this.p != null)
      this.p.D();
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    BLog.b(n, "onSaveInstanceState");
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("calling_package", this.o);
    if (this.p != null)
      this.p.e(paramBundle);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.PlatformWrapperActivity
 * JD-Core Version:    0.6.0
 */