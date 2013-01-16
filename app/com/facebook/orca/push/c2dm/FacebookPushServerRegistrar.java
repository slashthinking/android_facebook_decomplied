package com.facebook.orca.push.c2dm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.net.OrcaNetworkManager;
import com.facebook.orca.ops.OrcaServiceOperation;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.push.analytics.PushServerRegistrationClientEvent;
import com.facebook.orca.push.analytics.PushServerRegistrationInitialStatusClientEvent;
import com.facebook.orca.push.analytics.PushServerUnregistrationClientEvent;
import com.facebook.orca.server.OperationResult;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Provider;

public class FacebookPushServerRegistrar
{
  private static Class<?> a = FacebookPushServerRegistrar.class;
  private final Context b;
  private final Provider<OrcaServiceOperation> c;
  private final Provider<SingleMethodRunner> d;
  private final UnregisterPushTokenMethod e;
  private final Provider<String> f;
  private final UniqueIdForDeviceHolder g;
  private final OrcaNetworkManager h;
  private final PushTokenHolder i;
  private final AnalyticsLogger j;
  private final AlarmManager k;

  public FacebookPushServerRegistrar(Context paramContext, Provider<OrcaServiceOperation> paramProvider, Provider<SingleMethodRunner> paramProvider1, UnregisterPushTokenMethod paramUnregisterPushTokenMethod, Provider<String> paramProvider2, UniqueIdForDeviceHolder paramUniqueIdForDeviceHolder, OrcaNetworkManager paramOrcaNetworkManager, PushTokenHolder paramPushTokenHolder, AnalyticsLogger paramAnalyticsLogger, AlarmManager paramAlarmManager)
  {
    this.b = paramContext;
    this.c = paramProvider;
    this.d = paramProvider1;
    this.e = paramUnregisterPushTokenMethod;
    this.f = paramProvider2;
    this.g = paramUniqueIdForDeviceHolder;
    this.h = paramOrcaNetworkManager;
    this.i = paramPushTokenHolder;
    this.j = paramAnalyticsLogger;
    this.k = paramAlarmManager;
  }

  private void c()
  {
    long l = 10800000L + System.currentTimeMillis();
    this.k.set(1, l, e());
  }

  private void d()
  {
    this.k.cancel(e());
  }

  private PendingIntent e()
  {
    Intent localIntent = new Intent(this.b, FacebookPushServerRegistrar.LocalBroadcastReceiver.class);
    localIntent.setAction("com.facebook.orca.push.ACTION_ALARM");
    return PendingIntent.getBroadcast(this.b, -1, localIntent, 0);
  }

  private FacebookPushServerRegistrar.RegistrationStatus f()
  {
    FacebookPushServerRegistrar.RegistrationStatus localRegistrationStatus;
    if (!this.i.i())
      localRegistrationStatus = FacebookPushServerRegistrar.RegistrationStatus.NONE;
    while (true)
    {
      return localRegistrationStatus;
      if (!this.i.g().equals(this.f.b()))
      {
        localRegistrationStatus = FacebookPushServerRegistrar.RegistrationStatus.WRONG_USER;
        continue;
      }
      long l = this.i.m();
      if (System.currentTimeMillis() - l > 86400000L)
      {
        localRegistrationStatus = FacebookPushServerRegistrar.RegistrationStatus.EXPIRED;
        continue;
      }
      localRegistrationStatus = FacebookPushServerRegistrar.RegistrationStatus.CURRENT;
    }
  }

  public void a()
  {
    if (this.i.a() == null);
    while (true)
    {
      return;
      b("attempt");
      this.i.l();
      try
      {
        UnregisterPushTokenParams localUnregisterPushTokenParams = new UnregisterPushTokenParams(this.i.a());
        ((SingleMethodRunner)this.d.b()).a(this.e, localUnregisterPushTokenParams);
        b("success");
      }
      catch (Exception localException)
      {
        b("failed");
      }
    }
  }

  public void a(FacebookPushServerRegistrar.Callback paramCallback)
  {
    String str1 = (String)this.f.b();
    if (str1 == null)
    {
      BLog.c(a, "no user, cancel push token registration");
      a("auth_no_user");
      return;
    }
    PushTokenHolder.ServiceType localServiceType = this.i.d();
    String str2 = this.i.a();
    String str3 = this.g.b();
    if ((!this.i.i()) || (!str1.equals(this.i.g())));
    for (boolean bool = true; ; bool = false)
    {
      RegisterPushTokenParams localRegisterPushTokenParams = new RegisterPushTokenParams(localServiceType, str2, str3, bool);
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("registerPushTokenParams", localRegisterPushTokenParams);
      OrcaServiceOperation localOrcaServiceOperation = (OrcaServiceOperation)this.c.b();
      localOrcaServiceOperation.b(true);
      localOrcaServiceOperation.a(new FacebookPushServerRegistrar.1(this, paramCallback));
      localOrcaServiceOperation.a("register_push", localBundle);
      c();
      a("attempt");
      break;
    }
  }

  public void a(FacebookPushServerRegistrar.RegistrationStatus paramRegistrationStatus)
  {
    HoneyClientEvent localHoneyClientEvent = PushServerRegistrationInitialStatusClientEvent.a(paramRegistrationStatus, this.i.a());
    this.j.b(localHoneyClientEvent);
  }

  void a(OperationResult paramOperationResult, FacebookPushServerRegistrar.Callback paramCallback)
  {
    d();
    RegisterPushTokenResult localRegisterPushTokenResult = (RegisterPushTokenResult)paramOperationResult.h();
    if (!localRegisterPushTokenResult.a())
      a("server_failed");
    while (true)
    {
      return;
      if (localRegisterPushTokenResult.b())
      {
        paramCallback.a();
        a("invalid_token");
        continue;
      }
      this.i.k();
      a("success");
    }
  }

  public void a(String paramString)
  {
    HoneyClientEvent localHoneyClientEvent = PushServerRegistrationClientEvent.a(paramString, this.i.a(), b());
    this.j.b(localHoneyClientEvent);
  }

  public Map<String, String> b()
  {
    HashMap localHashMap = Maps.a();
    localHashMap.put("service_type", this.i.b().toString());
    return localHashMap;
  }

  public void b(FacebookPushServerRegistrar.Callback paramCallback)
  {
    FacebookPushServerRegistrar.RegistrationStatus localRegistrationStatus = f();
    a(localRegistrationStatus);
    switch (FacebookPushServerRegistrar.2.a[localRegistrationStatus.ordinal()])
    {
    default:
      BLog.d(a, "unexpected facebook registration status: " + localRegistrationStatus);
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return;
      BLog.a(a, "facebook registration is up to date");
      continue;
      if (this.h.b())
      {
        BLog.a(a, "facebook registration has expired and network is connected -- trying to register");
        a(paramCallback);
        continue;
      }
      BLog.a(a, "facebook registration has expired but network is not connected -- skipping registration");
      continue;
      BLog.d(a, "push token registered with different user. claiming token with facebook");
      a("wrong_user");
      a(paramCallback);
      continue;
      BLog.a(a, "Not registered with facebook server. registering");
      a(paramCallback);
    }
  }

  public void b(String paramString)
  {
    HoneyClientEvent localHoneyClientEvent = PushServerUnregistrationClientEvent.a(paramString, this.i.a());
    this.j.b(localHoneyClientEvent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.FacebookPushServerRegistrar
 * JD-Core Version:    0.6.0
 */