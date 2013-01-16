package com.facebook.katana.activity.faceweb;

import android.content.Context;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacewebPalCall;

class FacewebFragment$SetBookmarksMenuHiddenHandler extends FacewebFragment.StatefulNativeUICallHandler
{
  public FacewebFragment$SetBookmarksMenuHiddenHandler(FacewebFragment paramFacewebFragment, Handler paramHandler)
  {
    super(paramHandler);
  }

  public void a(Context paramContext, FacebookWebView paramFacebookWebView)
  {
    FacewebFragment localFacewebFragment = this.a;
    if (Boolean.valueOf(this.f.a(paramFacebookWebView.getMobilePage(), "hidden")).booleanValue());
    for (int i = 8; ; i = 0)
    {
      FacewebFragment.a(localFacewebFragment, i);
      return;
    }
  }

  public void b(Context paramContext, FacebookWebView paramFacebookWebView)
  {
    FragmentActivity localFragmentActivity = this.a.n();
    if (localFragmentActivity != null)
    {
      View localView = localFragmentActivity.findViewById(2131296299);
      if ((localView != null) && (localView.getVisibility() != FacewebFragment.p(this.a)))
        localView.setVisibility(FacewebFragment.p(this.a));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.SetBookmarksMenuHiddenHandler
 * JD-Core Version:    0.6.0
 */