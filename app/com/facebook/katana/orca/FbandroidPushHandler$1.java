package com.facebook.katana.orca;

import android.app.Activity;
import com.facebook.katana.activity.FacebookActivityDelegate;
import com.facebook.orca.inject.FbInjector;

class FbandroidPushHandler$1
  implements Runnable
{
  public void run()
  {
    ((FacebookActivityDelegate)FbInjector.a(this.a).a(FacebookActivityDelegate.class)).f();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidPushHandler.1
 * JD-Core Version:    0.6.0
 */