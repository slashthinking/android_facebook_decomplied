package com.facebook.katana.activity.faceweb;

import android.os.Handler;
import com.facebook.katana.util.Utils;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeUICallHandler;
import com.facebook.katana.webview.FacewebPalCall;

class FacewebFragment$HideSoftKeyboardHandler extends FacebookWebView.NativeUICallHandler
{
  public FacewebFragment$HideSoftKeyboardHandler(FacewebFragment paramFacewebFragment, Handler paramHandler)
  {
    super(paramHandler);
  }

  public void a(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    Utils.b(this.a.n());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.HideSoftKeyboardHandler
 * JD-Core Version:    0.6.0
 */