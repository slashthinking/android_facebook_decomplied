package com.facebook.orca.mqtt.serialization;

import com.facebook.orca.mqtt.messages.ConnectPayload;
import com.facebook.orca.mqtt.messages.ConnectPayloadBuilder;
import com.facebook.orca.mqtt.messages.ConnectVariableHeader;
import com.facebook.orca.mqtt.messages.FixedHeader;
import com.facebook.orca.mqtt.messages.SubAckPayload;
import com.facebook.orca.mqtt.messages.SubscribePayload;
import com.facebook.orca.mqtt.messages.SubscribeTopic;
import com.facebook.orca.mqtt.messages.UnsubscribePayload;
import com.google.common.collect.Lists;
import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.List;

class MessageDecoder$PayloadDecoder extends MessageDecoder.BaseDecoder
{
  private Object c;

  MessageDecoder$PayloadDecoder(FixedHeader paramFixedHeader, Object paramObject, int paramInt)
  {
    super(paramFixedHeader, paramInt);
    this.c = paramObject;
  }

  private Object c(DataInputStream paramDataInputStream)
  {
    Object localObject;
    switch (this.a.a())
    {
    case 2:
    case 4:
    case 5:
    case 6:
    case 7:
    default:
      localObject = null;
    case 1:
    case 8:
    case 9:
    case 10:
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
      continue;
      localObject = h(paramDataInputStream);
    }
  }

  private ConnectPayload d(DataInputStream paramDataInputStream)
  {
    ConnectVariableHeader localConnectVariableHeader = (ConnectVariableHeader)this.c;
    String str1 = a(paramDataInputStream);
    String str3;
    String str2;
    if (localConnectVariableHeader.d())
    {
      str3 = a(paramDataInputStream);
      str2 = a(paramDataInputStream);
    }
    while (true)
    {
      String str5;
      String str4;
      if (this.b > 0)
        if (localConnectVariableHeader.b())
        {
          str5 = a(paramDataInputStream);
          boolean bool = localConnectVariableHeader.c();
          str4 = null;
          if (bool)
            str4 = a(paramDataInputStream);
        }
      while (true)
      {
        ConnectPayloadBuilder localConnectPayloadBuilder = new ConnectPayloadBuilder();
        localConnectPayloadBuilder.a(str1);
        localConnectPayloadBuilder.b(str3);
        localConnectPayloadBuilder.c(str2);
        localConnectPayloadBuilder.d(str5);
        localConnectPayloadBuilder.e(str4);
        return localConnectPayloadBuilder.f();
        str5 = null;
        break;
        str4 = null;
        str5 = null;
      }
      str2 = null;
      str3 = null;
    }
  }

  private SubscribePayload e(DataInputStream paramDataInputStream)
  {
    ArrayList localArrayList = Lists.a();
    while (this.b > 0)
    {
      String str = a(paramDataInputStream);
      int i = paramDataInputStream.readUnsignedByte();
      this.b = (-1 + this.b);
      localArrayList.add(new SubscribeTopic(str, i));
    }
    return new SubscribePayload(localArrayList);
  }

  private SubAckPayload f(DataInputStream paramDataInputStream)
  {
    ArrayList localArrayList = Lists.a();
    while (this.b > 0)
    {
      int i = 0xFFFFFFFC & paramDataInputStream.readUnsignedByte();
      this.b = (-1 + this.b);
      localArrayList.add(Integer.valueOf(i));
    }
    return new SubAckPayload(localArrayList);
  }

  private UnsubscribePayload g(DataInputStream paramDataInputStream)
  {
    ArrayList localArrayList = Lists.a();
    while (this.b > 0)
      localArrayList.add(a(paramDataInputStream));
    return new UnsubscribePayload(localArrayList);
  }

  private byte[] h(DataInputStream paramDataInputStream)
  {
    byte[] arrayOfByte = new byte[this.b];
    paramDataInputStream.readFully(arrayOfByte);
    this.b = 0;
    return arrayOfByte;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.serialization.MessageDecoder.PayloadDecoder
 * JD-Core Version:    0.6.0
 */