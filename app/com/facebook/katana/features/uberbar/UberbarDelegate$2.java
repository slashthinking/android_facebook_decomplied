package com.facebook.katana.features.uberbar;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.katana.webview.FacewebWebView;

class UberbarDelegate$2
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    UberbarDelegate.c(this.a).a("/search/uberbar", true);
    UberbarDelegate.a(this.a, false);
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.uberbar.UberbarDelegate.2
 * JD-Core Version:    0.6.0
 */