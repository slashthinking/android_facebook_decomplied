package org.acra.util;

abstract class Base64$Coder
{
  public int op;
  public byte[] output;

  public abstract int maxOutputSize(int paramInt);

  public abstract boolean process(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.util.Base64.Coder
 * JD-Core Version:    0.6.0
 */