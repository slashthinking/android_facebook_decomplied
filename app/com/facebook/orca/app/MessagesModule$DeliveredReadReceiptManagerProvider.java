package com.facebook.orca.app;

import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.cache.DeliveredReadReceiptManager;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperation;
import com.facebook.orca.push.mqtt.MqttConnectionManager;

class MessagesModule$DeliveredReadReceiptManagerProvider extends AbstractProvider<DeliveredReadReceiptManager>
{
  private MessagesModule$DeliveredReadReceiptManagerProvider(MessagesModule paramMessagesModule)
  {
  }

  public DeliveredReadReceiptManager a()
  {
    return new DeliveredReadReceiptManager((OrcaActivityBroadcaster)b(OrcaActivityBroadcaster.class), a(OrcaServiceOperation.class, FromApplication.class), (DataCache)b(DataCache.class), (MqttConnectionManager)b(MqttConnectionManager.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.DeliveredReadReceiptManagerProvider
 * JD-Core Version:    0.6.0
 */