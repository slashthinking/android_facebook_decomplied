package com.facebook.orca.app;

import com.facebook.orca.common.util.AndroidThreadUtil;
import com.google.common.util.concurrent.SettableFuture;

class FbAppInitializer$1
  implements Runnable
{
  public void run()
  {
    FbAppInitializer.a(this.b);
    this.a.a_(null);
    FbAppInitializer.c(this.b).b(new FbAppInitializer.1.1(this));
    FbAppInitializer.d(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbAppInitializer.1
 * JD-Core Version:    0.6.0
 */