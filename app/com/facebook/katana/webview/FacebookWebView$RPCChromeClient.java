package com.facebook.katana.webview;

import android.net.Uri;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import java.util.Map;

public class FacebookWebView$RPCChromeClient extends BaseWebView.BaseWebChromeClient
{
  protected FacebookWebView$RPCChromeClient(FacebookWebView paramFacebookWebView)
  {
  }

  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    int i;
    if (!(paramWebView instanceof FacebookWebView))
      i = 0;
    while (true)
    {
      return i;
      FacebookWebView localFacebookWebView = (FacebookWebView)paramWebView;
      Uri localUri = Uri.parse(paramString2);
      FacebookWebView.UrlHandler localUrlHandler = (FacebookWebView.UrlHandler)localFacebookWebView.a.get(localUri.getScheme());
      if (localUrlHandler != null)
      {
        localUrlHandler.a(this.b.c, localFacebookWebView, localUri);
        paramJsPromptResult.cancel();
        i = 1;
        continue;
      }
      i = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacebookWebView.RPCChromeClient
 * JD-Core Version:    0.6.0
 */