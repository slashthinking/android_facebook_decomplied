package com.facebook.katana.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.WindowManager.BadTokenException;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.common.util.NetAccessLogger;
import com.facebook.katana.LoginActivity;
import com.facebook.katana.SettingsActivity;
import com.facebook.katana.UriAuthHandler;
import com.facebook.katana.util.StringUtils;

class LoggedOutWebViewActivity$LoggedOutWebViewClient extends WebViewClient
{
  private LoggedOutWebViewActivity$LoggedOutWebViewClient(LoggedOutWebViewActivity paramLoggedOutWebViewActivity)
  {
  }

  private void a()
  {
    try
    {
      LoggedOutWebViewActivity.e(this.a).show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      while (true)
        ErrorReporting.a(LoggedOutWebViewActivity.i(), "failed to show spinner, bad token", localBadTokenException);
    }
    catch (IllegalStateException localIllegalStateException)
    {
      while (true)
        ErrorReporting.a(LoggedOutWebViewActivity.i(), "failed to show spinner, bad state", localIllegalStateException);
    }
  }

  public void onLoadResource(WebView paramWebView, String paramString)
  {
    LoggedOutWebViewActivity.f(this.a).a(paramString);
  }

  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if (Log.a(LoggedOutWebViewActivity.i(), 3))
      Log.e(LoggedOutWebViewActivity.i(), "loaded url: " + paramString);
    paramWebView.loadUrl("javascript:fbLoggedOutWebViewIsErrorPage.setFailing(typeof JX == 'undefined')");
  }

  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    a();
  }

  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    ErrorReporting.a(LoggedOutWebViewActivity.i(), "failure loading. url=" + paramString2 + " error=" + paramString1);
    LoggedOutWebViewActivity.c(this.a);
    LoggedOutWebViewActivity.a(this.a).setVisibility(0);
  }

  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
    if (!PreferenceManager.getDefaultSharedPreferences(this.a).getBoolean(SettingsActivity.c, true))
      paramSslErrorHandler.proceed();
    while (true)
    {
      return;
      ErrorReporting.a(LoggedOutWebViewActivity.i(), "onReceivedSslError:" + paramSslError.toString());
      LoggedOutWebViewActivity.c(this.a);
      LoggedOutWebViewActivity.a(this.a).setVisibility(0);
    }
  }

  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    int i = 1;
    Uri localUri = Uri.parse(paramString);
    String str1 = localUri.getScheme();
    String str2 = localUri.getHost();
    String str3 = localUri.getPath();
    if (StringUtils.a("fblogin", str1))
    {
      this.a.startActivity(new Intent(this.a, UriAuthHandler.class).setData(localUri));
      this.a.finish();
    }
    while (true)
    {
      return i;
      if (StringUtils.a("fbredirect", str1))
      {
        String str4 = localUri.getQueryParameter("uri");
        this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str4)));
        this.a.finish();
        continue;
      }
      if (((!StringUtils.a(str1, "http")) && (!StringUtils.a(str1, "https"))) || (!str2.endsWith(".facebook.com")))
      {
        this.a.startActivity(new Intent("android.intent.action.VIEW", localUri));
        continue;
      }
      if ((StringUtils.a(str3, "/")) || (StringUtils.a(str3, "/login.php")))
      {
        this.a.startActivity(new Intent(this.a, LoginActivity.class));
        continue;
      }
      i = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.LoggedOutWebViewActivity.LoggedOutWebViewClient
 * JD-Core Version:    0.6.0
 */