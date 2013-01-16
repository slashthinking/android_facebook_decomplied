package com.facebook.orca.push.mqtt;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.analytics.ReliabilityAnalyticsLogger;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.auth.UserTokenCredentials;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.config.MqttConfig;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.mqtt.MqttQOSLevel;
import com.facebook.orca.net.OrcaNetworkManager;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.prefs.OrcaSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.orca.push.annotations.MqttEndpointCapability;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Random;
import javax.inject.Provider;

public class MqttPushService extends Service
{
  public static final Class<?> a = MqttPushService.class;
  private MqttConnectionManager b;
  private OrcaSharedPreferences c;
  private Provider<MqttConfig> d;
  private OrcaNetworkManager e;
  private Provider<UserTokenCredentials> f;
  private OrcaSharedPreferences.OnSharedPreferenceChangeListener g;
  private PushStateBroadcaster h;
  private Provider<Long> i;
  private ReliabilityAnalyticsLogger j;
  private AlarmManager k;
  private Clock l;
  private Random m;
  private BroadcastReceiver n;
  private boolean o;
  private MqttPushService.ConnectionState p;
  private long q;
  private long r;
  private long s;
  private MqttConfig t;

  private PendingIntent a(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, MqttPushService.class);
    localIntent.setAction(paramString);
    return PendingIntent.getService(this, 0, localIntent, 0);
  }

  private void a(long paramLong)
  {
    long l1 = (paramLong - this.l.a()) / 1000L;
    BLog.a(a, "Scheduling kick in " + l1 + " seconds");
    this.k.set(0, paramLong, a("Orca.KICK"));
  }

  private void a(Intent paramIntent)
  {
    if ("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED".equals(paramIntent.getAction()))
    {
      this.r = 0L;
      this.s = this.l.a();
      long l1 = Math.min(this.c.a(MqttPrefKeys.b, 10000L), 30000L);
      this.c.b().a(MqttPrefKeys.b, l1).a();
      BLog.a(a, "Network changed");
    }
    while (true)
    {
      e();
      return;
      if (!"com.facebook.orca.ACTION_MQTT_CONFIG_CHANGED".equals(paramIntent.getAction()))
        continue;
      BLog.a(a, "Config changed");
    }
  }

  private void b(String paramString)
  {
    this.j.a("mqtt_connection", paramString, null, null, null);
  }

  private void c()
  {
    BLog.c(a, "Starting service...");
    if (this.o)
    {
      BLog.d(a, "Attempt to start service that is already started");
      e();
    }
    while (true)
    {
      return;
      this.o = true;
      this.h.a(PushStateEvent.SERVICE_STARTED);
      this.n = new MqttPushService.1(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED");
      localIntentFilter.addAction("com.facebook.orca.ACTION_MQTT_CONFIG_CHANGED");
      LocalBroadcastManager.a(this).a(this.n, localIntentFilter);
      this.g = new MqttPushService.2(this);
      this.c.a(this.g);
      e();
    }
  }

  private void d()
  {
    if (!this.o)
      BLog.d(a, "Attempt to stop connection not active.");
    this.o = false;
    this.h.a(PushStateEvent.SERVICE_STOPPED);
    LocalBroadcastManager localLocalBroadcastManager = LocalBroadcastManager.a(this);
    if (this.n != null)
    {
      localLocalBroadcastManager.a(this.n);
      this.n = null;
    }
    if (this.g != null)
    {
      this.c.b(this.g);
      this.g = null;
    }
    h();
  }

  private void e()
  {
    BLog.a(a, "In kickConnection");
    if (!i())
    {
      BLog.a(a, "Shouldn't be connected");
      h();
    }
    while (true)
    {
      return;
      if (this.d.b() != this.t)
      {
        BLog.a(a, "Mqtt config changed -- disconnecting");
        h();
      }
      this.t = ((MqttConfig)this.d.b());
      if (this.p == MqttPushService.ConnectionState.CONNECTED)
        if (this.s > this.q)
          BLog.a(a, "Will reconnect because network changed");
      do
      {
        if (this.l.a() >= this.r)
          break label167;
        BLog.a(a, "Too early to retry connection");
        break;
        BLog.a(a, "Already connected");
        break;
      }
      while (this.p != MqttPushService.ConnectionState.CONNECTING);
      BLog.a(a, "Already connecting");
      continue;
      label167: BLog.a(a, "Connecting");
      this.p = MqttPushService.ConnectionState.CONNECTING;
      b("connecting");
      this.b.a();
    }
  }

  private void f()
  {
    if (i())
      this.b.c();
    while (true)
    {
      return;
      h();
    }
  }

  private void g()
  {
    b("disconnected");
  }

  private void h()
  {
    g();
    this.p = MqttPushService.ConnectionState.DISCONNECTED;
    this.b.b();
    l();
    k();
  }

  private boolean i()
  {
    int i1 = 0;
    if (!this.o)
      BLog.a(a, "Service not started");
    while (true)
    {
      return i1;
      if (!this.e.b())
      {
        BLog.a(a, "Not connected to network");
        i1 = 0;
        continue;
      }
      if (this.f.b() == null)
      {
        BLog.a(a, "Not logged in");
        i1 = 0;
        continue;
      }
      i1 = 1;
    }
  }

  private void j()
  {
    long l1 = 60000L * this.t.d();
    this.k.setRepeating(0, l1 + this.l.a(), l1, a("Orca.KEEP_ALIVE"));
  }

  private void k()
  {
    this.k.cancel(a("Orca.KEEP_ALIVE"));
  }

  private void l()
  {
    BLog.a(a, "Cancelling any pending kick");
    this.k.cancel(a("Orca.KICK"));
  }

  private void m()
  {
    BLog.a(a, "updateEndpointCapability");
    if (this.p == MqttPushService.ConnectionState.CONNECTED)
    {
      ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
      localObjectNode.put("endpoint_capabilities", (Long)this.i.b());
      this.b.a("/send_endpoint_capabilities", localObjectNode, MqttQOSLevel.FIRE_AND_FORGET);
    }
  }

  void a()
  {
    BLog.a(a, "Connection established");
    if (this.c.a(MqttPrefKeys.b, 10000L) != 10000L)
      this.c.b().a(MqttPrefKeys.b, 10000L).a();
    j();
    this.p = MqttPushService.ConnectionState.CONNECTED;
    this.q = this.l.a();
    b("connected");
    this.h.a(PushStateEvent.CHANNEL_CONNECTED);
    m();
  }

  void a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent("com.facebook.orca.push.mqtt.PUBLISH");
    localIntent.putExtra("topic_name", paramString1);
    localIntent.putExtra("payload", paramString2);
    this.h.a(localIntent);
  }

  void b()
  {
    this.h.a(PushStateEvent.CHANNEL_DISCONNECTED);
    if (this.p == MqttPushService.ConnectionState.DISCONNECTED);
    while (true)
    {
      return;
      BLog.a(a, "Connection lost");
      this.p = MqttPushService.ConnectionState.DISCONNECTED;
      g();
      long l1 = Math.min(2L * this.c.a(MqttPrefKeys.b, 10000L), 600000L);
      this.c.b().a(MqttPrefKeys.b, l1).a();
      long l2 = ()((0.5D + this.m.nextFloat()) * l1);
      BLog.c(a, "Rescheduling connection in " + l2 / 1000L + " seconds.");
      k();
      if (!this.e.b())
        continue;
      long l3 = l2 + this.l.a();
      a(l3);
      this.r = l3;
    }
  }

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onCreate()
  {
    super.onCreate();
    BLog.c(a, "Creating service");
    AppInitLockHelper.a(this);
    FbInjector localFbInjector = FbInjector.a(this);
    this.b = ((MqttConnectionManager)localFbInjector.a(MqttConnectionManager.class));
    this.c = ((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class));
    this.d = localFbInjector.b(MqttConfig.class);
    this.e = ((OrcaNetworkManager)localFbInjector.a(OrcaNetworkManager.class));
    this.f = localFbInjector.b(UserTokenCredentials.class);
    this.h = ((PushStateBroadcaster)localFbInjector.a(PushStateBroadcaster.class));
    this.i = localFbInjector.b(Long.class, MqttEndpointCapability.class);
    this.l = ((Clock)localFbInjector.a(Clock.class));
    this.b.a(this);
    this.m = new Random();
    this.t = ((MqttConfig)this.d.b());
    this.j = ((ReliabilityAnalyticsLogger)localFbInjector.a(ReliabilityAnalyticsLogger.class));
    this.k = ((AlarmManager)localFbInjector.a(AlarmManager.class, FromApplication.class));
  }

  public void onDestroy()
  {
    BLog.c(a, "Service destroyed (started=" + this.o + ")");
    if (this.o)
      d();
    this.b.b();
  }

  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
    BLog.c(a, "Service started with intent=" + paramIntent);
    if (paramIntent == null);
    while (true)
    {
      return;
      String str = paramIntent.getAction();
      if ("Orca.STOP".equals(str))
      {
        d();
        stopSelf();
        continue;
      }
      if ("Orca.START".equals(str))
      {
        c();
        continue;
      }
      if ("Orca.KEEP_ALIVE".equals(str))
      {
        f();
        continue;
      }
      if (!"Orca.KICK".equals(str))
        continue;
      e();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.MqttPushService
 * JD-Core Version:    0.6.0
 */