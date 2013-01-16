package com.facebook.orca.push.c2dm;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.SecureBroadcastReceiver.ActionReceiver;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.inject.FbInjector;

class C2DMRegistrar$LocalBroadcastReceiver$1
  implements SecureBroadcastReceiver.ActionReceiver
{
  public void a(Context paramContext, Intent paramIntent, BroadcastReceiverLike paramBroadcastReceiverLike)
  {
    AppInitLockHelper.a(paramContext);
    ((C2DMRegistrar)FbInjector.a(paramContext).a(C2DMRegistrar.class)).a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.C2DMRegistrar.LocalBroadcastReceiver.1
 * JD-Core Version:    0.6.0
 */