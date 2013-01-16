package com.facebook.katana.activity.faceweb;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.facebook.katana.activity.media.CameraReviewActivity;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeUICallHandler;
import com.facebook.katana.webview.FacewebPalCall;
import com.facebook.katana.webview.FacewebWebView;

public class FacewebFragment$ShowVaultReviewHandler extends FacebookWebView.NativeUICallHandler
{
  public FacewebFragment$ShowVaultReviewHandler(FacewebFragment paramFacewebFragment, Handler paramHandler)
  {
    super(paramHandler);
  }

  public void a(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    long l1 = FacewebFragment.d(this.a).b().userId;
    Uri localUri = Uri.parse(paramFacewebPalCall.a(FacewebFragment.b(this.a).getMobilePage(), "imgurl"));
    long l2 = Long.parseLong(paramFacewebPalCall.a(FacewebFragment.b(this.a).getMobilePage(), "fbid"));
    Intent localIntent = CameraReviewActivity.a(paramFacebookWebView.getContext(), localUri, false, l1, l2);
    this.a.a(localIntent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.ShowVaultReviewHandler
 * JD-Core Version:    0.6.0
 */