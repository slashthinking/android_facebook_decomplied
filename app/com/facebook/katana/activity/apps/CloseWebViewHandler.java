package com.facebook.katana.activity.apps;

import android.app.Activity;
import android.os.Handler;
import com.facebook.debug.Assert;
import com.facebook.katana.activity.FacebookActivityDelegate;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeUICallHandler;
import com.facebook.katana.webview.FacewebPalCall;

public class CloseWebViewHandler extends FacebookWebView.NativeUICallHandler
{
  public CloseWebViewHandler(Handler paramHandler)
  {
    super(paramHandler);
  }

  public void a(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    Assert.a(FacebookActivityDelegate.a);
    FacebookActivityDelegate.a.dismissDialog(684737812);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.apps.CloseWebViewHandler
 * JD-Core Version:    0.6.0
 */