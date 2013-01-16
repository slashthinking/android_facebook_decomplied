package com.facebook.katana.webview;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.webkit.WebView;
import android.webkit.WebView.HitTestResult;
import com.facebook.orca.common.ui.widgets.refreshablelistview.RefreshableListViewState;

class RefreshableFacewebWebViewContainer$3
  implements View.OnLongClickListener
{
  public boolean onLongClick(View paramView)
  {
    if (RefreshableFacewebWebViewContainer.a(this.a) != RefreshableListViewState.NORMAL);
    while (true)
    {
      return true;
      WebView.HitTestResult localHitTestResult = ((WebView)paramView).getHitTestResult();
      if (localHitTestResult.getType() != 7)
        continue;
      String str = localHitTestResult.getExtra();
      if (!str.startsWith("http"))
        continue;
      RefreshableFacewebWebViewContainer.a(this.a, str);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.RefreshableFacewebWebViewContainer.3
 * JD-Core Version:    0.6.0
 */