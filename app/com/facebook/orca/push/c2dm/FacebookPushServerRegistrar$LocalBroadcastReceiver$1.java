package com.facebook.orca.push.c2dm;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.SecureBroadcastReceiver.ActionReceiver;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.inject.FbInjector;

class FacebookPushServerRegistrar$LocalBroadcastReceiver$1
  implements SecureBroadcastReceiver.ActionReceiver
{
  public void a(Context paramContext, Intent paramIntent, BroadcastReceiverLike paramBroadcastReceiverLike)
  {
    AppInitLockHelper.a(paramContext);
    FbInjector localFbInjector = FbInjector.a(paramContext);
    C2DMRegistrar localC2DMRegistrar = (C2DMRegistrar)localFbInjector.a(C2DMRegistrar.class);
    ((FacebookPushServerRegistrar)localFbInjector.a(FacebookPushServerRegistrar.class)).a(localC2DMRegistrar.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.FacebookPushServerRegistrar.LocalBroadcastReceiver.1
 * JD-Core Version:    0.6.0
 */