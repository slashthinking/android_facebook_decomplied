package com.facebook.orca.common.ui.widgets;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

public abstract class AbstractCustomFilter
  implements CustomFilter
{
  private Handler a;
  private Handler b = new AbstractCustomFilter.ResultsHandler(this, null);
  private CustomFilter.Delayer c;
  private final Object d = new Object();

  public final void a(CharSequence paramCharSequence)
  {
    a(paramCharSequence, null);
  }

  public final void a(CharSequence paramCharSequence, CustomFilter.FilterListener paramFilterListener)
  {
    synchronized (this.d)
    {
      if (this.a == null)
      {
        HandlerThread localHandlerThread = new HandlerThread("Filter", 10);
        localHandlerThread.start();
        this.a = new AbstractCustomFilter.RequestHandler(this, localHandlerThread.getLooper());
      }
      if (this.c == null)
      {
        l = 0L;
        Message localMessage = this.a.obtainMessage(-791613427);
        AbstractCustomFilter.RequestArguments localRequestArguments = new AbstractCustomFilter.RequestArguments(null);
        String str = null;
        if (paramCharSequence != null)
          str = paramCharSequence.toString();
        localRequestArguments.a = str;
        localRequestArguments.b = paramFilterListener;
        if (paramFilterListener != null)
          paramFilterListener.a(CustomFilter.FilteringState.FILTERING);
        localMessage.obj = localRequestArguments;
        this.a.removeMessages(-791613427);
        this.a.removeMessages(-559038737);
        this.a.sendMessageDelayed(localMessage, l);
        return;
      }
      long l = this.c.a(paramCharSequence);
    }
  }

  protected abstract void a(CharSequence paramCharSequence, CustomFilter.FilterResults paramFilterResults);

  protected abstract CustomFilter.FilterResults b(CharSequence paramCharSequence);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.AbstractCustomFilter
 * JD-Core Version:    0.6.0
 */