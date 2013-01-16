package com.facebook.katana;

import com.facebook.katana.util.PlatformUtils;

class VersionTasks$1 extends Thread
{
  public void run()
  {
    if (VersionTasks.a(this.a).b())
      PlatformUtils.b(VersionTasks.b(this.a));
    VersionTasks.a(this.a).b(VersionTasks.b(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.VersionTasks.1
 * JD-Core Version:    0.6.0
 */