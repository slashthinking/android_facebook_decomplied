package com.facebook.katana.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebView;

class LoggedOutWebViewActivity$1
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    LoggedOutWebViewActivity.a(this.a).setVisibility(8);
    LoggedOutWebViewActivity.d(this.a).setVisibility(8);
    LoggedOutWebViewActivity.d(this.a).reload();
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.LoggedOutWebViewActivity.1
 * JD-Core Version:    0.6.0
 */