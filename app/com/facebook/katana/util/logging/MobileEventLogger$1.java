package com.facebook.katana.util.logging;

import android.content.ContentResolver;
import com.facebook.katana.provider.MobileEventLogProvider;

class MobileEventLogger$1 extends Thread
{
  public void run()
  {
    this.a.delete(MobileEventLogProvider.a, null, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.logging.MobileEventLogger.1
 * JD-Core Version:    0.6.0
 */