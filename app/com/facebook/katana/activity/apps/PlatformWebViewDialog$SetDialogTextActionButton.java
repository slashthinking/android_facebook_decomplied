package com.facebook.katana.activity.apps;

import android.app.Dialog;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeUICallHandler;
import com.facebook.katana.webview.FacewebPalCall;

public class PlatformWebViewDialog$SetDialogTextActionButton extends FacebookWebView.NativeUICallHandler
{
  private Dialog b;
  private String d;

  public PlatformWebViewDialog$SetDialogTextActionButton(PlatformWebViewDialog paramPlatformWebViewDialog, Dialog paramDialog, Handler paramHandler)
  {
    super(paramHandler);
    this.b = paramDialog;
  }

  public void a(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    Button localButton = (Button)this.b.findViewById(2131296341);
    this.d = paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "script");
    String str = paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "title");
    if (StringUtils.c(str))
      localButton.setVisibility(8);
    while (true)
    {
      localButton.setOnClickListener(new PlatformWebViewDialog.SetDialogTextActionButton.DialogActionButtonHandler(this, paramFacebookWebView));
      return;
      localButton.setText(str);
      localButton.setVisibility(0);
      this.b.findViewById(2131296343).setVisibility(0);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.apps.PlatformWebViewDialog.SetDialogTextActionButton
 * JD-Core Version:    0.6.0
 */