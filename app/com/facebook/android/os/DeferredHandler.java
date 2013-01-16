package com.facebook.android.os;

import android.os.Looper;
import android.os.MessageQueue;
import java.util.LinkedList;

public class DeferredHandler
{
  private LinkedList<Runnable> a = new LinkedList();
  private MessageQueue b = Looper.myQueue();
  private DeferredHandler.Impl c = new DeferredHandler.Impl(this, null);

  public void a()
  {
    synchronized (this.a)
    {
      this.a.clear();
      return;
    }
  }

  public void a(Runnable paramRunnable)
  {
    synchronized (this.a)
    {
      this.a.add(paramRunnable);
      if (this.a.size() == 1)
        b();
      return;
    }
  }

  void b()
  {
    if (this.a.size() > 0)
    {
      if (!((Runnable)this.a.getFirst() instanceof DeferredHandler.IdleRunnable))
        break label38;
      this.b.addIdleHandler(this.c);
    }
    while (true)
    {
      return;
      label38: this.c.sendEmptyMessage(1);
    }
  }

  public void b(Runnable paramRunnable)
  {
    a(new DeferredHandler.IdleRunnable(this, paramRunnable));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.android.os.DeferredHandler
 * JD-Core Version:    0.6.0
 */