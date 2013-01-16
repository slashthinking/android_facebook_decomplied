package com.facebook.feed.data;

import com.facebook.feed.model.DataLoaderConfig;
import com.facebook.orca.server.DataFreshnessParam;

class AbstractDataLoader$1
  implements Runnable
{
  public void run()
  {
    if (this.a.v)
      this.a.a(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, this.a.g(), this.a.h.b());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.data.AbstractDataLoader.1
 * JD-Core Version:    0.6.0
 */