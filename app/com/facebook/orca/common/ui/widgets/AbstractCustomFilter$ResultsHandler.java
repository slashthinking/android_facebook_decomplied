package com.facebook.orca.common.ui.widgets;

import android.os.Handler;
import android.os.Message;

class AbstractCustomFilter$ResultsHandler extends Handler
{
  private AbstractCustomFilter$ResultsHandler(AbstractCustomFilter paramAbstractCustomFilter)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    AbstractCustomFilter.RequestArguments localRequestArguments = (AbstractCustomFilter.RequestArguments)paramMessage.obj;
    this.a.a(localRequestArguments.a, localRequestArguments.c);
    int i;
    if (localRequestArguments.b != null)
    {
      if (localRequestArguments.c == null)
        break label116;
      i = localRequestArguments.c.b;
      localRequestArguments.b.a(i);
    }
    while (true)
    {
      synchronized (AbstractCustomFilter.b(this.a))
      {
        if (AbstractCustomFilter.c(this.a) != null)
        {
          if (AbstractCustomFilter.c(this.a).hasMessages(-791613427))
            continue;
          break label135;
          if (j == 0)
            continue;
          localRequestArguments.b.a(CustomFilter.FilteringState.FINISHED);
          return;
          label116: i = -1;
          break;
          j = 0;
        }
      }
      label135: int j = 1;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.AbstractCustomFilter.ResultsHandler
 * JD-Core Version:    0.6.0
 */