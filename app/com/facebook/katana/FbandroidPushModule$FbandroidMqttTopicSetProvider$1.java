package com.facebook.katana;

import com.facebook.orca.mqtt.messages.SubscribeTopic;
import com.facebook.orca.push.mqtt.IProvideSubscribeTopics;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Set;

class FbandroidPushModule$FbandroidMqttTopicSetProvider$1
  implements IProvideSubscribeTopics
{
  public Set<SubscribeTopic> a()
  {
    HashSet localHashSet = Sets.a();
    localHashSet.add(new SubscribeTopic("/inbox", 0));
    localHashSet.add(new SubscribeTopic("/mobile_requests_count", 0));
    localHashSet.add(new SubscribeTopic("/friend_requests_seen", 0));
    return localHashSet;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.FbandroidPushModule.FbandroidMqttTopicSetProvider.1
 * JD-Core Version:    0.6.0
 */