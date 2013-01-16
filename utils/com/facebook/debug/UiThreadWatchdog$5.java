package com.facebook.debug;

class UiThreadWatchdog$5
  implements Runnable
{
  UiThreadWatchdog$5(UiThreadWatchdog paramUiThreadWatchdog)
  {
  }

  public void run()
  {
    UiThreadWatchdog.f(this.a);
    UiThreadWatchdog.g(this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.debug.UiThreadWatchdog.5
 * JD-Core Version:    0.6.2
 */