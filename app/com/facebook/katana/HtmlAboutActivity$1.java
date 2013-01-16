package com.facebook.katana;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.IOException;

class HtmlAboutActivity$1 extends WebViewClient
{
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    int i;
    if (!paramString.equals("/license"))
    {
      this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
      i = 1;
    }
    while (true)
    {
      return i;
      try
      {
        paramWebView.loadDataWithBaseURL(null, this.a.c(2131099650), "text/txt", "utf-8", null);
        this.a.findViewById(2131297008).setVisibility(8);
        i = 1;
      }
      catch (IOException localIOException)
      {
        i = 0;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.HtmlAboutActivity.1
 * JD-Core Version:    0.6.0
 */