package com.facebook.device;

import com.facebook.common.util.TriState;

public class CpuCapabilities
{
  private static TriState a = TriState.UNSET;
  private static boolean b = false;

  static
  {
    try
    {
      System.loadLibrary("cpucapabilities");
      b = true;
      label19: return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      break label19;
    }
  }

  public static boolean a()
  {
    TriState localTriState;
    if ((b) && (a == TriState.UNSET))
    {
      if (nativeDeviceSupportsNeon())
      {
        localTriState = TriState.YES;
        a = localTriState;
      }
    }
    else
      if (a != TriState.YES)
        break label49;
    label49: for (boolean bool = true; ; bool = false)
    {
      return bool;
      localTriState = TriState.NO;
      break;
    }
  }

  private static native boolean nativeDeviceSupportsNeon();
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.device.CpuCapabilities
 * JD-Core Version:    0.6.2
 */