package com.facebook.dalvik;

import android.util.Log;
import java.io.IOException;

public class DalvikReplaceBuffer
{
  private static boolean a = false;
  private static String b = "";

  public static boolean a()
  {
    return a;
  }

  public static String b()
  {
    return b;
  }

  public static void c()
  {
    long l;
    try
    {
      l = DalvikInternals.a();
      if (l == 0L)
        throw new IOException("Failed to find LinearAllocHdr.");
    }
    catch (IOException localIOException)
    {
      a = true;
      b = localIOException.getMessage();
      Log.e("DalvikReplaceBuffer", "Failed to replace LinearAlloc buffer. Continuing with standard buffer.", localIOException);
    }
    while (true)
    {
      return;
      DalvikInternals.replaceLinearAllocBuffer(l, 8388608, 4096);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.dalvik.DalvikReplaceBuffer
 * JD-Core Version:    0.6.0
 */