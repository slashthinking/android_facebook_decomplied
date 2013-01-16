package com.facebook.orca.mqtt.messages;

public class SubscribeMqttMessage extends MqttMessage
{
  public SubscribeMqttMessage(FixedHeader paramFixedHeader, MessageIdVariableHeader paramMessageIdVariableHeader, SubscribePayload paramSubscribePayload)
  {
    super(paramFixedHeader, paramMessageIdVariableHeader, paramSubscribePayload);
  }

  public MessageIdVariableHeader a()
  {
    return (MessageIdVariableHeader)super.b();
  }

  public SubscribePayload c()
  {
    return (SubscribePayload)super.d();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.messages.SubscribeMqttMessage
 * JD-Core Version:    0.6.0
 */