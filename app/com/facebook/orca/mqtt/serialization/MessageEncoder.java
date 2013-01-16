package com.facebook.orca.mqtt.serialization;

import com.facebook.orca.mqtt.messages.ConnAckMqttMessage;
import com.facebook.orca.mqtt.messages.ConnAckVariableHeader;
import com.facebook.orca.mqtt.messages.ConnectMqttMessage;
import com.facebook.orca.mqtt.messages.ConnectPayload;
import com.facebook.orca.mqtt.messages.ConnectVariableHeader;
import com.facebook.orca.mqtt.messages.FixedHeader;
import com.facebook.orca.mqtt.messages.MessageIdVariableHeader;
import com.facebook.orca.mqtt.messages.MqttMessage;
import com.facebook.orca.mqtt.messages.PublishMqttMessage;
import com.facebook.orca.mqtt.messages.PublishVariableHeader;
import com.facebook.orca.mqtt.messages.SubAckMqttMessage;
import com.facebook.orca.mqtt.messages.SubAckPayload;
import com.facebook.orca.mqtt.messages.SubscribeMqttMessage;
import com.facebook.orca.mqtt.messages.SubscribePayload;
import com.facebook.orca.mqtt.messages.SubscribeTopic;
import com.facebook.orca.mqtt.messages.UnsubAckMqttMessage;
import com.facebook.orca.mqtt.messages.UnsubscribeMqttMessage;
import com.facebook.orca.mqtt.messages.UnsubscribePayload;
import com.google.common.collect.ImmutableList;
import java.io.DataOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

public class MessageEncoder
{
  private DataOutputStream a;

  private int a(ConnectVariableHeader paramConnectVariableHeader)
  {
    boolean bool = paramConnectVariableHeader.b();
    int i = 0;
    if (bool)
      i = 128;
    if (paramConnectVariableHeader.c())
      i |= 64;
    if (paramConnectVariableHeader.e())
      i |= 32;
    int j = i | (0x3 & paramConnectVariableHeader.f()) << 3;
    if (paramConnectVariableHeader.d())
      j |= 4;
    if (paramConnectVariableHeader.g())
      j |= 2;
    return j;
  }

  private int a(FixedHeader paramFixedHeader)
  {
    int i = 0x0 | paramFixedHeader.a() << 4;
    if (paramFixedHeader.b())
      i |= 8;
    int j = i | paramFixedHeader.c() << 1;
    if (paramFixedHeader.d())
      j |= 1;
    return j;
  }

  private void a(int paramInt)
  {
    do
    {
      int i = paramInt % 128;
      paramInt /= 128;
      if (paramInt > 0)
        i |= 128;
      this.a.writeByte(i);
    }
    while (paramInt > 0);
  }

  private void a(ConnAckMqttMessage paramConnAckMqttMessage)
  {
    this.a.writeByte(a(paramConnAckMqttMessage.f()));
    this.a.writeByte(2);
    this.a.writeByte(0);
    this.a.writeByte(paramConnAckMqttMessage.a().a());
    this.a.flush();
  }

