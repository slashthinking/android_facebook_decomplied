package com.facebook.background;

import com.facebook.orca.common.util.AndroidThreadUtil;
import java.util.concurrent.locks.ReentrantLock;

class BackgroundTaskRunner$ReentrantLockWithUiThreadCheck
{
  private final AndroidThreadUtil a;
  private final ReentrantLock b = new ReentrantLock();

  BackgroundTaskRunner$ReentrantLockWithUiThreadCheck(AndroidThreadUtil paramAndroidThreadUtil)
  {
    this.a = paramAndroidThreadUtil;
  }

  void a()
  {
    this.a.b();
    this.b.lock();
  }

  void b()
  {
    this.b.unlock();
  }

  boolean c()
  {
    return this.b.isHeldByCurrentThread();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.background.BackgroundTaskRunner.ReentrantLockWithUiThreadCheck
 * JD-Core Version:    0.6.0
 */