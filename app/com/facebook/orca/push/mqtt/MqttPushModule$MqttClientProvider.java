package com.facebook.orca.push.mqtt;

import com.facebook.app.UserActivityManager;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.orca.annotations.UserAgentString;
import com.facebook.orca.auth.UserTokenCredentials;
import com.facebook.orca.config.MqttConfig;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.mqtt.MqttClient;
import com.facebook.orca.mqtt.MqttParameters;
import com.facebook.orca.mqtt.MqttSsl;
import com.facebook.orca.push.annotations.IsMobileOnlineAvailabilityEnabled;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

class MqttPushModule$MqttClientProvider extends AbstractProvider<MqttClient>
{
  private MqttPushModule$MqttClientProvider(MqttPushModule paramMqttPushModule)
  {
  }

  public MqttClient a()
  {
    MqttConfig localMqttConfig = (MqttConfig)b(MqttConfig.class);
    MqttClient localMqttClient;
    if (localMqttConfig == null)
      localMqttClient = null;
    while (true)
    {
      return localMqttClient;
      UserTokenCredentials localUserTokenCredentials = (UserTokenCredentials)b(UserTokenCredentials.class);
      if (localUserTokenCredentials == null)
      {
        localMqttClient = null;
        continue;
      }
      UniqueIdForDeviceHolder localUniqueIdForDeviceHolder = (UniqueIdForDeviceHolder)b(UniqueIdForDeviceHolder.class);
      String str = localUniqueIdForDeviceHolder.c();
      if (str == null)
      {
        localMqttClient = null;
        continue;
      }
      boolean bool1 = ((UserActivityManager)b(UserActivityManager.class)).b(10000L);
      boolean bool2 = ((Boolean)b(Boolean.class, IsMobileOnlineAvailabilityEnabled.class)).booleanValue();
      ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
      localObjectNode.put("make_user_available_when_in_foreground", bool2);
      localObjectNode.put("no_automatic_foreground", true);
      localObjectNode.put("device_id", localUniqueIdForDeviceHolder.b());
      localObjectNode.put("initial_foreground_state", bool1);
      localMqttClient = new MqttClient((MqttSsl)b(MqttSsl.class), new MqttParameters(localMqttConfig.a(), localMqttConfig.b(), localMqttConfig.c(), str, localUserTokenCredentials.a(), localUserTokenCredentials.b(), (String)b(String.class, UserAgentString.class), (short)(60 * localMqttConfig.d()), localObjectNode));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.MqttPushModule.MqttClientProvider
 * JD-Core Version:    0.6.0
 */