package com.facebook.orca.protocol.methods;

import android.content.Context;
import com.facebook.orca.push.common.PushDeserialization;
import com.facebook.orca.push.mqtt.MqttConnectionManager;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.NewMessageResult;
import com.facebook.orca.threads.Message;
import com.facebook.orca.users.UserKey;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class SendViaChatHandler
{
  private final Context a;
  private final MqttConnectionManager b;
  private final PushDeserialization c;
  private final SendMessageParameterHelper d;
  private final ObjectMapper e;

  public SendViaChatHandler(Context paramContext, MqttConnectionManager paramMqttConnectionManager, PushDeserialization paramPushDeserialization, SendMessageParameterHelper paramSendMessageParameterHelper, ObjectMapper paramObjectMapper)
  {
    this.a = paramContext;
    this.b = paramMqttConnectionManager;
    this.c = paramPushDeserialization;
    this.d = paramSendMessageParameterHelper;
    this.e = paramObjectMapper;
  }

  public NewMessageResult a(Message paramMessage, UserKey paramUserKey)
  {
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    if (paramUserKey != null);
    long l1;
    SendViaChatHandler.MyPublishListener localMyPublishListener;
    long l2;
    for (String str = paramUserKey.b(); ; str = paramMessage.b())
    {
      localObjectNode.put("to", str);
      localObjectNode.put("body", paramMessage.h());
      l1 = Long.parseLong(paramMessage.t());
      localObjectNode.put("msgid", l1);
      if (paramMessage.o())
        localObjectNode.put("coordinates", this.d.a(paramMessage));
      localMyPublishListener = new SendViaChatHandler.MyPublishListener(this, l1);
      localMyPublishListener.a();
      try
      {
        l2 = 5000L + System.currentTimeMillis();
        if (this.b.a("/send_message2", localObjectNode, 5000L))
          break;
        throw new Exception("Failed to send via MQTT (publish failed)");
      }
      finally
      {
        localMyPublishListener.b();
      }
    }
    long l3 = l2 - System.currentTimeMillis();
    if (l3 < 0L)
      throw new Exception("Failed to send via MQTT (timed out after publish)");
    if (!localMyPublishListener.a(l3))
      throw new Exception("Failed to send via MQTT (timed out waiting for response)");
    if (!SendViaChatHandler.MyPublishListener.a(localMyPublishListener))
      throw new Exception("Failed to send via MQTT (server returned failure");
    localMyPublishListener.b();
    Message localMessage = this.c.a(0, paramMessage.b(), Long.toString(l1), paramMessage.h(), -1L, paramMessage.e(), paramMessage.k(), null);
    return new NewMessageResult(DataFreshnessResult.FROM_SERVER, paramMessage.b(), localMessage, null, System.currentTimeMillis());
  }

  public boolean a(Message paramMessage)
  {
    if ((this.b.g()) && (!paramMessage.z()));
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.SendViaChatHandler
 * JD-Core Version:    0.6.0
 */