package com.facebook.katana.activity.composer;

import android.view.View;
import android.view.animation.Animation;
import com.facebook.widget.listeners.BaseAnimationListener;
import java.util.concurrent.Callable;

class ComposerActivity$3 extends BaseAnimationListener
{
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setVisibility(8);
    if (this.b != null);
    try
    {
      this.b.call();
      label26: return;
    }
    catch (Exception localException)
    {
      break label26;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerActivity.3
 * JD-Core Version:    0.6.0
 */