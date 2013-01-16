package com.facebook.katana.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.common.util.Log;
import com.facebook.common.util.NetAccessLogger;
import com.facebook.katana.LoginActivity;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSession.LoginStatus;
import com.facebook.katana.util.FacebookPlatform;
import com.facebook.katana.util.URLQueryBuilder;
import com.facebook.orca.inject.FbInjector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

public abstract class PlatformDialogActivity extends BaseFacebookActivity
{
  protected static Locale n;
  private static final Class<?> p = PlatformDialogActivity.class;
  protected String o = null;
  private String q = null;
  private ProgressDialog r;
  private WebView s;
  private NetAccessLogger t;

  static
  {
    n = null;
  }

  private void a(Configuration paramConfiguration)
  {
    CookieSyncManager.createInstance(this);
    if (paramConfiguration != null);
    for (Locale localLocale = paramConfiguration.locale; ; localLocale = getResources().getConfiguration().locale)
    {
      if ((n == null) || (!localLocale.equals(n)))
      {
        n = (Locale)localLocale.clone();
        CookieManager.getInstance().setCookie("facebook.com", "locale=");
      }
      return;
    }
  }

  private void a(WebViewClient paramWebViewClient)
  {
    this.s = ((WebView)findViewById(2131297692));
    this.s.setVerticalScrollBarEnabled(false);
    this.s.setHorizontalScrollBarEnabled(false);
    this.s.setWebViewClient(paramWebViewClient);
    this.s.getSettings().setJavaScriptEnabled(true);
    a(null);
  }

  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    int i;
    if (paramBoolean)
    {
      i = -1;
      if (paramBundle != null)
        break label25;
      setResult(i);
    }
    while (true)
    {
      finish();
      return;
      i = 0;
      break;
      label25: Intent localIntent = new Intent();
      localIntent.putExtras(paramBundle);
      setResult(i, localIntent);
    }
  }

  protected Bundle a(String paramString)
  {
    try
    {
      URL localURL = new URL(paramString);
      localBundle = URLQueryBuilder.a(localURL.getQuery());
      localBundle.putAll(URLQueryBuilder.a(localURL.getRef()));
      return localBundle;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      while (true)
      {
        Log.a("PlatformDialogActivity", "Caught malformed URL: " + paramString);
        Bundle localBundle = new Bundle();
      }
    }
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.t = ((NetAccessLogger)C().a(NetAccessLogger.class));
    if (paramBundle != null)
    {
      this.q = paramBundle.getString("calling_package");
      if (!isFinishing())
        break label54;
    }
    while (true)
    {
      return;
      this.q = l();
      break;
      label54: setContentView(2130903498);
      this.r = new PlatformDialogActivity.PlatformDialogSpinner(this);
      a(new PlatformDialogActivity.PlatformDialogWebViewClient(this, null));
      i();
      if (this.o == null)
        Log.a("PlatformDialogActivity", "mUrl was not set in setupDialogURL(). Any class inheriting from PlatformDialogActivity MUST set mUrl in this method.");
      AppSession localAppSession = AppSession.a(this, false);
      if ((localAppSession == null) || (localAppSession.i() != AppSession.LoginStatus.STATUS_LOGGED_IN))
      {
        LoginActivity.c(this);
        continue;
      }
      k();
    }
  }

  protected void c(Bundle paramBundle)
  {
    a(true, paramBundle);
  }

  protected void d(Bundle paramBundle)
  {
    a(false, paramBundle);
  }

  protected abstract void i();

  protected String j()
  {
    return this.q;
  }

  protected void k()
  {
    if (AppSession.b(this, false) == null)
      d(null);
    while (true)
    {
      return;
      this.o = FacebookPlatform.a(this, this.o);
      this.s.loadUrl(this.o);
    }
  }

  protected String l()
  {
    String str1 = getCallingPackage();
    if ((getIntent().getExtras() != null) && (("com.facebook.katana".equals(str1)) || ("com.facebook.wakizashi".equals(str1))));
    for (String str2 = getIntent().getExtras().getString("calling_package_key"); ; str2 = null)
      return str2;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == 0)
      finish();
    switch (paramInt1)
    {
    default:
    case 2210:
    }
    while (true)
    {
      return;
      k();
    }
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("calling_package", this.q);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.PlatformDialogActivity
 * JD-Core Version:    0.6.0
 */