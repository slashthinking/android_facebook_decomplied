package com.facebook.orca.mqtt.messages;

public class SubAckMqttMessage extends MqttMessage
{
  public SubAckMqttMessage(FixedHeader paramFixedHeader, MessageIdVariableHeader paramMessageIdVariableHeader, SubAckPayload paramSubAckPayload)
  {
    super(paramFixedHeader, paramMessageIdVariableHeader, paramSubAckPayload);
  }

  public MessageIdVariableHeader a()
  {
    return (MessageIdVariableHeader)super.b();
  }

  public SubAckPayload c()
  {
    return (SubAckPayload)super.d();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.messages.SubAckMqttMessage
 * JD-Core Version:    0.6.0
 */