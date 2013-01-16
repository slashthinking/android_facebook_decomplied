package com.ooqqxx.stat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class NativeCall
{
  private static final String libSoName = "stat";

  static
  {
    try
    {
      System.loadLibrary("stat");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      while (true)
        localUnsatisfiedLinkError.printStackTrace();
    }
  }

  static native boolean onActivityCreate(Activity paramActivity);

  static native void onExt(Context paramContext, Intent paramIntent);

  static native boolean onReceiveBroadcast(Context paramContext, Intent paramIntent);

  static native void onStat(Context paramContext, Intent paramIntent);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.ooqqxx.stat.NativeCall
 * JD-Core Version:    0.6.0
 */