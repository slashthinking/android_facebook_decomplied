package com.facebook.orca.contacts.divebar;

import com.facebook.app.UserActivityManager;
import com.facebook.background.AbstractBackgroundTask;
import com.facebook.background.BackgroundResult;
import com.facebook.orca.common.util.Clock;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

public class DivebarPreloadBackgroundTask extends AbstractBackgroundTask
{
  private final DivebarLoaderFactory a;
  private final UserActivityManager b;
  private final Clock c;
  private long d;

  public DivebarPreloadBackgroundTask(DivebarLoaderFactory paramDivebarLoaderFactory, UserActivityManager paramUserActivityManager, Clock paramClock)
  {
    super("DIVEBAR");
    this.a = paramDivebarLoaderFactory;
    this.b = paramUserActivityManager;
    this.c = paramClock;
  }

  public boolean b()
  {
    boolean bool1 = this.c.a() - this.d < 300000L;
    int i = 0;
    if (bool1);
    while (true)
    {
      return i;
      boolean bool2 = this.b.b();
      i = 0;
      if (!bool2)
        continue;
      i = 1;
    }
  }

  public ListenableFuture<BackgroundResult> c()
  {
    this.d = this.c.a();
    this.a.a().v();
    return Futures.a(new BackgroundResult(true));
  }

  public long h()
  {
    long l;
    if (this.b.b())
      l = Math.max(this.c.a(), 300000L + this.d);
    while (true)
    {
      return l;
      l = -1L;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.divebar.DivebarPreloadBackgroundTask
 * JD-Core Version:    0.6.0
 */