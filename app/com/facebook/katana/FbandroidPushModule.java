package com.facebook.katana;

import com.facebook.katana.annotations.ForFbandroidApp;
import com.facebook.katana.orca.FbandroidMqttPushHandler;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.push.mqtt.IProvideSubscribeTopics;
import com.facebook.orca.push.mqtt.MqttPushHandler;
import com.facebook.orca.push.mqtt.MqttTopicList;

public class FbandroidPushModule extends AbstractModule
{
  protected void a()
  {
    a(FbandroidMqttPushHandler.class).a(new FbandroidPushModule.FbandroidPushDataHandlerProvider(this, null)).a();
    c(MqttPushHandler.class).a(FbandroidMqttPushHandler.class);
    a(IProvideSubscribeTopics.class, MqttTopicList.class).a(IProvideSubscribeTopics.class, ForFbandroidApp.class);
    a(IProvideSubscribeTopics.class).a(ForFbandroidApp.class).a(new FbandroidPushModule.FbandroidMqttTopicSetProvider(this, null));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.FbandroidPushModule
 * JD-Core Version:    0.6.0
 */