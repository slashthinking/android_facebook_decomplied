package com.facebook.katana;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.facebook.katana.activity.faceweb.FacewebFragment;
import com.facebook.katana.webview.FacewebWebView;

class AppCenterMobileCanvasActivity$MobileCanvasFragment extends FacewebFragment
{
  private void a(long paramLong)
  {
    new Handler().postDelayed(new AppCenterMobileCanvasActivity.MobileCanvasFragment.1(this), paramLong);
  }

  public void B()
  {
    super.B();
    FacewebWebView localFacewebWebView = M();
    if (localFacewebWebView != null)
      localFacewebWebView.setShouldCloseOnNavigatingAway(true);
  }

  public void C()
  {
    super.C();
    FacewebWebView localFacewebWebView = M();
    if ((localFacewebWebView != null) && (localFacewebWebView.j()))
      a(3000L);
  }

  public void g()
  {
    super.g();
    FacewebWebView localFacewebWebView = M();
    if ((localFacewebWebView != null) && (localFacewebWebView.j()))
      n().finish();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.AppCenterMobileCanvasActivity.MobileCanvasFragment
 * JD-Core Version:    0.6.0
 */