package com.facebook.katana.util;

import android.os.Looper;

public class ThreadUtils
{
  public static boolean a()
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread());
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.ThreadUtils
 * JD-Core Version:    0.6.0
 */