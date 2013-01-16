package com.facebook.katana.features.uberbar;

import android.content.Context;
import android.os.Handler;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeCallHandler;
import com.facebook.katana.webview.FacewebPalCall;

class UberbarDelegate$SearchHandler
  implements FacebookWebView.NativeCallHandler
{
  static
  {
    if (!UberbarDelegate.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      a = bool;
      return;
    }
  }

  private UberbarDelegate$SearchHandler(UberbarDelegate paramUberbarDelegate)
  {
  }

  public void a(Context paramContext, FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    if ((!a) && (!paramFacewebPalCall.a().equals("ubersearchReady")))
      throw new AssertionError();
    new Handler().post(new UberbarDelegate.SearchHandler.1(this));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.uberbar.UberbarDelegate.SearchHandler
 * JD-Core Version:    0.6.0
 */