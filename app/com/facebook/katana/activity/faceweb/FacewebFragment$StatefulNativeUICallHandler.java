package com.facebook.katana.activity.faceweb;

import android.content.Context;
import android.os.Handler;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeCallHandler;
import com.facebook.katana.webview.FacewebPalCall;

abstract class FacewebFragment$StatefulNativeUICallHandler
  implements FacebookWebView.NativeCallHandler
{
  protected Handler e;
  protected FacewebPalCall f = null;

  public FacewebFragment$StatefulNativeUICallHandler(Handler paramHandler)
  {
    this.e = paramHandler;
  }

  public void a(Context paramContext, FacebookWebView paramFacebookWebView)
  {
  }

  public final void a(Context paramContext, FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    this.f = paramFacewebPalCall;
    a(paramContext, paramFacebookWebView);
    this.e.post(new FacewebFragment.StatefulNativeUICallHandler.1(this, paramContext, paramFacebookWebView));
  }

  public abstract void b(Context paramContext, FacebookWebView paramFacebookWebView);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.StatefulNativeUICallHandler
 * JD-Core Version:    0.6.0
 */