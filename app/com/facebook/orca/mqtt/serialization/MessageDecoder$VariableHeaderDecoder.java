package com.facebook.orca.mqtt.serialization;

import com.facebook.orca.mqtt.messages.ConnAckVariableHeader;
import com.facebook.orca.mqtt.messages.ConnectVariableHeader;
import com.facebook.orca.mqtt.messages.ConnectVariableHeaderBuilder;
import com.facebook.orca.mqtt.messages.FixedHeader;
import com.facebook.orca.mqtt.messages.MessageIdVariableHeader;
import com.facebook.orca.mqtt.messages.PublishVariableHeader;
import java.io.DataInputStream;
import java.io.IOException;

class MessageDecoder$VariableHeaderDecoder extends MessageDecoder.BaseDecoder
{
  MessageDecoder$VariableHeaderDecoder(FixedHeader paramFixedHeader, int paramInt)
  {
    super(paramFixedHeader, paramInt);
  }

  private Object c(DataInputStream paramDataInputStream)
  {
    Object localObject;
    switch (this.a.a())
    {
    case 5:
    case 6:
    case 7:
    default:
      localObject = null;
    case 1:
    case 2:
    case 4:
    case 8:
    case 9:
    case 10:
    case 11:
    case 3:
    }
    while (true)
    {
      return localObject;
      localObject = d(paramDataInputStream);
      continue;
      localObject = e(paramDataInputStream);
      continue;
      localObject = f(paramDataInputStream);
      continue;
      localObject = g(paramDataInputStream);
    }
  }

  private ConnectVariableHeader d(DataInputStream paramDataInputStream)
  {
    boolean bool1 = true;
    if (!"MQIsdp".equals(a(paramDataInputStream)))
    {
      paramDataInputStream.close();
      throw new IOException("Invalid input - missing header");
    }
    int i = paramDataInputStream.readByte();
    int j = paramDataInputStream.readUnsignedByte();
    this.b = (-2 + this.b);
    int k = b(paramDataInputStream);
    ConnectVariableHeaderBuilder localConnectVariableHeaderBuilder = new ConnectVariableHeaderBuilder();
    localConnectVariableHeaderBuilder.a(i);
    boolean bool2;
    boolean bool3;
    label110: boolean bool4;
    label131: boolean bool5;
    if ((j & 0x80) == 128)
    {
      bool2 = bool1;
      localConnectVariableHeaderBuilder.a(bool2);
      if ((j & 0x40) != 64)
        break label206;
      bool3 = bool1;
      localConnectVariableHeaderBuilder.b(bool3);
      if ((j & 0x20) != 32)
        break label212;
      bool4 = bool1;
      localConnectVariableHeaderBuilder.d(bool4);
      localConnectVariableHeaderBuilder.b((j & 0x18) >> 3);
      if ((j & 0x4) != 4)
        break label218;
      bool5 = bool1;
      label163: localConnectVariableHeaderBuilder.c(bool5);
      if ((j & 0x2) != 2)
        break label224;
    }
    while (true)
    {
      localConnectVariableHeaderBuilder.e(bool1);
      localConnectVariableHeaderBuilder.c(k);
      return localConnectVariableHeaderBuilder.i();
      bool2 = false;
      break;
      label206: bool3 = false;
      break label110;
      label212: bool4 = false;
      break label131;
      label218: bool5 = false;
      break label163;
      label224: bool1 = false;
    }
  }

  private ConnAckVariableHeader e(DataInputStream paramDataInputStream)
  {
    paramDataInputStream.readUnsignedByte();
    byte b = paramDataInputStream.readByte();
    this.b = (-2 + this.b);
    return new ConnAckVariableHeader(b);
  }

  private MessageIdVariableHeader f(DataInputStream paramDataInputStream)
  {
    return new MessageIdVariableHeader(b(paramDataInputStream));
  }

  private PublishVariableHeader g(DataInputStream paramDataInputStream)
  {
    String str = a(paramDataInputStream);
    int i = -1;
    if (this.a.c() > 0)
      i = b(paramDataInputStream);
    return new PublishVariableHeader(str, i);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.serialization.MessageDecoder.VariableHeaderDecoder
 * JD-Core Version:    0.6.0
 */