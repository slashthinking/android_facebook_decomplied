package com.facebook.katana.webview;

import android.os.Handler;

class RefreshableFacewebWebViewContainer$4
  implements FacewebWebView.FacewebWebViewListener
{
  public void a(FacewebWebView.FacewebErrorType paramFacewebErrorType, FacewebWebView.PageState paramPageState)
  {
    if (!RefreshableFacewebWebViewContainer.b(this.a))
    {
      RefreshableFacewebWebViewContainer.4.1 local1 = new RefreshableFacewebWebViewContainer.4.1(this);
      RefreshableFacewebWebViewContainer.d(this.a).removeCallbacks(local1);
      RefreshableFacewebWebViewContainer.d(this.a).postDelayed(local1, 200L);
      RefreshableFacewebWebViewContainer.a(this.a, true);
    }
    while (true)
    {
      return;
      RefreshableFacewebWebViewContainer.a(this.a, paramFacewebErrorType);
      this.a.a(RefreshableFacewebWebViewContainer.ContentState.CONTENT_STATE_ERROR);
    }
  }

  public void a(FacewebWebView.PageState paramPageState)
  {
    if (paramPageState != FacewebWebView.PageState.PAGE_STATE_SUCCESS)
      this.a.a(RefreshableFacewebWebViewContainer.ContentState.CONTENT_STATE_LOADING);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.RefreshableFacewebWebViewContainer.4
 * JD-Core Version:    0.6.0
 */