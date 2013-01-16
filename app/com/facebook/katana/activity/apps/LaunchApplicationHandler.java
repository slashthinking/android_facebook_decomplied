package com.facebook.katana.activity.apps;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.facebook.debug.Assert;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeCallHandler;
import com.facebook.katana.webview.FacewebPalCall;
import com.facebook.katana.webview.FacewebUriPalCall;

public class LaunchApplicationHandler
  implements FacebookWebView.NativeCallHandler
{
  private Handler a;

  public LaunchApplicationHandler(Handler paramHandler)
  {
    this.a = paramHandler;
  }

  public final void a(Context paramContext, FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    Assert.b(paramFacewebPalCall instanceof FacewebUriPalCall);
    if (!(paramFacewebPalCall instanceof FacewebUriPalCall));
    while (true)
    {
      return;
      Uri localUri = ((FacewebUriPalCall)paramFacewebPalCall).b();
      this.a.post(new LaunchApplicationHandler.1(this, paramContext, localUri));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.apps.LaunchApplicationHandler
 * JD-Core Version:    0.6.0
 */