  private void a(ConnectMqttMessage paramConnectMqttMessage)
  {
    FixedHeader localFixedHeader = paramConnectMqttMessage.f();
    ConnectVariableHeader localConnectVariableHeader = paramConnectMqttMessage.a();
    ConnectPayload localConnectPayload = paramConnectMqttMessage.c();
    byte[] arrayOfByte1 = a(localConnectPayload.a());
    int i = 0 + (2 + arrayOfByte1.length);
    String str1 = localConnectPayload.b();
    byte[] arrayOfByte2;
    byte[] arrayOfByte3;
    label76: byte[] arrayOfByte4;
    label119: String str4;
    if (str1 != null)
    {
      arrayOfByte2 = a(str1);
      String str2 = localConnectPayload.c();
      if (str2 == null)
        break label455;
      arrayOfByte3 = a(str2);
      if (localConnectVariableHeader.d())
        i = i + (2 + arrayOfByte2.length) + (2 + arrayOfByte3.length);
      String str3 = localConnectPayload.d();
      if (str3 == null)
        break label463;
      arrayOfByte4 = a(str3);
      if (localConnectVariableHeader.b())
        i += 2 + arrayOfByte4.length;
      str4 = localConnectPayload.e();
      if (str4 == null)
        break label471;
    }
    label455: label463: label471: for (byte[] arrayOfByte5 = a(str4); ; arrayOfByte5 = new byte[0])
    {
      if (localConnectVariableHeader.c())
        i += 2 + arrayOfByte5.length;
      int j = i + 12;
      this.a.writeByte(a(localFixedHeader));
      a(j);
      this.a.writeByte(0);
      this.a.writeByte(6);
      this.a.writeByte(77);
      this.a.writeByte(81);
      this.a.writeByte(73);
      this.a.writeByte(115);
      this.a.writeByte(100);
      this.a.writeByte(112);
      this.a.write(localConnectVariableHeader.a());
      this.a.write(a(localConnectVariableHeader));
      this.a.writeShort(localConnectVariableHeader.h());
      this.a.writeShort(arrayOfByte1.length);
      this.a.write(arrayOfByte1, 0, arrayOfByte1.length);
      if (localConnectVariableHeader.d())
      {
        this.a.writeShort(arrayOfByte2.length);
        this.a.write(arrayOfByte2, 0, arrayOfByte2.length);
        this.a.writeShort(arrayOfByte3.length);
        this.a.write(arrayOfByte3, 0, arrayOfByte3.length);
      }
      if (localConnectVariableHeader.b())
      {
        this.a.writeShort(arrayOfByte4.length);
        this.a.write(arrayOfByte4, 0, arrayOfByte4.length);
      }
      if (localConnectVariableHeader.c())
      {
        this.a.writeShort(arrayOfByte5.length);
        this.a.write(arrayOfByte5, 0, arrayOfByte5.length);
      }
      this.a.flush();
      return;
      arrayOfByte2 = new byte[0];
      break;
      arrayOfByte3 = new byte[0];
      break label76;
      arrayOfByte4 = new byte[0];
      break label119;
    }
  }

  private void a(PublishMqttMessage paramPublishMqttMessage)
  {
    FixedHeader localFixedHeader = paramPublishMqttMessage.f();
    PublishVariableHeader localPublishVariableHeader = paramPublishMqttMessage.a();
    byte[] arrayOfByte1 = paramPublishMqttMessage.c();
    byte[] arrayOfByte2 = a(localPublishVariableHeader.a());
    int i = 2 + arrayOfByte2.length;
    if (localFixedHeader.c() > 0);
    for (int j = 2; ; j = 0)
    {
      int k = j + i + arrayOfByte1.length;
      this.a.writeByte(a(localFixedHeader));
      a(k);
      this.a.writeShort(arrayOfByte2.length);
      this.a.write(arrayOfByte2, 0, arrayOfByte2.length);
      if (localFixedHeader.c() > 0)
        this.a.writeShort(localPublishVariableHeader.b());
      this.a.write(arrayOfByte1, 0, arrayOfByte1.length);
      this.a.flush();
      return;
    }
  }

  private void a(SubAckMqttMessage paramSubAckMqttMessage)
  {
    int i = 2 + paramSubAckMqttMessage.c().a().size();
    (1 + b(i));
    this.a.writeByte(a(paramSubAckMqttMessage.f()));
    a(i);
    this.a.writeShort(paramSubAckMqttMessage.a().a());
    Iterator localIterator = paramSubAckMqttMessage.c().a().iterator();
    while (localIterator.hasNext())
    {
      int j = ((Integer)localIterator.next()).intValue();
      this.a.writeByte(j);
    }
    this.a.flush();
  }

