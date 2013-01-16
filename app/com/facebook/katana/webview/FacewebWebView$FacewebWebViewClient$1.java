package com.facebook.katana.webview;

import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.orca.common.util.StringLocaleUtil;

class FacewebWebView$FacewebWebViewClient$1
  implements FacebookWebView.JsReturnHandler
{
  public void a(FacebookWebView paramFacebookWebView, String paramString1, boolean paramBoolean, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.length() <= 0) || (!paramString2.equals("1")))
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = FacewebWebView.k();
      String str = StringLocaleUtil.a("%s.onPageFinished-Error", arrayOfObject1);
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = this.a;
      ErrorReporting.a(str, StringLocaleUtil.a("url: %s", arrayOfObject2));
      this.b.c.l = FacewebWebView.PageState.PAGE_STATE_ERROR;
      this.b.c.m = FacewebWebView.FacewebErrorType.INVALID_HTML_ERROR;
      this.b.c.i.a(this.b.c.m, this.b.c.l);
      FacewebWebView.FacewebWebViewClient.a(this.b, this.a);
      Log.e(FacewebWebView.k(), "FacewebWebViewClient: onPageFinished: loaded bad html");
    }
    while (true)
    {
      return;
      FacewebWebView.FacewebWebViewClient.a(this.b, paramFacebookWebView, this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacewebWebView.FacewebWebViewClient.1
 * JD-Core Version:    0.6.0
 */