package com.facebook.katana.service.method;

import android.os.Handler;
import java.util.HashMap;

class PagesSearch$DeleteThread extends Thread
{
  private PagesSearch$DeleteThread(PagesSearch paramPagesSearch)
  {
  }

  public void run()
  {
    PagesSearch.a(this.a, new HashMap());
    PagesSearch.a(this.a).post(new PagesSearch.DeleteThread.1(this));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PagesSearch.DeleteThread
 * JD-Core Version:    0.6.0
 */