package com.facebook.katana.activity.faceweb;

import android.os.Handler;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeUICallHandler;
import com.facebook.katana.webview.FacewebPalCall;

public class FacewebFragment$ShowFeedCommentComposerHandler extends FacebookWebView.NativeUICallHandler
{
  public FacewebFragment$ShowFeedCommentComposerHandler(FacewebFragment paramFacewebFragment, Handler paramHandler)
  {
    super(paramHandler);
  }

  public void a(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    FacewebFragment.a(this.a, paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "post_id"));
    FacewebFragment.b(this.a, paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "callback"));
    this.a.P().a(null, Integer.valueOf(30));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.ShowFeedCommentComposerHandler
 * JD-Core Version:    0.6.0
 */