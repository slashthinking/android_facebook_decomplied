package com.facebook.katana.webview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class RefreshableFacewebWebViewContainer$5
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!paramView.hasFocus())
      paramView.requestFocus();
    return this.a.a(paramMotionEvent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.RefreshableFacewebWebViewContainer.5
 * JD-Core Version:    0.6.0
 */