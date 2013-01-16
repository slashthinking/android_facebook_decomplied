package com.facebook.katana.webview;

import android.os.Handler;
import com.facebook.common.util.Log;
import com.facebook.katana.Constants.URL;

class FacewebWebView$BroadcastScriptHandler extends FacebookWebView.NativeUICallHandler
{
  public FacewebWebView$BroadcastScriptHandler(FacewebWebView paramFacewebWebView, Handler paramHandler)
  {
    super(paramHandler);
  }

  public void a(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    String str = paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "script");
    int i = Integer.valueOf(paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "delay")).intValue();
    if (!Constants.URL.a(paramFacebookWebView.getUrl()))
      Log.a(FacewebWebView.k(), "Page with Non-facebook URL (" + paramFacebookWebView.getUrl() + ") attempting to invoke broadcastScript");
    while (true)
    {
      return;
      this.c.postDelayed(new FacewebWebView.BroadcastScriptHandler.1(this, str), i);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacewebWebView.BroadcastScriptHandler
 * JD-Core Version:    0.6.0
 */