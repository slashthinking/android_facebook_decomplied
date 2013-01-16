package com.facebook.katana.features.uberbar;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebView;
import android.webkit.WebView.HitTestResult;
import com.facebook.analytics.InteractionLogger;

class UberbarDelegate$4
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    UberbarDelegate.d(this.a);
    WebView.HitTestResult localHitTestResult;
    if (paramMotionEvent.getAction() == 0)
    {
      localHitTestResult = ((WebView)paramView).getHitTestResult();
      if (localHitTestResult != null)
        break label28;
    }
    while (true)
    {
      return false;
      label28: if (localHitTestResult.getType() != 7)
        continue;
      String str = localHitTestResult.getExtra();
      UberbarDelegate.e(this.a).a(str, "link", "SearchResults");
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.uberbar.UberbarDelegate.4
 * JD-Core Version:    0.6.0
 */