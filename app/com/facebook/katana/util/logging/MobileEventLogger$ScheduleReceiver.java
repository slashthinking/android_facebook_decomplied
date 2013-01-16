package com.facebook.katana.util.logging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class MobileEventLogger$ScheduleReceiver extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    MobileEventLogger.e(paramContext);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.logging.MobileEventLogger.ScheduleReceiver
 * JD-Core Version:    0.6.0
 */