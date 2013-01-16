package com.facebook.orca.push.mqtt;

import com.facebook.orca.mqtt.messages.SubscribeTopic;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Provider;

class OrcaMqttTopicsSetProvider
  implements IProvideSubscribeTopics
{
  private Provider<Boolean> a;
  private Provider<Boolean> b;
  private Provider<Boolean> c;

  OrcaMqttTopicsSetProvider(Provider<Boolean> paramProvider1, Provider<Boolean> paramProvider2, Provider<Boolean> paramProvider3)
  {
    this.a = paramProvider1;
    this.b = paramProvider2;
    this.c = paramProvider3;
  }

  public Set<SubscribeTopic> a()
  {
    HashSet localHashSet = Sets.a();
    localHashSet.add(new SubscribeTopic("/orca_message_notifications", 0));
    if (((Boolean)this.a.b()).booleanValue())
    {
      localHashSet.add(new SubscribeTopic("/orca_typing_notifications", 0));
      localHashSet.add(new SubscribeTopic("/orca_presence", 0));
    }
    if (((Boolean)this.b.b()).booleanValue())
      localHashSet.add(new SubscribeTopic("/messaging_events", 0));
    localHashSet.add(new SubscribeTopic("/push_notification", 0));
    if (((Boolean)this.c.b()).booleanValue())
    {
      localHashSet.add(new SubscribeTopic("/webrtc", 0));
      localHashSet.add(new SubscribeTopic("/webrtc_response", 0));
    }
    return localHashSet;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.OrcaMqttTopicsSetProvider
 * JD-Core Version:    0.6.0
 */