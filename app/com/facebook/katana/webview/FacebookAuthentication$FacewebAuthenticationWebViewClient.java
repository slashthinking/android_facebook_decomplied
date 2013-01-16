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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FacebookAuthentication$FacewebAuthenticationWebViewClient extends WebViewClient
{
  protected final Context a;
  protected final String b;

  public FacebookAuthentication$FacewebAuthenticationWebViewClient(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.b = Uri.parse(paramString).getPath();
  }

  public void onLoadResource(WebView paramWebView, String paramString)
  {
    FacebookAuthentication.a(this.a).a(paramString);
  }

  public void onPageFinished(WebView paramWebView, String paramString)
  {
    int i = 0;
    if (paramString != null)
    {
      boolean bool = FacebookAuthentication.a(paramString, this.b);
      i = 0;
      if (bool)
      {
        Log.e(FacebookAuthentication.a, "authenticated -> true");
        FacebookAuthentication.b = true;
        i = 1;
      }
    }
    monitorenter;
    while (true)
    {
      FacebookAuthentication.Callback localCallback;
      try
      {
        FacebookAuthentication.c = false;
        Set localSet = FacebookAuthentication.d;
        FacebookAuthentication.d = new HashSet();
        monitorexit;
        Iterator localIterator = localSet.iterator();
        if (!localIterator.hasNext())
          break;
        localCallback = (FacebookAuthentication.Callback)localIterator.next();
        if (i != 0)
        {
          localCallback.a();
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      localCallback.b();
    }
    FacebookAuthentication.a().destroy();
    FacebookAuthentication.a(null);
  }

  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    Log.e(FacebookAuthentication.a, "authentication error: " + paramString1);
    monitorenter;
    try
    {
      FacebookAuthentication.c = false;
      Set localSet = FacebookAuthentication.d;
      FacebookAuthentication.d = new HashSet();
      monitorexit;
      Iterator localIterator = localSet.iterator();
      while (localIterator.hasNext())
        ((FacebookAuthentication.Callback)localIterator.next()).c();
    }
    finally
    {
      monitorexit;
    }
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
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacebookAuthentication.FacewebAuthenticationWebViewClient
 * JD-Core Version:    0.6.0
 */