package com.facebook.katana.webview;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebView;
import com.facebook.base.BuildConstants;
import com.facebook.common.util.Log;
import com.facebook.katana.activity.apps.OpenWebViewHandler;
import com.facebook.katana.activity.apps.PostMessageHandler;
import java.util.Map;

class FacebookWebView$FacebookWebViewClient extends FacebookAuthentication.AuthWebViewClient
{
  public FacebookWebView$FacebookWebViewClient(Context paramContext, FacebookAuthentication.Callback paramCallback)
  {
    super(paramContext, paramCallback);
  }

  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if (!(paramWebView instanceof FacebookWebView));
    while (true)
    {
      return;
      FacebookWebView localFacebookWebView = (FacebookWebView)paramWebView;
      localFacebookWebView.b("function() {window.__fbNative = {};window.__fbNative.nativeReady = true;" + PostMessageHandler.a() + OpenWebViewHandler.a() + "}();", null);
      localFacebookWebView.a("fbNativeReady", null);
    }
  }

  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    if (BuildConstants.a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url ").append(paramString2).append(" failed (code: ").append(paramInt).append("; description: ").append(paramString1).append(")");
      Log.d(FacebookWebView.a(), localStringBuilder.toString());
    }
  }

  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    int i;
    if (super.shouldOverrideUrlLoading(paramWebView, paramString))
      i = 1;
    while (true)
    {
      return i;
      if (!(paramWebView instanceof FacebookWebView))
      {
        i = 0;
        continue;
      }
      FacebookWebView localFacebookWebView = (FacebookWebView)paramWebView;
      Uri localUri = Uri.parse(paramString);
      String str = localUri.getScheme();
      FacebookWebView.UrlHandler localUrlHandler = (FacebookWebView.UrlHandler)localFacebookWebView.a.get(str);
      if (localUrlHandler != null)
      {
        localUrlHandler.a(this.a, (FacebookWebView)paramWebView, localUri);
        i = 1;
        continue;
      }
      i = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacebookWebView.FacebookWebViewClient
 * JD-Core Version:    0.6.0
 */