package com.facebook.orca.background;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;

class FetchThreadsIntoMemoryCacheBackgroundTask$1 extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("threads");
    FetchThreadsIntoMemoryCacheBackgroundTask.a(this.a, localArrayList);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.background.FetchThreadsIntoMemoryCacheBackgroundTask.1
 * JD-Core Version:    0.6.0
 */