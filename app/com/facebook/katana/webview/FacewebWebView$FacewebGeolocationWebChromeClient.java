package com.facebook.katana.webview;

import android.webkit.GeolocationPermissions.Callback;
import com.facebook.katana.Constants.URL;

public class FacewebWebView$FacewebGeolocationWebChromeClient extends FacebookWebView.RPCChromeClient
{
  protected FacewebWebView$FacewebGeolocationWebChromeClient(FacewebWebView paramFacewebWebView)
  {
    super(paramFacewebWebView);
  }

  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    super.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
    if (Constants.URL.a(paramString))
      paramCallback.invoke(paramString, true, true);
    while (true)
    {
      return;
      paramCallback.invoke(paramString, false, false);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacewebWebView.FacewebGeolocationWebChromeClient
 * JD-Core Version:    0.6.0
 */