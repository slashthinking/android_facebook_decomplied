package com.facebook.katana.activity.faceweb;

import android.os.Handler;
import com.facebook.katana.IntentUriHandler;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeUICallHandler;
import com.facebook.katana.webview.FacewebPalCall;
import com.facebook.orca.common.util.StringLocaleUtil;

public class FacewebFragment$ShowMessageComposerHandler extends FacebookWebView.NativeUICallHandler
{
  public FacewebFragment$ShowMessageComposerHandler(FacewebFragment paramFacewebFragment, Handler paramHandler)
  {
    super(paramHandler);
  }

  public void a(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    String str = StringLocaleUtil.a("fb://messaging/compose/%s", new Object[] { Long.valueOf(FacewebFragment.a(paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "target"))) });
    IntentUriHandler.b(this.a.n(), str);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.ShowMessageComposerHandler
 * JD-Core Version:    0.6.0
 */