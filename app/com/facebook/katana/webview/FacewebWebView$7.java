package com.facebook.katana.webview;

import com.facebook.katana.binding.AppSession.LogoutReason;
import com.facebook.katana.features.faceweb.FacewebComponentsStore;

class FacewebWebView$7
  implements FacewebComponentsStoreCache.Listener
{
  public void a(FacewebComponentsStore paramFacewebComponentsStore)
  {
  }

  public void a(FacewebComponentsStoreCache.LoadError paramLoadError, String paramString)
  {
    if (paramLoadError == FacewebComponentsStoreCache.LoadError.NETWORK_ERROR)
      this.a.a(FacewebWebView.FacewebErrorType.AUTHENTICATION_NETWORK_ERROR, AppSession.LogoutReason.FACEWEB_NONSPECIFIC);
    while (true)
    {
      return;
      this.a.a(FacewebWebView.FacewebErrorType.AUTHENTICATION_ERROR, AppSession.LogoutReason.FORCED_FACEWEB_COMPONENTS_STORE_ERROR);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacewebWebView.7
 * JD-Core Version:    0.6.0
 */