package com.google.zxing.qrcode.encoder;

final class BlockPair
{
  private final byte[] a;
  private final byte[] b;

  BlockPair(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.a = paramArrayOfByte1;
    this.b = paramArrayOfByte2;
  }

  public byte[] a()
  {
    return this.a;
  }

  public byte[] b()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.encoder.BlockPair
 * JD-Core Version:    0.6.0
 */