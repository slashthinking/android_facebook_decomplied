package com.facebook.katana.orca;

import com.facebook.katana.activity.FacebookActivityDelegate;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.notify.OrcaForegroundActivityListener;

class FbandroidPushHandler$2
  implements Runnable
{
  public void run()
  {
    FacebookActivityDelegate localFacebookActivityDelegate = (FacebookActivityDelegate)FbInjector.a(FbandroidPushHandler.a(this.b).a()).a(FacebookActivityDelegate.class);
    if (this.a > 0)
      localFacebookActivityDelegate.g();
    localFacebookActivityDelegate.f();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidPushHandler.2
 * JD-Core Version:    0.6.0
 */