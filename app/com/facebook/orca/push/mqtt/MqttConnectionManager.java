package com.facebook.orca.push.mqtt;

import android.os.Handler;
import com.facebook.analytics.AnalyticCounters;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.mqtt.MqttClient;
import com.facebook.orca.mqtt.MqttException;
import com.facebook.orca.mqtt.MqttQOSLevel;
import com.facebook.orca.mqtt.messages.SubscribeTopic;
import com.facebook.orca.net.OrcaNetworkManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;

public class MqttConnectionManager
{
  private static final Class<?> a = MqttConnectionManager.class;
  private final OrcaNetworkManager b;
  private final AnalyticCounters c;
  private final Handler d;
  private MqttClient e;
  private MqttPushService f;
  private long g;
  private long h;
  private long i;
  private boolean j;
  private long k;
  private long l;
  private Set<Integer> m = Sets.a();
  private Map<String, SubscribeTopic> n = Maps.a();
  private Provider<MqttClient> o;

  public MqttConnectionManager(OrcaNetworkManager paramOrcaNetworkManager, AnalyticCounters paramAnalyticCounters, Provider<MqttClient> paramProvider)
  {
    this.b = paramOrcaNetworkManager;
    this.c = paramAnalyticCounters;
    this.o = paramProvider;
    this.d = new Handler();
  }

  private void a(MqttClient paramMqttClient)
  {
    if (paramMqttClient != null)
    {
      this.c.a("mqtt_bytes_sent", paramMqttClient.e());
      this.c.a("mqtt_bytes_received", paramMqttClient.f());
    }
  }

  private void a(Collection<SubscribeTopic> paramCollection)
  {
    BLog.c(a, "New topics: " + paramCollection);
    if ((h()) && (paramCollection.size() > 0));
    Class localClass;
    StringBuilder localStringBuilder;
    try
    {
      this.e.a(ImmutableList.a(paramCollection));
      return;
    }
    catch (MqttException localMqttException)
    {
      localClass = a;
      localStringBuilder = new StringBuilder().append("MqttException: ");
      if (localMqttException.getMessage() == null);
    }
    for (String str = localMqttException.getMessage(); ; str = "NULL")
    {
      BLog.c(localClass, str, localMqttException);
      break;
    }
  }

  private void k()
  {
    if (this.j)
      if (this.e == null)
      {
        l();
        if (this.i < this.l)
          n();
      }
    while (true)
    {
      return;
      if (this.g < this.k)
      {
        o();
        break;
      }
      if (this.e.b())
        break;
      o();
      break;
      if (this.e == null)
        continue;
      m();
    }
  }

  private void l()
  {
    this.e = ((MqttClient)this.o.b());
    if (this.e == null);
    while (true)
    {
      return;
      BLog.a(a, "Created mqtt client: " + this.e);
      this.e.a(new MqttConnectionManager.CallbackHandler(this, this.e));
      this.e.a();
      this.g = System.currentTimeMillis();
    }
  }

  private void m()
  {
    if (this.e != null)
    {
      MqttClient localMqttClient = this.e;
      this.e = null;
      a(localMqttClient);
      localMqttClient.a(null);
      this.f.b();
      localMqttClient.d();
      this.h = System.currentTimeMillis();
    }
  }

  private void n()
  {
    Class localClass;
    StringBuilder localStringBuilder;
    try
    {
      if (this.e != null)
      {
        this.e.a("/keepalive", new byte[0], MqttQOSLevel.FIRE_AND_FORGET, false);
        this.i = System.currentTimeMillis();
        a(this.e);
      }
      return;
    }
    catch (MqttException localMqttException)
    {
      localClass = a;
      localStringBuilder = new StringBuilder().append("MqttException: ");
      if (localMqttException.getMessage() == null);
    }
    for (String str = localMqttException.getMessage(); ; str = "NULL")
    {
      BLog.c(localClass, str, localMqttException);
      this.e.d();
      this.e = null;
      this.f.b();
      break;
    }
  }

  private void o()
  {
    BLog.c(a, "Reconnecting...");
    m();
    if (this.b.b())
      l();
  }

