package com.facebook.katana.activity.faceweb;

import android.os.Handler;
import com.facebook.analytics.InteractionLogger;
import com.facebook.analytics.InteractionLogger.ContentFlags;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.activity.FacebookActivityDelegate;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeUICallHandler;
import com.facebook.katana.webview.FacewebPalCall;
import com.facebook.orca.activity.FbActivityUtils;

class FacewebFragment$UpdateNativeLoadingIndicator extends FacebookWebView.NativeUICallHandler
{
  public FacewebFragment$UpdateNativeLoadingIndicator(FacewebFragment paramFacewebFragment, Handler paramHandler)
  {
    super(paramHandler);
  }

  public void a(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    FacewebFragment.d(this.a, FacewebFragment.n(this.a));
    if (this.a.A() == null);
    BaseFacebookActivity localBaseFacebookActivity;
    do
    {
      return;
      localBaseFacebookActivity = this.a.P();
    }
    while (localBaseFacebookActivity == null);
    localBaseFacebookActivity.t().a(FacewebFragment.n(this.a));
    InteractionLogger localInteractionLogger = FacewebFragment.l(this.a);
    if (FacewebFragment.n(this.a));
    for (InteractionLogger.ContentFlags localContentFlags = InteractionLogger.ContentFlags.LOCAL_DATA; ; localContentFlags = InteractionLogger.ContentFlags.NETWORK_DATA)
    {
      localInteractionLogger.a(localContentFlags, this.a.Q(), FbActivityUtils.a(localBaseFacebookActivity));
      break;
    }
  }

  public void b(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    FacewebFragment.c(this.a, paramFacewebPalCall.a().equals("pageLoading"));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.UpdateNativeLoadingIndicator
 * JD-Core Version:    0.6.0
 */