package com.facebook.katana.webview;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.net.http.SslError;
import android.preference.PreferenceManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.base.BuildConstants;
import com.facebook.common.util.Log;
import com.facebook.common.util.NetAccessLogger;
import com.facebook.common.util.Toaster;
import com.facebook.katana.SettingsActivity;
import com.facebook.katana.model.FacebookAffiliation;
import com.facebook.katana.util.StringUtils;

public class FacebookAuthentication$AuthWebViewClient extends WebViewClient
{
  protected Context a;
  protected FacebookAuthentication.Callback b;

  public FacebookAuthentication$AuthWebViewClient(Context paramContext, FacebookAuthentication.Callback paramCallback)
  {
    this.a = paramContext;
    this.b = paramCallback;
  }

  public void onLoadResource(WebView paramWebView, String paramString)
  {
    FacebookAuthentication.a(this.a).a(paramString);
  }

  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    if (!PreferenceManager.getDefaultSharedPreferences(this.a).getBoolean(SettingsActivity.c, true))
      paramSslErrorHandler.proceed();
    while (true)
    {
      return;
      if ((BuildConstants.a()) || (FacebookAffiliation.c()))
      {
        Toaster.a(this.a, 2131362916);
        continue;
      }
      Log.e(FacebookAuthentication.a, this.a.getString(2131362915));
    }
  }

  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    Uri localUri = Uri.parse(paramString);
    String str1 = localUri.getScheme();
    String str2 = localUri.getHost();
    String str3 = localUri.getPath();
    if (((StringUtils.a(str1, "http")) || (StringUtils.a(str1, "https"))) && (str2.endsWith(".facebook.com")) && (str3.equals("/login.php")))
      FacebookAuthentication.a(this.a, this.b);
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacebookAuthentication.AuthWebViewClient
 * JD-Core Version:    0.6.0
 */