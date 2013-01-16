package com.facebook.katana;

import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

class LoginActivity$5
  implements Runnable
{
  public void run()
  {
    int i = (this.a.getHeight() - this.b.getHeight()) / 2;
    LoginActivity.d(this.d);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, i, 1, 0.0F);
    localTranslateAnimation.setDuration(500L);
    this.b.startAnimation(localTranslateAnimation);
    LoginActivity.e(this.d).postDelayed(this.c, 400L);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.LoginActivity.5
 * JD-Core Version:    0.6.0
 */