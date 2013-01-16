package com.facebook.katana.webview;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.preference.PreferenceManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.base.BuildConstants;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.IntentUriHandler;
import com.facebook.katana.SettingsActivity;
import com.facebook.katana.util.StringUtils;
import com.facebook.orca.common.util.StringLocaleUtil;

public class FacewebWebView$FacewebWebViewClient extends FacebookWebView.FacebookWebViewClient
{
  public FacewebWebView$FacewebWebViewClient(FacewebWebView paramFacewebWebView, Context paramContext, FacebookAuthentication.Callback paramCallback)
  {
    super(paramContext, paramCallback);
  }

  private void a()
  {
    String str1 = this.c.getMobilePage();
    String str2 = null;
    if (str1 != null)
      str2 = str1.split("\\?")[0];
    this.c.e.b("LaunchFromPushNotification:" + str2, str1);
    this.c.e.b("LaunchFromJewelNotification:" + str2, str1);
  }

  private void a(WebView paramWebView, String paramString)
  {
    this.c.l = FacewebWebView.PageState.PAGE_STATE_SUCCESS;
    this.c.m = null;
    FacewebWebView.a((FacewebWebView)paramWebView);
  }

  private void a(String paramString)
  {
    this.c.e.c("ColdStart");
    String str = StringUtils.a(paramString);
    if (str != null)
    {
      this.c.e.c("FacewebPageNetworkLoad:" + str);
      this.c.e.c("FacewebPageRPCLoadCompleted:" + str);
    }
  }

  public void onLoadResource(WebView paramWebView, String paramString)
  {
    if ((BuildConstants.a()) && (paramString.startsWith("http://")))
      ErrorReporting.a("Webview", "Webview attempted to load a resource over http: " + paramWebView.getUrl() + ":" + paramString);
  }

  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if ((FacewebWebView.d(this.c)) && (FacewebWebView.e(this.c)));
    while (true)
    {
      return;
      super.onPageFinished(paramWebView, paramString);
      a();
      if (this.c.l != FacewebWebView.PageState.PAGE_STATE_ERROR)
        break;
      this.c.i.a(this.c.m, this.c.l);
      a(paramString);
    }
    if ((paramString != null) && (Constants.URL.c(paramString)))
      this.c.a("(function(){if (window.FW_ENABLED) { return '1'; }; return null;})()", new FacewebWebView.FacewebWebViewClient.1(this, paramString));
    while (true)
    {
      String str = StringUtils.a(paramString);
      if (str == null)
        break;
      this.c.e.b("FacewebPageNetworkLoad:" + str);
      break;
      a(paramWebView, paramString);
    }
  }

  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    this.c.i.a(this.c.l);
  }

  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    this.c.l = FacewebWebView.PageState.PAGE_STATE_ERROR;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = FacewebWebView.k();
    arrayOfObject[1] = Integer.valueOf(paramInt);
    ErrorReporting.a(StringLocaleUtil.a("%s.onReceivedError-%d", arrayOfObject), StringLocaleUtil.a("url: %s description: %s", new Object[] { paramString2, paramString1 }));
    switch (paramInt)
    {
    default:
      this.c.m = FacewebWebView.FacewebErrorType.SITE_ERROR;
    case -14:
    case -13:
    case -12:
    case -9:
    case -7:
    case -4:
    case -15:
    case -8:
    case -6:
    case -5:
    case -2:
    case -11:
    case -10:
    case -3:
    }
    while (true)
    {
      Log.e(FacewebWebView.k(), "FacewebWebViewClient: onReceivedError:" + paramInt + ":" + paramString2 + ":" + paramString1);
      return;
      this.c.m = FacewebWebView.FacewebErrorType.SITE_ERROR;
      continue;
      this.c.m = FacewebWebView.FacewebErrorType.CONNECTION_ERROR;
      continue;
      this.c.m = FacewebWebView.FacewebErrorType.SSL_ERROR;
    }
  }

  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    if ((FacewebWebView.d(this.c)) && (FacewebWebView.e(this.c)));
    while (true)
    {
      return;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = FacewebWebView.k();
      String str = StringLocaleUtil.a("%s.onReceivedSSLError", arrayOfObject1);
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = this.c.getMobilePage();
      ErrorReporting.a(str, StringLocaleUtil.a("url: %s", arrayOfObject2));
      if (!PreferenceManager.getDefaultSharedPreferences(this.a).getBoolean(SettingsActivity.c, true))
      {
        paramSslErrorHandler.proceed();
        continue;
      }
      super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
      this.c.l = FacewebWebView.PageState.PAGE_STATE_ERROR;
      this.c.m = FacewebWebView.FacewebErrorType.SSL_ERROR;
      this.c.i.a(this.c.m, this.c.l);
      a(paramWebView.getUrl());
      Log.e(FacewebWebView.k(), "FacewebWebViewClient: onReceivedSslError:" + paramSslError.toString());
    }
  }

  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    boolean bool = true;
    if ((FacewebWebView.d(this.c)) && (FacewebWebView.e(this.c)));
    while (true)
    {
      return bool;
      if (super.shouldOverrideUrlLoading(paramWebView, paramString))
      {
        if ((!FacewebWebView.d(this.c)) || (paramString == null) || (!paramString.startsWith("fbrpc://facebook/nativethirdparty")))
          continue;
        FacewebWebView.a(this.c, bool);
        continue;
      }
      Uri localUri = Uri.parse(paramString);
      String str1 = localUri.getScheme();
      String str2 = localUri.getHost();
      String str3 = localUri.getPath();
      if ((this.c.l != FacewebWebView.PageState.PAGE_STATE_SUCCESS) && (("http".equalsIgnoreCase(str1)) || ("https".equalsIgnoreCase(str1))) && (str2 != null) && (str2.toLowerCase().endsWith(".facebook.com")) && (!"/l.php".equals(str3)))
      {
        bool = false;
        continue;
      }
      if (IntentUriHandler.a(this.a, paramString) != null)
      {
        IntentUriHandler.b(this.a, paramString);
        continue;
      }
      Intent localIntent = new Intent("android.intent.action.VIEW", localUri);
      localIntent.setFlags(524288);
      try
      {
        this.a.startActivity(localIntent);
        if (!FacewebWebView.d(this.c))
          continue;
        FacewebWebView.a(this.c, true);
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacewebWebView.FacewebWebViewClient
 * JD-Core Version:    0.6.0
 */