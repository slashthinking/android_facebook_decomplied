package com.facebook.orca.mqtt.serialization;

import com.facebook.orca.mqtt.messages.ConnAckMqttMessage;
import com.facebook.orca.mqtt.messages.ConnAckVariableHeader;
import com.facebook.orca.mqtt.messages.ConnectMqttMessage;
import com.facebook.orca.mqtt.messages.ConnectPayload;
import com.facebook.orca.mqtt.messages.ConnectVariableHeader;
import com.facebook.orca.mqtt.messages.FixedHeader;
import com.facebook.orca.mqtt.messages.MessageIdVariableHeader;
import com.facebook.orca.mqtt.messages.MqttMessage;
import com.facebook.orca.mqtt.messages.PubAckMessage;
import com.facebook.orca.mqtt.messages.PublishMqttMessage;
import com.facebook.orca.mqtt.messages.PublishVariableHeader;
import com.facebook.orca.mqtt.messages.SubAckMqttMessage;
import com.facebook.orca.mqtt.messages.SubAckPayload;
import com.facebook.orca.mqtt.messages.SubscribeMqttMessage;
import com.facebook.orca.mqtt.messages.SubscribePayload;
import com.facebook.orca.mqtt.messages.UnsubscribeMqttMessage;
import com.facebook.orca.mqtt.messages.UnsubscribePayload;

public class MessageFactory
{
  public MqttMessage a(FixedHeader paramFixedHeader, Object paramObject1, Object paramObject2)
  {
    Object localObject;
    switch (paramFixedHeader.a())
    {
    case 5:
    case 6:
    case 7:
    case 11:
    case 13:
    default:
      throw new IllegalArgumentException("Unknown message type: " + paramFixedHeader.a());
    case 1:
      localObject = new ConnectMqttMessage(paramFixedHeader, (ConnectVariableHeader)paramObject1, (ConnectPayload)paramObject2);
    case 2:
    case 8:
    case 9:
    case 10:
    case 3:
    case 14:
    case 12:
    case 4:
    }
    while (true)
    {
      return localObject;
      localObject = new ConnAckMqttMessage(paramFixedHeader, (ConnAckVariableHeader)paramObject1);
      continue;
      localObject = new SubscribeMqttMessage(paramFixedHeader, (MessageIdVariableHeader)paramObject1, (SubscribePayload)paramObject2);
      continue;
      localObject = new SubAckMqttMessage(paramFixedHeader, (MessageIdVariableHeader)paramObject1, (SubAckPayload)paramObject2);
      continue;
      localObject = new UnsubscribeMqttMessage(paramFixedHeader, (MessageIdVariableHeader)paramObject1, (UnsubscribePayload)paramObject2);
      continue;
      localObject = new PublishMqttMessage(paramFixedHeader, (PublishVariableHeader)paramObject1, (byte[])(byte[])paramObject2);
      continue;
      localObject = new MqttMessage(paramFixedHeader, null, null);
      continue;
      localObject = new MqttMessage(paramFixedHeader, null, null);
      continue;
      localObject = new PubAckMessage(paramFixedHeader, (MessageIdVariableHeader)paramObject1);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.serialization.MessageFactory
 * JD-Core Version:    0.6.0
 */