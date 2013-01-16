package com.facebook.orca.push.mqtt;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.common.OrcaWakeLockManager.WakeLock;
import com.facebook.orca.inject.FbInjector;
import java.util.Iterator;
import java.util.Set;

public class MqttReceiver extends IntentService
{
  private Set<MqttPushHandler> a;
  private MqttReceiverWakeLockHolder b;

  public MqttReceiver()
  {
    super("MqttReceiver");
  }

  static void a(Context paramContext, Intent paramIntent)
  {
    ((MqttReceiverWakeLockHolder)FbInjector.a(paramContext).a(MqttReceiverWakeLockHolder.class)).a.a();
    paramIntent.setClassName(paramContext, MqttReceiver.class.getName());
    paramContext.startService(paramIntent);
  }

  public void onCreate()
  {
    super.onCreate();
    AppInitLockHelper.a(this);
    FbInjector localFbInjector = FbInjector.a(this);
    this.b = ((MqttReceiverWakeLockHolder)localFbInjector.a(MqttReceiverWakeLockHolder.class));
    this.a = localFbInjector.c(MqttPushHandler.class);
  }

  public final void onHandleIntent(Intent paramIntent)
  {
    try
    {
      if (paramIntent.getAction().equals("com.facebook.orca.push.mqtt.PUBLISH"))
      {
        String str1 = paramIntent.getStringExtra("topic_name");
        String str2 = paramIntent.getStringExtra("payload");
        Iterator localIterator = this.a.iterator();
        if (localIterator.hasNext())
          ((MqttPushHandler)localIterator.next()).a(str1, str2);
      }
    }
    finally
    {
      this.b.a.b();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.MqttReceiver
 * JD-Core Version:    0.6.0
 */