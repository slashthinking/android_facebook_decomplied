package com.facebook.orca.mqtt.messages;

public class ConnectMqttMessage extends MqttMessage
{
  public ConnectMqttMessage(FixedHeader paramFixedHeader, ConnectVariableHeader paramConnectVariableHeader, ConnectPayload paramConnectPayload)
  {
    super(paramFixedHeader, paramConnectVariableHeader, paramConnectPayload);
  }

  public ConnectVariableHeader a()
  {
    return (ConnectVariableHeader)super.b();
  }

  public ConnectPayload c()
  {
    return (ConnectPayload)super.d();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.messages.ConnectMqttMessage
 * JD-Core Version:    0.6.0
 */