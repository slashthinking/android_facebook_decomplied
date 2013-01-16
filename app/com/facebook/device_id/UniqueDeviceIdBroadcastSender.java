package com.facebook.device_id;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.login.AbstractAuthComponent;
import java.util.Random;
import java.util.Set;
import javax.inject.Provider;

public class UniqueDeviceIdBroadcastSender extends AbstractAuthComponent
{
  private static final Class<?> a = UniqueDeviceIdBroadcastSender.class;
  private final UniqueIdForDeviceHolder b;
  private final Clock c;
  private final Context d;
  private final AlarmManager e;
  private final Provider<DeviceIdReceiver> f;
  private final Set<DeviceIdChangedCallback> g;

  public UniqueDeviceIdBroadcastSender(UniqueIdForDeviceHolder paramUniqueIdForDeviceHolder, Clock paramClock, Context paramContext, AlarmManager paramAlarmManager, Provider<DeviceIdReceiver> paramProvider, Set<DeviceIdChangedCallback> paramSet)
  {
    this.b = paramUniqueIdForDeviceHolder;
    this.c = paramClock;
    this.d = paramContext;
    this.e = paramAlarmManager;
    this.f = paramProvider;
    this.g = paramSet;
  }

  private void d()
  {
    BLog.b(a, "querying other apps for unique id");
    Intent localIntent = new Intent();
    localIntent.setAction("com.facebook.GET_UNIQUE_ID");
    DeviceIdReceiver localDeviceIdReceiver = (DeviceIdReceiver)this.f.b();
    localDeviceIdReceiver.a(new UniqueDeviceIdBroadcastSender.1(this));
    this.d.sendOrderedBroadcast(localIntent, "com.facebook.receiver.permission.ACCESS", localDeviceIdReceiver, null, 1, null, null);
  }

  private long e()
  {
    Random localRandom = new Random(this.c.a());
    return 3600000L * (-6 + localRandom.nextInt(12)) + 60000L * (-30 + localRandom.nextInt(60));
  }

  public void a()
  {
    UniqueDeviceId localUniqueDeviceId = this.b.d();
    if ((localUniqueDeviceId != null) && (this.c.a() - localUniqueDeviceId.b() > 172800000L));
    while (true)
    {
      return;
      d();
      Intent localIntent = new Intent(this.d, UniqueDeviceIdBroadcastSender.LocalBroadcastReceiver.class);
      localIntent.setAction("com.facebook.GET_UNIQUE_ID");
      PendingIntent localPendingIntent = PendingIntent.getBroadcast(this.d, -1, localIntent, 0);
      long l = 86400000L + this.c.a() + e();
      this.e.set(1, l, localPendingIntent);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.device_id.UniqueDeviceIdBroadcastSender
 * JD-Core Version:    0.6.0
 */