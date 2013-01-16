package com.facebook.orca.mqtt.serialization;

import com.facebook.orca.mqtt.messages.FixedHeader;
import com.google.common.base.Charsets;
import java.io.DataInputStream;
import java.nio.charset.Charset;

class MessageDecoder$BaseDecoder
{
  protected FixedHeader a;
  protected int b;

  MessageDecoder$BaseDecoder(FixedHeader paramFixedHeader, int paramInt)
  {
    this.a = paramFixedHeader;
    this.b = paramInt;
  }

  protected String a(DataInputStream paramDataInputStream)
  {
    int i = b(paramDataInputStream);
    byte[] arrayOfByte = new byte[i];
    paramDataInputStream.readFully(arrayOfByte);
    this.b -= i;
    return new String(arrayOfByte, Charsets.UTF_8.name());
  }

  protected int b(DataInputStream paramDataInputStream)
  {
    int i = paramDataInputStream.readUnsignedByte();
    int j = paramDataInputStream.readUnsignedByte();
    this.b = (-2 + this.b);
    return j | i << 8;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.serialization.MessageDecoder.BaseDecoder
 * JD-Core Version:    0.6.0
 */