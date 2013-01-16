package com.facebook.device_id;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.SecureBroadcastReceiver.ActionReceiver;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;

class UniqueDeviceIdBroadcastSender$LocalBroadcastReceiver$1
  implements SecureBroadcastReceiver.ActionReceiver
{
  public void a(Context paramContext, Intent paramIntent, BroadcastReceiverLike paramBroadcastReceiverLike)
  {
    BLog.b(UniqueDeviceIdBroadcastSender.LocalBroadcastReceiver.a, "querying for device id");
    AppInitLockHelper.a(paramContext);
    UniqueDeviceIdBroadcastSender.c((UniqueDeviceIdBroadcastSender)FbInjector.a(paramContext).a(UniqueDeviceIdBroadcastSender.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.device_id.UniqueDeviceIdBroadcastSender.LocalBroadcastReceiver.1
 * JD-Core Version:    0.6.0
 */