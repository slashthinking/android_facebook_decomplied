package com.facebook.orca.mqtt.serialization;

import com.facebook.orca.mqtt.messages.FixedHeader;
import com.facebook.orca.mqtt.messages.FixedHeaderBuilder;
import com.facebook.orca.mqtt.messages.MqttMessage;
import com.google.common.base.Preconditions;
import java.io.DataInputStream;
import java.io.IOException;

public class MessageDecoder
{
  private final MessageFactory a;
  private DataInputStream b;

  public MessageDecoder(MessageFactory paramMessageFactory)
  {
    this.a = paramMessageFactory;
  }

  private FixedHeader b()
  {
    int i = 1;
    int j = 0;
    int k = this.b.readUnsignedByte();
    int m = k >> 4;
    int n;
    int i2;
    int i3;
    if ((k & 0x8) == 8)
    {
      n = i;
      i2 = (k & 0x6) >> 1;
      if ((k & 0x1) == 0)
        break label140;
      i3 = i;
    }
    while (true)
    {
      int i5 = this.b.readUnsignedByte();
      j += i * (i5 & 0x7F);
      i *= 128;
      if ((i5 & 0x80) != 0)
        continue;
      FixedHeaderBuilder localFixedHeaderBuilder = new FixedHeaderBuilder();
      localFixedHeaderBuilder.a(m);
      localFixedHeaderBuilder.a(n);
      localFixedHeaderBuilder.b(i2);
      localFixedHeaderBuilder.b(i3);
      localFixedHeaderBuilder.c(j);
      return localFixedHeaderBuilder.f();
      int i1 = 0;
      break;
      label140: int i4 = 0;
      j = 0;
    }
  }

  public MqttMessage a()
  {
    monitorenter;
    FixedHeader localFixedHeader;
    Object localObject2;
    Object localObject3;
    while (true)
    {
      try
      {
        if (this.b != null)
        {
          bool = true;
          Preconditions.checkArgument(bool, "Stream not initialized");
          localFixedHeader = b();
          MessageDecoder.VariableHeaderDecoder localVariableHeaderDecoder = new MessageDecoder.VariableHeaderDecoder(localFixedHeader, localFixedHeader.e());
          localObject2 = MessageDecoder.VariableHeaderDecoder.a(localVariableHeaderDecoder, this.b);
          MessageDecoder.PayloadDecoder localPayloadDecoder = new MessageDecoder.PayloadDecoder(localFixedHeader, localObject2, localVariableHeaderDecoder.b);
          localObject3 = MessageDecoder.PayloadDecoder.a(localPayloadDecoder, this.b);
          if (localPayloadDecoder.b == 0)
            break;
          throw new IOException("Unexpected bytes remaining in payload");
        }
      }
      finally
      {
        monitorexit;
      }
      boolean bool = false;
    }
    MqttMessage localMqttMessage = this.a.a(localFixedHeader, localObject2, localObject3);
    monitorexit;
    return localMqttMessage;
  }

  public void a(DataInputStream paramDataInputStream)
  {
    this.b = paramDataInputStream;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.serialization.MessageDecoder
 * JD-Core Version:    0.6.0
 */