package com.facebook.orca.push;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.SecureBroadcastReceiver.ActionReceiver;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.inject.FbInjector;

class PushInitializer$AlarmReceiver
  implements SecureBroadcastReceiver.ActionReceiver
{
  private PushInitializer a;

  public void a(Context paramContext, Intent paramIntent, BroadcastReceiverLike paramBroadcastReceiverLike)
  {
    AppInitLockHelper.a(paramContext);
    this.a = ((PushInitializer)FbInjector.a(paramContext).a(PushInitializer.class));
    PushInitializer.a(this.a, false);
    PushInitializer.b(this.a).post(new PushInitializer.AlarmReceiver.1(this));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.PushInitializer.AlarmReceiver
 * JD-Core Version:    0.6.0
 */