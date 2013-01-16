package com.facebook.orca.push;

import android.app.AlarmManager;
import android.content.Context;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;

class PushModule$PushInitializerProvider extends AbstractProvider<PushInitializer>
{
  private PushModule$PushInitializerProvider(PushModule paramPushModule)
  {
  }

  public PushInitializer a()
  {
    return new PushInitializer((Context)b(Context.class, FromApplication.class), (AlarmManager)b(AlarmManager.class, FromApplication.class), c(PushManager.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.PushModule.PushInitializerProvider
 * JD-Core Version:    0.6.0
 */