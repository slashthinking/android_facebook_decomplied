package com.facebook.katana.activity.faceweb;

import android.os.Bundle;
import android.os.Handler;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeUICallHandler;
import com.facebook.katana.webview.FacewebPalCall;

public class FacewebFragment$ShowCheckinComposerHandler extends FacebookWebView.NativeUICallHandler
{
  public FacewebFragment$ShowCheckinComposerHandler(FacewebFragment paramFacewebFragment, Handler paramHandler)
  {
    super(paramHandler);
  }

  public void a(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    FacewebFragment.b(this.a, paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "callback"));
    long l = FacewebFragment.a(paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "target"));
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("extra_is_checkin", true);
    this.a.a(null, localBundle, Integer.valueOf(10), 0, l);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.ShowCheckinComposerHandler
 * JD-Core Version:    0.6.0
 */