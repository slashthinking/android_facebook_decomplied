package com.facebook.katana.webview;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.util.Log;

public class FacebookJsBridge$UriHandler
  implements FacebookWebView.UrlHandler
{
  protected FacebookJsBridge$UriHandler(FacebookJsBridge paramFacebookJsBridge)
  {
  }

  public void a(Context paramContext, FacebookWebView paramFacebookWebView, Uri paramUri)
  {
    FacewebUriPalCall localFacewebUriPalCall = new FacewebUriPalCall(paramUri);
    if (!this.a.a(paramContext, paramFacebookWebView, localFacewebUriPalCall))
      Log.a(this.a.c, "PAL call " + localFacewebUriPalCall.a() + " not handled");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacebookJsBridge.UriHandler
 * JD-Core Version:    0.6.0
 */