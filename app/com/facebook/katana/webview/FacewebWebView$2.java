package com.facebook.katana.webview;

import com.facebook.katana.binding.AppSession.LogoutReason;

class FacewebWebView$2
  implements FacebookAuthentication.Callback
{
  public void a()
  {
    this.a.c();
  }

  public void b()
  {
    this.a.a(FacewebWebView.FacewebErrorType.AUTHENTICATION_ERROR, AppSession.LogoutReason.FORCED_FACEWEB_AUTHENTICATION_FAILED);
  }

  public void c()
  {
    this.a.a(FacewebWebView.FacewebErrorType.AUTHENTICATION_NETWORK_ERROR, AppSession.LogoutReason.FACEWEB_NONSPECIFIC);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacewebWebView.2
 * JD-Core Version:    0.6.0
 */