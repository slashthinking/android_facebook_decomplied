package com.facebook.orca.push.mqtt;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.app.UserActivityManager;
import com.facebook.orca.activity.SafeLocalBroadcastReceiver;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.debug.BLog;
import javax.inject.Provider;

public class MqttPushServiceManager
  implements INeedInit
{
  private static final Class<?> a = MqttPushServiceManager.class;
  private final Context b;
  private final UserActivityManager c;
  private final Provider<String> d;
  private final Provider<Boolean> e;
  private final Provider<Boolean> f;
  private SafeLocalBroadcastReceiver g;
  private boolean h;
  private boolean i;

  public MqttPushServiceManager(@FromApplication Context paramContext, UserActivityManager paramUserActivityManager, Provider<String> paramProvider, Provider<Boolean> paramProvider1, Provider<Boolean> paramProvider2)
  {
    this.e = paramProvider1;
    this.f = paramProvider2;
    this.b = paramContext;
    this.c = paramUserActivityManager;
    this.d = paramProvider;
  }

  private void a(long paramLong)
  {
    long l = (paramLong - System.currentTimeMillis()) / 1000L;
    BLog.a(a, "Scheduling check in " + l + " seconds");
    Intent localIntent = new Intent(this.b, MqttPushServiceManager.LocalBroadcastReceiver.class);
    localIntent.setAction("com.facebook.orca.push.mqtt.ACTION_ALARM");
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(this.b, 0, localIntent, 0);
    ((AlarmManager)this.b.getSystemService("alarm")).set(0, paramLong, localPendingIntent);
  }

  private void a(PushStateEvent paramPushStateEvent)
  {
    switch (MqttPushServiceManager.2.a[paramPushStateEvent.ordinal()])
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      return;
      this.i = true;
      continue;
      this.i = false;
    }
  }

  private void c()
  {
    BLog.a(a, "onActivityBroadcast");
    d();
  }

  private void d()
  {
    BLog.a(a, "Checking if push service should run");
    if (this.h)
    {
      BLog.a(a, "Service enabled");
      if (h())
      {
        BLog.a(a, "Service should be running");
        if (!this.i)
        {
          BLog.a(a, "Service isn't started");
          e();
        }
        if (!g())
          i();
      }
    }
    while (true)
    {
      return;
      BLog.a(a, "Service shouldn't be started");
      if (!this.i)
        continue;
      f();
      continue;
      if (!this.i)
        continue;
      f();
    }
  }

  private void e()
  {
    BLog.a(a, "Ensuring service started");
    Intent localIntent = new Intent(this.b, MqttPushService.class);
    localIntent.setAction("Orca.START");
    this.b.startService(localIntent);
  }

  private void f()
  {
    BLog.a(a, "Stopping service cleanly");
    if (this.i)
    {
      Intent localIntent1 = new Intent(this.b, MqttPushService.class);
      localIntent1.setAction("Orca.STOP");
      this.b.startService(localIntent1);
    }
    while (true)
    {
      return;
      Intent localIntent2 = new Intent(this.b, MqttPushService.class);
      this.b.stopService(localIntent2);
    }
  }

  private boolean g()
  {
    boolean bool = ((Boolean)this.e.b()).booleanValue();
    if ((((Boolean)this.f.b()).booleanValue()) && (bool));
    for (int j = 1; ; j = 0)
      return j;
  }

  private boolean h()
  {
    int j = 0;
    if (this.d.b() == null)
      BLog.a(a, "Not logged in");
    while (true)
    {
      return j;
      if ((!g()) && (System.currentTimeMillis() - this.c.d() > 600000L))
      {
        BLog.a(a, "User is idle");
        j = 0;
        continue;
      }
      j = 1;
    }
  }

  private void i()
  {
    long l = 600000L + this.c.d();
    a(Math.max(30000L + System.currentTimeMillis(), l));
  }

  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    d();
  }

  public void i_()
  {
    AppInitLockHelper.a(this.b);
    IntentFilter localIntentFilter = new IntentFilter();
    if (!g())
      localIntentFilter.addAction("com.facebook.app.USER_MAYBE_BECAME_ACTIVE_OR_INACTIVE");
    localIntentFilter.addAction("com.facebook.orca.ACTION_PERSISTENT_CHANNEL_STATE_CHANGED");
    this.g = new MqttPushServiceManager.1(this, this.b, localIntentFilter);
    this.g.a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.MqttPushServiceManager
 * JD-Core Version:    0.6.0
 */