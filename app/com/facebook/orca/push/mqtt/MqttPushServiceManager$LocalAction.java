package com.facebook.orca.push.mqtt;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.SecureBroadcastReceiver.ActionReceiver;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.common.async.AsyncTaskRunner;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;

class MqttPushServiceManager$LocalAction
  implements SecureBroadcastReceiver.ActionReceiver
{
  public void a(Context paramContext, Intent paramIntent, BroadcastReceiverLike paramBroadcastReceiverLike)
  {
    BLog.a(MqttPushServiceManager.b(), "LocalBroadcastReceiver.onReceive");
    AppInitLockHelper.a(paramContext);
    new AsyncTaskRunner(new MqttPushServiceManager.LocalAction.1(this, (MqttPushServiceManager)FbInjector.a(paramContext).a(MqttPushServiceManager.class))).a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.MqttPushServiceManager.LocalAction
 * JD-Core Version:    0.6.0
 */