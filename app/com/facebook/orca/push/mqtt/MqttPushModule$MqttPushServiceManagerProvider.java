package com.facebook.orca.push.mqtt;

import com.facebook.app.UserActivityManager;
import com.facebook.orca.annotations.MeUserId;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.push.annotations.IsPersistentPushServiceEnabledForApp;
import com.facebook.orca.push.annotations.IsPersistentPushServiceEnabledForUser;

class MqttPushModule$MqttPushServiceManagerProvider extends AbstractProvider<MqttPushServiceManager>
{
  private MqttPushModule$MqttPushServiceManagerProvider(MqttPushModule paramMqttPushModule)
  {
  }

  public MqttPushServiceManager a()
  {
    return new MqttPushServiceManager(MqttPushModule.a(this.a), (UserActivityManager)b(UserActivityManager.class), a(String.class, MeUserId.class), a(Boolean.class, IsPersistentPushServiceEnabledForUser.class), a(Boolean.class, IsPersistentPushServiceEnabledForApp.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.MqttPushModule.MqttPushServiceManagerProvider
 * JD-Core Version:    0.6.0
 */