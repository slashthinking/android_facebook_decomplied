package com.facebook.orca.push.mqtt;

import com.facebook.orca.annotations.IsDeliveredReadReceiptEnabled;
import com.facebook.orca.annotations.IsPresenceEnabled;
import com.facebook.orca.annotations.IsVoipEnabledForUser;
import com.facebook.orca.inject.AbstractProvider;

class OrcaMqttPushModule$OrcaMqttTopicsSetProviderProvider extends AbstractProvider<OrcaMqttTopicsSetProvider>
{
  private OrcaMqttPushModule$OrcaMqttTopicsSetProviderProvider(OrcaMqttPushModule paramOrcaMqttPushModule)
  {
  }

  public OrcaMqttTopicsSetProvider a()
  {
    return new OrcaMqttTopicsSetProvider(a(Boolean.class, IsPresenceEnabled.class), a(Boolean.class, IsDeliveredReadReceiptEnabled.class), a(Boolean.class, IsVoipEnabledForUser.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.OrcaMqttPushModule.OrcaMqttTopicsSetProviderProvider
 * JD-Core Version:    0.6.0
 */