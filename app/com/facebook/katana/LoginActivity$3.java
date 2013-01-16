package com.facebook.katana;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

class LoginActivity$3
  implements Runnable
{
  public void run()
  {
    View localView1 = this.a.findViewById(2131296669);
    View localView2 = this.a.findViewById(2131296679);
    localView1.setVisibility(0);
    LoginActivity.b(this.a, true);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(100L);
    localView1.startAnimation(localAlphaAnimation);
    localView2.startAnimation(localAlphaAnimation);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.LoginActivity.3
 * JD-Core Version:    0.6.0
 */