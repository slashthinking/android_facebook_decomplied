package com.facebook.orca.phone;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import com.facebook.orca.annotations.IsIncallOutgoingEnabled;
import com.facebook.orca.annotations.IsIncallPermitted;
import com.facebook.orca.common.OrcaWakeLockManager.WakeLock;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import java.util.List;
import javax.inject.Provider;

public class TelephonyState
{
  private static boolean g = false;
  private static String h = null;
  private static TelephonyReceiverWakeLockHolder i;
  private Class<?> a = TelephonyState.class;
  private Provider<Boolean> b;
  private Provider<Boolean> c;
  private ActivityManager d = null;
  private PowerManager e = null;
  private TelephonyManager f = null;

  private void b(Context paramContext, String paramString)
  {
    if (!this.e.isScreenOn())
      i.a.a();
    if (this.f.getCallState() != 0)
    {
      Intent localIntent = new Intent(paramContext, IncallActivity.class);
      localIntent.putExtra("android.intent.extra.PHONE_NUMBER", paramString);
      localIntent.setFlags(272629760);
      paramContext.startActivity(localIntent);
    }
    while (true)
    {
      return;
      i.a.b();
    }
  }

  private boolean g()
  {
    return ((ActivityManager.RunningTaskInfo)this.d.getRunningTasks(1).get(0)).topActivity.flattenToString().contains("com.android.phone.InCallScreen");
  }

  void a(Context paramContext)
  {
    FbInjector localFbInjector = FbInjector.a(paramContext);
    this.b = localFbInjector.b(Boolean.class, IsIncallPermitted.class);
    this.c = localFbInjector.b(Boolean.class, IsIncallOutgoingEnabled.class);
    if (((Boolean)this.b.b()).booleanValue())
    {
      this.d = ((ActivityManager)paramContext.getSystemService("activity"));
      this.e = ((PowerManager)paramContext.getSystemService("power"));
      this.f = ((TelephonyManager)paramContext.getSystemService("phone"));
      if (i == null)
        i = (TelephonyReceiverWakeLockHolder)localFbInjector.a(TelephonyReceiverWakeLockHolder.class);
    }
  }

  void a(Context paramContext, String paramString)
  {
    if ((!((Boolean)this.c.b()).booleanValue()) && (g()))
      b(paramContext, paramString);
    long l = System.nanoTime();
    while ((!g()) && (this.f.getCallState() != 0))
    {
      if (System.nanoTime() - l <= 1000000000L)
        continue;
      BLog.e(this.a, "Incall UI launch loop has timed out!");
    }
    while (true)
    {
      return;
      b(paramContext, paramString);
    }
  }

  void a(String paramString)
  {
    h = paramString;
  }

  void a(boolean paramBoolean)
  {
    g = paramBoolean;
  }

  boolean a()
  {
    return ((Boolean)this.b.b()).booleanValue();
  }

  boolean b()
  {
    return ((Boolean)this.c.b()).booleanValue();
  }

  boolean c()
  {
    return g;
  }

  String d()
  {
    return h;
  }

  boolean e()
  {
    return i.a.d();
  }

  void f()
  {
    i.a.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.phone.TelephonyState
 * JD-Core Version:    0.6.0
 */