package com.facebook.orca.push.mqtt;

import com.facebook.orca.push.PushManager;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Provider;

public class MqttPushManager
  implements PushManager
{
  private final MqttPushServiceManager a;
  private final MqttConnectionManager b;
  private final Provider<Set<IProvideSubscribeTopics>> c;

  public MqttPushManager(MqttPushServiceManager paramMqttPushServiceManager, MqttConnectionManager paramMqttConnectionManager, Provider<Set<IProvideSubscribeTopics>> paramProvider)
  {
    this.a = paramMqttPushServiceManager;
    this.b = paramMqttConnectionManager;
    this.c = paramProvider;
  }

  public void a()
  {
    HashSet localHashSet = Sets.a();
    Iterator localIterator = ((Set)this.c.b()).iterator();
    while (localIterator.hasNext())
      localHashSet.addAll(((IProvideSubscribeTopics)localIterator.next()).a());
    this.b.a(localHashSet);
    this.a.a(true);
  }

  public void b()
  {
    a();
  }

  public void c()
  {
    this.a.a(false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.MqttPushManager
 * JD-Core Version:    0.6.0
 */