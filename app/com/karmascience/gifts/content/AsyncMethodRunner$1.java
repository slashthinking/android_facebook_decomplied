package com.karmascience.gifts.content;

import com.facebook.common.util.Log;
import com.facebook.orca.protocol.base.SingleMethodRunner;

class AsyncMethodRunner$1
  implements Runnable
{
  public void run()
  {
    try
    {
      AsyncMethodRunner.a(this.c).a(this.a, this.b);
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        Log.a(AsyncMethodRunner.a(), "Executing method failed", localException);
        this.a.a(0, localException.getMessage());
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.content.AsyncMethodRunner.1
 * JD-Core Version:    0.6.0
 */