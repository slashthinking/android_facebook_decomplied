package com.facebook.katana.webview;

import android.content.Context;
import android.os.Handler;

public abstract class FacebookWebView$NativeUICallHandler
  implements FacebookWebView.NativeCallHandler
{
  protected Handler c;

  public FacebookWebView$NativeUICallHandler(Handler paramHandler)
  {
    this.c = paramHandler;
  }

  public final void a(Context paramContext, FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    b(paramFacebookWebView, paramFacewebPalCall);
    this.c.post(new FacebookWebView.NativeUICallHandler.1(this, paramFacebookWebView, paramFacewebPalCall));
  }

  public abstract void a(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall);

  public void b(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacebookWebView.NativeUICallHandler
 * JD-Core Version:    0.6.0
 */