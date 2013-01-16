package com.facebook.orca.push.c2dm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.net.OrcaNetworkManager;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.push.analytics.PushC2DMRegistrationClientEvent;
import com.facebook.orca.push.analytics.PushC2DMRegistrationInitialStatusClientEvent;
import com.facebook.orca.push.analytics.PushC2DMUnregistrationClientEvent;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Map;

public class C2DMRegistrar
{
  private static final Class<?> b = C2DMRegistrar.class;
  final FacebookPushServerRegistrar.Callback a;
  private final Context c;
  private final OrcaSharedPreferences d;
  private final AnalyticsLogger e;
  private final boolean f;
  private final OrcaNetworkManager g;
  private final FacebookPushServerRegistrar h;
  private final PushTokenHolder i;
  private final AlarmManager j;

  public C2DMRegistrar(Context paramContext, OrcaSharedPreferences paramOrcaSharedPreferences, AnalyticsLogger paramAnalyticsLogger, boolean paramBoolean, OrcaNetworkManager paramOrcaNetworkManager, FacebookPushServerRegistrar paramFacebookPushServerRegistrar, PushTokenHolder paramPushTokenHolder, AlarmManager paramAlarmManager)
  {
    this.c = paramContext;
    this.d = paramOrcaSharedPreferences;
    this.e = paramAnalyticsLogger;
    this.f = paramBoolean;
    this.g = paramOrcaNetworkManager;
    this.h = paramFacebookPushServerRegistrar;
    this.i = paramPushTokenHolder;
    this.j = paramAlarmManager;
    this.a = new C2DMRegistrar.1(this);
  }

  private void a(long paramLong)
  {
    if (paramLong > 1800000L)
      paramLong = 1800000L;
    OrcaSharedPreferences.Editor localEditor = this.d.b();
    localEditor.a(C2DMPrefKeys.f, paramLong);
    localEditor.a();
  }

  private C2DMRegistrar.RegistrationStatus d()
  {
    C2DMRegistrar.RegistrationStatus localRegistrationStatus;
    if (StringUtil.a(this.i.a()))
      localRegistrationStatus = C2DMRegistrar.RegistrationStatus.NONE;
    while (true)
    {
      return localRegistrationStatus;
      long l1 = System.currentTimeMillis();
      long l2 = this.i.j();
      long l3 = this.d.a(C2DMPrefKeys.g, 0L);
      if ((l1 - l2 > 604800000L) && (l1 - l3 > 172800000L))
      {
        localRegistrationStatus = C2DMRegistrar.RegistrationStatus.EXPIRED;
        continue;
      }
      if (this.i.e() != this.f)
      {
        localRegistrationStatus = C2DMRegistrar.RegistrationStatus.WRONG_TYPE;
        continue;
      }
      localRegistrationStatus = C2DMRegistrar.RegistrationStatus.CURRENT;
    }
  }

  private void e()
  {
    long l = 10800000L + System.currentTimeMillis();
    this.j.set(1, l, g());
  }

  private void f()
  {
    this.j.cancel(g());
  }

  private PendingIntent g()
  {
    Intent localIntent = new Intent(this.c, C2DMRegistrar.LocalBroadcastReceiver.class);
    localIntent.setAction("com.facebook.orca.push.ACTION_ALARM");
    return PendingIntent.getBroadcast(this.c, -1, localIntent, 0);
  }

  private void h()
  {
    a("invalid_token");
    if (System.currentTimeMillis() - this.i.j() < 86400000L);
    while (true)
    {
      return;
      this.i.f();
      a();
    }
  }

  private long i()
  {
    return this.d.a(C2DMPrefKeys.f, 30000L);
  }

