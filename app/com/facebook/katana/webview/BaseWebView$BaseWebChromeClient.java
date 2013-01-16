package com.facebook.katana.webview;

import android.webkit.WebChromeClient;
import com.facebook.common.util.Log;

public class BaseWebView$BaseWebChromeClient extends WebChromeClient
{
  protected String a;

  public BaseWebView$BaseWebChromeClient()
  {
    this("console");
  }

  public BaseWebView$BaseWebChromeClient(String paramString)
  {
    this.a = paramString;
  }

  public void onConsoleMessage(String paramString1, int paramInt, String paramString2)
  {
    Log.d(this.a, paramString2 + ":" + paramInt + ": " + paramString1);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.BaseWebView.BaseWebChromeClient
 * JD-Core Version:    0.6.0
 */