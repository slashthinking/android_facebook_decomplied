package com.facebook.katana.activity.faceweb;

import android.os.Bundle;
import android.os.Handler;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeUICallHandler;
import com.facebook.katana.webview.FacewebPalCall;

public class FacewebFragment$ShowStatusComposerHandler extends FacebookWebView.NativeUICallHandler
{
  public FacewebFragment$ShowStatusComposerHandler(FacewebFragment paramFacewebFragment, Handler paramHandler)
  {
    super(paramHandler);
  }

  public void a(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    Bundle localBundle = new Bundle();
    FacewebFragment.b(this.a, paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "callback"));
    long l = paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "target", -1L);
    if ((l != -1L) && (l != FacewebFragment.d(this.a).b().userId))
      localBundle.putLong("extra_fixed_audience_id", l);
    localBundle.putString("extra_composer_title_string", paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "title"));
    this.a.a(localBundle, paramFacebookWebView, paramFacewebPalCall);
    this.a.a(null, localBundle, Integer.valueOf(10));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.ShowStatusComposerHandler
 * JD-Core Version:    0.6.0
 */