package com.facebook.orca.mqtt.messages;

public class PublishMqttMessage extends MqttMessage
{
  public PublishMqttMessage(FixedHeader paramFixedHeader, PublishVariableHeader paramPublishVariableHeader, byte[] paramArrayOfByte)
  {
    super(paramFixedHeader, paramPublishVariableHeader, paramArrayOfByte);
  }

  public PublishVariableHeader a()
  {
    return (PublishVariableHeader)super.b();
  }

  public byte[] c()
  {
    return (byte[])(byte[])super.d();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.messages.PublishMqttMessage
 * JD-Core Version:    0.6.0
 */