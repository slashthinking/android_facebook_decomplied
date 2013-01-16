package android_src.mms.util;

import android_src.mms.pdu.GenericPdu;

public final class PduCacheEntry
{
  private final GenericPdu a;
  private final int b;
  private final long c;

  public PduCacheEntry(GenericPdu paramGenericPdu, int paramInt, long paramLong)
  {
    this.a = paramGenericPdu;
    this.b = paramInt;
    this.c = paramLong;
  }

  public GenericPdu a()
  {
    return this.a;
  }

  public int b()
  {
    return this.b;
  }

  public long c()
  {
    return this.c;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.util.PduCacheEntry
 * JD-Core Version:    0.6.0
 */