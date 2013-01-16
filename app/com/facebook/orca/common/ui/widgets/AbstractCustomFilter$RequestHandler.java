package com.facebook.orca.common.ui.widgets;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

class AbstractCustomFilter$RequestHandler extends Handler
{
  public AbstractCustomFilter$RequestHandler(AbstractCustomFilter paramAbstractCustomFilter, Looper paramLooper)
  {
    super(paramLooper);
  }

  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    switch (i)
    {
    default:
    case -791613427:
    case -559038737:
    }
    while (true)
    {
      return;
      AbstractCustomFilter.RequestArguments localRequestArguments = (AbstractCustomFilter.RequestArguments)paramMessage.obj;
      try
      {
        localRequestArguments.c = this.a.b(localRequestArguments.a);
        Message localMessage4 = AbstractCustomFilter.a(this.a).obtainMessage(i);
        localMessage4.obj = localRequestArguments;
        localMessage4.sendToTarget();
        synchronized (AbstractCustomFilter.b(this.a))
        {
          if (AbstractCustomFilter.c(this.a) != null)
          {
            Message localMessage3 = AbstractCustomFilter.c(this.a).obtainMessage(-559038737);
            AbstractCustomFilter.c(this.a).sendMessageDelayed(localMessage3, 3000L);
          }
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          localRequestArguments.c = new CustomFilter.FilterResults();
          Log.w("Filter", "An exception occured during performFiltering()!", localException);
          Message localMessage2 = AbstractCustomFilter.a(this.a).obtainMessage(i);
          localMessage2.obj = localRequestArguments;
          localMessage2.sendToTarget();
        }
      }
      finally
      {
        Message localMessage1 = AbstractCustomFilter.a(this.a).obtainMessage(i);
        localMessage1.obj = localRequestArguments;
        localMessage1.sendToTarget();
      }
      synchronized (AbstractCustomFilter.b(this.a))
      {
        if (AbstractCustomFilter.c(this.a) != null)
        {
          AbstractCustomFilter.c(this.a).getLooper().quit();
          AbstractCustomFilter.a(this.a, null);
        }
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.AbstractCustomFilter.RequestHandler
 * JD-Core Version:    0.6.0
 */