package com.facebook.katana;

import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.platform.FacebookAuthenticationService;
import com.facebook.katana.view.FacebookProgressCircleView;

class LoginActivity$11
  implements Runnable
{
  public void run()
  {
    if ((!LoginActivity.h(this.a)) || (LoginActivity.i(this.a)));
    while (true)
    {
      return;
      long l = SystemClock.elapsedRealtime() - LoginActivity.j(this.a);
      if ((l < 60000L) && (!LoginActivity.k(this.a)))
      {
        int i = (int)(LoginActivity.l(this.a) + (100 - LoginActivity.l(this.a)) * (float)l / 60000.0F);
        LoginActivity.m(this.a).setProgress(i);
        LoginActivity.e(this.a).postDelayed(this, 200L);
        continue;
      }
      if (LoginActivity.n(this.a))
      {
        this.a.k();
        FacebookAuthenticationService.b(this.a, LoginActivity.o(this.a).b().username);
        LoginActivity.p(this.a);
        continue;
      }
      if (LoginActivity.o(this.a) != null)
      {
        LoginActivity.a(this.a, "");
        LoginActivity.o(this.a).b(LoginActivity.q(this.a));
      }
      LoginActivity.b(this.a, this.a.getString(2131362988));
      LoginActivity.c(this.a, this.a.getString(2131362991));
      LoginActivity.c(this.a, true);
      if (LoginActivity.h(this.a))
        this.a.showDialog(2);
      this.a.findViewById(2131296669).setVisibility(0);
      LoginActivity.b(this.a, true);
      LoginActivity.m(this.a).setVisibility(8);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.LoginActivity.11
 * JD-Core Version:    0.6.0
 */