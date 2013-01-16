package com.facebook.feed.background;

import com.facebook.hardware.ScreenPowerState.PowerChangeListener;
import java.util.concurrent.ExecutorService;

class PrefetchNewsFeedBackgroundTask$1
  implements ScreenPowerState.PowerChangeListener
{
  public void a()
  {
    PrefetchNewsFeedBackgroundTask.b(this.a).submit(new PrefetchNewsFeedBackgroundTask.1.1(this));
  }

  public void b()
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.background.PrefetchNewsFeedBackgroundTask.1
 * JD-Core Version:    0.6.0
 */