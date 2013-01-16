package com.facebook.orca.push.mqtt;

import com.facebook.analytics.ReliabilityAnalyticsLogger;
import com.facebook.orca.cache.DeliveredReadReceiptManager;
import com.facebook.orca.fbwebrtc.WebrtcManager;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.presence.PresenceManager;
import com.facebook.orca.push.PushHandler;
import com.facebook.orca.push.c2dm.C2DMRegistrar;
import com.facebook.orca.push.c2dm.PushTokenHolder;
import com.facebook.orca.push.common.PushDeserialization;
import com.fasterxml.jackson.databind.ObjectMapper;

class OrcaMqttPushModule$OrcaMqttPushHandlerProvider extends AbstractProvider<OrcaMqttPushHandler>
{
  private OrcaMqttPushModule$OrcaMqttPushHandlerProvider(OrcaMqttPushModule paramOrcaMqttPushModule)
  {
  }

  public OrcaMqttPushHandler a()
  {
    return new OrcaMqttPushHandler(c(PushHandler.class), (PushDeserialization)b(PushDeserialization.class), (DeliveredReadReceiptManager)b(DeliveredReadReceiptManager.class), (PresenceManager)b(PresenceManager.class), (MqttConnectionManager)b(MqttConnectionManager.class), (C2DMRegistrar)b(C2DMRegistrar.class), (PushTokenHolder)b(PushTokenHolder.class), (ReliabilityAnalyticsLogger)b(ReliabilityAnalyticsLogger.class), (ObjectMapper)b(ObjectMapper.class), (WebrtcManager)b(WebrtcManager.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.OrcaMqttPushModule.OrcaMqttPushHandlerProvider
 * JD-Core Version:    0.6.0
 */