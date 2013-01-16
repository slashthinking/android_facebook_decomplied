package com.facebook.katana.activity.faceweb;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.facebook.common.util.Log;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeUICallHandler;
import com.facebook.katana.webview.FacewebPalCall;

public class FacewebFragment$CallTextCellHandler extends FacebookWebView.NativeUICallHandler
{
  private final String b;
  private final String d;

  public FacewebFragment$CallTextCellHandler(FacewebFragment paramFacewebFragment, Handler paramHandler, String paramString1, String paramString2)
  {
    super(paramHandler);
    this.b = paramString2;
    this.d = paramString1;
  }

  public void a(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    String str = paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "target");
    if ((str != null) && (str.length() > 0))
    {
      Uri localUri = Uri.parse(this.b + str);
      Intent localIntent = new Intent(this.d, localUri);
      this.a.a(localIntent);
    }
    while (true)
    {
      return;
      Log.a(this.a.Q(), "Empty phone number; text/call skipped.");
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.CallTextCellHandler
 * JD-Core Version:    0.6.0
 */