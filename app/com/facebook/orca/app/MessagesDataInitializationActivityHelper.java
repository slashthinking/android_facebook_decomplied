package com.facebook.orca.app;

import android.app.Activity;
import com.facebook.orca.activity.AbstractFbActivityListener;

public class MessagesDataInitializationActivityHelper extends AbstractFbActivityListener
{
  private final AppInitLock a;

  public MessagesDataInitializationActivityHelper(AppInitLock paramAppInitLock)
  {
    this.a = paramAppInitLock;
  }

  public void f(Activity paramActivity)
  {
    if (!paramActivity.getClass().getPackage().getName().startsWith("com.facebook.orca"));
    while (true)
    {
      return;
      this.a.b();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesDataInitializationActivityHelper
 * JD-Core Version:    0.6.0
 */