  // ERROR //
  public int a(String paramString, JsonNode paramJsonNode, MqttQOSLevel paramMqttQOSLevel)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 70	com/facebook/orca/push/mqtt/MqttConnectionManager:e	Lcom/facebook/orca/mqtt/MqttClient;
    //   4: astore 4
    //   6: aload 4
    //   8: ifnull +11 -> 19
    //   11: aload 4
    //   13: invokevirtual 165	com/facebook/orca/mqtt/MqttClient:b	()Z
    //   16: ifne +9 -> 25
    //   19: iconst_m1
    //   20: istore 5
    //   22: iload 5
    //   24: ireturn
    //   25: aload_0
    //   26: getfield 49	com/facebook/orca/push/mqtt/MqttConnectionManager:m	Ljava/util/Set;
    //   29: astore 7
    //   31: aload 7
    //   33: monitorenter
    //   34: aload 4
    //   36: aload_1
    //   37: aload_2
    //   38: invokevirtual 221	com/fasterxml/jackson/databind/JsonNode:toString	()Ljava/lang/String;
    //   41: invokestatic 226	com/facebook/orca/common/util/StringUtil:d	(Ljava/lang/String;)[B
    //   44: aload_3
    //   45: iconst_0
    //   46: invokevirtual 212	com/facebook/orca/mqtt/MqttClient:a	(Ljava/lang/String;[BLcom/facebook/orca/mqtt/MqttQOSLevel;Z)I
    //   49: istore 5
    //   51: aload_0
    //   52: getfield 49	com/facebook/orca/push/mqtt/MqttConnectionManager:m	Ljava/util/Set;
    //   55: iload 5
    //   57: invokestatic 232	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: invokeinterface 238 2 0
    //   65: pop
    //   66: aload 7
    //   68: monitorexit
    //   69: aload_0
    //   70: aload 4
    //   72: invokespecial 193	com/facebook/orca/push/mqtt/MqttConnectionManager:a	(Lcom/facebook/orca/mqtt/MqttClient;)V
    //   75: goto -53 -> 22
    //   78: astore 6
    //   80: iconst_m1
    //   81: istore 5
    //   83: goto -61 -> 22
    //   86: astore 8
    //   88: aload 7
    //   90: monitorexit
    //   91: aload 8
    //   93: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   25	34	78	com/facebook/orca/mqtt/MqttException
    //   69	75	78	com/facebook/orca/mqtt/MqttException
    //   91	94	78	com/facebook/orca/mqtt/MqttException
    //   34	69	86	finally
    //   88	91	86	finally
  }

  void a()
  {
    this.j = true;
    this.k = System.currentTimeMillis();
    this.l = 0L;
    k();
  }

  void a(MqttPushService paramMqttPushService)
  {
    this.f = paramMqttPushService;
  }

  // ERROR //
  public void a(Set<SubscribeTopic> paramSet)
  {
    // Byte code:
    //   0: getstatic 38	com/facebook/orca/push/mqtt/MqttConnectionManager:a	Ljava/lang/Class;
    //   3: new 95	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   10: ldc 244
    //   12: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_1
    //   16: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 114	com/facebook/orca/debug/BLog:c	(Ljava/lang/Class;Ljava/lang/String;)V
    //   25: invokestatic 47	com/google/common/collect/Sets:a	()Ljava/util/HashSet;
    //   28: astore_2
    //   29: aload_0
    //   30: getfield 56	com/facebook/orca/push/mqtt/MqttConnectionManager:n	Ljava/util/Map;
    //   33: astore_3
    //   34: aload_3
    //   35: monitorenter
    //   36: aload_1
    //   37: invokeinterface 248 1 0
    //   42: astore 5
    //   44: aload 5
    //   46: invokeinterface 253 1 0
    //   51: ifeq +69 -> 120
    //   54: aload 5
    //   56: invokeinterface 256 1 0
    //   61: checkcast 258	com/facebook/orca/mqtt/messages/SubscribeTopic
    //   64: astore 6
    //   66: aload 6
    //   68: invokevirtual 260	com/facebook/orca/mqtt/messages/SubscribeTopic:a	()Ljava/lang/String;
    //   71: astore 7
    //   73: aload_0
    //   74: getfield 56	com/facebook/orca/push/mqtt/MqttConnectionManager:n	Ljava/util/Map;
    //   77: aload 7
    //   79: invokeinterface 265 2 0
    //   84: ifne -40 -> 44
    //   87: aload_0
    //   88: getfield 56	com/facebook/orca/push/mqtt/MqttConnectionManager:n	Ljava/util/Map;
    //   91: aload 7
    //   93: aload 6
    //   95: invokeinterface 269 3 0
    //   100: pop
    //   101: aload_2
    //   102: aload 6
    //   104: invokeinterface 238 2 0
    //   109: pop
    //   110: goto -66 -> 44
    //   113: astore 4
    //   115: aload_3
    //   116: monitorexit
    //   117: aload 4
    //   119: athrow
    //   120: aload_3
    //   121: monitorexit
    //   122: aload_0
    //   123: aload_2
    //   124: invokespecial 91	com/facebook/orca/push/mqtt/MqttConnectionManager:a	(Ljava/util/Collection;)V
    //   127: return
    //
    // Exception table:
    //   from	to	target	type
    //   36	117	113	finally
    //   120	122	113	finally
  }

  public boolean a(String paramString, JsonNode paramJsonNode, long paramLong)
  {
    int i1 = 1;
    long l1 = paramLong + System.currentTimeMillis();
    while (true)
    {
      synchronized (this.m)
      {
        int i2 = a(paramString, paramJsonNode, MqttQOSLevel.ACKNOWLEDGED_DELIVERY);
        long l2 = l1 - System.currentTimeMillis();
        if (l2 <= 0L)
          continue;
        this.m.wait(l2);
        if (!this.m.contains(Integer.valueOf(i2)))
          break;
        l2 = l1 - System.currentTimeMillis();
        continue;
        if (this.m.contains(Integer.valueOf(i2)));
      }
      i1 = 0;
    }
    return i1;
  }

  void b()
  {
    this.j = false;
    k();
  }

  void c()
  {
    this.l = System.currentTimeMillis();
    k();
  }

  void d()
  {
    this.f.a();
  }

  void e()
  {
    f();
  }

  void f()
  {
    this.f.b();
  }

  public boolean g()
  {
    MqttClient localMqttClient = this.e;
    if ((localMqttClient != null) && (localMqttClient.b()));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public boolean h()
  {
    MqttClient localMqttClient = this.e;
    if ((localMqttClient != null) && (localMqttClient.c()));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public long i()
  {
    return this.h;
  }

  public long j()
  {
    return this.g;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.MqttConnectionManager
 * JD-Core Version:    0.6.0
 */