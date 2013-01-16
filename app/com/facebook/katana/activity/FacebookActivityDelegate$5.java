package com.facebook.katana.activity;

import android.os.SystemClock;
import com.facebook.katana.binding.AppSession;

class FacebookActivityDelegate$5
  implements Runnable
{
  public void run()
  {
    AppSession localAppSession = AppSession.a(FacebookActivityDelegate.b(this.a), false);
    if ((localAppSession != null) && (SystemClock.elapsedRealtime() - FacebookActivityDelegate.u() >= 300000L) && (!localAppSession.f()))
      FacebookActivityDelegate.a(this.a, localAppSession.b(FacebookActivityDelegate.b(this.a), 0, false));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.FacebookActivityDelegate.5
 * JD-Core Version:    0.6.0
 */