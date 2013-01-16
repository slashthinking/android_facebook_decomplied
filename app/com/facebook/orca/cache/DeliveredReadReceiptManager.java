package com.facebook.orca.cache;

import android.os.Bundle;
import com.facebook.orca.app.OrcaActivityBroadcaster;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.mqtt.MqttQOSLevel;
import com.facebook.orca.ops.OrcaServiceOperation;
import com.facebook.orca.push.mqtt.MqttConnectionManager;
import com.facebook.orca.server.DeliveredReceiptParams;
import com.facebook.orca.server.ReadReceiptParams;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.users.UserKey;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.inject.Provider;

public class DeliveredReadReceiptManager
{
  private final OrcaActivityBroadcaster a;
  private final Provider<OrcaServiceOperation> b;
  private final DataCache c;
  private final MqttConnectionManager d;

  public DeliveredReadReceiptManager(OrcaActivityBroadcaster paramOrcaActivityBroadcaster, Provider<OrcaServiceOperation> paramProvider, DataCache paramDataCache, MqttConnectionManager paramMqttConnectionManager)
  {
    this.a = paramOrcaActivityBroadcaster;
    this.b = paramProvider;
    this.c = paramDataCache;
    this.d = paramMqttConnectionManager;
  }

  private OrcaServiceOperation a()
  {
    OrcaServiceOperation localOrcaServiceOperation = (OrcaServiceOperation)this.b.b();
    localOrcaServiceOperation.c(true);
    return localOrcaServiceOperation;
  }

  public void a(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.f() == null) || (paramMessage.f().e() == null) || (paramMessage.f().e().equals(this.c.b())));
    while (true)
    {
      return;
      ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
      localObjectNode.put("msg_sender_id", paramMessage.f().e().b());
      localObjectNode.put("mid", paramMessage.a());
      localObjectNode.put("tid", paramMessage.b());
      this.d.a("/send_delivery_receipt", localObjectNode, MqttQOSLevel.FIRE_AND_FORGET);
    }
  }

  public void a(UserKey paramUserKey, String paramString, long paramLong)
  {
    ThreadSummary localThreadSummary;
    if (StringUtil.a(paramString))
    {
      localThreadSummary = this.c.c(paramUserKey);
      if (localThreadSummary != null)
        break label36;
    }
    while (true)
    {
      return;
      localThreadSummary = this.c.b(paramString);
      break;
      label36: OrcaServiceOperation localOrcaServiceOperation = a();
      ReadReceiptParams localReadReceiptParams = new ReadReceiptParams(localThreadSummary.a(), paramUserKey, paramLong);
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("readReceiptParams", localReadReceiptParams);
      localOrcaServiceOperation.a("read_receipt", localBundle);
    }
  }

  public void a(UserKey paramUserKey, String paramString1, String paramString2)
  {
    ThreadSummary localThreadSummary;
    if (StringUtil.a(paramString1))
    {
      localThreadSummary = this.c.c(paramUserKey);
      if (localThreadSummary != null)
        break label36;
    }
    while (true)
    {
      return;
      localThreadSummary = this.c.b(paramString1);
      break;
      label36: OrcaServiceOperation localOrcaServiceOperation = a();
      DeliveredReceiptParams localDeliveredReceiptParams = new DeliveredReceiptParams(localThreadSummary.a(), paramUserKey, paramString2);
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("deliveredReceiptParms", localDeliveredReceiptParams);
      localOrcaServiceOperation.a("delivered_receipt", localBundle);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.cache.DeliveredReadReceiptManager
 * JD-Core Version:    0.6.0
 */