  public void a()
  {
    a("attempt");
    e();
    Intent localIntent = new Intent("com.google.android.c2dm.intent.REGISTER");
    localIntent.putExtra("app", PendingIntent.getBroadcast(this.c, 0, new Intent(), 0));
    PushTokenHolder.ServiceType localServiceType = this.i.b();
    if (localServiceType == PushTokenHolder.ServiceType.GCM)
      localIntent.putExtra("sender", "15057814354");
    while (true)
    {
      this.d.b().a(C2DMPrefKeys.h, localServiceType.toString()).a();
      ComponentName localComponentName = this.c.startService(localIntent);
      BLog.a(b, "startService=" + localComponentName);
      return;
      localIntent.putExtra("sender", "facebook.android@gmail.com");
    }
  }

  public void a(C2DMRegistrar.RegistrationStatus paramRegistrationStatus)
  {
    HoneyClientEvent localHoneyClientEvent = PushC2DMRegistrationInitialStatusClientEvent.a(paramRegistrationStatus, this.i.a());
    this.e.b(localHoneyClientEvent);
  }

  public void a(String paramString)
  {
    HoneyClientEvent localHoneyClientEvent = PushC2DMRegistrationClientEvent.a(paramString, this.i.a(), c());
    this.e.b(localHoneyClientEvent);
  }

  void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.i.f();
      b("success");
    }
    while (true)
    {
      return;
      f();
      if (paramString2 != null)
      {
        this.i.f();
        BLog.e(b, "Registration error " + paramString2);
        if ("SERVICE_NOT_AVAILABLE".equals(paramString2))
        {
          long l = i();
          BLog.b(b, "Scheduling registration retry, backoff = " + l);
          Intent localIntent = new Intent("com.google.android.c2dm.intent.RETRY");
          PendingIntent localPendingIntent = PendingIntent.getBroadcast(this.c, 0, localIntent, 0);
          ((AlarmManager)this.c.getSystemService("alarm")).set(3, l + SystemClock.elapsedRealtime(), localPendingIntent);
          a(2L * l);
        }
        a(paramString2.toLowerCase());
        continue;
      }
      this.i.a(paramString1, this.i.c());
      a("success");
      this.h.a(this.a);
    }
  }

  public void a(boolean paramBoolean)
  {
    BLog.b(b, "checking push registration status, forceFacebookServerRegistration=" + paramBoolean);
    C2DMRegistrar.RegistrationStatus localRegistrationStatus = d();
    a(localRegistrationStatus);
    switch (C2DMRegistrar.2.a[localRegistrationStatus.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return;
      BLog.a(b, "GCM/C2DM registration is current, checking facebook server registration");
      if (paramBoolean)
      {
        this.h.a(this.a);
        continue;
      }
      this.h.b(this.a);
      continue;
      BLog.a(b, "GCM/C2DM preference inconsistency. Reregistering with google server");
      b();
      a();
      continue;
      if (this.g.b())
      {
        BLog.a(b, "Regid has expired and network is connected  -- trying to register with google server");
        a();
        continue;
      }
      BLog.a(b, "Regid has expired but network is not connected  -- skipping registration with google server");
      continue;
      BLog.a(b, "Has no regid -- trying to register with google server");
      a();
    }
  }

  public void b()
  {
    b("attempt");
    Intent localIntent = new Intent("com.google.android.c2dm.intent.UNREGISTER");
    localIntent.putExtra("app", PendingIntent.getBroadcast(this.c, 0, new Intent(), 0));
    this.c.startService(localIntent);
    this.h.a();
    this.i.f();
  }

  public void b(String paramString)
  {
    HoneyClientEvent localHoneyClientEvent = PushC2DMUnregistrationClientEvent.a(paramString, this.i.a());
    this.e.b(localHoneyClientEvent);
  }

  public Map<String, String> c()
  {
    HashMap localHashMap = Maps.a();
    localHashMap.put("backoff", String.valueOf(i()));
    localHashMap.put("service_type", this.i.b().toString());
    return localHashMap;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.C2DMRegistrar
 * JD-Core Version:    0.6.0
 */