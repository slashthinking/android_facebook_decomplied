package com.facebook.feed.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.facebook.feed.model.DataLoaderConfig;
import com.facebook.feed.util.FeedNetworkConnectivityReceiver;
import com.facebook.orca.net.OrcaNetworkManager;
import com.facebook.orca.server.DataFreshnessParam;

class AbstractDataLoader$5 extends FeedNetworkConnectivityReceiver
{
  public void a(Context paramContext, Intent paramIntent)
  {
    boolean bool = this.b.e.b();
    if (bool)
    {
      if (this.a.a() != 0)
        break label67;
      this.b.a(DataFreshnessParam.STALE_DATA_OKAY, this.b.g(), this.b.h.b());
    }
    while (true)
    {
      this.b.q.b(bool);
      return;
      label67: this.b.a();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.data.AbstractDataLoader.5
 * JD-Core Version:    0.6.0
 */