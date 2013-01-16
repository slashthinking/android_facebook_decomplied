package com.facebook.katana;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.push.mqtt.IProvideSubscribeTopics;

class FbandroidPushModule$FbandroidMqttTopicSetProvider extends AbstractProvider<IProvideSubscribeTopics>
{
  private FbandroidPushModule$FbandroidMqttTopicSetProvider(FbandroidPushModule paramFbandroidPushModule)
  {
  }

  public IProvideSubscribeTopics a()
  {
    return new FbandroidPushModule.FbandroidMqttTopicSetProvider.1(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.FbandroidPushModule.FbandroidMqttTopicSetProvider
 * JD-Core Version:    0.6.0
 */