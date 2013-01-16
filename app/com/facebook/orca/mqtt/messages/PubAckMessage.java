package com.facebook.orca.mqtt.messages;

public class PubAckMessage extends MqttMessage
{
  public PubAckMessage(FixedHeader paramFixedHeader, MessageIdVariableHeader paramMessageIdVariableHeader)
  {
    super(paramFixedHeader, paramMessageIdVariableHeader, null);
  }

  public MessageIdVariableHeader a()
  {
    return (MessageIdVariableHeader)super.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.messages.PubAckMessage
 * JD-Core Version:    0.6.0
 */