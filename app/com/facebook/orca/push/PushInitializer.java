package com.facebook.orca.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.login.AbstractAuthComponent;
import java.util.Iterator;
import java.util.Set;

public class PushInitializer extends AbstractAuthComponent
  implements INeedInit
{
  private static Class<?> a = PushInitializer.class;
  private final Context b;
  private final AlarmManager c;
  private final Handler d;
  private final Set<PushManager> e;
  private boolean f;

  public PushInitializer(Context paramContext, AlarmManager paramAlarmManager, Set<PushManager> paramSet)
  {
    this.b = paramContext;
    this.c = paramAlarmManager;
    this.d = new Handler();
    this.e = paramSet;
  }

  private void d()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
      ((PushManager)localIterator.next()).b();
    f();
  }

  private void e()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
      ((PushManager)localIterator.next()).c();
  }

  private void f()
  {
    if (this.f);
    while (true)
    {
      return;
      Intent localIntent = new Intent(this.b, PushInitializer.LocalBroadcastReceiver.class);
      localIntent.setAction("com.facebook.orca.push.ACTION_ALARM");
      PendingIntent localPendingIntent = PendingIntent.getBroadcast(this.b, -1, localIntent, 0);
      long l = 86400000L + System.currentTimeMillis();
      this.c.set(1, l, localPendingIntent);
      this.f = true;
    }
  }

  public void b()
  {
    BLog.b(a, "PushInitializer.onLogin");
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
      ((PushManager)localIterator.next()).a();
  }

  public void c()
  {
    e();
  }

  public void i_()
  {
    BLog.b(a, "PushInitializer.init");
    d();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.PushInitializer
 * JD-Core Version:    0.6.0
 */