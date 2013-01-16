package com.facebook.katana.webview;

public enum RefreshableFacewebWebViewContainer$ContentState
{
  static
  {
    CONTENT_STATE_LOADING = new ContentState("CONTENT_STATE_LOADING", 2);
    CONTENT_STATE_ERROR = new ContentState("CONTENT_STATE_ERROR", 3);
    ContentState[] arrayOfContentState = new ContentState[4];
    arrayOfContentState[0] = CONTENT_STATE_WEBVIEW;
    arrayOfContentState[1] = CONTENT_STATE_WEBVIEW_SNAPSHOT;
    arrayOfContentState[2] = CONTENT_STATE_LOADING;
    arrayOfContentState[3] = CONTENT_STATE_ERROR;
    $VALUES = arrayOfContentState;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.RefreshableFacewebWebViewContainer.ContentState
 * JD-Core Version:    0.6.0
 */