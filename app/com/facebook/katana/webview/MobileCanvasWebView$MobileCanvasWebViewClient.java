package com.facebook.katana.webview;

import android.content.Context;
import android.webkit.WebView;
import com.facebook.base.BuildConstants;
import com.facebook.common.util.Log;

public class MobileCanvasWebView$MobileCanvasWebViewClient extends FacebookWebView.FacebookWebViewClient
{
  public MobileCanvasWebView$MobileCanvasWebViewClient(MobileCanvasWebView paramMobileCanvasWebView, Context paramContext)
  {
    super(paramContext, new MobileCanvasWebView.MobileCanvasWebViewClient.1(paramMobileCanvasWebView));
  }

  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    ((MobileCanvasWebView)paramWebView).b(paramString);
  }

  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    if (BuildConstants.a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url ").append(paramString2).append(" failed (code: ").append(paramInt).append("; description: ").append(paramString1).append(")");
      Log.d(MobileCanvasWebView.b(), localStringBuilder.toString());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.MobileCanvasWebView.MobileCanvasWebViewClient
 * JD-Core Version:    0.6.0
 */