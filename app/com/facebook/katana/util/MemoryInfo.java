package com.facebook.katana.util;

import android.os.Debug;
import com.facebook.orca.common.util.StringLocaleUtil;
import java.text.DecimalFormat;

public class MemoryInfo
{
  private static DecimalFormat g = new DecimalFormat("##0.0");
  public final long a;
  public final long b;
  public final long c;
  public final long d;
  public final long e;
  public final long f;

  public MemoryInfo()
  {
    Runtime localRuntime = Runtime.getRuntime();
    this.a = (localRuntime.totalMemory() - localRuntime.freeMemory());
    this.b = (localRuntime.maxMemory() - this.a);
    this.c = localRuntime.maxMemory();
    this.f = this.c;
    this.d = (Debug.getNativeHeapAllocatedSize() - Debug.getNativeHeapFreeSize());
    this.e = (this.f - this.d);
  }

  private static String a(long paramLong1, long paramLong2)
  {
    double d1 = 1.0D * paramLong1 / 1048576.0D;
    double d2 = 1.0D * paramLong2 / 1048576.0D;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = g.format(d1);
    arrayOfObject[1] = g.format(d2);
    arrayOfObject[2] = g.format(d2 * 100.0D / d1);
    return StringLocaleUtil.a("Max: %sM Used: %sM %s%%", arrayOfObject);
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = a(this.c, this.a);
    arrayOfObject[1] = a(this.f, this.d);
    return StringLocaleUtil.a("Memory: JAVA [%s]  NATIVE [%s]", arrayOfObject);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.MemoryInfo
 * JD-Core Version:    0.6.0
 */