  private void a(SubscribeMqttMessage paramSubscribeMqttMessage)
  {
    FixedHeader localFixedHeader = paramSubscribeMqttMessage.f();
    MessageIdVariableHeader localMessageIdVariableHeader = paramSubscribeMqttMessage.a();
    SubscribePayload localSubscribePayload = paramSubscribeMqttMessage.c();
    Iterator localIterator1 = localSubscribePayload.a().iterator();
    for (int i = 0; localIterator1.hasNext(); i = 1 + (i + (2 + a(((SubscribeTopic)localIterator1.next()).a()).length)));
    int j = 2 + i;
    this.a.writeByte(a(localFixedHeader));
    a(j);
    int k = localMessageIdVariableHeader.a();
    this.a.writeShort(k);
    Iterator localIterator2 = localSubscribePayload.a().iterator();
    while (localIterator2.hasNext())
    {
      SubscribeTopic localSubscribeTopic = (SubscribeTopic)localIterator2.next();
      byte[] arrayOfByte = a(localSubscribeTopic.a());
      this.a.writeShort(arrayOfByte.length);
      this.a.write(arrayOfByte, 0, arrayOfByte.length);
      this.a.write(localSubscribeTopic.b());
    }
    this.a.flush();
  }

  private void a(UnsubAckMqttMessage paramUnsubAckMqttMessage)
  {
    (1 + b(2));
    this.a.writeByte(a(paramUnsubAckMqttMessage.f()));
    a(2);
    this.a.writeShort(paramUnsubAckMqttMessage.a().a());
    this.a.flush();
  }

  private void a(UnsubscribeMqttMessage paramUnsubscribeMqttMessage)
  {
    FixedHeader localFixedHeader = paramUnsubscribeMqttMessage.f();
    MessageIdVariableHeader localMessageIdVariableHeader = paramUnsubscribeMqttMessage.a();
    UnsubscribePayload localUnsubscribePayload = paramUnsubscribeMqttMessage.c();
    Iterator localIterator1 = localUnsubscribePayload.a().iterator();
    int i = 0;
    while (localIterator1.hasNext())
      i += 2 + a((String)localIterator1.next()).length;
    int j = 2 + i;
    this.a.writeByte(a(localFixedHeader));
    a(j);
    int k = localMessageIdVariableHeader.a();
    this.a.writeShort(k);
    Iterator localIterator2 = localUnsubscribePayload.a().iterator();
    while (localIterator2.hasNext())
    {
      byte[] arrayOfByte = a((String)localIterator2.next());
      this.a.writeShort(arrayOfByte.length);
      this.a.write(arrayOfByte, 0, arrayOfByte.length);
    }
    this.a.flush();
  }

  private byte[] a(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("utf-8");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new RuntimeException(localUnsupportedEncodingException);
  }

  private int b(int paramInt)
  {
    int i = 0;
    do
    {
      paramInt /= 128;
      i++;
    }
    while (paramInt > 0);
    return i;
  }

  private void b(MqttMessage paramMqttMessage)
  {
    FixedHeader localFixedHeader = paramMqttMessage.f();
    this.a.writeByte(a(localFixedHeader));
    this.a.writeByte(0);
    this.a.flush();
  }

  public void a(MqttMessage paramMqttMessage)
  {
    monitorenter;
    try
    {
      switch (paramMqttMessage.e())
      {
      case 4:
      case 5:
      case 6:
      case 7:
      case 12:
      default:
        throw new IllegalArgumentException("Unknown message type: " + paramMqttMessage.e());
      case 2:
      case 8:
      case 9:
      case 10:
      case 11:
      case 3:
      case 13:
      case 1:
      }
    }
    finally
    {
      monitorexit;
    }
    a((ConnAckMqttMessage)paramMqttMessage);
    while (true)
    {
      monitorexit;
      return;
      a((SubscribeMqttMessage)paramMqttMessage);
      continue;
      a((SubAckMqttMessage)paramMqttMessage);
      continue;
      a((UnsubscribeMqttMessage)paramMqttMessage);
      continue;
      a((UnsubAckMqttMessage)paramMqttMessage);
      continue;
      a((PublishMqttMessage)paramMqttMessage);
      continue;
      b(paramMqttMessage);
      continue;
      a((ConnectMqttMessage)paramMqttMessage);
    }
  }

  public void a(DataOutputStream paramDataOutputStream)
  {
    this.a = paramDataOutputStream;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.serialization.MessageEncoder
 * JD-Core Version:    0.6.0
 */