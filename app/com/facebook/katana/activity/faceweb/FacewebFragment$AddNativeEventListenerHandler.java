package com.facebook.katana.activity.faceweb;

import android.os.Handler;
import com.facebook.common.util.Log;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeUICallHandler;
import com.facebook.katana.webview.FacewebPalCall;
import java.util.Map;
import java.util.Set;

public class FacewebFragment$AddNativeEventListenerHandler extends FacebookWebView.NativeUICallHandler
{
  public FacewebFragment$AddNativeEventListenerHandler(FacewebFragment paramFacewebFragment, Handler paramHandler)
  {
    super(paramHandler);
  }

  public void a(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    String str1 = paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "callback");
    String str2 = paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "event");
    if ((str2 == null) || (str1 == null))
      Log.a(this.a.Q(), "Could not register native event listener: event=" + str2 + " callback=" + str1);
    while (true)
    {
      return;
      if (!FacewebFragment.N().contains(str2))
      {
        Log.b(this.a.Q(), "Ignoring unknown event listener type " + str2);
        continue;
      }
      FacewebFragment.f(this.a).put(str2, str1);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.AddNativeEventListenerHandler
 * JD-Core Version:    0.6.0
 */