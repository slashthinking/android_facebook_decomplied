package com.facebook.orca.common.util;

import android.os.HandlerThread;

class DefaultAndroidThreadUtil$1
  implements Runnable
{
  public void run()
  {
    try
    {
      this.a.run();
      return;
    }
    finally
    {
      this.b.quit();
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.DefaultAndroidThreadUtil.1
 * JD-Core Version:    0.6.0
 */