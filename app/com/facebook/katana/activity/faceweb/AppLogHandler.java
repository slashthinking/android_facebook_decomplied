package com.facebook.katana.activity.faceweb;

import android.content.Context;
import com.facebook.common.util.Log;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeCallHandler;
import com.facebook.katana.webview.FacewebPalCall;

class AppLogHandler
  implements FacebookWebView.NativeCallHandler
{
  private final String a;

  public AppLogHandler(String paramString)
  {
    this.a = paramString;
  }

  public void a(Context paramContext, FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    Log.d(this.a, paramFacewebPalCall.a(null, "msg", ""));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.AppLogHandler
 * JD-Core Version:    0.6.0
 */