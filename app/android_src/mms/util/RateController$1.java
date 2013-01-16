package android_src.mms.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class RateController$1 extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.android.mms.RATE_LIMIT_CONFIRMED".equals(paramIntent.getAction()))
      monitorenter;
    while (true)
    {
      try
      {
        RateController localRateController = this.a;
        if (!paramIntent.getBooleanExtra("answer", false))
          break label56;
        i = 1;
        RateController.a(localRateController, i);
        notifyAll();
        monitorexit;
      }
      finally
      {
        localObject = finally;
        monitorexit;
        throw localObject;
      }
      return;
      label56: int i = 2;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.util.RateController.1
 * JD-Core Version:    0.6.0
 */