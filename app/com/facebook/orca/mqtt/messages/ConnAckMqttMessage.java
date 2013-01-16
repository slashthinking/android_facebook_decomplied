package com.facebook.orca.mqtt.messages;

public class ConnAckMqttMessage extends MqttMessage
{
  public ConnAckMqttMessage(FixedHeader paramFixedHeader, ConnAckVariableHeader paramConnAckVariableHeader)
  {
    super(paramFixedHeader, paramConnAckVariableHeader, null);
  }

  public ConnAckVariableHeader a()
  {
    return (ConnAckVariableHeader)super.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.messages.ConnAckMqttMessage
 * JD-Core Version:    0.6.0
 */