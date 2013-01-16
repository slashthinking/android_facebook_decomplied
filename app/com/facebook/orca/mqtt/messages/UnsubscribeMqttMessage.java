package com.facebook.orca.mqtt.messages;

public class UnsubscribeMqttMessage extends MqttMessage
{
  public UnsubscribeMqttMessage(FixedHeader paramFixedHeader, MessageIdVariableHeader paramMessageIdVariableHeader, UnsubscribePayload paramUnsubscribePayload)
  {
    super(paramFixedHeader, paramMessageIdVariableHeader, paramUnsubscribePayload);
  }

  public MessageIdVariableHeader a()
  {
    return (MessageIdVariableHeader)super.b();
  }

  public UnsubscribePayload c()
  {
    return (UnsubscribePayload)super.d();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.messages.UnsubscribeMqttMessage
 * JD-Core Version:    0.6.0
 */