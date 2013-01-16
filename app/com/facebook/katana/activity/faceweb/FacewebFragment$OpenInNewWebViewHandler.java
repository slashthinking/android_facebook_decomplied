package com.facebook.katana.activity.faceweb;

import android.os.Handler;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeUICallHandler;
import com.facebook.katana.webview.FacewebPalCall;

public class FacewebFragment$OpenInNewWebViewHandler extends FacebookWebView.NativeUICallHandler
{
  public FacewebFragment$OpenInNewWebViewHandler(FacewebFragment paramFacewebFragment, Handler paramHandler)
  {
    super(paramHandler);
  }

  public void a(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    String str = paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "url");
    if (!StringUtils.c(str))
      this.a.b(str);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.OpenInNewWebViewHandler
 * JD-Core Version:    0.6.0
 */