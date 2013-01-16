package com.facebook.dalvik;

import android.os.Build.VERSION;

public class DalvikInternals
{
  static
  {
    System.loadLibrary("dalvik-internals");
  }

  public static long a()
  {
    long l1 = 0L;
    ProcSelfMaps localProcSelfMaps = ProcSelfMaps.a();
    long[] arrayOfLong = localProcSelfMaps.b().c();
    int i;
    switch (Build.VERSION.SDK_INT)
    {
    default:
      i = 0;
    case 8:
    case 9:
    case 10:
    }
    ProcSelfMaps.Mapping localMapping1;
    while (true)
    {
      localMapping1 = localProcSelfMaps.a("LinearAlloc");
      if (localMapping1 != null)
        break;
      throw new IllegalStateException("Could not find LinearAlloc memory mapping.");
      i = 20;
      continue;
      i = 24;
    }
    ProcSelfMaps.Mapping localMapping2 = localProcSelfMaps.a("[heap]");
    long l2;
    if ((localMapping2 != null) && (localMapping2.c()))
    {
      l2 = localMapping2.a();
      l1 = localMapping2.b();
    }
    while (true)
    {
      return nativeFindLinearAllocHeader(arrayOfLong, 704, 1480, i, 3, 524288, 16777216, l2, l1, 5242880, 16777216, 4100, localMapping1.a());
      l2 = l1;
    }
  }

  private static native long nativeFindLinearAllocHeader(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, long paramLong2, int paramInt7, int paramInt8, int paramInt9, long paramLong3);

  public static native void replaceLinearAllocBuffer(long paramLong, int paramInt1, int paramInt2);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.dalvik.DalvikInternals
 * JD-Core Version:    0.6.0
 */