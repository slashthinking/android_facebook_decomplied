package com.facebook.katana.activity.faceweb;

import android.os.Handler;
import android.support.v4.app.DialogFragment;
import com.facebook.katana.activity.faceweb.dialog.FeedFilterPickerDialogFragment;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeUICallHandler;
import com.facebook.katana.webview.FacewebPalCall;

public class FacewebFragment$FeedFilterPickerHandler extends FacebookWebView.NativeUICallHandler
{
  public FacewebFragment$FeedFilterPickerHandler(FacewebFragment paramFacewebFragment, Handler paramHandler)
  {
    super(paramHandler);
  }

  public void a(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    if (!this.a.u());
    while (true)
    {
      return;
      FeedFilterPickerDialogFragment.a(paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "options"), paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "dismiss_script"), Integer.parseInt(paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "selected_index"))).a(this.a.r(), "dialog");
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.FeedFilterPickerHandler
 * JD-Core Version:    0.6.0
 */