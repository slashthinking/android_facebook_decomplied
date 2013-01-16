package com.facebook.katana.activity.faceweb;

import android.app.Activity;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeUICallHandler;
import com.facebook.katana.webview.FacewebPalCall;

public class FacewebFragment$CloseAndBackHandler extends FacebookWebView.NativeUICallHandler
{
  private boolean b;

  public FacewebFragment$CloseAndBackHandler(FacewebFragment paramFacewebFragment, Handler paramHandler, boolean paramBoolean)
  {
    super(paramHandler);
    this.b = paramBoolean;
  }

  public void a(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    FragmentActivity localFragmentActivity = this.a.n();
    if (localFragmentActivity != null)
    {
      if (!this.b)
        break label24;
      localFragmentActivity.onBackPressed();
    }
    while (true)
    {
      return;
      label24: localFragmentActivity.finish();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.CloseAndBackHandler
 * JD-Core Version:    0.6.0
 */