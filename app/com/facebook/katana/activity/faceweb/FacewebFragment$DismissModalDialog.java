package com.facebook.katana.activity.faceweb;

import android.app.Activity;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.facebook.katana.features.composer.ComposerUserSettings;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeUICallHandler;
import com.facebook.katana.webview.FacewebPalCall;

public class FacewebFragment$DismissModalDialog extends FacebookWebView.NativeUICallHandler
{
  public FacewebFragment$DismissModalDialog(FacewebFragment paramFacewebFragment, Handler paramHandler)
  {
    super(paramHandler);
  }

  public void a(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    FragmentActivity localFragmentActivity = this.a.n();
    if (localFragmentActivity == null);
    while (true)
    {
      return;
      ComposerUserSettings.a(localFragmentActivity, "composer_tour_completed", "1");
      ComposerUserSettings.a(localFragmentActivity, "composer_share_location");
      localFragmentActivity.onBackPressed();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.DismissModalDialog
 * JD-Core Version:    0.6.0
 */