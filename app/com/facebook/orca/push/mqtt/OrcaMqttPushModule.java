package com.facebook.orca.push.mqtt;

import android.content.Context;
import com.facebook.orca.annotations.ForMessages;
import com.facebook.orca.config.MqttConfig;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.MultiBinding;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.facebook.orca.push.annotations.IsPersistentPushServiceEnabledForApp;
import com.facebook.orca.push.annotations.IsPersistentPushServiceEnabledForUser;

public class OrcaMqttPushModule extends AbstractModule
{
  private Context a;

  public OrcaMqttPushModule(Context paramContext)
  {
    this.a = paramContext;
  }

  protected void a()
  {
    a(MqttConfig.class).a(new OrcaMqttPushModule.OrcaMqttConfigProvider(this, null));
    a(Boolean.class).a(IsPersistentPushServiceEnabledForUser.class).c(IsPersistentPushServiceEnabledForUserProvider.class);
    a(Boolean.class).a(IsPersistentPushServiceEnabledForApp.class).a(Boolean.valueOf(false));
    a(OrcaMqttPushHandler.class).a(new OrcaMqttPushModule.OrcaMqttPushHandlerProvider(this, null)).a();
    c(MqttPushHandler.class).a(OrcaMqttPushHandler.class);
    a(IProvideSubscribeTopics.class, MqttTopicList.class).a(IProvideSubscribeTopics.class, ForMessages.class);
    a(IProvideSubscribeTopics.class).a(ForMessages.class).a(new OrcaMqttPushModule.OrcaMqttTopicsSetProviderProvider(this, null)).a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.OrcaMqttPushModule
 * JD-Core Version:    0.6.0
 */