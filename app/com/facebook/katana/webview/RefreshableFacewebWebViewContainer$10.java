package com.facebook.katana.webview;

import android.view.animation.Animation;
import com.facebook.orca.common.ui.widgets.refreshablelistview.RefreshableListViewState;
import com.facebook.widget.listeners.BaseAnimationListener;

class RefreshableFacewebWebViewContainer$10 extends BaseAnimationListener
{
  public void onAnimationEnd(Animation paramAnimation)
  {
    RefreshableFacewebWebViewContainer.a(this.a, RefreshableListViewState.NORMAL);
    this.a.a(RefreshableFacewebWebViewContainer.ContentState.CONTENT_STATE_WEBVIEW);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.RefreshableFacewebWebViewContainer.10
 * JD-Core Version:    0.6.0
 */