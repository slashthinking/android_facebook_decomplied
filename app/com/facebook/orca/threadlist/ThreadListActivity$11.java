package com.facebook.orca.threadlist;

import android.os.MessageQueue.IdleHandler;
import com.facebook.orca.common.ui.titlebar.DivebarController;

class ThreadListActivity$11
  implements MessageQueue.IdleHandler
{
  public boolean queueIdle()
  {
    if (ThreadListActivity.h(this.a))
      ThreadListActivity.e(this.a).j();
    return false;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.ThreadListActivity.11
 * JD-Core Version:    0.6.0
 */