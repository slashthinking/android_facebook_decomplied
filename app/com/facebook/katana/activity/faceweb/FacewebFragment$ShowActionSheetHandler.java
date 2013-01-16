package com.facebook.katana.activity.faceweb;

import android.os.Handler;
import android.support.v4.app.DialogFragment;
import com.facebook.katana.activity.faceweb.dialog.ActionSheetDialogFragment;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeUICallHandler;
import com.facebook.katana.webview.FacewebPalCall;

public class FacewebFragment$ShowActionSheetHandler extends FacebookWebView.NativeUICallHandler
{
  public FacewebFragment$ShowActionSheetHandler(FacewebFragment paramFacewebFragment, Handler paramHandler)
  {
    super(paramHandler);
  }

  public void a(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    if (!this.a.u());
    while (true)
    {
      return;
      ActionSheetDialogFragment.a(paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "buttons"), "true".equals(paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "hide_cancel_button"))).a(this.a.r(), "dialog");
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.ShowActionSheetHandler
 * JD-Core Version:    0.6.0
 */