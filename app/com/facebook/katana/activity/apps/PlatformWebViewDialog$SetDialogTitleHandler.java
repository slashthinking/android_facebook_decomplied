package com.facebook.katana.activity.apps;

import android.app.Dialog;
import android.os.Handler;
import android.widget.TextView;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeUICallHandler;
import com.facebook.katana.webview.FacewebPalCall;

public class PlatformWebViewDialog$SetDialogTitleHandler extends FacebookWebView.NativeUICallHandler
{
  private Dialog b;

  public PlatformWebViewDialog$SetDialogTitleHandler(PlatformWebViewDialog paramPlatformWebViewDialog, Dialog paramDialog, Handler paramHandler)
  {
    super(paramHandler);
    this.b = paramDialog;
  }

  public void a(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    ((TextView)this.b.findViewById(2131296686)).setText(paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "title", ""));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.apps.PlatformWebViewDialog.SetDialogTitleHandler
 * JD-Core Version:    0.6.0
 */