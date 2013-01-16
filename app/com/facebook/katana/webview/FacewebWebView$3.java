package com.facebook.katana.webview;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebStorage;
import java.util.LinkedList;
import java.util.Queue;

class FacewebWebView$3
  implements FacebookWebView.NativeCallHandler
{
  protected Queue<Long> a = new LinkedList();

  public void a(Context paramContext, FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    monitorenter;
    try
    {
      if (paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "clearHttpCache") != null)
      {
        this.c.clearCache(true);
        FacewebComponentsStoreCache.a(this.c.c);
        this.a.clear();
      }
      if (paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "clearLocalStorage") != null)
      {
        WebStorage.getInstance().deleteAllData();
        this.c.clearCache(true);
      }
      if (paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "clearCookies") != null)
      {
        CookieManager.getInstance().removeAllCookie();
        FacebookAuthentication.a(this.b, this.c.h);
      }
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacewebWebView.3
 * JD-Core Version:    0.6.0
 */