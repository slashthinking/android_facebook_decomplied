package com.facebook.katana.activity.faceweb;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.facebook.katana.webview.FacewebWebView;

class FacewebFragment$ShowTextPublisherHandler$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public void onGlobalLayout()
  {
    if (this.a.getHeight() < this.a.getRootView().getHeight() / 2)
    {
      FacewebFragment.b(this.b.d).pageDown(true);
      this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.ShowTextPublisherHandler.1
 * JD-Core Version:    0.6.0
 */