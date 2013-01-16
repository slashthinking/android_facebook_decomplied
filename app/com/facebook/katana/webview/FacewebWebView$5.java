package com.facebook.katana.webview;

import android.content.Context;

class FacewebWebView$5
  implements FacebookWebView.NativeCallHandler
{
  public void a(Context paramContext, FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    String str = paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "version");
    if (str != null)
      MFacewebVersion.a(paramContext, str);
    FacewebComponentsStoreCache.b(paramContext);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacewebWebView.5
 * JD-Core Version:    0.6.0
 */