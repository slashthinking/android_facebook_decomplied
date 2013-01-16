package com.facebook.katana.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.WindowManager.BadTokenException;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.facebook.base.BuildConstants;
import com.facebook.common.util.Log;
import com.facebook.common.util.NetAccessLogger;
import com.facebook.katana.SettingsActivity;
import com.facebook.katana.model.FacebookAffiliation;

class PlatformDialogActivity$PlatformDialogWebViewClient extends WebViewClient
{
  private PlatformDialogActivity$PlatformDialogWebViewClient(PlatformDialogActivity paramPlatformDialogActivity)
  {
  }

  private void a(String paramString)
  {
    if (this.a.getIntent().getBooleanExtra("return_via_intent_url", false))
    {
      String str2 = this.a.getIntent().getStringExtra("client_id");
      String str3 = this.a.getIntent().getStringExtra("activity_id");
      if (str3 == null)
        str3 = "";
      StringBuilder localStringBuilder = new StringBuilder("fb").append(str2).append(str3).append("://authorize");
      String str4 = Uri.parse(paramString).getEncodedFragment();
      if (str4 != null)
        localStringBuilder.append("#").append(str4);
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(localStringBuilder.toString()));
      this.a.startActivity(localIntent);
    }
    while (true)
    {
      return;
      String str1 = paramString.replace("fbconnect", "http");
      Bundle localBundle = this.a.a(str1);
      this.a.c(localBundle);
    }
  }

  public void onLoadResource(WebView paramWebView, String paramString)
  {
    PlatformDialogActivity.b(this.a).a(paramString);
  }

  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    try
    {
      PlatformDialogActivity.a(this.a).dismiss();
      label16: return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label16;
    }
  }

  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    try
    {
      PlatformDialogActivity.a(this.a).show();
      label17: return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label17;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      break label17;
    }
  }

  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    Bundle localBundle = new Bundle();
    localBundle.putString("error", paramString1);
    localBundle.putInt("error_code", paramInt);
    localBundle.putString("failing_url", paramString2);
    this.a.d(localBundle);
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
        Toast.makeText(this.a, 2131362916, 1).show();
        continue;
      }
      Log.e(PlatformDialogActivity.m(), this.a.getString(2131362915));
    }
  }

  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    int i = 1;
    if (paramString.startsWith("fbconnect://success"))
      a(paramString);
    while (true)
    {
      return i;
      if (paramString.contains("touch"))
      {
        i = 0;
        continue;
      }
      this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.PlatformDialogActivity.PlatformDialogWebViewClient
 * JD-Core Version:    0.6.0
 */